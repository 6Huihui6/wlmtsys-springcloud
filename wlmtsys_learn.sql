create database wlmtsys_learn;
use wlmtsys_learn;

CREATE TABLE IF NOT EXISTS learning (
                                        id INT AUTO_INCREMENT PRIMARY KEY COMMENT '资料ID',
                                        title VARCHAR(255) NOT NULL COMMENT '标题',
                                        description TEXT COMMENT '描述',
                                        uploader VARCHAR(255) NOT NULL COMMENT '上传者',
                                        create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '上传时间',
                                        file_type VARCHAR(50) COMMENT '文件类型',
                                        file_size INT COMMENT '文件大小（字节）',
                                        url VARCHAR(255) COMMENT '文件存储路径'
) COMMENT='学习资料表';

create table wlmtsys_learn.channel
(
    id        int auto_increment
        primary key,
    name      varchar(255) null,
    parent_id int          null
);

INSERT INTO wlmtsys_learn.channel (id, name, parent_id) VALUES (1, '考研考公', 0);
INSERT INTO wlmtsys_learn.channel (id, name, parent_id) VALUES (2, '技术', 0);
INSERT INTO wlmtsys_learn.channel (id, name, parent_id) VALUES (3, '生活', 0);
INSERT INTO wlmtsys_learn.channel (id, name, parent_id) VALUES (4, '书籍', 0);
INSERT INTO wlmtsys_learn.channel (id, name, parent_id) VALUES (5, '四级六级', 0);
INSERT INTO wlmtsys_learn.channel (id, name, parent_id) VALUES (6, 'java', 2);
INSERT INTO wlmtsys_learn.channel (id, name, parent_id) VALUES (7, 'python', 2);
INSERT INTO wlmtsys_learn.channel (id, name, parent_id) VALUES (8, 'ai', 2);
INSERT INTO wlmtsys_learn.channel (id, name, parent_id) VALUES (9, '算法', 2);
INSERT INTO wlmtsys_learn.channel (id, name, parent_id) VALUES (10, '小程序', 2);
INSERT INTO wlmtsys_learn.channel (id, name, parent_id) VALUES (11, 'vue', 2);
INSERT INTO wlmtsys_learn.channel (id, name, parent_id) VALUES (12, '美食', 3);
INSERT INTO wlmtsys_learn.channel (id, name, parent_id) VALUES (13, '情感', 3);
INSERT INTO wlmtsys_learn.channel (id, name, parent_id) VALUES (14, '鸡汤', 3);
INSERT INTO wlmtsys_learn.channel (id, name, parent_id) VALUES (15, '游戏', 3);
INSERT INTO wlmtsys_learn.channel (id, name, parent_id) VALUES (16, '谈情小说', 4);
INSERT INTO wlmtsys_learn.channel (id, name, parent_id) VALUES (17, '学习书籍', 4);
INSERT INTO wlmtsys_learn.channel (id, name, parent_id) VALUES (18, '武侠小说', 4);
INSERT INTO wlmtsys_learn.channel (id, name, parent_id) VALUES (19, '四级', 5);
INSERT INTO wlmtsys_learn.channel (id, name, parent_id) VALUES (20, '六级', 5);
INSERT INTO wlmtsys_learn.channel (id, name, parent_id) VALUES (21, '考研', 1);
INSERT INTO wlmtsys_learn.channel (id, name, parent_id) VALUES (22, '考公', 1);
