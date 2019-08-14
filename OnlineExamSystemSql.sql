-- MySQL dump 10.13  Distrib 5.5.61, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: OnlineExamSystem
-- ------------------------------------------------------
-- Server version	5.5.61-0ubuntu0.14.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Question`
--

DROP TABLE IF EXISTS `Question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Question` (
  `qId` int(11) NOT NULL,
  `question` varchar(250) NOT NULL,
  `subjectId` int(11) NOT NULL,
  PRIMARY KEY (`qId`),
  KEY `subjectId` (`subjectId`),
  CONSTRAINT `Question_ibfk_1` FOREIGN KEY (`subjectId`) REFERENCES `Subject` (`subjectId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Question`
--

LOCK TABLES `Question` WRITE;
/*!40000 ALTER TABLE `Question` DISABLE KEYS */;
INSERT INTO `Question` VALUES (1001,'A is two years older than B who is twice as old as C. If the total of the ages of A, B and C be 27, the how old is B?',101),(1002,'A person crosses a 600 m long street in 5 minutes. What is his speed in km per hour?',101),(1003,'It was Sunday on Jan 1, 2006. What was the day of the week Jan 1, 2010? ',101),(1004,'What will be the day of the week 15th August, 2010? ',101),(1005,'A sum of money at simple interest amounts to Rs. 815 in 3 years and to Rs. 854 in 4 years. The sum is: ',101),(1006,'Arun went for a movie nine days ago. He goes to watch movies only on Thursdays. What day of the week is today?',101),(1007,'A bag contains 2 yellow, 3 green and 2 blue balls. Two balls are drawn at random. What is the probability that none of the balls drawn is blue?',101),(1008,'The angle between the minute hand and the hour hand of a clock when the time is 8.30, is',101),(1009,'A is 2 1?3 times as fast as B. If A gives B a start of 80 m, how long should the race course be so that both of them reach at the same time?',101),(2001,'The Pacific yew is an evergreen tree that grows in the Pacific Northwest. The Pacific yew has a fleshy, poisonous fruit. Recently, taxol, a substance found in the bark of the Pacific yew, was discovered to be a promising new anticancer drug.',202),(2002,'On weekends, Mr. Sanchez spends many hours working in his vegetable and flower gardens. Mrs. Sanchez spends her free time reading and listening to classical music. Both Mr. Sanchez and Mrs. Sanchez like to cook.',202),(2003,'Look at this series: 2, 1, (1/2), (1/4), ... What number should come next?',202),(2004,'Look at this series: 7, 10, 8, 11, 9, 12, ... What number should come next?',202),(2005,'Look at this series: 36, 34, 30, 28, 24, ... What number should come next?',202),(2006,'Look at this series: 22, 21, 23, 22, 24, 23, ... What number should come next?',202),(2007,'Look at this series: 53, 53, 40, 40, 27, 27, ... What number should come next?',202),(2008,'Three of the words will be in the same classification, the remaining one will not be. Your answer will be the one word that does NOT belong in the same classification as the others.Which word does NOT belong with the others?',202),(2009,'Three of the words will be in the same classification, the remaining one will not be. Your answer will be the one word that does NOT belong in the same classification as the others.Whichword does not belong with the others?',202),(3001,'What will you do if you see an accident on the road?',303),(3002,'What will you do if your friend is angry with you for some reason even if it was not your fault?',303),(3003,'Express your view on: My goals in life are clear',303),(3004,'What do you do if your colleagues are rude to you at work?',303),(3005,'How confident are you in whatever you do?',303),(3006,'How adaptive are you to changing working environment?',303),(3007,'What are your views on ALWAYS being punctual?',303),(3008,'What do you think about your leadership qualities?',303),(3009,'What is your opinion on the statement:Ican efficiently perform multiple tasks at a time. ',303),(10010,' Find the odd man out. 1, 8, 27, 64, 125, 196, 216, 343',101),(10011,'An error 2% in excess is made while measuring the side of a square. What is the percentage of error in the calculated area of the square? ',101),(10012,'The area of a rectangular plot is 460 square metres. If the length is 15% more than the breadth, what is the breadth of the plot?',101),(10013,'The base of a parallelogram is (p+4), altitude to the base is (p?3) and the area is (p2?4),find out its actual area.',101),(10014,' The average of 20 numbers is zero. Of them, How many of them may be greater than zero, at the most?',101),(10015,'A man\'s speed with the current is 15 km/hr and the speed of the current is 2.5 km/hr. The man\'s speed against the current is:',101),(10016,'The banker\'s discount on a bill due 4 months hence at 15% is Rs. 420. What is the true discount?',101),(10017,' In a dairy farm, 40 cows eat 40 bags of husk in 40 days. In how many days one cow will eat one bag of husk?',101),(10018,'If 204 ÷ 12.75 = 16, then 2.04 ÷ 1.275 = ?',101),(10019,'What is the greatest number of four digits which is divisible by 15, 25, 40 and 75 ?',101),(10020,' From a point P on a level ground, the angle of elevation of the top tower is 30º. If the tower is 200 m high, the distance of point P from the foot of the tower is:',101),(10021,'log?6/log3?6=? ',101),(10022,' A container contains 40 litres of milk. From this container 4 litres of milk was taken out and replaced by water. This process was repeated further two times. How much milk is now contained by the container?',101),(10023,'If (232 + 1) is completely divisible by a whole number, which of the following numbers is completely divisible by this number? ',101),(10024,'Out of 7 consonants and 4 vowels, how many words of 3 consonants and 2 vowels can be formed?',101),(10025,'Two pipes A and B can fill a cistern in 37 1/2 minutes and 45 minutes respectively. Both pipes are opened. The cistern will be filled in just half an hour, if pipe B is turned off after',101),(10026,'The price of 80 apples is equal to that of 120 oranges. The price of 60 apples and 75 oranges together is Rs. 1320. The total price of 25 apples and 40 oranges is',101),(10027,'A train, 800 metre long is running with a speed of 78 km/hr. It crosses a tunnel in 1 minute. What is the length of the tunnel (in metres)?',101),(10028,'Insert the missing number. 12, 25, 49, 99, 197, 395, (...)',101),(10029,'A fruit seller sells apples at the rate of Rs. 9 per kg and thereby loses 20%. At what price per kg, he should have sold them to make a profit of 5%?',101),(10030,'Two train each 500 metre long, are running in opposite directions on parallel tracks. If their speeds are 45 km/hr and 30 km/hr respectively, the time taken by the slower train to pass the driver of the faster one is',101),(20010,'Find the odd one out',202),(20011,'Find the odd one out',202),(20012,'Find the odd one out',202),(20013,' If FRIEND is coded as HUMJTK, how can CANDLE be written in that code?',202),(20014,'In a certain code ADVENTURES is written as TRDESAUVEN. How is PRODUCED written in that code ?',202),(20015,'If FRAGRANCE is written as SBHSBODFG, how can IMPOSING be written?',202),(20016,'If ROBUST is coded as QNATRS in a certain language, which word would be coded as ZXCMP?',202),(20017,'Pointing to a amn in a photograph,a woman said that his brothers father is the only son of my grandfather.How is the woman related to the man in the photograph?',202),(20018,'A told B that the girl he met yesterday was the youngest daughter of the brother–in–law of mother of my friend.How is the girl related to friend of A?',202),(20019,'A and B are young ones of C. If C is the father of A but B is not the son of C. How are B and C related',202),(20020,'Doctor : Patient : : Politician : ?',202),(20021,'Ignorance : Education : : Disease : ?',202),(20022,'Man : Biography : : Nation : ?',202),(20023,'Guilt : Past : : Hope : ?',202),(20024,'Tickets numbered 1 to 20 are mixed up and then a ticket is drawn at random. What is the probability that the ticket drawn has a number which is a multiple of 3 or 5? ',202),(20025,'A bag contains 2 red, 3 green and 2 blue balls. Two balls are drawn at random. What is the probability that none of the balls drawn is blue? ',202),(20026,'In a box, there are 8 red, 7 blue and 6 green balls. One ball is picked up randomly. What is the probability that it is neither red nor green? ',202),(20027,'What is the probability of getting a sum 9 from two throws of a dice?',202),(20028,'Three unbiased coins are tossed. What is the probability of getting at most two heads? ',202),(20029,'A card is drawn from a pack of 52 cards. The probability of getting a queen of club or a king of heart is:',202),(20030,'A bag contains 4 white, 5 red and 6 blue balls. Three balls are drawn at random from the bag. The probability that all of them are red, is:',202),(30010,'What do you feel about unexpected resposibility?',303);
/*!40000 ALTER TABLE `Question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `QuestionChoices`
--

DROP TABLE IF EXISTS `QuestionChoices`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `QuestionChoices` (
  `choiceId` int(11) NOT NULL,
  `qId` int(11) NOT NULL,
  `isRightChoice` int(11) NOT NULL,
  `choice` varchar(100) NOT NULL,
  `subjectId` int(11) NOT NULL,
  PRIMARY KEY (`choiceId`),
  KEY `qId` (`qId`),
  KEY `subjectId` (`subjectId`),
  CONSTRAINT `QuestionChoices_ibfk_1` FOREIGN KEY (`qId`) REFERENCES `Question` (`qId`),
  CONSTRAINT `subjectId` FOREIGN KEY (`subjectId`) REFERENCES `Subject` (`subjectId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `QuestionChoices`
--

LOCK TABLES `QuestionChoices` WRITE;
/*!40000 ALTER TABLE `QuestionChoices` DISABLE KEYS */;
INSERT INTO `QuestionChoices` VALUES (10011,1001,0,'7',101),(10012,1001,0,'8',101),(10013,1001,0,'9',101),(10014,1001,1,'10',101),(10021,1002,0,'3.6',101),(10022,1002,1,'7.2',101),(10023,1002,0,'8.4',101),(10024,1002,0,'10',101),(10031,1003,0,'Sunday',101),(10032,1003,0,'Saturday',101),(10033,1003,1,'Friday',101),(10034,1003,0,'Wednesday',101),(10041,1004,1,'Sunday',101),(10042,1004,0,'Monday',101),(10043,1004,0,'Tuesday',101),(10044,1004,0,'Thursday',101),(10051,1005,0,'RS.650',101),(10052,1005,0,'RS.690',101),(10053,1005,1,'RS.698',101),(10054,1005,0,'RS.700',101),(10061,1006,0,'Wednesday',101),(10062,1006,1,'Saturday',101),(10063,1006,0,'Friday',101),(10064,1006,0,'Sunday',101),(10071,1007,0,'1/2',101),(10072,1007,1,'10/21',101),(10073,1007,0,'9/11',101),(10074,1007,0,'7/11',101),(10081,1008,1,'75 Degree',101),(10082,1008,0,'85 Degree',101),(10083,1008,0,'80 Degree',101),(10084,1008,0,'70 Degree',101),(10091,1009,0,'170 metre',101),(10092,1009,0,'150 metre',101),(10093,1009,0,'140 metre',101),(10094,1009,0,'160 metre',101),(20011,2001,0,'Taxol is poisonous when taken by healthy people.',202),(20012,2001,0,'Taxol has cured people from various diseases.',202),(20013,2001,1,'People should not eat the fruit of the Pacific yew.',202),(20014,2001,0,'The Pacific yew was considered worthless until taxol was discovered.',202),(20021,2002,1,'Mr. Sanchez enjoys planting and growing vegetables.',202),(20022,2002,0,'Mr. Sanchez does not like classical music',202),(20023,2002,0,'Mrs. Sanchez cooks the vegetables that Mr Sachez grows.',202),(20024,2002,0,'Mrs. Sanchez enjoys reading nineteenth century novels.',202),(20031,2003,0,'(1/3)',202),(20032,2003,1,'(1/8)',202),(20033,2003,0,'(2/8)',202),(20034,2003,0,'(1/16)',202),(20041,2004,0,'7',202),(20042,2004,1,'10',202),(20043,2004,0,'12',202),(20044,2004,0,'13',202),(20051,2005,0,'20',202),(20052,2005,1,'22',202),(20053,2005,0,'23',202),(20054,2005,0,'26',202),(20061,2006,0,'22',202),(20062,2006,0,'24',202),(20063,2006,1,'25',202),(20064,2006,0,'26',202),(20071,2007,0,'12',202),(20072,2007,1,'14',202),(20073,2007,0,'27',202),(20074,2007,0,'53',202),(20081,2008,0,'parsley',202),(20082,2008,0,'basil',202),(20083,2008,0,'dill',202),(20084,2008,1,'mayonnaise',202),(20091,2009,0,'inch',202),(20092,2009,1,'ounce',202),(20093,2009,0,'centimeter',202),(20094,2009,0,'yard',202),(100101,10010,0,'64',101),(100102,10010,1,'196',101),(100103,10010,0,'216',101),(100104,10010,0,'1',101),(100111,10011,1,'4.04%',101),(100112,10011,0,'2.02%',101),(100113,10011,0,'4%',101),(100114,10011,0,'2%',101),(100121,10012,0,'14 metres',101),(100122,10012,1,'20 metres',101),(100123,10012,0,'18 metres',101),(100124,10012,0,'12 metres',101),(100131,10013,0,'40 sq. units',101),(100132,10013,0,'54 sq. units',101),(100133,10013,0,'36 sq. units',101),(100134,10013,1,'60 sq. units',101),(100141,10014,0,'1',101),(100142,10014,0,'20',101),(100143,10014,0,'0',101),(100144,10014,1,'19',101),(100151,10015,0,'8.5 km/hr',101),(100152,10015,1,'10 km/hr',101),(100153,10015,0,'12.5 km/hr',101),(100154,10015,0,'9 km/hr',101),(100161,10016,0,'Rs. 410',101),(100162,10016,1,'Rs. 400',101),(100163,10016,0,'Rs. 390',101),(100164,10016,0,'Rs. 380',101),(100171,10017,0,'1',101),(100172,10017,1,'40',101),(100173,10017,0,'20',101),(100174,10017,0,'26',101),(100181,10018,0,'16',101),(100182,10018,1,'1.6',101),(100183,10018,0,'0.16',101),(100184,10018,0,'0.016',101),(100191,10019,0,'9800',101),(100192,10019,0,'9400',101),(100193,10019,1,'9600',101),(100194,10019,0,'9200',101),(100201,10020,1,'346 m',101),(100202,10020,0,'400 m',101),(100203,10020,0,'312 m',101),(100204,10020,0,'298 m',101),(100211,10021,0,'1/3',101),(100212,10021,0,'1/2',101),(100213,10021,1,'3/2',101),(100214,10021,0,'2/3',101),(100221,10022,0,'26 litres',101),(100222,10022,1,'29.1 litres',101),(100223,10022,0,'28 litres',101),(100224,10022,0,'28.2 litres',101),(100231,10023,1,'(2^96 + 1)',101),(100232,10023,0,'(7 X 2^23)',101),(100233,10023,0,'(2^16 - 1)',101),(100234,10023,0,'(2^16 + 1)',101),(100241,10024,0,'24400',101),(100242,10024,0,'21300',101),(100243,10024,0,'210',101),(100244,10024,1,'25200',101),(100251,10025,0,'5 min',101),(100252,10025,1,'9 min',101),(100253,10025,0,'10 min',101),(100254,10025,0,'15 min',101),(100261,10026,0,'Rs. 660',101),(100262,10026,0,'Rs. 780',101),(100263,10026,0,'Rs. 820',101),(100264,10026,1,'Rs. 620',101),(100271,10027,0,'440 metre',101),(100272,10027,1,'500 metre',101),(100273,10027,0,'260 metre',101),(100274,10027,0,'430 metre',101),(100281,10028,1,'789',101),(100282,10028,0,'1579',101),(100283,10028,0,'722',101),(100284,10028,0,'812',101),(100291,10029,0,'Rs. 11.32',101),(100292,10029,0,'Rs. 11',101),(100293,10029,0,'Rs. 12',101),(100294,10029,1,'Rs. 11.81',101),(100301,10030,0,'50 seconds',101),(100302,10030,0,'58 seconds',101),(100303,10030,1,'24 seconds',101),(100304,10030,0,'22 seconds',101),(200101,20010,0,'crusade',202),(200102,20010,0,'expedition',202),(200103,20010,1,'cruise',202),(200104,20010,0,'campaign',202),(200111,20011,0,'flourish',202),(200112,20011,1,'renovate',202),(200113,20011,0,'blossom',202),(200114,20011,0,'thrive',202),(200121,20012,1,'vapour',202),(200122,20012,0,'mist',202),(200123,20012,0,'hailstone',202),(200124,20012,0,'fog',202),(200131,20013,0,'DEQJQM',202),(200132,20013,0,'DCQHQK',202),(200133,20013,1,'EDRIRL',202),(200134,20013,0,'ESJFME',202),(200141,20014,1,'IUIPGSSRNP',202),(200142,20014,0,'IUIPGSRSNR',202),(200143,20014,0,'IUINGSSRRP',202),(200144,20014,0,'IRIPGSSNRR',202),(200151,20015,0,'NQPTJHOJ',202),(200152,20015,1,'NQPTJOHJ',202),(200153,20015,0,'NQTPJOHJ',202),(200154,20015,0,'NQPTJOHI',202),(200161,20016,1,'AWDLQ',202),(200162,20016,0,'AYDNQ',202),(200163,20016,0,'BZEOR',202),(200164,20016,0,'YYBNO',202),(200171,20017,1,'Sister',202),(200172,20017,0,'Aunt',202),(200173,20017,0,'Grandmother',202),(200174,20017,0,'Daughter',202),(200181,20018,0,'Niece',202),(200182,20018,1,'Cousin',202),(200183,20018,0,'Friend',202),(200184,20018,0,'Daughter',202),(200191,20019,0,'Niece and Uncle',202),(200192,20019,1,'Daughter and Father',202),(200193,20019,0,'Daughter and Uncle',202),(200194,20019,0,'Daughter and Mother',202),(200201,20020,1,'Voter',202),(200202,20020,0,'Chair',202),(200203,20020,0,'Money',202),(200204,20020,0,'Public',202),(200211,20021,0,'Hospital',202),(200212,20021,0,'Doctor',202),(200213,20021,1,'Medicine',202),(200214,20021,0,'Nurse',202),(200221,20022,1,'History',202),(200222,20022,0,'Geography',202),(200223,20022,0,'People',202),(200224,20022,0,'Leader',202),(200231,20023,0,'Present',202),(200232,20023,0,'Sorrow',202),(200233,20023,0,'Past',202),(200234,20023,1,'Future',202),(200241,20024,0,'1/2',202),(200242,20024,0,'2/5',202),(200243,20024,0,'8/15',202),(200244,20024,1,'9/20',202),(200251,20025,1,'10/21',202),(200252,20025,0,'11/21',202),(200253,20025,0,'2/7',202),(200254,20025,0,'5/7',202),(200261,20026,1,'1/3',202),(200262,20026,0,'3/4',202),(200263,20026,0,'7/19',202),(200264,20026,0,'8/21',202),(200271,20027,0,'1/6',202),(200272,20027,0,'1/8',202),(200273,20027,1,'1/9',202),(200274,20027,0,'1/12',202),(200281,20028,0,'3/4',202),(200282,20028,0,'1/4',202),(200283,20028,0,'3/8',202),(200284,20028,1,'7/8',202),(200291,20029,0,'1/13',202),(200292,20029,0,'2/13',202),(200293,20029,1,'1/26',202),(200294,20029,0,'1/52',202),(200301,20030,0,'1/22',202),(200302,20030,0,'3/22',202),(200303,20030,1,'2/91',202),(200304,20030,0,'2/77',202);
/*!40000 ALTER TABLE `QuestionChoices` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Result`
--

DROP TABLE IF EXISTS `Result`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Result` (
  `resultId` int(11) NOT NULL AUTO_INCREMENT,
  `examId` int(11) NOT NULL,
  `subjectId` int(11) NOT NULL,
  `marks` int(11) DEFAULT '0',
  `examDate` date NOT NULL,
  PRIMARY KEY (`resultId`),
  KEY `examId` (`examId`),
  KEY `subjectId` (`subjectId`),
  CONSTRAINT `Result_ibfk_1` FOREIGN KEY (`examId`) REFERENCES `Student` (`examId`),
  CONSTRAINT `Result_ibfk_2` FOREIGN KEY (`subjectId`) REFERENCES `Subject` (`subjectId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Result`
--

LOCK TABLES `Result` WRITE;
/*!40000 ALTER TABLE `Result` DISABLE KEYS */;
INSERT INTO `Result` VALUES (1,302001,101,8,'2018-10-15'),(2,302001,202,8,'2018-10-15'),(4,302001,303,10,'2018-10-15'),(5,302002,101,10,'2018-10-15'),(6,302002,202,6,'2018-10-15'),(7,302002,303,20,'2018-10-15');
/*!40000 ALTER TABLE `Result` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Student`
--

DROP TABLE IF EXISTS `Student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Student` (
  `examId` int(11) NOT NULL,
  `studentName` varchar(50) NOT NULL,
  `studentClass` varchar(30) NOT NULL,
  `studentPassword` varchar(255) NOT NULL,
  PRIMARY KEY (`examId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Student`
--

LOCK TABLES `Student` WRITE;
/*!40000 ALTER TABLE `Student` DISABLE KEYS */;
INSERT INTO `Student` VALUES (302001,'Jack Perry','BE COMP 1','dcb1359079416e5fea25e825f7e66018'),(302002,'Lily Brown','BE COMP 2','a654603cb87866f1b768d67b94a9db10');
/*!40000 ALTER TABLE `Student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Subject`
--

DROP TABLE IF EXISTS `Subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Subject` (
  `subjectId` int(11) NOT NULL,
  `subjectName` varchar(30) NOT NULL,
  PRIMARY KEY (`subjectId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Subject`
--

LOCK TABLES `Subject` WRITE;
/*!40000 ALTER TABLE `Subject` DISABLE KEYS */;
INSERT INTO `Subject` VALUES (101,'Quantitative Aptitude'),(202,'Logical Reasoning'),(303,'Personality Aptitude');
/*!40000 ALTER TABLE `Subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SubjectiveAnswer`
--

DROP TABLE IF EXISTS `SubjectiveAnswer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SubjectiveAnswer` (
  `examId` int(11) NOT NULL,
  `qId` int(11) NOT NULL,
  `answerContents` varchar(300) DEFAULT NULL,
  `score` int(11) NOT NULL,
  KEY `examId` (`examId`),
  KEY `qId` (`qId`),
  CONSTRAINT `SubjectiveAnswer_ibfk_1` FOREIGN KEY (`examId`) REFERENCES `Student` (`examId`),
  CONSTRAINT `SubjectiveAnswer_ibfk_2` FOREIGN KEY (`qId`) REFERENCES `Question` (`qId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SubjectiveAnswer`
--

LOCK TABLES `SubjectiveAnswer` WRITE;
/*!40000 ALTER TABLE `SubjectiveAnswer` DISABLE KEYS */;
INSERT INTO `SubjectiveAnswer` VALUES (302001,30010,'orjpjpj',2),(302001,3009,'',0),(302001,3006,'iohih',2),(302001,3002,'',0),(302001,3005,'',0),(302001,30010,'lkjprijpij',2),(302001,3009,';ojfjpfj',2),(302001,3006,'wliejijp',2),(302001,3002,'',0),(302001,3005,'jfpopf',2),(302001,30010,'ihoih',2),(302001,3009,'',0),(302001,3006,'',0),(302001,3002,'',0),(302001,3005,'',0),(302001,3003,'jbk',2),(302001,3007,'bkg',2),(302001,3001,'',0),(302001,3008,'',0),(302001,30010,'',0),(302001,3002,'',0),(302001,3009,'',0),(302001,3008,'',0),(302001,3004,'',0),(302001,30010,'',0),(302001,3008,'',0),(302001,3004,'',0),(302001,3009,'',0),(302001,3006,'',0),(302001,3007,'',0),(302001,3002,'i will wait for him to say sorry.',1),(302001,3004,'i will ingnore them.I dont care what they think about me.',1),(302001,3009,'I can do multiple tasks at a time very efficiently.',3),(302001,3001,'I will help victim and take him to hospital.',2),(302001,3007,'I like to always being punctual.',2),(302001,3009,'uhohio',2),(302001,3003,'lknjnn',2),(302001,3006,'kjhuhouh',2),(302001,30010,'',0),(302001,3005,'',0),(302001,3004,'',0),(302001,30010,'',0),(302001,3008,'',0),(302001,3005,'',0),(302001,3002,'',0),(302001,3006,'i m very adaptive',2),(302001,30010,'i dont like it',2),(302001,3005,'im not confident',1),(302001,3002,'i will wait for him',2),(302001,3004,'i will ignore them',2),(302001,3002,'ddg',2),(302001,3006,'',0),(302001,3007,'fgdcfhfc',2),(302001,3009,'',0),(302001,3001,'',0),(302001,3005,'sgdh',2),(302001,3001,'dfhfgh',2),(302001,3007,'gfg',2),(302001,3004,'hfgh',2),(302001,3003,'ghfgj',2),(302001,3005,'fngiut',2),(302001,3009,'fvteiow',2),(302001,3007,'freu8fw0qe',2),(302001,3006,'',0),(302001,3001,'sjdihergi',2),(302002,3005,NULL,0),(302002,3009,NULL,0),(302002,3007,NULL,0),(302002,3006,NULL,0),(302002,3001,NULL,0),(302001,3001,NULL,0),(302001,3005,NULL,0),(302001,3008,NULL,0),(302001,3004,NULL,0),(302001,3002,NULL,0),(302001,3007,NULL,0),(302001,30010,NULL,0),(302001,3006,NULL,0),(302001,3009,NULL,0),(302001,3003,NULL,0),(302001,3006,'I am very much adaptive to changing environment.I can work efficiently if there will be chang in working environment.',1),(302001,3004,'',0),(302001,30010,'I cannot handle unexpected responsibilities.',1),(302001,3003,'My goals in life are very clear.I fixed my goals in my childhood only.I am trying to achieve my goals.',1),(302001,3005,'I am very much confident in everything I do.I can do anything in good confidence.',3),(302001,3008,'',0),(302001,3001,'I wii help that person beacause it is my responsibility.',2),(302001,3009,'I cannot perform multiple tasks at a time efficiently beacause I cannot handle multiple tasks at a time.',1),(302001,3002,'',0),(302001,3007,'I am very punctual person.I like to be a punctual.',1),(302002,3006,'I am very much adaptive to changing environment.',1),(302002,3004,'I will avoid my colleagues at work.I will igore them.',1),(302002,30010,'',0),(302002,3003,'My goals in my life are very much clear.',3),(302002,3005,'I am very much confident in everything i do.',3),(302002,3008,'My leadership qualities are very good.',3),(302002,3001,'I will help that person.',3),(302002,3009,'I can perform multiple tasks at a time.',3),(302002,3002,'I will not talk to him unless he will not fell gulty about his anger.',1),(302002,3007,'I am very punctual person.',2);
/*!40000 ALTER TABLE `SubjectiveAnswer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Teacher`
--

DROP TABLE IF EXISTS `Teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Teacher` (
  `teacherId` int(11) NOT NULL,
  `teacherName` varchar(50) NOT NULL,
  `teacherPassword` varchar(255) NOT NULL,
  PRIMARY KEY (`teacherId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Teacher`
--

LOCK TABLES `Teacher` WRITE;
/*!40000 ALTER TABLE `Teacher` DISABLE KEYS */;
INSERT INTO `Teacher` VALUES (402001,'Bob Martin','27b0566d30723405f9de0982e714202c');
/*!40000 ALTER TABLE `Teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `UserQuestionAnswer`
--

DROP TABLE IF EXISTS `UserQuestionAnswer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `UserQuestionAnswer` (
  `examId` int(11) NOT NULL,
  `subjectId` int(11) NOT NULL,
  `qId` int(11) NOT NULL,
  `choiceId` int(11) NOT NULL,
  `isRight` int(11) NOT NULL,
  KEY `examId` (`examId`),
  KEY `subjectId` (`subjectId`),
  KEY `qId` (`qId`),
  KEY `choiceId` (`choiceId`),
  CONSTRAINT `UserQuestionAnswer_ibfk_1` FOREIGN KEY (`examId`) REFERENCES `Student` (`examId`),
  CONSTRAINT `UserQuestionAnswer_ibfk_2` FOREIGN KEY (`subjectId`) REFERENCES `Subject` (`subjectId`),
  CONSTRAINT `UserQuestionAnswer_ibfk_3` FOREIGN KEY (`qId`) REFERENCES `Question` (`qId`),
  CONSTRAINT `UserQuestionAnswer_ibfk_4` FOREIGN KEY (`choiceId`) REFERENCES `QuestionChoices` (`choiceId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `UserQuestionAnswer`
--

LOCK TABLES `UserQuestionAnswer` WRITE;
/*!40000 ALTER TABLE `UserQuestionAnswer` DISABLE KEYS */;
INSERT INTO `UserQuestionAnswer` VALUES (302001,101,1003,10031,0),(302001,101,10026,100261,0),(302001,101,10021,100212,0),(302001,101,10013,100131,0),(302001,101,10024,100242,0),(302001,101,10029,100291,0),(302001,101,1004,10042,0),(302001,101,10028,100281,1),(302001,101,1006,10062,1),(302001,101,10018,10062,1),(302001,101,10020,100201,1),(302001,101,1009,10092,0),(302001,101,10014,100141,0),(302001,101,10012,100122,1),(302001,101,10016,100161,0),(302001,202,2005,20051,0),(302001,202,2009,20091,0),(302001,202,20017,200171,1),(302001,202,20029,200291,0),(302001,202,20020,200201,1),(302001,202,2002,20021,1),(302001,202,2001,20011,0),(302001,202,20024,200241,0),(302001,202,2008,20081,0),(302001,202,2003,20031,0),(302001,202,2006,20061,0),(302001,202,20018,200181,0),(302001,202,20021,200211,0),(302001,202,20016,200161,1),(302001,202,20019,200191,0),(302002,101,10012,100121,0),(302002,101,10027,100272,1),(302002,101,10021,100212,0),(302002,101,1005,10052,0),(302002,101,1004,10042,0),(302002,101,1003,10032,0),(302002,101,10024,100242,0),(302002,101,10015,100152,1),(302002,101,10025,100252,1),(302002,101,1008,10082,0),(302002,101,10020,100202,0),(302002,101,10016,100162,1),(302002,101,1001,10012,0),(302002,101,10010,100102,1),(302002,101,10023,100232,0),(302002,202,2002,20022,0),(302002,202,2009,20092,1),(302002,202,20026,200262,0),(302002,202,20028,200282,0),(302002,202,20029,200292,0),(302002,202,20020,200202,0),(302002,202,20021,200212,0),(302002,202,2003,20032,1),(302002,202,20017,200172,0),(302002,202,20023,200232,0),(302002,202,20022,200222,0),(302002,202,20030,200302,0),(302002,202,20027,200272,0),(302002,202,20015,200152,1),(302002,202,20014,200142,0);
/*!40000 ALTER TABLE `UserQuestionAnswer` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-15 23:16:51
