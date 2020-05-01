/*
 Navicat MySQL Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : localhost:3306
 Source Schema         : players

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 21/02/2020 22:31:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_ad
-- ----------------------------
DROP TABLE IF EXISTS `t_ad`;
CREATE TABLE `t_ad`  (
  `id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `ad_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '广告名称',
  `ad_link` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '跳转链接',
  `ad_image_dir` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '广告图片存储路径',
  `ad_type` tinyint(4) NOT NULL COMMENT '广告类型 1：底部广告',
  `ad_state` tinyint(4) NOT NULL COMMENT '广告状态 0：正常 1：删除',
  `created` datetime(0) NULL DEFAULT NULL COMMENT '发布时间',
  `updated` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `ad_type`(`ad_type`, `ad_state`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_ad
-- ----------------------------
--INSERT INTO `t_ad` VALUES ('43eb74d29c94496b98084a1746e08842', '张天爱', 'https://www.taobao.com', 'F:\\zhaoyuan\\image\\zhangtianai.jpg', 1, 2, '2020-02-21 21:12:00', '2020-02-21 21:36:10');
--INSERT INTO `t_ad` VALUES ('4808fec7476f4bf5995487dcba4444f9', 'ztas', 'https://www.sina.com', 'F:\\zhaoyuan\\image\\zhangtianai_3u8633.jpg', 1, 0, '2020-02-21 21:37:10', '2020-02-21 21:37:10');

-- ----------------------------
-- Table structure for t_admin_user
-- ----------------------------
DROP TABLE IF EXISTS `t_admin_user`;
CREATE TABLE `t_admin_user`  (
  `id` char(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主鍵',
  `username` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用戶名',
  `password` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密碼',
  `state` tinyint(4) NOT NULL COMMENT '用戶狀態 0：有效 1：鎖定',
  `created` datetime(0) NULL DEFAULT NULL COMMENT '創建時間',
  `updated` datetime(0) NULL DEFAULT NULL COMMENT '更新時間',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_admin_user
-- ----------------------------
INSERT INTO `t_admin_user` VALUES ('7626edcf9380429895bfa337801ef769', 'admin', 'c88df4411808d136e922de694b482832', 0, '2020-02-21 22:33:10', '2020-02-21 22:33:10');
INSERT INTO `t_admin_user` VALUES ('a1b69ddc74744653a372c6f8eb542de5', 'zhaoyuan', 'c88df4411808d136e922de694b482832', 0, '2020-02-20 14:17:10', '2020-02-20 14:17:10');
INSERT INTO `t_admin_user` VALUES ('c6c0d614a406477fb2511838c47be58c', 'zhangzean', 'c88df4411808d136e922de694b482832', 0, '2020-02-20 14:18:08', '2020-02-20 14:18:08');
INSERT INTO `t_admin_user` VALUES ('e4965a4fa3de4e0da7d58202e02f2ffc', 'suofeiya', '701e1f77a892e2843877f6fa3afc518a', 0, '2020-02-12 17:20:19', '2020-02-12 17:20:19');

-- ----------------------------
-- Table structure for t_carousel
-- ----------------------------
DROP TABLE IF EXISTS `t_carousel`;
CREATE TABLE `t_carousel`  (
  `id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `carousel_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `carousel_link` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '跳转的链接',
  `carousel_image_dir` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片存储路径',
  `carousel_price` smallint(5) NULL DEFAULT NULL COMMENT '预计价格',
  `carousel_sort` tinyint(3) NULL DEFAULT NULL COMMENT '排序规则',
  `carousel_state` tinyint(4) NOT NULL COMMENT '状态：0-正常 1：禁用',
  `created` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updated` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id`(`id`) USING BTREE,
  INDEX `carousel_link`(`carousel_link`, `carousel_image_dir`, `carousel_sort`, `carousel_state`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_carousel
-- ----------------------------
--INSERT INTO `t_carousel` VALUES ('5ebbd3ed1d7549548ecc58130317d0af', '马思纯', 'https://baike.baidu.com/item/%E9%A9%AC%E6%80%9D%E7%BA%AF', 'F:\\zhaoyuan\\image\\msc.jpg', 300, 2, 0, '2020-02-19 16:51:56', '2020-02-19 16:51:56');
--INSERT INTO `t_carousel` VALUES ('6660f3d3dc8e47de8a8fa1bdede6f237', '张天爱', 'https://baike.baidu.com/item/%E5%BC%A0%E5%A4%A9%E7%88%B1/14081783?fr=aladdin', 'F:\\zhaoyuan\\image\\zhangtianai.jpg', 520, 1, 0, '2020-02-19 16:19:02', '2020-02-19 16:19:06');
--INSERT INTO `t_carousel` VALUES ('e150bf29e12b482399013470297c5c4d', '科怀·伦纳德', 'https://baike.baidu.com/item/%E7%A7%91%E6%80%80%C2%B7%E4%BC%A6%E7%BA%B3%E5%BE%B7/3780255?fr=aladdin', 'F:\\zhaoyuan\\image\\khlnd.jpg', 50, 1, 0, '2020-02-20 13:47:27', '2020-02-20 13:47:31');
--INSERT INTO `t_carousel` VALUES ('f2cbd89e3c6b4933a9d22b4d9dbb4a38', 'gem', 'https://baike.baidu.com/item/%E9%82%93%E7%B4%AB%E6%A3%8B/6798196?fr=aladdin', 'F:\\zhaoyuan\\image\\gem.jpg', 250, 2, 0, '2020-02-19 16:53:52', '2020-02-20 13:21:41');

-- ----------------------------
-- Table structure for t_log
-- ----------------------------
DROP TABLE IF EXISTS `t_log`;
CREATE TABLE `t_log`  (
  `id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `operator` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '操作人',
  `oper_event` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '操作事件',
  `created` datetime(0) NULL DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_log
-- ----------------------------
--INSERT INTO `t_log` VALUES ('06536cc117aa403583814e686ff18826', 'suofeiya', 'suofeiya登录', '2020-02-20 15:38:04');
--INSERT INTO `t_log` VALUES ('0707fead3f254751ba9f06fe1eddc25f', 'suofeiya', 'suofeiya登录', '2020-02-21 19:21:00');
--INSERT INTO `t_log` VALUES ('0803e7db9d7d43148c29631bba2fc025', 'suofeiya', 'suofeiya登录', '2020-02-20 15:41:22');

-- ----------------------------
-- Table structure for t_media_info
-- ----------------------------
DROP TABLE IF EXISTS `t_media_info`;
CREATE TABLE `t_media_info`  (
  `id` bigint(20) NOT NULL COMMENT '主鍵',
  `media_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '視頻標題',
  `media_size` int(11) NOT NULL COMMENT '視頻大小',
  `media_image_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '視頻截圖存放路徑',
  `media_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '視頻外網url',
  `created` datetime(0) NOT NULL COMMENT '視頻創建時間',
  `updated` datetime(0) NULL DEFAULT NULL COMMENT '視頻更新時間',
  `state` tinyint(4) NOT NULL COMMENT '视频状态 0：正常 1：删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `id`(`id`, `media_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_media_info
-- ----------------------------
--INSERT INTO `t_media_info` VALUES (158166911601392, '邓紫棋(gem)', 333, 'F:\\zhaoyuan\\image\\avatar.jpg', 'blob:https://www.iqiyi.com/1c91678c-267e-4be9-a470-a4c6b8a86839', '2020-02-14 00:00:00', '2020-02-14 18:04:21', 0);
--INSERT INTO `t_media_info` VALUES (158167488857130, 'zhangtianai', 520, 'F:\\zhaoyuan\\image\\zhangtianai.jpg', 'https://baikevideo.cdn.bcebos.com/media/mda-Ogm60VGwqTr85ead/c756867d0a0989fd2d5f745dc6391dda.mp4', '2020-02-14 05:20:00', '2020-02-14 18:08:09', 0);
--INSERT INTO `t_media_info` VALUES (158167560999991, 'masichun', 666, 'F:\\zhaoyuan\\image\\masishun.jpg', 'http://vfx.mtime.cn/Video/2019/03/19/mp4/190319212559089721.mp4', '2020-02-14 18:20:06', '2020-02-14 18:20:10', 0);
--INSERT INTO `t_media_info` VALUES (158175471739362, 'suofeiya', 500, 'F:\\zhaoyuan\\image\\zhangtianai_1.jpg', 'http://vfx.mtime.cn/Video/2019/03/14/mp4/190314102306987969.mp4', '2020-02-15 00:00:00', '2020-02-15 16:30:11', 0);
--INSERT INTO `t_media_info` VALUES (158184200142364, 'zhangtianaimnanlili', 250, 'F:\\zhaoyuan\\image\\zhangtianai.jpg', 'https://vdept.bdstatic.com/726b5331476667715044343261546e6a/323179566469355a/5198996615c0fad9d3f2261b724f63b075af891e645a5a493e4965962d1581c7b4c28aa167421c7fd125d5eb0c9d2f04.mp4?auth_key=1581848946-0-0-42219d164159cd1b78a3562527415a3e', '2020-02-20 00:00:00', '2020-02-20 13:43:43', 0);
--INSERT INTO `t_media_info` VALUES (158217738044690, '科怀·伦纳德', 100, 'F:\\zhaoyuan\\image\\kehuailunnade.jpg', 'https://vfx.mtime.cn/Video/2019/01/15/mp4/190115161611510728_480.mp4', '2020-02-20 00:00:00', '2020-02-20 13:58:23', 0);

-- ----------------------------
-- Table structure for t_media_visit_num
-- ----------------------------
DROP TABLE IF EXISTS `t_media_visit_num`;
CREATE TABLE `t_media_visit_num`  (
  `id` char(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `media_id` bigint(20) NOT NULL COMMENT '视频id',
  `media_visit_num` bigint(10) NOT NULL COMMENT '播放次数',
  `created` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updated` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `media_id`(`media_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_media_visit_num
-- ----------------------------
--INSERT INTO `t_media_visit_num` VALUES ('46d9d69f8cd3466d92e0faa6aaae2551', 158175471739362, 217, '2020-02-15 16:18:37', '2020-02-15 16:18:37');
--INSERT INTO `t_media_visit_num` VALUES ('a53a5b4ed3d344e1a89a033980846a17', 158167560999991, 11, '2020-02-14 18:20:10', '2020-02-14 18:20:10');
--INSERT INTO `t_media_visit_num` VALUES ('a53a5b4ed3d344e1a89a033980846a18', 158166911601392, 111, '2020-02-15 16:11:43', '2020-02-15 16:11:46');
--INSERT INTO `t_media_visit_num` VALUES ('a53a5b4ed3d344e1a89a033980846a19', 158167488857130, 122, '2020-02-15 16:13:10', '2020-02-15 16:13:14');
--INSERT INTO `t_media_visit_num` VALUES ('c24afd2314794284acd1709c56f86707', 158217738044690, 206, '2020-02-20 13:43:00', '2020-02-20 13:43:00');
--INSERT INTO `t_media_visit_num` VALUES ('c2e68b0a0c8a4bb38fdacb5f2564284f', 158184200142364, 509, '2020-02-16 16:33:21', '2020-02-16 16:33:21');

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`  (
  `order_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '订单id',
  `payment` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '实付金额。精确到2位小数;单位:元。如:200.07，表示:200元7分',
  `states` tinyint(4) NULL DEFAULT NULL COMMENT '状态：1、未付款，2、交易成功，3、交易完成 ',
  `created` datetime(0) NULL DEFAULT NULL COMMENT '订单创建时间',
  `updated` datetime(0) NULL DEFAULT NULL COMMENT '订单更新时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '交易完成时间',
  PRIMARY KEY (`order_id`) USING BTREE,
  INDEX `create_time`(`created`) USING BTREE,
  INDEX `status`(`states`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order
-- ----------------------------
--INSERT INTO `t_order` VALUES ('100544158219296209634', '0.01', 1, '2020-02-20 18:02:42', '2020-02-20 18:02:42', NULL);
--INSERT INTO `t_order` VALUES ('100544158219327067923', '0.01', 1, '2020-02-20 18:07:51', '2020-02-20 18:07:51', NULL);
--INSERT INTO `t_order` VALUES ('100544158219336219437', '0.01', 1, '2020-02-20 18:09:22', '2020-02-20 18:09:22', NULL);
-- Table structure for t_visit_num
-- ----------------------------
DROP TABLE IF EXISTS `t_visit_num`;
CREATE TABLE `t_visit_num`  (
  `id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `visit_num` smallint(5) NOT NULL COMMENT '每日访问量',
  `created` date NULL DEFAULT NULL COMMENT '时间',
  `updated` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `created`(`created`) USING BTREE,
  INDEX `visit_num`(`visit_num`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
