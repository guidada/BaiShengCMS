/*
 Navicat Premium Data Transfer

 Source Server         : laycoding
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : 111.230.135.188:3306
 Source Schema         : db_bs_cms

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 15/06/2019 00:12:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_franchisee
-- ----------------------------
DROP TABLE IF EXISTS `sys_franchisee`;
CREATE TABLE `sys_franchisee`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `sys_cs_id` int(10) NULL DEFAULT 0,
  `sys_cs_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '*',
  `sys_cs_company` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '*',
  `sys_cs_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '*',
  `sys_cs_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0.00',
  `sys_cs_money` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0.00',
  `sys_cs_project` int(10) NULL DEFAULT 0,
  `sys_cs_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0',
  `sys_cs_remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '*',
  `sys_cs_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '*',
  `sys_cs_license` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sys_cs_idcard` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '*',
  `sys_cs_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '*',
  `sys_cs_zipcode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '*',
  `sys_cs_email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '*',
  `sys_cs_region` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '*',
  `sys_company_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '*',
  `sys_cs_sex` int(1) NULL DEFAULT 0,
  `sys_create_time` datetime(0) NULL DEFAULT '2019-04-28 00:00:00',
  `sys_over_time` datetime(0) NULL DEFAULT '2019-04-28 00:00:00',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_franchisee
-- ----------------------------
INSERT INTO `sys_franchisee` VALUES (3, 201900001, '张三', NULL, '加盟', '6888.00', '1500000.00', 4, '1', '呵呵呵', '18611511365', NULL, '220104198001126368', '黄村', NULL, NULL, '北京市/北京市/房山区', '', 1, '2015-05-04 00:00:00', '2026-05-04 00:00:00');
INSERT INTO `sys_franchisee` VALUES (4, 201900001, '张三', NULL, '加盟', '6888.00', '1500000.00', 4, '1', '呵呵呵', '18611511365', NULL, '220104198001126368', '黄村', NULL, NULL, '北京市/北京市/房山区', '', 1, '2015-05-04 00:00:00', '2026-05-04 00:00:00');
INSERT INTO `sys_franchisee` VALUES (5, 291801, '李思思', NULL, '加盟', '10000', '6888', 2, '1', '区代', '13657018728', NULL, '220104198001126368', '江西省上饶市信州区', NULL, NULL, '安徽省/芜湖市', '江西省上饶市信州区上饶师范学院', 0, '2019-05-07 00:00:00', '2025-05-04 00:00:00');
INSERT INTO `sys_franchisee` VALUES (6, 3645452, '王小小', NULL, '普通合同', '6888', '6888', 1, '0', '..', '13657018728', NULL, '330622199904271234', 'sadsa', NULL, NULL, '北京市/北京市/房山区', '北京市/北京市/房山区/***街道', 0, '2019-05-18 00:00:00', '2019-05-25 00:00:00');
INSERT INTO `sys_franchisee` VALUES (7, 12334456, '孔小二', NULL, '加盟', '6888', '6888', 1, '0', '代理', '13601010233', NULL, '220124198101062234', '吉林德惠', NULL, NULL, '北京市/北京市/东城区', '东城九号', 0, '2019-05-05 00:00:00', '2020-05-05 00:00:00');

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `resource` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES (1, '客户查询', 'customer:query');
INSERT INTO `sys_permission` VALUES (2, '区域查询', 'region:query');
INSERT INTO `sys_permission` VALUES (3, '合同查询', 'contract:query');
INSERT INTO `sys_permission` VALUES (4, '合同添加', 'contract:add');
INSERT INTO `sys_permission` VALUES (5, '加盟分布', 'affiliate:distribution');
INSERT INTO `sys_permission` VALUES (6, '金额汇总', 'count:money');
INSERT INTO `sys_permission` VALUES (7, '用户管理', 'user:management');
INSERT INTO `sys_permission` VALUES (8, '权限管理', 'privilege:management');

-- ----------------------------
-- Table structure for sys_projects
-- ----------------------------
DROP TABLE IF EXISTS `sys_projects`;
CREATE TABLE `sys_projects`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `sys_project_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_projects
-- ----------------------------
INSERT INTO `sys_projects` VALUES (1, '佰晟练字');
INSERT INTO `sys_projects` VALUES (2, '恋笔作文');
INSERT INTO `sys_projects` VALUES (3, '智说口才');
INSERT INTO `sys_projects` VALUES (4, '涂乐美术');
INSERT INTO `sys_projects` VALUES (5, '朗讯速读');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sn` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '管理员', 'emplyee-admin');

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `pid` int(10) NOT NULL,
  `role_id` int(10) NOT NULL,
  `permission_id` int(10) NOT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '*',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES (1, 0, 0, 0, '管理员');
INSERT INTO `sys_role_permission` VALUES (2, 0, 0, 0, '项目员');
INSERT INTO `sys_role_permission` VALUES (3, 0, 0, 0, '录入员');
INSERT INTO `sys_role_permission` VALUES (23, 2, 2, 1, '*');
INSERT INTO `sys_role_permission` VALUES (24, 2, 2, 2, '*');
INSERT INTO `sys_role_permission` VALUES (25, 2, 2, 3, '*');
INSERT INTO `sys_role_permission` VALUES (26, 1, 1, 1, '*');
INSERT INTO `sys_role_permission` VALUES (27, 1, 1, 2, '*');
INSERT INTO `sys_role_permission` VALUES (28, 1, 1, 3, '*');
INSERT INTO `sys_role_permission` VALUES (29, 1, 1, 4, '*');
INSERT INTO `sys_role_permission` VALUES (30, 1, 1, 5, '*');
INSERT INTO `sys_role_permission` VALUES (31, 1, 1, 6, '*');
INSERT INTO `sys_role_permission` VALUES (32, 1, 1, 7, '*');
INSERT INTO `sys_role_permission` VALUES (33, 1, 1, 8, '*');
INSERT INTO `sys_role_permission` VALUES (34, 3, 3, 4, '*');

-- ----------------------------
-- Table structure for sys_tb_contract
-- ----------------------------
DROP TABLE IF EXISTS `sys_tb_contract`;
CREATE TABLE `sys_tb_contract`  (
  `sys_ct_num` int(10) NOT NULL,
  `sys_ct_image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_tb_contract
-- ----------------------------
INSERT INTO `sys_tb_contract` VALUES (20190001, 'e5f67d63-efbf-4b66-89c7-2f123063b7b3.jpg');
INSERT INTO `sys_tb_contract` VALUES (20190001, '6ce41d0c-5e24-431f-acda-9760b7b89061.jpg');
INSERT INTO `sys_tb_contract` VALUES (20190001, '78d399ac-eb73-4f9b-89fe-ab1a13b5f9c5.JPG');
INSERT INTO `sys_tb_contract` VALUES (20190001, '16a895d9-28fc-4ce6-8d03-9b173709e5cc.jpg');
INSERT INTO `sys_tb_contract` VALUES (20190001, '75bcbc9f-652e-423d-bbc8-7a5af0c329ec.jpg');
INSERT INTO `sys_tb_contract` VALUES (20190001, '7003cb5d-903e-4902-8287-a21a564b86e6.jpg');
INSERT INTO `sys_tb_contract` VALUES (201801, 'e7303a93-efdd-46bc-95d9-3c7192f32be6.jpg');
INSERT INTO `sys_tb_contract` VALUES (201900001, '6c4bc3d2-ad3c-4ab8-8dbe-abcefa8f1219.png');
INSERT INTO `sys_tb_contract` VALUES (201900001, 'c80942d5-f6cd-42f8-8fc8-ba46e78e6d29.png');

-- ----------------------------
-- Table structure for sys_tb_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_tb_user`;
CREATE TABLE `sys_tb_user`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `sys_user` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sys_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sys_nick` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sys_status` int(1) NULL DEFAULT 0,
  `sys_create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  `sys_update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_tb_user
-- ----------------------------
INSERT INTO `sys_tb_user` VALUES (1, 'admin', 'bbad8d72c1fac1d081727158807a8798', '管理员', 0, '2019-04-26 11:26:01', '2019-04-26 11:26:01');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `user_id` int(10) NOT NULL,
  `role_id` int(10) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1);
INSERT INTO `sys_user_role` VALUES (3, 3);
INSERT INTO `sys_user_role` VALUES (4, 2);

SET FOREIGN_KEY_CHECKS = 1;
