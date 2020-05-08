/*
 Navicat Premium Data Transfer

 Source Server         : raylee
 Source Server Type    : MariaDB
 Source Server Version : 50564
 Source Host           : 129.204.220.220:3306
 Source Schema         : raylee

 Target Server Type    : MariaDB
 Target Server Version : 50564
 File Encoding         : 65001

 Date: 08/05/2020 17:45:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for people_daily
-- ----------------------------
DROP TABLE IF EXISTS `people_daily`;
CREATE TABLE `people_daily`  (
  `id` int(11) NOT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `audio_play_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `audio_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `comment_count` int(255) NULL DEFAULT NULL,
  `share_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `seminar_id` int(255) NULL DEFAULT NULL,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config`  (
  `business` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '业务模块',
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '业务功能代码',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '业务功能对应值',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '业务功能代码描述',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建日期',
  `modify_data` datetime(0) NULL DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`business`, `code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_config
-- ----------------------------
INSERT INTO `sys_config` VALUES ('peopledaily', 'listenListAPI', 'https://app.peopleapp.com/Api/600/DetailApi/getListenList', '人民日报文章请求接口', '2019-12-13 10:23:30', '2019-12-13 10:23:30');
INSERT INTO `sys_config` VALUES ('peopledaily', 'paramname', 'seminar_id', '人民日报文章请求接口参数名', '2019-12-13 10:23:30', '2019-12-13 10:23:30');
INSERT INTO `sys_config` VALUES ('peopledaily', 'paramvalue', '[{\"id\":\"52\",\"name\":\"健康侦探\"},{\"id\":\"53\",\"name\":\"美食美地\"},{\"id\":\"54\",\"name\":\"星星晚上好\"},{\"id\":\"55\",\"name\":\"新读新听\"},{\"id\":\"56\",\"name\":\"全天热点梳理\"},{\"id\":\"57\",\"name\":\"夜读\"}]', '人民日报文章请求接口参数集合', '2019-12-13 10:23:31', '2019-12-13 10:23:31');

SET FOREIGN_KEY_CHECKS = 1;
