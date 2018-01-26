/*
Navicat MySQL Data Transfer

Source Server         : 204
Source Server Version : 50552
Source Host           : 192.168.148.17:3306
Source Database       : jiannei

Target Server Type    : MYSQL
Target Server Version : 50552
File Encoding         : 65001

Date: 2018-01-26 16:11:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `mobile` varchar(255) DEFAULT NULL COMMENT '手机号',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父ID',
  `parent_ids` varchar(255) DEFAULT NULL COMMENT '父关联ID',
  `locked` int(11) DEFAULT '0' COMMENT '冻结/激活（0：激活，1：冻结）',
  `created_at` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_at` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `唯一` (`username`,`mobile`,`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='管理员表';

-- ----------------------------
-- Table structure for car
-- ----------------------------
DROP TABLE IF EXISTS `car`;
CREATE TABLE `car` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `user_type` int(11) DEFAULT NULL COMMENT '用户类型',
  `car_number` varchar(255) DEFAULT NULL COMMENT '车牌号',
  `desc` varchar(255) DEFAULT NULL COMMENT '描述',
  `created_at` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_at` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `car_number` (`car_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='车辆信息表';

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `gender` varchar(255) DEFAULT NULL COMMENT '性别',
  `birth_date` date DEFAULT NULL COMMENT '出生日期',
  `mobile` varchar(255) DEFAULT NULL COMMENT '手机号',
  `telephone` varchar(255) DEFAULT NULL COMMENT '电话',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `created_at` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_at` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户表';

-- ----------------------------
-- Table structure for customer_bill
-- ----------------------------
DROP TABLE IF EXISTS `customer_bill`;
CREATE TABLE `customer_bill` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `dealer_id` bigint(20) DEFAULT NULL COMMENT 'dealer id',
  `customer_id` bigint(20) DEFAULT NULL COMMENT '客户ID',
  `customer_name` varchar(255) DEFAULT NULL COMMENT '客户名称',
  `customer_phone` varchar(255) DEFAULT NULL COMMENT '客户手机号',
  `order_id` varchar(255) DEFAULT NULL COMMENT '货单号',
  `total_price` decimal(10,2) DEFAULT NULL COMMENT '总价',
  `actual_price` decimal(10,2) DEFAULT NULL COMMENT '实际总价',
  `paid` decimal(10,2) DEFAULT NULL COMMENT '已支付数额',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `created_at` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_at` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for dealer
-- ----------------------------
DROP TABLE IF EXISTS `dealer`;
CREATE TABLE `dealer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'dealerID',
  `name` varchar(255) DEFAULT NULL COMMENT '负责人名称',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `company_name` varchar(255) DEFAULT NULL COMMENT '公司名',
  `mobile` varchar(255) DEFAULT NULL COMMENT '手机号',
  `telephone` varchar(255) DEFAULT NULL COMMENT '电话',
  `admin_id` bigint(20) DEFAULT NULL COMMENT '创建者ID',
  `province_code` varchar(255) DEFAULT NULL COMMENT '省份CODE',
  `city_code` varchar(255) DEFAULT NULL COMMENT '城市CODE',
  `area_code` varchar(255) DEFAULT NULL COMMENT '地区CODE',
  `address` varchar(500) DEFAULT NULL COMMENT '地址',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `locked` int(11) DEFAULT '0' COMMENT '激活/冻结 （0：激活，1：冻结）',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `invite_code` varchar(255) DEFAULT NULL COMMENT '邀请码',
  `created_at` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_at` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`,`company_name`,`mobile`,`invite_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='dealer表';

-- ----------------------------
-- Table structure for order_product
-- ----------------------------
DROP TABLE IF EXISTS `order_product`;
CREATE TABLE `order_product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `order_id` varchar(255) DEFAULT NULL COMMENT '货单号',
  `product_order` varchar(255) DEFAULT NULL COMMENT '产品订单号',
  `name` varchar(255) DEFAULT NULL COMMENT '产品名称',
  `specification` varchar(255) DEFAULT NULL COMMENT '产品规格',
  `hardness` varchar(255) DEFAULT NULL COMMENT '产品硬度',
  `texture` varchar(255) DEFAULT NULL COMMENT '产品材质',
  `color` varchar(255) DEFAULT NULL COMMENT '产品颜色',
  `customer_weight` double DEFAULT NULL COMMENT '客户货单的产品重量',
  `weight` double DEFAULT NULL COMMENT '实际产品称重',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `status` int(11) DEFAULT '0' COMMENT '状态（0：进厂；1：已分拣；2：已加工；3：已打包；4：已入库；5：已出库）',
  `priority` int(11) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `customer_id` bigint(20) DEFAULT NULL COMMENT '客户ID',
  `dealer_id` bigint(20) DEFAULT NULL COMMENT 'dealer_id',
  `price` decimal(10,2) DEFAULT NULL COMMENT '单价',
  `total_price` decimal(10,2) DEFAULT NULL COMMENT '总价',
  PRIMARY KEY (`id`),
  UNIQUE KEY `order_id` (`order_id`,`product_order`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='货单产品表';

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) DEFAULT NULL COMMENT '产品名称',
  `specification` varchar(255) DEFAULT NULL COMMENT '产品规格',
  `hardness` varchar(255) DEFAULT NULL COMMENT '产品硬度',
  `texture` varchar(255) DEFAULT NULL COMMENT '产品材质',
  `color` varchar(255) DEFAULT NULL COMMENT '产品表色',
  `desc` varchar(255) DEFAULT NULL COMMENT '描述',
  `created_at` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_at` datetime DEFAULT NULL COMMENT '更新时间',
  `creator` bigint(20) DEFAULT NULL COMMENT '创建者ID（dealer）',
  `price` decimal(10,2) DEFAULT NULL COMMENT '单价',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品信息表';

-- ----------------------------
-- Table structure for product_basket
-- ----------------------------
DROP TABLE IF EXISTS `product_basket`;
CREATE TABLE `product_basket` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` varchar(255) DEFAULT NULL COMMENT '货单号',
  `product_order` varchar(255) DEFAULT NULL COMMENT '产品单号',
  `basket_num` int(11) DEFAULT NULL COMMENT '筐号',
  `sort_user` varchar(255) DEFAULT NULL COMMENT '分拣人',
  `area` varchar(255) DEFAULT NULL COMMENT '存放区域',
  `created_at` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_at` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品分拣表';

-- ----------------------------
-- Table structure for product_package
-- ----------------------------
DROP TABLE IF EXISTS `product_package`;
CREATE TABLE `product_package` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` varchar(255) DEFAULT NULL COMMENT '货单号',
  `product_order` varchar(255) DEFAULT NULL COMMENT '产品货单号',
  `package_num` varchar(255) DEFAULT NULL COMMENT '包号',
  `package_weight` double DEFAULT NULL COMMENT '包重',
  `sort_user` varchar(255) DEFAULT NULL COMMENT '打包人',
  `area` varchar(255) DEFAULT NULL COMMENT '存放区域',
  `created_at` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_at` datetime DEFAULT NULL COMMENT '更新时间',
  `status` int(11) DEFAULT '0' COMMENT '状态（0：默认；1：入库；2：出库）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品打包列表';

-- ----------------------------
-- Table structure for resource
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `type` varchar(255) DEFAULT NULL COMMENT '类型（栏目，menu,按钮）',
  `url` varchar(255) DEFAULT NULL COMMENT '相对路径',
  `priority` int(11) DEFAULT NULL COMMENT '显示顺序',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父ID',
  `parent_ids` varchar(255) DEFAULT NULL COMMENT '父ID列表',
  `permission` varchar(255) DEFAULT NULL COMMENT '权限字符串',
  `available` int(11) DEFAULT '0' COMMENT '是否可用（0：可用，1：不可以）',
  `created_at` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_at` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源表';

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `desc` varchar(255) DEFAULT NULL COMMENT '描述',
  `created_at` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_at` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Table structure for role_resource
-- ----------------------------
DROP TABLE IF EXISTS `role_resource`;
CREATE TABLE `role_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `res_id` bigint(20) DEFAULT NULL COMMENT '资源ID',
  `created_at` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_at` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色资源表';

-- ----------------------------
-- Table structure for user_order
-- ----------------------------
DROP TABLE IF EXISTS `user_order`;
CREATE TABLE `user_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `order_id` varchar(255) DEFAULT NULL COMMENT '货单号',
  `customer_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `customer_name` varchar(255) DEFAULT NULL COMMENT '用户名称',
  `customer_phone` varchar(255) DEFAULT NULL COMMENT '用户电话',
  `car_number` varchar(255) DEFAULT NULL COMMENT '车牌号',
  `total_weight` double DEFAULT NULL COMMENT '总重量',
  `car_weight` double DEFAULT NULL COMMENT '车重',
  `status` int(11) DEFAULT '0' COMMENT '状态（0：已进厂；1：已分拣：2：已镀锌；3：已入库；4：已出库）',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `dealer_id` bigint(20) DEFAULT NULL COMMENT 'dealer id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `order_id` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='货单表';

-- ----------------------------
-- Table structure for user_token
-- ----------------------------
DROP TABLE IF EXISTS `user_token`;
CREATE TABLE `user_token` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `user_type` int(11) DEFAULT NULL COMMENT '用户类型',
  `access_token` varchar(255) DEFAULT NULL COMMENT '访问token',
  `refresh_token` varchar(255) DEFAULT NULL COMMENT '刷新token',
  `expired` bigint(20) DEFAULT NULL COMMENT '有效期',
  `created_at` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_at` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `唯一` (`access_token`,`refresh_token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for worker
-- ----------------------------
DROP TABLE IF EXISTS `worker`;
CREATE TABLE `worker` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `gender` varchar(255) DEFAULT NULL COMMENT '性别',
  `birth_date` date DEFAULT NULL COMMENT '出生日期',
  `mobile` varchar(255) DEFAULT NULL COMMENT '手机号',
  `native_place` varchar(255) DEFAULT NULL COMMENT '籍贯',
  `dealer_id` bigint(20) DEFAULT NULL COMMENT 'dealer ID',
  `work_type` int(255) DEFAULT NULL COMMENT '工种',
  `locked` int(11) DEFAULT '0' COMMENT '激活/冻结 （0：激活；1：冻结）',
  `created_at` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_at` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工人表';
