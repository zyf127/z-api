-- 创建库
create database if not exists z_api;

-- 切换库
use z_api;

-- 用户表
create table user
(
    id            bigint auto_increment comment 'id'
        primary key,
    user_name     varchar(256)                           null comment '用户昵称',
    user_account  varchar(256)                           not null comment '账号',
    user_avatar   varchar(1024)                          null comment '用户头像',
    gender        tinyint                                null comment '性别',
    user_role     varchar(256) default 'user'            not null comment '用户角色：user / admin',
    user_password varchar(512)                           not null comment '密码',
    access_key    varchar(512)                           not null comment '签名 access_key',
    secret_key    varchar(512)                           not null comment '签名 secret_key',
    create_time   datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time   datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    is_delete     tinyint      default 0                 not null comment '是否删除',
    constraint uni_user_account
        unique (user_account)
)
    comment '用户';


-- 接口信息表
create table interface_info
(
    id              bigint auto_increment comment '主键'
        primary key,
    name            varchar(256)                       not null comment '名称',
    description     varchar(256)                       null comment '描述',
    url             varchar(512)                       not null comment '接口地址',
    request_params  text                               not null comment '请求参数',
    request_header  text                               null comment '请求头',
    response_header text                               null comment '响应头',
    status          int      default 0                 not null comment '接口状态（0-下线，1-上线）',
    method          varchar(256)                       not null comment '请求类型',
    user_id         bigint                             not null comment '创建人',
    create_time     datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time     datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    is_delete       tinyint  default 0                 not null comment '是否删除(0-未删, 1-已删)'
)
    comment '接口信息';


-- 用户接口关系表
create table user_interface_info
(
    id                bigint auto_increment comment '主键'
        primary key,
    user_id           bigint                             not null comment '调用用户 id',
    interface_info_id bigint                             not null comment '接口 id',
    used_num         int      default 0                 not null comment '已调用次数',
    left_num          int      default 0                 not null comment '剩余调用次数',
    status            int      default 0                 not null comment '0-正常，1-禁用',
    create_time       datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time       datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    is_delete         tinyint  default 0                 not null comment '是否删除(0-未删, 1-已删)'
)
    comment '用户接口关系';

