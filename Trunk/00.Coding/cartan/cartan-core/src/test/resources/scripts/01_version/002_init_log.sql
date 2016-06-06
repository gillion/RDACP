/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2013/6/20 17:35:17                           */
/*==============================================================*/

drop table if exists cartan_log.t_log_activity;

drop table if exists cartan_log.t_log_notification;

drop table if exists cartan_log.t_log_sms;

/*==============================================================*/
/* Table: t_log_activity                                        */
/*==============================================================*/
create table cartan_log.t_log_activity
(
   id                   bigint not null,
   app_name             varchar(30) comment '应用ID',
   app_version          varchar(10) comment '应用版本',
   activity             varchar(10) comment '活动类型（表码）
            init 		Application initialization
            login 		Successful authentication using the application
            logout                      User logout
            call                           Procedure call to an adapter',
   app_user_id          varchar(40) comment '应用用户',
   service_name         varchar(100) comment '服务名',
   service_version      varchar(2) comment '服务版本',
   user_agent           varchar(200) comment 'HTTP用户代理，从HTTP头获取',
   session_id           varchar(40) comment '会话ID',
   ip_address           varchar(30) comment 'IP地址',
   device_id            varchar(40) comment '设备唯一ID',
   device_model         varchar(30) comment '设备品牌',
   device_os            varchar(30) comment '设备操作系统',
   create_time          bigint comment '毫秒数',
   primary key (id)
)
CHARSET=utf8;

/*==============================================================*/
/* Index: idx_log_act_crtime                                    */
/*==============================================================*/
create index idx_log_act_crtime on cartan_log.t_log_activity
(
   create_time
);

/*==============================================================*/
/* Table: t_log_notification                                    */
/*==============================================================*/
create table cartan_log.t_log_notification
(
   id                   bigint not null,
   app_name             varchar(30),
   device_id            varchar(40),
   os_name              varchar(30) comment '运操作系统类型',
   channel_name         varchar(30) comment '消息频道',
   mediator_name        varchar(30) comment '第三方推送平台',
   sender_id            char(36) comment '系统用户,可为空',
   create_time          bigint comment '创建时间，单位为毫秒',
   primary key (id)
)
CHARSET=utf8;

/*==============================================================*/
/* Index: idx_log_nitif_crtime                                  */
/*==============================================================*/
create index idx_log_nitif_crtime on cartan_log.t_log_notification
(
   create_time
);

/*==============================================================*/
/* Table: t_log_sms                                             */
/*==============================================================*/
create table cartan_log.t_log_sms
(
   id                   bigint not null,
   app_name             varchar(30),
   phone_num            varchar(20),
   channel_name         varchar(30) comment '消息频道',
   mediator_name        varchar(30) comment '第三方推送平台',
   message_count        int,
   sender_id            varchar(40),
   create_time          bigint comment '创建时间，单位为毫秒',
   primary key (id)
)
CHARSET=utf8;

/*==============================================================*/
/* Index: idx_log_sms_crtime                                    */
/*==============================================================*/
create index idx_log_sms_crtime on cartan_log.t_log_sms
(
   create_time
);

