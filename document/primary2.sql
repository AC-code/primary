/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : primary2

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-06-05 22:08:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for classes
-- ----------------------------
DROP TABLE IF EXISTS `classes`;
CREATE TABLE `classes` (
  `classId` int(11) NOT NULL,
  `gradeId` int(11) DEFAULT NULL,
  `className` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`classId`),
  KEY `FK_Reference_22` (`gradeId`),
  CONSTRAINT `FK_Reference_22` FOREIGN KEY (`gradeId`) REFERENCES `grade` (`gradeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of classes
-- ----------------------------
INSERT INTO `classes` VALUES ('1', '1', '一班');
INSERT INTO `classes` VALUES ('2', '1', '二班');
INSERT INTO `classes` VALUES ('3', '1', '三班');
INSERT INTO `classes` VALUES ('20170101', '201701', '一班');
INSERT INTO `classes` VALUES ('20170102', '201701', '二班');
INSERT INTO `classes` VALUES ('20180201', '201802', '一班');
INSERT INTO `classes` VALUES ('20180202', '201802', '二班');

-- ----------------------------
-- Table structure for class_course_grade
-- ----------------------------
DROP TABLE IF EXISTS `class_course_grade`;
CREATE TABLE `class_course_grade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `classId` int(11) DEFAULT NULL,
  `g_c_id` int(11) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_26` (`classId`),
  KEY `FK_Reference_27` (`g_c_id`),
  CONSTRAINT `FK_Reference_26` FOREIGN KEY (`classId`) REFERENCES `classes` (`classId`),
  CONSTRAINT `FK_Reference_27` FOREIGN KEY (`g_c_id`) REFERENCES `grade_course` (`g_c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class_course_grade
-- ----------------------------
INSERT INTO `class_course_grade` VALUES ('1', '1', '3', '期中考试');
INSERT INTO `class_course_grade` VALUES ('3', '1', '5', '期末考试');
INSERT INTO `class_course_grade` VALUES ('4', '20170101', '9', '期中考试');
INSERT INTO `class_course_grade` VALUES ('5', '20170101', '9', '期末考试');
INSERT INTO `class_course_grade` VALUES ('6', '20180201', '12', '期中成绩');
INSERT INTO `class_course_grade` VALUES ('7', '20170102', '6', '期末成绩');
INSERT INTO `class_course_grade` VALUES ('8', '1', '3', '期末考试');
INSERT INTO `class_course_grade` VALUES ('9', '20180201', '12', '期末考试');

-- ----------------------------
-- Table structure for class_stu
-- ----------------------------
DROP TABLE IF EXISTS `class_stu`;
CREATE TABLE `class_stu` (
  `classId` int(11) NOT NULL,
  `stuId` int(11) DEFAULT NULL,
  `number` int(11) NOT NULL,
  PRIMARY KEY (`classId`,`number`),
  KEY `FK_Reference_17` (`stuId`),
  CONSTRAINT `FK_Reference_16` FOREIGN KEY (`classId`) REFERENCES `classes` (`classId`),
  CONSTRAINT `FK_Reference_17` FOREIGN KEY (`stuId`) REFERENCES `student` (`stuId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class_stu
-- ----------------------------
INSERT INTO `class_stu` VALUES ('1', '1', '1');
INSERT INTO `class_stu` VALUES ('20180201', '1', '1');
INSERT INTO `class_stu` VALUES ('20180201', '2', '2');
INSERT INTO `class_stu` VALUES ('1', '3', '2');
INSERT INTO `class_stu` VALUES ('1', '3', '3');
INSERT INTO `class_stu` VALUES ('1', '4', '4');
INSERT INTO `class_stu` VALUES ('1', '8', '5');
INSERT INTO `class_stu` VALUES ('20170101', '10', '4');
INSERT INTO `class_stu` VALUES ('20170101', '1700000', '1');
INSERT INTO `class_stu` VALUES ('1', '1700001', '7');
INSERT INTO `class_stu` VALUES ('20170101', '1700001', '2');
INSERT INTO `class_stu` VALUES ('20170102', '1700001', '1');
INSERT INTO `class_stu` VALUES ('20180201', '1700001', '8');
INSERT INTO `class_stu` VALUES ('20170101', '1700002', '3');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `courseId` int(11) NOT NULL,
  `courseName` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`courseId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', '语文');
INSERT INTO `course` VALUES ('2', '数学');
INSERT INTO `course` VALUES ('3', '英语');
INSERT INTO `course` VALUES ('4', '美术');
INSERT INTO `course` VALUES ('5', '体育');
INSERT INTO `course` VALUES ('6', '音乐');

-- ----------------------------
-- Table structure for course_teacher
-- ----------------------------
DROP TABLE IF EXISTS `course_teacher`;
CREATE TABLE `course_teacher` (
  `stuffId` int(11) NOT NULL,
  `g_c_id` int(11) NOT NULL,
  `classId` int(11) NOT NULL,
  PRIMARY KEY (`stuffId`,`g_c_id`,`classId`),
  KEY `FK_Reference_24` (`g_c_id`),
  KEY `FK_Reference_25` (`classId`),
  CONSTRAINT `FK_Reference_15` FOREIGN KEY (`stuffId`) REFERENCES `stuff` (`stuffId`),
  CONSTRAINT `FK_Reference_25` FOREIGN KEY (`classId`) REFERENCES `classes` (`classId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_teacher
-- ----------------------------
INSERT INTO `course_teacher` VALUES ('2', '3', '1');
INSERT INTO `course_teacher` VALUES ('10', '3', '1');
INSERT INTO `course_teacher` VALUES ('6', '5', '1');
INSERT INTO `course_teacher` VALUES ('9', '5', '1');
INSERT INTO `course_teacher` VALUES ('15', '5', '1');
INSERT INTO `course_teacher` VALUES ('2', '6', '20170102');
INSERT INTO `course_teacher` VALUES ('2', '7', '20170102');
INSERT INTO `course_teacher` VALUES ('2', '9', '20170101');
INSERT INTO `course_teacher` VALUES ('2', '12', '20180201');
INSERT INTO `course_teacher` VALUES ('2', '13', '20180202');

-- ----------------------------
-- Table structure for grade
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade` (
  `gradeId` int(11) NOT NULL,
  `sessnId` int(11) DEFAULT NULL,
  `gradeName` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`gradeId`),
  KEY `FK_Reference_21` (`sessnId`),
  CONSTRAINT `FK_Reference_21` FOREIGN KEY (`sessnId`) REFERENCES `session` (`sessnId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of grade
-- ----------------------------
INSERT INTO `grade` VALUES ('1', '1', '一年级');
INSERT INTO `grade` VALUES ('2', '1', '二年级');
INSERT INTO `grade` VALUES ('7', '2', '一年级');
INSERT INTO `grade` VALUES ('201701', '2017', '一年级');
INSERT INTO `grade` VALUES ('201702', '2017', '二年级');
INSERT INTO `grade` VALUES ('201801', '2018', '一年级');
INSERT INTO `grade` VALUES ('201802', '2018', '二年级');

-- ----------------------------
-- Table structure for grade_course
-- ----------------------------
DROP TABLE IF EXISTS `grade_course`;
CREATE TABLE `grade_course` (
  `g_c_id` int(11) NOT NULL AUTO_INCREMENT,
  `courseId` int(11) DEFAULT NULL,
  `gradeId` int(11) DEFAULT NULL,
  PRIMARY KEY (`g_c_id`),
  KEY `FK_Reference_18` (`courseId`),
  KEY `FK_Reference_23` (`gradeId`),
  CONSTRAINT `FK_Reference_18` FOREIGN KEY (`courseId`) REFERENCES `course` (`courseId`),
  CONSTRAINT `FK_Reference_23` FOREIGN KEY (`gradeId`) REFERENCES `grade` (`gradeId`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of grade_course
-- ----------------------------
INSERT INTO `grade_course` VALUES ('3', '3', '1');
INSERT INTO `grade_course` VALUES ('5', '5', '1');
INSERT INTO `grade_course` VALUES ('6', '1', '201701');
INSERT INTO `grade_course` VALUES ('7', '2', '201701');
INSERT INTO `grade_course` VALUES ('9', '3', '201701');
INSERT INTO `grade_course` VALUES ('11', '5', '201701');
INSERT INTO `grade_course` VALUES ('12', '1', '201802');
INSERT INTO `grade_course` VALUES ('13', '2', '201802');
INSERT INTO `grade_course` VALUES ('14', '3', '201802');

-- ----------------------------
-- Table structure for head_teacher
-- ----------------------------
DROP TABLE IF EXISTS `head_teacher`;
CREATE TABLE `head_teacher` (
  `classId` int(11) NOT NULL,
  `stuffId` int(11) NOT NULL,
  PRIMARY KEY (`classId`,`stuffId`),
  KEY `FK_Reference_11` (`stuffId`),
  CONSTRAINT `FK_Reference_10` FOREIGN KEY (`classId`) REFERENCES `classes` (`classId`),
  CONSTRAINT `FK_Reference_11` FOREIGN KEY (`stuffId`) REFERENCES `stuff` (`stuffId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of head_teacher
-- ----------------------------
INSERT INTO `head_teacher` VALUES ('1', '2');
INSERT INTO `head_teacher` VALUES ('2', '2');
INSERT INTO `head_teacher` VALUES ('20170101', '2');
INSERT INTO `head_teacher` VALUES ('20170102', '2');
INSERT INTO `head_teacher` VALUES ('20180201', '2');
INSERT INTO `head_teacher` VALUES ('1', '3');
INSERT INTO `head_teacher` VALUES ('2', '3');
INSERT INTO `head_teacher` VALUES ('3', '3');
INSERT INTO `head_teacher` VALUES ('20170101', '3');
INSERT INTO `head_teacher` VALUES ('1', '4');
INSERT INTO `head_teacher` VALUES ('2', '4');

-- ----------------------------
-- Table structure for parent
-- ----------------------------
DROP TABLE IF EXISTS `parent`;
CREATE TABLE `parent` (
  `parentId` int(11) NOT NULL,
  `stuId` int(11) DEFAULT NULL,
  `password` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`parentId`),
  KEY `FK_Reference_1` (`stuId`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`stuId`) REFERENCES `student` (`stuId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of parent
-- ----------------------------
INSERT INTO `parent` VALUES ('3', '3', '3');
INSERT INTO `parent` VALUES ('6', '6', '6');
INSERT INTO `parent` VALUES ('7', '7', '7');
INSERT INTO `parent` VALUES ('8', '8', '8');
INSERT INTO `parent` VALUES ('9', '9', '9');
INSERT INTO `parent` VALUES ('10', '10', '10');
INSERT INTO `parent` VALUES ('11', '11', '13');
INSERT INTO `parent` VALUES ('12', '12', '9');
INSERT INTO `parent` VALUES ('13', '13', '4');
INSERT INTO `parent` VALUES ('14', '14', '15');
INSERT INTO `parent` VALUES ('15', '15', '15');
INSERT INTO `parent` VALUES ('16', '16', '16');
INSERT INTO `parent` VALUES ('17', '17', '17');
INSERT INTO `parent` VALUES ('18', '18', '18');
INSERT INTO `parent` VALUES ('22', '22', '22');
INSERT INTO `parent` VALUES ('23', '23', '23');
INSERT INTO `parent` VALUES ('24', '24', '24');
INSERT INTO `parent` VALUES ('25', '25', '25');
INSERT INTO `parent` VALUES ('26', '26', '26');
INSERT INTO `parent` VALUES ('27', '27', '27');
INSERT INTO `parent` VALUES ('28', '28', '28');
INSERT INTO `parent` VALUES ('29', '29', '29');
INSERT INTO `parent` VALUES ('32', '32', '32');
INSERT INTO `parent` VALUES ('33', '33', '33');
INSERT INTO `parent` VALUES ('34', '34', '34');
INSERT INTO `parent` VALUES ('35', '35', '35');
INSERT INTO `parent` VALUES ('36', '36', '36');
INSERT INTO `parent` VALUES ('37', '37', '37');
INSERT INTO `parent` VALUES ('38', '38', '38');
INSERT INTO `parent` VALUES ('39', '39', '39');
INSERT INTO `parent` VALUES ('42', '42', '42');
INSERT INTO `parent` VALUES ('43', '43', '43');
INSERT INTO `parent` VALUES ('44', '44', '44');
INSERT INTO `parent` VALUES ('45', '45', '45');
INSERT INTO `parent` VALUES ('46', '46', '46');
INSERT INTO `parent` VALUES ('47', '47', '47');
INSERT INTO `parent` VALUES ('48', '48', '48');
INSERT INTO `parent` VALUES ('49', '49', '49');
INSERT INTO `parent` VALUES ('52', '52', '52');
INSERT INTO `parent` VALUES ('53', '53', '53');
INSERT INTO `parent` VALUES ('54', '54', '54');
INSERT INTO `parent` VALUES ('55', '55', '55');
INSERT INTO `parent` VALUES ('56', '56', '56');
INSERT INTO `parent` VALUES ('57', '57', '57');
INSERT INTO `parent` VALUES ('58', '58', '58');
INSERT INTO `parent` VALUES ('59', '59', '59');
INSERT INTO `parent` VALUES ('62', '62', '62');
INSERT INTO `parent` VALUES ('63', '63', '63');
INSERT INTO `parent` VALUES ('64', '64', '64');
INSERT INTO `parent` VALUES ('65', '65', '65');
INSERT INTO `parent` VALUES ('66', '66', '66');
INSERT INTO `parent` VALUES ('67', '67', '67');
INSERT INTO `parent` VALUES ('68', '68', '68');
INSERT INTO `parent` VALUES ('69', '69', '69');
INSERT INTO `parent` VALUES ('72', '72', '72');
INSERT INTO `parent` VALUES ('73', '73', '73');
INSERT INTO `parent` VALUES ('74', '74', '74');
INSERT INTO `parent` VALUES ('75', '75', '75');
INSERT INTO `parent` VALUES ('76', '76', '76');
INSERT INTO `parent` VALUES ('77', '77', '77');
INSERT INTO `parent` VALUES ('78', '78', '78');
INSERT INTO `parent` VALUES ('79', '79', '79');
INSERT INTO `parent` VALUES ('82', '82', '82');
INSERT INTO `parent` VALUES ('83', '83', '83');
INSERT INTO `parent` VALUES ('84', '84', '84');
INSERT INTO `parent` VALUES ('85', '85', '85');
INSERT INTO `parent` VALUES ('86', '86', '86');
INSERT INTO `parent` VALUES ('87', '87', '87');
INSERT INTO `parent` VALUES ('88', '88', '88');
INSERT INTO `parent` VALUES ('89', '89', '89');
INSERT INTO `parent` VALUES ('92', '92', '92');
INSERT INTO `parent` VALUES ('93', '93', '93');
INSERT INTO `parent` VALUES ('94', '94', '94');
INSERT INTO `parent` VALUES ('95', '95', '95');
INSERT INTO `parent` VALUES ('96', '96', '96');
INSERT INTO `parent` VALUES ('97', '97', '97');
INSERT INTO `parent` VALUES ('98', '98', '98');
INSERT INTO `parent` VALUES ('99', '99', '99');
INSERT INTO `parent` VALUES ('102', '102', '102');
INSERT INTO `parent` VALUES ('103', '103', '103');
INSERT INTO `parent` VALUES ('104', '104', '104');
INSERT INTO `parent` VALUES ('105', '105', '105');
INSERT INTO `parent` VALUES ('106', '106', '106');
INSERT INTO `parent` VALUES ('107', '107', '107');
INSERT INTO `parent` VALUES ('108', '108', '108');
INSERT INTO `parent` VALUES ('109', '109', '109');
INSERT INTO `parent` VALUES ('1000001', '1000001', '1000001');
INSERT INTO `parent` VALUES ('1000002', '1000002', '1000002');
INSERT INTO `parent` VALUES ('1000003', '1000003', '1000003');
INSERT INTO `parent` VALUES ('1000004', '1000004', '1000004');
INSERT INTO `parent` VALUES ('1000005', '1000005', '1000005');
INSERT INTO `parent` VALUES ('1000006', '1000006', '1000006');
INSERT INTO `parent` VALUES ('1000007', '1000007', '1000007');
INSERT INTO `parent` VALUES ('1000008', '1000008', '1000008');
INSERT INTO `parent` VALUES ('1000009', '1000009', '1000009');
INSERT INTO `parent` VALUES ('1700000', '1700000', '1700000');
INSERT INTO `parent` VALUES ('1700001', '1700001', '1700001');
INSERT INTO `parent` VALUES ('1700002', '1700002', '1700002');
INSERT INTO `parent` VALUES ('1700003', '1700003', '1700003');
INSERT INTO `parent` VALUES ('1700004', '1700004', '1700004');
INSERT INTO `parent` VALUES ('1700005', '1700005', '1700005');
INSERT INTO `parent` VALUES ('1700006', '1700006', '1700006');
INSERT INTO `parent` VALUES ('1700007', '1700007', '1700007');
INSERT INTO `parent` VALUES ('1700008', '1700008', '1700008');
INSERT INTO `parent` VALUES ('1800001', '1800001', '1800001');
INSERT INTO `parent` VALUES ('1800002', '1800002', '1800002');
INSERT INTO `parent` VALUES ('1800003', '1800003', '1800003');
INSERT INTO `parent` VALUES ('1800004', '1800004', '1800004');
INSERT INTO `parent` VALUES ('1800005', '1800005', '1800005');
INSERT INTO `parent` VALUES ('1800006', '1800006', '1800006');
INSERT INTO `parent` VALUES ('1800007', '1800007', '1800007');
INSERT INTO `parent` VALUES ('1800008', '1800008', '1800008');
INSERT INTO `parent` VALUES ('1800009', '1800009', '1800009');

-- ----------------------------
-- Table structure for prefect
-- ----------------------------
DROP TABLE IF EXISTS `prefect`;
CREATE TABLE `prefect` (
  `gradeId` int(11) NOT NULL,
  `stuffId` int(11) NOT NULL,
  PRIMARY KEY (`stuffId`,`gradeId`),
  KEY `FK_Reference_6` (`gradeId`),
  CONSTRAINT `FK_Reference_6` FOREIGN KEY (`gradeId`) REFERENCES `grade` (`gradeId`),
  CONSTRAINT `FK_Reference_7` FOREIGN KEY (`stuffId`) REFERENCES `stuff` (`stuffId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of prefect
-- ----------------------------
INSERT INTO `prefect` VALUES ('1', '2');
INSERT INTO `prefect` VALUES ('1', '10');
INSERT INTO `prefect` VALUES ('2', '2');
INSERT INTO `prefect` VALUES ('7', '2');
INSERT INTO `prefect` VALUES ('201701', '2');
INSERT INTO `prefect` VALUES ('201701', '3');
INSERT INTO `prefect` VALUES ('201702', '3');
INSERT INTO `prefect` VALUES ('201802', '2');

-- ----------------------------
-- Table structure for p_to_p
-- ----------------------------
DROP TABLE IF EXISTS `p_to_p`;
CREATE TABLE `p_to_p` (
  `parentId` int(11) NOT NULL,
  `beParentId` int(11) NOT NULL,
  PRIMARY KEY (`parentId`,`beParentId`),
  KEY `FK_Reference_3` (`beParentId`),
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`parentId`) REFERENCES `parent` (`parentId`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`beParentId`) REFERENCES `parent` (`parentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of p_to_p
-- ----------------------------

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `id` int(11) NOT NULL,
  `classId` int(11) NOT NULL,
  `number` int(11) NOT NULL,
  `mark` float DEFAULT NULL,
  PRIMARY KEY (`id`,`classId`,`number`),
  KEY `FK_Reference_20` (`classId`,`number`),
  CONSTRAINT `FK_Reference_19` FOREIGN KEY (`id`) REFERENCES `class_course_grade` (`id`),
  CONSTRAINT `FK_Reference_20` FOREIGN KEY (`classId`, `number`) REFERENCES `class_stu` (`classId`, `number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES ('1', '1', '1', '80.5');
INSERT INTO `score` VALUES ('1', '1', '2', '70.5');
INSERT INTO `score` VALUES ('1', '1', '3', '90.5');
INSERT INTO `score` VALUES ('1', '1', '4', '7');
INSERT INTO `score` VALUES ('1', '1', '5', '80');
INSERT INTO `score` VALUES ('4', '20170101', '1', '0');
INSERT INTO `score` VALUES ('4', '20170101', '2', '0');
INSERT INTO `score` VALUES ('4', '20170101', '3', '0');
INSERT INTO `score` VALUES ('5', '20170101', '1', '100');
INSERT INTO `score` VALUES ('5', '20170101', '2', '50');
INSERT INTO `score` VALUES ('5', '20170101', '3', '60');
INSERT INTO `score` VALUES ('5', '20170101', '4', '0.5');
INSERT INTO `score` VALUES ('6', '20180201', '1', '50');
INSERT INTO `score` VALUES ('6', '20180201', '2', '0');
INSERT INTO `score` VALUES ('7', '20170102', '1', '90');
INSERT INTO `score` VALUES ('8', '1', '1', '0');
INSERT INTO `score` VALUES ('8', '1', '2', '0');
INSERT INTO `score` VALUES ('8', '1', '3', '0');
INSERT INTO `score` VALUES ('8', '1', '4', '0');
INSERT INTO `score` VALUES ('8', '1', '5', '0');
INSERT INTO `score` VALUES ('8', '1', '7', '44');
INSERT INTO `score` VALUES ('9', '20180201', '1', '0');
INSERT INTO `score` VALUES ('9', '20180201', '2', '0');
INSERT INTO `score` VALUES ('9', '20180201', '8', '55');

-- ----------------------------
-- Table structure for session
-- ----------------------------
DROP TABLE IF EXISTS `session`;
CREATE TABLE `session` (
  `sessnId` int(11) NOT NULL,
  `sessnName` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`sessnId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of session
-- ----------------------------
INSERT INTO `session` VALUES ('1', '2014届');
INSERT INTO `session` VALUES ('2', '2015届');
INSERT INTO `session` VALUES ('3', '2016届');
INSERT INTO `session` VALUES ('2017', '2017届');
INSERT INTO `session` VALUES ('2018', '2018届');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `stuId` int(11) NOT NULL,
  `stuName` varchar(20) DEFAULT NULL,
  `password` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`stuId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '叶雨泽', '1');
INSERT INTO `student` VALUES ('2', '雨泽', '111');
INSERT INTO `student` VALUES ('3', '小贱贱', '123123');
INSERT INTO `student` VALUES ('4', '邱文生', '3');
INSERT INTO `student` VALUES ('5', '丘文生', '3');
INSERT INTO `student` VALUES ('6', '伍绍钦', '6');
INSERT INTO `student` VALUES ('7', '傻逼楷超', '7');
INSERT INTO `student` VALUES ('8', '楷超儿子', '8');
INSERT INTO `student` VALUES ('9', '楷超孙子', '9');
INSERT INTO `student` VALUES ('10', '楷超儿子', '10');
INSERT INTO `student` VALUES ('11', '叶', '11');
INSERT INTO `student` VALUES ('12', '叶', '12');
INSERT INTO `student` VALUES ('13', '叶', '13');
INSERT INTO `student` VALUES ('14', '叶', '14');
INSERT INTO `student` VALUES ('15', '叶', '15');
INSERT INTO `student` VALUES ('16', '叶', '16');
INSERT INTO `student` VALUES ('17', '叶', '17');
INSERT INTO `student` VALUES ('18', '叶', '18');
INSERT INTO `student` VALUES ('22', '叶', '22');
INSERT INTO `student` VALUES ('23', '叶', '23');
INSERT INTO `student` VALUES ('24', '叶', '24');
INSERT INTO `student` VALUES ('25', '叶', '25');
INSERT INTO `student` VALUES ('26', '叶', '26');
INSERT INTO `student` VALUES ('27', '叶', '27');
INSERT INTO `student` VALUES ('28', '叶', '28');
INSERT INTO `student` VALUES ('29', '叶', '29');
INSERT INTO `student` VALUES ('32', '叶', '32');
INSERT INTO `student` VALUES ('33', '叶', '33');
INSERT INTO `student` VALUES ('34', '叶', '34');
INSERT INTO `student` VALUES ('35', '叶', '35');
INSERT INTO `student` VALUES ('36', '叶', '36');
INSERT INTO `student` VALUES ('37', '叶', '37');
INSERT INTO `student` VALUES ('38', '叶', '38');
INSERT INTO `student` VALUES ('39', '叶', '39');
INSERT INTO `student` VALUES ('42', '叶', '42');
INSERT INTO `student` VALUES ('43', '叶', '43');
INSERT INTO `student` VALUES ('44', '叶', '44');
INSERT INTO `student` VALUES ('45', '叶', '45');
INSERT INTO `student` VALUES ('46', '叶', '46');
INSERT INTO `student` VALUES ('47', '叶', '47');
INSERT INTO `student` VALUES ('48', '叶', '48');
INSERT INTO `student` VALUES ('49', '叶', '49');
INSERT INTO `student` VALUES ('52', '叶', '52');
INSERT INTO `student` VALUES ('53', '叶', '53');
INSERT INTO `student` VALUES ('54', '叶', '54');
INSERT INTO `student` VALUES ('55', '叶', '55');
INSERT INTO `student` VALUES ('56', '叶', '56');
INSERT INTO `student` VALUES ('57', '叶', '57');
INSERT INTO `student` VALUES ('58', '叶', '58');
INSERT INTO `student` VALUES ('59', '叶', '59');
INSERT INTO `student` VALUES ('62', '叶', '62');
INSERT INTO `student` VALUES ('63', '叶', '63');
INSERT INTO `student` VALUES ('64', '叶', '64');
INSERT INTO `student` VALUES ('65', '叶', '65');
INSERT INTO `student` VALUES ('66', '叶', '66');
INSERT INTO `student` VALUES ('67', '叶', '67');
INSERT INTO `student` VALUES ('68', '叶', '68');
INSERT INTO `student` VALUES ('69', '叶', '69');
INSERT INTO `student` VALUES ('72', '叶', '72');
INSERT INTO `student` VALUES ('73', '叶', '73');
INSERT INTO `student` VALUES ('74', '叶', '74');
INSERT INTO `student` VALUES ('75', '叶', '75');
INSERT INTO `student` VALUES ('76', '叶', '76');
INSERT INTO `student` VALUES ('77', '叶', '77');
INSERT INTO `student` VALUES ('78', '叶', '78');
INSERT INTO `student` VALUES ('79', '叶', '79');
INSERT INTO `student` VALUES ('82', '叶', '82');
INSERT INTO `student` VALUES ('83', '叶', '83');
INSERT INTO `student` VALUES ('84', '叶', '84');
INSERT INTO `student` VALUES ('85', '叶', '85');
INSERT INTO `student` VALUES ('86', '叶', '86');
INSERT INTO `student` VALUES ('87', '叶', '87');
INSERT INTO `student` VALUES ('88', '叶', '88');
INSERT INTO `student` VALUES ('89', '叶', '89');
INSERT INTO `student` VALUES ('92', '叶', '92');
INSERT INTO `student` VALUES ('93', '叶', '93');
INSERT INTO `student` VALUES ('94', '叶', '94');
INSERT INTO `student` VALUES ('95', '叶', '95');
INSERT INTO `student` VALUES ('96', '叶', '96');
INSERT INTO `student` VALUES ('97', '叶', '97');
INSERT INTO `student` VALUES ('98', '叶', '98');
INSERT INTO `student` VALUES ('99', '叶', '99');
INSERT INTO `student` VALUES ('102', '叶', '102');
INSERT INTO `student` VALUES ('103', '叶', '103');
INSERT INTO `student` VALUES ('104', '叶', '104');
INSERT INTO `student` VALUES ('105', '叶', '105');
INSERT INTO `student` VALUES ('106', '叶', '106');
INSERT INTO `student` VALUES ('107', '叶', '107');
INSERT INTO `student` VALUES ('108', '叶', '108');
INSERT INTO `student` VALUES ('109', '叶', '109');
INSERT INTO `student` VALUES ('1000001', '张三', '1000001');
INSERT INTO `student` VALUES ('1000002', '李四', '1000002');
INSERT INTO `student` VALUES ('1000003', '王五', '1000003');
INSERT INTO `student` VALUES ('1000004', '叶', '1000004');
INSERT INTO `student` VALUES ('1000005', '叶', '1000005');
INSERT INTO `student` VALUES ('1000006', '叶', '1000006');
INSERT INTO `student` VALUES ('1000007', '叶', '1000007');
INSERT INTO `student` VALUES ('1000008', '叶', '1000008');
INSERT INTO `student` VALUES ('1000009', '叶', '1000009');
INSERT INTO `student` VALUES ('1700000', '张三', '1700000');
INSERT INTO `student` VALUES ('1700001', '李四', '1700001');
INSERT INTO `student` VALUES ('1700002', '王五', '1700002');
INSERT INTO `student` VALUES ('1700003', '叶', '1700003');
INSERT INTO `student` VALUES ('1700004', '叶', '1700004');
INSERT INTO `student` VALUES ('1700005', '叶', '1700005');
INSERT INTO `student` VALUES ('1700006', '叶', '1700006');
INSERT INTO `student` VALUES ('1700007', '叶', '1700007');
INSERT INTO `student` VALUES ('1700008', '叶', '1700008');
INSERT INTO `student` VALUES ('1800001', '张三', '1800001');
INSERT INTO `student` VALUES ('1800002', '李四', '1800002');
INSERT INTO `student` VALUES ('1800003', '王五', '1800003');
INSERT INTO `student` VALUES ('1800004', '叶', '1800004');
INSERT INTO `student` VALUES ('1800005', '叶', '1800005');
INSERT INTO `student` VALUES ('1800006', '叶', '1800006');
INSERT INTO `student` VALUES ('1800007', '叶', '1800007');
INSERT INTO `student` VALUES ('1800008', '叶', '1800008');
INSERT INTO `student` VALUES ('1800009', '叶', '1800009');

-- ----------------------------
-- Table structure for stuff
-- ----------------------------
DROP TABLE IF EXISTS `stuff`;
CREATE TABLE `stuff` (
  `stuffId` int(11) NOT NULL,
  `authority` int(11) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `password` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`stuffId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stuff
-- ----------------------------
INSERT INTO `stuff` VALUES ('2', '1', '2', '234');
INSERT INTO `stuff` VALUES ('3', '3', '3', '3');
INSERT INTO `stuff` VALUES ('4', '1', '4', '4');
INSERT INTO `stuff` VALUES ('6', '3', '6', '6');
INSERT INTO `stuff` VALUES ('7', '3', '7', '7');
INSERT INTO `stuff` VALUES ('9', '2', '9', '9');
INSERT INTO `stuff` VALUES ('10', '2', '文生特', '10');
INSERT INTO `stuff` VALUES ('11', '2', '11', '11');
INSERT INTO `stuff` VALUES ('12', '2', '邱文生', '12');
INSERT INTO `stuff` VALUES ('15', '0', '邱文生', '13');
INSERT INTO `stuff` VALUES ('16', '0', '雨泽儿子', '11');
INSERT INTO `stuff` VALUES ('17', '0', '17', '17');

-- ----------------------------
-- View structure for class_course_detail
-- ----------------------------
DROP VIEW IF EXISTS `class_course_detail`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`::1` SQL SECURITY DEFINER VIEW `class_course_detail` AS select `course`.`courseName` AS `courseName`,`grade_course`.`g_c_id` AS `g_c_id`,`classes`.`classId` AS `classId` from ((`classes` join `grade_course` on((`classes`.`gradeId` = `grade_course`.`gradeId`))) join `course` on((`grade_course`.`courseId` = `course`.`courseId`))) ;

-- ----------------------------
-- View structure for class_detail
-- ----------------------------
DROP VIEW IF EXISTS `class_detail`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`::1` SQL SECURITY DEFINER VIEW `class_detail` AS select `session`.`sessnName` AS `sessnName`,`grade`.`gradeName` AS `gradeName`,`classes`.`className` AS `className`,`classes`.`classId` AS `classId` from ((`classes` join `grade` on((`classes`.`gradeId` = `grade`.`gradeId`))) join `session` on((`grade`.`sessnId` = `session`.`sessnId`))) ;

-- ----------------------------
-- View structure for class_head_teacher
-- ----------------------------
DROP VIEW IF EXISTS `class_head_teacher`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`::1` SQL SECURITY DEFINER VIEW `class_head_teacher` AS select `head_teacher`.`classId` AS `classId`,`head_teacher`.`stuffId` AS `stuffId`,`stuff`.`name` AS `name` from (`head_teacher` join `stuff` on((`head_teacher`.`stuffId` = `stuff`.`stuffId`))) ;

-- ----------------------------
-- View structure for class_stu_detail
-- ----------------------------
DROP VIEW IF EXISTS `class_stu_detail`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`::1` SQL SECURITY DEFINER VIEW `class_stu_detail` AS select `class_stu`.`number` AS `number`,`student`.`stuName` AS `stuName`,`student`.`stuId` AS `stuId`,`class_stu`.`classId` AS `classId` from (`class_stu` join `student` on((`class_stu`.`stuId` = `student`.`stuId`))) ;

-- ----------------------------
-- View structure for course_teacher_detail
-- ----------------------------
DROP VIEW IF EXISTS `course_teacher_detail`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`::1` SQL SECURITY DEFINER VIEW `course_teacher_detail` AS select `stuff`.`name` AS `name`,`course_teacher`.`stuffId` AS `stuffId`,`course_teacher`.`g_c_id` AS `g_c_id`,`course_teacher`.`classId` AS `classId` from (`course_teacher` join `stuff` on((`course_teacher`.`stuffId` = `stuff`.`stuffId`))) ;

-- ----------------------------
-- View structure for grade_course_detail
-- ----------------------------
DROP VIEW IF EXISTS `grade_course_detail`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`::1` SQL SECURITY DEFINER VIEW `grade_course_detail` AS select `course`.`courseName` AS `courseName`,`grade_course`.`g_c_id` AS `g_c_id`,`grade_course`.`courseId` AS `courseId`,`grade_course`.`gradeId` AS `gradeId` from (`grade_course` join `course` on((`grade_course`.`courseId` = `course`.`courseId`))) ;

-- ----------------------------
-- View structure for grade_prefect
-- ----------------------------
DROP VIEW IF EXISTS `grade_prefect`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`::1` SQL SECURITY DEFINER VIEW `grade_prefect` AS select `stuff`.`name` AS `name`,`stuff`.`stuffId` AS `stuffId`,`prefect`.`gradeId` AS `gradeId`,`grade`.`gradeName` AS `gradeName`,`session`.`sessnName` AS `sessnName` from (((`prefect` join `stuff` on((`prefect`.`stuffId` = `stuff`.`stuffId`))) join `grade` on((`prefect`.`gradeId` = `grade`.`gradeId`))) join `session` on((`grade`.`sessnId` = `session`.`sessnId`))) ;

-- ----------------------------
-- View structure for score_detail
-- ----------------------------
DROP VIEW IF EXISTS `score_detail`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`::1` SQL SECURITY DEFINER VIEW `score_detail` AS select `class_stu_detail`.`stuName` AS `stuName`,`class_stu_detail`.`stuId` AS `stuId`,`score`.`mark` AS `mark`,`score`.`id` AS `id`,`score`.`classId` AS `classId`,`score`.`number` AS `number` from (`score` join `class_stu_detail` on(((`score`.`classId` = `class_stu_detail`.`classId`) and (`score`.`number` = `class_stu_detail`.`number`)))) ;

-- ----------------------------
-- View structure for student_parent
-- ----------------------------
DROP VIEW IF EXISTS `student_parent`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`::1` SQL SECURITY DEFINER VIEW `student_parent` AS select `parent`.`parentId` AS `parentId`,`parent`.`password` AS `password`,`student`.`stuName` AS `stuName` from (`parent` join `student` on((`parent`.`stuId` = `student`.`stuId`))) ;

-- ----------------------------
-- View structure for stu_score_detail
-- ----------------------------
DROP VIEW IF EXISTS `stu_score_detail`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`::1` SQL SECURITY DEFINER VIEW `stu_score_detail` AS select `class_stu`.`stuId` AS `stuId`,`class_stu`.`classId` AS `classId`,`class_stu`.`number` AS `number`,`score`.`mark` AS `mark`,`class_course_grade`.`name` AS `name`,`course`.`courseName` AS `courseName`,`class_detail`.`className` AS `className`,`class_detail`.`gradeName` AS `gradeName`,`class_detail`.`sessnName` AS `sessnName` from (((((`class_stu` join `score` on(((`score`.`classId` = `class_stu`.`classId`) and (`score`.`number` = `class_stu`.`number`)))) join `class_course_grade` on((`score`.`id` = `class_course_grade`.`id`))) join `grade_course` on((`class_course_grade`.`g_c_id` = `grade_course`.`g_c_id`))) join `class_detail` on((`class_stu`.`classId` = `class_detail`.`classId`))) join `course` on((`grade_course`.`courseId` = `course`.`courseId`))) ;

-- ----------------------------
-- View structure for teacher_class_course_detail
-- ----------------------------
DROP VIEW IF EXISTS `teacher_class_course_detail`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`::1` SQL SECURITY DEFINER VIEW `teacher_class_course_detail` AS select `grade_course_detail`.`courseName` AS `courseName`,`course_teacher`.`g_c_id` AS `g_c_id`,`course_teacher`.`stuffId` AS `stuffId`,`course_teacher`.`classId` AS `classId` from (`course_teacher` join `grade_course_detail` on((`course_teacher`.`g_c_id` = `grade_course_detail`.`g_c_id`))) ;

-- ----------------------------
-- View structure for teacher_class_detail
-- ----------------------------
DROP VIEW IF EXISTS `teacher_class_detail`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`::1` SQL SECURITY DEFINER VIEW `teacher_class_detail` AS select distinct `course_teacher`.`stuffId` AS `stuffId`,`class_detail`.`sessnName` AS `sessnName`,`class_detail`.`gradeName` AS `gradeName`,`class_detail`.`className` AS `className`,`course_teacher`.`classId` AS `classId` from (`course_teacher` join `class_detail` on((`course_teacher`.`classId` = `class_detail`.`classId`))) ;

-- ----------------------------
-- View structure for teac_class_course_grade
-- ----------------------------
DROP VIEW IF EXISTS `teac_class_course_grade`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`::1` SQL SECURITY DEFINER VIEW `teac_class_course_grade` AS select `course_teacher`.`stuffId` AS `stuffId`,`class_course_grade`.`id` AS `id`,`class_course_grade`.`classId` AS `classId`,`class_course_grade`.`g_c_id` AS `g_c_id`,`class_course_grade`.`name` AS `name` from (`class_course_grade` join `course_teacher` on(((`class_course_grade`.`g_c_id` = `course_teacher`.`g_c_id`) and (`class_course_grade`.`classId` = `course_teacher`.`classId`)))) ;
