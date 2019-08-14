/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientServer;

import java.io.Serializable;

/**
 *
 * @author megha
 */
public class ClientServer implements Serializable {
    public int loginId;
    public String loginPassword=null;
    
    public int QuestionNo;
    public int qid;
    public String QuestionContents=null;
    public String Option1=null;
    public String Option2=null;
    public String Option3=null;
    public String Option4=null;
    public int OptionId1;
    public int OptionId2;
    public int OptionId3;
    public int OptionId4;
    public int isAnswered=0;
    public int UserOption;
    
    public int min=0;
    public int sec=0;
    
    public String Token=null;
    public int TokenCount=0;
        
    public int QuestionNo1;
    public int choice;
    public int correctAnswer;
    public int isRight;    
    
    public String Answer;
    public int Marks;
    
    public int isSubject1;
    public int isSubject2;
    public int isSubject3;
    
    public int examId;
    public int marks_quantitative;
    public int marks_logical;
    public int marks_personality;
    public int temp;
    
    public float avg;
    public float maximum;
    public float minimum; 
    public ClientServer(int loginId,String loginPassword) {
        //constructor to store login information of user
        this.loginId=loginId;
        this.loginPassword=loginPassword;
    }
   
    public ClientServer(int QuestionNo,int qid,String QuestionContents,String Option1,String Option2,String Option3,String Option4,int OptionId1,int OptionId2,int OptionId3,int OptionId4)
    {
        //constructor to store objective question format
        this.QuestionNo=QuestionNo;
        this.qid=qid;
        this.QuestionContents=QuestionContents;
        this.Option1=Option1;
        this.Option2=Option2;
        this.Option3=Option3;
        this.Option4=Option4;
        this.OptionId1=OptionId1;
        this.OptionId2=OptionId2;
        this.OptionId3=OptionId3;
        this.OptionId4=OptionId4;
    }
    
    public ClientServer(int QuestionNo,int isAnswered,int UserAnswer)
    {
        //constructor to store list of questions answered by user
        this.QuestionNo=QuestionNo;
        this.isAnswered=isAnswered;
        this.UserOption=UserAnswer;
    }
    
    public ClientServer(int min,int sec){
        this.min=min;
        this.sec=sec;
    }
    
    public ClientServer(String Token,int TokenCount){
        this.Token=Token;
        this.TokenCount=TokenCount;
    }
    public ClientServer(int QuestionNo1,int choice,int correctAnswer,int isRight)
    {
        this.QuestionNo1=QuestionNo1;
        this.choice=choice;
        this.correctAnswer=correctAnswer;
        this.isRight=isRight;
    }
    
   public ClientServer(int QuestionNo,String QuestionContents,String temp){
       this.QuestionNo=QuestionNo;
       this.QuestionContents=QuestionContents;
   } 
   
   public ClientServer(int marks,String Answer,int Answered){
       this.Marks=marks;
       this.Answer=Answer;
       this.isAnswered=Answered;
   }
   
   public ClientServer(int isSubject1,int isSubject2,int isSubject3,String temp){
       this.isSubject1=isSubject1;
       this.isSubject2=isSubject2;
       this.isSubject3=isSubject3;
   }
   public ClientServer(int examId,int marks_quantitative,int marks_logical,int marks_personality,int temp)
   {
       this.examId=examId;
       this.marks_quantitative=marks_quantitative;
       this.marks_logical=marks_logical;
       this.marks_personality=marks_personality;
   }
   
   public  ClientServer(float Minimum,float avg,float  Maximum){
       this.maximum=Maximum;
       this.avg=avg;
       this.minimum=Minimum;
   }
       
}
