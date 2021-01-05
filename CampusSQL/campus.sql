-- MySQL dump 10.13  Distrib 5.5.54, for Win64 (AMD64)
--
-- Host: localhost    Database: campus
-- ------------------------------------------------------
-- Server version	5.5.54

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
-- Table structure for table `school`
--

DROP TABLE IF EXISTS `school`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `school` (
  `sch_name` varchar(80) DEFAULT NULL,
  `sch_sno` varchar(20) DEFAULT NULL,
  UNIQUE KEY `sch_sno` (`sch_sno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `school`
--

LOCK TABLES `school` WRITE;
/*!40000 ALTER TABLE `school` DISABLE KEYS */;
INSERT INTO `school` VALUES ('河北科技师范学院','0951160718');
/*!40000 ALTER TABLE `school` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task`
--

DROP TABLE IF EXISTS `task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task` (
  `title` varchar(40) CHARACTER SET gbk DEFAULT NULL,
  `content` varchar(100) CHARACTER SET gbk DEFAULT NULL,
  `username` varchar(30) CHARACTER SET gbk DEFAULT NULL,
  `status` varchar(2) CHARACTER SET gbk DEFAULT '1',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `receive_time` datetime DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `phone_number` varchar(20) CHARACTER SET gbk DEFAULT NULL,
  `other_name` varchar(40) DEFAULT NULL,
  `address` varchar(100) CHARACTER SET gbk DEFAULT NULL,
  `radio_title` varchar(50) DEFAULT NULL,
  `radio` varchar(50) DEFAULT NULL,
  `id` int(10) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task`
--

LOCK TABLES `task` WRITE;
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
INSERT INTO `task` VALUES ('圆通快递','拿小包裹，广顺楼下','niu','1','2017-06-11 14:35:41',NULL,0,'15800764949',NULL,'送到x号宿舍楼','0','悬赏',34),('菜鸟驿站','大食堂边，学校内，小包裹','niu','4','2017-06-11 14:37:29','2017-06-11 22:43:43',10,'15039749914','test','送到北宿舍楼','快递','悬赏',35),('学校南门','半小时之后到','niu','4','2017-06-11 14:40:24','2017-06-11 22:44:58',20,'15303215555','test','订的是鸡公煲，送到x宿舍楼','外卖','悬赏',36),('毕业生聚会','16号晚上6点在誉漫庄园','test','1','2017-06-11 14:42:00',NULL,10,'18181858712',NULL,'','外卖','悬赏',37),('京东快递','校医院东边，一个小快递，校内','niu','1','2017-06-11 14:42:03',NULL,10,'15738987744',NULL,'编号166，拿到1号宿舍楼','快递','悬赏',38),('快递','黑色包裹一个','test','1','2017-06-11 14:43:19',NULL,50,'15791576676',NULL,'','快递','悬赏',39),('顺丰','医务室东侧知遇书屋黑色包裹','test','1','2017-06-11 14:48:10',NULL,186,'15746563333',NULL,'手机尾号3333送到北上广\n\n','快递','悬赏',40);
/*!40000 ALTER TABLE `task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `username` varchar(40) DEFAULT NULL,
  `password` varchar(40) DEFAULT NULL,
  `sno` varchar(30) NOT NULL DEFAULT '',
  `phonenumber` varchar(20) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `score` int(11) DEFAULT '0',
  PRIMARY KEY (`sno`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `phonenumber` (`phonenumber`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('niu','123456','0951','15304558886','2017-06-11 22:33:14','2017-06-11 16:36:40',30),('test3','123456','09511607','15555555555','2017-06-10 20:27:24','2017-06-10 13:11:28',50),('nou','123456','0951160718','55555555555','2017-06-10 21:15:20','2017-06-11 14:06:46',5),('test2','123456','09511609','15533555555','2017-06-10 20:27:41','2017-06-10 12:38:53',10),('123r','123456','123','123','2017-05-17 15:06:55','2017-06-10 03:18:34',100),('test1','123456','1234','1235','2017-05-17 15:29:52','2017-06-11 09:30:36',111),('test4','123456','12345','15554776444','2017-06-10 20:31:32','2017-06-10 12:31:32',0),('test','test','sno','phonenumber','2017-05-17 14:59:17','2017-06-11 14:48:10',0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-12  7:44:45
