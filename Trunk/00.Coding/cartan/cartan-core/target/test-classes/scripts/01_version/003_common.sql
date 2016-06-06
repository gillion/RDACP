
/**
1.新增t_upload_file表，用于保存上传的文件的元数据信息（文件内容保存到硬盘中）
 */
drop table if exists t_upload_file;

/*==============================================================*/
/* Table: t_upload_file                                         */
/*==============================================================*/
create table t_upload_file
(
   id                   char(36) not null,
   file_name            varchar(100) comment '原文件名称',
   file_suffix          varchar(30) comment '文件后缀名',
   file_size            int comment '文件大小，单位为字节',
   file_status          char(1) comment '0：临时状态 1：持久状态',
   create_time          char(14) comment '文件上传时间',
   primary key (id)
);

alter table t_upload_file comment '上传的文件
1）系统所有上传的文件都保存在这个表中；
2）文件上传后，file_status初始';

/*==============================================================*/
/* Index: idx_upload_file_crtime                                */
/*==============================================================*/
create index idx_upload_file_crtime on t_upload_file
(
   create_time
);

/*2. t_app_issue表的url字段删除，新增app_file_id字段（该字段是t_upload_file的外键）*/
alter table  t_app_issue drop column url;
alter table  t_app_issue add column app_file_id char(36);
