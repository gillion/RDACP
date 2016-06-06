/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2013/6/20 17:32:35                           */
/*==============================================================*/

drop table if exists cartan_common.t_app;

drop table if exists cartan_common.t_app_issue;

drop table if exists cartan_common.t_channel_device;

drop table if exists cartan_common.t_channel_user;

drop table if exists cartan_common.t_code_item;

drop table if exists cartan_common.t_code_table;

drop table if exists cartan_common.t_device;

drop table if exists cartan_common.t_device_app;

drop table if exists cartan_common.t_msg_channel;

drop table if exists cartan_common.t_msg_mediator;

drop table if exists cartan_common.t_rpt_activity;

drop table if exists cartan_common.t_rpt_activity30;

drop table if exists cartan_common.t_rpt_notification;

drop table if exists cartan_common.t_rpt_notification30;

drop table if exists cartan_common.t_rpt_sms;

drop table if exists cartan_common.t_rpt_sms30;

drop table if exists cartan_common.t_service;

drop table if exists cartan_common.t_service_acl;

drop table if exists cartan_common.t_service_issue;

drop table if exists cartan_common.t_sys_parameter;

drop table if exists cartan_common.t_sys_user;

/*==============================================================*/
/* Table: t_app                                                 */
/*==============================================================*/
create table cartan_common.t_app
(
   app_name             varchar(30) not null comment '应用名称(英文代号，唯一)',
   app_label            varchar(60) comment '应用标识名',
   appkey               varchar(36) comment '应用键',
   secret               varchar(30) comment '密钥，30位随机串',
   description          varchar(200) comment '描述',
   author               char(36) not null comment '申请者',
   create_time          char(14) not null comment '创建时间',
   status               char(1) comment '状态 1：未审核 2：审核通过 3：不通过',
   auditor              char(36) comment '审核者',
   audit_info           varchar(500) comment '审核意见',
   audit_time           char(14) comment '审核时间',
   curr_version         varchar(10) comment '最新版本',
   primary key (app_name),
   key ak_app_appkey (appkey)
)
CHARSET=utf8;

/*==============================================================*/
/* Index: idx_app_crtime                                        */
/*==============================================================*/
create index idx_app_crtime on cartan_common.t_app
(
   create_time
);

/*==============================================================*/
/* Table: t_app_issue                                           */
/*==============================================================*/
create table cartan_common.t_app_issue
(
   id                   char(36) not null,
   app_name             varchar(30) comment '应用名称(英文代号，唯一)',
   app_version          varchar(10) not null comment '产品版本号',
   inner_version        varchar(30) not null comment '内部版本号',
   released             char(1) not null comment '是否发布',
   locked               char(1) comment '是否锁定，锁定后不可用',
   url                  varchar(100) not null comment '包URL',
   create_time          char(14) not null comment '创建时间',
   issue_time           char(14) comment '发布时间',
   primary key (id)
)
CHARSET=utf8;

/*==============================================================*/
/* Index: idx_app_issue_appname                                 */
/*==============================================================*/
create index idx_app_issue_appname on cartan_common.t_app_issue
(
   app_name
);

/*==============================================================*/
/* Table: t_channel_device                                      */
/*==============================================================*/
create table cartan_common.t_channel_device
(
   id                   char(36) not null,
   channel_user_id      char(36) comment '频道订阅ID',
   device_uid           varchar(40) not null comment '移动设备唯一标识，如果是消息推送频道，则必须',
   phone_num            varchar(20) comment '手机号，如果是短信频道，必须',
   create_time          char(14) not null comment '创建时间',
   primary key (id)
)
CHARSET=utf8;

/*==============================================================*/
/* Index: idx_channel_device_userid                             */
/*==============================================================*/
create index idx_channel_device_userid on cartan_common.t_channel_device
(
   channel_user_id
);

/*==============================================================*/
/* Table: t_channel_user                                        */
/*==============================================================*/
create table cartan_common.t_channel_user
(
   id                   char(36) not null,
   channel_name         varchar(30) comment '频道名，唯一',
   user_id              varchar(40),
   create_time          char(14) comment '订阅时间',
   primary key (id)
)
CHARSET=utf8;

/*==============================================================*/
/* Table: t_code_item                                           */
/*==============================================================*/
create table cartan_common.t_code_item
(
   item_id              char(36) not null,
   code_tab_code        varchar(30) not null comment '字典表代码',
   item_code            varchar(50) not null comment '项目代码',
   item_title           varchar(200) not null comment '项目标识',
   order_no             int not null default 0 comment '排序顺序号',
   primary key (item_id)
)
CHARSET=utf8;

/*==============================================================*/
/* Index: idx_code_item_tabcode                                 */
/*==============================================================*/
create index idx_code_item_tabcode on cartan_common.t_code_item
(
   code_tab_code
);

/*==============================================================*/
/* Table: t_code_table                                          */
/*==============================================================*/
create table cartan_common.t_code_table
(
   code_tab_code        varchar(30) not null comment '字典表代码',
   code_tab_title       varchar(100) not null comment '字典表中文名',
   description          varchar(200) comment '备注',
   order_no             int not null default 0 comment '排序顺序号',
   primary key (code_tab_code)
)
CHARSET=utf8;

/*==============================================================*/
/* Table: t_device                                              */
/*==============================================================*/
create table cartan_common.t_device
(
   device_id            varchar(40) not null comment '设备唯一标识ID',
   device_name          varchar(30) comment '设备名称',
   app_user_id          varchar(40) comment '所属者ID',
   app_user_name        varchar(60) comment '所属者',
   manufacturer         varchar(60) comment '制造商，表码',
   model                varchar(30) comment '品牌，表码',
   os_name              varchar(30) comment '操作系统，表码',
   os_version           varchar(30) comment '版本号',
   create_time          char(14) comment '创建时间',
   primary key (device_id)
)
CHARSET=utf8;

/*==============================================================*/
/* Table: t_device_app                                          */
/*==============================================================*/
create table cartan_common.t_device_app
(
   app_issue_id         char(36) not null,
   device_id            varchar(60) not null,
   primary key (app_issue_id, device_id)
)
CHARSET=utf8;

/*==============================================================*/
/* Table: t_msg_channel                                         */
/*==============================================================*/
create table cartan_common.t_msg_channel
(
   channel_name         varchar(30) not null comment '频道名，唯一',
   app_name             varchar(30) comment '应用名称(英文代号，唯一)',
   channel_label        varchar(60) comment '频道标识',
   description          varchar(200) comment '描述',
   total_subscriber     int comment '总订阅者数',
   total_message        bigint comment '总消息数',
   primary key (channel_name)
)
CHARSET=utf8;

/*==============================================================*/
/* Index: idx_msg_channel_appname                               */
/*==============================================================*/
create index idx_msg_channel_appname on cartan_common.t_msg_channel
(
   app_name
);

/*==============================================================*/
/* Table: t_msg_mediator                                        */
/*==============================================================*/
create table cartan_common.t_msg_mediator
(
   mediator_name        varchar(30) not null comment '平台名称',
   mediator_type        char(1) comment '1:短信网关 2:推送消息',
   environment          varchar(20) comment '运行环境，如iphone,android',
   description          varchar(200) comment '描述',
   conf                 varchar(1000) comment '配置信息JSON',
   os                   varchar(30) comment '对应的OS，OS为表码',
   primary key (mediator_name)
)
CHARSET=utf8;

/*==============================================================*/
/* Table: t_rpt_activity                                        */
/*==============================================================*/
create table cartan_common.t_rpt_activity
(
   id                   bigint not null,
   device_id            varchar(40) comment '设备唯一ID',
   app_name             varchar(30) comment '应用名称',
   activity             varchar(10) comment '活动类型（表码）
            init 		Application initialization
            login 		Successful authentication using the application
            logout                      User logout
            call                           Procedure call to an adapter',
   total_count          int comment '短信数',
   report_date          char(8) comment '统计的日期',
   primary key (id)
)
CHARSET=utf8;

/*==============================================================*/
/* Index: idx_rpt_activity_rtpdate                              */
/*==============================================================*/
create index idx_rpt_activity_rtpdate on cartan_common.t_rpt_activity
(
   report_date
);

/*==============================================================*/
/* Table: t_rpt_activity30                                      */
/*==============================================================*/
create table cartan_common.t_rpt_activity30
(
   id                   bigint not null,
   app_name             varchar(30) comment '应用名称',
   activity             varchar(10) comment '活动类型（表码）
            init 		Application initialization
            login 		Successful authentication using the application
            logout                      User logout
            call                           Procedure call to an adapter',
   device_id            varchar(40) comment '设备唯一ID',
   total_count          int comment '短信数',
   report_date          char(8) comment '统计的日期',
   primary key (id)
)
CHARSET=utf8;

/*==============================================================*/
/* Index: idx_rpt_act30_rptdate                                 */
/*==============================================================*/
create index idx_rpt_act30_rptdate on cartan_common.t_rpt_activity30
(
   report_date
);

/*==============================================================*/
/* Table: t_rpt_notification                                    */
/*==============================================================*/
create table cartan_common.t_rpt_notification
(
   id                   bigint not null,
   app_name             varchar(30),
   channel_name         varchar(30) comment '消息频道',
   device_id            varchar(40),
   mediator_name        varchar(30) comment '第三方推送平台',
   total_count          int comment '短信数',
   report_date          char(8) comment '统计的日期',
   primary key (id)
)
CHARSET=utf8;

/*==============================================================*/
/* Index: idx_rpt_nft_rptdate                                   */
/*==============================================================*/
create index idx_rpt_nft_rptdate on cartan_common.t_rpt_notification
(
   report_date
);

/*==============================================================*/
/* Table: t_rpt_notification30                                  */
/*==============================================================*/
create table cartan_common.t_rpt_notification30
(
   id                   bigint not null,
   channel_name         varchar(30) comment '消息频道',
   app_name             varchar(30),
   device_id            varchar(30),
   mediator_name        varchar(30) comment '第三方推送平台',
   total_count          int comment '短信数',
   report_date          char(8) comment '统计的日期',
   primary key (id)
)
CHARSET=utf8;

/*==============================================================*/
/* Index: idx_rpt_ntf_rptdate                                   */
/*==============================================================*/
create index idx_rpt_ntf_rptdate on cartan_common.t_rpt_notification30
(
   report_date
);

/*==============================================================*/
/* Table: t_rpt_sms                                             */
/*==============================================================*/
create table cartan_common.t_rpt_sms
(
   id                   bigint not null,
   channel_name         varchar(30) comment '消息频道',
   mediator_name        varchar(30) comment '第三方推送平台',
   total_count          int comment '短信数',
   report_date          char(8) comment '统计的日期',
   primary key (id)
)
CHARSET=utf8;

/*==============================================================*/
/* Index: idx_rpt_sms_rptdate                                   */
/*==============================================================*/
create index idx_rpt_sms_rptdate on cartan_common.t_rpt_sms
(
   report_date
);

/*==============================================================*/
/* Table: t_rpt_sms30                                           */
/*==============================================================*/
create table cartan_common.t_rpt_sms30
(
   id                   bigint not null,
   channel_name         varchar(30) comment '消息频道',
   mediator_name        varchar(30) comment '第三方推送平台',
   total_count          int comment '短信数',
   report_date          char(8) comment '统计的日期',
   primary key (id)
)
CHARSET=utf8;

/*==============================================================*/
/* Index: idx_rpt_sms30_rptdate                                 */
/*==============================================================*/
create index idx_rpt_sms30_rptdate on cartan_common.t_rpt_sms30
(
   report_date
);

/*==============================================================*/
/* Table: t_service                                             */
/*==============================================================*/
create table cartan_common.t_service
(
   service_name         varchar(100) not null comment '服务方法名，如users.getUser,',
   service_type         char(1) comment '1:平台级服务 2:应用级服务',
   service_catelog      varchar(30) comment '服务分类,采用分级代码,每层两位代码，如
            01       类1
            0101   类01
            0102   类02
            参见字典表',
   service_label        varchar(30) comment '标识',
   description          varchar(2000) comment '接口说明',
   create_time          char(14) not null comment '创建时间',
   order_no             int comment '排序号',
   primary key (service_name)
)
CHARSET=utf8;

/*==============================================================*/
/* Index: idx_service_catalog                                   */
/*==============================================================*/
create index idx_service_catalog on cartan_common.t_service
(
   service_catelog
);

/*==============================================================*/
/* Table: t_service_acl                                         */
/*==============================================================*/
create table cartan_common.t_service_acl
(
   service_name         varchar(100) not null,
   app_name             varchar(30) not null,
   primary key (service_name, app_name)
)
CHARSET=utf8;

/*==============================================================*/
/* Table: t_service_issue                                       */
/*==============================================================*/
create table cartan_common.t_service_issue
(
   id                   char(36) not null,
   service_name         varchar(100) comment '服务方法名，如users.getUser,',
   version              varchar(2) comment '版本号',
   description          varchar(2000) comment '接口说明',
   released             char(1) not null comment '是否发布',
   locked               char(1) comment '是否锁定，锁定后不可用',
   author               varchar(60),
   create_time          char(14) not null comment '创建时间',
   issue_time           char(14) comment '发布时间',
   primary key (id)
)
CHARSET=utf8;

/*==============================================================*/
/* Index: idx_service_issue_srvname                             */
/*==============================================================*/
create index idx_service_issue_srvname on cartan_common.t_service_issue
(
   service_name
);

/*==============================================================*/
/* Table: t_sys_parameter                                       */
/*==============================================================*/
create table cartan_common.t_sys_parameter
(
   param_name           varchar(30) not null,
   param_value          varchar(200) not null comment '参数值',
   description          varchar(200) comment '备注',
   order_no             int not null default 0 comment '排序顺序号',
   primary key (param_name)
)
CHARSET=utf8;

/*==============================================================*/
/* Table: t_sys_user                                            */
/*==============================================================*/
create table cartan_common.t_sys_user
(
   user_id              char(36) not null,
   user_name            varchar(30) not null comment '用户名',
   password             varchar(60) comment 'MD5加密密码',
   user_type            char(1) comment '用户类型 1：系统管理员 2：开发者',
   last_logon_time      char(14) comment '最后登录时间',
   last_logon_ip        varchar(100) comment '最后登录IP',
   status               char(1) comment '1：正常 2：锁定',
   create_time          char(14) comment '创建时间',
   primary key (user_id)
)
CHARSET=utf8;

/*==============================================================*/
/* Index: idx_sys_user_name                                     */
/*==============================================================*/
create index idx_sys_user_name on cartan_common.t_sys_user
(
   user_name
);

