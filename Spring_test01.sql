/*
 Navicat Premium Data Transfer

 Source Server         : Test
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : test01

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 18/04/2022 12:10:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for competence
-- ----------------------------
DROP TABLE IF EXISTS `competence`;
CREATE TABLE `competence`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of competence
-- ----------------------------
INSERT INTO `competence` VALUES (1, 'user');
INSERT INTO `competence` VALUES (2, 'admin');
INSERT INTO `competence` VALUES (3, 'root');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES (1, '前端');
INSERT INTO `department` VALUES (2, '后端');
INSERT INTO `department` VALUES (3, '数据库');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `gender` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '0 - 女 | 1- 男',
  `brith` datetime NOT NULL,
  `departmentId` int NOT NULL,
  `competenceId` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES (1, 'A1', '36d04a9d74392c727b1a9bf97a7bcbac', '1', '2012-03-04 16:00:00', 2, 2);
INSERT INTO `employee` VALUES (2, 'A2', 'e10adc3949ba59abbe56e057f20f883e', '1', '2022-04-14 16:17:32', 3, 2);
INSERT INTO `employee` VALUES (3, 'A3', '74be16979710d4c4e7c6647856088456', '0', '2022-04-14 16:00:00', 2, 2);
INSERT INTO `employee` VALUES (4, 'A4', 'c33367701511b4f6020ec61ded352059', '1', '2022-04-14 16:17:32', 1, 2);
INSERT INTO `employee` VALUES (5, 'A5', 'c33367701511b4f6020ec61ded352059', '0', '2022-04-14 16:17:32', 2, 2);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `gender` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '0 - 女 | 1- 男',
  `brith` datetime NOT NULL,
  `detail` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'V2', '1', '2018-10-15 16:00:00', 'hello,world');
INSERT INTO `user` VALUES (2, 'BB', '1', '2022-04-04 15:57:24', NULL);
INSERT INTO `user` VALUES (3, 'CC', '0', '2022-04-10 15:58:16', NULL);
INSERT INTO `user` VALUES (4, 'DD', '0', '2022-04-14 19:34:55', '123');
INSERT INTO `user` VALUES (6, 'A2', '1', '2018-10-15 16:00:00', 'hello,world');

SET FOREIGN_KEY_CHECKS = 1;
