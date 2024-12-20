-- 创建数据库，如果不存在则创建
CREATE DATABASE IF NOT EXISTS wlmtsys_post;
-- 使用数据库
USE wlmtsys_post;

-- 创建 post 表，如果不存在则创建
CREATE TABLE `post` (
                        `post_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '帖子ID',
                        `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
                        `title` varchar(255) DEFAULT NULL COMMENT '标题',
                        `content` text COMMENT '帖子内容',
                        `created_time` datetime DEFAULT NULL COMMENT '发帖时间',
                        `updated_time` datetime DEFAULT NULL COMMENT '更新时间',
                        `like` int(11) DEFAULT NULL COMMENT '点赞数',
                        `is_deleted` int(11) DEFAULT NULL COMMENT '是否删除，0未删除，1已删除',
                        `collection` int(11) DEFAULT NULL COMMENT '收藏数',
                        `forward` int(11) DEFAULT NULL COMMENT '转发数',
                        `channel` int(11) DEFAULT NULL COMMENT '帖子频道',
                        `labels` varchar(255) DEFAULT NULL COMMENT '标签',
                        `views` int(11) DEFAULT NULL COMMENT '浏览量',
                        `heat` int(11) DEFAULT NULL COMMENT '热度',
                        `status` int(11) DEFAULT NULL COMMENT '帖子状态，1审核失败,2审核通过，3已发布',
                        `publish_time` date DEFAULT NULL COMMENT '定时发布时间，不定时则为空',
                        `reason` varchar(255) DEFAULT NULL COMMENT '拒绝理由',
                        PRIMARY KEY (`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='帖子表';

-- 为 userId 添加索引
CREATE INDEX idx_user_id ON post(user_id);

-- 为 status 添加索引
CREATE INDEX idx_status ON post(status);

-- 为 createdTime 添加索引
CREATE INDEX idx_created_time ON post(created_time);

-- 为 updatedTime 添加索引
CREATE INDEX idx_updated_time ON post(updated_time);

-- 为 channel 添加索引
CREATE INDEX idx_channel ON post(channel);

-- 为 publishTime 添加索引
CREATE INDEX idx_publish_time ON post(publish_time);

ALTER TABLE `post`
    ADD FULLTEXT(content);

create table if not exists images
(
    id       int  not null comment '图片id'
        primary key,
    post_id int  null comment '帖子id',
    url      text null comment '链接'
);


create table wlmtsys_post.view_records
(
    id        int auto_increment
        primary key,
    user_id   int                                not null,
    post_id   int                                not null,
    view_time datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP,
    constraint unique_user_post
        unique (user_id, post_id)
);

create table wlmtsys_post.channel
(
    id        int auto_increment
        primary key,
    name      varchar(255) null,
    parent_id int          null
);

create table points_board
(
    id      bigint   not null comment '榜单id'
        primary key,
    post_id bigint   not null comment '帖子id',
    points  int      not null comment '积分值',
    `rank`  tinyint  not null comment '名次，只记录赛季前100',
    season  smallint not null comment '赛季，例如 1,就是第一赛季，2-就是第二赛季',
    constraint idx_season_user
        unique (season, post_id)
)
    comment '积分榜单' charset = utf8mb4
                         row_format = DYNAMIC;


create table points_record
(
    id          bigint auto_increment comment '积分记录表id'
        primary key,
    post_id     bigint                             not null comment '帖子id',
    type        tinyint                            not null comment '积分方式：1-课程学习，2-每日签到，3-课程问答， 4-课程笔记，5-课程评价',
    points      tinyint                            not null comment '积分值',
    create_time datetime default CURRENT_TIMESTAMP not null comment '创建时间'
)
    comment '学习积分记录，每个月底清零' charset = utf8mb4
                                        row_format = DYNAMIC;

create index idx_create_time
    on points_record (create_time);

create index idx_user_id
    on points_record (post_id, type);



