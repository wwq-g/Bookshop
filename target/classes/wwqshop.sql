/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50733
 Source Host           : localhost:3306
 Source Schema         : wwqshop

 Target Server Type    : MySQL
 Target Server Version : 50733
 File Encoding         : 65001

 Date: 23/02/2021 20:33:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for wwq_cart
-- ----------------------------
DROP TABLE IF EXISTS `wwq_cart`;
CREATE TABLE `wwq_cart`  (
  `cart_id` int(11) NOT NULL AUTO_INCREMENT,
  `cart_p_filename` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cart_p_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cart_p_price` decimal(10, 2) NULL DEFAULT NULL,
  `cart_p_quantity` int(11) NULL DEFAULT NULL,
  `cart_p_stock` int(11) NULL DEFAULT NULL,
  `cart_p_id` int(11) NULL DEFAULT NULL,
  `cart_u_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cart_valid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`cart_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for wwq_category
-- ----------------------------
DROP TABLE IF EXISTS `wwq_category`;
CREATE TABLE `wwq_category`  (
  `cate_id` int(10) NOT NULL AUTO_INCREMENT,
  `cate_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '分类名称',
  `cate_parent_id` decimal(10, 0) NOT NULL COMMENT '父级id',
  PRIMARY KEY (`cate_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for wwq_product
-- ----------------------------
DROP TABLE IF EXISTS `wwq_product`;
CREATE TABLE `wwq_product`  (
  `product_id` int(10) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_description` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `product_price` decimal(10, 2) NOT NULL,
  `product_stock` decimal(10, 0) NULL DEFAULT NULL,
  `product_fid` decimal(10, 0) NULL DEFAULT NULL,
  `product_cid` decimal(10, 0) NULL DEFAULT NULL,
  `product_filename` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`product_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for wwq_user
-- ----------------------------
DROP TABLE IF EXISTS `wwq_user`;
CREATE TABLE `wwq_user`  (
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sex` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `mobile` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `birthday` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(10) NOT NULL,
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
