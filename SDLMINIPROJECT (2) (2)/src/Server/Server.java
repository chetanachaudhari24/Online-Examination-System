package Server;

import ClientServer.ClientServer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server 
{	
	ServerSocket ss=null;
	Socket cs=null;
	Operations op=null;
	ExecutorService pool=null;
	int port;

	public Server(int port)
	{
		this.port=port;
		op=new Operations();
	    pool=Executors.newFixedThreadPool(10);
	}
	
	public void startServer()
	{
		try
		{
			ss=new ServerSocket(6000);
			while(true)
			{
				System.out.println("Server waiting for client:");
				cs=ss.accept();
				System.out.println("Got one client. Creating a thread for this client:");
				ServerThreadBody runnable=new ServerThreadBody(cs,op,this);
				pool.execute(runnable);
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) 
	{
		new Server(6000).startServer();
	}
}

class ServerThreadBody implements Runnable 
{
	Server server=null;
	Socket cs=null;
	DataInputStream din=null;
	DataOutputStream dout=null;
	ObjectInputStream oin=null;
	ObjectOutputStream oout=null;
	Operations op=null;
			
	public ServerThreadBody(Socket cs, Operations op, Server server)
	{
		this.cs=cs;
		this.op=op;
		this.server=server;
	}
	
	public void run()
	{
		String request;
                String requestForqId;
                String requestForOption;
                String requestForResult;
                int studentId;
                HashMap<Integer, ClientServer> resultList;
                ArrayList<ClientServer>QuestionList;
                ArrayList<ClientServer>SubjectiveQuestionList;
                ArrayList<ClientServer>ResultList;
                ArrayList<ClientServer>DisplayList;
		try
		{
			din=new DataInputStream(cs.getInputStream());
			dout=new DataOutputStream(cs.getOutputStream());
			oin=new ObjectInputStream(cs.getInputStream());
			oout=new ObjectOutputStream(cs.getOutputStream());
			
			while(true)
			{
                                
				request=din.readUTF();
				if(request.equals("StudentLogin"))
				{
					ClientServer student=(ClientServer)oin.readObject();
					int flag=op.studentLogin(student);
                                        dout.writeInt(flag);
                                        
                                        studentId=din.readInt();
                                        ClientServer check=op.checkTestGivenByStudent(studentId);
                                        oout.writeObject(check);
                                        
                                        studentId=din.readInt();
                                        //ClientServer check=op.checkTestGivenByStudent(studentId);
                                        //oout.writeObject(check);
                                        String startTest=din.readUTF();
                                        
                                        op.findSubject(startTest);
                                        //ClientServer check=op.checkTestGivenByStudent(studentId);
                                        //oout.writeObject(check);
                                     
                                        dout.writeUTF(startTest);
                                        requestForqId=din.readUTF();
                                        if(requestForqId.equals("Getting QuestionId for objective test"))
                                        {
                                        QuestionList=op.getQuestionId();
                                        oout.writeObject(QuestionList);
                                        
                                        resultList=(HashMap<Integer, ClientServer>) oin.readObject();
                                        studentId=din.readInt();
                                        
                                        op.storeResult(resultList,studentId,QuestionList);
                                            
                                        ResultList=op.getResult();
                                        oout.writeObject(ResultList);
                                 
                                        String studentName=op.getStudentName(studentId);
                                        dout.writeUTF(startTest);
                                        dout.writeUTF(studentName);
                                        int marks=din.readInt();
                                        op.storeMarks(marks,studentId);
                                        //op.clearTableEntries();
                                        }
                                       
                                        if(requestForqId.equals("Getting QuestionId for subjective test"))
                                        {
                                           
                                        SubjectiveQuestionList=op.getSubjectiveQuestionId();
                                       
                                        oout.writeObject(SubjectiveQuestionList);
                                            
                                        HashMap<Integer, ClientServer> answerList = (HashMap<Integer, ClientServer>) oin.readObject();
                                           
                                        studentId=din.readInt();
                                        op.storeSubjectiveAnswer(answerList,studentId);
                                        
                                         String studentName=op.getStudentName(studentId);
                                         dout.writeUTF(studentName);
                                        
                                        int marks=din.readInt();
                                        op.storeMarks(marks,studentId);
                                        /*resultList=(HashMap<Integer, ClientServer>) oin.readObject();
                                        studentId=din.readInt();
                                        op.storeResult(resultList,studentId);
                                            
                                        ResultList=op.getResult();
                                        oout.writeObject(ResultList);
                                 
                                        int marks=din.readInt();
                                        op.storeMarks(marks);*/
                                        }
                                       
                                        
				}
                                else if(request.equals("TeacherLogin"))
				{
					ClientServer teacher=(ClientServer)oin.readObject();
					int flag=op.teacherLogin(teacher);
                                        dout.writeInt(flag);
                                        
                                        DisplayList=op.teacherGetMarks();
                                        oout.writeObject(DisplayList);
                                        
                                        String requestForGraph;
                                        
                                       
                                        while(true)
                                        {
                                            requestForGraph=din.readUTF();
                                            if(requestForGraph.equals("Displaying Graph"))
                                            {
                                            String subjectName=din.readUTF();
                                            ClientServer obj=op.GetDataForChart(subjectName);
                                            oout.writeObject(obj);
                                            }
                                        }
                                        
				}
                                
				
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}