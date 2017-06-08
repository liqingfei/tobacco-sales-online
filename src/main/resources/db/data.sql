-- MySQL dump 10.13  Distrib 5.7.16, for osx10.12 (x86_64)
--
-- Host: localhost    Database: tobacco
-- ------------------------------------------------------
-- Server version	5.7.16

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
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES ('E4020B769DA1491EA617898D14E323BD','admin','1AA9BC4AC2294C798EF60FB11E23C56D',3,5.64,1,'2017-06-08 01:30:21');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tobacco`
--

LOCK TABLES `tobacco` WRITE;
/*!40000 ALTER TABLE `tobacco` DISABLE KEYS */;
INSERT INTO `tobacco` VALUES ('0D1FDD6C270D437E80DBC7C796FC7ABB','黄鹤楼','云南卷烟厂','xx',18.8,'This is test create2','2017-06-07 07:22:09'),('1AA9BC4AC2294C798EF60FB11E23C56D','黄鹤楼','云南卷烟厂','xx',18.8,'This is test create','2017-06-07 07:17:23'),('1EC9B22ED37C445C8A3D21CF106EF264','黄鹤楼','云南卷烟厂','xx',18.8,'This is test create4','2017-06-07 07:27:43'),('FD1F774749BD4835BBF12A3349BC734E','黄鹤楼','云南卷烟厂','xx',18.8,'This is test update2','2017-06-08 01:28:43');
/*!40000 ALTER TABLE `tobacco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tobacco_quantity`
--

LOCK TABLES `tobacco_quantity` WRITE;
/*!40000 ALTER TABLE `tobacco_quantity` DISABLE KEYS */;
INSERT INTO `tobacco_quantity` VALUES (3,'1AA9BC4AC2294C798EF60FB11E23C56D',2000,1,'2017-06-07 07:17:24'),(4,'0D1FDD6C270D437E80DBC7C796FC7ABB',2000,1,'2017-06-07 07:22:09'),(5,'FD1F774749BD4835BBF12A3349BC734E',2000,1,'2017-06-08 01:28:43'),(6,'1EC9B22ED37C445C8A3D21CF106EF264',2000,1,'2017-06-07 07:27:43');
/*!40000 ALTER TABLE `tobacco_quantity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_attrs`
--

LOCK TABLES `user_attrs` WRITE;
/*!40000 ALTER TABLE `user_attrs` DISABLE KEYS */;
INSERT INTO `user_attrs` VALUES ('admin','email','admin@test.com','2017-06-06 08:20:44'),('admin','phone','11111111','2017-06-06 08:20:44'),('test','email','test@test.com','2017-06-08 01:35:04');
/*!40000 ALTER TABLE `user_attrs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES ('admin','admin','2017-06-06 07:46:19'),('test','user','2017-06-08 01:33:55');
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('admin','21232f297a57a5a743894a0e4a801fc3',1,'2017-06-08 01:28:21'),('test','098f6bcd4621d373cade4e832627b4f6',1,'2017-06-08 01:34:21');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-08  9:51:47
