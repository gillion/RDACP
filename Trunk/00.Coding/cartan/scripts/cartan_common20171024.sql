/*
SQLyog v10.2 
MySQL - 5.1.62-community : Database - cartan_common
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`cartan_common` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `cartan_common`;

/*Table structure for table `t_app` */

DROP TABLE IF EXISTS `t_app`;

CREATE TABLE `t_app` (
  `app_name` varchar(30) NOT NULL COMMENT '应用名称(英文代号，唯一)',
  `app_label` varchar(60) DEFAULT NULL COMMENT '应用标识名',
  `appkey` varchar(36) DEFAULT NULL COMMENT '应用键',
  `secret` varchar(30) DEFAULT NULL COMMENT '密钥，30位随机串',
  `description` varchar(200) DEFAULT NULL COMMENT '描述',
  `author` char(36) NOT NULL COMMENT '申请者',
  `create_time` char(14) NOT NULL COMMENT '创建时间',
  `status` char(1) DEFAULT NULL COMMENT '状态 1：未审核 2：审核通过 3：不通过',
  `auditor` char(36) DEFAULT NULL COMMENT '审核者',
  `audit_info` varchar(500) DEFAULT NULL COMMENT '审核意见',
  `audit_time` char(14) DEFAULT NULL COMMENT '审核时间',
  `curr_version` varchar(10) DEFAULT NULL COMMENT '最新版本',
  PRIMARY KEY (`app_name`),
  KEY `ak_app_appkey` (`appkey`),
  KEY `idx_app_crtime` (`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='移动应用注册表,开发者提出申请,申请审核通过后生成appkey/secret';

/*Data for the table `t_app` */

/*Table structure for table `t_codegener` */

DROP TABLE IF EXISTS `t_codegener`;

CREATE TABLE `t_codegener` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `SETUP_NAME` varchar(1000) DEFAULT NULL COMMENT '配置名称',
  `BASE_PACKAGE` varchar(200) DEFAULT NULL COMMENT '基础包',
  `MODULE_NAME` varchar(200) DEFAULT NULL COMMENT '模块名',
  `ROOT` varchar(1000) DEFAULT NULL COMMENT '根目录',
  `OUTPUT` varchar(1000) DEFAULT NULL COMMENT '输出路径',
  `SYSNAME` varchar(200) DEFAULT NULL COMMENT '系统名称',
  `STATUS` varchar(50) DEFAULT NULL COMMENT '状态',
  `LOCK_MAN` varchar(50) DEFAULT NULL COMMENT '锁定人',
  `LOCK_TIME` varchar(50) DEFAULT NULL COMMENT '锁定时间',
  `projectName` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='基本配置';

/*Data for the table `t_codegener` */

insert  into `t_codegener`(`ID`,`SETUP_NAME`,`BASE_PACKAGE`,`MODULE_NAME`,`ROOT`,`OUTPUT`,`SYSNAME`,`STATUS`,`LOCK_MAN`,`LOCK_TIME`,`projectName`) values ('1001','TBS订单管理','cn.cst.jfgl','order','E:\\project\\pdmsCodeGener\\CodeGener','','jfgl-tbs-web','102','liuxb','2016-08-03 8:50:22','jfgl'),('1002','TBS积分管理','cn.cst.jfgl','credit','E:\\project\\pdmsCodeGener\\CodeGener','','jfgl-tbs-web','102','liuxb','2016-08-03 8:50:27','jfgl'),('1003','TBS礼品管理','cn.cst.jfgl','present','E:\\project\\pdmsCodeGener\\CodeGener','','jfgl-tbs-web','102','liuxb','2016-08-03 8:50:32','jfgl'),('1004','TBS系统管理','cn.cst.jfgl','system','E:\\project\\pdmsCodeGener\\CodeGener','','jfgl-tbs-web','102','liuxb','2016-08-03 8:50:37','jfgl'),('1005','TBS销量管理','cn.cst.jfgl','sales','E:\\project\\pdmsCodeGener\\CodeGener','','jfgl-tbs-web','102','liuxb','2016-08-03 8:50:42','jfgl'),('1006','TBS咨讯管理','cn.cst.jfgl','message','E:\\project\\pdmsCodeGener\\CodeGener','','jfgl-tbs-web','102','liuxb','2016-08-03 8:50:47','jfgl'),('1007','TBS公共表','cn.cst.jfgl','syscom','E:\\project\\pdmsCodeGener\\CodeGener','','jfgl-tbs-web','102','liuxb','2016-08-03 8:50:52','jfgl'),('1008','TBS主数据','cn.cst.jfgl','mdm','E:\\project\\pdmsCodeGener\\CodeGener','','jfgl-tbs-web','102','liuxb','2016-08-03 8:50:58','jfgl'),('1009','PCR订单管理','cn.cst.jfgl','order','E:\\project\\pdmsCodeGener\\CodeGener','','jfgl-pcr-web','102','liuxb','2016-08-03 8:51:3','jfgl'),('1010','PCR积分管理','cn.cst.jfgl','credit','E:\\project\\pdmsCodeGener\\CodeGener','','jfgl-pcr-web','102','liuxb','2016-08-03 8:51:8','jfgl'),('1011','PCR礼品管理','cn.cst.jfgl','present','E:\\project\\pdmsCodeGener\\CodeGener','','jfgl-pcr-web','102','liuxb','2016-08-03 8:51:14','jfgl'),('1012','PCR系统管理','cn.cst.jfgl','system','E:\\project\\pdmsCodeGener\\CodeGener','','jfgl-pcr-web','102','liuxb','2016-08-03 8:51:19','jfgl'),('1013','PCR销量管理','cn.cst.jfgl','sales','E:\\project\\pdmsCodeGener\\CodeGener','','jfgl-pcr-web','102','liuxb','2016-08-03 8:51:23','jfgl'),('1014','PCR咨讯管理','cn.cst.jfgl','message','E:\\project\\pdmsCodeGener\\CodeGener','','jfgl-pcr-web','102','liuxb','2016-08-03 8:51:29','jfgl'),('1015','PCR公共表','cn.cst.jfgl','syscom','E:\\project\\pdmsCodeGener\\CodeGener','','jfgl-pcr-web','102','liuxb','2016-08-03 8:51:34','jfgl'),('1016','PCR主数据','cn.cst.jfgl','mdm','E:\\project\\pdmsCodeGener\\CodeGener','','jfgl-pcr-web','102','liuxb','2016-08-03 8:51:39','jfgl'),('2001','JM基础管理','cn.cst.pdqc.jm','system','c:\\workspace\\pdmsCodeGener\\pdqc','','pdqc-web','101','','','pdqc'),('3001','主数据管理','cn.com.xcs.framework.cppz','system','E:\\project\\pdmsCodeGener\\pdqc','','pdqc',NULL,NULL,NULL,'mdm'),('32FAD1BF-23F0-4AA1-B80E-9C6874DF86B9','PCR礼品管理测试','cn.cst.jfgl','present','E:\\project\\pdmsCodeGener\\CodeGener',NULL,'jfgl-cst-web','101',NULL,NULL,'jfgl'),('9C8FD897-02C3-401D-874D-E4BFF07E31F2','公共配置','cn.cst.pdqc.hy','common','C:\\workspace\\pdmsCodeGener\\cts',NULL,'cts','101',NULL,NULL,'cts'),('D310E222-7BC9-448B-B394-B0ED95AF83E7','HY基础管理','cn.cst.pdqc.hy','system','c:\\workspace\\pdmsCodeGener\\pdqc',NULL,'pdqc-web','101',NULL,NULL,'pdqc'),('E0FECF94-7B49-403B-97B6-A8711F187FF4','KCGL礼品管理测试','cn.cst.kcgl','present','E:\\project\\pdmsCodeGener\\CodeGener','','kcgl-web','101','','','jfgl');

/*Table structure for table `t_codegener_checkbox` */

DROP TABLE IF EXISTS `t_codegener_checkbox`;

CREATE TABLE `t_codegener_checkbox` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `SETUP_ID` varchar(50) DEFAULT NULL COMMENT '基本配置',
  `TABLE_ID` varchar(50) DEFAULT NULL COMMENT '关联模型',
  `CHECKBOX_FIELD` varchar(50) DEFAULT NULL COMMENT '复选字段',
  `CODE_TYPE` varchar(50) DEFAULT NULL COMMENT '代码类型',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='复选组件';

/*Data for the table `t_codegener_checkbox` */

insert  into `t_codegener_checkbox`(`ID`,`SETUP_ID`,`TABLE_ID`,`CHECKBOX_FIELD`,`CODE_TYPE`) values ('1001','6001','5002','isDecisionTable','T014');

/*Table structure for table `t_codegener_combobox` */

DROP TABLE IF EXISTS `t_codegener_combobox`;

CREATE TABLE `t_codegener_combobox` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `SETUP_ID` varchar(50) DEFAULT NULL COMMENT '基本配置',
  `TABLE_ID` varchar(50) DEFAULT NULL COMMENT '关联模型',
  `COMBOBOX_FIELD` varchar(50) DEFAULT NULL COMMENT '下拉字段',
  `CODE_TYPE` varchar(50) DEFAULT NULL COMMENT '代码类型',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='下拉组件';

/*Data for the table `t_codegener_combobox` */

insert  into `t_codegener_combobox`(`ID`,`SETUP_ID`,`TABLE_ID`,`COMBOBOX_FIELD`,`CODE_TYPE`) values ('1001','6001','5001','triggerType','T009'),('1002','6001','5001','actionType','T010'),('1003','6001','5001','ruleType','T008'),('1004','6001','5001','ruleStatus','T006'),('1005','6001','5001','publicType','T007'),('1006','6001','5003','templateType','T068');

/*Table structure for table `t_codegener_radio` */

DROP TABLE IF EXISTS `t_codegener_radio`;

CREATE TABLE `t_codegener_radio` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `SETUP_ID` varchar(50) DEFAULT NULL COMMENT '基本配置',
  `TABLE_ID` varchar(50) DEFAULT NULL COMMENT '关联模型',
  `RADIO_FIELD` varchar(50) DEFAULT NULL COMMENT '单选字段',
  `CODE_TYPE` varchar(50) DEFAULT NULL COMMENT '代码类型',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='单选组件';

/*Data for the table `t_codegener_radio` */

insert  into `t_codegener_radio`(`ID`,`SETUP_ID`,`TABLE_ID`,`RADIO_FIELD`,`CODE_TYPE`) values ('1001','6001','5002','srcPath','102');

/*Table structure for table `t_codegener_select` */

DROP TABLE IF EXISTS `t_codegener_select`;

CREATE TABLE `t_codegener_select` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `SETUP_ID` varchar(50) DEFAULT NULL COMMENT '基本配置',
  `TABLE_ID` varchar(50) DEFAULT NULL COMMENT '关联模型',
  `SELECT_FIELD` varchar(50) DEFAULT NULL COMMENT '弹出字段',
  `SELECT_TABLE` varchar(50) DEFAULT NULL COMMENT '取数模型',
  `SELECT_DES` varchar(50) DEFAULT NULL COMMENT '描述字段',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='弹出组件';

/*Data for the table `t_codegener_select` */

insert  into `t_codegener_select`(`ID`,`SETUP_ID`,`TABLE_ID`,`SELECT_FIELD`,`SELECT_TABLE`,`SELECT_DES`) values ('1001','6001','5001','ipfCcmBoId','IpfCcmBo','boName');

/*Table structure for table `t_codegener_table` */

DROP TABLE IF EXISTS `t_codegener_table`;

CREATE TABLE `t_codegener_table` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `SETUP_ID` varchar(50) DEFAULT NULL COMMENT '配置名称',
  `TABLE_NAME` varchar(200) DEFAULT NULL COMMENT '表名',
  `TABLE_DES` varchar(200) DEFAULT NULL COMMENT '中文描述',
  `PARENT_TABLE_NAME` varchar(200) DEFAULT NULL COMMENT '继承表名',
  `NO_PARENT` varchar(3) DEFAULT NULL COMMENT '无公共字段',
  `IS_NEW_BSCLASS` varchar(3) DEFAULT NULL COMMENT '是否新建业务类',
  `PAGE_SIZE` varchar(50) DEFAULT NULL COMMENT '编辑列数',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='关联模型';

/*Data for the table `t_codegener_table` */

insert  into `t_codegener_table`(`ID`,`SETUP_ID`,`TABLE_NAME`,`TABLE_DES`,`PARENT_TABLE_NAME`,`NO_PARENT`,`IS_NEW_BSCLASS`,`PAGE_SIZE`) values ('1001','1001','t_sctbs_promotion_order','促销品订单','','0','1','2'),('1002','1001','t_sctbs_prom_order_detail','促销品订单明细','','0','1','2'),('1003','1001','t_sctbs_prom_cons_order','促销品合并订单','','0','1','2'),('1004','1001','t_sctbs_present_order','礼品订单（原始）','','0','1','2'),('1005','1001','t_sctbs_present_order_dtl','礼品订单明细（原始）','','0','1','2'),('1006','1001','t_sctbs_order_deliver','订单物流信息','','0','1','2'),('1007','1001','t_sctbs_shopping_cart','购物车(缓存库）','','0','1','2'),('1008','1001','t_sctbs_supplier_order','合并订单（供应商）','','0','1','2'),('1009','1002','t_sctbs_award_punish','积分奖罚','','0','1','2'),('1010','1002','t_sctbs_credit_clear','积分清零及返还','','0','1','2'),('1011','1002','t_sctbs_credit_overdraft','积分提前消费','','0','1','2'),('1012','1002','t_sctbs_credit_acnt','积分账户','','0','1','2'),('1013','1002','t_sctbs_credit_acnt_detail','积分账户明细','','0','1','2'),('1014','1003','t_sctbs_present_store','礼品库存信息','','0','1','2'),('1015','1003','t_sctbs_present_type','礼品类别','','0','1','2'),('1016','1003','t_sctbs_promotion_ware','促销品库存信息','','0','1','2'),('1017','1003','t_sctbs_supplier','供应商','','0','1','2'),('1018','1003','t_sctbs_promotion','促销活动','','0','1','2'),('1019','1003','t_sctbs_promotion_shop','促销活动店铺信息','','0','1','2'),('1020','1004','t_sctbs_best_shop','优秀店家','','0','1','2'),('1021','1004','t_sctbs_best_shop_dtl','优秀店家明细表','','0','1','2'),('1022','1004','t_sctbs_exchange_date','兑换时间设置（含清零兑换）','','0','1','2'),('1023','1004','t_sctbs_guide_content','积分项目指引内容','','0','1','2'),('1024','1004','t_sctbs_shop_agent','协助店铺兑换','','0','1','2'),('1025','1004','t_sctbs_economy_product','TBS经济型产品','','0','1','2'),('1026','1004','t_sctbs_convertible_rule','TBS积分规则','','0','1','2'),('1027','1004','t_sctbs_return_rule','TBS退货积分规则','','0','1','2'),('1028','1005','t_sctbs_sales_record_detail','店铺销量登记明细（月）','','0','1','2'),('1029','1005','t_sctbs_sales_record_mon','店铺销量登记（月）','','0','1','2'),('1030','1005','t_sctbs_sales_rebate','店铺销售返利','','0','1','2'),('1031','1006','t_sctbs_inner_msg','咨讯','','0','1','2'),('1032','1006','t_sctbs_msg_user','咨讯接收者','','0','1','2'),('1033','1006','t_sctbs_mail_msg','邮件消息','','0','1','2'),('1034','1006','t_sctbs_sms_send','短信发送记录','','0','1','2'),('1035','1006','t_sctbs_sms_send_hand','手工短信','','0','1','2'),('1036','1006','t_sctbs_question','意见','','0','1','2'),('1037','1006','t_sctbs_reply','反馈','','0','1','2'),('1038','1006','t_sctbs_attach_info','附件信息表','','0','1','2'),('1039','1006','t_sctbs_attach_info_detail','附件明细表','','0','1','2'),('1040','1007','t_sctbs_check_code','验证码表','','0','1','2'),('1041','1007','t_sctbs_sys_param','系统参数表','','0','1','2'),('1042','1007','t_sctbs_shop_addr','店铺地址表','','0','1','2'),('1043','1007','t_sctbs_user_base_info','商城用户基础信息','','0','1','2'),('1044','1007','t_sctbs_slide_pic','图片幻灯片','','0','1','2'),('1045','1007','t_cst_role','角色表','','2','1','2'),('1046','1007','t_cst_menu','菜单表','','2','1','2'),('1047','1007','t_cst_authority','权限表','','2','1','2'),('1048','1007','t_cst_resource','资源表','','2','1','2'),('1049','1007','t_cst_role_user','角色用户表','','2','1','2'),('1050','1007','t_cst_role_out_user','角色外网用户表','','2','1','2'),('1051','1007','t_cst_role_authority','角色权限表','','2','1','2'),('1052','1007','t_cst_authority_resource','权限资源表','','2','1','2'),('1053','1007','t_cst_login_log','登录日志表','','2','1','2'),('1054','1007','t_cst_operate_log','操作日志表','','2','1','2'),('1055','1007','t_cst_sup_del_user','供应商物流用户表','','2','1','2'),('1056','1008','t_cst_mdm_product_info','商品信息表','','1','1','2'),('1057','1008','t_cst_mdm_shop','销售门店','','1','1','2'),('1058','1008','t_cst_mdm_dealer','经销商','','1','1','2'),('1059','1008','t_cst_mdm_dealer_cust_config','经销商母客户代号关联表','','1','1','2'),('1060','1008','t_cst_mdm_ccode_info','客户代号','','1','1','2'),('1061','1008','t_cst_mdm_groupalias','组别','','1','1','2'),('1062','1008','t_cst_mdm_brand','品牌','','1','1','2'),('1063','1008','t_cst_mdm_user_groups','用户组别关联表','','1','1','2'),('1064','1008','t_cst_user','内部用户表','','1','1','2'),('1065','1008','t_cst_mdm_out_user','外部用户表','','1','1','2'),('1066','1008','t_cst_conf_dictionary','字典表','','1','1','2'),('1067','1008','t_cst_conf_dictitem','字典明细表','','1','1','2'),('1068','1008','v_cst_out_user','外部用户视图','','1','1','2'),('1069','1009','t_scpcr_promotion_order','促销品订单','t_sctbs_promotion_order','0','1','2'),('1070','1009','t_scpcr_prom_order_detail','促销品订单明细','t_sctbs_prom_order_detail','0','1','2'),('1071','1009','t_scpcr_prom_cons_order','促销品合并订单','t_sctbs_prom_cons_order','0','1','2'),('1072','1009','t_scpcr_present_order','礼品订单（原始）','t_sctbs_present_order','0','1','2'),('1073','1009','t_scpcr_present_order_dtl','礼品订单明细（原始）','t_sctbs_present_order_dtl','0','1','2'),('1074','1009','t_scpcr_order_deliver','订单物流信息','t_sctbs_order_deliver','0','1','2'),('1075','1009','t_scpcr_shopping_cart','购物车(缓存库）','t_sctbs_shopping_cart','0','1','2'),('1076','1009','t_scpcr_supplier_order','合并订单（供应商）','t_sctbs_supplier_order','0','1','2'),('1077','1010','t_scpcr_award_punish','积分奖罚','t_sctbs_award_punish','0','1','2'),('1078','1010','t_scpcr_credit_clear','积分清零及返还','t_sctbs_credit_clear','0','1','2'),('1079','1010','t_scpcr_credit_overdraft','积分提前消费','t_sctbs_credit_overdraft','0','1','2'),('1080','1010','t_scpcr_credit_acnt','积分账户','t_sctbs_credit_acnt','0','1','2'),('1081','1010','t_scpcr_credit_acnt_detail','积分账户明细','t_sctbs_credit_acnt_detail','0','1','2'),('1082','1011','t_scpcr_present_store','礼品库存信息','t_sctbs_present_store','0','1','2'),('1083','1011','t_scpcr_present_type','礼品类别','t_sctbs_present_type','0','1','2'),('1084','1011','t_scpcr_promotion_ware','促销品库存信息','t_sctbs_promotion_ware','0','1','2'),('1085','1011','t_scpcr_supplier','供应商','t_sctbs_supplier','0','1','2'),('1086','1011','t_scpcr_promotion','促销活动','t_sctbs_promotion','0','1','2'),('1087','1011','t_scpcr_promotion_shop','促销活动店铺信息','t_sctbs_promotion_shop','0','1','2'),('1088','1012','t_scpcr_best_shop','优秀店家','t_sctbs_best_shop','0','1','2'),('1089','1012','t_scpcr_best_shop_dtl','优秀店家明细表','t_sctbs_best_shop_dtl','0','1','2'),('1090','1012','t_scpcr_exchange_date','兑换时间设置（含清零兑换）','t_sctbs_exchange_date','0','1','2'),('1091','1012','t_scpcr_guide_content','积分项目指引内容','t_sctbs_guide_content','0','1','2'),('1092','1012','t_scpcr_shop_agent','协助店铺兑换','t_sctbs_shop_agent','0','1','2'),('1093','1012','t_scpcr_siging_level','PCR签约级别维护','','0','1','2'),('1094','1012','t_scpcr_siging_standard','PCR店铺签约标准','','0','1','2'),('1095','1012','t_scpcr_convertible_rule','PCR积分规则','','0','1','2'),('1096','1013','t_scpcr_sales_record_detail','店铺销量登记明细（月）','t_sctbs_sales_record_detail','0','1','2'),('1097','1013','t_scpcr_sales_record_mon','店铺销量登记（月）','t_sctbs_sales_record_mon','0','1','2'),('1098','1013','t_scpcr_sales_rebate','店铺销售返利','t_sctbs_sales_rebate','0','1','2'),('1099','1014','t_scpcr_inner_msg','咨讯','t_sctbs_inner_msg','0','1','2'),('1100','1014','t_scpcr_msg_user','咨讯接收者','t_sctbs_msg_user','0','1','2'),('1101','1014','t_scpcr_mail_msg','邮件消息','t_sctbs_mail_msg','0','1','2'),('1102','1014','t_scpcr_sms_send','短信发送记录','t_sctbs_sms_send','0','1','2'),('1103','1014','t_scpcr_sms_send_hand','手工短信','t_sctbs_sms_send_hand','0','1','2'),('1104','1014','t_scpcr_question','意见','t_sctbs_question','0','1','2'),('1105','1014','t_scpcr_reply','反馈','t_sctbs_reply','0','1','2'),('1106','1014','t_scpcr_attach_info','附件信息表','t_sctbs_attach_info','0','1','2'),('1107','1014','t_scpcr_attach_info_detail','附件明细表','t_sctbs_attach_info_detail','0','1','2'),('1108','1015','t_scpcr_check_code','验证码表','t_sctbs_check_code','0','1','2'),('1109','1015','t_scpcr_sys_param','系统参数表','t_sctbs_sys_param','0','1','2'),('1110','1015','t_scpcr_shop_addr','店铺地址表','t_sctbs_shop_addr','0','1','2'),('1111','1015','t_scpcr_user_base_info','商城用户基础信息','t_sctbs_user_base_info','0','1','2'),('1112','1015','t_scpcr_slide_pic','图片幻灯片','t_sctbs_slide_pic','0','1','2'),('1113','1015','t_cst_role','角色表','','2','1','2'),('1114','1015','t_cst_menu','菜单表','','2','1','2'),('1115','1015','t_cst_authority','权限表','','2','1','2'),('1116','1015','t_cst_resource','资源表','','2','1','2'),('1117','1015','t_cst_role_user','角色用户表','','2','1','2'),('1118','1015','t_cst_role_out_user','角色外网用户表','','2','1','2'),('1119','1015','t_cst_role_authority','角色权限表','','2','1','2'),('1120','1015','t_cst_authority_resource','权限资源表','','2','1','2'),('1121','1015','t_cst_login_log','登录日志表','','2','1','2'),('1122','1015','t_cst_operate_log','操作日志表','','2','1','2'),('1123','1015','t_cst_sup_del_user','供应商物流用户表','','2','1','2'),('1124','1016','t_cst_mdm_product_info','商品信息表','','1','1','2'),('1125','1016','t_cst_mdm_shop','销售门店','','1','1','2'),('1126','1016','t_cst_mdm_dealer','经销商','','1','1','2'),('1127','1016','t_cst_mdm_dealer_cust_config','经销商母客户代号关联表','','1','1','2'),('1128','1016','t_cst_mdm_ccode_info','客户代号','','1','1','2'),('1129','1016','t_cst_mdm_groupalias','组别','','1','1','2'),('1130','1016','t_cst_mdm_brand','品牌','','1','1','2'),('1131','1016','t_cst_mdm_user_groups','用户组别关联表','','1','1','2'),('1132','1016','t_cst_user','内部用户表','','1','1','2'),('1133','1016','t_cst_mdm_out_user','外部用户表','','1','1','2'),('1134','1016','t_cst_conf_dictionary','字典表','','1','1','2'),('1135','1016','t_cst_conf_dictitem','字典明细表','','1','1','2'),('1137','2001','t_pz_baseMessageSet_jm','基础信息维护字典表','','0','1','2'),('1138','2001','t_pz_waiguanbuliangSet_jm','外观不良项目字典表','','0','1','2'),('1139','2001','t_pz_oeguigeSet_jm','OE规格设置字典','','0','1','2'),('1140','2001','t_pz_zhuisutiaojianSet_jm','追溯条件设置字典','','0','1','2'),('1141','3001','t_pz_waiguanbuliangSet','外观不良项目字典表','','0','1','2'),('2F150E3D-AD56-4EED-A37A-CEC7A903FDA5','D310E222-7BC9-448B-B394-B0ED95AF83E7','t_pz_waiguanbuliangSet_hy','外观不良项目字典表','t_pz_waiguanbuliangSet_jm','0','1','2'),('30743B9A-2CD4-4DB8-B05A-30EFB3FCCC85','32FAD1BF-23F0-4AA1-B80E-9C6874DF86B9','t_sccst_present_exchange','礼品兑换表','','0','1','2'),('3A30DF09-BD8A-42D4-B228-45380317D570','D310E222-7BC9-448B-B394-B0ED95AF83E7','t_pz_baseMessageSet_hy','基础信息维护字典表','t_pz_baseMessageSet_jm','0','1','2'),('582FA166-00F3-4B70-A70B-D68D7671C5ED','D310E222-7BC9-448B-B394-B0ED95AF83E7','t_pz_oeguigeSet_hy','OE规格设置字典','t_pz_oeguigeSet_jm','0','1','2'),('6DD40900-6073-4913-BAEF-827574C42876','9C8FD897-02C3-401D-874D-E4BFF07E31F2','t_login_user','用户登陆','','0','1','2'),('715FE93E-0BF5-4D15-B78D-215DE7674B73','D310E222-7BC9-448B-B394-B0ED95AF83E7','t_pz_zhuisutiaojianSet_hy','追溯条件设置字典','t_pz_zhuisutiaojianSet_jm','0','1','2'),('9F99CDE7-CFC4-4F21-A181-EB7D8BF1C06F','E0FECF94-7B49-403B-97B6-A8711F187FF4','t_sccst_present_exchange','礼品兑换表','','0','1','2'),('B23098FF-0663-4E3A-99DE-0A65F14A8F0B','E0FECF94-7B49-403B-97B6-A8711F187FF4','t_sccst_present_info','礼品信息表','','0','1','2');

/*Table structure for table `t_comcode` */

DROP TABLE IF EXISTS `t_comcode`;

CREATE TABLE `t_comcode` (
  `id` varchar(300) DEFAULT NULL,
  `typeCode` varchar(300) DEFAULT NULL,
  `code` varchar(300) DEFAULT NULL,
  `name` varchar(300) DEFAULT NULL,
  `shortName` varchar(300) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='常用代码';

/*Data for the table `t_comcode` */

insert  into `t_comcode`(`id`,`typeCode`,`code`,`name`,`shortName`) values ('1001','101','101','赞成','格式化'),('1002','101','102','反对','反对'),('1003','102','101','正常','正常'),('1004','102','102','锁定','锁定'),('1005','103','101','输入','输入'),('1006','103','102','输出','输出'),('1007','103','103','输入输出','输入输出'),('1008','104','101','大于等于','>='),('1009','104','102','小于等于','<='),('1010','104','103','大于','>'),('1011','104','104','小于','<'),('1012','104','105','等于','='),('1013','104','106','不等于','<>'),('1014','105','101','包含','in'),('1015','105','102','或者','or'),('1016','105','103','并且','and'),('1017','106','101','格式化','格式化'),('1018','106','102','自定义','自定义'),('1019','107','101','单输出','单输出'),('1020','107','102','多输出','多输出'),('1021','108','101','字符','字符'),('1022','108','102','浮点','浮点'),('1023','108','103','整形','整形'),('1024','109','0','否','否'),('1025','109','1','是','是'),('1026','110','0','读写模板','读写模板'),('1027','110','1','只读模板','只读模板'),('1028','110','2','无公共字段模板','无公共字段模板'),('1029','110','3','历史记录模板','历史记录模板');

/*Table structure for table `t_comstyle` */

DROP TABLE IF EXISTS `t_comstyle`;

CREATE TABLE `t_comstyle` (
  `id` varchar(300) DEFAULT NULL,
  `code` varchar(300) DEFAULT NULL,
  `name` varchar(300) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='代码类型';

/*Data for the table `t_comstyle` */

insert  into `t_comstyle`(`id`,`code`,`name`) values ('101','101','投票状态'),('102','102','规则状态'),('103','103','数据集类型'),('104','104','区间符号'),('105','105','关系符号'),('106','106','内容类别'),('107','107','输出方式'),('108','108','变量类型'),('109','109','选择状态'),('110','110','模板类型');

/*Table structure for table `t_condition_partition` */

DROP TABLE IF EXISTS `t_condition_partition`;

CREATE TABLE `t_condition_partition` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `CONDITION_NAME` varchar(200) DEFAULT NULL COMMENT '条件模型',
  `STATUS` varchar(50) DEFAULT NULL COMMENT '状态',
  `MODIFY_DATE` varchar(20) DEFAULT NULL COMMENT '修改日期',
  `MODIFYED` varchar(50) DEFAULT NULL COMMENT '修改人',
  `OWNER` varchar(50) DEFAULT NULL COMMENT '所有人',
  `LOCKED` varchar(50) DEFAULT NULL COMMENT '锁定人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='条件细分';

/*Data for the table `t_condition_partition` */

insert  into `t_condition_partition`(`ID`,`CONDITION_NAME`,`STATUS`,`MODIFY_DATE`,`MODIFYED`,`OWNER`,`LOCKED`) values ('4D41DCEA-6FB4-4FC3-8C7A-8F6DE547E365','1','101','2016-08-10 19:42:34','1','1','1');

/*Table structure for table `t_condition_partition_node` */

DROP TABLE IF EXISTS `t_condition_partition_node`;

CREATE TABLE `t_condition_partition_node` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `CON_PARTITION_ID` varchar(50) DEFAULT NULL COMMENT '条件模型',
  `CON_NODE_NAME` varchar(200) DEFAULT NULL COMMENT '节点名称',
  `RELATION_MARK` varchar(50) DEFAULT NULL COMMENT '关系符',
  `VAR_NAME` varchar(20) DEFAULT NULL COMMENT '变量',
  `OPT_CHAR` varchar(50) DEFAULT NULL COMMENT '操作符',
  `COMPARE_VALUE` varchar(50) DEFAULT NULL COMMENT '对比值',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='条件细分节点';

/*Data for the table `t_condition_partition_node` */

insert  into `t_condition_partition_node`(`ID`,`CON_PARTITION_ID`,`CON_NODE_NAME`,`RELATION_MARK`,`VAR_NAME`,`OPT_CHAR`,`COMPARE_VALUE`) values ('3F8A572B-2C21-4C2D-BF55-85F92C06AE65','1','','or','1','<=','1'),('6634BB5F-8687-4866-B40F-C36DFD7A75E3','1','','or','1','<=','1');

/*Table structure for table `t_cst_sup_del_user` */

DROP TABLE IF EXISTS `t_cst_sup_del_user`;

CREATE TABLE `t_cst_sup_del_user` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `USER_ID` varchar(50) DEFAULT NULL COMMENT '用户账号',
  `REAL_NAME` varchar(200) DEFAULT NULL COMMENT '用户名称',
  `USER_TYPE` varchar(50) DEFAULT NULL COMMENT '用户类型',
  `ENABLE` varchar(1) DEFAULT NULL COMMENT '是否启用',
  `BEGIN_TIME` varchar(20) DEFAULT NULL COMMENT '启用时间',
  `STOP_TIME` varchar(20) DEFAULT NULL COMMENT '停用时间',
  `PASSWORD` varchar(60) DEFAULT NULL COMMENT '密码',
  `SALT` varchar(50) DEFAULT NULL COMMENT '盐值',
  `LAST_PWD_TIME` varchar(20) DEFAULT NULL COMMENT '密码最后更新时间',
  `SUPPLIER_ID` varchar(50) DEFAULT NULL COMMENT '供应商ID',
  `DELIVER_ID` varchar(50) DEFAULT NULL COMMENT '物流ID',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` varchar(20) DEFAULT NULL COMMENT '修改时间',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='供应商物流用户表';

/*Data for the table `t_cst_sup_del_user` */

/*Table structure for table `t_dataset` */

DROP TABLE IF EXISTS `t_dataset`;

CREATE TABLE `t_dataset` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `DATASET_NAME` varchar(50) DEFAULT NULL COMMENT '数据集',
  `DATASET_DES` varchar(200) DEFAULT NULL COMMENT '数据集描述',
  `DATASET_TYPE` varchar(50) DEFAULT NULL COMMENT '类型',
  `REMARK` varchar(1000) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据集';

/*Data for the table `t_dataset` */

insert  into `t_dataset`(`ID`,`DATASET_NAME`,`DATASET_DES`,`DATASET_TYPE`,`REMARK`) values ('F14A85AB-5820-4B29-9C28-B5C69CE1E9AD','1','1','101','1');

/*Table structure for table `t_dataset_var` */

DROP TABLE IF EXISTS `t_dataset_var`;

CREATE TABLE `t_dataset_var` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `DATASET_ID` varchar(50) DEFAULT NULL COMMENT '数据集',
  `VAR_NAME` varchar(50) DEFAULT NULL COMMENT '变量',
  `VAR_DES` varchar(200) DEFAULT NULL COMMENT '变量描述',
  `IS_DERIVED` varchar(1) DEFAULT NULL COMMENT '是否衍生',
  `IS_SET` varchar(1) DEFAULT NULL COMMENT '是否集合',
  `VAR_TYPE` varchar(50) DEFAULT NULL COMMENT '变量类型',
  `SPAN_BEGIN` varchar(50) DEFAULT NULL COMMENT '取值起始',
  `SPAN_END` varchar(50) DEFAULT NULL COMMENT '取值结束',
  `IS_OUTPUT` varchar(1) DEFAULT NULL COMMENT '是否输出',
  `DEF_VALUE` varchar(50) DEFAULT NULL COMMENT '缺省值',
  `REMARK` varchar(1000) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据集变量';

/*Data for the table `t_dataset_var` */

insert  into `t_dataset_var`(`ID`,`DATASET_ID`,`VAR_NAME`,`VAR_DES`,`IS_DERIVED`,`IS_SET`,`VAR_TYPE`,`SPAN_BEGIN`,`SPAN_END`,`IS_OUTPUT`,`DEF_VALUE`,`REMARK`) values ('E167364E-D2FF-4C5F-B98E-A803316B828E','F14A85AB-5820-4B29-9C28-B5C69CE1E9AD','1','1','1','1','102','1','100','0','1','');

/*Table structure for table `t_group_action` */

DROP TABLE IF EXISTS `t_group_action`;

CREATE TABLE `t_group_action` (
  `id` varchar(100) NOT NULL COMMENT '活动编号',
  `name` varchar(100) DEFAULT NULL COMMENT '活动名称',
  `begintime` varchar(100) DEFAULT NULL COMMENT '开始时间',
  `endtime` varchar(100) DEFAULT NULL COMMENT '结束时间',
  `addr` varchar(100) DEFAULT NULL COMMENT '活动地址',
  `leadings` varchar(100) DEFAULT NULL COMMENT '活动负责',
  `memoinfo` varchar(100) DEFAULT NULL COMMENT '活动备注',
  `mincount` varchar(100) DEFAULT NULL COMMENT '最少人数',
  `budget` varchar(100) DEFAULT NULL COMMENT '人均预算',
  `spending` varchar(100) DEFAULT NULL COMMENT '结算总额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='团务活动';

/*Data for the table `t_group_action` */

/*Table structure for table `t_group_info` */

DROP TABLE IF EXISTS `t_group_info`;

CREATE TABLE `t_group_info` (
  `id` varchar(100) NOT NULL COMMENT '编号',
  `type` varchar(100) DEFAULT NULL COMMENT '类别',
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `createtime` varchar(100) DEFAULT NULL COMMENT '创建时间',
  `creator` varchar(100) DEFAULT NULL COMMENT '创建成员',
  `memoinfo` varchar(100) DEFAULT NULL COMMENT '说明',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='团体信息';

/*Data for the table `t_group_info` */

/*Table structure for table `t_group_member` */

DROP TABLE IF EXISTS `t_group_member`;

CREATE TABLE `t_group_member` (
  `id` varchar(200) NOT NULL COMMENT '编号',
  `user` varchar(100) DEFAULT NULL COMMENT '账号',
  `GroupInfoId` varchar(100) DEFAULT NULL COMMENT '团体',
  `area` varchar(100) DEFAULT NULL COMMENT '地区',
  `name` varchar(100) DEFAULT NULL COMMENT '姓名',
  `tel` varchar(100) DEFAULT NULL COMMENT '电话',
  `unit` varchar(1000) DEFAULT NULL COMMENT '单位',
  `addr` varchar(1000) DEFAULT NULL COMMENT '住址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='团体成员';

/*Data for the table `t_group_member` */

/*Table structure for table `t_ipf_ccm_bizrule` */

DROP TABLE IF EXISTS `t_ipf_ccm_bizrule`;

CREATE TABLE `t_ipf_ccm_bizrule` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `RULE_TYPE` varchar(50) DEFAULT NULL COMMENT '规则类型',
  `RULE_CLASS` varchar(50) DEFAULT NULL COMMENT '规则类名',
  `RULE_CODE` varchar(50) DEFAULT NULL COMMENT '规则编码',
  `RULE_NAME` varchar(50) DEFAULT NULL COMMENT '规则名称',
  `RULE_DES` varchar(200) DEFAULT NULL COMMENT '规则描述',
  `IS_SYSTEM_CREATE` varchar(20) DEFAULT NULL COMMENT '系统创建',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='业务规则';

/*Data for the table `t_ipf_ccm_bizrule` */

/*Table structure for table `t_ipf_ccm_bizrule_dtl` */

DROP TABLE IF EXISTS `t_ipf_ccm_bizrule_dtl`;

CREATE TABLE `t_ipf_ccm_bizrule_dtl` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `IPF_CCM_BIZRULE_ID` varchar(50) DEFAULT NULL COMMENT '规则',
  `IPF_CCM_STRATEGY_ID` varchar(50) DEFAULT NULL COMMENT '策略ID',
  `STRATEGY_CODE` varchar(50) DEFAULT NULL COMMENT '策略代码',
  `STRATEGY_NAME` varchar(50) DEFAULT NULL COMMENT '策略名称',
  `REMARK` varchar(1000) DEFAULT NULL COMMENT '备注',
  `RULE_DETAIL_INDEX` varchar(50) DEFAULT NULL COMMENT '序号',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='规则明细';

/*Data for the table `t_ipf_ccm_bizrule_dtl` */

/*Table structure for table `t_ipf_ccm_bizrule_dtl_param` */

DROP TABLE IF EXISTS `t_ipf_ccm_bizrule_dtl_param`;

CREATE TABLE `t_ipf_ccm_bizrule_dtl_param` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `IPF_CCM_BIZRULE_ID` varchar(50) DEFAULT NULL COMMENT '规则',
  `IPF_CCM_STRATEGY_ID` varchar(50) DEFAULT NULL COMMENT '策略ID',
  `IPF_CCM_STRATEGY_PARAM_ID` varchar(50) DEFAULT NULL COMMENT '策略参数ID',
  `PARAM_NAME` varchar(50) DEFAULT NULL COMMENT '参数名',
  `PARAM_DES` varchar(1000) DEFAULT NULL COMMENT '参数描述',
  `PARAM_VALUE` varchar(50) DEFAULT NULL COMMENT '参数值',
  `PARAM_VALUE_DES` varchar(1000) DEFAULT NULL COMMENT '参数值说明',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='规则明细参数';

/*Data for the table `t_ipf_ccm_bizrule_dtl_param` */

/*Table structure for table `t_ipf_ccm_bo` */

DROP TABLE IF EXISTS `t_ipf_ccm_bo`;

CREATE TABLE `t_ipf_ccm_bo` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `BO_NAME` varchar(50) DEFAULT NULL COMMENT '业务对象名',
  `BO_TYPE` varchar(50) DEFAULT NULL COMMENT '对象类型',
  `APP_MODULE` varchar(50) DEFAULT NULL COMMENT '功能模块',
  `SERVICE_TYPE` varchar(50) DEFAULT NULL COMMENT '服务类型',
  `JAVA_PATH` varchar(1000) DEFAULT NULL COMMENT 'JAVA路径',
  `SERVICE_CATEGORY` varchar(50) DEFAULT NULL COMMENT '服务分类',
  `TABLE_NAME` varchar(50) DEFAULT NULL COMMENT '表名',
  `TABLE_TYPE` varchar(50) DEFAULT NULL COMMENT '表类型',
  `DESCRIPTION` varchar(200) DEFAULT NULL COMMENT '描述',
  `SEARCH_COLUMNS` varchar(50) DEFAULT NULL COMMENT '查询条件列数',
  `SEARCH_MODE` varchar(50) DEFAULT NULL COMMENT '查询模式',
  `PAGE_SIZE` varchar(50) DEFAULT NULL COMMENT '每页记录',
  `IPF_CCM_UI_LAYOUT_ID` varchar(50) DEFAULT NULL COMMENT '界面布局ID',
  `UI_LAYOUT_NAME` varchar(50) DEFAULT NULL COMMENT '界面布局名称',
  `FORM_CELL_MODE` varchar(50) DEFAULT NULL COMMENT '界面模式',
  `UI_TEMPLATE` varchar(50) DEFAULT NULL COMMENT '界面模板',
  `FORM_COLUMNS` varchar(50) DEFAULT NULL COMMENT '每行列数',
  `GRID_STYLE` varchar(50) DEFAULT NULL COMMENT '表格样式',
  `GRID_ALIGN` varchar(50) DEFAULT NULL COMMENT '表格列对齐',
  `GRID_EDIT_TYPE` varchar(50) DEFAULT NULL COMMENT '表格维护方式',
  `GENERATE_OPTION` varchar(200) DEFAULT NULL COMMENT '代码生成选项',
  `LOCK_ROW_EXPRESS` varchar(2000) DEFAULT NULL COMMENT '行锁定表达式',
  `GRID_TYPE` varchar(50) DEFAULT NULL COMMENT '表格类型',
  `IS_MAIN_OBJECT` varchar(20) DEFAULT NULL COMMENT '主对象',
  `IS_INIT_DATA_BO` varchar(20) DEFAULT NULL COMMENT '初始化数据对象',
  `IS_AUTO_LOAD` varchar(20) DEFAULT NULL COMMENT '自动查询',
  `IS_NEED_ADV_SEARCH` varchar(20) DEFAULT NULL COMMENT '需高级查询',
  `NEED_PAGING` varchar(50) DEFAULT NULL COMMENT '表格分页',
  `IS_GRID_FILTER` varchar(20) DEFAULT NULL COMMENT '表格列筛选',
  `IS_GRID_CUSTOM` varchar(20) DEFAULT NULL COMMENT '表格列定义',
  `REMARK` varchar(1000) DEFAULT NULL COMMENT '备注',
  `WHERE_CLAUSE` varchar(2000) DEFAULT NULL COMMENT 'WHERE条件',
  `ID_GENERATOR` varchar(20) DEFAULT NULL COMMENT 'ID生成器名称',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='业务对象';

/*Data for the table `t_ipf_ccm_bo` */

/*Table structure for table `t_ipf_ccm_bo_check` */

DROP TABLE IF EXISTS `t_ipf_ccm_bo_check`;

CREATE TABLE `t_ipf_ccm_bo_check` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `CHECK_TYPE` varchar(50) DEFAULT NULL COMMENT '校验类型',
  `CHECK_NAME` varchar(50) DEFAULT NULL COMMENT '校验名称',
  `BO_NAME` varchar(50) DEFAULT NULL COMMENT '业务对象名',
  `PROPERTY_NAME` varchar(50) DEFAULT NULL COMMENT '属性名称',
  `PROPERTY_DESC` varchar(200) DEFAULT NULL COMMENT '属性描述',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据校验';

/*Data for the table `t_ipf_ccm_bo_check` */

/*Table structure for table `t_ipf_ccm_bo_check_field` */

DROP TABLE IF EXISTS `t_ipf_ccm_bo_check_field`;

CREATE TABLE `t_ipf_ccm_bo_check_field` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `IPF_CCM_BO_CHECK_ID` varchar(50) DEFAULT NULL COMMENT '校验',
  `PROPERTY_ID` varchar(50) DEFAULT NULL COMMENT '属性ID',
  `PROPERTY_NAME` varchar(50) DEFAULT NULL COMMENT '属性名称',
  `PROPERTY_DESC` varchar(200) DEFAULT NULL COMMENT '属性描述',
  `BO_NAME` varchar(50) DEFAULT NULL COMMENT '业务对象名',
  `SEQ_NO` varchar(50) DEFAULT NULL COMMENT '顺序号',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据字段';

/*Data for the table `t_ipf_ccm_bo_check_field` */

/*Table structure for table `t_ipf_ccm_bo_check_group` */

DROP TABLE IF EXISTS `t_ipf_ccm_bo_check_group`;

CREATE TABLE `t_ipf_ccm_bo_check_group` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `IPF_CCM_BO_ID` varchar(50) DEFAULT NULL COMMENT '业务对象',
  `GROUP_NAME` varchar(50) DEFAULT NULL COMMENT '分组名称',
  `GROUP_DESC` varchar(200) DEFAULT NULL COMMENT '分组描述',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='对象校验分组';

/*Data for the table `t_ipf_ccm_bo_check_group` */

/*Table structure for table `t_ipf_ccm_bo_check_rel_group` */

DROP TABLE IF EXISTS `t_ipf_ccm_bo_check_rel_group`;

CREATE TABLE `t_ipf_ccm_bo_check_rel_group` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `IPF_CCM_BO_CHECK_ID` varchar(50) DEFAULT NULL COMMENT '校验',
  `GROUP_NAME` varchar(50) DEFAULT NULL COMMENT '分组名称',
  `GROUP_DESC` varchar(200) DEFAULT NULL COMMENT '分组描述',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='校验分组';

/*Data for the table `t_ipf_ccm_bo_check_rel_group` */

/*Table structure for table `t_ipf_ccm_bo_control_event` */

DROP TABLE IF EXISTS `t_ipf_ccm_bo_control_event`;

CREATE TABLE `t_ipf_ccm_bo_control_event` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `IPF_CCM_BO_FORM_COLUMN_ID` varchar(50) DEFAULT NULL COMMENT '编辑页',
  `EVENT_TYPE` varchar(50) DEFAULT NULL COMMENT '事件类型',
  `EXEC_TYPE` varchar(50) DEFAULT NULL COMMENT '执行类型',
  `EXEC_CONTENT` varchar(50) DEFAULT NULL COMMENT '执行内容',
  `CALL_BACK` varchar(2000) DEFAULT NULL COMMENT '回调JS',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='编辑页控件事件';

/*Data for the table `t_ipf_ccm_bo_control_event` */

/*Table structure for table `t_ipf_ccm_bo_form_cell` */

DROP TABLE IF EXISTS `t_ipf_ccm_bo_form_cell`;

CREATE TABLE `t_ipf_ccm_bo_form_cell` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `IPF_CCM_BO_ID` varchar(50) DEFAULT NULL COMMENT '业务对象',
  `FORM_TYPE` varchar(50) DEFAULT NULL COMMENT '界面类型',
  `IS_DEFAULT` varchar(20) DEFAULT NULL COMMENT '默认FORM',
  `CELL_NAME` varchar(50) DEFAULT NULL COMMENT '栅格名称',
  `CELL_TYPE` varchar(50) DEFAULT NULL COMMENT '栅格类型',
  `CELL_HEIGH` varchar(50) DEFAULT NULL COMMENT '栅格高度',
  `IS_SHOW_GROUP` varchar(20) DEFAULT NULL COMMENT '显示分组',
  `GROUP_WIDGET` varchar(50) DEFAULT NULL COMMENT '分组控件',
  `ELEMENT_CODE` varchar(50) DEFAULT NULL COMMENT '数据元素代码',
  `GROUP_TITLE` varchar(50) DEFAULT NULL COMMENT '分组标题',
  `UNIT_COUNT` varchar(50) DEFAULT NULL COMMENT '包含栅格数',
  `IS_PARENT` varchar(20) DEFAULT NULL COMMENT '包含子栅格',
  `CHILDREN_LINE_COUNT` varchar(50) DEFAULT NULL COMMENT '子栅格行数',
  `PARENT_CELL_NAME` varchar(50) DEFAULT NULL COMMENT '父栅格',
  `ROW_NO` varchar(50) DEFAULT NULL COMMENT '所属栅格行',
  `COLUMN_NO` varchar(50) DEFAULT NULL COMMENT '所属栅格列',
  `LABEL_UNIT_COUNT` varchar(50) DEFAULT NULL COMMENT '标签占栅格数',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='表单珊格';

/*Data for the table `t_ipf_ccm_bo_form_cell` */

/*Table structure for table `t_ipf_ccm_bo_form_column` */

DROP TABLE IF EXISTS `t_ipf_ccm_bo_form_column`;

CREATE TABLE `t_ipf_ccm_bo_form_column` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `IPF_CCM_BO_ID` varchar(50) DEFAULT NULL COMMENT '业务对象',
  `PROPERTY_ID` varchar(50) DEFAULT NULL COMMENT '属性',
  `PROPERTY_TYPE` varchar(50) DEFAULT NULL COMMENT '属性类型',
  `IS_GROUP` varchar(20) DEFAULT NULL COMMENT '分组',
  `GROUP_NAME` varchar(50) DEFAULT NULL COMMENT '分组名',
  `UI_TYPE` varchar(50) DEFAULT NULL COMMENT '组件类型',
  `COLUMN_NO` varchar(50) DEFAULT NULL COMMENT '列号',
  `ROW_NO` varchar(50) DEFAULT NULL COMMENT '行号',
  `INIT_VALUE_TYPE` varchar(50) DEFAULT NULL COMMENT '初始值类型',
  `DEFAULT_VALUE` varchar(50) DEFAULT NULL COMMENT '初始值',
  `TAB_INDEX` varchar(50) DEFAULT NULL COMMENT 'Tab顺序',
  `IS_HEADER` varchar(20) DEFAULT NULL COMMENT '抬头',
  `LABLE_STYLE` varchar(50) DEFAULT NULL COMMENT '字段文本样式',
  `COLUMN_STYLE` varchar(50) DEFAULT NULL COMMENT '字段样式',
  `DISPLAY_LABLE` varchar(50) DEFAULT NULL COMMENT '字段文本是否显示',
  `CORRECT_TYPE` varchar(50) DEFAULT NULL COMMENT '转换类型',
  `ACTIVE_EXPRESS` varchar(1000) DEFAULT NULL COMMENT '可编辑表达式',
  `IS_NOT_NULL` varchar(20) DEFAULT NULL COMMENT '非空',
  `IS_VISIBLE` varchar(20) DEFAULT NULL COMMENT '可见',
  `IS_READ_ONLY` varchar(20) DEFAULT NULL COMMENT '只读',
  `CELL_NAME` varchar(50) DEFAULT NULL COMMENT '对应栅格',
  `INLINE_ORDER_NO` varchar(50) DEFAULT NULL COMMENT '顺序',
  `INLINE_WIDTH` varchar(50) DEFAULT NULL COMMENT '控件宽度',
  `INLINE_CONNECTOR` varchar(50) DEFAULT NULL COMMENT '连接符',
  `TEXT_FORM_HEIGHT` varchar(50) DEFAULT NULL COMMENT '多行文本控制高度',
  `TEXT_LINE_NUM` varchar(50) DEFAULT NULL COMMENT '多行文本行数',
  `IS_SHOW_LABEL` varchar(50) DEFAULT NULL COMMENT '显示标签',
  `IS_RADIO_INLINE` varchar(50) DEFAULT NULL COMMENT '控件内联',
  `RULE_NO` varchar(50) DEFAULT NULL COMMENT '规则号',
  `IS_CA_NOTE` varchar(20) DEFAULT NULL COMMENT '是否管理标签页',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='编辑页';

/*Data for the table `t_ipf_ccm_bo_form_column` */

/*Table structure for table `t_ipf_ccm_bo_form_toolbar` */

DROP TABLE IF EXISTS `t_ipf_ccm_bo_form_toolbar`;

CREATE TABLE `t_ipf_ccm_bo_form_toolbar` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `IPF_CCM_BO_ID` varchar(50) DEFAULT NULL COMMENT '业务对象',
  `METHOD_ID` varchar(50) DEFAULT NULL COMMENT '调用方法',
  `SEQ_NO` varchar(50) DEFAULT NULL COMMENT '顺序号',
  `BUTTON_STYLE` varchar(50) DEFAULT NULL COMMENT '按钮样式',
  `DISABLED_EXPREE` varchar(1000) DEFAULT NULL COMMENT '可编辑表达式',
  `IS_REFRESH_PARENT_BO` varchar(50) DEFAULT NULL COMMENT '刷新主表',
  `HOTKEY_TYPE` varchar(50) DEFAULT NULL COMMENT '热键类型',
  `HOTKEY_VALUE` varchar(50) DEFAULT NULL COMMENT '热键值',
  `IS_HIDE` varchar(20) DEFAULT NULL COMMENT '隐藏',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='编辑页按钮';

/*Data for the table `t_ipf_ccm_bo_form_toolbar` */

/*Table structure for table `t_ipf_ccm_bo_grid_column` */

DROP TABLE IF EXISTS `t_ipf_ccm_bo_grid_column`;

CREATE TABLE `t_ipf_ccm_bo_grid_column` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `IPF_CCM_BO_ID` varchar(50) DEFAULT NULL COMMENT '业务对象',
  `PROPERTY_TYPE` varchar(50) DEFAULT NULL COMMENT '属性类型',
  `PROPERTY_ID` varchar(50) DEFAULT NULL COMMENT '属性',
  `CELL_RULE_NO` varchar(50) DEFAULT NULL COMMENT '单元格处理规则号',
  `METHOD_ID` varchar(50) DEFAULT NULL COMMENT '调用方法',
  `IS_ORDER_BY` varchar(50) DEFAULT NULL COMMENT '排序',
  `SORT_ORDER` varchar(20) DEFAULT NULL COMMENT '排序顺序',
  `ACTIVE_EXPRESS` varchar(1000) DEFAULT NULL COMMENT '可编辑表达式',
  `LOCK_COLUMN_EXPRESS` varchar(1000) DEFAULT NULL COMMENT '列锁定表达式',
  `UNLOCK_COLUMN_EXPRESS` varchar(1000) DEFAULT NULL COMMENT '列解锁表达式',
  `CORRECT_TYPE` varchar(50) DEFAULT NULL COMMENT '转换类型',
  `STYLE` varchar(50) DEFAULT NULL COMMENT '标题样式',
  `UI_TYPE` varchar(50) DEFAULT NULL COMMENT '组件类型',
  `WIDTH` varchar(50) DEFAULT NULL COMMENT '列宽',
  `COLUMN_NO` varchar(50) DEFAULT NULL COMMENT '列号',
  `INIT_VALUE_TYPE` varchar(50) DEFAULT NULL COMMENT '初始值类型',
  `DEFAULT_VALUE` varchar(50) DEFAULT NULL COMMENT '初始值',
  `INIT_VALUE_TYPE2` varchar(50) DEFAULT NULL COMMENT '初始值类型2',
  `DEFAULT_VALUE2` varchar(50) DEFAULT NULL COMMENT '初始值2',
  `IS_NOT_NULL` varchar(20) DEFAULT NULL COMMENT '非空',
  `IS_READ_ONLY` varchar(20) DEFAULT NULL COMMENT '只读',
  `IS_VISIBLE` varchar(20) DEFAULT NULL COMMENT '可见',
  `IS_SUM` varchar(20) DEFAULT NULL COMMENT '汇总',
  `IS_CELL_EDITABLE` varchar(50) DEFAULT NULL COMMENT '表格可编辑',
  `IS_SHOW_SORT` varchar(20) DEFAULT NULL COMMENT '显示排序',
  `IS_CONDITION` varchar(20) DEFAULT NULL COMMENT '查询条件',
  `IS_RANGE` varchar(20) DEFAULT NULL COMMENT '区间查询条件',
  `CONDITION_VISIBLE` varchar(50) DEFAULT NULL COMMENT '查询条件可见性',
  `SEARCH_ROW_NO` varchar(50) DEFAULT NULL COMMENT '查询条件行号',
  `SEARCH_COLUMN_NO` varchar(50) DEFAULT NULL COMMENT '查询条件列号',
  `OPERATION` varchar(50) DEFAULT NULL COMMENT '查询操作符',
  `TAB_INDEX` varchar(50) DEFAULT NULL COMMENT 'Tab顺序',
  `IS_QUICK_SEARCH` varchar(20) DEFAULT NULL COMMENT '快捷查询',
  `IS_QUICK_SHOW_LABEL` varchar(50) DEFAULT NULL COMMENT '快捷查询显示标签',
  `IS_QUICK_RADIO_INLINE` varchar(50) DEFAULT NULL COMMENT '快捷查询内联',
  `QUICK_CELL_NAME` varchar(50) DEFAULT NULL COMMENT '快捷查询对应栅格',
  `QUICK_INLINE_ORDER_NO` varchar(50) DEFAULT NULL COMMENT '快捷查询顺序',
  `QUICK_INLINE_WIDTH` varchar(50) DEFAULT NULL COMMENT '快捷查询控件高度',
  `QUICK_INLINE_CONNECTOR` varchar(50) DEFAULT NULL COMMENT '快捷查询连接符',
  `QUICK_TEXT_LINE_NUM` varchar(50) DEFAULT NULL COMMENT '快捷查询多行文本行数',
  `QUICK_TEXT_FORM_HEIGHT` varchar(50) DEFAULT NULL COMMENT '快捷查询多行文本控制高度',
  `IS_ADV_SEARCH` varchar(50) DEFAULT NULL COMMENT '需高级查询',
  `IS_ADV_SHOW_LABEL` varchar(50) DEFAULT NULL COMMENT '高级查询显示标签',
  `IS_ADV_RADIO_INLINE` varchar(50) DEFAULT NULL COMMENT '高级查询内联',
  `ADV_CELL_NAME` varchar(50) DEFAULT NULL COMMENT '高级查询对应栅格',
  `ADV_INLINE_ORDER_NO` varchar(50) DEFAULT NULL COMMENT '高级查询顺序',
  `ADV_INLINE_WIDTH` varchar(50) DEFAULT NULL COMMENT '高级查询控件高度',
  `ADV_INLINE_CONNECTOR` varchar(50) DEFAULT NULL COMMENT '高级查询连接符',
  `ADV_TEXT_LINE_NUM` varchar(50) DEFAULT NULL COMMENT '高级查询多行文本行数',
  `ADV_TEXT_FORM_HEIGHT` varchar(50) DEFAULT NULL COMMENT '高级查询多行文本控制高度',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='管理页';

/*Data for the table `t_ipf_ccm_bo_grid_column` */

/*Table structure for table `t_ipf_ccm_bo_grid_toolbar` */

DROP TABLE IF EXISTS `t_ipf_ccm_bo_grid_toolbar`;

CREATE TABLE `t_ipf_ccm_bo_grid_toolbar` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `IPF_CCM_BO_ID` varchar(50) DEFAULT NULL COMMENT '业务对象',
  `METHOD_ID` varchar(50) DEFAULT NULL COMMENT '调用方法',
  `BUTTON_STYLE` varchar(50) DEFAULT NULL COMMENT '按钮样式',
  `SEQ_NO` varchar(50) DEFAULT NULL COMMENT '顺序号',
  `IS_REFRESH_PARENT_BO` varchar(50) DEFAULT NULL COMMENT '刷新主表',
  `IS_HIDE` varchar(20) DEFAULT NULL COMMENT '隐藏',
  `HOTKEY_TYPE` varchar(50) DEFAULT NULL COMMENT '快捷键类型',
  `HOTKEY_VALUE` varchar(50) DEFAULT NULL COMMENT '快捷键值',
  `DISABLED_EXPREE` varchar(50) DEFAULT NULL COMMENT '可编辑表达式',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='管理页按钮';

/*Data for the table `t_ipf_ccm_bo_grid_toolbar` */

/*Table structure for table `t_ipf_ccm_bo_method` */

DROP TABLE IF EXISTS `t_ipf_ccm_bo_method`;

CREATE TABLE `t_ipf_ccm_bo_method` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `IPF_CCM_BO_ID` varchar(50) DEFAULT NULL COMMENT '业务对象',
  `METHOD_NAME` varchar(50) DEFAULT NULL COMMENT '调用方法名称',
  `METHOD_DESC` varchar(1000) DEFAULT NULL COMMENT '调用方法描述',
  `BO_REF_ID` varchar(50) DEFAULT NULL COMMENT '业务对象引用',
  `IS_DEFAULT` varchar(20) DEFAULT NULL COMMENT '默认方法',
  `REF_SHLP_NAME` varchar(50) DEFAULT NULL COMMENT '搜索帮助名称',
  `ICON` varchar(1000) DEFAULT NULL COMMENT '图标',
  `RULE_NO` varchar(50) DEFAULT NULL COMMENT '规则号',
  `URL` varchar(2000) DEFAULT NULL COMMENT '调用的URL地址',
  `REMARK` varchar(1000) DEFAULT NULL COMMENT '备注',
  `IS_VISIBLE` varchar(20) DEFAULT NULL COMMENT '可见',
  `JUMP_METHOD_ID` varchar(50) DEFAULT NULL COMMENT '跳转方法ID',
  `JUMP_BO_NAME` varchar(50) DEFAULT NULL COMMENT '跳转业务对象名',
  `JUMP_METHOD_NAME` varchar(50) DEFAULT NULL COMMENT '跳转方法名称',
  `WIDTH` varchar(50) DEFAULT NULL COMMENT '宽',
  `HEIGHT` varchar(50) DEFAULT NULL COMMENT '高',
  `GROUP_NAME` varchar(50) DEFAULT NULL COMMENT '校验分组名称',
  `JUMP_WINDOW_TITLE` varchar(50) DEFAULT NULL COMMENT '弹窗标题',
  `IS_REFRESH_PARENT_BO` varchar(20) DEFAULT NULL COMMENT '是否刷新主表',
  `IS_PERMISSION` varchar(20) DEFAULT NULL COMMENT '权限控制',
  `PRINT_METHOD` varchar(50) DEFAULT NULL COMMENT '打印方法',
  `PRINT_OPTION` varchar(50) DEFAULT NULL COMMENT '打印选项',
  `FILE_URL` varchar(50) DEFAULT NULL COMMENT '文件路径',
  `METHOD_BODY` varchar(50) DEFAULT NULL COMMENT '方法内容',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='后台方法定义表';

/*Data for the table `t_ipf_ccm_bo_method` */

/*Table structure for table `t_ipf_ccm_bo_method_param` */

DROP TABLE IF EXISTS `t_ipf_ccm_bo_method_param`;

CREATE TABLE `t_ipf_ccm_bo_method_param` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `IPF_CCM_BO_METHOD_ID` varchar(50) DEFAULT NULL COMMENT '方法',
  `CONSTANT_VALUE` varchar(50) DEFAULT NULL COMMENT '常量值',
  `IS_CONDITION` varchar(20) DEFAULT NULL COMMENT '查询条件',
  `METHOD_NAME` varchar(50) DEFAULT NULL COMMENT '方法名',
  `PARAM_NAME` varchar(50) DEFAULT NULL COMMENT '参数名',
  `PARAM_REF` varchar(50) DEFAULT NULL COMMENT '属性名',
  `PARAM_TYPE` varchar(50) DEFAULT NULL COMMENT '参数值来源类型',
  `BO_NAME_REF` varchar(50) DEFAULT NULL COMMENT '业务对象名',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='方法参数定义表';

/*Data for the table `t_ipf_ccm_bo_method_param` */

/*Table structure for table `t_ipf_ccm_bo_method_rule` */

DROP TABLE IF EXISTS `t_ipf_ccm_bo_method_rule`;

CREATE TABLE `t_ipf_ccm_bo_method_rule` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `IPF_CCB_BO_METHOD_ID` varchar(50) DEFAULT NULL COMMENT '方法',
  `RULE_NO` varchar(50) DEFAULT NULL COMMENT '规则号',
  `RULE_NAME` varchar(50) DEFAULT NULL COMMENT '规则名称',
  `INVOKE_POINT` varchar(50) DEFAULT NULL COMMENT '调用时机',
  `INVOKE_ORDER` varchar(50) DEFAULT NULL COMMENT '调用顺序',
  `RULE_ID` varchar(50) DEFAULT NULL COMMENT '规则ID',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='方法规则调用';

/*Data for the table `t_ipf_ccm_bo_method_rule` */

/*Table structure for table `t_ipf_ccm_bo_page` */

DROP TABLE IF EXISTS `t_ipf_ccm_bo_page`;

CREATE TABLE `t_ipf_ccm_bo_page` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `IPF_CCM_BO_ID` varchar(50) DEFAULT NULL COMMENT '业务对象',
  `PAGE_TYPE` varchar(50) DEFAULT NULL COMMENT '页面类型',
  `DESCRIPTION` varchar(1000) DEFAULT NULL COMMENT '描述',
  `PAGE_NAME` varchar(50) DEFAULT NULL COMMENT '页面名称',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='页面列表';

/*Data for the table `t_ipf_ccm_bo_page` */

/*Table structure for table `t_ipf_ccm_bo_page_layout` */

DROP TABLE IF EXISTS `t_ipf_ccm_bo_page_layout`;

CREATE TABLE `t_ipf_ccm_bo_page_layout` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `IPF_CCM_BO_PAGE_ID` varchar(50) DEFAULT NULL COMMENT '页面',
  `LAYOUT_TYPE` varchar(50) DEFAULT NULL COMMENT '页面布局类型',
  `LAYOUT_CONTAINER_TYPE` varchar(50) DEFAULT NULL COMMENT '页面布局容器类型',
  `LAYOUT_BO_NAME` varchar(50) DEFAULT NULL COMMENT '页面布局业务对象名称',
  `STYLE_CLASS` varchar(50) DEFAULT NULL COMMENT '样式名称',
  `STYLE` varchar(50) DEFAULT NULL COMMENT '样式',
  `FORM_TYPE` varchar(50) DEFAULT NULL COMMENT '表单类型',
  `ELEMENT_NAME` varchar(50) DEFAULT NULL COMMENT '布局元素名称',
  `HEIGHT` varchar(50) DEFAULT NULL COMMENT '栅格高度',
  `IS_SHOW_GROUP` varchar(50) DEFAULT NULL COMMENT '显示分组',
  `GROUP_WIDGET` varchar(50) DEFAULT NULL COMMENT '分组控件',
  `GROUP_MSG_CODE` varchar(50) DEFAULT NULL COMMENT '分组标题系统消息代码',
  `GROUP_TITLE` varchar(50) DEFAULT NULL COMMENT '分组标题',
  `UNIT_COUNT` varchar(50) DEFAULT NULL COMMENT '包含栅格数',
  `IS_PARENT` varchar(50) DEFAULT NULL COMMENT '是否父栅格',
  `CHILDREN_LINE_COUNT` varchar(50) DEFAULT NULL COMMENT '子栅格行数',
  `CELL_NAME` varchar(50) DEFAULT NULL COMMENT '栅格名称',
  `ROW_NO` varchar(50) DEFAULT NULL COMMENT '行号',
  `COLUMN_NO` varchar(50) DEFAULT NULL COMMENT '列号',
  `LABEL_UNIT_COUNT` varchar(50) DEFAULT NULL COMMENT '标签占栅格数',
  `SEQ_NO` varchar(50) DEFAULT NULL COMMENT '序号',
  `CONTROL_CONNECTOR` varchar(50) DEFAULT NULL COMMENT '连接符号',
  `PARENT_CELL_NAME` varchar(50) DEFAULT NULL COMMENT '父栅格',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='页面布局';

/*Data for the table `t_ipf_ccm_bo_page_layout` */

/*Table structure for table `t_ipf_ccm_bo_pg_lo_element` */

DROP TABLE IF EXISTS `t_ipf_ccm_bo_pg_lo_element`;

CREATE TABLE `t_ipf_ccm_bo_pg_lo_element` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `IPF_CCM_BO_PAGE_LAYOUT_ID` varchar(50) DEFAULT NULL COMMENT '页面布局',
  `SEQ_NO` varchar(50) DEFAULT NULL COMMENT '序号',
  `LAYOUT_ELEMENT_TYPE` varchar(50) DEFAULT NULL COMMENT '页面布局元素类型',
  `LAYOUT_BO_NAME` varchar(50) DEFAULT NULL COMMENT '页面布局业务对象名称',
  `CONTROL_HEIGHT` varchar(50) DEFAULT NULL COMMENT '控件高度',
  `CONTROL_WIDTH` varchar(50) DEFAULT NULL COMMENT '控件宽度',
  `TEXT_LINE_NUM` varchar(50) DEFAULT NULL COMMENT '多行文本行数',
  `CONTROL_CONNECTOR` varchar(50) DEFAULT NULL COMMENT '连接符',
  `IS_NOT_NULL` varchar(20) DEFAULT NULL COMMENT '非空',
  `IS_READ_ONLY` varchar(20) DEFAULT NULL COMMENT '只读',
  `UI_TYPE` varchar(50) DEFAULT NULL COMMENT '控件类型',
  `IS_VISIBLE` varchar(20) DEFAULT NULL COMMENT '可见',
  `COLUMN_STYLE` varchar(50) DEFAULT NULL COMMENT '列样式',
  `LABLE_STYLE` varchar(50) DEFAULT NULL COMMENT '标签样式',
  `IS_SHOW_LABLE` varchar(20) DEFAULT NULL COMMENT '显示标签',
  `IS_INLINE` varchar(20) DEFAULT NULL COMMENT '控件内联',
  `TAB_INDEX` varchar(50) DEFAULT NULL COMMENT 'Tab顺序',
  `DEFAULT_VALUE` varchar(50) DEFAULT NULL COMMENT '默认值',
  `INIT_VALUE_TYPE` varchar(50) DEFAULT NULL COMMENT '初始值类型',
  `CORRECT_TYPE` varchar(50) DEFAULT NULL COMMENT '转换类型',
  `CONDITION_TYPE` varchar(50) DEFAULT NULL COMMENT '查询条件类型',
  `OPERATION` varchar(50) DEFAULT NULL COMMENT '操作符',
  `QUERY_TYPE` varchar(50) DEFAULT NULL COMMENT '查询类型',
  `RANGE_TYPE` varchar(50) DEFAULT NULL COMMENT '区间类型',
  `METHOD_NAME` varchar(50) DEFAULT NULL COMMENT '方法名称',
  `PROPERTY_NAME` varchar(50) DEFAULT NULL COMMENT '属性名',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='布局元素定义';

/*Data for the table `t_ipf_ccm_bo_pg_lo_element` */

/*Table structure for table `t_ipf_ccm_bo_property` */

DROP TABLE IF EXISTS `t_ipf_ccm_bo_property`;

CREATE TABLE `t_ipf_ccm_bo_property` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `PROPERTY_NAME` varchar(50) DEFAULT NULL COMMENT '属性名',
  `COLUMN_NAME` varchar(50) DEFAULT NULL COMMENT '字段名',
  `PROPERTY_TYPE` varchar(50) DEFAULT NULL COMMENT '属性类型',
  `SUB_BO_LAYOUT_TYPE` varchar(50) DEFAULT NULL COMMENT '布局类型',
  `TABLE_NAME` varchar(50) DEFAULT NULL COMMENT '表名',
  `MAX_VALUE` varchar(50) DEFAULT NULL COMMENT '最大值',
  `MIN_VALUE` varchar(50) DEFAULT NULL COMMENT '最小值',
  `ELEMENT_CODE` varchar(50) DEFAULT NULL COMMENT '数据元素代码',
  `FIELD_TEXT` varchar(1000) DEFAULT NULL COMMENT '显示文本',
  `DATA_TYPE` varchar(50) DEFAULT NULL COMMENT '数据类型',
  `FIELD_LENGTH` varchar(50) DEFAULT NULL COMMENT '字段长度',
  `DECIMALS` varchar(50) DEFAULT NULL COMMENT '小数位',
  `IS_NOT_NULL` varchar(20) DEFAULT NULL COMMENT '非空',
  `IS_KEY` varchar(20) DEFAULT NULL COMMENT '主键',
  `SUB_BO_NAME` varchar(50) DEFAULT NULL COMMENT '子业务对象名',
  `SUB_BO_REL_TYPE` varchar(50) DEFAULT NULL COMMENT '关联BO类型',
  `SUB_BO_REL_PRO` varchar(50) DEFAULT NULL COMMENT '关系对象属性',
  `SUB_BO_ORDER_NO` varchar(50) DEFAULT NULL COMMENT '子业务对象的排序号',
  `PERSISTENT_SAVE_TYPE` varchar(50) DEFAULT NULL COMMENT '子业务对象保存方式',
  `REL_SUB_BO_PRO_NAME` varchar(50) DEFAULT NULL COMMENT '关联子业务对象属性名称',
  `SEARCH_HELP` varchar(50) DEFAULT NULL COMMENT '搜索帮助名',
  `REF_PRO_NAME` varchar(50) DEFAULT NULL COMMENT '搜索帮助关联属性',
  `DICT_TABLE_NAME` varchar(50) DEFAULT NULL COMMENT '字典表',
  `DICT_GROUP_VALUE` varchar(50) DEFAULT NULL COMMENT '字典分组值',
  `FETCH_WAY` varchar(50) DEFAULT NULL COMMENT '取数方式',
  `FIX_VALUE` varchar(50) DEFAULT NULL COMMENT '取数固定值',
  `VALUE_EXPRESSION` varchar(2000) DEFAULT NULL COMMENT '取数表达式',
  `VLAUE_RULE_NO` varchar(50) DEFAULT NULL COMMENT '取数规则号',
  `PRE_CONDITION` varchar(2000) DEFAULT NULL COMMENT '前提条件',
  `OPT_CONDITION` varchar(2000) DEFAULT NULL COMMENT '选择条件',
  `IS_SURCHARGE` varchar(20) DEFAULT NULL COMMENT '附加费',
  `IS_REALTIME_CALCULATE` varchar(20) DEFAULT NULL COMMENT '实时计算',
  `RP_TYPE` varchar(20) DEFAULT NULL COMMENT '收付类型',
  `CUST_ID_PROPERTY_NAME` varchar(50) DEFAULT NULL COMMENT '客户代码属性名称',
  `BUSINESS_DATE_PROPERTY_NAME` varchar(50) DEFAULT NULL COMMENT '业务日期属性名称',
  `IPF_CCM_BO_ID` varchar(50) DEFAULT NULL COMMENT '所属业务对象',
  `AUTH_FIELD` varchar(50) DEFAULT NULL COMMENT '授权字段',
  `HELP_INDEX` varchar(50) DEFAULT NULL COMMENT '帮助索引号',
  `NUMBER_OBJECT_ID` varchar(50) DEFAULT NULL COMMENT '号码对象ID',
  `REL_BO_METHOD` varchar(50) DEFAULT NULL COMMENT '关联业务对象方法名',
  `REL_BO_NAME` varchar(50) DEFAULT NULL COMMENT '关联业务对象名',
  `SH_TABLE` varchar(50) DEFAULT NULL COMMENT '搜索帮助表或视图',
  `SH_VALUE_COLUMN` varchar(50) DEFAULT NULL COMMENT '值字段',
  `VALIDACTION_TYPE` varchar(50) DEFAULT NULL COMMENT '数据校验类型',
  `VALIDACTION_REGEX` varchar(50) DEFAULT NULL COMMENT '数据校验正则表达式',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='属性定义';

/*Data for the table `t_ipf_ccm_bo_property` */

/*Table structure for table `t_ipf_ccm_bo_property_cas` */

DROP TABLE IF EXISTS `t_ipf_ccm_bo_property_cas`;

CREATE TABLE `t_ipf_ccm_bo_property_cas` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `IPF_CCM_BO_PROPERTY_ID` varchar(50) DEFAULT NULL COMMENT '属性',
  `CASCADE_PROPERTY_ID` varchar(50) DEFAULT NULL COMMENT '级联属性',
  `OPERATION` varchar(50) DEFAULT NULL COMMENT '操作符',
  `TARGET_PROPERTY_NAME` varchar(50) DEFAULT NULL COMMENT '目标属性名称',
  `TYPE` varchar(50) DEFAULT NULL COMMENT '类型',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='属性动态过滤配置';

/*Data for the table `t_ipf_ccm_bo_property_cas` */

/*Table structure for table `t_ipf_ccm_bo_relation` */

DROP TABLE IF EXISTS `t_ipf_ccm_bo_relation`;

CREATE TABLE `t_ipf_ccm_bo_relation` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `IPF_CCM_BO_ID` varchar(50) DEFAULT NULL COMMENT '业务对象',
  `PROPERTY_NAME` varchar(50) DEFAULT NULL COMMENT '属性名称',
  `SUB_BO_NAME` varchar(50) DEFAULT NULL COMMENT '子对象名称',
  `SUB_BO_REL_TYPE` varchar(50) DEFAULT NULL COMMENT '子对象关系类型',
  `OBJECT_TYPE` varchar(50) DEFAULT NULL COMMENT '对象类型',
  `DESCRIPTION` varchar(1000) DEFAULT NULL COMMENT '描述',
  `SUB_BO_ORDER_NO` varchar(50) DEFAULT NULL COMMENT '子业务对象的排序号',
  `PERSISTENT_SAVE_TYPE` varchar(50) DEFAULT NULL COMMENT '子业务对象保存方式',
  `GRID_EDIT_TYPE` varchar(50) DEFAULT NULL COMMENT '表格维护方式',
  `LINK_BO_NAME` varchar(50) DEFAULT NULL COMMENT '关联对象名称',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='业务对象关系';

/*Data for the table `t_ipf_ccm_bo_relation` */

/*Table structure for table `t_ipf_ccm_dict` */

DROP TABLE IF EXISTS `t_ipf_ccm_dict`;

CREATE TABLE `t_ipf_ccm_dict` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `DICT_CODE` varchar(50) DEFAULT NULL COMMENT '字典代码',
  `DICT_NAME` varchar(50) DEFAULT NULL COMMENT '字典名称',
  `DICT_TYPE` varchar(50) DEFAULT NULL COMMENT '字典类型',
  `CODE_COLUMN` varchar(50) DEFAULT NULL COMMENT '字典代码字段',
  `NAME_COLUMN` varchar(50) DEFAULT NULL COMMENT '字典名称字段',
  `KEY_COLUMN` varchar(50) DEFAULT NULL COMMENT '字典ID字段',
  `TABLE_NAME` varchar(50) DEFAULT NULL COMMENT '字典表名',
  `IS_GROUP` varchar(20) DEFAULT NULL COMMENT '是否分组',
  `GROUP_COLUMN` varchar(50) DEFAULT NULL COMMENT '分组字段',
  `REMARK` varchar(1000) DEFAULT NULL COMMENT '备注',
  `ORDER_COLUMN` varchar(50) DEFAULT NULL COMMENT '排序字段',
  `IS_SYSTEM` varchar(20) DEFAULT NULL COMMENT '是否系统',
  `DATA_TYPE` varchar(50) DEFAULT NULL COMMENT '数据类型',
  `FIELD_LENGTH` varchar(50) DEFAULT NULL COMMENT '字段长度',
  `DECIMALS` varchar(50) DEFAULT NULL COMMENT '小数位',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='字典类型';

/*Data for the table `t_ipf_ccm_dict` */

/*Table structure for table `t_ipf_ccm_dict_value` */

DROP TABLE IF EXISTS `t_ipf_ccm_dict_value`;

CREATE TABLE `t_ipf_ccm_dict_value` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `IPF_CCM_DICT_ID` varchar(50) DEFAULT NULL COMMENT '业务对象',
  `CODE_VALUE` varchar(50) DEFAULT NULL COMMENT '代码值',
  `DISPLAY_VALUE` varchar(50) DEFAULT NULL COMMENT '显示值',
  `SEQ_NO` varchar(50) DEFAULT NULL COMMENT '顺序号',
  `GROUP_VALUE` varchar(50) DEFAULT NULL COMMENT '分组值',
  `REMARK` varchar(1000) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='字典数据';

/*Data for the table `t_ipf_ccm_dict_value` */

/*Table structure for table `t_ipf_ccm_environment` */

DROP TABLE IF EXISTS `t_ipf_ccm_environment`;

CREATE TABLE `t_ipf_ccm_environment` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `USER_CODE` varchar(200) DEFAULT NULL COMMENT '工程代码',
  `PROJECT_NAME` varchar(50) DEFAULT NULL COMMENT '工程名称',
  `PROJECT_PATH` varchar(1) DEFAULT NULL COMMENT '工程路径',
  `SRC_PATH` varchar(1) DEFAULT NULL COMMENT '原代码路径',
  `TEMPLATE_PATH` varchar(50) DEFAULT NULL COMMENT '模板工程目录',
  `WEB_CONTENT_NAME` varchar(20) DEFAULT NULL COMMENT '模板工程名称',
  `TARGET_PROJECT_NAME` varchar(20) DEFAULT NULL COMMENT '分支工程名称',
  `TARGET_PROJECT_PATH` varchar(50) DEFAULT NULL COMMENT '分支工程路径',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='代码生成环境配置';

/*Data for the table `t_ipf_ccm_environment` */

/*Table structure for table `t_ipf_ccm_numrule` */

DROP TABLE IF EXISTS `t_ipf_ccm_numrule`;

CREATE TABLE `t_ipf_ccm_numrule` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `RULE_CODE` varchar(50) DEFAULT NULL COMMENT '单号规则代码',
  `RULE_NAME` varchar(50) DEFAULT NULL COMMENT '单号规则名称',
  `RULE_EXPRESSION` varchar(2000) DEFAULT NULL COMMENT '单号生成规则',
  `RULE_STATUS` varchar(50) DEFAULT NULL COMMENT '单号规则状态',
  `INITIAL_VALUE` varchar(50) DEFAULT NULL COMMENT '初始值',
  `MAX_VALUE` varchar(50) DEFAULT NULL COMMENT '最大值',
  `GROWTH` varchar(50) DEFAULT NULL COMMENT '增长值',
  `REMARK` varchar(1000) DEFAULT NULL COMMENT '备注',
  `IS_ACTIVE` varchar(20) DEFAULT NULL COMMENT '有效',
  `IPF_CCM_BO_ID` varchar(50) DEFAULT NULL COMMENT '业务对象ID',
  `BO_NAME` varchar(50) DEFAULT NULL COMMENT '业务对象名称',
  `IPF_CCM_BO_PROPERTY_ID` varchar(50) DEFAULT NULL COMMENT '属性ID',
  `PROPERTY_NAME` varchar(50) DEFAULT NULL COMMENT '属性名称',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='单号生成规则';

/*Data for the table `t_ipf_ccm_numrule` */

/*Table structure for table `t_ipf_ccm_numrule_list` */

DROP TABLE IF EXISTS `t_ipf_ccm_numrule_list`;

CREATE TABLE `t_ipf_ccm_numrule_list` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `IPF_CCM_NUMRULE_ID` varchar(50) DEFAULT NULL COMMENT '单号生成规则',
  `CONST_EXPRESSION` varchar(2000) DEFAULT NULL COMMENT '规则内容',
  `CURRENT_VALUE` varchar(50) DEFAULT NULL COMMENT '当前值',
  `INITIAL_VALUE` varchar(50) DEFAULT NULL COMMENT '初始值',
  `MAX_VALUE` varchar(50) DEFAULT NULL COMMENT '最大值',
  `GROWTH` varchar(50) DEFAULT NULL COMMENT '增长值',
  `REMARK` varchar(1000) DEFAULT NULL COMMENT '备注',
  `IS_ACTIVE` varchar(20) DEFAULT NULL COMMENT '有效',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='单号生成规则历史';

/*Data for the table `t_ipf_ccm_numrule_list` */

/*Table structure for table `t_ipf_ccm_shlp` */

DROP TABLE IF EXISTS `t_ipf_ccm_shlp`;

CREATE TABLE `t_ipf_ccm_shlp` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `SHLP_NAME` varchar(50) DEFAULT NULL COMMENT '名称',
  `SHLP_STATUS` varchar(50) DEFAULT NULL COMMENT '状态',
  `DATA_SOURCE` varchar(1000) DEFAULT NULL COMMENT '数据源',
  `DATA_SOURCE_TYPE` varchar(50) DEFAULT NULL COMMENT '数据源类型',
  `VALUE_COLUMN` varchar(50) DEFAULT NULL COMMENT '值字段',
  `DISPLAY_COLUMN` varchar(50) DEFAULT NULL COMMENT '文本字段',
  `RULE_NO` varchar(50) DEFAULT NULL COMMENT '业务规则号',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='搜索帮助';

/*Data for the table `t_ipf_ccm_shlp` */

/*Table structure for table `t_ipf_ccm_shlp_detail` */

DROP TABLE IF EXISTS `t_ipf_ccm_shlp_detail`;

CREATE TABLE `t_ipf_ccm_shlp_detail` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `IPF_CCM_SHLP_ID` varchar(50) DEFAULT NULL COMMENT '搜索帮助',
  `SHLP_NAME` varchar(50) DEFAULT NULL COMMENT '搜索帮助名称',
  `FIELD_NAME` varchar(50) DEFAULT NULL COMMENT '字段名',
  `FIELD_TEXT` varchar(1000) DEFAULT NULL COMMENT '显示文本',
  `LIST_POSITION` varchar(50) DEFAULT NULL COMMENT '字段清单中的位置',
  `IS_VISIBLE` varchar(20) DEFAULT NULL COMMENT '是否清单中显示',
  `IS_INPUT` varchar(20) DEFAULT NULL COMMENT '输入参数',
  `IS_OUTPUT` varchar(20) DEFAULT NULL COMMENT '输出参数',
  `DETAIL_STATUS` varchar(50) DEFAULT NULL COMMENT '状态',
  `DATA_TYPE` varchar(50) DEFAULT NULL COMMENT '数据类型',
  `DECIMALS` varchar(50) DEFAULT NULL COMMENT '小数位',
  `DEFAULT_VALUE` varchar(50) DEFAULT NULL COMMENT '默认值',
  `COLUMN_LENGTH` varchar(50) DEFAULT NULL COMMENT '长度',
  `CONDITION_POSITION` varchar(50) DEFAULT NULL COMMENT '条件字段位置',
  `OPERATION` varchar(50) DEFAULT NULL COMMENT '操作符',
  `IS_ROLL_CHANGE` varchar(20) DEFAULT NULL COMMENT '条件选择类型',
  `IS_EDITABLE` varchar(20) DEFAULT NULL COMMENT '弹出窗表格中可编辑',
  `DDTEXT` varchar(1000) DEFAULT NULL COMMENT '字段中文描述',
  `IS_SORT` varchar(20) DEFAULT NULL COMMENT '排序',
  `SORT_ORDER` varchar(50) DEFAULT NULL COMMENT '排序顺序',
  `SORT_TYPE` varchar(50) DEFAULT NULL COMMENT '排序类型',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='搜索帮助明细';

/*Data for the table `t_ipf_ccm_shlp_detail` */

/*Table structure for table `t_ipf_ccm_shlp_text` */

DROP TABLE IF EXISTS `t_ipf_ccm_shlp_text`;

CREATE TABLE `t_ipf_ccm_shlp_text` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `IPF_CCM_SHLP_ID` varchar(50) DEFAULT NULL COMMENT '搜索帮助',
  `DD_LANGUAGE` varchar(50) DEFAULT NULL COMMENT '语言',
  `DD_TEXT` varchar(1000) DEFAULT NULL COMMENT '文本描述',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='搜索帮助多语言';

/*Data for the table `t_ipf_ccm_shlp_text` */

/*Table structure for table `t_ipf_ccm_strategy` */

DROP TABLE IF EXISTS `t_ipf_ccm_strategy`;

CREATE TABLE `t_ipf_ccm_strategy` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `STRATEGY_TYPE` varchar(50) DEFAULT NULL COMMENT '策略类别',
  `STRATEGY_CODE` varchar(50) DEFAULT NULL COMMENT '策略编码',
  `STRATEGY_NAME` varchar(50) DEFAULT NULL COMMENT '策略名称',
  `STRATEGY_DES` varchar(1000) DEFAULT NULL COMMENT '策略描述',
  `DRL_FILE` varchar(1000) DEFAULT NULL COMMENT 'DRL文件',
  `DRL_ROUTE` varchar(1000) DEFAULT NULL COMMENT 'DRL路径',
  `PACKAGE_NAME` varchar(50) DEFAULT NULL COMMENT '包名',
  `RULE_NO` varchar(50) DEFAULT NULL COMMENT '规则号',
  `RULE_TYPE` varchar(50) DEFAULT NULL COMMENT '规则类型',
  `SOURCE_CODE` varchar(50) DEFAULT NULL COMMENT '源代码',
  `SVN_REVISION` varchar(50) DEFAULT NULL COMMENT 'SVN版本',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='策略定义';

/*Data for the table `t_ipf_ccm_strategy` */

/*Table structure for table `t_ipf_ccm_strategy_param` */

DROP TABLE IF EXISTS `t_ipf_ccm_strategy_param`;

CREATE TABLE `t_ipf_ccm_strategy_param` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `IPF_CCM_STRATEGY_ID` varchar(50) DEFAULT NULL COMMENT '策略',
  `PARAM_TYPE` varchar(50) DEFAULT NULL COMMENT '参数类型',
  `PARAM_NAME` varchar(50) DEFAULT NULL COMMENT '参数名',
  `PARAM_DES` varchar(1000) DEFAULT NULL COMMENT '参数描述',
  `RTM_CONFIG_CODE` varchar(50) DEFAULT NULL COMMENT '运行期配置',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='策略参数定义';

/*Data for the table `t_ipf_ccm_strategy_param` */

/*Table structure for table `t_ipf_ccm_template` */

DROP TABLE IF EXISTS `t_ipf_ccm_template`;

CREATE TABLE `t_ipf_ccm_template` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `TEMPLATE_FILE` varchar(200) DEFAULT NULL COMMENT '模板文件',
  `TEMPLATE_DESC` varchar(200) DEFAULT NULL COMMENT '模板描述',
  `TEMPLATE_TYPE` varchar(20) DEFAULT NULL COMMENT '模板类型',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='模板文件';

/*Data for the table `t_ipf_ccm_template` */

/*Table structure for table `t_ipf_ccm_ui_layout` */

DROP TABLE IF EXISTS `t_ipf_ccm_ui_layout`;

CREATE TABLE `t_ipf_ccm_ui_layout` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `UI_LAYOUT_NAME` varchar(50) DEFAULT NULL COMMENT '名称',
  `DESCRIPTION` varchar(50) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='界面布局';

/*Data for the table `t_ipf_ccm_ui_layout` */

/*Table structure for table `t_ipf_ccm_ui_layout_config` */

DROP TABLE IF EXISTS `t_ipf_ccm_ui_layout_config`;

CREATE TABLE `t_ipf_ccm_ui_layout_config` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `IPF_CCM_BO_ID` varchar(50) DEFAULT NULL COMMENT '业务对象',
  `BO_ID` varchar(50) DEFAULT NULL COMMENT '业务对象ID',
  `PAGE_NAME` varchar(50) DEFAULT NULL COMMENT '页面名称',
  `LAYOUT_ELEMENT_NAME` varchar(50) DEFAULT NULL COMMENT '布局元素名称',
  `LAYOUT_ELEMENT_DESCRIPTION` varchar(200) DEFAULT NULL COMMENT '布局元素描述',
  `BO_NAME` varchar(50) DEFAULT NULL COMMENT '业务对象名称',
  `BO_ELEMENT_NAME` varchar(50) DEFAULT NULL COMMENT '业务对象布局元素名称',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='业务对象界面布局';

/*Data for the table `t_ipf_ccm_ui_layout_config` */

/*Table structure for table `t_ipf_ccm_ui_layout_detail` */

DROP TABLE IF EXISTS `t_ipf_ccm_ui_layout_detail`;

CREATE TABLE `t_ipf_ccm_ui_layout_detail` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `IPF_CCM_UI_LAYOUT_ID` varchar(50) DEFAULT NULL COMMENT '界面布局',
  `IPF_CCM_UI_LAYOUT_LIST_ID` varchar(50) DEFAULT NULL COMMENT '界面布局列表',
  `LAYOUT_ELEMENT_NAME` varchar(50) DEFAULT NULL COMMENT '名称',
  `DESCRIPTION` varchar(50) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='界面布局明细';

/*Data for the table `t_ipf_ccm_ui_layout_detail` */

/*Table structure for table `t_ipf_ccm_ui_layout_list` */

DROP TABLE IF EXISTS `t_ipf_ccm_ui_layout_list`;

CREATE TABLE `t_ipf_ccm_ui_layout_list` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `IPF_CCM_UI_LAYOUT_ID` varchar(50) DEFAULT NULL COMMENT '界面布局',
  `PAGE_NAME` varchar(50) DEFAULT NULL COMMENT '名称',
  `DESCRIPTION` varchar(50) DEFAULT NULL COMMENT '描述',
  `IMAGE_PATH` varchar(200) DEFAULT NULL COMMENT '图片路径',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='界面布局列表';

/*Data for the table `t_ipf_ccm_ui_layout_list` */

/*Table structure for table `t_ipf_dml_column` */

DROP TABLE IF EXISTS `t_ipf_dml_column`;

CREATE TABLE `t_ipf_dml_column` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `IPF_DML_TABLE_ID` varchar(50) DEFAULT NULL COMMENT '表名',
  `COLUMN_NAME` varchar(50) DEFAULT NULL COMMENT '字段名称',
  `IPF_DML_ELEMENT_ID` varchar(50) DEFAULT NULL COMMENT '数据元素ID',
  `ELEMENT_CODE` varchar(50) DEFAULT NULL COMMENT '数据元素代码',
  `FIELD_TEXT` varchar(200) DEFAULT NULL COMMENT '显示文本',
  `DATA_TYPE` varchar(50) DEFAULT NULL COMMENT '数据类型',
  `FIELD_LENGTH` varchar(50) DEFAULT NULL COMMENT '字段长度',
  `DECIMALS` varchar(50) DEFAULT NULL COMMENT '小数位',
  `IS_NOT_NULL` varchar(20) DEFAULT NULL COMMENT '非空',
  `IS_PRIMARY_KEY` varchar(20) DEFAULT NULL COMMENT '主键',
  `DEFAULT_VALUE` varchar(50) DEFAULT NULL COMMENT '默认值',
  `INIT_VALUE` varchar(50) DEFAULT NULL COMMENT '初始值',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='表字段';

/*Data for the table `t_ipf_dml_column` */

/*Table structure for table `t_ipf_dml_constraint` */

DROP TABLE IF EXISTS `t_ipf_dml_constraint`;

CREATE TABLE `t_ipf_dml_constraint` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `IPF_DML_TABLE_ID` varchar(50) DEFAULT NULL COMMENT '表名',
  `CONSTRAINT_NAME` varchar(50) DEFAULT NULL COMMENT '约束名称',
  `CONSTRAINT_TYPE` varchar(50) DEFAULT NULL COMMENT '约束类型',
  `COLUMN_NAME` varchar(50) DEFAULT NULL COMMENT '字段名称',
  `FOREIGN_TABLE_NAME` varchar(50) DEFAULT NULL COMMENT '外关联表名',
  `FOREIGN_COLUMN_NAME` varchar(50) DEFAULT NULL COMMENT '外关联字段名',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='表约束';

/*Data for the table `t_ipf_dml_constraint` */

/*Table structure for table `t_ipf_dml_constraint_column` */

DROP TABLE IF EXISTS `t_ipf_dml_constraint_column`;

CREATE TABLE `t_ipf_dml_constraint_column` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `IPF_DML_CONSTRAINT_ID` varchar(50) DEFAULT NULL COMMENT '约束',
  `COLUMN_NAME` varchar(50) DEFAULT NULL COMMENT '字段名称',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='表约束字段';

/*Data for the table `t_ipf_dml_constraint_column` */

/*Table structure for table `t_ipf_dml_element` */

DROP TABLE IF EXISTS `t_ipf_dml_element`;

CREATE TABLE `t_ipf_dml_element` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `ELEMENT_CODE` varchar(50) DEFAULT NULL COMMENT '数据元素代码',
  `FIELD_TEXT` varchar(200) DEFAULT NULL COMMENT '显示文本',
  `DATA_TYPE` varchar(50) DEFAULT NULL COMMENT '数据类型',
  `FIELD_LENGTH` varchar(50) DEFAULT NULL COMMENT '字段长度',
  `DECIMALS` varchar(50) DEFAULT NULL COMMENT '小数位',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据元素';

/*Data for the table `t_ipf_dml_element` */

/*Table structure for table `t_ipf_dml_element_text` */

DROP TABLE IF EXISTS `t_ipf_dml_element_text`;

CREATE TABLE `t_ipf_dml_element_text` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `IPF_DML_ELEMENT_ID` varchar(50) DEFAULT NULL COMMENT '数据元素',
  `DD_LANGUAGE` varchar(50) DEFAULT NULL COMMENT '语言',
  `DD_TEXT` varchar(1000) DEFAULT NULL COMMENT '文本描述',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据元素多语言';

/*Data for the table `t_ipf_dml_element_text` */

/*Table structure for table `t_ipf_dml_index` */

DROP TABLE IF EXISTS `t_ipf_dml_index`;

CREATE TABLE `t_ipf_dml_index` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `IPF_DML_TABLE_ID` varchar(50) DEFAULT NULL COMMENT '表名',
  `INDEX_NAME` varchar(50) DEFAULT NULL COMMENT '索引名称',
  `INDEX_TYPE` varchar(50) DEFAULT NULL COMMENT '索引类型',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='表索引';

/*Data for the table `t_ipf_dml_index` */

/*Table structure for table `t_ipf_dml_index_column` */

DROP TABLE IF EXISTS `t_ipf_dml_index_column`;

CREATE TABLE `t_ipf_dml_index_column` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `IPF_DML_INDEX_ID` varchar(50) DEFAULT NULL COMMENT '索引',
  `COLUMN_NAME` varchar(50) DEFAULT NULL COMMENT '字段名称',
  `INDEX_OPTION` varchar(1000) DEFAULT NULL COMMENT '索引选项',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='表索引字段';

/*Data for the table `t_ipf_dml_index_column` */

/*Table structure for table `t_ipf_dml_script_publish` */

DROP TABLE IF EXISTS `t_ipf_dml_script_publish`;

CREATE TABLE `t_ipf_dml_script_publish` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `FILE_NAME` varchar(50) DEFAULT NULL COMMENT '文件名称',
  `FILE_DES` varchar(50) DEFAULT NULL COMMENT '文件描述',
  `FILE_CONTENT` varchar(2000) DEFAULT NULL COMMENT '文件内容',
  `IS_PUBLISHED` varchar(20) DEFAULT NULL COMMENT '已发布',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='脚本发布';

/*Data for the table `t_ipf_dml_script_publish` */

/*Table structure for table `t_ipf_dml_table` */

DROP TABLE IF EXISTS `t_ipf_dml_table`;

CREATE TABLE `t_ipf_dml_table` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `TABLE_NAME` varchar(50) DEFAULT NULL COMMENT '表名',
  `TABLE_TYPE` varchar(50) DEFAULT NULL COMMENT '表类型',
  `TABLE_DESC` varchar(50) DEFAULT NULL COMMENT '表描述',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='表定义';

/*Data for the table `t_ipf_dml_table` */

/*Table structure for table `t_ipf_dml_view` */

DROP TABLE IF EXISTS `t_ipf_dml_view`;

CREATE TABLE `t_ipf_dml_view` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `VIEW_NAME` varchar(50) DEFAULT NULL COMMENT '视图名称',
  `VIEW_DES` varchar(1000) DEFAULT NULL COMMENT '视图描述',
  `VIEW_TYPE` varchar(50) DEFAULT NULL COMMENT '视图类型',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='视图定义';

/*Data for the table `t_ipf_dml_view` */

/*Table structure for table `t_ipf_dml_view_column` */

DROP TABLE IF EXISTS `t_ipf_dml_view_column`;

CREATE TABLE `t_ipf_dml_view_column` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `IPF_DML_VIEW_ID` varchar(50) DEFAULT NULL COMMENT '视图',
  `COLUMN_NAME` varchar(50) DEFAULT NULL COMMENT '字段名称',
  `FIELD_TEXT` varchar(50) DEFAULT NULL COMMENT '字段标题',
  `DATA_TYPE` varchar(50) DEFAULT NULL COMMENT '数据类型',
  `FIELD_LENGTH` varchar(50) DEFAULT NULL COMMENT '字段长度',
  `DECIMALS` varchar(20) DEFAULT NULL COMMENT '小数位',
  `IS_NOT_NULL` varchar(20) DEFAULT NULL COMMENT '非空',
  `IS_PRIMARY_KEY` varchar(20) DEFAULT NULL COMMENT '主键',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='视图字段';

/*Data for the table `t_ipf_dml_view_column` */

/*Table structure for table `t_ipf_dml_view_sql` */

DROP TABLE IF EXISTS `t_ipf_dml_view_sql`;

CREATE TABLE `t_ipf_dml_view_sql` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `IPF_DML_VIEW_ID` varchar(50) DEFAULT NULL COMMENT '视图',
  `DBMS_TYPE` varchar(50) DEFAULT NULL COMMENT '数据库类型',
  `SQL_STATEMENT` varchar(2000) DEFAULT NULL COMMENT 'SQL表达式',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='视图SQL';

/*Data for the table `t_ipf_dml_view_sql` */

/*Table structure for table `t_ipf_fci_build` */

DROP TABLE IF EXISTS `t_ipf_fci_build`;

CREATE TABLE `t_ipf_fci_build` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `IPF_FCI_VIEW_ID` varchar(50) DEFAULT NULL COMMENT '视图',
  `IPF_FCI_PROJECT_ID` varchar(50) DEFAULT NULL COMMENT '项目',
  `MAJOR_VERSION` varchar(50) DEFAULT NULL COMMENT '主版本号',
  `MINOR_VERSION` varchar(50) DEFAULT NULL COMMENT '次版本号',
  `MAX_VERSION_BUILD_NUMBER` varchar(50) DEFAULT NULL COMMENT '最大版本编译号',
  `IS_DEFAULT` varchar(20) DEFAULT NULL COMMENT '是否默认',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='视图编译号';

/*Data for the table `t_ipf_fci_build` */

/*Table structure for table `t_ipf_fci_label` */

DROP TABLE IF EXISTS `t_ipf_fci_label`;

CREATE TABLE `t_ipf_fci_label` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `IPF_FCI_VIEW_ID` varchar(50) DEFAULT NULL COMMENT '视图',
  `LABEL_NAME` varchar(50) DEFAULT NULL COMMENT '基线名称',
  `LABEL_DESC` varchar(200) DEFAULT NULL COMMENT '基线描述',
  `IPF_FCI_BUILD_ID` varchar(50) DEFAULT NULL COMMENT '编译号',
  `MAJOR_VERSION` varchar(50) DEFAULT NULL COMMENT '主版本号',
  `MINOR_VERSION` varchar(50) DEFAULT NULL COMMENT '次版本号',
  `VERSION_BUILD_NUMBER` varchar(50) DEFAULT NULL COMMENT '版本编译号',
  `REVISION_NUMBER` varchar(50) DEFAULT NULL COMMENT '修订号',
  `SVN_REVISION` varchar(50) DEFAULT NULL COMMENT 'SVN修订号',
  `SVN_TAGS_PATH` varchar(1000) DEFAULT NULL COMMENT 'SVN基线路径',
  `IS_ACTIVE` varchar(20) DEFAULT NULL COMMENT '启用',
  `VIEW_NAME` varchar(50) DEFAULT NULL COMMENT '视图名称',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='基线管理';

/*Data for the table `t_ipf_fci_label` */

/*Table structure for table `t_ipf_fci_label_detail` */

DROP TABLE IF EXISTS `t_ipf_fci_label_detail`;

CREATE TABLE `t_ipf_fci_label_detail` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `IPF_FCI_LABEL_ID` varchar(50) DEFAULT NULL COMMENT '基线',
  `IPF_FCI_VIEW_ID` varchar(50) DEFAULT NULL COMMENT '视图',
  `CONFIG_ITEM_TYPE` varchar(50) DEFAULT NULL COMMENT '配置项名称',
  `CONFIG_ITEM_CODE` varchar(50) DEFAULT NULL COMMENT '配置项代码',
  `CONFIG_ITEM_ID` varchar(50) DEFAULT NULL COMMENT '配置项ID',
  `REVISION_NUMBER` varchar(50) DEFAULT NULL COMMENT '修订号',
  `RELATION_MEMBER_ID` varchar(50) DEFAULT NULL COMMENT '关联成员',
  `IS_ACTIVE` varchar(20) DEFAULT NULL COMMENT '启用',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='基线明细';

/*Data for the table `t_ipf_fci_label_detail` */

/*Table structure for table `t_ipf_fci_project` */

DROP TABLE IF EXISTS `t_ipf_fci_project`;

CREATE TABLE `t_ipf_fci_project` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `PROJECT_NAME` varchar(50) DEFAULT NULL COMMENT '项目名称',
  `PROJECT_TYPE` varchar(50) DEFAULT NULL COMMENT '项目类型',
  `PROJECT_DES` varchar(200) DEFAULT NULL COMMENT '项目描述',
  `DEFAULT_VIEW_ID` varchar(50) DEFAULT NULL COMMENT '默认视图',
  `SVN_REPOSITORY_PATH` varchar(200) DEFAULT NULL COMMENT 'SVN路径',
  `SVN_USER` varchar(50) DEFAULT NULL COMMENT 'SVN帐户',
  `SVN_PASSWORD` varchar(50) DEFAULT NULL COMMENT 'SVN密码',
  `MAX_REVISON_NUMBER` varchar(50) DEFAULT NULL COMMENT '最大修订号',
  `DD_LANGUAGE` varchar(50) DEFAULT NULL COMMENT '默认语言',
  `DB_TYPE` varchar(50) DEFAULT NULL COMMENT '数据库类型',
  `DB_VERSION` varchar(20) DEFAULT NULL COMMENT '数据库版本号',
  `IS_ACTIVE` varchar(20) DEFAULT NULL COMMENT '启用',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目管理';

/*Data for the table `t_ipf_fci_project` */

/*Table structure for table `t_ipf_fci_revision` */

DROP TABLE IF EXISTS `t_ipf_fci_revision`;

CREATE TABLE `t_ipf_fci_revision` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `IPF_FCI_VIEW_ID` varchar(50) DEFAULT NULL COMMENT '视图',
  `IPF_FCI_PROJECT_ID` varchar(50) DEFAULT NULL COMMENT '项目',
  `REVISION_NUMBER` varchar(50) DEFAULT NULL COMMENT '修订号',
  `REMARK` varchar(1000) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='视图修订号';

/*Data for the table `t_ipf_fci_revision` */

/*Table structure for table `t_ipf_fci_view` */

DROP TABLE IF EXISTS `t_ipf_fci_view`;

CREATE TABLE `t_ipf_fci_view` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `VIEW_NAME` varchar(50) DEFAULT NULL COMMENT '视图名称',
  `PROJECT_NAME` varchar(50) DEFAULT NULL COMMENT '项目名称',
  `VIEW_DESC` varchar(50) DEFAULT NULL COMMENT '视图描述',
  `SVN_BRANCHES_PATH` varchar(200) DEFAULT NULL COMMENT 'SVN路径',
  `IS_ACTIVE` varchar(20) DEFAULT NULL COMMENT '启用',
  `CONNECTION_STRING` varchar(1000) DEFAULT NULL COMMENT '目标数据库连接',
  `IPF_FCI_PROJECT_ID` varchar(50) DEFAULT NULL COMMENT '所属项目',
  `SOURCE_LABEL_ID` varchar(50) DEFAULT NULL COMMENT '基线名称',
  `IS_PERMISSION_PAGE_ONLY` varchar(20) DEFAULT NULL COMMENT '只生成页面权限',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='视图管理';

/*Data for the table `t_ipf_fci_view` */

/*Table structure for table `t_ipf_fci_view_member` */

DROP TABLE IF EXISTS `t_ipf_fci_view_member`;

CREATE TABLE `t_ipf_fci_view_member` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `IPF_FCI_VIEW_ID` varchar(50) DEFAULT NULL COMMENT '视图',
  `CONFIG_ITEM_TYPE` varchar(50) DEFAULT NULL COMMENT '配置项类型',
  `CONFIG_ITEM_CODE` varchar(50) DEFAULT NULL COMMENT '配置项代码',
  `CONFIG_ITEM_ID` varchar(50) DEFAULT NULL COMMENT '配置项ID',
  `REVISION_NUMBER` varchar(50) DEFAULT NULL COMMENT '修订号',
  `SOURCE_TYPE` varchar(50) DEFAULT NULL COMMENT '来源类型',
  `SOURCE_ITEM_ID` varchar(50) DEFAULT NULL COMMENT '来源',
  `RELATION_MEMBER_ID` varchar(50) DEFAULT NULL COMMENT '关联成员',
  `IS_LOCK` varchar(50) DEFAULT NULL COMMENT '锁定状态',
  `LOCK_USER` varchar(50) DEFAULT NULL COMMENT '锁定人',
  `LOCK_TIME` varchar(20) DEFAULT NULL COMMENT '锁定时间',
  `IS_ACTIVE` varchar(20) DEFAULT NULL COMMENT '启用',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='视图成员';

/*Data for the table `t_ipf_fci_view_member` */

/*Table structure for table `t_ipf_poi_setting` */

DROP TABLE IF EXISTS `t_ipf_poi_setting`;

CREATE TABLE `t_ipf_poi_setting` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `BO_NAME` varchar(50) DEFAULT NULL COMMENT '业务对象名称',
  `POI_TYPE` varchar(20) DEFAULT NULL COMMENT '导入导出类型',
  `TEMPLATE_FILE_NAME` varchar(50) DEFAULT NULL COMMENT '模板文件名称',
  `TEMPLATE_URL` varchar(50) DEFAULT NULL COMMENT '模板地址',
  `FILE_NAME` varchar(50) DEFAULT NULL COMMENT '导入导出文件名',
  `SOURCE_SERVICE` varchar(200) DEFAULT NULL COMMENT '请求数据路径',
  `CLASS_NAME` varchar(50) DEFAULT NULL COMMENT 'POI对象全名',
  `TEMPLATE_EXT_NAME` varchar(50) DEFAULT NULL COMMENT '模板文件扩展名',
  `RULE_NO` varchar(50) DEFAULT NULL COMMENT '导入规则号',
  `DICT_NAME` varchar(50) DEFAULT NULL COMMENT '数据字典路径',
  `DEAL_SERVICE` varchar(50) DEFAULT NULL COMMENT '结果处理服务',
  `METHODE_NAME` varchar(50) DEFAULT NULL COMMENT '结果处理服务方法名',
  `IS_ASYNC` varchar(50) DEFAULT NULL COMMENT '是否异步下载',
  `ASYNC_PAGE_SIZE` varchar(50) DEFAULT NULL COMMENT '异步每页行数',
  `TEMPLATE` varchar(2000) DEFAULT NULL COMMENT '模板内容',
  `TEMPLATE_FILE_KEY` varchar(50) DEFAULT NULL COMMENT '模板文件KEY',
  `PRIMARY_COLUMNS` varchar(50) DEFAULT NULL COMMENT '主键指定',
  `CHILDREN_TABLE` varchar(50) DEFAULT NULL COMMENT '子表信息定义类',
  `SORT_EXPRESS` varchar(2000) DEFAULT NULL COMMENT '排序表达式',
  `ALLOW_PARAMETER` varchar(50) DEFAULT NULL COMMENT '是否接收参数',
  `DEFINE_COLUMN` varchar(50) DEFAULT NULL COMMENT '导入字段定义',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='POI配置管理';

/*Data for the table `t_ipf_poi_setting` */

/*Table structure for table `t_ipf_req_rule` */

DROP TABLE IF EXISTS `t_ipf_req_rule`;

CREATE TABLE `t_ipf_req_rule` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `RULE_NAME` varchar(50) DEFAULT NULL COMMENT '规则名称',
  `RULE_NO` varchar(50) DEFAULT NULL COMMENT '规则号',
  `RULE_TYPE` varchar(50) DEFAULT NULL COMMENT '规则类型',
  `RULE_STATUS` varchar(50) DEFAULT NULL COMMENT '规则状态',
  `TRIGGER_TYPE` varchar(50) DEFAULT NULL COMMENT '触发类型',
  `PHYSICAL_LOCATION` varchar(50) DEFAULT NULL COMMENT '所处物理位置',
  `ACTION_TYPE` varchar(50) DEFAULT NULL COMMENT '动作类型',
  `BUSINESS_LOCATION` varchar(50) DEFAULT NULL COMMENT '所处业务位置',
  `BUSINESS_MODULE` varchar(50) DEFAULT NULL COMMENT '业务模块',
  `DROOLS_ATTRIBUTE` varchar(1000) DEFAULT NULL COMMENT '规则属性',
  `RULE_DESC` varchar(50) DEFAULT NULL COMMENT '规则描述',
  `IS_DECISION_TABLE` varchar(20) DEFAULT NULL COMMENT '是否使用决策表',
  `PUBLIC_TYPE` varchar(50) DEFAULT NULL COMMENT '共享类型',
  `IPF_CCM_BO_ID` varchar(50) DEFAULT NULL COMMENT '业务对象',
  `IMPORT_DESC` varchar(50) DEFAULT NULL COMMENT '传参说明',
  `DROOLS_WHEN` varchar(1000) DEFAULT NULL COMMENT 'DROOLS条件',
  `DROOLS_THEN` varchar(1000) DEFAULT NULL COMMENT 'DROOLS动作',
  `REMARK` varchar(1000) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='规则需求表';

/*Data for the table `t_ipf_req_rule` */

/*Table structure for table `t_ipf_rtm_config` */

DROP TABLE IF EXISTS `t_ipf_rtm_config`;

CREATE TABLE `t_ipf_rtm_config` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `CONFIG_CODE` varchar(50) DEFAULT NULL COMMENT '配置代码',
  `CONFIG_NAME` varchar(50) DEFAULT NULL COMMENT '配置名称',
  `TYPE_CODE` varchar(50) DEFAULT NULL COMMENT '类别代码',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='运行期配置';

/*Data for the table `t_ipf_rtm_config` */

/*Table structure for table `t_ipf_rtm_config_attr` */

DROP TABLE IF EXISTS `t_ipf_rtm_config_attr`;

CREATE TABLE `t_ipf_rtm_config_attr` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `IPF_RTM_CONFIG_ID` varchar(50) DEFAULT NULL COMMENT '运行期配置',
  `SEQ_NO` varchar(50) DEFAULT NULL COMMENT '序号',
  `DISPLAY_LABEL` varchar(50) DEFAULT NULL COMMENT '显示名称',
  `DATA_TYPE` varchar(50) DEFAULT NULL COMMENT '数据类型',
  `UI_TYPE` varchar(50) DEFAULT NULL COMMENT 'UI组件类型',
  `DICT_TABLE_NAME` varchar(50) DEFAULT NULL COMMENT '字典表编码',
  `DICT_GROUP_VALUE` varchar(50) DEFAULT NULL COMMENT '字典表分组名',
  `SEARCH_HELP` varchar(50) DEFAULT NULL COMMENT '搜索帮助名',
  `SH_VALUE_COLUMN` varchar(50) DEFAULT NULL COMMENT '搜索帮助值字段',
  `SH_DISPLAY_COLUMN` varchar(50) DEFAULT NULL COMMENT '搜索帮助文本字段',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='运行期配置明细';

/*Data for the table `t_ipf_rtm_config_attr` */

/*Table structure for table `t_ipf_rtm_config_attr_bo` */

DROP TABLE IF EXISTS `t_ipf_rtm_config_attr_bo`;

CREATE TABLE `t_ipf_rtm_config_attr_bo` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `IPF_RTM_CONFIG_ATTR_ID` varchar(50) DEFAULT NULL COMMENT '运行期配置明细',
  `IPF_RTM_CONFIG_ID` varchar(50) DEFAULT NULL COMMENT '运行期配置明细',
  `IPF_CCM_BO_ID` varchar(50) DEFAULT NULL COMMENT '业务对象ID',
  `BO_NAME` varchar(50) DEFAULT NULL COMMENT '业务对象名称',
  `BO_DESC` varchar(1000) DEFAULT NULL COMMENT '业务对象描述',
  `BO_ATTRIBUTE_NAME` varchar(50) DEFAULT NULL COMMENT '属性名称',
  `IS_VISIBLE` varchar(20) DEFAULT NULL COMMENT '可见',
  `IS_REQUIRED` varchar(20) DEFAULT NULL COMMENT '必输',
  `DEFAULT_VALUE` varchar(50) DEFAULT NULL COMMENT '默认值',
  `SHLP_VALUE_FILED` varchar(50) DEFAULT NULL COMMENT '搜索帮助值字段',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='运行期配置明细BO扩展';

/*Data for the table `t_ipf_rtm_config_attr_bo` */

/*Table structure for table `t_ipf_rtm_type` */

DROP TABLE IF EXISTS `t_ipf_rtm_type`;

CREATE TABLE `t_ipf_rtm_type` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `TYPE_CODE` varchar(50) DEFAULT NULL COMMENT '类别代码',
  `TYPE_NAME` varchar(50) DEFAULT NULL COMMENT '类别名称',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='运行期配置类型';

/*Data for the table `t_ipf_rtm_type` */

/*Table structure for table `t_ipf_rtm_type_bo` */

DROP TABLE IF EXISTS `t_ipf_rtm_type_bo`;

CREATE TABLE `t_ipf_rtm_type_bo` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `IPF_RTM_TYPE_ID` varchar(50) DEFAULT NULL COMMENT '运行期配置类型',
  `IPF_CCM_BO_ID` varchar(50) DEFAULT NULL COMMENT '业务对象ID',
  `BO_NAME` varchar(50) DEFAULT NULL COMMENT '业务对象名称',
  `BO_DESC` varchar(1000) DEFAULT NULL COMMENT '业务对象描述',
  `PROPERTY_NAME` varchar(50) DEFAULT NULL COMMENT '业务对象属性名称',
  `PROPERTY_UTILITY` varchar(50) DEFAULT NULL COMMENT '属性用途',
  `EXTERNAL_BO_NAME` varchar(50) DEFAULT NULL COMMENT '外部业务对象名称',
  `EXTERNAL_MATCH_PROPERTY` varchar(50) DEFAULT NULL COMMENT '查询匹配属性',
  `EXTERNAL_RESULT_PROPERTY` varchar(50) DEFAULT NULL COMMENT '结果属性',
  `EXTERNAL_BO_ID` varchar(50) DEFAULT NULL COMMENT '外部业务对象ID',
  `TRIGGER_PROPERTY_NAME` varchar(50) DEFAULT NULL COMMENT '触发属性名',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='运行期配置界面';

/*Data for the table `t_ipf_rtm_type_bo` */

/*Table structure for table `t_ipf_rtm_type_bo_attr` */

DROP TABLE IF EXISTS `t_ipf_rtm_type_bo_attr`;

CREATE TABLE `t_ipf_rtm_type_bo_attr` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `IPF_RTM_TYPE_BO_ID` varchar(50) DEFAULT NULL COMMENT '运行期配置界面',
  `PROPERTY_NAME` varchar(50) DEFAULT NULL COMMENT '属性名称',
  `FIELD_TEXT` varchar(200) DEFAULT NULL COMMENT '属性中文描述',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='运行期配置字段';

/*Data for the table `t_ipf_rtm_type_bo_attr` */

/*Table structure for table `t_ipf_rtm_type_bo_map` */

DROP TABLE IF EXISTS `t_ipf_rtm_type_bo_map`;

CREATE TABLE `t_ipf_rtm_type_bo_map` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `IPF_RTM_TYPE_BO_ID` varchar(50) DEFAULT NULL COMMENT '运行期配置界面',
  `SOURCE_VALUE` varchar(50) DEFAULT NULL COMMENT '源值',
  `DEST_VALUE` varchar(50) DEFAULT NULL COMMENT '目标值',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='类型与BO对照表';

/*Data for the table `t_ipf_rtm_type_bo_map` */

/*Table structure for table `t_ipf_rule_filter` */

DROP TABLE IF EXISTS `t_ipf_rule_filter`;

CREATE TABLE `t_ipf_rule_filter` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `FILTER_CODE` varchar(50) DEFAULT NULL COMMENT '筛选编号',
  `FILTER_NAME` varchar(50) DEFAULT NULL COMMENT '筛选名称',
  `FILTER_DESC` varchar(1000) DEFAULT NULL COMMENT '描述',
  `FILTER_EXPRESS` varchar(2000) DEFAULT NULL COMMENT '筛选条件表达式',
  `IS_ACTIVE` varchar(20) DEFAULT NULL COMMENT '有效',
  `IS_SYSTEM_CREATE` varchar(20) DEFAULT NULL COMMENT '系统创建',
  `IPF_CCM_BO_ID` varchar(50) DEFAULT NULL COMMENT '业务对象ID',
  `BO_NAME` varchar(50) DEFAULT NULL COMMENT '业务对象名称',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='筛选条件配置';

/*Data for the table `t_ipf_rule_filter` */

/*Table structure for table `t_ipf_rule_filter_detail` */

DROP TABLE IF EXISTS `t_ipf_rule_filter_detail`;

CREATE TABLE `t_ipf_rule_filter_detail` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `IPF_RULE_FILTER_ID` varchar(50) DEFAULT NULL COMMENT '筛选条件',
  `LINE_ID` varchar(50) DEFAULT NULL COMMENT '行号',
  `ATTRIBUTE` varchar(50) DEFAULT NULL COMMENT '表属性',
  `OPERAND` varchar(50) DEFAULT NULL COMMENT '运算符',
  `LITERAL_VALUE` varchar(50) DEFAULT NULL COMMENT '值',
  `AND_OR` varchar(50) DEFAULT NULL COMMENT 'AND或者OR',
  `LEFT_PAREN` varchar(50) DEFAULT NULL COMMENT '左括号数量',
  `RIGHT_PAREN` varchar(50) DEFAULT NULL COMMENT '右括号数量',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='筛选条件配置明细';

/*Data for the table `t_ipf_rule_filter_detail` */

/*Table structure for table `t_ipf_rule_rotate` */

DROP TABLE IF EXISTS `t_ipf_rule_rotate`;

CREATE TABLE `t_ipf_rule_rotate` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `WAREHOUSE_OFFICE_ID` varchar(50) DEFAULT NULL COMMENT '周转单位',
  `RULE_CODE` varchar(50) DEFAULT NULL COMMENT '周转规则代码',
  `RULE_DESC` varchar(200) DEFAULT NULL COMMENT '描述',
  `IS_ACTIVE` varchar(20) DEFAULT NULL COMMENT '启用',
  `IS_SYSTEM_CREATE` varchar(20) DEFAULT NULL COMMENT '系统创建',
  `ROTATE_EXPRESS` varchar(2000) DEFAULT NULL COMMENT '周转规则表达式',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='周转规则';

/*Data for the table `t_ipf_rule_rotate` */

/*Table structure for table `t_ipf_rule_rotate_detail` */

DROP TABLE IF EXISTS `t_ipf_rule_rotate_detail`;

CREATE TABLE `t_ipf_rule_rotate_detail` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `IPF_RULE_ROTATE_ID` varchar(50) DEFAULT NULL COMMENT '周转规则',
  `LINE_ID` varchar(50) DEFAULT NULL COMMENT '行号',
  `LOT_ATTRIBUTES` varchar(50) DEFAULT NULL COMMENT '批次属性',
  `SORT_TYPE` varchar(50) DEFAULT NULL COMMENT '排序',
  `DETAIL_DESC` varchar(2000) DEFAULT NULL COMMENT '描述',
  `IS_ACTIVE` varchar(20) DEFAULT NULL COMMENT '启用',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='周转规则明细';

/*Data for the table `t_ipf_rule_rotate_detail` */

/*Table structure for table `t_ipf_schedule_job` */

DROP TABLE IF EXISTS `t_ipf_schedule_job`;

CREATE TABLE `t_ipf_schedule_job` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `JOB_NAME` varchar(50) DEFAULT NULL COMMENT '任务名称',
  `JOB_GROUP` varchar(50) DEFAULT NULL COMMENT '任务分组',
  `JOB_STATUS` varchar(50) DEFAULT NULL COMMENT '任务状态',
  `CRON_EXPRESSION` varchar(1000) DEFAULT NULL COMMENT '执行频率',
  `JOB_DESC` varchar(1000) DEFAULT NULL COMMENT '任务描述',
  `RULE_NO` varchar(50) DEFAULT NULL COMMENT '规则号',
  `JOB_SERVICE` varchar(50) DEFAULT NULL COMMENT '任务对象',
  `JOB_METHOD` varchar(50) DEFAULT NULL COMMENT '任务方法',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='定时任务';

/*Data for the table `t_ipf_schedule_job` */

/*Table structure for table `t_login_session` */

DROP TABLE IF EXISTS `t_login_session`;

CREATE TABLE `t_login_session` (
  `id` varchar(100) NOT NULL COMMENT '编号',
  `sessionid` varchar(100) DEFAULT NULL COMMENT '会话',
  `loginUser` varchar(100) DEFAULT NULL COMMENT '登录用户',
  `UserName` varchar(100) DEFAULT NULL COMMENT '用户姓名',
  `loginTime` varchar(100) DEFAULT NULL COMMENT '登录时间',
  `projectName` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='登录会话';

/*Data for the table `t_login_session` */

insert  into `t_login_session`(`id`,`sessionid`,`loginUser`,`UserName`,`loginTime`,`projectName`) values ('04A158D3-5308-445E-865F-E2700F51150D','1p5548nqmxsjp','mdm','mdm','2016-10-26 17:7:29','mdm'),('1F385E3A-7CF2-41D2-B67F-5EC26769451D','1or5q3yyen7cl','liuxb','liuxb','2016-10-20 14:11:1','pdqc'),('289E9964-4715-4FF7-AB3F-55E0211AC3B3','134pg92tymnid','liuxb','liuxb','2016-10-03 20:22:56','jfgl'),('2DCAC6B0-DE1F-4162-B6B2-7826684B3F28','fhnq760s40s4','liuxb','liuxb','2017-10-11 17:7:31','pdqc'),('3CE6E24D-2632-4E8D-9F50-E8A145EFE901','z433pw2egbdi','liuxb','liuxb','2017-10-12 11:16:20','pdqc'),('451B3772-E8E3-4A98-AE54-2507A45D0931','1m9nsc267y02r','liuxb','liuxb','2017-10-10 15:11:46','pdqc'),('52CCF9BA-152A-411F-8699-BB3009C6D2AC','14mx7qd22gdeg','liuxb','liuxb','2017-10-11 16:45:3','pdqc'),('55A72A02-BDD6-4A89-9A2E-9CC3A0DBBC3E','1jawilhtrxmya','liuxb','liuxb','2017-10-12 10:56:1','pdqc'),('58FEF14D-53FC-4F30-B870-FC6D87626A51','wkhvxe9p337c','liuxb','liuxb','2016-10-03 21:31:58','jfgl'),('5FE1342A-289A-40FB-8E2E-A353C47A6FD0','j8mbfbud8hjq','cts','cts','2017-10-11 14:5:38','cts'),('6D16A86E-8E16-4D2E-AA75-EEC5137D65FD','1x4ltwu6wp9qk','liuxb','liuxb','2017-10-10 9:44:2','pdqc'),('71D33B9E-0900-40F6-A14D-9F9386D4EE7E','6m9kp8z2h4j1','liuxb','liuxb','2016-10-03 19:39:27','jfgl'),('856BF568-786E-4EB8-B67B-5CA9948C7564','1tg7yx9su05qw','liuxb','liuxb','2016-10-20 14:37:56','pdqc'),('8863DE70-00C2-45A8-A163-F8BC272BA5CB','y878t39oeihz','liuxb','liuxb','2017-10-16 8:58:15','pdqc'),('89AA85FA-9FF2-4266-B925-5F0645C4D194','qriu8rdgnk1q','liuxb','liuxb','2016-10-03 21:43:29','jfgl'),('8C39F1D2-F091-41DE-AA73-97C0DDEC8086','xwt7ykj7sug6','liuxb','liuxb','2017-10-11 11:47:2','pdqc'),('9C38D5E4-71E6-471D-98DE-31A69AFCE03A','9y659pfa5k5r','liuxb','liuxb','2017-10-13 13:54:46','pdqc'),('A27BF321-EBC7-4BE2-A38D-D0DCE8137D47','dcsz0wmepgvl','liuxb','liuxb','2017-10-12 10:34:19','pdqc'),('A52F6C78-8F19-4727-818B-A239BF25D9AF','1swn7a0uienu7','liuxb','liuxb','2017-10-10 9:21:10','pdqc'),('AEC5B684-05C7-4497-903D-F820E95B6BCD','18ss63ovsxvdr','liuxb','liuxb','2016-10-09 21:42:12','jfgl'),('BD20F031-62BF-4699-A74C-5C731647FF65','o8tkpfm1t0h1','cts','cts','2017-10-13 11:31:23','cts'),('C5F91EFD-7C14-4D21-93AF-921446669FB3','11zn9krcwgdxj','liuxb','liuxb','2016-10-14 2:6:11','pdqc'),('C739E4E8-8E2E-4DB5-A19B-FC260BE1CDD9','1snl5tgjxsozr','mdm','mdm','2016-10-27 18:18:47','mdm'),('CA2F45B2-41BE-4D6E-B6B3-3CFB47021D19','mojpwy2hhnx7','liuxb','liuxb','2017-10-25 10:38:39','pdqc'),('CA48B719-BADC-433D-9B82-0A2599D26E79','u7nzqul0r234','liuxb','liuxb','2016-10-03 19:55:19','jfgl'),('D72DEEAB-5891-4783-AA18-716669035CC7','1ntdspdiy1h9','cts','cts','2017-10-11 15:37:54','cts'),('E3F8B10B-B59A-47B8-97FF-D3CBFC72EE9D','1io5brnzvvkqq','liuxb','liuxb','2016-10-03 20:16:4','jfgl'),('E4076F68-87F2-4D5D-9DC0-81E864698C00','1fppjqg3cvj4e','liuxb','liuxb','2016-10-03 19:56:39','jfgl'),('E8B10B65-EF32-4876-9C06-55284F1D6342','1wsdf69760jxx','liuxb','liuxb','2016-10-14 1:41:1','pdqc'),('F8D2F58A-E495-4B64-8E88-4D73EBB6E52E','79pi92ybvaqh','liuxb','liuxb','2017-10-11 11:22:12','pdqc');

/*Table structure for table `t_login_user` */

DROP TABLE IF EXISTS `t_login_user`;

CREATE TABLE `t_login_user` (
  `id` varchar(100) NOT NULL COMMENT '编号',
  `user` varchar(100) DEFAULT NULL COMMENT '账号',
  `pwd` varchar(100) DEFAULT NULL COMMENT '密码',
  `power` varchar(10) DEFAULT NULL COMMENT '权限',
  `templateType` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息';

/*Data for the table `t_login_user` */

insert  into `t_login_user`(`id`,`user`,`pwd`,`power`,`templateType`) values ('1','1','1','jfgl','1'),('cailg','cailg','cailg','jfgl','1'),('chengwc','chengwc','chengwc','jfgl','1'),('cts','cts','cts','cts','5'),('huanghr','huanghr','huanghr','jfgl','1'),('huangzy','huangzy','huangzy','jfgl','1'),('liuxb','liuxb','liuxb','pdqc','2'),('liy','liy','liy','jfgl','1'),('mdm','mdm','mdm','mdm','3'),('panbc','panbc','panbc','jfgl','1'),('shusm','shusm','shusm','jfgl','1'),('wangjf','wangjf','wangjf','jfgl','1'),('wuw','wuw','wuw','jfgl','1'),('yeqf','yeqf','yeqf','jfgl','1'),('zhangbl','zhangbl','zhangbl','jfgl','1'),('zhangjf','zhangjf','zhangjf','jfgl','1'),('zhangmc','zhangmc','zhangmc','jfgl','1'),('zhangsd','zhangsd','zhangsd','jfgl','1'),('zhangtn','zhangtn','zhangtn','jfgl','1');

/*Table structure for table `t_member_clothingsize` */

DROP TABLE IF EXISTS `t_member_clothingsize`;

CREATE TABLE `t_member_clothingsize` (
  `id` varchar(100) NOT NULL COMMENT '编号',
  `name` varchar(100) DEFAULT NULL COMMENT '姓名',
  `depart` varchar(100) DEFAULT NULL COMMENT '部门',
  `height` varchar(100) DEFAULT NULL COMMENT '身高',
  `weight` varchar(100) DEFAULT NULL COMMENT '体重',
  `clothingSize` varchar(100) DEFAULT NULL COMMENT '尺码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='服装尺码';

/*Data for the table `t_member_clothingsize` */

/*Table structure for table `t_member_partake` */

DROP TABLE IF EXISTS `t_member_partake`;

CREATE TABLE `t_member_partake` (
  `id` varchar(100) NOT NULL COMMENT '参与编号',
  `GroupActId` varchar(100) DEFAULT NULL COMMENT '活动编号',
  `GroupMemberId` varchar(100) DEFAULT NULL COMMENT '成员编号',
  `partaketime` varchar(100) DEFAULT NULL COMMENT '参与时间',
  `spending` varchar(100) DEFAULT NULL COMMENT '摊分开支',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='成员参与';

/*Data for the table `t_member_partake` */

/*Table structure for table `t_member_vote` */

DROP TABLE IF EXISTS `t_member_vote`;

CREATE TABLE `t_member_vote` (
  `id` varchar(100) NOT NULL COMMENT '投票编号',
  `GroupActId` varchar(100) DEFAULT NULL COMMENT '活动编号',
  `GroupMemberId` varchar(100) DEFAULT NULL COMMENT '成员编号',
  `votetime` varchar(100) DEFAULT NULL COMMENT '投票时间',
  `votestate` varchar(100) DEFAULT NULL COMMENT '投票状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='成员投票';

/*Data for the table `t_member_vote` */

/*Table structure for table `t_rule` */

DROP TABLE IF EXISTS `t_rule`;

CREATE TABLE `t_rule` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `RULE_NAME` varchar(200) DEFAULT NULL COMMENT '规则',
  `RULESET_ID` varchar(50) DEFAULT NULL COMMENT '规则集',
  `IS_USED` varchar(1) DEFAULT NULL COMMENT '是否有效',
  `PRI_LEVEL` varchar(1) DEFAULT NULL COMMENT '优先级',
  `CONTENT_TYPE` varchar(50) DEFAULT NULL COMMENT '内容类别',
  `EFFECT_DATE` varchar(20) DEFAULT NULL COMMENT '生效日期',
  `INVALID_DATE` varchar(20) DEFAULT NULL COMMENT '失效日期',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_DATE` varchar(20) DEFAULT NULL COMMENT '创建日期',
  `MODIFY_DATE` varchar(20) DEFAULT NULL COMMENT '修改日期',
  `MODIFYED` varchar(50) DEFAULT NULL COMMENT '修改人',
  `OWNER` varchar(50) DEFAULT NULL COMMENT '所有人',
  `LOCKED` varchar(50) DEFAULT NULL COMMENT '锁定人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='规则';

/*Data for the table `t_rule` */

insert  into `t_rule`(`ID`,`RULE_NAME`,`RULESET_ID`,`IS_USED`,`PRI_LEVEL`,`CONTENT_TYPE`,`EFFECT_DATE`,`INVALID_DATE`,`CREATOR`,`CREATE_DATE`,`MODIFY_DATE`,`MODIFYED`,`OWNER`,`LOCKED`) values ('8F1D7ACC-4407-4513-B379-3161FFA6DA49','1','5A65A13F-597E-4EFC-8993-1C1580B49F14','0','1','101','2016-08-10 19:44:31','2016-08-10 19:44:32','1','2016-08-10 19:44:32','2016-08-10 19:44:32','1','1','');

/*Table structure for table `t_rule_table` */

DROP TABLE IF EXISTS `t_rule_table`;

CREATE TABLE `t_rule_table` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `RULE_TABLE_NAME` varchar(200) DEFAULT NULL COMMENT '决策表',
  `VERSION` varchar(50) DEFAULT NULL COMMENT '版本',
  `STATUS` varchar(50) DEFAULT NULL COMMENT '状态',
  `MODIFY_DATE` varchar(20) DEFAULT NULL COMMENT '修改日期',
  `MODIFYED` varchar(50) DEFAULT NULL COMMENT '修改人',
  `OWNER` varchar(50) DEFAULT NULL COMMENT '所有人',
  `LOCKED` varchar(50) DEFAULT NULL COMMENT '锁定人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='决策表';

/*Data for the table `t_rule_table` */

insert  into `t_rule_table`(`ID`,`RULE_TABLE_NAME`,`VERSION`,`STATUS`,`MODIFY_DATE`,`MODIFYED`,`OWNER`,`LOCKED`) values ('3FB9257C-FBD0-4882-937F-66789374C784','1','1','101','2016-08-10 19:43:06','1','','');

/*Table structure for table `t_rule_table_input` */

DROP TABLE IF EXISTS `t_rule_table_input`;

CREATE TABLE `t_rule_table_input` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `RULE_TABLE_ID` varchar(200) DEFAULT NULL COMMENT '决策表',
  `OUTPUT_LOCATION` varchar(50) DEFAULT NULL COMMENT '输出定位',
  `INPUT_VAR` varchar(50) DEFAULT NULL COMMENT '输入变量',
  `INPUT_VALUE` varchar(50) DEFAULT NULL COMMENT '输入值',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='决策表输入';

/*Data for the table `t_rule_table_input` */

insert  into `t_rule_table_input`(`ID`,`RULE_TABLE_ID`,`OUTPUT_LOCATION`,`INPUT_VAR`,`INPUT_VALUE`) values ('C436C500-1C9C-428C-9667-8B40C7C2A67D','3FB9257C-FBD0-4882-937F-66789374C784','1','1','1');

/*Table structure for table `t_rule_table_output` */

DROP TABLE IF EXISTS `t_rule_table_output`;

CREATE TABLE `t_rule_table_output` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `RULE_TABLE_ID` varchar(200) DEFAULT NULL COMMENT '决策表',
  `OUTPUT_LOCATION` varchar(50) DEFAULT NULL COMMENT '输出定位',
  `OUTPUT_VAR` varchar(20) DEFAULT NULL COMMENT '输出变量',
  `OUTPUT_VALUE` varchar(50) DEFAULT NULL COMMENT '输出值',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='决策表输出';

/*Data for the table `t_rule_table_output` */

insert  into `t_rule_table_output`(`ID`,`RULE_TABLE_ID`,`OUTPUT_LOCATION`,`OUTPUT_VAR`,`OUTPUT_VALUE`) values ('E4F5A276-AE46-4533-A101-DD91D318E428','3FB9257C-FBD0-4882-937F-66789374C784','1','1','1');

/*Table structure for table `t_rule_tree` */

DROP TABLE IF EXISTS `t_rule_tree`;

CREATE TABLE `t_rule_tree` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `RULE_TREE_NAME` varchar(200) DEFAULT NULL COMMENT '决策树',
  `VERSION` varchar(50) DEFAULT NULL COMMENT '版本',
  `STATUS` varchar(50) DEFAULT NULL COMMENT '状态',
  `OUTPUT_WAY` varchar(1) DEFAULT NULL COMMENT '输出方式',
  `MODIFY_DATE` varchar(20) DEFAULT NULL COMMENT '修改日期',
  `MODIFYED` varchar(50) DEFAULT NULL COMMENT '修改人',
  `OWNER` varchar(50) DEFAULT NULL COMMENT '所有人',
  `LOCKED` varchar(50) DEFAULT NULL COMMENT '锁定人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='决策树';

/*Data for the table `t_rule_tree` */

insert  into `t_rule_tree`(`ID`,`RULE_TREE_NAME`,`VERSION`,`STATUS`,`OUTPUT_WAY`,`MODIFY_DATE`,`MODIFYED`,`OWNER`,`LOCKED`) values ('1F840FC1-4F78-4AF9-9209-5902862C0EFF','1','1','101','','2016-08-10 19:42:43','1','1','1');

/*Table structure for table `t_rule_tree_output` */

DROP TABLE IF EXISTS `t_rule_tree_output`;

CREATE TABLE `t_rule_tree_output` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `RULE_TREE_ID` varchar(50) DEFAULT NULL COMMENT '决策树',
  `TREE_NODE_CODE` varchar(50) DEFAULT NULL COMMENT '节点代码',
  `TREE_NODE_NAME` varchar(200) DEFAULT NULL COMMENT '节点名称',
  `OUTPUT_VER` varchar(50) DEFAULT NULL COMMENT '输出变量',
  `OUTPUT_VALUE` varchar(50) DEFAULT NULL COMMENT '输出值',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='决策树输出';

/*Data for the table `t_rule_tree_output` */

/*Table structure for table `t_ruleset` */

DROP TABLE IF EXISTS `t_ruleset`;

CREATE TABLE `t_ruleset` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `RULESET_NAME` varchar(200) DEFAULT NULL COMMENT '规则集',
  `VERSION` varchar(50) DEFAULT NULL COMMENT '版本',
  `STATUS` varchar(50) DEFAULT NULL COMMENT '状态',
  `MODIFY_DATE` varchar(20) DEFAULT NULL COMMENT '修改日期',
  `MODIFYED` varchar(50) DEFAULT NULL COMMENT '修改人',
  `OWNER` varchar(50) DEFAULT NULL COMMENT '所有人',
  `LOCKED` varchar(50) DEFAULT NULL COMMENT '锁定人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='规则集';

/*Data for the table `t_ruleset` */

insert  into `t_ruleset`(`ID`,`RULESET_NAME`,`VERSION`,`STATUS`,`MODIFY_DATE`,`MODIFYED`,`OWNER`,`LOCKED`) values ('5A65A13F-597E-4EFC-8993-1C1580B49F14','1','1','101','2016-08-10 19:44:22','1','1','1');

/*Table structure for table `t_sccst_band_code` */

DROP TABLE IF EXISTS `t_sccst_band_code`;

CREATE TABLE `t_sccst_band_code` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `PRESENT_BAND` varchar(50) DEFAULT NULL COMMENT '礼品品牌',
  `PRESENT_CODE` varchar(50) DEFAULT NULL COMMENT '礼品编码',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(50) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(50) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='帐号品牌关联礼品编码设置';

/*Data for the table `t_sccst_band_code` */

/*Table structure for table `t_sccst_exchange_introduce` */

DROP TABLE IF EXISTS `t_sccst_exchange_introduce`;

CREATE TABLE `t_sccst_exchange_introduce` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `TYPE_NAME` varchar(50) DEFAULT NULL COMMENT '类别名称',
  `TYPE_ORDER` varchar(200) DEFAULT NULL COMMENT '详细内容',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(50) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(50) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='积分兑换介绍';

/*Data for the table `t_sccst_exchange_introduce` */

/*Table structure for table `t_sccst_exchange_time` */

DROP TABLE IF EXISTS `t_sccst_exchange_time`;

CREATE TABLE `t_sccst_exchange_time` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `BEGIN_TIME` varchar(50) DEFAULT NULL COMMENT '开始时间',
  `END_TIME` varchar(50) DEFAULT NULL COMMENT '结束时间',
  `IS_USED` varchar(10) DEFAULT NULL COMMENT '启用状态',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(50) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(50) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='经销商兑换集团礼品时间设置';

/*Data for the table `t_sccst_exchange_time` */

insert  into `t_sccst_exchange_time`(`ID`,`BEGIN_TIME`,`END_TIME`,`IS_USED`,`CREATOR`,`CREATE_OFFICE`,`CREATE_TIME`,`LAST_MODIFYOR`,`LAST_MODIFY_OFFICE`,`LAST_MODIFY_TIME`,`RECORD_VERSION`) values ('FC88E5E8-B2CD-4C6D-AE93-09758781D496','1','1','1','','','','','','','0');

/*Table structure for table `t_sccst_first_page` */

DROP TABLE IF EXISTS `t_sccst_first_page`;

CREATE TABLE `t_sccst_first_page` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `PRESENT_NO` varchar(50) DEFAULT NULL COMMENT '礼品编码',
  `PRESENT_NAME` varchar(200) DEFAULT NULL COMMENT '礼品名称',
  `IS_FIRST_PAGE` varchar(10) DEFAULT NULL COMMENT '是否显示在首页',
  `UPLOAD_TIME` varchar(50) DEFAULT NULL COMMENT '上传时间',
  `PIC_NAME` varchar(1000) DEFAULT NULL COMMENT '图片名称',
  `SHOW_ORDER` varchar(50) DEFAULT NULL COMMENT '轮播顺序',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(50) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(50) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='首页信息维护';

/*Data for the table `t_sccst_first_page` */

/*Table structure for table `t_sccst_group_code` */

DROP TABLE IF EXISTS `t_sccst_group_code`;

CREATE TABLE `t_sccst_group_code` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `GROUP_NO` varchar(50) DEFAULT NULL COMMENT '正新组别',
  `PRESENT_CODE` varchar(50) DEFAULT NULL COMMENT '礼品编码',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(50) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(50) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='正新组别关联礼品编码设置';

/*Data for the table `t_sccst_group_code` */

/*Table structure for table `t_sccst_order` */

DROP TABLE IF EXISTS `t_sccst_order`;

CREATE TABLE `t_sccst_order` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `ORDER_NO` varchar(200) DEFAULT NULL COMMENT '订单编号',
  `COMPANY_CODE` varchar(50) DEFAULT NULL COMMENT '公司别',
  `CUSTOM_NO` varchar(50) DEFAULT NULL COMMENT '客户代号',
  `REQUIRED_ALL_INTEGRAL` decimal(10,0) DEFAULT '0' COMMENT '所需总积分',
  `ORDER_TIME` varchar(50) DEFAULT NULL COMMENT '下单时间',
  `VND_NAME` varchar(50) DEFAULT NULL COMMENT '经销商名称',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(50) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(50) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='我的订单';

/*Data for the table `t_sccst_order` */

/*Table structure for table `t_sccst_order_detail` */

DROP TABLE IF EXISTS `t_sccst_order_detail`;

CREATE TABLE `t_sccst_order_detail` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `ORDER_NO` varchar(200) DEFAULT NULL COMMENT '订单编号',
  `REQUIRED_ALL_INTEGRAL` decimal(10,0) DEFAULT '0' COMMENT '所需总积分',
  `ORDER_TIME` varchar(50) DEFAULT NULL COMMENT '订单时间',
  `PRESENT_PIC` varchar(50) DEFAULT NULL COMMENT '礼品图片',
  `PRESENT_BRAND` varchar(50) DEFAULT NULL COMMENT '礼品品牌',
  `MATERIAL_NUMBER` varchar(50) DEFAULT NULL COMMENT '礼品料号',
  `PRESENT_NAME` varchar(50) DEFAULT NULL COMMENT '礼品名称',
  `PRESENT_UNIT` varchar(50) DEFAULT NULL COMMENT '单位',
  `PRESENT_QTY` decimal(10,0) DEFAULT '0' COMMENT '礼品数量',
  `REQUIRED_INTEGRAL` decimal(10,0) DEFAULT '0' COMMENT '所需积分',
  `PRESENT_STATUS` varchar(20) DEFAULT NULL COMMENT '礼品状态',
  `REMARK` varchar(50) DEFAULT NULL COMMENT '备注',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(50) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(50) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单明细';

/*Data for the table `t_sccst_order_detail` */

insert  into `t_sccst_order_detail`(`ID`,`ORDER_NO`,`REQUIRED_ALL_INTEGRAL`,`ORDER_TIME`,`PRESENT_PIC`,`PRESENT_BRAND`,`MATERIAL_NUMBER`,`PRESENT_NAME`,`PRESENT_UNIT`,`PRESENT_QTY`,`REQUIRED_INTEGRAL`,`PRESENT_STATUS`,`REMARK`,`CREATOR`,`CREATE_OFFICE`,`CREATE_TIME`,`LAST_MODIFYOR`,`LAST_MODIFY_OFFICE`,`LAST_MODIFY_TIME`,`RECORD_VERSION`) values ('3A282766-4133-45CD-BF27-B75461C4D99A','1','1','','','','1','','','1','1','','','','','','','','','0');

/*Table structure for table `t_sccst_present_car` */

DROP TABLE IF EXISTS `t_sccst_present_car`;

CREATE TABLE `t_sccst_present_car` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `PRESENT_PIC` varchar(200) DEFAULT NULL COMMENT '礼品图片',
  `PRESENT_NO` varchar(50) DEFAULT NULL COMMENT '礼品编号',
  `PRESENT_NAME` varchar(50) DEFAULT NULL COMMENT '礼品名称',
  `REQUIRED_INTEGRAL` decimal(10,0) DEFAULT '0' COMMENT '所需积分',
  `PRESENT_TYPE` varchar(50) DEFAULT NULL COMMENT '礼品类别',
  `FACTORY_CODE` varchar(50) DEFAULT NULL COMMENT '厂别',
  `PRODUCT_NO` varchar(50) DEFAULT NULL COMMENT '型号',
  `PRESENT_COLOR` varchar(50) DEFAULT NULL COMMENT '颜色',
  `PRESENT_UNIT` varchar(50) DEFAULT NULL COMMENT '单位',
  `CONVERTIBLE_QTY` decimal(10,0) DEFAULT '0' COMMENT '兑换数量',
  `PRESENT_TOTAL` decimal(10,0) DEFAULT '0' COMMENT '小计积分',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(50) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(50) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='礼品车';

/*Data for the table `t_sccst_present_car` */

insert  into `t_sccst_present_car`(`ID`,`PRESENT_PIC`,`PRESENT_NO`,`PRESENT_NAME`,`REQUIRED_INTEGRAL`,`PRESENT_TYPE`,`FACTORY_CODE`,`PRODUCT_NO`,`PRESENT_COLOR`,`PRESENT_UNIT`,`CONVERTIBLE_QTY`,`PRESENT_TOTAL`,`CREATOR`,`CREATE_OFFICE`,`CREATE_TIME`,`LAST_MODIFYOR`,`LAST_MODIFY_OFFICE`,`LAST_MODIFY_TIME`,`RECORD_VERSION`) values ('09FD4426-CEFF-423D-AAA7-A50CCAE18DBF','1','1','','1','','','','','','1','1',NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `t_sccst_present_exchange` */

DROP TABLE IF EXISTS `t_sccst_present_exchange`;

CREATE TABLE `t_sccst_present_exchange` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `PRESENT_TYPE_ID` varchar(50) DEFAULT NULL COMMENT '礼品类别',
  `PRESENT_PIC` varchar(200) DEFAULT NULL COMMENT '礼品图片',
  `PRESENT_NO` varchar(50) DEFAULT NULL COMMENT '礼品编号',
  `PRESENT_NAME` varchar(20) DEFAULT NULL COMMENT '礼品名称',
  `PRESENT_BRAND` varchar(20) DEFAULT NULL COMMENT '品牌',
  `PRESENT_MOQ` decimal(10,0) DEFAULT '0' COMMENT '起订量',
  `CONVERTIBLE_QTY` decimal(10,0) DEFAULT '0' COMMENT '已兑换数量',
  `REQUIRED_INTEGRAL` decimal(10,0) DEFAULT '0' COMMENT '所需积分',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(50) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='礼品兑换';

/*Data for the table `t_sccst_present_exchange` */

insert  into `t_sccst_present_exchange`(`ID`,`PRESENT_TYPE_ID`,`PRESENT_PIC`,`PRESENT_NO`,`PRESENT_NAME`,`PRESENT_BRAND`,`PRESENT_MOQ`,`CONVERTIBLE_QTY`,`REQUIRED_INTEGRAL`,`CREATOR`,`CREATE_OFFICE`,`CREATE_TIME`,`LAST_MODIFYOR`,`LAST_MODIFY_OFFICE`,`LAST_MODIFY_TIME`,`RECORD_VERSION`) values ('F09A4A26-1944-4466-A128-1BBE713E2AD6','1','1','1','1','1','1','1','1',NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `t_sccst_present_info` */

DROP TABLE IF EXISTS `t_sccst_present_info`;

CREATE TABLE `t_sccst_present_info` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `PRESENT_TYPE_ID` varchar(20) DEFAULT NULL COMMENT '礼品类别',
  `PRESENT_NO` varchar(50) DEFAULT NULL COMMENT '礼品编号',
  `PRESENT_NAME` varchar(20) DEFAULT NULL COMMENT '礼品名称',
  `UNIT` varchar(20) DEFAULT NULL COMMENT '单位',
  `PACKAGE_QTY` decimal(10,0) DEFAULT '0' COMMENT '包装数量',
  `QUARTER_EXCHANGE_QTY` decimal(10,0) DEFAULT '0' COMMENT '本季累计兑换数量',
  `EXCHANGE_QTY` decimal(10,0) DEFAULT '0' COMMENT '总兑换数量',
  `IS_DOWN` varchar(10) DEFAULT NULL COMMENT '是否下架',
  `IS_SHARING` varchar(10) DEFAULT NULL COMMENT '是否共用',
  `MOQ` decimal(10,0) DEFAULT '0' COMMENT '最低起订量',
  `REQUIRED_INTEGRAL` decimal(10,0) DEFAULT '0' COMMENT '所需积分',
  `PRESENT_PIC` varchar(1000) DEFAULT NULL COMMENT '礼品图片',
  `PRODUCT_NO` varchar(50) DEFAULT NULL COMMENT '型号',
  `COLOR_TYPE` varchar(50) DEFAULT NULL COMMENT '颜色分类',
  `MATERIAL_NUMBER` varchar(50) DEFAULT NULL COMMENT '料号',
  `STANDARD` varchar(50) DEFAULT NULL COMMENT '规格',
  `REMARK` varchar(4000) DEFAULT NULL COMMENT '礼品描述',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(50) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(50) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='礼品信息';

/*Data for the table `t_sccst_present_info` */

/*Table structure for table `t_sccst_present_type` */

DROP TABLE IF EXISTS `t_sccst_present_type`;

CREATE TABLE `t_sccst_present_type` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `TYPE_NAME` varchar(50) DEFAULT NULL COMMENT '礼品类别',
  `TYPE_ORDER` varchar(200) DEFAULT NULL COMMENT '排列顺序',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(50) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(50) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='礼品类别';

/*Data for the table `t_sccst_present_type` */

insert  into `t_sccst_present_type`(`ID`,`TYPE_NAME`,`TYPE_ORDER`,`CREATOR`,`CREATE_OFFICE`,`CREATE_TIME`,`LAST_MODIFYOR`,`LAST_MODIFY_OFFICE`,`LAST_MODIFY_TIME`,`RECORD_VERSION`) values ('D9A08674-9EC3-4A97-BD4B-8DB186A59DB4','1','1','','','','','','','0');

/*Table structure for table `t_scpcr_attach_info` */

DROP TABLE IF EXISTS `t_scpcr_attach_info`;

CREATE TABLE `t_scpcr_attach_info` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `ATTACHMENT_TYPE` varchar(50) DEFAULT NULL COMMENT '附件类型',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='附件信息表';

/*Data for the table `t_scpcr_attach_info` */

/*Table structure for table `t_scpcr_attach_info_detail` */

DROP TABLE IF EXISTS `t_scpcr_attach_info_detail`;

CREATE TABLE `t_scpcr_attach_info_detail` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `ATTACHMENT_ID` varchar(50) DEFAULT NULL COMMENT '附件ID',
  `ATTACHMENT_NAME` varchar(50) DEFAULT NULL COMMENT '附件名称',
  `ATTACHMENT_PATH` varchar(50) DEFAULT NULL COMMENT '附件路径',
  `TEMP_DIR` varchar(1000) DEFAULT NULL COMMENT '临时目录',
  `UPLOAD_DATE` varchar(20) DEFAULT NULL COMMENT '上传时间',
  `FILE_SIZE` varchar(50) DEFAULT NULL COMMENT '文件大小',
  `FILE_EXT` varchar(50) DEFAULT NULL COMMENT '文件后缀',
  `FILE_DES` varchar(50) DEFAULT NULL COMMENT '文件说明',
  `IS_DEFAULT` varchar(1) DEFAULT NULL COMMENT '默认',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='附件明细表';

/*Data for the table `t_scpcr_attach_info_detail` */

/*Table structure for table `t_scpcr_award_punish` */

DROP TABLE IF EXISTS `t_scpcr_award_punish`;

CREATE TABLE `t_scpcr_award_punish` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `SHOP_ID` varchar(50) DEFAULT NULL COMMENT '店铺ID',
  `AWARD_PUNISH_TYPE` varchar(20) DEFAULT NULL COMMENT '奖惩类型',
  `AWARD_PUNISH_INTEGRAL` decimal(10,0) DEFAULT '0' COMMENT '奖惩积分',
  `AWARD_PUNISH_REASON` varchar(50) DEFAULT NULL COMMENT '奖励原因',
  `ATTACHMENT_ID` varchar(50) DEFAULT NULL COMMENT '附件ID',
  `AWARD_PUNISH_STATUS` varchar(20) DEFAULT NULL COMMENT '奖惩记录状态',
  `APPLY_MAN` varchar(20) DEFAULT NULL COMMENT '申请人',
  `APPLY_DATE` varchar(20) DEFAULT NULL COMMENT '申请日期',
  `AUDIT_MAN` varchar(20) DEFAULT NULL COMMENT '审核人',
  `AUDIT_DATE` varchar(20) DEFAULT NULL COMMENT '审核日期',
  `AUDIT_OPINION` varchar(200) DEFAULT NULL COMMENT '审核意见',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='积分奖罚';

/*Data for the table `t_scpcr_award_punish` */

/*Table structure for table `t_scpcr_best_shop` */

DROP TABLE IF EXISTS `t_scpcr_best_shop`;

CREATE TABLE `t_scpcr_best_shop` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `IS_PUBLISH` varchar(1) DEFAULT NULL COMMENT '是否发布',
  `BEST_MONTH` varchar(20) DEFAULT NULL COMMENT '评优月份',
  `SHOP_ID` varchar(50) DEFAULT NULL COMMENT '店铺ID',
  `SHOP_DES` varchar(200) DEFAULT NULL COMMENT '店铺概述',
  `ATTACHMENT_ID` varchar(200) DEFAULT NULL COMMENT '附件ID',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='优秀店家';

/*Data for the table `t_scpcr_best_shop` */

/*Table structure for table `t_scpcr_best_shop_dtl` */

DROP TABLE IF EXISTS `t_scpcr_best_shop_dtl`;

CREATE TABLE `t_scpcr_best_shop_dtl` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `BEST_STORE_ID` varchar(50) DEFAULT NULL COMMENT '优秀店家ID',
  `SHOP_TYPE` varchar(50) DEFAULT NULL COMMENT '店家类型',
  `SHOP_UP_DESC` varchar(50) DEFAULT NULL COMMENT '店家上部描述',
  `SHOP_DOWN_DESC` varchar(50) DEFAULT NULL COMMENT '店家下部描述',
  `ATTACHMENT_ID` varchar(200) DEFAULT NULL COMMENT '附件ID',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='优秀店家明细表';

/*Data for the table `t_scpcr_best_shop_dtl` */

/*Table structure for table `t_scpcr_check_code` */

DROP TABLE IF EXISTS `t_scpcr_check_code`;

CREATE TABLE `t_scpcr_check_code` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `USER_ID` varchar(50) DEFAULT NULL COMMENT '用户ID',
  `CHECK_TYPE` varchar(20) DEFAULT NULL COMMENT '验证类型',
  `CHECK_CODE` varchar(50) DEFAULT NULL COMMENT '验证码',
  `CHECK_TIME` varchar(20) DEFAULT NULL COMMENT '验证时间',
  `IS_USED` varchar(1) DEFAULT NULL COMMENT '是否有效',
  `FAILURE_TIME` varchar(20) DEFAULT NULL COMMENT '失效时间',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='验证码表';

/*Data for the table `t_scpcr_check_code` */

/*Table structure for table `t_scpcr_convertible_rule` */

DROP TABLE IF EXISTS `t_scpcr_convertible_rule`;

CREATE TABLE `t_scpcr_convertible_rule` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `TYPE` varchar(1) DEFAULT NULL COMMENT '类型',
  `SIGING_STANDARD_ID` varchar(50) DEFAULT NULL COMMENT '签约标准ID',
  `WARE_ID` varchar(50) DEFAULT NULL COMMENT '产品种类ID',
  `CONVERTIBLE` decimal(10,0) DEFAULT '0' COMMENT 'PUMP币',
  `SALE_DISCOUNT` decimal(10,0) DEFAULT '0' COMMENT '销售折扣',
  `PURCHASES_PERCENT` decimal(10,0) DEFAULT '0' COMMENT '进货量比例',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='PCR积分规则';

/*Data for the table `t_scpcr_convertible_rule` */

/*Table structure for table `t_scpcr_credit_acnt` */

DROP TABLE IF EXISTS `t_scpcr_credit_acnt`;

CREATE TABLE `t_scpcr_credit_acnt` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `SHOP_ID` varchar(50) DEFAULT NULL COMMENT '店铺ID',
  `INTEGRAL_BALANCE` decimal(10,0) DEFAULT '0' COMMENT '积分余额',
  `INTEGRAL_USE_BALANCE` decimal(10,0) DEFAULT '0' COMMENT '积分可用余额',
  `DATA_TIME` varchar(20) DEFAULT NULL COMMENT '设立日期',
  `INTEGRAL_EXPIRE_DATE` varchar(20) DEFAULT NULL COMMENT '积分到期日',
  `PERIOD_UNZERIO_INTEGRAL` decimal(10,0) DEFAULT '0' COMMENT '本期不清零积分',
  `UNZERIO_MONTH` varchar(1) DEFAULT NULL COMMENT '不清零月数',
  `PRE_MONEY` decimal(10,0) DEFAULT '0' COMMENT '预占金额',
  `OVERDRAW_MONEY` decimal(10,0) DEFAULT '0' COMMENT '透支金额',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='积分账户';

/*Data for the table `t_scpcr_credit_acnt` */

/*Table structure for table `t_scpcr_credit_acnt_detail` */

DROP TABLE IF EXISTS `t_scpcr_credit_acnt_detail`;

CREATE TABLE `t_scpcr_credit_acnt_detail` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `INTEGRAL_ACCOUNT_ID` varchar(50) DEFAULT NULL COMMENT '积分账户ID',
  `INTEGRAL_OPT_TYPE` varchar(50) DEFAULT NULL COMMENT '积分操作类型',
  `INCREASE_OR_DECREASE` varchar(1) DEFAULT NULL COMMENT '增减标识',
  `CHANGE_MONEY` decimal(10,0) DEFAULT '0' COMMENT '变动金额',
  `CHANGE_INTEGRAL_BALANCE` decimal(10,0) DEFAULT '0' COMMENT '变动后积分余额',
  `CHANGE_INTEGRAL_USE_BALANCE` decimal(10,0) DEFAULT '0' COMMENT '变动后积分可用余额',
  `SALES_SETTLE_MONTH` decimal(10,0) DEFAULT '0' COMMENT '销量结算月',
  `OPT_TIME` varchar(20) DEFAULT NULL COMMENT '操作日期',
  `RELATION_TRADING_ID` varchar(50) DEFAULT NULL COMMENT '关联交易ID',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='积分账户明细';

/*Data for the table `t_scpcr_credit_acnt_detail` */

/*Table structure for table `t_scpcr_credit_clear` */

DROP TABLE IF EXISTS `t_scpcr_credit_clear`;

CREATE TABLE `t_scpcr_credit_clear` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `SHOP_ID` varchar(50) DEFAULT NULL COMMENT '店铺ID',
  `ZERO_STATUS` varchar(20) DEFAULT NULL COMMENT '清零状态',
  `ZERO_INTEGRAL` decimal(10,0) DEFAULT '0' COMMENT '清零积分',
  `INTEGRAL_EXPIRE_DATE` varchar(20) DEFAULT NULL COMMENT '积分到期日',
  `ZERO_DATE` varchar(20) DEFAULT NULL COMMENT '清零日期',
  `ZERO_MAN` varchar(20) DEFAULT NULL COMMENT '清零人',
  `RETURN_INTEGRAL` decimal(10,0) DEFAULT '0' COMMENT '返还积分',
  `RETURN_APPLY_MAN` varchar(50) DEFAULT NULL COMMENT '返还申请人',
  `RETURN_APPLY_REASON` varchar(500) DEFAULT NULL COMMENT '返还申请原因',
  `RETURN_APPLY_DATE` varchar(50) DEFAULT NULL COMMENT '返还申请日期',
  `RETURN_APPLY_AUDIT_MAN` varchar(20) DEFAULT NULL COMMENT '返还审核人',
  `AUDIT_OPINION` varchar(500) DEFAULT NULL COMMENT '审核意见',
  `AUDIT_RETURN_TIME` varchar(50) DEFAULT NULL COMMENT '审核日期',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='积分清零及返还';

/*Data for the table `t_scpcr_credit_clear` */

/*Table structure for table `t_scpcr_credit_overdraft` */

DROP TABLE IF EXISTS `t_scpcr_credit_overdraft`;

CREATE TABLE `t_scpcr_credit_overdraft` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `SHOP_ID` varchar(50) DEFAULT NULL COMMENT '店铺ID',
  `OVERDRAFT_CONVERTIBLE` decimal(10,0) DEFAULT '0' COMMENT '透支积分',
  `OVERDRAFT_REASON` varchar(500) DEFAULT NULL COMMENT '透支原因',
  `OVERDRAFT_APPLY_DATE` varchar(20) DEFAULT NULL COMMENT '透支申请日期',
  `OVERDRAFT_APPLY_MAN` varchar(20) DEFAULT NULL COMMENT '透支申请人',
  `ATTACHMENT_ID` varchar(200) DEFAULT NULL COMMENT '附件ID',
  `OVERDRAFT_APPLY_STATUS` varchar(20) DEFAULT NULL COMMENT '透支申请状态',
  `AUDIT_MAN` varchar(20) DEFAULT NULL COMMENT '审核人',
  `AUDIT_TIME` varchar(20) DEFAULT NULL COMMENT '审核日期',
  `AUDIT_OPINION` varchar(500) DEFAULT NULL COMMENT '审核意见',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='积分提前消费';

/*Data for the table `t_scpcr_credit_overdraft` */

/*Table structure for table `t_scpcr_exchange_date` */

DROP TABLE IF EXISTS `t_scpcr_exchange_date`;

CREATE TABLE `t_scpcr_exchange_date` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `BEGIN_DATE` varchar(20) DEFAULT NULL COMMENT '开始日期',
  `END_DATE` varchar(20) DEFAULT NULL COMMENT '截止日期',
  `IS_USED` varchar(1) DEFAULT NULL COMMENT '是否启用',
  `EXCHANGE_TYPE` varchar(50) DEFAULT NULL COMMENT '兑换类型',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='兑换时间设置（含清零兑换）';

/*Data for the table `t_scpcr_exchange_date` */

/*Table structure for table `t_scpcr_guide_content` */

DROP TABLE IF EXISTS `t_scpcr_guide_content`;

CREATE TABLE `t_scpcr_guide_content` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `TOPIC_ID` varchar(50) DEFAULT NULL COMMENT '主题ID',
  `GUIDE_CONTENT` varchar(50) DEFAULT NULL COMMENT '指引内容',
  `PUBLISH_TIME` varchar(50) DEFAULT NULL COMMENT '发布日期',
  `PUBLISH_MAN` varchar(50) DEFAULT NULL COMMENT '发布人ID',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='积分项目指引内容';

/*Data for the table `t_scpcr_guide_content` */

/*Table structure for table `t_scpcr_inner_msg` */

DROP TABLE IF EXISTS `t_scpcr_inner_msg`;

CREATE TABLE `t_scpcr_inner_msg` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `INFORMATION_TYPE` varchar(50) DEFAULT NULL COMMENT '咨讯类型',
  `TOPIC` varchar(50) DEFAULT NULL COMMENT '主题',
  `CONTENT` varchar(50) DEFAULT NULL COMMENT '内容',
  `ATTACHMENT_ID` varchar(50) DEFAULT NULL COMMENT '附件id',
  `INFORMATION_STATUS` varchar(50) DEFAULT NULL COMMENT '咨讯状态',
  `SEND_TIME` varchar(20) DEFAULT NULL COMMENT '发送时间',
  `IS_PUBLISH` varchar(1) DEFAULT NULL COMMENT '是否发布',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='咨讯';

/*Data for the table `t_scpcr_inner_msg` */

/*Table structure for table `t_scpcr_mail_msg` */

DROP TABLE IF EXISTS `t_scpcr_mail_msg`;

CREATE TABLE `t_scpcr_mail_msg` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `MAIL_TOPIC` varchar(200) DEFAULT NULL COMMENT '邮件主题',
  `MAIL_CONTENT` varchar(4000) DEFAULT NULL COMMENT '邮件内容',
  `RECEIVER_MAIL` varchar(50) DEFAULT NULL COMMENT '收件人邮箱',
  `SENDER_MAIL` varchar(50) DEFAULT NULL COMMENT '发件人邮箱',
  `RECEIVER` varchar(50) DEFAULT NULL COMMENT '收件人',
  `RECEIVER_TYPE` varchar(20) DEFAULT NULL COMMENT '收件人类型',
  `SEND_TIME` varchar(14) DEFAULT NULL COMMENT '发送时间',
  `SEND_STATUS` varchar(3) DEFAULT NULL COMMENT '发送状态',
  `BUSSINESS_TYPE` varchar(3) DEFAULT NULL COMMENT '业务类型',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='邮件消息';

/*Data for the table `t_scpcr_mail_msg` */

/*Table structure for table `t_scpcr_msg_user` */

DROP TABLE IF EXISTS `t_scpcr_msg_user`;

CREATE TABLE `t_scpcr_msg_user` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `MSG_SEND_ID` varchar(50) DEFAULT NULL COMMENT '咨讯发送ID',
  `MSG_ID` varchar(50) DEFAULT NULL COMMENT '咨讯ID',
  `RECEIVER_TYPE` varchar(10) DEFAULT NULL COMMENT '接收者类型',
  `RECEIVER_ID` varchar(50) DEFAULT NULL COMMENT '接收者ID',
  `IS_VIEWED` varchar(1) DEFAULT NULL COMMENT '是否已查看',
  `VIEW_TIME` varchar(14) DEFAULT NULL COMMENT '查看时间',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='咨询接收者';

/*Data for the table `t_scpcr_msg_user` */

/*Table structure for table `t_scpcr_order_deliver` */

DROP TABLE IF EXISTS `t_scpcr_order_deliver`;

CREATE TABLE `t_scpcr_order_deliver` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `MERGE_ORDER_ID` varchar(50) DEFAULT NULL COMMENT '合并订单ID',
  `PROVIDER_CONTENT` varchar(200) DEFAULT NULL COMMENT '物流说明',
  `PROVIDER_NAME` varchar(50) DEFAULT NULL COMMENT '物流供应商名称',
  `PROVIDER_ID` varchar(50) DEFAULT NULL COMMENT '物流供应商ID',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单物流信息';

/*Data for the table `t_scpcr_order_deliver` */

/*Table structure for table `t_scpcr_present_order` */

DROP TABLE IF EXISTS `t_scpcr_present_order`;

CREATE TABLE `t_scpcr_present_order` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `SHOP_ID` varchar(50) DEFAULT NULL COMMENT '店铺ID',
  `ORDER_NO` varchar(50) DEFAULT NULL COMMENT '订单编号',
  `ALL_ORDER_COMMIT_CONV` decimal(10,0) DEFAULT '0' COMMENT '订单提交积分合计',
  `ALL_ACTUAL_EXCHANGE_CONV` decimal(10,0) DEFAULT '0' COMMENT '实际兑换积分合计',
  `ALL_RETURN_CONV` decimal(10,0) DEFAULT '0' COMMENT '返还积分合计',
  `ORDER_STATUS` varchar(50) DEFAULT NULL COMMENT '订单状态',
  `SHOP_ADDR_ID` varchar(50) DEFAULT NULL COMMENT '收货地址ID',
  `RECEIVE_MAN` varchar(50) DEFAULT NULL COMMENT '收货人',
  `RECEIVE_ADD` varchar(50) DEFAULT NULL COMMENT '收货地址',
  `RECEIVE_TEL` varchar(50) DEFAULT NULL COMMENT '收货电话',
  `COMMIT_MAN` varchar(50) DEFAULT NULL COMMENT '提交人',
  `COMMIT_TIME` varchar(20) DEFAULT NULL COMMENT '提交日期',
  `MODIFYOR` varchar(20) DEFAULT NULL COMMENT '修改人',
  `MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '修改日期',
  `REJECTED_MAN` varchar(20) DEFAULT NULL COMMENT '驳回人',
  `REJECTED_TIME` varchar(20) DEFAULT NULL COMMENT '驳回日期',
  `AUDIT_MAN` varchar(20) DEFAULT NULL COMMENT '审核人',
  `SETTLE_TIME` varchar(20) DEFAULT NULL COMMENT '结算日期',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='礼品订单（原始）';

/*Data for the table `t_scpcr_present_order` */

/*Table structure for table `t_scpcr_present_order_dtl` */

DROP TABLE IF EXISTS `t_scpcr_present_order_dtl`;

CREATE TABLE `t_scpcr_present_order_dtl` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `ORIGINAL_ORDER_ID` varchar(50) DEFAULT NULL COMMENT '原始订单ID',
  `PRESENT_ID` varchar(50) DEFAULT NULL COMMENT '礼品ID',
  `ORDER_COMMIT_QTY` decimal(10,0) DEFAULT '0' COMMENT '订单提交数量',
  `ACTUAL_CONVERTIBLE_QTY` decimal(10,0) DEFAULT '0' COMMENT '实际兑换数量',
  `ORDER_COMMIT_INTEGRAL` decimal(10,0) DEFAULT '0' COMMENT '订单提交积分',
  `ACTUAL_CONVERTIBLE_INTEGRAL` decimal(10,0) DEFAULT '0' COMMENT '实际兑换积分',
  `RETURN_INTEGRAL` decimal(10,0) DEFAULT '0' COMMENT '返还积分',
  `MERGE_ORDER_ID` varchar(50) DEFAULT NULL COMMENT '合并订单ID',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='礼品订单明细（原始）';

/*Data for the table `t_scpcr_present_order_dtl` */

/*Table structure for table `t_scpcr_present_store` */

DROP TABLE IF EXISTS `t_scpcr_present_store`;

CREATE TABLE `t_scpcr_present_store` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `PRESENT_CODE` varchar(50) DEFAULT NULL COMMENT '礼品编码',
  `PRESENT_VERSION` decimal(10,0) DEFAULT '0' COMMENT '礼品版本号',
  `PRESENT_NAME` varchar(200) DEFAULT NULL COMMENT '礼品名称',
  `PRESENT_TYPE` varchar(20) DEFAULT NULL COMMENT '礼品类型',
  `SUPPLIER` varchar(50) DEFAULT NULL COMMENT '供应商ID',
  `SUPPLIER_NAME` varchar(200) DEFAULT NULL COMMENT '供应商名称',
  `PRESENT_TYPE_ID` varchar(50) DEFAULT NULL COMMENT '礼品类别ID',
  `UNIT` varchar(10) DEFAULT NULL COMMENT '单位',
  `ALL_CONVERTIBLE_QTY` decimal(10,0) DEFAULT '0' COMMENT '累计兑换数量',
  `INVENTORY` decimal(10,0) DEFAULT '0' COMMENT '库存',
  `IS_SOLD_OUT` varchar(1) DEFAULT NULL COMMENT '是否下架',
  `UNIT_INTEGRAL_QTY` decimal(10,0) DEFAULT '0' COMMENT '单位兑换积分',
  `MATERIAL_NUMBER` varchar(50) DEFAULT NULL COMMENT '商品编码/料号',
  `PRODUCT_NO` varchar(50) DEFAULT NULL COMMENT '型号',
  `PRESENT_COLOR` varchar(50) DEFAULT NULL COMMENT '颜色',
  `ATTACHMENT_ID` varchar(200) DEFAULT NULL COMMENT '附件id',
  `PRESENT_DES` varchar(200) DEFAULT NULL COMMENT '礼品描述',
  `PURCHASE_PRICE` decimal(10,0) DEFAULT '0' COMMENT '进货价',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='礼品库存信息';

/*Data for the table `t_scpcr_present_store` */

/*Table structure for table `t_scpcr_present_type` */

DROP TABLE IF EXISTS `t_scpcr_present_type`;

CREATE TABLE `t_scpcr_present_type` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `PRESENT_TYPE_CODE` varchar(50) DEFAULT NULL COMMENT '礼品类别代码',
  `PRESENT_TYPE_NAME` varchar(200) DEFAULT NULL COMMENT '礼品类别名称',
  `PRESENT_TYPE_ADDR` varchar(200) DEFAULT NULL COMMENT '礼品类别链接地址',
  `INDEX_NO` decimal(10,0) DEFAULT '0' COMMENT '顺序号',
  `PRESENT_TYPE` varchar(20) DEFAULT NULL COMMENT '礼品类型',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='礼品类别';

/*Data for the table `t_scpcr_present_type` */

/*Table structure for table `t_scpcr_prom_cons_order` */

DROP TABLE IF EXISTS `t_scpcr_prom_cons_order`;

CREATE TABLE `t_scpcr_prom_cons_order` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `SHOP_ID` varchar(50) DEFAULT NULL COMMENT '店铺ID',
  `MERGE_ORDER_NO` varchar(50) DEFAULT NULL COMMENT '合并订单编号',
  `RECEIVE_MAN` varchar(50) DEFAULT NULL COMMENT '收货人',
  `RECEIVE_ADD` varchar(1000) DEFAULT NULL COMMENT '收货地址',
  `RECEIVE_TEL` varchar(50) DEFAULT NULL COMMENT '收货电话',
  `ORDER_STATUS` varchar(50) DEFAULT NULL COMMENT '订单状态',
  `LAST_UPDATE_TIME` varchar(20) DEFAULT NULL COMMENT '最后更新日期',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='促销品合并订单';

/*Data for the table `t_scpcr_prom_cons_order` */

/*Table structure for table `t_scpcr_prom_order_detail` */

DROP TABLE IF EXISTS `t_scpcr_prom_order_detail`;

CREATE TABLE `t_scpcr_prom_order_detail` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `ORIGINAL_ORDER_ID` varchar(50) DEFAULT NULL COMMENT '原始订单ID',
  `PROMOTION_ORDER_ID` varchar(50) DEFAULT NULL COMMENT '促销品ID',
  `ORDER_COMMIT_QTY` decimal(10,0) DEFAULT '0' COMMENT '订单提交数量',
  `ACTUAL_DEAL_QTY` decimal(10,0) DEFAULT '0' COMMENT '实际成交数量',
  `ORDER_COMMIT_MONEY` decimal(10,0) DEFAULT '0' COMMENT '订单提交金额',
  `ACTUAL_DEAL_MONEY` decimal(10,0) DEFAULT '0' COMMENT '实际成交金额',
  `MERGE_ORDER_ID` varchar(50) DEFAULT NULL COMMENT '合并订单ID',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='促销品订单明细';

/*Data for the table `t_scpcr_prom_order_detail` */

/*Table structure for table `t_scpcr_promotion` */

DROP TABLE IF EXISTS `t_scpcr_promotion`;

CREATE TABLE `t_scpcr_promotion` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `PROMOTION_NAME` varchar(200) DEFAULT NULL COMMENT '促销活动名称',
  `PROMOTION_CONTENT` varchar(4000) DEFAULT NULL COMMENT '促销活动内容说明',
  `PROMOTION_BEGIN_TIME` varchar(20) DEFAULT NULL COMMENT '促销开始日期',
  `PROMOTION_END_TIME` varchar(20) DEFAULT NULL COMMENT '促销结束日期',
  `PROMOTION_STATUS` varchar(20) DEFAULT NULL COMMENT '促销活动状态',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='促销活动';

/*Data for the table `t_scpcr_promotion` */

/*Table structure for table `t_scpcr_promotion_order` */

DROP TABLE IF EXISTS `t_scpcr_promotion_order`;

CREATE TABLE `t_scpcr_promotion_order` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `ORIGINAL_ORDER_ID` varchar(50) DEFAULT NULL COMMENT '原始订单ID',
  `SHOP_ID` varchar(50) DEFAULT NULL COMMENT '店铺ID',
  `ORDER_NO` varchar(50) DEFAULT NULL COMMENT '订单编号',
  `ALL_ORDER_COMMIT_MONEY` decimal(10,0) DEFAULT '0' COMMENT '订单提交金额合计',
  `ALL_ACTUAL_MONEY` decimal(10,0) DEFAULT '0' COMMENT '实际成交金额合计',
  `ORDER_STATUS` varchar(50) DEFAULT NULL COMMENT '订单状态',
  `RECEIVE_MAN` varchar(50) DEFAULT NULL COMMENT '收货人',
  `RECEIVE_ADDRESS` varchar(500) DEFAULT NULL COMMENT '收货地址',
  `RECEIVE_TEL` varchar(50) DEFAULT NULL COMMENT '收货电话',
  `COMMIT_MAN` varchar(50) DEFAULT NULL COMMENT '提交人',
  `COMMIT_TIME` varchar(20) DEFAULT NULL COMMENT '提交日期',
  `REJECTED_MAN` varchar(50) DEFAULT NULL COMMENT '驳回人',
  `REJECTED_TIME` varchar(20) DEFAULT NULL COMMENT '驳回日期',
  `REVIEWER` varchar(50) DEFAULT NULL COMMENT '审核人',
  `SETTLE_TIME` varchar(20) DEFAULT NULL COMMENT '结算日期',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='促销品订单';

/*Data for the table `t_scpcr_promotion_order` */

/*Table structure for table `t_scpcr_promotion_shop` */

DROP TABLE IF EXISTS `t_scpcr_promotion_shop`;

CREATE TABLE `t_scpcr_promotion_shop` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `PROMOTION_ID` varchar(50) DEFAULT NULL COMMENT '促销活动ID号',
  `SHOP_ID` varchar(50) DEFAULT NULL COMMENT '店铺ID号',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='促销活动店铺信息';

/*Data for the table `t_scpcr_promotion_shop` */

/*Table structure for table `t_scpcr_question` */

DROP TABLE IF EXISTS `t_scpcr_question`;

CREATE TABLE `t_scpcr_question` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `OPINION_CONTENT` varchar(200) DEFAULT NULL COMMENT '意见内容',
  `USER_TYPE` varchar(50) DEFAULT NULL COMMENT '用户类型',
  `QUESTIONER` varchar(50) DEFAULT NULL COMMENT '提问人',
  `FEEDBACK` varchar(50) DEFAULT NULL COMMENT '反馈状态',
  `FEEDBACK_LAST_TIME` varchar(14) DEFAULT NULL COMMENT '最后反馈时间',
  `STATUS_VIEW` varchar(20) DEFAULT NULL COMMENT '查看状态',
  `ATTACHMENT_ID` varchar(50) DEFAULT NULL COMMENT '附件id',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='意见';

/*Data for the table `t_scpcr_question` */

/*Table structure for table `t_scpcr_reply` */

DROP TABLE IF EXISTS `t_scpcr_reply`;

CREATE TABLE `t_scpcr_reply` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `OPINION_ID` varchar(50) DEFAULT NULL COMMENT '意见ID',
  `FEEDBACK_CONTENT` varchar(200) DEFAULT NULL COMMENT '反馈内容',
  `FEEDBACK_MAN` varchar(50) DEFAULT NULL COMMENT '反馈人',
  `FEEDBACK_TIME` varchar(14) DEFAULT NULL COMMENT '反馈时间',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='反馈';

/*Data for the table `t_scpcr_reply` */

/*Table structure for table `t_scpcr_sales_rebate` */

DROP TABLE IF EXISTS `t_scpcr_sales_rebate`;

CREATE TABLE `t_scpcr_sales_rebate` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `SALES_RECORD_ID` varchar(50) DEFAULT NULL COMMENT '销量记录ID',
  `QUARTER_REBATE` varchar(50) DEFAULT NULL COMMENT '季度返利金额',
  `MONTH_REBATE` varchar(50) DEFAULT NULL COMMENT '月返利金额',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='店铺销售返利';

/*Data for the table `t_scpcr_sales_rebate` */

/*Table structure for table `t_scpcr_sales_record_detail` */

DROP TABLE IF EXISTS `t_scpcr_sales_record_detail`;

CREATE TABLE `t_scpcr_sales_record_detail` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `SALES_RECORD_ID` varchar(50) DEFAULT NULL COMMENT '销量记录ID',
  `WARE_ID` varchar(50) DEFAULT NULL COMMENT '产品种类ID',
  `SALES_QTY` decimal(10,0) DEFAULT '0' COMMENT '销售数量',
  `IS_SAILS_RETURN` varchar(1) DEFAULT NULL COMMENT '是否退货',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='店铺销量登记明细（月）';

/*Data for the table `t_scpcr_sales_record_detail` */

/*Table structure for table `t_scpcr_sales_record_mon` */

DROP TABLE IF EXISTS `t_scpcr_sales_record_mon`;

CREATE TABLE `t_scpcr_sales_record_mon` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `DEALER_ID` varchar(50) DEFAULT NULL COMMENT '经销商ID',
  `DEALER_NAME` varchar(50) DEFAULT NULL COMMENT '经销商名称',
  `SHOP_ID` varchar(50) DEFAULT NULL COMMENT '店铺id',
  `SHOP_NAME` varchar(50) DEFAULT NULL COMMENT '店铺名称',
  `SHOP_MAN` varchar(50) DEFAULT NULL COMMENT '店主',
  `SHOP_PROPERTY` varchar(50) DEFAULT NULL COMMENT '店铺属性',
  `SALES_TYPE` varchar(1) DEFAULT NULL COMMENT '销售类型',
  `ALL_PERIOD_QTY` decimal(10,0) DEFAULT '0' COMMENT '当期销量合计',
  `SALES_MONTH` varchar(50) DEFAULT NULL COMMENT '销售月份',
  `SALES_RECORD_STATUS` varchar(50) DEFAULT NULL COMMENT '销售记录状态',
  `IS_ADDITIONAL_RECORD` varchar(50) DEFAULT NULL COMMENT '是否补录',
  `SIGN_GRADE` varchar(50) DEFAULT NULL COMMENT '签约等级',
  `COMMIT_MAN` varchar(20) DEFAULT NULL COMMENT '提交人',
  `COMMIT_TIME` varchar(20) DEFAULT NULL COMMENT '提交日期',
  `AUDIT_MAN` varchar(20) DEFAULT NULL COMMENT '审核人',
  `AUDIT_TIME` varchar(20) DEFAULT NULL COMMENT '审核日期',
  `SETTLE_MAN` varchar(20) DEFAULT NULL COMMENT '结算人',
  `SETTLE_TIME` varchar(20) DEFAULT NULL COMMENT '结算日期',
  `OPT_DES` varchar(500) DEFAULT NULL COMMENT '审核意见',
  `ATTACHMENT_ID` varchar(50) DEFAULT NULL COMMENT '附件id',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='店铺销量登记（月）';

/*Data for the table `t_scpcr_sales_record_mon` */

/*Table structure for table `t_scpcr_shop_addr` */

DROP TABLE IF EXISTS `t_scpcr_shop_addr`;

CREATE TABLE `t_scpcr_shop_addr` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `SHOP_ID` varchar(50) DEFAULT NULL COMMENT '店铺ID',
  `PROVINCE` varchar(50) DEFAULT NULL COMMENT '省名称',
  `CITY` varchar(50) DEFAULT NULL COMMENT '市名称',
  `AREA` varchar(50) DEFAULT NULL COMMENT '区名称',
  `ADDRESS` varchar(200) DEFAULT NULL COMMENT '详细地址',
  `POSTCODE` varchar(50) DEFAULT NULL COMMENT '邮政编号',
  `NAME` varchar(50) DEFAULT NULL COMMENT '收货人',
  `PHONE_NUM` varchar(60) DEFAULT NULL COMMENT '手机号码',
  `IS_DEFAULT` varchar(1) DEFAULT NULL COMMENT '是否为默认地址',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='店铺收货地址表';

/*Data for the table `t_scpcr_shop_addr` */

/*Table structure for table `t_scpcr_shopping_cart` */

DROP TABLE IF EXISTS `t_scpcr_shopping_cart`;

CREATE TABLE `t_scpcr_shopping_cart` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `USER_ID` varchar(50) DEFAULT NULL COMMENT '用户ID',
  `SHOP_ID` varchar(50) DEFAULT NULL COMMENT '店铺ID',
  `PRODUCT_TYPE` varchar(50) DEFAULT NULL COMMENT '商品类型',
  `PRODUCT_ID` varchar(50) DEFAULT NULL COMMENT '商品ID',
  `PRODUCT_QTY` decimal(10,0) DEFAULT '0' COMMENT '购物数量',
  `ALL_SHOP_CONV` decimal(10,0) DEFAULT '0' COMMENT '购物积分合计',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='购物车';

/*Data for the table `t_scpcr_shopping_cart` */

/*Table structure for table `t_scpcr_siging_level` */

DROP TABLE IF EXISTS `t_scpcr_siging_level`;

CREATE TABLE `t_scpcr_siging_level` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `SIGING_LEVEL` varchar(50) DEFAULT NULL COMMENT '级别',
  `SIGING_LEVEL_VALUE` varchar(50) DEFAULT NULL COMMENT '级别值',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='PCR签约级别维护';

/*Data for the table `t_scpcr_siging_level` */

/*Table structure for table `t_scpcr_siging_standard` */

DROP TABLE IF EXISTS `t_scpcr_siging_standard`;

CREATE TABLE `t_scpcr_siging_standard` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `SHOP_TYPE` varchar(50) DEFAULT NULL COMMENT '店铺属性',
  `SIGING_LEVEL_ID` varchar(50) DEFAULT NULL COMMENT '签约级别ID',
  `MON_REBATE_AMOUNT` decimal(10,0) DEFAULT '0' COMMENT '每月返利量',
  `SEASON_REBATE_AMOUNT` decimal(10,0) DEFAULT '0' COMMENT '每季返利量',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='PCR店铺签约标准';

/*Data for the table `t_scpcr_siging_standard` */

/*Table structure for table `t_scpcr_slide_pic` */

DROP TABLE IF EXISTS `t_scpcr_slide_pic`;

CREATE TABLE `t_scpcr_slide_pic` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `ATTACHMENT_ID` varchar(50) DEFAULT NULL COMMENT '幻灯图片地址',
  `SLIDE_PIC_URL` varchar(50) DEFAULT NULL COMMENT '幻灯图片链接地址',
  `SLIDE_TITLE` varchar(50) DEFAULT NULL COMMENT '幻灯标题',
  `UPLOAD_TIME` varchar(50) DEFAULT NULL COMMENT '上传时间',
  `IS_SHOW_FIRST` varchar(1) DEFAULT NULL COMMENT '是否显示在首页',
  `SHUFFLING_ORDER` varchar(50) DEFAULT NULL COMMENT '轮播顺序',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='图片幻灯片';

/*Data for the table `t_scpcr_slide_pic` */

/*Table structure for table `t_scpcr_sms_send` */

DROP TABLE IF EXISTS `t_scpcr_sms_send`;

CREATE TABLE `t_scpcr_sms_send` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `SMS_SEND_TEL` varchar(50) DEFAULT NULL COMMENT '短信发送号码',
  `SMS_RECEIVE_TEL` varchar(50) DEFAULT NULL COMMENT '短信接收号码',
  `SEND_CONTENT` varchar(2000) DEFAULT NULL COMMENT '发送内容',
  `SEND_MAN` varchar(50) DEFAULT NULL COMMENT '发送人ID',
  `RECEIVE_MAN` varchar(50) DEFAULT NULL COMMENT '接受人ID',
  `RECEIVE_TYPE` varchar(50) DEFAULT NULL COMMENT '接收人类型',
  `SEND_TIME` varchar(20) DEFAULT NULL COMMENT '发送时间',
  `SEND_STATUS` varchar(20) DEFAULT NULL COMMENT '发送状态',
  `FAILE_REASON` varchar(200) DEFAULT NULL COMMENT '失败原因',
  `BUSSINESS_TYPE` varchar(50) DEFAULT NULL COMMENT '业务类型',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='短信发送记录';

/*Data for the table `t_scpcr_sms_send` */

/*Table structure for table `t_scpcr_supplier` */

DROP TABLE IF EXISTS `t_scpcr_supplier`;

CREATE TABLE `t_scpcr_supplier` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `SUPPLIER_TYPE` varchar(50) DEFAULT NULL COMMENT '供应商类型',
  `SUPPLIER_NO` varchar(50) DEFAULT NULL COMMENT '供应商编号',
  `SUPPLIER_NAME` varchar(50) DEFAULT NULL COMMENT '供应商名称',
  `SUPPLIER_TEL` varchar(50) DEFAULT NULL COMMENT '供应商联系电话',
  `SUPPLIER_ADD` varchar(1000) DEFAULT NULL COMMENT '供应商地址',
  `SUPPLIER_MAIL` varchar(50) DEFAULT NULL COMMENT '供应商邮箱',
  `BUSSINESS_MAIL` varchar(50) DEFAULT NULL COMMENT '业务对接邮箱',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='供应商';

/*Data for the table `t_scpcr_supplier` */

/*Table structure for table `t_scpcr_supplier_order` */

DROP TABLE IF EXISTS `t_scpcr_supplier_order`;

CREATE TABLE `t_scpcr_supplier_order` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `SHOP_ID` varchar(50) DEFAULT NULL COMMENT '店铺ID',
  `MERGE_ORDER_NO` varchar(50) DEFAULT NULL COMMENT '合并订单编号',
  `SUPPLIER_ID` varchar(50) DEFAULT NULL COMMENT '供应商ID',
  `RECEIVE_MAN` varchar(50) DEFAULT NULL COMMENT '收货人',
  `RECEIVE_ADD` varchar(1000) DEFAULT NULL COMMENT '收货地址',
  `RECEIVE_TEL` varchar(50) DEFAULT NULL COMMENT '收货电话',
  `ORDER_STATUS` varchar(50) DEFAULT NULL COMMENT '订单状态',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='礼品合并订单（供应商）';

/*Data for the table `t_scpcr_supplier_order` */

/*Table structure for table `t_scpcr_sys_param` */

DROP TABLE IF EXISTS `t_scpcr_sys_param`;

CREATE TABLE `t_scpcr_sys_param` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `PARAM_NAME` varchar(200) DEFAULT NULL COMMENT '参数名称',
  `PARAM_KEY` varchar(50) DEFAULT NULL COMMENT '参数代码',
  `PARAM_VALUE` varchar(200) DEFAULT NULL COMMENT '参数值',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统参数表';

/*Data for the table `t_scpcr_sys_param` */

/*Table structure for table `t_scpcr_user_base_info` */

DROP TABLE IF EXISTS `t_scpcr_user_base_info`;

CREATE TABLE `t_scpcr_user_base_info` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `CONVERTIBLE_ACCOUNT_ID` varchar(50) DEFAULT NULL COMMENT '账户ID',
  `ATTACHMENT_ID` varchar(50) DEFAULT NULL COMMENT '用户头像地址',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商城用户基础信息';

/*Data for the table `t_scpcr_user_base_info` */

/*Table structure for table `t_sctbs_attach_info` */

DROP TABLE IF EXISTS `t_sctbs_attach_info`;

CREATE TABLE `t_sctbs_attach_info` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `ATTACHMENT_TYPE` varchar(50) DEFAULT NULL COMMENT '附件类型',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='附件信息表';

/*Data for the table `t_sctbs_attach_info` */

/*Table structure for table `t_sctbs_attach_info_detail` */

DROP TABLE IF EXISTS `t_sctbs_attach_info_detail`;

CREATE TABLE `t_sctbs_attach_info_detail` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `ATTACHMENT_ID` varchar(50) DEFAULT NULL COMMENT '附件ID',
  `ATTACHMENT_NAME` varchar(50) DEFAULT NULL COMMENT '附件名称',
  `ATTACHMENT_PATH` varchar(50) DEFAULT NULL COMMENT '附件路径',
  `TEMP_DIR` varchar(1000) DEFAULT NULL COMMENT '临时目录',
  `UPLOAD_DATE` varchar(20) DEFAULT NULL COMMENT '上传时间',
  `FILE_SIZE` varchar(50) DEFAULT NULL COMMENT '文件大小',
  `FILE_EXT` varchar(50) DEFAULT NULL COMMENT '文件后缀',
  `FILE_DES` varchar(50) DEFAULT NULL COMMENT '文件说明',
  `IS_DEFAULT` varchar(1) DEFAULT NULL COMMENT '默认',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='附件明细表';

/*Data for the table `t_sctbs_attach_info_detail` */

/*Table structure for table `t_sctbs_award_punish` */

DROP TABLE IF EXISTS `t_sctbs_award_punish`;

CREATE TABLE `t_sctbs_award_punish` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `SHOP_ID` varchar(50) DEFAULT NULL COMMENT '店铺ID',
  `AWARD_PUNISH_TYPE` varchar(20) DEFAULT NULL COMMENT '奖惩类型',
  `AWARD_PUNISH_INTEGRAL` decimal(10,0) DEFAULT '0' COMMENT '奖惩积分',
  `AWARD_PUNISH_REASON` varchar(50) DEFAULT NULL COMMENT '奖励原因',
  `ATTACHMENT_ID` varchar(50) DEFAULT NULL COMMENT '附件ID',
  `AWARD_PUNISH_STATUS` varchar(1) DEFAULT NULL COMMENT '奖惩记录状态',
  `APPLY_MAN` varchar(20) DEFAULT NULL COMMENT '申请人',
  `APPLY_DATE` varchar(20) DEFAULT NULL COMMENT '申请日期',
  `AUDIT_MAN` varchar(20) DEFAULT NULL COMMENT '审核人',
  `AUDIT_DATE` varchar(20) DEFAULT NULL COMMENT '审核日期',
  `AUDIT_OPINION` varchar(200) DEFAULT NULL COMMENT '审核意见',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='积分奖罚';

/*Data for the table `t_sctbs_award_punish` */

/*Table structure for table `t_sctbs_check_code` */

DROP TABLE IF EXISTS `t_sctbs_check_code`;

CREATE TABLE `t_sctbs_check_code` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `USER_ID` varchar(50) DEFAULT NULL COMMENT '用户ID',
  `CHECK_TYPE` varchar(20) DEFAULT NULL COMMENT '验证类型',
  `CHECK_CODE` varchar(50) DEFAULT NULL COMMENT '验证码',
  `CHECK_TIME` varchar(20) DEFAULT NULL COMMENT '验证时间',
  `IS_USED` varchar(1) DEFAULT NULL COMMENT '是否有效',
  `FAILURE_TIME` varchar(20) DEFAULT NULL COMMENT '失效时间',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='验证码表';

/*Data for the table `t_sctbs_check_code` */

/*Table structure for table `t_sctbs_convertible_rule` */

DROP TABLE IF EXISTS `t_sctbs_convertible_rule`;

CREATE TABLE `t_sctbs_convertible_rule` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `CONVERTIBLE_LEVEL` varchar(1) DEFAULT NULL COMMENT '积分等级',
  `PRODUCT_SIZE` varchar(50) DEFAULT NULL COMMENT '寸别',
  `START_NUMBER` decimal(10,0) DEFAULT '0' COMMENT '起始数量',
  `END_NUMBER` decimal(10,0) DEFAULT '0' COMMENT '终止数量',
  `CONVERTIBLE` decimal(10,0) DEFAULT '0' COMMENT '积分',
  `SALES_LIMIT` decimal(10,0) DEFAULT '0' COMMENT '销售上限',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='TBS积分规则';

/*Data for the table `t_sctbs_convertible_rule` */

/*Table structure for table `t_sctbs_credit_acnt` */

DROP TABLE IF EXISTS `t_sctbs_credit_acnt`;

CREATE TABLE `t_sctbs_credit_acnt` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `SHOP_ID` varchar(50) DEFAULT NULL COMMENT '店铺ID',
  `INTEGRAL_BALANCE` decimal(10,0) DEFAULT '0' COMMENT '积分余额',
  `INTEGRAL_USE_BALANCE` decimal(10,0) DEFAULT '0' COMMENT '积分可用余额',
  `DATA_TIME` varchar(20) DEFAULT NULL COMMENT '设立日期',
  `INTEGRAL_EXPIRE_DATE` varchar(20) DEFAULT NULL COMMENT '积分到期日',
  `PERIOD_UNZERIO_INTEGRAL` decimal(10,0) DEFAULT '0' COMMENT '本期不清零积分',
  `UNZERIO_MONTH` varchar(1) DEFAULT NULL COMMENT '不清零月数',
  `PRE_MONEY` decimal(10,0) DEFAULT '0' COMMENT '预占金额',
  `OVERDRAW_MONEY` decimal(10,0) DEFAULT '0' COMMENT '透支金额',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='积分账户';

/*Data for the table `t_sctbs_credit_acnt` */

/*Table structure for table `t_sctbs_credit_acnt_detail` */

DROP TABLE IF EXISTS `t_sctbs_credit_acnt_detail`;

CREATE TABLE `t_sctbs_credit_acnt_detail` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `INTEGRAL_ACCOUNT_ID` varchar(50) DEFAULT NULL COMMENT '积分账户ID',
  `INTEGRAL_OPT_TYPE` varchar(50) DEFAULT NULL COMMENT '积分操作类型',
  `INCREASE_OR_DECREASE` varchar(1) DEFAULT NULL COMMENT '增减标识',
  `CHANGE_MONEY` decimal(10,0) DEFAULT '0' COMMENT '变动金额',
  `CHANGE_INTEGRAL_BALANCE` decimal(10,0) DEFAULT '0' COMMENT '变动后积分余额',
  `CHANGE_INTEGRAL_USE_BALANCE` decimal(10,0) DEFAULT '0' COMMENT '变动后积分可用余额',
  `SALES_SETTLE_MONTH` decimal(10,0) DEFAULT '0' COMMENT '销量结算月',
  `OPT_TIME` varchar(20) DEFAULT NULL COMMENT '操作日期',
  `RELATION_TRADING_ID` varchar(50) DEFAULT NULL COMMENT '关联交易ID',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='积分账户明细';

/*Data for the table `t_sctbs_credit_acnt_detail` */

/*Table structure for table `t_sctbs_credit_clear` */

DROP TABLE IF EXISTS `t_sctbs_credit_clear`;

CREATE TABLE `t_sctbs_credit_clear` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `SHOP_ID` varchar(50) DEFAULT NULL COMMENT '店铺ID',
  `ZERO_STATUS` varchar(20) DEFAULT NULL COMMENT '清零状态',
  `ZERO_INTEGRAL` decimal(10,0) DEFAULT '0' COMMENT '清零积分',
  `INTEGRAL_EXPIRE_DATE` varchar(20) DEFAULT NULL COMMENT '积分到期日',
  `ZERO_DATE` varchar(20) DEFAULT NULL COMMENT '清零日期',
  `ZERO_MAN` varchar(20) DEFAULT NULL COMMENT '清零人',
  `RETURN_INTEGRAL` decimal(10,0) DEFAULT '0' COMMENT '返还积分',
  `RETURN_APPLY_MAN` varchar(50) DEFAULT NULL COMMENT '返还申请人',
  `RETURN_APPLY_REASON` varchar(500) DEFAULT NULL COMMENT '返还申请原因',
  `RETURN_APPLY_DATE` varchar(50) DEFAULT NULL COMMENT '返还申请日期',
  `RETURN_APPLY_AUDIT_MAN` varchar(20) DEFAULT NULL COMMENT '返还审核人',
  `AUDIT_OPINION` varchar(500) DEFAULT NULL COMMENT '审核意见',
  `AUDIT_RETURN_TIME` varchar(50) DEFAULT NULL COMMENT '审核日期',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='积分清零及返还';

/*Data for the table `t_sctbs_credit_clear` */

/*Table structure for table `t_sctbs_credit_overdraft` */

DROP TABLE IF EXISTS `t_sctbs_credit_overdraft`;

CREATE TABLE `t_sctbs_credit_overdraft` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `SHOP_ID` varchar(50) DEFAULT NULL COMMENT '店铺ID',
  `OVERDRAFT_CONVERTIBLE` decimal(10,0) DEFAULT '0' COMMENT '透支积分',
  `OVERDRAFT_REASON` varchar(500) DEFAULT NULL COMMENT '透支原因',
  `OVERDRAFT_APPLY_DATE` varchar(20) DEFAULT NULL COMMENT '透支申请日期',
  `OVERDRAFT_APPLY_MAN` varchar(20) DEFAULT NULL COMMENT '透支申请人',
  `ATTACHMENT_ID` varchar(200) DEFAULT NULL COMMENT '附件ID',
  `OVERDRAFT_APPLY_STATUS` varchar(20) DEFAULT NULL COMMENT '透支申请状态',
  `AUDIT_MAN` varchar(20) DEFAULT NULL COMMENT '审核人',
  `AUDIT_TIME` varchar(20) DEFAULT NULL COMMENT '审核日期',
  `AUDIT_OPINION` varchar(500) DEFAULT NULL COMMENT '审核意见',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='积分提前消费';

/*Data for the table `t_sctbs_credit_overdraft` */

/*Table structure for table `t_sctbs_economy_product` */

DROP TABLE IF EXISTS `t_sctbs_economy_product`;

CREATE TABLE `t_sctbs_economy_product` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `WARE_ID` varchar(50) DEFAULT NULL COMMENT '产品种类ID',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='TBS经济型产品';

/*Data for the table `t_sctbs_economy_product` */

/*Table structure for table `t_sctbs_exchange_date` */

DROP TABLE IF EXISTS `t_sctbs_exchange_date`;

CREATE TABLE `t_sctbs_exchange_date` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `BEGIN_DATE` varchar(20) DEFAULT NULL COMMENT '开始日期',
  `END_DATE` varchar(20) DEFAULT NULL COMMENT '截止日期',
  `IS_USED` varchar(1) DEFAULT NULL COMMENT '是否启用',
  `EXCHANGE_TYPE` varchar(50) DEFAULT NULL COMMENT '兑换类型',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='兑换时间设置（含清零兑换）';

/*Data for the table `t_sctbs_exchange_date` */

/*Table structure for table `t_sctbs_guide_content` */

DROP TABLE IF EXISTS `t_sctbs_guide_content`;

CREATE TABLE `t_sctbs_guide_content` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `TOPIC_ID` varchar(50) DEFAULT NULL COMMENT '主题ID',
  `GUIDE_CONTENT` varchar(50) DEFAULT NULL COMMENT '指引内容',
  `PUBLISH_TIME` varchar(50) DEFAULT NULL COMMENT '发布日期',
  `PUBLISH_MAN` varchar(50) DEFAULT NULL COMMENT '发布人ID',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='积分项目指引内容';

/*Data for the table `t_sctbs_guide_content` */

/*Table structure for table `t_sctbs_inner_msg` */

DROP TABLE IF EXISTS `t_sctbs_inner_msg`;

CREATE TABLE `t_sctbs_inner_msg` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `INFORMATION_TYPE` varchar(50) DEFAULT NULL COMMENT '咨讯类型',
  `TOPIC` varchar(50) DEFAULT NULL COMMENT '主题',
  `CONTENT` varchar(50) DEFAULT NULL COMMENT '内容',
  `ATTACHMENT_ID` varchar(50) DEFAULT NULL COMMENT '附件id',
  `INFORMATION_STATUS` varchar(50) DEFAULT NULL COMMENT '咨讯状态',
  `SEND_TIME` varchar(20) DEFAULT NULL COMMENT '发送时间',
  `IS_PUBLISH` varchar(1) DEFAULT NULL COMMENT '是否发布',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='咨讯';

/*Data for the table `t_sctbs_inner_msg` */

/*Table structure for table `t_sctbs_mail_msg` */

DROP TABLE IF EXISTS `t_sctbs_mail_msg`;

CREATE TABLE `t_sctbs_mail_msg` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `MAIL_TOPIC` varchar(200) DEFAULT NULL COMMENT '邮件主题',
  `MAIL_CONTENT` varchar(4000) DEFAULT NULL COMMENT '邮件内容',
  `RECEIVER_MAIL` varchar(50) DEFAULT NULL COMMENT '收件人邮箱',
  `SENDER_MAIL` varchar(50) DEFAULT NULL COMMENT '发件人邮箱',
  `RECEIVER` varchar(50) DEFAULT NULL COMMENT '收件人',
  `RECEIVER_TYPE` varchar(20) DEFAULT NULL COMMENT '收件人类型',
  `SEND_TIME` varchar(14) DEFAULT NULL COMMENT '发送时间',
  `SEND_STATUS` varchar(3) DEFAULT NULL COMMENT '发送状态',
  `BUSSINESS_TYPE` varchar(3) DEFAULT NULL COMMENT '业务类型',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='邮件消息';

/*Data for the table `t_sctbs_mail_msg` */

/*Table structure for table `t_sctbs_msg_user` */

DROP TABLE IF EXISTS `t_sctbs_msg_user`;

CREATE TABLE `t_sctbs_msg_user` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `MSG_SEND_ID` varchar(50) DEFAULT NULL COMMENT '咨讯发送ID',
  `MSG_ID` varchar(50) DEFAULT NULL COMMENT '咨讯ID',
  `RECEIVER_TYPE` varchar(10) DEFAULT NULL COMMENT '接收者类型',
  `RECEIVER_ID` varchar(50) DEFAULT NULL COMMENT '接收者ID',
  `IS_VIEWED` varchar(1) DEFAULT NULL COMMENT '是否已查看',
  `VIEW_TIME` varchar(14) DEFAULT NULL COMMENT '查看时间',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='咨询接收者';

/*Data for the table `t_sctbs_msg_user` */

/*Table structure for table `t_sctbs_order_deliver` */

DROP TABLE IF EXISTS `t_sctbs_order_deliver`;

CREATE TABLE `t_sctbs_order_deliver` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `MERGE_ORDER_ID` varchar(50) DEFAULT NULL COMMENT '合并订单ID',
  `PROVIDER_CONTENT` varchar(200) DEFAULT NULL COMMENT '物流说明',
  `PROVIDER_NAME` varchar(50) DEFAULT NULL COMMENT '物流供应商名称',
  `PROVIDER_ID` varchar(50) DEFAULT NULL COMMENT '物流供应商ID',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单物流信息';

/*Data for the table `t_sctbs_order_deliver` */

/*Table structure for table `t_sctbs_present_order` */

DROP TABLE IF EXISTS `t_sctbs_present_order`;

CREATE TABLE `t_sctbs_present_order` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `SHOP_ID` varchar(50) DEFAULT NULL COMMENT '店铺ID',
  `ORDER_NO` varchar(50) DEFAULT NULL COMMENT '订单编号',
  `ALL_ORDER_COMMIT_CONV` decimal(10,0) DEFAULT '0' COMMENT '订单提交积分合计',
  `ALL_ACTUAL_EXCHANGE_CONV` decimal(10,0) DEFAULT '0' COMMENT '实际兑换积分合计',
  `ALL_RETURN_CONV` decimal(10,0) DEFAULT '0' COMMENT '返还积分合计',
  `ORDER_STATUS` varchar(50) DEFAULT NULL COMMENT '订单状态',
  `SHOP_ADDR_ID` varchar(50) DEFAULT NULL COMMENT '收货地址ID',
  `RECEIVE_MAN` varchar(50) DEFAULT NULL COMMENT '收货人',
  `RECEIVE_ADD` varchar(50) DEFAULT NULL COMMENT '收货地址',
  `RECEIVE_TEL` varchar(50) DEFAULT NULL COMMENT '收货电话',
  `COMMIT_MAN` varchar(50) DEFAULT NULL COMMENT '提交人',
  `COMMIT_TIME` varchar(20) DEFAULT NULL COMMENT '提交日期',
  `MODIFYOR` varchar(20) DEFAULT NULL COMMENT '修改人',
  `MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '修改日期',
  `REJECTED_MAN` varchar(20) DEFAULT NULL COMMENT '驳回人',
  `REJECTED_TIME` varchar(20) DEFAULT NULL COMMENT '驳回日期',
  `AUDIT_MAN` varchar(20) DEFAULT NULL COMMENT '审核人',
  `SETTLE_TIME` varchar(20) DEFAULT NULL COMMENT '结算日期',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='礼品订单（原始）';

/*Data for the table `t_sctbs_present_order` */

/*Table structure for table `t_sctbs_present_order_dtl` */

DROP TABLE IF EXISTS `t_sctbs_present_order_dtl`;

CREATE TABLE `t_sctbs_present_order_dtl` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `ORIGINAL_ORDER_ID` varchar(50) DEFAULT NULL COMMENT '原始订单ID',
  `PRESENT_ID` varchar(50) DEFAULT NULL COMMENT '礼品ID',
  `ORDER_COMMIT_QTY` decimal(10,0) DEFAULT '0' COMMENT '订单提交数量',
  `ACTUAL_CONVERTIBLE_QTY` decimal(10,0) DEFAULT '0' COMMENT '实际兑换数量',
  `ORDER_COMMIT_INTEGRAL` decimal(10,0) DEFAULT '0' COMMENT '订单提交积分',
  `ACTUAL_CONVERTIBLE_INTEGRAL` decimal(10,0) DEFAULT '0' COMMENT '实际兑换积分',
  `RETURN_INTEGRAL` decimal(10,0) DEFAULT '0' COMMENT '返还积分',
  `MERGE_ORDER_ID` varchar(50) DEFAULT NULL COMMENT '合并订单ID',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='礼品订单明细（原始）';

/*Data for the table `t_sctbs_present_order_dtl` */

/*Table structure for table `t_sctbs_present_store` */

DROP TABLE IF EXISTS `t_sctbs_present_store`;

CREATE TABLE `t_sctbs_present_store` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `PRESENT_CODE` varchar(50) DEFAULT NULL COMMENT '礼品编码',
  `PRESENT_VERSION` decimal(10,0) DEFAULT '0' COMMENT '礼品版本号',
  `PRESENT_NAME` varchar(200) DEFAULT NULL COMMENT '礼品名称',
  `PRESENT_TYPE` varchar(20) DEFAULT NULL COMMENT '礼品类型',
  `SUPPLIER` varchar(50) DEFAULT NULL COMMENT '供应商ID',
  `SUPPLIER_NAME` varchar(200) DEFAULT NULL COMMENT '供应商名称',
  `PRESENT_TYPE_ID` varchar(50) DEFAULT NULL COMMENT '礼品类别ID',
  `UNIT` varchar(10) DEFAULT NULL COMMENT '单位',
  `ALL_CONVERTIBLE_QTY` decimal(10,0) DEFAULT '0' COMMENT '累计兑换数量',
  `INVENTORY` decimal(10,0) DEFAULT '0' COMMENT '库存',
  `IS_SOLD_OUT` varchar(1) DEFAULT NULL COMMENT '是否下架',
  `UNIT_INTEGRAL_QTY` decimal(10,0) DEFAULT '0' COMMENT '单位兑换积分',
  `MATERIAL_NUMBER` varchar(50) DEFAULT NULL COMMENT '商品编码/料号',
  `PRODUCT_NO` varchar(50) DEFAULT NULL COMMENT '型号',
  `PRESENT_COLOR` varchar(50) DEFAULT NULL COMMENT '颜色',
  `ATTACHMENT_ID` varchar(200) DEFAULT NULL COMMENT '附件id',
  `PRESENT_DES` varchar(200) DEFAULT NULL COMMENT '礼品描述',
  `PURCHASE_PRICE` decimal(10,0) DEFAULT '0' COMMENT '进货价',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='礼品库存信息';

/*Data for the table `t_sctbs_present_store` */

/*Table structure for table `t_sctbs_present_type` */

DROP TABLE IF EXISTS `t_sctbs_present_type`;

CREATE TABLE `t_sctbs_present_type` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `PRESENT_TYPE_CODE` varchar(50) DEFAULT NULL COMMENT '礼品类别代码',
  `PRESENT_TYPE_NAME` varchar(200) DEFAULT NULL COMMENT '礼品类别名称',
  `PRESENT_TYPE_ADDR` varchar(200) DEFAULT NULL COMMENT '礼品类别链接地址',
  `INDEX_NO` decimal(10,0) DEFAULT '0' COMMENT '顺序号',
  `PRESENT_TYPE` varchar(20) DEFAULT NULL COMMENT '礼品类型',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='礼品类别';

/*Data for the table `t_sctbs_present_type` */

/*Table structure for table `t_sctbs_prom_cons_order` */

DROP TABLE IF EXISTS `t_sctbs_prom_cons_order`;

CREATE TABLE `t_sctbs_prom_cons_order` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `SHOP_ID` varchar(50) DEFAULT NULL COMMENT '店铺ID',
  `MERGE_ORDER_NO` varchar(50) DEFAULT NULL COMMENT '合并订单编号',
  `RECEIVE_MAN` varchar(50) DEFAULT NULL COMMENT '收货人',
  `RECEIVE_ADD` varchar(1000) DEFAULT NULL COMMENT '收货地址',
  `RECEIVE_TEL` varchar(50) DEFAULT NULL COMMENT '收货电话',
  `ORDER_STATUS` varchar(50) DEFAULT NULL COMMENT '订单状态',
  `LAST_UPDATE_TIME` varchar(20) DEFAULT NULL COMMENT '最后更新日期',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='促销品合并订单';

/*Data for the table `t_sctbs_prom_cons_order` */

/*Table structure for table `t_sctbs_prom_order_detail` */

DROP TABLE IF EXISTS `t_sctbs_prom_order_detail`;

CREATE TABLE `t_sctbs_prom_order_detail` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `ORIGINAL_ORDER_ID` varchar(50) DEFAULT NULL COMMENT '原始订单ID',
  `PROMOTION_ORDER_ID` varchar(50) DEFAULT NULL COMMENT '促销品ID',
  `ORDER_COMMIT_QTY` decimal(10,0) DEFAULT '0' COMMENT '订单提交数量',
  `ACTUAL_DEAL_QTY` decimal(10,0) DEFAULT '0' COMMENT '实际成交数量',
  `ORDER_COMMIT_MONEY` decimal(10,0) DEFAULT '0' COMMENT '订单提交金额',
  `ACTUAL_DEAL_MONEY` decimal(10,0) DEFAULT '0' COMMENT '实际成交金额',
  `MERGE_ORDER_ID` varchar(50) DEFAULT NULL COMMENT '合并订单ID',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='促销品订单明细';

/*Data for the table `t_sctbs_prom_order_detail` */

/*Table structure for table `t_sctbs_promotion` */

DROP TABLE IF EXISTS `t_sctbs_promotion`;

CREATE TABLE `t_sctbs_promotion` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `PROMOTION_NAME` varchar(200) DEFAULT NULL COMMENT '促销活动名称',
  `PROMOTION_CONTENT` varchar(4000) DEFAULT NULL COMMENT '促销活动内容说明',
  `PROMOTION_BEGIN_TIME` varchar(20) DEFAULT NULL COMMENT '促销开始日期',
  `PROMOTION_END_TIME` varchar(20) DEFAULT NULL COMMENT '促销结束日期',
  `PROMOTION_STATUS` varchar(20) DEFAULT NULL COMMENT '促销活动状态',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='促销活动';

/*Data for the table `t_sctbs_promotion` */

/*Table structure for table `t_sctbs_promotion_order` */

DROP TABLE IF EXISTS `t_sctbs_promotion_order`;

CREATE TABLE `t_sctbs_promotion_order` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `ORIGINAL_ORDER_ID` varchar(50) DEFAULT NULL COMMENT '原始订单ID',
  `SHOP_ID` varchar(50) DEFAULT NULL COMMENT '店铺ID',
  `ORDER_NO` varchar(50) DEFAULT NULL COMMENT '订单编号',
  `ALL_ORDER_COMMIT_MONEY` decimal(10,0) DEFAULT '0' COMMENT '订单提交金额合计',
  `ALL_ACTUAL_MONEY` decimal(10,0) DEFAULT '0' COMMENT '实际成交金额合计',
  `ORDER_STATUS` varchar(50) DEFAULT NULL COMMENT '订单状态',
  `RECEIVE_MAN` varchar(50) DEFAULT NULL COMMENT '收货人',
  `RECEIVE_ADDRESS` varchar(500) DEFAULT NULL COMMENT '收货地址',
  `RECEIVE_TEL` varchar(50) DEFAULT NULL COMMENT '收货电话',
  `COMMIT_MAN` varchar(50) DEFAULT NULL COMMENT '提交人',
  `COMMIT_TIME` varchar(20) DEFAULT NULL COMMENT '提交日期',
  `REJECTED_MAN` varchar(50) DEFAULT NULL COMMENT '驳回人',
  `REJECTED_TIME` varchar(20) DEFAULT NULL COMMENT '驳回日期',
  `REVIEWER` varchar(50) DEFAULT NULL COMMENT '审核人',
  `SETTLE_TIME` varchar(20) DEFAULT NULL COMMENT '结算日期',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='促销品订单';

/*Data for the table `t_sctbs_promotion_order` */

/*Table structure for table `t_sctbs_promotion_shop` */

DROP TABLE IF EXISTS `t_sctbs_promotion_shop`;

CREATE TABLE `t_sctbs_promotion_shop` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `PROMOTION_ID` varchar(50) DEFAULT NULL COMMENT '促销活动ID号',
  `SHOP_ID` varchar(50) DEFAULT NULL COMMENT '店铺ID号',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='促销活动店铺信息';

/*Data for the table `t_sctbs_promotion_shop` */

/*Table structure for table `t_sctbs_question` */

DROP TABLE IF EXISTS `t_sctbs_question`;

CREATE TABLE `t_sctbs_question` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `OPINION_CONTENT` varchar(200) DEFAULT NULL COMMENT '意见内容',
  `USER_TYPE` varchar(50) DEFAULT NULL COMMENT '用户类型',
  `QUESTIONER` varchar(50) DEFAULT NULL COMMENT '提问人',
  `FEEDBACK` varchar(50) DEFAULT NULL COMMENT '反馈状态',
  `FEEDBACK_LAST_TIME` varchar(14) DEFAULT NULL COMMENT '最后反馈时间',
  `STATUS_VIEW` varchar(20) DEFAULT NULL COMMENT '查看状态',
  `ATTACHMENT_ID` varchar(50) DEFAULT NULL COMMENT '附件id',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='意见';

/*Data for the table `t_sctbs_question` */

/*Table structure for table `t_sctbs_reply` */

DROP TABLE IF EXISTS `t_sctbs_reply`;

CREATE TABLE `t_sctbs_reply` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `OPINION_ID` varchar(50) DEFAULT NULL COMMENT '意见ID',
  `FEEDBACK_CONTENT` varchar(200) DEFAULT NULL COMMENT '反馈内容',
  `FEEDBACK_MAN` varchar(50) DEFAULT NULL COMMENT '反馈人',
  `FEEDBACK_TIME` varchar(14) DEFAULT NULL COMMENT '反馈时间',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='反馈';

/*Data for the table `t_sctbs_reply` */

/*Table structure for table `t_sctbs_return_rule` */

DROP TABLE IF EXISTS `t_sctbs_return_rule`;

CREATE TABLE `t_sctbs_return_rule` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `CONVERTIBLE_LEVEL` varchar(1) DEFAULT NULL COMMENT '积分等级',
  `PRODUCT_SIZE` varchar(50) DEFAULT NULL COMMENT '寸别',
  `CONVERTIBLE` decimal(10,0) DEFAULT '0' COMMENT '积分',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='TBS退货积分规则';

/*Data for the table `t_sctbs_return_rule` */

/*Table structure for table `t_sctbs_sales_rebate` */

DROP TABLE IF EXISTS `t_sctbs_sales_rebate`;

CREATE TABLE `t_sctbs_sales_rebate` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `SALES_RECORD_ID` varchar(50) DEFAULT NULL COMMENT '销量记录ID',
  `QUARTER_REBATE` varchar(50) DEFAULT NULL COMMENT '季度返利金额',
  `MONTH_REBATE` varchar(50) DEFAULT NULL COMMENT '月返利金额',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='店铺销售返利';

/*Data for the table `t_sctbs_sales_rebate` */

/*Table structure for table `t_sctbs_sales_record_detail` */

DROP TABLE IF EXISTS `t_sctbs_sales_record_detail`;

CREATE TABLE `t_sctbs_sales_record_detail` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `SALES_RECORD_ID` varchar(50) DEFAULT NULL COMMENT '销量记录ID',
  `WARE_ID` varchar(50) DEFAULT NULL COMMENT '产品种类ID',
  `SALES_QTY` decimal(10,0) DEFAULT '0' COMMENT '销售数量',
  `IS_SAILS_RETURN` varchar(1) DEFAULT NULL COMMENT '是否退货',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='店铺销量登记明细（月）';

/*Data for the table `t_sctbs_sales_record_detail` */

/*Table structure for table `t_sctbs_sales_record_mon` */

DROP TABLE IF EXISTS `t_sctbs_sales_record_mon`;

CREATE TABLE `t_sctbs_sales_record_mon` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `DEALER_ID` varchar(50) DEFAULT NULL COMMENT '经销商ID',
  `DEALER_NAME` varchar(50) DEFAULT NULL COMMENT '经销商名称',
  `SHOP_ID` varchar(50) DEFAULT NULL COMMENT '店铺id',
  `SHOP_NAME` varchar(50) DEFAULT NULL COMMENT '店铺名称',
  `SHOP_MAN` varchar(50) DEFAULT NULL COMMENT '店主',
  `SHOP_PROPERTY` varchar(50) DEFAULT NULL COMMENT '店铺属性',
  `SALES_TYPE` varchar(1) DEFAULT NULL COMMENT '销售类型',
  `ALL_PERIOD_QTY` decimal(10,0) DEFAULT '0' COMMENT '当期销量合计',
  `SALES_MONTH` varchar(50) DEFAULT NULL COMMENT '销售月份',
  `SALES_RECORD_STATUS` varchar(50) DEFAULT NULL COMMENT '销售记录状态',
  `IS_ADDITIONAL_RECORD` varchar(50) DEFAULT NULL COMMENT '是否补录',
  `SIGN_GRADE` varchar(50) DEFAULT NULL COMMENT '签约等级',
  `COMMIT_MAN` varchar(20) DEFAULT NULL COMMENT '提交人',
  `COMMIT_TIME` varchar(20) DEFAULT NULL COMMENT '提交日期',
  `AUDIT_MAN` varchar(20) DEFAULT NULL COMMENT '审核人',
  `AUDIT_TIME` varchar(20) DEFAULT NULL COMMENT '审核日期',
  `SETTLE_MAN` varchar(20) DEFAULT NULL COMMENT '结算人',
  `SETTLE_TIME` varchar(20) DEFAULT NULL COMMENT '结算日期',
  `OPT_DES` varchar(500) DEFAULT NULL COMMENT '审核意见',
  `ATTACHMENT_ID` varchar(50) DEFAULT NULL COMMENT '附件id',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='店铺销量登记（月）';

/*Data for the table `t_sctbs_sales_record_mon` */

/*Table structure for table `t_sctbs_shop_addr` */

DROP TABLE IF EXISTS `t_sctbs_shop_addr`;

CREATE TABLE `t_sctbs_shop_addr` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `SHOP_ID` varchar(50) DEFAULT NULL COMMENT '店铺ID',
  `PROVINCE` varchar(50) DEFAULT NULL COMMENT '省名称',
  `CITY` varchar(50) DEFAULT NULL COMMENT '市名称',
  `AREA` varchar(50) DEFAULT NULL COMMENT '区名称',
  `ADDRESS` varchar(200) DEFAULT NULL COMMENT '详细地址',
  `POSTCODE` varchar(50) DEFAULT NULL COMMENT '邮政编号',
  `NAME` varchar(50) DEFAULT NULL COMMENT '收货人',
  `PHONE_NUM` varchar(60) DEFAULT NULL COMMENT '手机号码',
  `IS_DEFAULT` varchar(1) DEFAULT NULL COMMENT '是否为默认地址',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='店铺收货地址表';

/*Data for the table `t_sctbs_shop_addr` */

/*Table structure for table `t_sctbs_shop_agent` */

DROP TABLE IF EXISTS `t_sctbs_shop_agent`;

CREATE TABLE `t_sctbs_shop_agent` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `AGENT_MAN` varchar(50) DEFAULT NULL COMMENT '代理人',
  `AGENT_STORE_ID` varchar(50) DEFAULT NULL COMMENT '被代理店铺ID',
  `AGENT_REQUEST_TIME` varchar(20) DEFAULT NULL COMMENT '代理申请时间',
  `AGENT_AUTHORIZATION_TIME` varchar(20) DEFAULT NULL COMMENT '授权时间',
  `AUTHORIZATION_CODE` varchar(20) DEFAULT NULL COMMENT '授权码',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='协助店铺兑换';

/*Data for the table `t_sctbs_shop_agent` */

/*Table structure for table `t_sctbs_shopping_cart` */

DROP TABLE IF EXISTS `t_sctbs_shopping_cart`;

CREATE TABLE `t_sctbs_shopping_cart` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `USER_ID` varchar(50) DEFAULT NULL COMMENT '用户ID',
  `SHOP_ID` varchar(50) DEFAULT NULL COMMENT '店铺ID',
  `PRODUCT_TYPE` varchar(50) DEFAULT NULL COMMENT '商品类型',
  `PRODUCT_ID` varchar(50) DEFAULT NULL COMMENT '商品ID',
  `PRODUCT_QTY` decimal(10,0) DEFAULT '0' COMMENT '购物数量',
  `ALL_SHOP_CONV` decimal(10,0) DEFAULT '0' COMMENT '购物积分合计',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='购物车';

/*Data for the table `t_sctbs_shopping_cart` */

/*Table structure for table `t_sctbs_slide_pic` */

DROP TABLE IF EXISTS `t_sctbs_slide_pic`;

CREATE TABLE `t_sctbs_slide_pic` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `ATTACHMENT_ID` varchar(50) DEFAULT NULL COMMENT '幻灯图片地址',
  `SLIDE_PIC_URL` varchar(50) DEFAULT NULL COMMENT '幻灯图片链接地址',
  `SLIDE_TITLE` varchar(50) DEFAULT NULL COMMENT '幻灯标题',
  `UPLOAD_TIME` varchar(50) DEFAULT NULL COMMENT '上传时间',
  `IS_SHOW_FIRST` varchar(1) DEFAULT NULL COMMENT '是否显示在首页',
  `SHUFFLING_ORDER` varchar(50) DEFAULT NULL COMMENT '轮播顺序',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='图片幻灯片';

/*Data for the table `t_sctbs_slide_pic` */

/*Table structure for table `t_sctbs_sms_send` */

DROP TABLE IF EXISTS `t_sctbs_sms_send`;

CREATE TABLE `t_sctbs_sms_send` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `SMS_SEND_TEL` varchar(50) DEFAULT NULL COMMENT '短信发送号码',
  `SMS_RECEIVE_TEL` varchar(50) DEFAULT NULL COMMENT '短信接收号码',
  `SEND_CONTENT` varchar(2000) DEFAULT NULL COMMENT '发送内容',
  `SEND_MAN` varchar(50) DEFAULT NULL COMMENT '发送人ID',
  `RECEIVE_MAN` varchar(50) DEFAULT NULL COMMENT '接受人ID',
  `RECEIVE_TYPE` varchar(50) DEFAULT NULL COMMENT '接收人类型',
  `SEND_TIME` varchar(20) DEFAULT NULL COMMENT '发送时间',
  `SEND_STATUS` varchar(20) DEFAULT NULL COMMENT '发送状态',
  `FAILE_REASON` varchar(200) DEFAULT NULL COMMENT '失败原因',
  `BUSSINESS_TYPE` varchar(50) DEFAULT NULL COMMENT '业务类型',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='短信发送记录';

/*Data for the table `t_sctbs_sms_send` */

/*Table structure for table `t_sctbs_supplier` */

DROP TABLE IF EXISTS `t_sctbs_supplier`;

CREATE TABLE `t_sctbs_supplier` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `SUPPLIER_TYPE` varchar(50) DEFAULT NULL COMMENT '供应商类型',
  `SUPPLIER_NO` varchar(50) DEFAULT NULL COMMENT '供应商编号',
  `SUPPLIER_NAME` varchar(50) DEFAULT NULL COMMENT '供应商名称',
  `SUPPLIER_TEL` varchar(50) DEFAULT NULL COMMENT '供应商联系电话',
  `SUPPLIER_ADD` varchar(1000) DEFAULT NULL COMMENT '供应商地址',
  `SUPPLIER_MAIL` varchar(50) DEFAULT NULL COMMENT '供应商邮箱',
  `BUSSINESS_MAIL` varchar(50) DEFAULT NULL COMMENT '业务对接邮箱',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='供应商';

/*Data for the table `t_sctbs_supplier` */

/*Table structure for table `t_sctbs_supplier_order` */

DROP TABLE IF EXISTS `t_sctbs_supplier_order`;

CREATE TABLE `t_sctbs_supplier_order` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `SHOP_ID` varchar(50) DEFAULT NULL COMMENT '店铺ID',
  `MERGE_ORDER_NO` varchar(50) DEFAULT NULL COMMENT '合并订单编号',
  `SUPPLIER_ID` varchar(50) DEFAULT NULL COMMENT '供应商ID',
  `RECEIVE_MAN` varchar(50) DEFAULT NULL COMMENT '收货人',
  `RECEIVE_ADD` varchar(1000) DEFAULT NULL COMMENT '收货地址',
  `RECEIVE_TEL` varchar(50) DEFAULT NULL COMMENT '收货电话',
  `ORDER_STATUS` varchar(50) DEFAULT NULL COMMENT '订单状态',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='礼品合并订单（供应商）';

/*Data for the table `t_sctbs_supplier_order` */

/*Table structure for table `t_sctbs_sys_param` */

DROP TABLE IF EXISTS `t_sctbs_sys_param`;

CREATE TABLE `t_sctbs_sys_param` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `PARAM_NAME` varchar(200) DEFAULT NULL COMMENT '参数名称',
  `PARAM_KEY` varchar(50) DEFAULT NULL COMMENT '参数代码',
  `PARAM_VALUE` varchar(200) DEFAULT NULL COMMENT '参数值',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统参数表';

/*Data for the table `t_sctbs_sys_param` */

/*Table structure for table `t_sctbs_user_base_info` */

DROP TABLE IF EXISTS `t_sctbs_user_base_info`;

CREATE TABLE `t_sctbs_user_base_info` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `CONVERTIBLE_ACCOUNT_ID` varchar(50) DEFAULT NULL COMMENT '账户ID',
  `ATTACHMENT_ID` varchar(50) DEFAULT NULL COMMENT '用户头像地址',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATE_OFFICE` varchar(50) DEFAULT NULL COMMENT '创建人所属组织',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFYOR` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `LAST_MODIFY_OFFICE` varchar(50) DEFAULT NULL COMMENT '最后修改人所属组织',
  `LAST_MODIFY_TIME` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  `RECORD_VERSION` decimal(10,0) DEFAULT '0' COMMENT '版本号',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '创建人所属品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商城用户基础信息';

/*Data for the table `t_sctbs_user_base_info` */

/*Table structure for table `t_section_partition` */

DROP TABLE IF EXISTS `t_section_partition`;

CREATE TABLE `t_section_partition` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `SECTION_NAME` varchar(200) DEFAULT NULL COMMENT '分段模型',
  `STATUS` varchar(50) DEFAULT NULL COMMENT '状态',
  `MODIFY_DATE` varchar(20) DEFAULT NULL COMMENT '修改日期',
  `MODIFYED` varchar(50) DEFAULT NULL COMMENT '修改人',
  `OWNER` varchar(50) DEFAULT NULL COMMENT '所有人',
  `LOCKED` varchar(50) DEFAULT NULL COMMENT '锁定人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='分段细分';

/*Data for the table `t_section_partition` */

insert  into `t_section_partition`(`ID`,`SECTION_NAME`,`STATUS`,`MODIFY_DATE`,`MODIFYED`,`OWNER`,`LOCKED`) values ('19F15467-8151-4F6A-97F9-7EBE49CEBD56','1','101','2016-07-06 23:45:59','1','1','1'),('8EC7725E-7C7D-4035-982C-2550797B69C2','1','101','2016-08-10 19:41:34','1','1','1');

/*Table structure for table `t_section_partition_var` */

DROP TABLE IF EXISTS `t_section_partition_var`;

CREATE TABLE `t_section_partition_var` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `SECTION_PARITION_ID` varchar(50) DEFAULT NULL COMMENT '分段模型',
  `VAR_NAME` varchar(200) DEFAULT NULL COMMENT '变量名称',
  `SECTION_LOWER_MARK` varchar(50) DEFAULT NULL COMMENT '下限符号',
  `SECTION_LOWER_LIMIT` varchar(20) DEFAULT NULL COMMENT '下限',
  `SECTION_UPPER_MARK` varchar(50) DEFAULT NULL COMMENT '上限符号',
  `SECTION_UPPER_LIMIT` varchar(50) DEFAULT NULL COMMENT '上限',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='分段细分变量';

/*Data for the table `t_section_partition_var` */

insert  into `t_section_partition_var`(`ID`,`SECTION_PARITION_ID`,`VAR_NAME`,`SECTION_LOWER_MARK`,`SECTION_LOWER_LIMIT`,`SECTION_UPPER_MARK`,`SECTION_UPPER_LIMIT`) values ('491E455C-198D-4999-9EB2-4B2C3791CB54','','1','<=','1','>=','100'),('8661F57E-606D-410A-B368-60C0DCE0E262','','1','>=','1','>=','1'),('97018802-1AC1-4145-8BB6-BFFFF3E3EDA8','','1','>=','1','>=','1'),('C4433E77-EED4-47D5-8F23-18E93EA94E76','','1','<=','1','>=','100'),('FED8EA5E-0533-4351-81E5-EF6FD03D8FF2','','1','>=','1','>=','1');

/*Table structure for table `t_sys_user` */

DROP TABLE IF EXISTS `t_sys_user`;

CREATE TABLE `t_sys_user` (
  `user_id` char(36) NOT NULL,
  `user_name` varchar(30) NOT NULL COMMENT '用户名',
  `password` varchar(60) DEFAULT NULL COMMENT 'MD5加密密码',
  `user_type` char(1) DEFAULT NULL COMMENT '用户类型 1：系统管理员 2：开发者',
  `last_logon_time` char(14) DEFAULT NULL COMMENT '最后登录时间',
  `last_logon_ip` varchar(100) DEFAULT NULL COMMENT '最后登录IP',
  `status` char(1) DEFAULT NULL COMMENT '1：正常 2：锁定',
  `create_time` char(14) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`),
  KEY `idx_sys_user_name` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='平台系统用户表,保存平台管理员用户,开发人员用户的信息.';

/*Data for the table `t_sys_user` */

insert  into `t_sys_user`(`user_id`,`user_name`,`password`,`user_type`,`last_logon_time`,`last_logon_ip`,`status`,`create_time`) values ('CCEFD76F-5411-4CB3-BCDB-90A9F61CCC2B','1','1','1','20120101120101','1','1','20120101120101');

/*Table structure for table `t_test` */

DROP TABLE IF EXISTS `t_test`;

CREATE TABLE `t_test` (
  `COL1` decimal(10,0) DEFAULT '0',
  `COL2` float DEFAULT '0',
  `COL3` int(11) DEFAULT '0',
  `COL4` datetime DEFAULT NULL,
  `COL5` varchar(50) NOT NULL,
  `COL6` char(1) DEFAULT '0',
  PRIMARY KEY (`COL5`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_test` */

/*Table structure for table `t_test_copy` */

DROP TABLE IF EXISTS `t_test_copy`;

CREATE TABLE `t_test_copy` (
  `COL1` decimal(10,0) DEFAULT '0',
  `COL2` float DEFAULT '0',
  `COL3` int(11) DEFAULT '0',
  `COL4` datetime DEFAULT NULL,
  `COL5` varchar(50) NOT NULL,
  `COL6` char(1) DEFAULT '0',
  PRIMARY KEY (`COL5`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_test_copy` */

/*Table structure for table `v_cst_out_user` */

DROP TABLE IF EXISTS `v_cst_out_user`;

CREATE TABLE `v_cst_out_user` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `USER_ID` varchar(50) DEFAULT NULL COMMENT '用户账号',
  `REAL_NAME` varchar(200) DEFAULT NULL COMMENT '用户名称',
  `USER_TYPE` varchar(50) DEFAULT NULL COMMENT '用户类型',
  `ENABLE` varchar(1) DEFAULT NULL COMMENT '是否启用',
  `BEGIN_TIME` varchar(20) DEFAULT NULL COMMENT '启用时间',
  `STOP_TIME` varchar(20) DEFAULT NULL COMMENT '停用时间',
  `PASSWORD` varchar(60) DEFAULT NULL COMMENT '密码',
  `SALT` varchar(50) DEFAULT NULL COMMENT '盐值',
  `LAST_PWD_TIME` varchar(20) DEFAULT NULL COMMENT '密码最后更新时间',
  `SUPPLIER_ID` varchar(50) DEFAULT NULL COMMENT '供应商ID',
  `DELIVER_ID` varchar(50) DEFAULT NULL COMMENT '物流ID',
  `DEALER_ID` varchar(50) DEFAULT NULL COMMENT '经销商ID',
  `SHOP_ID` varchar(50) DEFAULT NULL COMMENT '店铺ID',
  `CHILD_DEALER_ID` varchar(50) DEFAULT NULL COMMENT '子经销商ID',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` varchar(20) DEFAULT NULL COMMENT '修改时间',
  `DELETED` varchar(1) DEFAULT NULL COMMENT '逻辑删除标志',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '品牌',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='外部用户视图';

/*Data for the table `v_cst_out_user` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
