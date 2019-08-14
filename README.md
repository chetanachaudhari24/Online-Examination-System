









Online Examination System

Aditi Ambadkar (302004)
Chetana Chaudhari (302010)
Megha Ghadage (302017)


Software Requirements Specification
Document
















Version: 1	              Date: 15/10/2018

Table of Contents

1.  Introduction	3
1.1  Purpose	3
1.2  Scope	3
1.3  Definitions, Acronyms, and Abbreviations	4
1.4  References	4
1.5  Overview	5
2.  The Overall Description	
2.1  System Environment and Architecture	6
2.2 Functional Requirements Specification	
2.1.1 Student Use-Case	7
2.1.2 Teacher Use-Case	7
2.3  User Characteristics	7
2.3  Non-Functional Requirements	8
3.  Specific Requirements	9
3.1  External Interface Requirments	9
3.2  Detailed Functional Requirements	9
3.3 Detailed Non-Functional Requirements Specification	10
3.3.1 Logical Structure of Data	10



1.0  Introduction  

The purpose of this project is to provide a detailed description of the Online Examination System. It will explain the purpose and the features of the system, the various interfaces of the system and the functionalities of the system.
1.1  Purpose  

The principal motive of this project is to provide a system which can be used by schools, colleges and universities to ease the procedure of taking examinations for students. Educational institutes can make use of this application to conduct tests in a hassle-free, simple and a systematic manner. The various subject teachers can keep a record of the marks scored by each student, review the same for the performance of the class as well as maintain and manage the test scores for various academic purposes.
1.2  Scope 

    • This Online Examination System is designed for students and teachers at school, college or at university level; both having different purposes and functionalities
    • The Student: A student is expected to login to the system using his or her crendentials. After logging in, a subject whose test is to be taken is selected and the corresponding test will begin. Various options such as “Next” (to proceed to the next question), “Previous” (to come back to the previous question), “Review” (to view the answers selected for each question) and “Submit Test” (to submit the test) are provided. The marks obtained by the student will be displayed after submitting the test.
    • The Teacher: A teacher is suppose to login to the system using his or her login details. The teacher can view the marks of students in each subject, an overall analysis of marks subject wise and preserve a record that can be used in the future. 
    • Thus, a single system can be used to conduct the tests and maintain the records, which are ready for referral anytime thus, simple to use and efficient to manage. 
1.3  Definitions, Acronyms, and Abbreviations

Term
Description
Student
Person taking the test
Teacher
Person viewing the test results
Test
Comprising of questions and answer options 
Result
A record of student details and marks obtained in various subjects
  
1.4  References  

IEEE, IEEE Std 830-1998 IEEE Recommended Practice for Software Requirements Specification. IEEE Computer Society, 1998.

1.5  Overview  

The next chapter, the Overall Description section,  of this document gives an overview of the functionality of the application. It describes the informal requirements and is used to establish a context for the technical requirments specification  in the next chapter.
The third chapter, Requirements Specification section of this document is written mainly for the developers and defines in technical terms the specifications of the functionality of the system.
Both parts of the document describe the same software system in its entirety, but are proposed for different audiences and thus use different language.
















2.0  The Overall Description  
2.1  System Environment and Architecture  

The Online Examination System has two main actors- the student and the teacher. The student selects a test for a subject and is expected to answer a number of questions (objective or subjective type). The teacher can view the student details and marks obtained by them in different subjects. This data can be used by the teacher for future reference.



Fig. System Architecture



2.2  Functional Requirement Specification  

This section highlights the use case for each of the user i.e. student and the teacher separately. The student and the teachers have different logins and credential types as well as different functionalities.



Fig. Use-Case Diagram

2.2.1 Student Use Case

Use case: Take a test
Brief Desciption
The student will login to the system, select a subject and start the test.

Initial Step-By-Step Description
Before this use case can be initiated, the student has to login via the Student Login option by entering his or her allotted Exam ID and password. The required subject is to be selected from the drop down menu and the “Start Test” option is to be clicked.

    (i) Objective Type Test:
    1. A question along with four answer options will be displayed on the screen.
    2. The student is supposed to select an answer option by clicking the corresponding radio button. 
    3. The system will store the corresponding answer.
    4. The next question and the corresponding answer options can be displayed by clicking on the “Next” button.
    5. To go back to the previous question, the “Previous” button can be clicked.
    6. The “Review” button can be used to display the question number and the corresponding answer selected by the student.
    7. The “Submit Test” button is used to submit and end the test. The result will be displayed thereafter.
    8. A timer will be rolling, indicating the time remaining for the test to end.

    (ii) Subjective Type Test:
      1.   A question will be displayed whose answer is to be typed in the given text area.
      2.   The next question can be displayed by clicking on the “Next” button.
      3.   To go back to the previous question, the “Previous” button can be clicked.
      4.   The “Submit Test” button is used to submit and end the test. The result will be flashed. 

2.2.2 Teacher Use Case

Use case: View results
Brief Desciption
The teacher will login to the system, view the marks obtained by students in each subject.

Initial Step-By-Step Description
Before this use case can be initiated, the teacher has to login via the Teacher Login option by entering his or her allotted Teacher ID and password.

    1. The teacher can select the “Detailed Result” tab to view the marks obtained by each student in every subject.
    2. The teacher can select the “Overall Analysis” tab and then select a subject from the drop-down list and view a graph showing the minimum, average and maximum marks obtained by the students in that subject.

2.3 User Characteristics  

The Online Examination System has a very simple and a user friendly interface. The main screen has two types of login options- Student Login and Teacher Login. The user must identify themselves as one of the two and choose the appropriate login. Additonal instructions are provided to the user whenever necessary. The user should be able to use drop-down menus, buttons and similar tools.

2.4 Non-Functional Requirements  

The Online Examination System server can be run on one particular machine in a computer lab with online network administrator access. The students can login using the other available machines.
The number of students who can take a test on the system at a time shall be decided by the institution.
Various validations and verifications are implemented to prevent exceptions.
The application can be run on Ubuntu or Windows OS. 


































3.0  Requirements Specification
 3.1 External Interface Requirements

Only registered students and teachers can gain access to the Online Examination System. The registration of users i.e. students and teachers is done by the concerned database administrator.
The users are required to use the Login ID (Student- Exam ID and Teacher- Teacher ID) and password provided by the system administrator to login to the system. 
The credentials entered are verified from the database and then only access is granted.
The Online Examination System database maintains information about both the students (Exam ID and Name) and teachers (Teacher ID and Name).

3.2 Detailed Functional Requirements
    i. The Student:
    • Student Login: A student is required to login to the system using his or her Student Id (unique and numeric) and Password.
    • Subject Selection: The student has to select a subject from the drop-down list and read the instructions carefully before beginning the test.
    • Objective Type Test: If the subject selected is either Quantitative Aptitude or Logical Ability then answer is to be selected by clicking on the corresponding radio button. To go back to the previous question, the “Previous” button is to be clicked. To go the next question, the “Next” button is to be clicked. The answers marked can be checked using the “Review” button. The test can be submitted by clicking on the “Submit Test” button or automatically after the time is up.
    • Subjective Type Test: If the subject selected is Personality Aptitude then the answer is to be typed in the text area provided. The “Previous” button can be used to go back to the previous question and the “Next” button to go to the next question. The test can be submitted by clicking on the “Submit Test” button or automatically after the time is up.  
    • View Result: The student can view his or her complete details along with the marks obtained at the end of the test. The question number, user response and the correct response is displayed in case of an objective type test. The question number, marks, and the response type is displayed in case of a subjective type test. 
    • Sign Out: The student will be redirected to Login Page.
    ii. The Teacher:
    • Teacher Login: A teacher is required to login to the system using his or her Teacher Id (unique and numeric) and Password.
    • Detailed Result: The teacher can select the “Detailed Result” tab to view the marks obtained by all the students in each subject.
    • Overall Analysis : The teacher can select the “Overall Analysis” tab and select a subject from the drop-down list and view a graph depicting the minimum, average and the maximum marks obtained by the students in that subject.
    • Sign Out: The teacher will be redirected to Login Page.

This project is a Java Application developed in Netbeans IDE 8.2 with MySQL database at backend. The Stanford Core NLP is included to analyse the student responses entered in subjective tests and determine the response type and allot marks. JFreeCharts are used to create bar charts for the overall analysis of marks.   
3.3 Detailed Non-Functional Requirements
3.3.1 Logical Structure of Data

The logical structure of the data to be stored in the Online Examination System database is given below: 



Fig. E-R Diagram








The data descriptions of each of these data entities is as follows:

Student Data Entity
Data Item
Type
Description
Comment
examId (Primary Key)
Int
Exam ID of the student
Exam ID is used as the login ID for student
studentName
Varchar(50)
Name of the student

studentPassword
Varchar(255)
Password for login
Stored in MD5 32 hex digits format

Teacher Data Entity
Data Item
Type
Description
Comment
teacherId
(Primary Key)
Int
Teacher ID
Teacher ID is used as login ID for teacher
teacherName
Varchar(50)
Name of the teacher

teacherPassword
Varchar(255)
Password for login
Stored in MD5 32 hex digits format

Subject Data Entity
Data Item
Type
Description
Comment
subjectId (Primary Key)
Int
Subject ID

subjectName
Varchar(50)
Name of the subject


Question Data Entity
Data Item
Type
Description
Comment
qId (Primary Key)
Int
Question ID

question
Varchar(250)
Description of the question

subjectId
(Foreign Key)
Int
Subject ID
Indicates the subject to which the question belongs to


QuestionChoices Data Entity
Data Item
Type
Description
Comment
choiceId (Primary Key)
Int
Choice ID

qId (Foreign Key)
Int
Question ID
Indicates the question to which the choice belongs to
isRightChoice
Int
    0- Wrong
    1- Right
Indicates whether an option is the correct answer
choice
Varchar(100)
Description of the choice

subjectId
Int
Subject ID
Indicates the subject to which the choice belongs to

UserQuestionAnswer Data Entity
Data Item
Type
Description
Comment
examId (Foreign Key)
Int
Exam ID
Indicates the student to which the answer belongs to
subjectId
(Foreign Key)
Int
Subject ID
Indicates the subject question answered by the student
qId
(Foreign Key)
Int 
Question ID
Indicates the question answered by the student
choiceId
(Foreign Key)
Int
Choice ID
Indicates the choice selected for the answer by the student
isRight
Int 
    0- Wrong
    1- Right
Indicates whether the choice selected by the student is right or wrong




SubjectiveAnswer Data Entity
Data Item
Type
Description
Comment
examId (Foreign Key)
Int
Exam ID
Indicates the student to which the answer belongs to
qId
(Foreign Key)
Int
Question ID
Indicates the question answered by the student 
answerContents
Varchar(250) 
Description of student answer

score
Int
    0- Very Negative
    1- Negative
    2- Neutral
    3- Positive
    4- Very Positive
Indicates the marks and type of student response 

Result Data Entity
Data Item
Type
Description
Comment
resultId
(Primary Key)
Int
Result ID

examId
(Foreign Key)
Int
Exam ID
Indicates the student to which the answer belongs to
subjectId
Int
Subject ID
Indicates the subject to which the choice belongs to
marks
Int
Marks
Indicates the total marks obtained in a particular subject
examDate
Date
Exam date
Indicates the date on which the test was taken





Fig. Database Schema
