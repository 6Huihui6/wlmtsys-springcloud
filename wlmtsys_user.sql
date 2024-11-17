create database if not exists wlmtsys_user;
use wlmtsys_user;

create table wlmtsys_user.user
(
    id          bigint auto_increment
        primary key,
    salt        varchar(32)       null,
    username    varchar(100)      null,
    cell_phone  varchar(11)       null,
    password    varchar(32)       null,
    image       varchar(320)      null,
    sex         tinyint unsigned  null,
    create_time datetime          null,
    openid      varchar(200)      null,
    update_time datetime          null,
    type        tinyint default 3 null comment '用户类型',
    status      tinyint default 1 null comment '0---禁用'
);





create table user_detail
(
    user_id       int auto_increment comment '关联用户id'
        primary key,
    type          tinyint     default 2                 null comment '用户类型：1-员工, 2-普通学员，3-老师',
    name          varchar(64) default ''                null comment '名字',
    gender        tinyint     default 0                 not null comment '性别：0-男性，1-女性',
    icon          varchar(255)                          null comment '头像地址',
    email         varchar(255)                          null comment '邮箱',
    qq            varchar(18)                           null comment 'QQ号码',
    birthday      date                                  null comment '生日',
    job           varchar(32)                           null comment '岗位',
    province      varchar(32)                           null comment '省',
    city          varchar(32)                           null comment '市',
    district      varchar(32)                           null comment '区',
    intro         varchar(255)                          null comment '个人介绍',
    photo         varchar(255)                          null comment '形象照地址',
    role_id       bigint                                not null comment '角色id',
    create_time   datetime    default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time   datetime    default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    creater       bigint                                null comment '创建者id',
    updater       bigint      default 0                 null comment '更新者id',
    dep_id        bigint      default 0                 not null comment '部门id'
)
    comment '教师详情表';

create fulltext index name_idx
    on user_detail (name);


