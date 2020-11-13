-- 用户表
DROP TABLE IF EXISTS `mb_user`;
CREATE TABLE `mb_user` (
  `id` int(11) NOT NULL auto_increment,
  `username` varchar(32) NOT NULL COMMENT '用户名称',
  `birthday` datetime default NULL COMMENT '生日',
  `sex` char(1) default NULL COMMENT '性别',
  `address` varchar(256) default NULL COMMENT '地址',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert  into `mb_user`(`id`,`username`,`birthday`,`sex`,`address`) values (41,'老王','2018-02-27 17:47:08','男','北京'),(42,'小二王','2018-03-02 15:09:37','女','北京金燕龙'),(43,'小二王','2018-03-04 11:34:34','女','北京金燕龙'),(45,'传智播客','2018-03-04 12:04:06','男','北京金燕龙'),(46,'老王','2018-03-07 17:37:26','男','北京'),(48,'小马宝莉','2018-03-08 11:44:00','女','北京修正');

-- 账户表
DROP TABLE IF EXISTS `mb_account`;
CREATE TABLE `mb_account` (
  `ID` INT(11) NOT NULL COMMENT '编号',
  `UID` INT(11) DEFAULT NULL COMMENT '用户编号',
  `MONEY` DOUBLE DEFAULT NULL COMMENT '金额',
  PRIMARY KEY  (`ID`),
  KEY `FK_Reference_8` (`UID`),
  CONSTRAINT `FK_Reference_8` FOREIGN KEY (`UID`) REFERENCES `mb_user` (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;
INSERT  INTO `mb_account`(`ID`,`UID`,`MONEY`) VALUES (1,41,1000),(2,45,1000),(3,41,2000);

-- 角色表
DROP TABLE IF EXISTS `mb_role`;
CREATE TABLE `mb_role` (
  `ID` INT(11) NOT NULL COMMENT '编号',
  `ROLE_NAME` VARCHAR(30) DEFAULT NULL COMMENT '角色名称',
  `ROLE_DESC` VARCHAR(60) DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY  (`ID`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;
INSERT  INTO `mb_role`(`ID`,`ROLE_NAME`,`ROLE_DESC`) VALUES (1,'院长','管理整个学院'),(2,'总裁','管理整个公司'),(3,'校长','管理整个学校');

-- 用户与角色关系表 多对多第三张表
DROP TABLE IF EXISTS `mb_user_role`;
CREATE TABLE `mb_user_role` (
  `UID` INT(11) NOT NULL COMMENT '用户编号',
  `RID` INT(11) NOT NULL COMMENT '角色编号',
  PRIMARY KEY  (`UID`,`RID`),
  KEY `FK_Reference_10` (`RID`),
  CONSTRAINT `FK_Reference_10` FOREIGN KEY (`RID`) REFERENCES `mb_role` (`ID`),
  CONSTRAINT `FK_Reference_9` FOREIGN KEY (`UID`) REFERENCES `mb_user` (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;
INSERT  INTO `mb_user_role`(`UID`,`RID`) VALUES (41,1),(45,1),(41,2);