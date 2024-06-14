/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.7.17-log : Database - a202453
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`a202453` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `a202453`;

/*Table structure for table `attence` */

DROP TABLE IF EXISTS `attence`;

CREATE TABLE `attence` (
  `attenceid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `address` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `remark1` text COLLATE utf8_bin,
  `remark2` text COLLATE utf8_bin,
  `type` int(11) DEFAULT '0',
  PRIMARY KEY (`attenceid`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `attence` */

/*Table structure for table `banners` */

DROP TABLE IF EXISTS `banners`;

CREATE TABLE `banners` (
  `bannersid` int(11) NOT NULL AUTO_INCREMENT,
  `pos` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `pic` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`bannersid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `banners` */

insert  into `banners`(`bannersid`,`pos`,`pic`,`status`) values (5,'2','15752923406303.png',0),(6,'1','1576143306866a.jpg',1),(7,'3','1576143325438b.jpg',1);

/*Table structure for table `cang` */

DROP TABLE IF EXISTS `cang`;

CREATE TABLE `cang` (
  `cangid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `targetid` int(11) DEFAULT NULL,
  `remark1` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`cangid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `cang` */

insert  into `cang`(`cangid`,`userid`,`targetid`,`remark1`) values (7,2,6,NULL);

/*Table structure for table `discuss` */

DROP TABLE IF EXISTS `discuss`;

CREATE TABLE `discuss` (
  `discussid` int(11) NOT NULL AUTO_INCREMENT,
  `content` text COLLATE utf8_bin,
  `userid` int(11) DEFAULT NULL,
  `dtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` int(11) DEFAULT NULL,
  `remark1` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `targetid` int(11) DEFAULT NULL,
  PRIMARY KEY (`discussid`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `discuss` */

/*Table structure for table `fornum` */

DROP TABLE IF EXISTS `fornum`;

CREATE TABLE `fornum` (
  `fornumid` int(11) NOT NULL AUTO_INCREMENT,
  `title` text COLLATE utf8_bin,
  `content` text COLLATE utf8_bin,
  `sendtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `urls` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `remark1` text COLLATE utf8_bin,
  PRIMARY KEY (`fornumid`)
) ENGINE=InnoDB AUTO_INCREMENT=60019 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `fornum` */

insert  into `fornum`(`fornumid`,`title`,`content`,`sendtime`,`urls`,`userid`,`status`,`remark1`) values (60016,'1','健康啦','2024-04-10 21:18:23','1616686091386110000276_2.jpg',2,0,'选择相册'),(60017,'1','最近忙健身了','2024-04-10 21:18:26','1618125386836110000276_3.jpg',2,1,'12:12'),(60018,'1','cvvbbbbbb','2024-04-10 21:18:32','',2,1,'17:13');

/*Table structure for table `friends` */

DROP TABLE IF EXISTS `friends`;

CREATE TABLE `friends` (
  `friendsid` int(11) NOT NULL AUTO_INCREMENT,
  `senduserid` int(11) DEFAULT NULL,
  `touserid` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `remark1` text COLLATE utf8_bin,
  PRIMARY KEY (`friendsid`),
  UNIQUE KEY `senduserid` (`senduserid`,`touserid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `friends` */

insert  into `friends`(`friendsid`,`senduserid`,`touserid`,`status`,`remark1`) values (7,2,4,NULL,NULL);

/*Table structure for table `health` */

DROP TABLE IF EXISTS `health`;

CREATE TABLE `health` (
  `healthid` int(11) NOT NULL AUTO_INCREMENT,
  `age` int(11) DEFAULT NULL,
  `sex` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `xuey` double DEFAULT NULL,
  `xuet` double DEFAULT NULL,
  `xuez` double DEFAULT NULL,
  `xueg` double DEFAULT NULL,
  `remark1` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `sendtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`healthid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `health` */

insert  into `health`(`healthid`,`age`,`sex`,`xuey`,`xuet`,`xuez`,`xueg`,`remark1`,`userid`,`sendtime`) values (1,22,'男',60,50,20,30,'',2,'2024-04-10 20:21:42'),(2,23,'男',50,100,26,23,'',2,'2024-04-10 20:21:42');

/*Table structure for table `news` */

DROP TABLE IF EXISTS `news`;

CREATE TABLE `news` (
  `newsid` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `content` text COLLATE utf8_bin,
  `sendtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userid` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `readcount` int(11) DEFAULT NULL,
  `follow` int(11) DEFAULT NULL,
  PRIMARY KEY (`newsid`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `news` */

insert  into `news`(`newsid`,`title`,`content`,`sendtime`,`userid`,`status`,`readcount`,`follow`) values (21,'基于移动互联的老年医护管理','<p><strong><span style=\"font-family: 宋体;font-size: 14px\">基于移动互联的老年医护管理</span></strong></p><p><strong><span style=\"font-family: 宋体;font-size: 14px\">基于移动互联的老年医护管理</span></strong></p><p><strong><span style=\"font-family: 宋体;font-size: 14px\">基于移动互联的老年医护管理</span></strong></p><p><strong><span style=\"font-family: 宋体;font-size: 14px\">基于移动互联的老年医护管理</span></strong></p><p><br/></p>','2024-04-10 19:32:03',2,0,2,0);

/*Table structure for table `praise` */

DROP TABLE IF EXISTS `praise`;

CREATE TABLE `praise` (
  `praiseid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `targetid` int(11) DEFAULT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`praiseid`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `praise` */

insert  into `praise`(`praiseid`,`userid`,`targetid`,`time`) values (22,4,60016,'2024-04-10 21:20:35');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `nickname` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `sex` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `tel` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `userno` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `userLevel` int(11) DEFAULT NULL,
  `address` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `headPic` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `remark1` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `remark2` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `height` double DEFAULT '0',
  `weight` double DEFAULT '0',
  PRIMARY KEY (`userid`),
  UNIQUE KEY `username` (`username`,`tel`,`userno`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `user` */

insert  into `user`(`userid`,`username`,`nickname`,`password`,`sex`,`age`,`tel`,`userno`,`userLevel`,`address`,`headPic`,`remark1`,`remark2`,`height`,`weight`) values (1,'admin','admin','admin','男',18,'10086',NULL,3,'江西',NULL,NULL,NULL,1.76,55),(2,'test01','李四','123456','男',23,'13112121212',NULL,2,'南昌','1573723617176h1.jpg',NULL,NULL,1.75,65),(4,'test001','tim','123456','女',19,'13112121212','2',1,'江西','1575983096166IMG_20191210_125424.jpg',NULL,NULL,1.75,76),(5,'test002','tom','123456','女',18,'13112121212','2',1,'江西','1575983696667IMG_20191210_125424.jpg',NULL,NULL,1.75,67);

/*Table structure for table `xiu` */

DROP TABLE IF EXISTS `xiu`;

CREATE TABLE `xiu` (
  `xiuid` int(11) NOT NULL AUTO_INCREMENT,
  `stime` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `etime` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `title` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `remark1` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`xiuid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `xiu` */

insert  into `xiu`(`xiuid`,`stime`,`etime`,`title`,`userid`,`remark1`) values (1,'22:34','0:34','999感冒灵',4,'一日2次，每次2片');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
