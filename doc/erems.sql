-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: erems
-- ------------------------------------------------------
-- Server version	5.7.15-log

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
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `num` varchar(3) DEFAULT '000' COMMENT '编号',
  `province` varchar(45) DEFAULT NULL COMMENT '省',
  `city` varchar(45) DEFAULT NULL COMMENT '市',
  `detail` varchar(45) DEFAULT NULL COMMENT '详情',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (0,'000','中国','',NULL),(1,'001','江西省','南昌市',''),(2,'002','福建省','福州市',NULL),(3,'003','湖北省','武汉市',NULL);
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exam`
--

DROP TABLE IF EXISTS `exam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exam` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL DEFAULT '考试' COMMENT '考试名称',
  `description` varchar(3000) DEFAULT '描述' COMMENT '考试信息描述',
  `time` datetime DEFAULT NULL COMMENT '考试时间',
  `outed` tinyint(2) DEFAULT '0' COMMENT '过期标志，0未过期，1过期',
  PRIMARY KEY (`id`)user
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exam`
--

LOCK TABLES `exam` WRITE;
/*!40000 ALTER TABLE `exam` DISABLE KEYS */;
INSERT INTO `exam` VALUES (1,'四六级考试','高等教育考试','2018-06-20 09:00:00',0),(2,'公务员考试','公务员',NULL,0),(3,'中小学教师资格考试','中小学教师资格考试',NULL,0),(4,'非学历证书考试','非学历证书考试',NULL,0),(5,'全国计算机等级考试','全国计算机等级考试',NULL,0),(6,'专业技能课程考试','专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试','2018-05-19 09:00:00',1),(7,'专业英语四级考试','专业英语四级考试','2018-06-19 09:00:00',0),(8,'专业英语八级考试','专业英语八级考试','2018-06-19 15:00:00',0),(9,'音乐技能考试','音乐专业技能课程考试音乐专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试专业技能课程考试试','2018-05-19 09:00:00',0),(10,'xxx','xxx','2018-05-19 09:00:00',0);
/*!40000 ALTER TABLE `exam` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `myexam`
--

DROP TABLE IF EXISTS `myexam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `myexam` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '个人考试项信息id',
  `user_id` int(11) NOT NULL COMMENT '考生id',
  `exam_id` int(11) NOT NULL COMMENT '考试id',
  `pay` tinyint(2) DEFAULT '0' COMMENT '支付:0未支付，1支付',
  `score` int(11) DEFAULT '-1' COMMENT '考试分数，负数代表未进行考试',
  `time` date DEFAULT NULL COMMENT '考试时间',
  `exam_num` varchar(12) DEFAULT NULL COMMENT '考号：地点：001+考点：001+考室：01+位置：30',
  `room_num` varchar(12) DEFAULT NULL COMMENT '考场号',
  `address` int(11) DEFAULT '0' COMMENT '考试地点',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `myexam`
--

LOCK TABLES `myexam` WRITE;
/*!40000 ALTER TABLE `myexam` DISABLE KEYS */;
INSERT INTO `myexam` VALUES (1,1,1,1,99,NULL,'0010010101','00100101',1),(2,1,2,1,99,NULL,NULL,NULL,1),(4,1,2,1,-1,NULL,'0010010102','00100101',1),(5,1,3,1,100,NULL,NULL,NULL,1),(8,1,2,0,-1,NULL,NULL,NULL,1),(10,1,3,1,-1,NULL,NULL,NULL,1),(11,2,1,1,-1,NULL,'0010010102','00100101',1),(12,10,2,1,-1,NULL,NULL,NULL,2),(13,11,1,1,-1,NULL,'0030010101','00300101',3),(14,2,2,1,-1,NULL,NULL,NULL,0),(15,2,3,1,-1,NULL,NULL,NULL,0),(16,2,4,1,-1,NULL,NULL,NULL,0),(17,1,7,1,-1,NULL,NULL,NULL,0),(18,3,2,1,-1,NULL,NULL,NULL,0);
/*!40000 ALTER TABLE `myexam` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `room` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `num` varchar(5) DEFAULT '001' COMMENT '编号：前三位考点名，后两位考室名',
  `name` varchar(45) DEFAULT NULL COMMENT '考点名称',
  `size` int(11) DEFAULT '10' COMMENT '考点大小，考室数量',
  `address_id` int(11) DEFAULT NULL COMMENT '归属区域',
  `detail` varchar(45) DEFAULT NULL COMMENT '详情',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES (1,'001','南昌市第一中学',35,1,''),(2,'002','南昌市第二中学',40,1,''),(3,'003','南昌市第三中学',10,1,NULL),(4,'001','福州市第一中学',30,2,NULL),(5,'002','福州市第二中学',20,2,NULL),(6,'001','武汉市第一中学',15,3,NULL),(7,'002','武汉市第二中学',20,3,NULL),(8,'003','xxx',20,3,'');
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL COMMENT '真实姓名',
  `username` varchar(45) NOT NULL COMMENT '用户名',
  `password` varchar(45) NOT NULL COMMENT '密码',
  `sex` char(2) DEFAULT NULL COMMENT '性别',
  `idnumber` varchar(45) DEFAULT NULL COMMENT '身份证号',
  `eduback` varchar(45) DEFAULT NULL COMMENT '教育背景',
  `address` int(11) DEFAULT '0' COMMENT '0，默认中国',
  `email` varchar(45) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(11) DEFAULT NULL,
  `perimage` varchar(255) DEFAULT NULL COMMENT '存储照片名称',
  `role` smallint(6) DEFAULT '2' COMMENT '用户类型：0-管理员，1-老师，2-考生',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'test1','test1','test1','男','1','本科',0,'1@1.com','18700011122','QQ图片20160719212506.png',2),(2,'test2','test2','test2','女','1','1',1,'1@1.com','1','QQ图片20170118234123.jpg',2),(3,'test3','test3','test3','男','0','',1,'1@1.com','1','QQ图片20160719212506.png',2),(4,'m1','m1','m1','女','222','',2,'1@1.com','1211',NULL,1),(5,'admin','admin','admin','男','','',2,'1@1.com','',NULL,0),(6,'t1','t1','t1','女','','',2,'12xxxx3476@qq.com','1222',NULL,2),(7,'图','t2','t2','女','','',2,'12xxxx3476@qq.com','',NULL,2),(10,'t3','t3','t3','女','','',2,'1@1.com','',NULL,2),(11,'t4','t4','t4','男','','',2,'12xxxx3476@qq.com','',NULL,2),(14,NULL,'lyh','lyh',NULL,NULL,NULL,0,NULL,'123',NULL,2),(15,NULL,'zrq','zrq',NULL,NULL,NULL,0,NULL,'123',NULL,2);
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

-- Dump completed on 2018-06-08 18:28:28
-- add by hyx
DROP TABLE IF EXISTS `paper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
create table `paper`(
`id` int(5) NOT NULL AUTO_INCREMENT,
`name` varchar(20) NOT NULL DEFAULT '试卷' COMMENT '试卷名称',
`time` datetime DEFAULT NULL COMMENT '发布时间',
`user_name` varchar(10) NOT NULL DEFAULT '出卷人' COMMENT '出卷人姓名',
`outed` int(1) NOT NULL DEFAULT 0,
PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

INSERT INTO `paper` VALUES('00001', '2020年全国大学生英语六级考试', '2020-06-20 09:00:00', '张三', 0);
INSERT INTO `paper` VALUES('00002', '2021年全国大学生英语六级考试', '2021-06-20 09:00:00', '李四', 0);
INSERT INTO `paper` VALUES('00003', '2022年全国大学生英语六级考试', '2022-06-20 09:00:00', '王五', 0);

DROP TABLE IF EXISTS `mypaper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
create table `mypaper`(
`id` int(5) NOT NULL AUTO_INCREMENT,
`paperid` int(5) NOT NULL COMMENT '试卷id',
`userid` int(11) NOT NULL COMMENT '学生id',
`score` int(3) DEFAULT NULL COMMENT '分数',
`pay` int(1) NOT NULL DEFAULT 0,
`outed` int(1) NOT NULL DEFAULT 0,
PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


-- 选择题
DROP TABLE IF EXISTS `selectquestions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
create table `selectquestions`(
`id` int(3) NOT NULL AUTO_INCREMENT,
`paperid` int(5) NOT NULL COMMENT '试卷id',
`question` varchar(500) NOT NULL COMMENT '题干内容',
`answer` int(1) NOT NULL COMMENT '正确答案',
`selectA` varchar(200) NOT NULL COMMENT '选项A',
`selectB` varchar(200) NOT NULL COMMENT '选项B',
`selectC` varchar(200) NOT NULL COMMENT '选项C',
`selectD` varchar(200) NOT NULL COMMENT '选项D',
PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
insert into `selectquestions` values
(1, 1, 'The first selectQuestion here: xxxx xxxx xxxx?', 1, 'answer A', 'answer B', 'answer C', 'answer D');
insert into `selectquestions` values
(2, 2,'The second selectQuestion here: xxxx xxxx xxxx?', 2, 'answer A', 'answer B', 'answer C', 'answer D');
insert into `selectquestions` values
(3, 1,'The third selectQuestion here: xxxx xxxx xxxx?', 3, 'answer A', 'answer B', 'answer C', 'answer D');
insert into `selectquestions` values
(4, 2,'The fourth selectQuestion here: xxxx xxxx xxxx?', 0, 'answer A', 'answer B', 'answer C', 'answer D');

-- 主观题
DROP TABLE IF EXISTS `fillquestions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
create table `fillquestions`(
`id` int(3) NOT NULL AUTO_INCREMENT,
`paperid` int(5) DEFAULT '00000' COMMENT '试卷id',
`question` varchar(500) NOT NULL COMMENT '题干内容',
`answer` varchar(500) NOT NULL COMMENT '正确答案',
PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
insert into `fillquestions` values
(1, 1, 'The first fillQuestion here: xxxx xxxx xxxx?', 'This is answer for the first question.');
insert into `fillquestions` values
(2, 2, 'The second fillQuestion here: xxxx xxxx xxxx?', 'This is answer for the second question.');
insert into `fillquestions` values
(3, 1, 'The third fillQuestion here: xxxx xxxx xxxx?', 'This is answer for the third question.');
insert into `fillquestions` values
(4, 2, 'The fourth fillQuestion here: xxxx xxxx xxxx?', 'This is answer for the fourth question.');

-- 选择题答卷
DROP TABLE IF EXISTS `selectanswers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
create table `selectanswers`(
`id` int(3) NOT NULL AUTO_INCREMENT,
`studentid` int(11) NOT NULL COMMENT '学生id',
`paperid` int(5) DEFAULT '00000' COMMENT '试卷id',
`questionid` int(3) NOT NULL COMMENT '题目id',
`answer` int(1) NOT NULL COMMENT '作答内容',
PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- 填空题答卷
DROP TABLE IF EXISTS `fillanswers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
create table `fillanswers`(
`id` int(3) NOT NULL AUTO_INCREMENT,
`studentid` int(11) NOT NULL COMMENT '学生id',
`paperid` int(5) DEFAULT '00000' COMMENT '试卷id',
`questionid` int(3) NOT NULL COMMENT '题目id',
`answer` varchar(100) NOT NULL COMMENT '作答内容',
PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;