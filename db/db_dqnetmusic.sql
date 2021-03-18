/*
 Navicat Premium Data Transfer

 Source Server         : Localhost
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : db_dqnetmusic

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 17/03/2021 18:46:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_banner
-- ----------------------------
DROP TABLE IF EXISTS `tb_banner`;
CREATE TABLE `tb_banner`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '项目id、自增id',
  `img` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'banner海报',
  `link` int(11) NOT NULL COMMENT '链接id 指向 song or songlist',
  `type` int(11) NOT NULL COMMENT '指向link类型 song or songlist',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_banner
-- ----------------------------

-- ----------------------------
-- Table structure for tb_comment
-- ----------------------------
DROP TABLE IF EXISTS `tb_comment`;
CREATE TABLE `tb_comment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '项目id、自增id',
  `userid` int(11) NOT NULL COMMENT 'userid',
  `comment` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '评论内容',
  `typeid` int(11) NOT NULL COMMENT '评论的的song or songlist id',
  `type` int(255) NOT NULL COMMENT '指向评论类型 song or songlist',
  `createdate` datetime(0) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_comment
-- ----------------------------
INSERT INTO `tb_comment` VALUES (1, 1, '啊啊啊', 1, 0, '2021-02-12 16:00:00');
INSERT INTO `tb_comment` VALUES (2, 1, '啊啊啊', 1, 0, '2021-02-12 16:00:00');

-- ----------------------------
-- Table structure for tb_like
-- ----------------------------
DROP TABLE IF EXISTS `tb_like`;
CREATE TABLE `tb_like`  (
  `userid` int(11) NOT NULL COMMENT 'userid',
  `likeid` int(11) NOT NULL COMMENT '收藏id 指向 song or songlist',
  `type` int(11) NOT NULL COMMENT '指向收藏类型 song or songlist'
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of tb_like
-- ----------------------------
INSERT INTO `tb_like` VALUES (1, 1, 1);
INSERT INTO `tb_like` VALUES (1, 1, 0);
INSERT INTO `tb_like` VALUES (1, 2, 1);
INSERT INTO `tb_like` VALUES (1, 3, 1);

-- ----------------------------
-- Table structure for tb_song
-- ----------------------------
DROP TABLE IF EXISTS `tb_song`;
CREATE TABLE `tb_song`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '项目id、自增id',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '歌曲名',
  `path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '歌曲文件存放目录',
  `type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '歌曲类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_song
-- ----------------------------

-- ----------------------------
-- Table structure for tb_songlist
-- ----------------------------
DROP TABLE IF EXISTS `tb_songlist`;
CREATE TABLE `tb_songlist`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '项目id、自增id',
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '列表名',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '简介',
  `songlist` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用json存歌曲id',
  `createdate` datetime(0) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_songlist
-- ----------------------------

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '项目id、自增id',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (1, 'blade', '$2a$10$xNav92BGA97yt8Mv73qiruev0IL/5cMP7hFc4TZ5p9hMkvZF0iS1i');
INSERT INTO `tb_user` VALUES (2, 'dq', '321');
INSERT INTO `tb_user` VALUES (5, 'blade1', '123');

SET FOREIGN_KEY_CHECKS = 1;
