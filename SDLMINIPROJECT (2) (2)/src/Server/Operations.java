/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import ClientServer.ClientServer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.HashMap.*;
/**
 *
 * @author megha
 */
public class Operations {
    
    public int subjectId;
    //public static int subjectId;
    //ArrayList<ClientServer>QuestionList=new ArrayList<ClientServer>();
    //ArrayList<ClientServer>AnswerList=new ArrayList<ClientServer>();
    //int index=0;
    int studentId=0;
    //ArrayList<ClientServer>ResultList=new ArrayList<ClientServer>();
    ArrayList<ClientServer>SubjectiveQuestion=new ArrayList<ClientServer>();
    // ArrayList<ClientServer>DisplayList=new ArrayList<ClientServer>();
    public int studentLogin(ClientServer student)
    {
        int flag=0;
        try 
		{
                        Connection con=DatabaseConnectivity.getConnection();
			PreparedStatement ps=con.prepareStatement("SELECT * FROM Student WHERE examId=? AND studentPassword=MD5(?)");
			ps.setInt(1, student.loginId);
			ps.setString(2, student.loginPassword);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
                        {
                            flag=1;
                        }
			DatabaseConnectivity.closeConnection();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
       
        return flag;
    }
    
    public int teacherLogin(ClientServer teacher)
    {
        int flag=0;
        try 
		{
                        Connection con=DatabaseConnectivity.getConnection();
			PreparedStatement ps=con.prepareStatement("SELECT * FROM Teacher WHERE teacherId=? AND teacherPassword=MD5(?)");
			ps.setInt(1, teacher.loginId);
			ps.setString(2, teacher.loginPassword);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
                        {
                            flag=1;
                        }
			DatabaseConnectivity.closeConnection();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
        return flag;
    }
    
    public void findSubject(String startTest)
    {
        try
        {
            Connection con=DatabaseConnectivity.getConnection();
	    PreparedStatement ps=con.prepareStatement("SELECT * FROM Subject WHERE subjectName=?");
			ps.setString(1, startTest);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
                        {
                            subjectId=rs.getInt("subjectId");
                            //Operations.subjectId=rs.getInt("subjectId");
                        }
                        
			DatabaseConnectivity.closeConnection();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
    }
    public ArrayList<ClientServer> getQuestionId(){
      
         ArrayList<ClientServer>QuestionList=new ArrayList<ClientServer>();
        ClientServer Question;
        String QuestionContents=null;
        int qid=0;
        int OptionId1=0,OptionId2=0,OptionId3=0,OptionId4=0;
        String Option1=null;
        String Option2=null;
        String Option3=null;
        String Option4=null;
        try
        {    
            Connection con=DatabaseConnectivity.getConnection();
	    PreparedStatement ps=con.prepareStatement("SELECT * FROM Question WHERE subjectId=? ORDER BY rand() LIMIT 15;");
                       // ps.setInt(1,Operations.subjectId);
			ps.setInt(1,subjectId);
                       ResultSet rs=ps.executeQuery();
			int QuestionNo=0;
                        while(rs.next())
                        {
                        qid=rs.getInt("qId");
                        QuestionContents= rs.getString("question");
                        PreparedStatement ps1=con.prepareStatement("SELECT * FROM QuestionChoices WHERE qId=? AND SubjectId=?");
			ps1.setInt(1, qid);
                       // ps1.setInt(2,Operations.subjectId);
			ps1.setInt(2,subjectId);
                       ResultSet rs1=ps1.executeQuery();
                        int i=1;
                        while(rs1.next())
                        {
                            int ChoiceId=rs1.getInt("choiceId");
                            String ChoiceContents= rs1.getString("choice");
                            if(i==1)
                            {
                               OptionId1=ChoiceId;
                               Option1=ChoiceContents;
                            }
                            else if(i==2)
                            {
                                OptionId2=ChoiceId;
                                Option2=ChoiceContents;
                            }
                            else if(i==3)
                            {
                                OptionId3=ChoiceId;
                                Option3=ChoiceContents;
                            }
                            else
                            {
                                OptionId4=ChoiceId;
                                Option4=ChoiceContents;
                            }
                            i++;
                        }
                        QuestionNo++;
                        ClientServer obj=new ClientServer(QuestionNo, qid, QuestionContents, Option1, Option2, Option3, Option4, OptionId1, OptionId2, OptionId3, OptionId4);
                        QuestionList.add(obj);
                        
                        }
                        
                        
           /* Iterator<ClientServer>itr=QuestionList.iterator();
            while(itr.hasNext()){
                ClientServer obj=itr.next();
                System.out.println(obj.QuestionNo);
                System.out.println(obj.qid);
                System.out.println(obj.QuestionContents);              
            }*/
                        
            /*PreparedStatement ps1=con.prepareStatement("SELECT * FROM QuestionChoices WHERE qId=? AND SubjectId=?");
			ps1.setInt(1, qid);
                        ps1.setInt(2,subjectId);
			ResultSet rs1=ps1.executeQuery();
                        int i=1;
                        while(rs1.next())
                        {
                            int ChoiceId=rs1.getInt("choiceId");
                            String ChoiceContents= rs1.getString("choice");
                            if(i==1)
                            {
                                OptionId1=ChoiceId;
                                Option1=ChoiceContents;
                            }
                            else if(i==2)
                            {
                                OptionId2=ChoiceId;
                                Option2=ChoiceContents;
                            }
                            else if(i==3)
                            {
                                OptionId3=ChoiceId;
                                Option3=ChoiceContents;
                            }
                            else
                            {
                                OptionId4=ChoiceId;
                                Option4=ChoiceContents;
                                break;
                            }
                            i++;
                        }*/
                        
                        
			DatabaseConnectivity.closeConnection();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
        
        //Question=new ClientServer(QuestionNo,qid, QuestionContents, Option1, Option2, Option3, Option4, OptionId1,OptionId2,OptionId3,OptionId4);
        return QuestionList;
    }
    

    public ArrayList<ClientServer> getSubjectiveQuestionId(){
        ClientServer Question;
        String QuestionContents=null;
        int qid=0;
       // ArrayList<ClientServer>SubjectiveQuestion=new ArrayList<ClientServer>();
        try
        {    
            Connection con=DatabaseConnectivity.getConnection();
	    PreparedStatement ps=con.prepareStatement("SELECT * FROM Question WHERE subjectId=? ORDER BY rand() LIMIT 10;");
                        //ps.setInt(1,Operations.subjectId);
                        ps.setInt(1,subjectId);
			ResultSet rs=ps.executeQuery();
			int QuestionNo=0;
                        while(rs.next())
                        {
                        QuestionNo++;
                        qid=rs.getInt("qId");
                        QuestionContents= rs.getString("question");
                        ClientServer obj=new ClientServer(QuestionNo, QuestionContents,"Question"+QuestionNo);
                        SubjectiveQuestion.add(obj);
                          
                        }
			DatabaseConnectivity.closeConnection();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
        
        //Question=new ClientServer(QuestionNo,qid, QuestionContents, Option1, Option2, Option3, Option4, OptionId1,OptionId2,OptionId3,OptionId4);
        return SubjectiveQuestion;
    }
    
    
    public void getQuestionList(){
        int QuestionArray[]=new int[10];
        int i=0;
        while(i<=10){
            ClientServer obj=null;
        }
    }
    
    public void storeResult(HashMap<Integer, ClientServer> resultList,int studentId1,ArrayList QuestionList) throws SQLException, InstantiationException
    {
        ClientServer obj2;
        int choiceId=0;
        int isRight=0;
        int rowsinserted;
         int index=0;
        
        try
        {
            Connection con=DatabaseConnectivity.getConnection();
            Iterator<ClientServer>itr=QuestionList.iterator();
            while(itr.hasNext())
            {
              ClientServer obj3;
              obj3= (ClientServer) QuestionList.get(index);
              ClientServer obj=itr.next();
              obj2=resultList.get(obj3.QuestionNo);
              
              if(obj2.isAnswered==1) 
              {
               if(obj2.UserOption==1)
                choiceId=obj.OptionId1;
               else if(obj2.UserOption==2)
                choiceId=obj.OptionId2;
               else if(obj2.UserOption==3)
                choiceId=obj.OptionId3;
               else
                choiceId=obj.OptionId4;
              }
               
              PreparedStatement ps1=con.prepareStatement("SELECT * FROM QuestionChoices WHERE choiceId=?");
	      ps1.setInt(1,choiceId);
              ResultSet rs1=ps1.executeQuery();
              while(rs1.next())
              {
                 isRight=rs1.getInt("isRightChoice");
              }
                
               PreparedStatement ps=con.prepareStatement("INSERT INTO UserQuestionAnswer VALUES(?,?,?,?,?);");
               ps.setInt(1,studentId1);
               //ps.setInt(2,Operations.subjectId); 
               ps.setInt(2,subjectId); 
               ps.setInt(3,obj.qid);
               ps.setInt(4,choiceId);
               ps.setInt(5, isRight);
               rowsinserted=ps.executeUpdate();
               // System.out.println("Server.Operations.storeResult()");
                //System.out.println(subjectId+"  "+obj.qid+"  "+choiceId+"  "+choiceId+"  "+isRight);
               index++;
            }
            studentId=studentId1;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public ArrayList<ClientServer> getResult() throws SQLException, InstantiationException
  {
       ArrayList<ClientServer>ResultList=new ArrayList<ClientServer>();
       int choice=0;
       int queId=0;
       int isRight=0;
       int QuestionNo1;
       int correctAnswer=0;
       int isCorrect;
        int[] QuestionId=new int[11];
      try
      {
       
          
      Connection con=DatabaseConnectivity.getConnection();
      PreparedStatement ps=con.prepareStatement("SELECT * FROM UserQuestionAnswer WHERE examId=? AND subjectId=?");
      ps.setInt(1,studentId);
      ps.setInt(2,subjectId);
      ResultSet rs=ps.executeQuery();
      QuestionNo1=0;
      while(rs.next())
      {
        
          choice=rs.getInt("choiceId");
          queId=rs.getInt("qId");
          isRight=rs.getInt("isRight");
          
           PreparedStatement ps1=con.prepareStatement("SELECT * FROM QuestionChoices WHERE subjectId=? AND qId=?");
           ps1.setInt(1,subjectId);
           ps1.setInt(2,queId);
           ResultSet rs1=ps1.executeQuery();
          int i=1;
           while(rs1.next())
           {
               isCorrect=rs1.getInt("isRightChoice");
              
             if(isCorrect==1)
             {
                 correctAnswer=i;
             }
             else
             {
                 i++;
             }
           }

          QuestionNo1++;
         
          ClientServer obj=new ClientServer(QuestionNo1,choice,correctAnswer,isRight);
          ResultList.add(obj);
      }
      }
      catch(Exception e)
      {
          e.printStackTrace();
      }
      return ResultList;
  }
    
    public void storeMarks(int marks,int examId){
       try
       {
      Connection con=DatabaseConnectivity.getConnection();
      PreparedStatement ps=con.prepareStatement("INSERT INTO Result(examId,subjectId,marks,examDate) VALUES(?,?,?,CURDATE())");
      ps.setInt(1,examId);
      ps.setInt(2,subjectId);
      ps.setInt(3, marks);
      ps.executeUpdate();
      }
      catch(Exception e)
      {
          e.printStackTrace();
      } 
    }
    
    public void storeSubjectiveAnswer(HashMap<Integer, ClientServer> answerList,int studentId) throws SQLException, InstantiationException, IllegalAccessException
    {
        Connection con=DatabaseConnectivity.getConnection();
        for(int i=1; i<=10; i++)
        {
            ClientServer obj=answerList.get(i);
            ClientServer obj1=SubjectiveQuestion.get(i-1);
          
            PreparedStatement ps1=con.prepareStatement("SELECT qId FROM Question WHERE question=?");
            ps1.setString(1,obj1.QuestionContents);
            ResultSet rs=ps1.executeQuery();
            if(rs.next()){
            PreparedStatement ps=con.prepareStatement("INSERT INTO SubjectiveAnswer VALUES(?,?,?,?)");
            ps.setInt(1,studentId);
            ps.setInt(2,rs.getInt("qId"));
            ps.setString(3, obj.Answer);
            ps.setInt(4, obj.Marks);
            ps.executeUpdate();
            }
            
        }
    }
    
    public ClientServer checkTestGivenByStudent(int studentId) throws SQLException, InstantiationException, IllegalAccessException{
        int flag1=0;
        int flag2=0;
        int flag3=0;
        Connection con=DatabaseConnectivity.getConnection();
        PreparedStatement ps1=con.prepareStatement("SELECT * FROM Result WHERE examId=? AND subjectId=?");
        ps1.setInt(1,studentId);
        ps1.setInt(2,101);
        ResultSet rs1=ps1.executeQuery();
        if(rs1.next()){
            flag1=1;
        }
        
        
        PreparedStatement ps2=con.prepareStatement("SELECT * FROM Result WHERE examId=? AND subjectId=?");
        ps2.setInt(1,studentId);
        ps2.setInt(2,202);
        ResultSet rs2=ps2.executeQuery();
        if(rs2.next()){
            flag2=1;
        }
        
        PreparedStatement ps3=con.prepareStatement("SELECT * FROM Result WHERE examId=? AND subjectId=?");
        ps3.setInt(1,studentId);
        ps3.setInt(2,303);
        ResultSet rs3=ps3.executeQuery();
        if(rs3.next()){
            flag3=1;
        }
      
        ClientServer obj=new ClientServer(flag1,flag2,flag3,"checking for attempted tests.");
        return obj;
    }
    
    public void clearTableEntries() throws SQLException, InstantiationException, IllegalAccessException{
        Connection con=DatabaseConnectivity.getConnection();
        PreparedStatement ps=con.prepareStatement("TRUNCATE TABLE UserQuestionAnswer");
        int rs=ps.executeUpdate();
    }

     public ArrayList<ClientServer> teacherGetMarks() throws SQLException, InstantiationException, IllegalAccessException
        {
          
           int temp=0;
           ArrayList<ClientServer>DisplayList=new ArrayList<ClientServer>();
           Connection con=DatabaseConnectivity.getConnection();
           PreparedStatement ps=con.prepareStatement("SELECT DISTINCT examId FROM Result ORDER BY examId");
           ResultSet rs=ps.executeQuery();
           while(rs.next())
           {
               int examId=0;
               int marks_quantitative=0;
               int marks_logical=0;
               int marks_personality=0;
           
               examId=rs.getInt("examId");
              
               PreparedStatement ps1=con.prepareStatement("SELECT Marks,subjectId FROM Result WHERE examId=?");
               ps1.setInt(1,examId);
               ResultSet rs1=ps1.executeQuery();
               while(rs1.next())
               {
                   int subjectTemp=rs1.getInt("subjectId");
                   if(subjectTemp==101)
                       marks_quantitative=rs1.getInt("Marks");
                   else if(subjectTemp==202)
                       marks_logical=rs1.getInt("Marks");
                   else
                       marks_personality=rs1.getInt("Marks");
               }  
             
               ClientServer obj=new ClientServer(examId,marks_quantitative,marks_logical,marks_personality,temp);
               DisplayList.add(obj);
               }
           Iterator<ClientServer>itr=DisplayList.iterator();
           while(itr.hasNext())
           {
             ClientServer obj=itr.next();
              
           }
           return DisplayList;
            
        }
     
     public ClientServer GetDataForChart(String subjectName) throws SQLException, InstantiationException, IllegalAccessException{
           ClientServer data=null;
           Connection con=DatabaseConnectivity.getConnection();
           PreparedStatement ps=con.prepareStatement("SELECT subjectId FROM Subject WHERE subjectName=?");
           ps.setString(1, subjectName);
           ResultSet rs=ps.executeQuery();
           if(rs.next())
           {
               int subjectId=rs.getInt("subjectId");
              PreparedStatement ps1=con.prepareStatement("SELECT min(marks),avg(marks),max(marks) FROM Result WHERE subjectId=?");
              ps1.setInt(1, subjectId);
              ResultSet rs1=ps1.executeQuery();
               if(rs1.next())
               {
                data=new ClientServer(rs1.getFloat(1),rs1.getFloat(2),rs1.getFloat(3));
               }  
           }
           return data;
     }
     
     public String getStudentName(int sId) throws SQLException, InstantiationException, IllegalAccessException{
         
         Connection con=DatabaseConnectivity.getConnection();
           PreparedStatement ps=con.prepareStatement("SELECT studentName FROM Student WHERE examId=?");
           ps.setInt(1,sId);
           ResultSet rs=ps.executeQuery();
           String StudentName=null;
           if(rs.next())
           {
               StudentName=rs.getString("studentName");
           }
           return StudentName;
     }
}

