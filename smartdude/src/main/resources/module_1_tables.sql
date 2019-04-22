-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: smartdude
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `locationdetail`
--

DROP TABLE IF EXISTS `locationdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `locationdetail` (
  `locationid` int(11) NOT NULL AUTO_INCREMENT,
  `state` varchar(30) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `area` varchar(45) DEFAULT NULL,
  `landmark` varchar(45) DEFAULT NULL,
  `building` varchar(30) DEFAULT NULL,
  `floor` varchar(10) DEFAULT NULL,
  `block` varchar(10) DEFAULT NULL,
  `vendorid` int(11) DEFAULT NULL,
  PRIMARY KEY (`locationid`),
  KEY `vendorid_idx` (`vendorid`),
  CONSTRAINT `vendorid` FOREIGN KEY (`vendorid`) REFERENCES `vendor` (`vendorid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `locationqmanagerassociation`
--

DROP TABLE IF EXISTS `locationqmanagerassociation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `locationqmanagerassociation` (
  `locqmanagerassociationid` int(11) NOT NULL AUTO_INCREMENT,
  `activestatus` tinyint(1) DEFAULT NULL,
  `qmanagerid` int(11) DEFAULT NULL,
  `locationid` int(11) DEFAULT NULL,
  `createdtimestamp` datetime DEFAULT NULL,
  `updatedtimestamp` datetime DEFAULT NULL,
  PRIMARY KEY (`locqmanagerassociationid`),
  KEY `locid_idx` (`locationid`),
  KEY `qmanagerid_idx` (`qmanagerid`),
  CONSTRAINT `locid` FOREIGN KEY (`locationid`) REFERENCES `locationdetail` (`locationid`),
  CONSTRAINT `qmanagerid` FOREIGN KEY (`qmanagerid`) REFERENCES `queuemanager` (`qmanagerid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `queue`
--

DROP TABLE IF EXISTS `queue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `queue` (
  `queueid` int(11) NOT NULL AUTO_INCREMENT,
  `queuename` varchar(100) DEFAULT NULL,
  `loctionqmanagerassociationid` int(11) DEFAULT NULL,
  `queuestarttime` datetime DEFAULT NULL,
  `queueendtime` datetime DEFAULT NULL,
  `activestatus` tinyint(1) DEFAULT NULL,
  `createddatetime` datetime DEFAULT NULL,
  `createdmanagerid` int(11) DEFAULT NULL,
  `lastupdatetime` datetime DEFAULT NULL,
  PRIMARY KEY (`queueid`),
  UNIQUE KEY `queuename` (`queuename`),
  KEY `lqmassociation_idx` (`loctionqmanagerassociationid`),
  CONSTRAINT `lqmassociation` FOREIGN KEY (`loctionqmanagerassociationid`) REFERENCES `locationqmanagerassociation` (`locqmanagerassociationid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `queuemanager`
--

DROP TABLE IF EXISTS `queuemanager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `queuemanager` (
  `qmanagerid` int(11) NOT NULL AUTO_INCREMENT,
  `qmanagername` varchar(45) DEFAULT NULL,
  `qmanagerphonenumber` varchar(45) DEFAULT NULL,
  `qmanageremailid` varchar(45) DEFAULT NULL,
  `qmanagerpassword` varchar(400) DEFAULT NULL,
  `vendorid` int(11) DEFAULT NULL,
  `createdtimestamp` datetime DEFAULT NULL,
  `updatedtimestamp` datetime DEFAULT NULL,
  PRIMARY KEY (`qmanagerid`),
  KEY `vendorid_idx` (`vendorid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `rolecode` varchar(30) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  PRIMARY KEY (`role_id`),
  KEY `userid_idx` (`userid`),
  CONSTRAINT `userid` FOREIGN KEY (`userid`) REFERENCES `user` (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `service`
--

DROP TABLE IF EXISTS `service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `service` (
  `serviceid` int(11) NOT NULL AUTO_INCREMENT,
  `servicename` varchar(45) DEFAULT NULL,
  `noofserves` int(11) DEFAULT NULL,
  `units` int(11) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `altertquantity` int(11) DEFAULT NULL,
  `createdtimestamp` datetime DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `updatedtimestamp` datetime DEFAULT NULL,
  `queueid` int(11) DEFAULT NULL,
  PRIMARY KEY (`serviceid`),
  KEY `queueid_idx` (`queueid`),
  CONSTRAINT `queueid` FOREIGN KEY (`queueid`) REFERENCES `queue` (`queueid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `userID` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(45) DEFAULT NULL,
  `password` varchar(400) DEFAULT NULL,
  `client_code` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `vendor`
--

DROP TABLE IF EXISTS `vendor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `vendor` (
  `vendorid` int(11) NOT NULL AUTO_INCREMENT,
  `vendorcode` varchar(45) DEFAULT NULL,
  `vendorname` varchar(45) DEFAULT NULL,
  `organizationtype` varchar(45) DEFAULT NULL,
  `organizationname` varchar(45) DEFAULT NULL,
  `createdtimestamp` datetime DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `password` varchar(400) DEFAULT NULL,
  `phonenumber` varchar(15) DEFAULT NULL,
  `authendicatedtime` datetime DEFAULT NULL,
  PRIMARY KEY (`vendorid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-22 23:35:47
