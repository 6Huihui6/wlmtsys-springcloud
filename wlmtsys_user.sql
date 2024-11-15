create database if not exists wlmtsys_user;
use wlmtsys_user;

create table wlmtsys_user.user
(
    id          bigint auto_increment
        primary key,
    salt        varchar(32)      null,
    username    varchar(100)     null,
    phone       varchar(11)      null,
    password    varchar(32)      null,
    image       varchar(320)     null,
    sex         tinyint unsigned null,
    create_time datetime         null,
    openid      varchar(200)     null,
    update_time datetime         null
);

