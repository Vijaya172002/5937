-- MySQL dump 10.13  Distrib 8.0.32, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: 5937
-- ------------------------------------------------------
-- Server version	8.0.35-0ubuntu0.22.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Banklogin`
--

DROP TABLE IF EXISTS `Banklogin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Banklogin` (
  `id` int NOT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `amount` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Banklogin`
--

LOCK TABLES `Banklogin` WRITE;
/*!40000 ALTER TABLE `Banklogin` DISABLE KEYS */;
INSERT INTO `Banklogin` VALUES (1,'Vijaya','Vijju@1','20000'),(2,'Shabana','Sha@1','19600'),(3,'Sirisha','Siri@1','18500'),(4,'Rupa','Rupa@1','19500');
/*!40000 ALTER TABLE `Banklogin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Emp1`
--

DROP TABLE IF EXISTS `Emp1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Emp1` (
  `id` int NOT NULL,
  `Fname` varchar(45) NOT NULL,
  `Lname` varchar(45) DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL,
  `Phoneno` int DEFAULT NULL,
  `Branch` varchar(45) DEFAULT NULL,
  `Dob` varchar(45) DEFAULT NULL,
  `Username` varchar(45) DEFAULT NULL,
  `Password` varchar(45) DEFAULT NULL,
  `Salary` int DEFAULT NULL,
  `role` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`,`Fname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Emp1`
--

LOCK TABLES `Emp1` WRITE;
/*!40000 ALTER TABLE `Emp1` DISABLE KEYS */;
INSERT INTO `Emp1` VALUES (1,'Vijaya','Battula','v@gmail.com',848571859,'ECE','18/10/23','vijju@1','v@123',21000,'Hr'),(2,'Shabana','Shaik','SShaik@miraclesoft.com',0,'CSE','19/10/23','SShaik','ShabShai',20500,'Trainee'),(3,'Siri','Saripilli','SSaripilli@miraclesoft.com',123456789,'CSE','19/10/23','SSaripilli','SiriSari',20500,'Trainee'),(4,'Suneetha','Battula','SBattula@miraclesoft.com',876543219,'CSE','20/10/23','SBattula','SuneBatt',41000,'Hr');
/*!40000 ALTER TABLE `Emp1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Emp2`
--

DROP TABLE IF EXISTS `Emp2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Emp2` (
  `id` int NOT NULL,
  `Fname` varchar(45) DEFAULT NULL,
  `Lname` varchar(45) DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL,
  `Dob` varchar(45) DEFAULT NULL,
  `Dept` varchar(45) DEFAULT NULL,
  `role` varchar(45) DEFAULT NULL,
  `Phoneno` varchar(45) DEFAULT NULL,
  `Username` varchar(45) DEFAULT NULL,
  `Password` varchar(45) DEFAULT NULL,
  `Status` varchar(45) DEFAULT NULL,
  `Join date` varchar(45) DEFAULT NULL,
  `Salary` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Emp2`
--

LOCK TABLES `Emp2` WRITE;
/*!40000 ALTER TABLE `Emp2` DISABLE KEYS */;
INSERT INTO `Emp2` VALUES (1,'Suneetha','Battula','S@gmail.com','23/10/2000','Devlopment','H','987654321','Suni@1','S@1','A',NULL,50000),(2,'Vijaya','Battula','VBattula@miraclesoft.com','24/10/2000','Development','A','98765432','VBattula241020','VBattula0010','A',NULL,30000),(3,'Ram','Battula','RBattula@miraclesoft.com','23/10/2001','Development','H','87654321','RBattula231001','RBattula1410','A',NULL,40000),(4,'Kumar','Battula','KBattula@miraclesoft.com','15/04/2000','Development','P','812773486','KBattula150400','KBattula1710','A',NULL,30500),(5,'Ravi','Billa','RBilla@miraclesoft.com','10/11/2000','Development','A','998974524','RBilla101100','RBilla1710','A',NULL,31000),(6,'Jalaja','Namala','JNamala@miraclesoft.com','08/09/2000','Development','P','741331685','JNamala080900','JNamala1710','A',NULL,28000),(7,'Ganesh','Namala','GNamala@miraclesoft.com','03/09/2000','Development','T','897805912','GNamala030900','GNamala1710','A',NULL,30000),(8,'Vidhulatha','Namala','VNamala@miraclesoft.com','07/08/2000','Development','T','821485239','VNamala070800','VNamala1710','A',NULL,30000),(11,'Shabana','Shaik','SShaik@miraclesoft.com','25/06/2001','Development','E','88745223','SShaik250601','SShaik1510','B','21/08/2023',20000),(12,'Sireesha','Saripilli','SSaripilli@miraclesoft.com','06/06/2001','Development','E','734538929','SSaripilli060601','SSaripilli1510','B','21/08/2023',20000),(13,'Suvarna','Gudimetla','SGudimetla@miraclesoft.com','21/05/2001','Development','E','832428742','SGudimetla210501','SGudimetla1510','A','21/08/2023',20500),(14,'Sirisha','Lanka','jyothisirisha279@gmail.com','13/01/2001','Development','E','96458385','SLanka130101','SLanka1610','A','21/08/2023',20500),(15,'Deekshitha','Gorla','deekshithagorla01@gmail.com','29/10/2001','Development','E','865545443','DGorla291001','DGorla1610','A','27/08/2023',20000),(16,'Jeevitha','Kanapareddy','JKanapareddy@miraclesoft.com','14/05/2001','Development','E','746763436','JKanapareddy140501','JKanapareddy1610','A','21/08/2023',20500),(17,'Jahnavi','POtnuru','JPOtnuru@miraclesoft.com','25/01/2002','Development','E','87973518','JPOtnuru250102','JPOtnuru1610','A','21/08/2023',20000),(18,'Sadhana','Vabilisetty','SVabilisetty@miraclesoft.com','12/10/2001','Development','E','798753315','SVabilisetty121001','SVabilisetty1610','A','27/08/2023',20000),(19,'Anjali','Baditha','ABaditha@miraclesoft.com','07/05/2001','Development','E','733084465','ABaditha070501','ABaditha1610','A','21/08/2023',20000),(20,'Rupa','Sivangi','RSivangi@miraclesoft.com','13/08/2000','Development','E','942421573','RSivangi130800','RSivangi1610','A','27/08/2023',19500),(21,'Meena','SVani','MSVani@miraclesoft.com','24/03/2001','Development','E','745713661','MSVani240301','MSVani1710','A','27/08/2023',20000),(22,'Divya','Naga','DNaga@miraclesoft.com','18/09/2001','Development','E','947313894','DNaga180901','DNaga1710','A','21/08/2023',20000),(23,'Jayanthi','Dorepalli','JDorepalli@miraclesoft.com','19/10/2001','Development','E','717524837','JDorepalli191001','JDorepalli1710','A','31/08/2023',19500),(24,'Supriya','Vankayalapati','SVankayalapati@miraclesoft.com','23/05/2001','Development','E','873345891','SVankayalapati230501','SVankayalapati1710','A','31/08/2023',19500),(25,'Anusha','Cheduri','ACheduri@miraclesoft.com','16/02/2001','Development','E','918584243','ACheduri160201','ACheduri1710','B','15/08/2023',21000),(26,'Durga','Battula','DBattula@miraclesoft.com','01/07/2002','Development','E','848571859','DBattula010702','DBattula1710','B','21/08/2023',21000),(27,'Lucky','Battula','LBattula@miraclesoft.com','09/05/2003','Development','E','941582344','LBattula090503','LBattula1710','B','31/08/2023',20000),(28,'Dhanush','Billa','DBillamiraclesoft.com','21/08/2003','Development','E','756873271','DBilla210803','DBilla1010','B','31/08/2023',20000),(29,'Deekshitha','Billa','DBilla@miraclesoft.com','09/05/2003','Development','E','867650434','DBilla090503','DBilla1834','B','21/08/2023',20500);
/*!40000 ALTER TABLE `Emp2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `EmpTaskList`
--

DROP TABLE IF EXISTS `EmpTaskList`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `EmpTaskList` (
  `id` varchar(45) DEFAULT NULL,
  `Proj_id` varchar(45) NOT NULL,
  `Task_id` varchar(45) DEFAULT NULL,
  `PM` varchar(45) DEFAULT NULL,
  `Proj_StartDate` varchar(45) DEFAULT NULL,
  `Proj_EndDate` varchar(45) DEFAULT NULL,
  `Status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Proj_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `EmpTaskList`
--

LOCK TABLES `EmpTaskList` WRITE;
/*!40000 ALTER TABLE `EmpTaskList` DISABLE KEYS */;
INSERT INTO `EmpTaskList` VALUES ('23','Flip10','Regi11','KBattula150400','10-26-2023','25/08/2024','A'),('21','Uber10','Logi11','KBattula150400','10-30-2023','11/05/2024','A');
/*!40000 ALTER TABLE `EmpTaskList` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ProjectData`
--

DROP TABLE IF EXISTS `ProjectData`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ProjectData` (
  `Proj_id` varchar(45) NOT NULL,
  `Proj_name` varchar(45) DEFAULT NULL,
  `Description` varchar(150) DEFAULT NULL,
  `Proj_StartDate` varchar(45) DEFAULT NULL,
  `Proj_EndDate` varchar(45) DEFAULT NULL,
  `Total_emp` int DEFAULT NULL,
  `PM` varchar(45) DEFAULT NULL,
  `Hr` varchar(45) DEFAULT NULL,
  `Assignedby` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Proj_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ProjectData`
--

LOCK TABLES `ProjectData` WRITE;
/*!40000 ALTER TABLE `ProjectData` DISABLE KEYS */;
INSERT INTO `ProjectData` VALUES ('ajio10','ajio','ajio online shopping','10-26-2023','25/08/2024',15,'JNamala080900','RBattula231023','VBattula241023'),('Amaz10','Amazon','Amazon.com, online retailer, manufacturer of electronic book readers, and Web services provider ','10-26-2023','15/04/2024',20,'JNamala080900','RBattula231023','VBattula241023'),('Ecar10','Ecart','Flipkart online shopping','10-26-2023','25/08/2024',15,'KBattula150400','RBattula231023','VBattula241023'),('Flip10','Flipkart','Flipkart online shopping','10-26-2023','25/08/2024',15,'KBattula150400','RBattula231023','VBattula241023'),('ljio10','bjio','ajio online shopping','10-26-2023','25/08/2024',15,'JNamala080900','RBattula231023','RBattula231023'),('mees10','meesho','ajio online shopping','10-26-2023','25/08/2024',15,'JNamala080900','RBattula231023','VBattula241023'),('Rapi10','Rapido','Uber online transportation','10-30-2023','11/05/2024',10,'JNamala080900','RBattula231001','VBattula241020'),('Uber10','Uber','Uber online transportation','10-30-2023','11/05/2024',10,'JNamala080900','RBattula231001','VBattula241020'),('Yout10','Youtube','Youtube help  viewers to find videos more easily through search. Subscribe to the YouTube Creators channel for the latest news, updates, and tips.','10-26-2023','21/09/2023',25,'KBattula150400','RBattula231023','VBattula241023');
/*!40000 ALTER TABLE `ProjectData` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ProjectEmpContact`
--

DROP TABLE IF EXISTS `ProjectEmpContact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ProjectEmpContact` (
  `id` varchar(45) DEFAULT NULL,
  `Fname` varchar(45) NOT NULL,
  `Email` varchar(45) DEFAULT NULL,
  `Phoneno` int DEFAULT NULL,
  `Proj_id` varchar(45) DEFAULT NULL,
  `AssignedBy` varchar(45) DEFAULT NULL,
  `Emp_JoinDate` varchar(45) DEFAULT NULL,
  `Proj_AssignedDate` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Fname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ProjectEmpContact`
--

LOCK TABLES `ProjectEmpContact` WRITE;
/*!40000 ALTER TABLE `ProjectEmpContact` DISABLE KEYS */;
INSERT INTO `ProjectEmpContact` VALUES ('19','AnjaliBaditha','ABaditha@miraclesoft.com',733084465,'Flip10','KBattula150400','21/08/2023','10-26-2023'),('15','DeekshithaGorla','deekshithagorla01@gmail.com',865545443,'Yout10','KBattula150400','27/08/2023','10-26-2023'),('22','DivyaNaga','DNaga@miraclesoft.com',947313894,'Flip10','KBattula150400','21/08/2023','10-30-2023'),('17','JahnaviPOtnuru','JPOtnuru@miraclesoft.com',87973518,'Amaz10','JNamala080900','21/08/2023','10-26-2023'),('23','JayanthiDorepalli','JDorepalli@miraclesoft.com',782321905,'Flip10','KBattula150400','31/08/2023','10-31-2023'),('16','JeevithaKanapareddy','JKanapareddy@miraclesoft.com',746763436,'Amaz10','JNamala080900','21/08/2023','10-26-2023'),('21','MeenaSVani','MSVani@miraclesoft.com',745713661,'Uber10','KBattula150400','27/08/2023','10-30-2023'),('21','MeenaSVaninull','MSVani@miraclesoft.com',745713661,'Rapi10','JNamala080900','27/08/2023','10-30-2023'),('20','RupaSivangi','RSivangi@miraclesoft.com',942421573,'Flip10','KBattula150400','27/08/2023','10-27-2023'),('18','SadhanaVabilisetty','SVabilisetty@miraclesoft.com',798753315,'Amaz10','JNamala080900','27/08/2023','10-26-2023'),('14','SirishaLanka','jyothisirisha279@gmail.com',96458385,'Yout10','KBattula150400','21/08/2023','10-26-2023'),('24','SupriyaVankayalapati','SVankayalapati@miraclesoft.com',743785643,'Amaz10','JNamala080900','31/08/2023','11-01-2023'),('13','SuvarnaGudimetla','SGudimetla@miraclesoft.com',832428742,'Yout10','KBattula150400','21/08/2023','10-26-2023');
/*!40000 ALTER TABLE `ProjectEmpContact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ProjectMeet`
--

DROP TABLE IF EXISTS `ProjectMeet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ProjectMeet` (
  `Meet_id` varchar(45) DEFAULT NULL,
  `Meet_name` varchar(45) DEFAULT NULL,
  `Meet_contact` varchar(45) DEFAULT NULL,
  `Proj_id` varchar(45) DEFAULT NULL,
  `Start_time` varchar(45) DEFAULT NULL,
  `End_time` varchar(45) DEFAULT NULL,
  `Duration` int DEFAULT NULL,
  `Date` varchar(45) DEFAULT NULL,
  `Createdby` varchar(45) DEFAULT NULL,
  `Meeting_status` varchar(45) DEFAULT NULL,
  `Meeting_description` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ProjectMeet`
--

LOCK TABLES `ProjectMeet` WRITE;
/*!40000 ALTER TABLE `ProjectMeet` DISABLE KEYS */;
INSERT INTO `ProjectMeet` VALUES ('Yout12','Channel subscription online meet','14,15,','Yout10','13:00','13:30',30,'01/12/2023','KBattula150400','C','To discuss about New features in channel Subscription');
/*!40000 ALTER TABLE `ProjectMeet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Role`
--

DROP TABLE IF EXISTS `Role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Role` (
  `Id` int NOT NULL,
  `role` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Role`
--

LOCK TABLES `Role` WRITE;
/*!40000 ALTER TABLE `Role` DISABLE KEYS */;
INSERT INTO `Role` VALUES (1,'Hr'),(2,'Trainee'),(3,'Trainee'),(4,'Hr');
/*!40000 ALTER TABLE `Role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Role2`
--

DROP TABLE IF EXISTS `Role2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Role2` (
  `role_id` varchar(45) NOT NULL,
  `role_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Role2`
--

LOCK TABLES `Role2` WRITE;
/*!40000 ALTER TABLE `Role2` DISABLE KEYS */;
INSERT INTO `Role2` VALUES ('0',NULL),('A','Admin'),('E','Employee'),('H','HR Manager'),('P','Project Manager'),('T','Team Lead');
/*!40000 ALTER TABLE `Role2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Student`
--

DROP TABLE IF EXISTS `Student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Student` (
  `id` int NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `dept` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Student`
--

LOCK TABLES `Student` WRITE;
/*!40000 ALTER TABLE `Student` DISABLE KEYS */;
/*!40000 ALTER TABLE `Student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TaskList`
--

DROP TABLE IF EXISTS `TaskList`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TaskList` (
  `Proj_id` varchar(45) NOT NULL,
  `Task_id` varchar(45) DEFAULT NULL,
  `Task_name` varchar(45) DEFAULT NULL,
  `Task_description` varchar(45) DEFAULT NULL,
  `Duration` varchar(45) DEFAULT NULL,
  `Task_status` varchar(45) DEFAULT NULL,
  `Task_createdby` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Proj_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TaskList`
--

LOCK TABLES `TaskList` WRITE;
/*!40000 ALTER TABLE `TaskList` DISABLE KEYS */;
INSERT INTO `TaskList` VALUES ('Amaz10','Whis11','WhishList Page','Every constomer have whishList','16 hours','C','JNamala080900'),('Flip10','Regi11','Registration','Every constomer have to register','24 hours','A','KBattula150400'),('Uber10','Logi11','Login page','Login is required to use this app','36 hours','A','KBattula150400');
/*!40000 ALTER TABLE `TaskList` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `demo2`
--

DROP TABLE IF EXISTS `demo2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `demo2` (
  `fname` varchar(45) NOT NULL,
  `lname` varchar(45) NOT NULL,
  `ph` varchar(45) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `pin` varchar(45) DEFAULT NULL,
  `branch` varchar(45) DEFAULT NULL,
  `dep` varchar(45) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `dob` varchar(45) DEFAULT NULL,
  `salary` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ph`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `demo2`
--

LOCK TABLES `demo2` WRITE;
/*!40000 ALTER TABLE `demo2` DISABLE KEYS */;
INSERT INTO `demo2` VALUES ('Vijaya','Battula','1234567890','VBattula@miraclesoft.com','533408','ECE','ECE','VBattula0701','VijaBatt12:22:50.942742643','070102','20000');
/*!40000 ALTER TABLE `demo2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emp`
--

DROP TABLE IF EXISTS `emp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emp` (
  `id` int NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emp`
--

LOCK TABLES `emp` WRITE;
/*!40000 ALTER TABLE `emp` DISABLE KEYS */;
INSERT INTO `emp` VALUES (5930,''),(5937,'vijju'),(5939,'shab');
/*!40000 ALTER TABLE `emp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employ`
--

DROP TABLE IF EXISTS `employ`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employ` (
  `id` int NOT NULL,
  `firstname` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `designation` varchar(45) DEFAULT NULL,
  `phno` varchar(45) DEFAULT NULL,
  `salary` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employ`
--

LOCK TABLES `employ` WRITE;
/*!40000 ALTER TABLE `employ` DISABLE KEYS */;
INSERT INTO `employ` VALUES (1,'vijaya','battula','trainee','848571859','20000'),(1,'vijaya','battula','trainee','848571859','20000'),(2,'shabana','shaik','trainee','787964386','19000'),(3,'sirisha','sarapilli','trainee','7874537678','19000');
/*!40000 ALTER TABLE `employ` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `id` int DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `role` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'Vijaya','Trainee','v@1'),(2,'Shabana','Trainee','s@2'),(3,'Sunitha','Trainer','s@1'),(4,'Sirisha','Trainee','siri@3'),(6,'Kumar','Trainer','R@2');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `id` int NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  `role` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (1,'123','Hr'),(2,'s@123','Hr'),(3,'M1racle@123','Trainee'),(5,'M1racle@123','Trainer'),(7,'M1racle@123','Hr'),(8,'M1racle@123','Trainer'),(9,'M1racle@123','Trainer');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loginhr`
--

DROP TABLE IF EXISTS `loginhr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loginhr` (
  `id` varchar(45) NOT NULL,
  `fname` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `role` varchar(50) DEFAULT NULL,
  `salary` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loginhr`
--

LOCK TABLES `loginhr` WRITE;
/*!40000 ALTER TABLE `loginhr` DISABLE KEYS */;
INSERT INTO `loginhr` VALUES ('1','vijaya','vijju@gmail.com','Hr','20000'),('2','Sunitha','Suni@gmail.com','Hr','25000'),('3','shabana','sh@gmail.com','Trainee','20000'),('5','Kumar','k@gmail.com','Trainer','35000'),('7','Ram','r@gmail.com','Hr','50000'),('8','Sai','sa@gmail.com','Trainer','25000'),('9','durga','d@gmail.com','Trainer','20000');
/*!40000 ALTER TABLE `loginhr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` int DEFAULT NULL,
  `pswd` varchar(45) DEFAULT NULL,
  `role` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'vijaya','Trainee'),(3,'Sunitha','Trainer'),(5,'Ram','Hr'),(201,'Vijju@1','Hr');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `st`
--

DROP TABLE IF EXISTS `st`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `st` (
  `id` int DEFAULT NULL,
  `name` varchar(25) DEFAULT NULL,
  `marks` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `st`
--

LOCK TABLES `st` WRITE;
/*!40000 ALTER TABLE `st` DISABLE KEYS */;
INSERT INTO `st` VALUES (5937,'vijaya',98),(5937,'vijaya',98),(5939,'shabana',97),(5937,'vijaya',98),(5939,'shabana',97),(5938,'siri',97),(5936,'anjali',96),(5920,'deekshitha',96);
/*!40000 ALTER TABLE `st` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stud`
--

DROP TABLE IF EXISTS `stud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stud` (
  `id` int NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `dept` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stud`
--

LOCK TABLES `stud` WRITE;
/*!40000 ALTER TABLE `stud` DISABLE KEYS */;
INSERT INTO `stud` VALUES (1,'Vijaya','ECE'),(2,'Shabana','CSE'),(3,'Siri','CSE');
/*!40000 ALTER TABLE `stud` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `id` int DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `dept` varchar(20) DEFAULT NULL,
  `salary` int DEFAULT NULL,
  `work` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (5937,'Vijaya','ECE',15000,'Trainee'),(5938,'Sirisha','CSE',11500,'Trainee'),(5939,'Shabana','CSE',11000,'Trainee'),(5935,'Sirisha','ECE',11000,'Trainee'),(5936,'Anjali','CSE',13000,'Trainee'),(5930,'Deekshitha','CSE',18000,'Trainee'),(5931,'lucky','CSE',18000,'Trainee');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-15 11:21:36
