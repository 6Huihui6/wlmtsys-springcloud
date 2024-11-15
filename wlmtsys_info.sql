create database if not exists wlmtsys_info;
use wlmtsys_info;
create table if not exists wlmtsys_info.teams
(
    id          bigint auto_increment
        primary key,
    depart      varchar(50)                        null,
    name        varchar(50)                        null,
    image       varchar(500)                       null,
    job         varchar(50)                        null,
    `desc`      text                               null,
    core        int                                null,
    info        text                               null,
    create_time datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP
);



INSERT INTO wlmtsys_info.teams (id, depart, name, image, job, `desc`, core, info, create_time) VALUES (2, '1', '陈倩怡', 'https://wlmtsys.com:9000/wlmtsys/2024/09/27/901bb74778b944df8012dabdea59dfe0.jpg', '管理负责人', '<h1>陈倩怡</h1>
                                <div style="display: flex;">
                                <div style="width: 75%;">
                                    <p style="font-size: 20px">专业：信息管理与信息系统</p>
                                    <h2>技能特长：</h2>
                                    <ul>
                                    <li>项目管理</li>
                                    <li>前端界面设计</li>
                                    <li>视频剪辑</li>
                                    <li>新闻稿件撰写</li>
                                    <li>熟练使用Ps/ Mockitt设计前端UI、WPS Office应用。</li>
                                    </ul>
                                </div>
                                <img style="width: 25%;" src="https://wlmtsys.com:9000/wlmtsys/2024/09/27/901bb74778b944df8012dabdea59dfe0.jpg">
                                </div>
                                <h2>获奖情况：</h2><p>获2项软件著作、优秀学生干部、非计算机专业CCT二级证书、CET - 4证书、普通话水平测试等级证书、第十四届“蓝桥杯”大赛软件类校选拔一等奖 、第六届互联网应用开发竞赛一等奖 、第六届微信小程应用开发竞赛一等奖、第一届大数据和人工智能创新创意大赛一等奖、第二届大学生计算机应用能力与信息素养大赛二等奖</p>
                                <h2>实践经历：</h2>
                                <p>实践描述：</p><p>前往云浮市郁南县15个镇街为150多位新农人提供新媒体营销指导，带动1000多户果农就业增收，帮助打造“互联网 + 文旅融合”乡村文化符号，解决营销难题。</p>
                                <p>工作内容：</p><p>作为学生助理及实践团学生负责人，负责团队管理与工作任务的分配，参与实地调研，撰写调研文稿、新闻稿件等，协助指导老师开展新农人电商直播培训。</p>
                                <h2>项目经历：</h2>
                                <h3>国家地理标志产品郁南无核黄皮直播商城小程序</h3>
                                <p>工作内容：</p><p>作为队长组织协调队友完成任务、设计调查问卷、申报各类赛事、赛事跟进、计划书以及各类文稿的统稿。</p>
                                <h3>《心间漫步》日记小程序</h3>
                                <p>项目描述：</p><p>《心间漫步》日记小程序，集社交互动与个人管理于一体，提供一个简洁而全面的情感交流与记录平台。在现代生活快节奏的背景下，我们创建了一个温馨、互动的线上社区，让用户可以自由地表达心情，分享体验。社交互动模块包括心间广场和治愈卡片，用户可以在这里阅读、评论、互动，通过治愈卡片查看和分享心情体验。个人管理模块涵盖日记编写、心晴日记和个人中心，用户可以创建、编辑、发布个人日记，记录和管理心情状态。通过《心间漫步》，我们期望能够帮助用户更好地理解和管理自己的情绪，增强自我认知，同时也提供一个温暖、互动的社区，让用户在分享和交流中找到共鸣和支持。</p>
                                <p>工作内容：</p><p>项目负责人，团队管理、系统功能设计、UI设计、计划书、操作说明书撰写。</p>
                                <h3>“捉友DrawU”——LLM + 桌游社交平台</h3>
                                <p>项目描述：</p><p>“捉友DrawU”——LLM + 桌游社交平台结合AI技术简化规则理解，提供智能推荐和规则解读，为桌游爱好者提供一站式社交体验；首创桌游社交模式，集成了数字化和大数据技术，实现精准的桌游推荐和服务，满足用户个性化需求；通过简化用户上手流程，捉友提升用户体验，填补行业空白，引领全新的社交方式。该平台包含智能助手、活动列表、桌游列表、帖子、资讯等功能模块，为桌游爱好者提供丰富的信息和便捷的交流渠道。该项目目标用户群体包括桌游爱好者、桌游店和桌游厂商，满足他们寻找桌游信息、推广桌游店和推广新桌游的需求。随着桌游市场的快速发展，该项目具有广阔的市场前景，将为桌游爱好者提供一站式的社交体验，同时为桌游店和厂商提供推广渠道。</p>
                                <p>工作内容：</p><p>项目负责人，团队建设与人员管理、系统功能设计、UI设计、海报设计、计划书编写、操作说明书撰写、赛事申报与跟进。</p>', 99, '专业：信息管理与信息系统
                    技能特长：
                    项目管理、前端界面设计、视频剪辑、新闻稿件撰写；
                    熟练使用Ps、 Mockitt设计前端UI、WPS Office应用。
                    实践经历
                    实践描述：前往云浮市郁南县15个镇街为150多位新农人提供新媒体营销指导，带动1000多户果农就业增收，帮助打造“互联网 + 文旅融合”乡村文化符号，解决营销难题。
                    工作内容：作为学生助理及实践团学生负责人，负责团队管理与工作任务的分配，参与实地调研，撰写调研文稿、新闻稿件等，协助指导老师开展新农人电商直播培训。
                    项目经历：
                    1.项目描述：项目名称：国家地理标志产品郁南无核黄皮直播商城小程序；
                    工作内容：作为队长组织协调队友完成任务、设计调查问卷、申报各类赛事、赛事跟进、计划书以及各类文稿的统稿。
                    2.项目描述：《心间漫步》日记小程序，集社交互动与个人管理于一体，提供一个简洁而全面的情感交流与记录平台。在现代生活快节奏的背景下，我们创建了一个温馨、互动的线上社区，让用户可以自由地表达心情，分享体验。社交互动模块包括心间广场和治愈卡片，用户可以在这里阅读、评论、互动，通过治愈卡片查看和分享心情体验。个人管理模块涵盖日记编写、心晴日记和个人中心，用户可以创建、编辑、发布个人日记，记录和管理心情状态。通过《心间漫步》，我们期望能够帮助用户更好地理解和管理自己的情绪，增强自我认知，同时也提供一个温暖、互动的社区，让用户在分享和交流中找到共鸣和支持。
                    工作内容：项目负责人，团队管理、系统功能设计、UI设计、计划书、操作说明书撰写。
                    3.项目描述：“捉友DrawU”——LLM + 桌游社交平台结合AI技术简化规则理解，提供智能推荐和规则解读，为桌游爱好者提供一站式社交体验；首创桌游社交模式，集成了数字化和大数据技术，实现精准的桌游推荐和服务，满足用户个性化需求；通过简化用户上手流程，捉友提升用户体验，填补行业空白，引领全新的社交方式。该平台包含智能助手、活动列表、桌游列表、帖子、资讯等功能模块，为桌游爱好者提供丰富的信息和便捷的交流渠道。该项目目标用户群体包括桌游爱好者、桌游店和桌游厂商，满足他们寻找桌游信息、推广桌游店和推广新桌游的需求。随着桌游市场的快速发展，该项目具有广阔的市场前景，将为桌游爱好者提供一站式的社交体验，同时为桌游店和厂商提供推广渠道。
                    工作内容：项目负责人，团队建设与人员管理、系统功能设计、UI设计、海报设计、计划书编写、操作说明书撰写、赛事申报与跟进。
                    获奖情况：获2项软件著作、优秀学生干部、非计算机专业CCT二级证书、CET - 4证书、普通话水平测试等级证书、第十四届“蓝桥杯”大赛软件类校选拔一等奖 、第六届互联网应用开发竞赛一等奖 、第六届微信小程应用开发竞赛一等奖、第一届大数据和人工智能创新创意大赛一等奖、第二届大学生计算机应用能力与信息素养大赛二等奖\',
          ', '2024-10-08 09:27:00');
INSERT INTO wlmtsys_info.teams (id, depart, name, image, job, `desc`, core, info, create_time) VALUES (3, '1', '王鹏', 'https://wlmtsys.com:9000/wlmtsys/2024/09/27/4b12009a3b604afebab9bc5e832f97fd.jpg', '管理负责人', '<h1>王鹏</h1>
                                <div style="display: flex;">
                                <div style="width: 75%;">
                                    <p style="font-size: 20px">专业：信息管理与信息系统</p>
                                    <h2>技能特长：</h2>
                                    <ul>
                                    <li>视频剪辑</li>
                                    <li>电商运营（铺货、淘宝店铺装修等）</li>
                                    <li>公众号、APP、视频号后台管理</li>
                                    <li>会议稿件撰写（会议纪要、会议记录、人员表单、新闻稿、推文）</li>
                                    <li>常见ERP系统操作、spss工具使用</li>
                                    <li>电烙铁焊接、电脑车模具线路设计</li>
                                    <li>财务报表和报价单制作撰写</li>
                                    </ul>
                                </div>
                                <img style="width: 25%;" src="https://wlmtsys.com:9000/wlmtsys/2024/09/27/4b12009a3b604afebab9bc5e832f97fd.jpg">
                                </div>
                                <h2>获奖情况：</h2>
                                <ul>
                                    <li>广东白云学院“电锯辩论赛新生杯”优秀团队奖</li>
                                    <li>第八届中国国际“互联网+”大学生创新创业大赛院三等奖</li>
                                    <li>广东省国防教育专题短视频竞赛二等奖</li>
                                    <li>广东白云学院国防教育教导大队月度宣传之星</li>
                                    <li>第九届互联网+红旅赛道校二等奖</li>
                                    <li>第九届互联网+校一等奖</li>
                                    <li>广东省众创杯大学生启航赛团队组优胜奖</li>
                                    <li>三创赛数据分析赛道校二等奖</li>
                                </ul>
                                <h2>实践经历：</h2>
                                <p>实践描述：</p><p>奶茶店员工、皮具加工</p>
                                <p>工作内容：</p><p>备料、打包、出品、前台、台面手工、电脑车加工</p>
                                <h2>项目经历：</h2>
                                <h3>黄埔百年百人志项目成员</h3>
                                <p>工作内容：</p><p>负责项目审核工作，素材收集，网站后台管理，剪辑人员工作进展管理。</p>
                                <h3>易而戴项目负责人</h3>
                                <p>工作内容：</p><p>项目为白云学院与广州泛宇医疗科技有限公司合作项目，项目学生发展营销模块开发与推广课程制作推广。</p>
                                <h3>港珠澳大桥旅游开发项目负责人</h3>
                                <p>工作内容：</p><p>负责项目的整体规划和执行，撰写项目论文，进行数据整理与分析，为大桥的旅游开发提供策略支持，获港珠澳大桥管理局党委副书记韦东庆指导。
                                <h3>数智化营销云营销成员</h3>
                                <p>工作内容：</p><p>收集营销类素材，制作项目PPT，有效支持营销活动的开展，为企业提供数智化品牌营销解决方案，中清数据旗下项目。</p>', 99, '专业：信息管理与信息系统
                    技能特长：
                    视频剪辑，电商运营（铺货、淘宝店铺装修等），公众号、APP、视频号后台管理，会议稿件撰写（会议纪要、会议记录、人员表单、新闻稿、推文）、常见ERP系统操作、spss工具使用、电烙铁焊接、电脑车模具线路设计、财务报表和报价单制作撰写
                    实践经历：奶茶店员工、皮具加工
                    工作内容：备料、打包、出品、前台、台面手工、电脑车加工
                    项目经历：黄埔百年百人志项目成员 
                    工作内容：负责项目审核工作，素材收集，网站后台管理，剪辑人员工作进展管理。
                    易而戴项目负责人 
                    项目为白云学院与广州泛宇医疗科技有限公司合作项目，项目学生发展营销模块开发与推广课程制作推广。
                    港珠澳大桥旅游开发项目负责人 
                    负责项目的整体规划和执行，撰写项目论文，进行数据整理与分析，为大桥的旅游开发提供策略支持，获港珠澳大桥管理局党委副书记韦东庆指导。
                    数智化营销云营销成员 
                    收集营销类素材，制作项目PPT，有效支持营销活动的开展，为企业提供数智化品牌营销解决方案，中清数据旗下项目。
                    获奖情况：
                    广东白云学院“电锯辩论赛新生杯”优秀团队奖
                    第八届中国国际“互联网+”大学生创新创业大赛院三等奖
                    广东省国防教育专题短视频竞赛二等奖
                    广东白云学院国防教育教导大队月度宣传之星
                    第九届互联网+红旅赛道校二等奖
                    第九届互联网+校一等奖
                    广东省众创杯大学生启航赛团队组优胜奖
                    三创赛数据分析赛道校二等奖\'', '2024-10-08 09:27:48');
INSERT INTO wlmtsys_info.teams (id, depart, name, image, job, `desc`, core, info, create_time) VALUES (4, '3', '吴铭辉
', 'https://wlmtsys.com:9000/wlmtsys/2024/09/27/89f8ec5d14234ef4acb4ed75ed04b636.jpg', '后端开发', '<h1>吴铭辉</h1>
                                <div style="display: flex;">
                                    <div style="width: 75%;">
                                        <p style="font-size: 20px">专业：软件工程</p>
                                        <h2>技能特长：</h2>
                                        <ul>
                                            <li>Java后端开发</li>
                                            <li>小程序开发</li>
                                            <li>Vue前端开发</li>
                                            <li>拥有Maven构建项目的能力</li>
                                            <li>了解面向对象基础和设计模式</li>
                                            <li>熟悉使用关系数据库MySQL</li>
                                            <li>熟悉主流开源开发框架</li>
                                            <li>熟悉中间件Redis以及工具Git</li>
                                            <li>熟悉HTML5、CSS3、JavaScript和Vue</li>
                                        </ul>
                                    </div>
                                    <img style="width: 25%;" src="https://wlmtsys.com:9000/wlmtsys/2024/09/27/89f8ec5d14234ef4acb4ed75ed04b636.jpg">
                                </div>
                                <h2>获奖情况：</h2>
                                <ul>
                                    <li>2022-2023国家励志奖学金</li>
                                    <li>第三届校级职云杯大赛二等奖</li>
                                    <li>2022-2023学校三等奖学金</li>
                                    <li>2022-2023优秀大学生称号</li>
                                    <li>第五届数据库设计一等奖</li>
                                    <li>第一届创意海报设计二等奖</li>
                                    <li>2022-2023网页设计大赛三等奖</li>
                                    <li>二十五届校运会4*400接力比赛第三名</li>
                                    <li>2022-2023暑假社会实践活动三等奖</li>
                                    <li>多媒体课件三等奖</li>
                                </ul>
                                <h2>项目经历：</h2>
                                <h3>“飞来职Freelance——基于LLM的零工招聘平台</h3>
                                <p>项目介绍：在当今数字化时代，劳动力市场日益灵活化和多样化。本项目旨在搭建一个创新的零工平台，以解决这些痛点，满足供需双方的需求。</p>
                                <p>工作内容：</p>
                                <ul>
                                    <li>后台管理系统开发</li>
                                    <li>后端Spring Boot开发</li>
                                    <li>前端小程序协助开发</li>
                                    <li>数据库设计</li>
                                </ul>
                                <p>作品链接：<a href="https://gitee.com/huijinhui/freelance-springboot" target="_blank">https://gitee.com/huijinhui/freelance-springboot</a></p>
', 98, '专业：软件工程1

技能特长：
Java后端开发
小程序开发
Vue前端开发
拥有Maven构建项目的能力
了解面向对象基础和设计模式
熟悉使用关系数据库MySQL
熟悉主流开源开发框架
熟悉中间件Redis以及工具Git
熟悉HTML5、CSS3、JavaScript和Vue

获奖情况：
2022-2023国家励志奖学金
第三届校级职云杯大赛二等奖
2022-2023学校三等奖学金
2022-2023优秀大学生称号
第五届数据库设计一等奖
第一届创意海报设计二等奖
2022-2023网页设计大赛三等奖
二十五届校运会4*400接力比赛第三名
2022-2023暑假社会实践活动三等奖
多媒体课件三等奖
项目经历：
“飞来职Freelance——基于LLM的零工招聘平台
项目介绍：在当今数字化时代，劳动力市场日益灵活化和多样化。本项目旨在搭建一个创新的零工平台，以解决这些痛点，满足供需双方的需求。

工作内容：

后台管理系统开发
后端Spring Boot开发
前端小程序协助开发
数据库设计
作品链接：https://gitee.com/huijinhui/freelance-springboot', '2024-10-08 09:28:47');
INSERT INTO wlmtsys_info.teams (id, depart, name, image, job, `desc`, core, info, create_time) VALUES (10, '1', '廖耀华', 'https://wlmtsys.com:9000/wlmtsys/2024/09/27/9f50f75829804cc18f7f805bb5760c57.jpg', '技术负责人', '<h1>廖耀华</h1>
                                <div style="display: flex;">
                                <div style="width: 75%;">
                                    <p style="font-size: 20px">专业：数据科学与大数据技术</p>
                                    <h2>技能特长：</h2>
                                    <ul>
                                    <li>小程序开发</li>
                                    <li>Vue前端开发</li>
                                    <li>Java后端开发</li>
                                    <li>Python后端开发</li>
                                    <li>熟练使用Ps/Mockitt设计前端UI</li>
                                    <li>熟练使用WPS Office应用</li>
                                    </ul>
                                </div>
                                <img style="width: 25%;" src="https://wlmtsys.com:9000/wlmtsys/2024/09/27/9f50f75829804cc18f7f805bb5760c57.jpg">
                                </div>
                                <h2>获奖情况：</h2>
                                <ul>
                                    <li>《心间漫步》日记小程序V1.0计算机软件著作权登记证书</li>
                                    <li>《基于人工智能课堂教学智慧评价系统》V1.0计算机软件著作权登记证书</li>
                                    <li>第十四届蓝桥杯全国软件和信息技术专业人才大赛Java组国家级优秀奖</li>
                                    <li>第十四届蓝桥杯全国软件和信息技术专业人才大赛Java组广东省一等奖</li>
                                    <li>第十五届蓝桥杯全国软件和信息技术专业人才大赛Web组广东省三等奖</li>
                                    <li>国家励志奖学金</li>
                                    <li>第六届微信小程序应用开发赛 一等奖</li>
                                    <li>第四届算法设计竞赛 一等奖</li>
                                    <li>第一届数据获取与可视化方案设计竞赛 一等奖</li>
                                    <li>第六届数据分析精神 一等奖</li>
                                    <li>第三届大数据挑战赛 一等奖</li>
                                    <li>第八届网络爬虫竞赛 一等奖</li>
                                    <li>第六届移动互联网应用开发竞赛 一等奖</li>
                                    <li>第六届软件作品竞赛 一等奖</li>
                                    <li>第三届大数据预处理竞赛 一等奖</li>
                                    <li>第十四届“蓝桥杯”校园选拔赛 一等奖</li>
                                    <li>大数据协会创意可视化竞赛 一等奖</li>
                                    <li>第四届数据库设计竞赛 一等奖</li>
                                </ul>
                                <h2>实践经历：</h2>
                                <p>实践描述：</p><p>前往云浮市郁南县15个镇街为150多位新农人提供新媒体营销指导，带动1000多户果农就业增收，帮助打造“互联网 + 文旅融合”乡村文化符号，解决营销难题。</p>
                                <p>工作内容：</p><p>作为学生助理及实践团学生负责人，负责团队管理与工作任务的分配，参与实地调研，撰写调研文稿、新闻稿件等，协助指导老师开展新农人电商直播培训。</p>
                                <h2>项目经历：</h2>
                                <h3>基于人工智能课堂教学智慧评价系统</h3>
                                <p>项目介绍：</p>
                                <p>通过设备获取学生上课情况进行识别以及自动签到，通过数据库连接整理出汇报表进行统计。建立学习平台，方便学生与老师即使进行本节课内容的交流。通过与学习通的连接，方便老师布置作业以及即时统计未完成情况。</p>
                                <p>工作内容：</p>
                                <ul>
                                <li>使用Python PyQt5开发前端页面</li>
                                <li>使用Python PyTest测试软件并上传漏洞</li>
                                </ul>
                                <p>作品链接：<a href="https://gitee.com/huazaiLYH/face-recognition">https://gitee.com/huazaiLYH/face-recognition</a></p>
                                <h3>基于人脸识别的弱势人群护理系统</h3>
                                <p>项目介绍：</p>
                                <p>面向需要特殊关怀的弱势人群的创新技术产品，采用先进的人脸表情识别技术和智能管理系统，该系统通过摄像头收集用户面部表情信息，进行分析和识别，提供针对性的护理服务和支持措施，提高生活质量。</p>
                                <p>工作内容：</p>
                                <ul>
                                <li>负责前端开发与软件测试</li>
                                <li>使用Python PyQt5开发前端页面</li>
                                <li>使用Python PyTest测试软件并上传漏洞</li>
                                </ul>
                                <p>作品链接：<a href="https://gitee.com/huazaiLYH/ai-classroom">https://gitee.com/huazaiLYH/ai-classroom</a></p>
                                <h3>“心间漫步”日记小程序</h3>
                                <p>项目介绍：一个记录心情、图片的日记小程序，可以在广场中上传并分享自己的日记。</p>
                                <p>工作内容：</p>
                                <ul>
                                <li>作为前端开发人员，使用HTML、JavaScript、CSS技术开发前端页面</li>
                                <li>作为后端开发人员，使用Node.js技术开发后端逻辑层</li>
                                <li>作为运维人员，使用微信云开发作为数据库，并主要负责写SQL语句、检测数据库信息</li>
                                <li>统筹小组工作，定时开展例会，检查各人员进度，指名发展方向</li>
                                </ul>
                                <p>作品链接：<a href="https://gitee.com/huazaiLYH/heartwalking">https://gitee.com/huazaiLYH/heartwalking</a></p>
                                <h3>“捉友DrawU”——LLM+桌游社交平台</h3>
                                <p>项目介绍：“捉友DrawU”——LLM+桌游社交平台，结合AI智能助手，简化桌游规则理解，为桌游爱好者提供一站式社交平台，提升用户体验，填补行业空白，引领全新社交方式。</p>
                                <p>工作内容：</p>
                                <ul>
                                <li>作为前端开发人员，使用HTML、JavaScript、CSS技术开发前端页面</li>
                                <li>作为后端开发人员，使用Python Flask技术开发后端逻辑层</li>
                                <li>作为后端开发人员，使用ChatGLM 4.0作为小程序内置AI，负责调试AI</li>
                                <li>作为运维人员，使用MySQL作为数据库，并主要负责写SQL语句、检测数据库信息</li>
                                <li>作为项目负责人，负责撰写创业计划书与活动策划案，并在线下开展项目活动</li>
                                <li>定时开展培训与研讨会，提升小组能力</li>
                                </ul>
                                <p>作品链接：<a href="https://gitee.com/huazaiLYH/drawu">https://gitee.com/huazaiLYH/drawu</a></p>
                                <h3>“飞来职Freelance”——基于LLM的零工招聘平台</h3>
                                <p>项目介绍：在当今数字化时代，劳动力市场日益灵活化和多样化。随着人们工作观念的转变以及企业对弹性用工的需求增加，零工经济迅速崛起。然而，现有的零工市场存在信息不对称、匹配效率低下、权益保障不足等问题。本项目旨在搭建一个创新的零工平台，以解决这些痛点，满足供需双方的需求。</p>
                                <p>工作内容：</p>
                                <ul>
                                <li>作为前端开发人员，使用HTML、JavaScript、CSS技术开发前端页面</li>
                                <li>作为后端开发人员，我使用Java Springboot框架开发后端逻辑层。</li>
                                <li>作为后端开发人员，我使用ChatGLM 4.0作为小程序内置AI。我负责调试AI。</li>
                                <li>作为运维人员，我使用MySQL作为数据库，并主要负责写SQL语句、检测数据库信息。</li>
                                </ul>
                                <p>作品链接：<a href="https://gitee.com/SYxiaofeng/freelance-platform">https://gitee.com/SYxiaofeng/freelance-platform</a></p>
', 99, '专业：数据科学与大数据技术
技能特长：小程序开发、Vue前端开发、Java后端开发、Python后端开发；
熟练使用Ps/Mockitt设计前端UI、WPS Office应用。
项目经历：
项目名称：基于人工智能课堂教学智慧评价系统
项目介绍：通过设备获取学生上课情况进行识别以及自动签到，通过数据库连接整理出汇报表进行统计。 建立学习平台，方便学生与老师即使进行本节课内容的交流。 通过与学习通的连接，方便老师布置作业以及即时统计未完成情况。
工作内容：
1.在前端开发中，我使用Python PyQt5开发前端页面。
2.负责软件测试，我使用Python PyTest测试软件并上传漏洞。
项目经历：
项目名称：基于人脸识别的弱势人群护理系统
项目介绍：面向需要特殊关怀的弱势人群的创新技术产品，采用先进的人脸表情识别技术和智能管理系统，该系统通过摄像头收集用户面部表情信息，进行分析和识别，提供针对性的护理服务和支持措施，提高生活质量。\\n\\
                    工作内容：\\n\\
                    负责前端开发与软件测试。\\n\\
                    1.在前端开发中，我使用Python PyQt5开发前端页面。\\n\\
                    2.负责软件测试，我使用Python PyTest测试软件并上传漏洞。\\n\\
                    作品链接：https://gitee.com/huazaiLYH/ai-classroom\\n\'', '2024-10-08 09:35:11');
INSERT INTO wlmtsys_info.teams (id, depart, name, image, job, `desc`, core, info, create_time) VALUES (11, '3', '李卓峰', 'https://wlmtsys.com:9000/wlmtsys/2024/09/29/278dc25ffc984eb18d7fa468baa5b281.jpg', '前端开发', '<h1>李卓峰</h1>
                                <div style="display: flex;">
                                    <div style="width: 75%;">
                                        <p style="font-size: 20px">专业：软件工程</p>
                                        <h2>技能特长：</h2>
                                        <ul>
                                            <li>微信小程序开发</li>
                                            <li>Vue前端开发</li>
                                            <li>Java后端开发</li>
                                            <li>熟练使用Git、MySQL、Java</li>
                                            <li>熟练使用IDEA、Eclipse等集成开发环境</li>
                                            <li>了解SpringBoot框架进行高效应用开发</li>
                                        </ul>
                                    </div>
                                    <img style="width: 25%;" src="https://wlmtsys.com:9000/wlmtsys/2024/09/29/278dc25ffc984eb18d7fa468baa5b281.jpg">
                                </div>
                                <h2>项目经历：</h2>
                                <h3>“飞来职Freelance——基于LLM的零工招聘平台</h3>
                                <p>项目介绍：在当今数字化时代，劳动力市场日益灵活化和多样化。本项目旨在搭建一个创新的零工平台，以解决这些痛点，满足供需双方的需求。</p>
                                <p>工作内容：</p>
                                <ul>
                                    <li>负责全栈开发和系统架构</li>
                                    <li>负责前端开发，使用HTML、JavaScript、CSS技术开发前端页面</li>
                                    <li>后台管理系统开发，使用js、vue等技术开发前端页面</li>
                                </ul>
                                <p>作品链接：<a href="https://gitee.com/SYxiaofeng/freelance-platform" target="_blank">https://gitee.com/SYxiaofeng/freelance-platform</a></p>
', 90, '         专业：软件工程
                        技能特长：
                        微信小程序开发、Vue前端开发、Java后端开发、git、mysql、Java，熟练使用IDEA、Eclipse等集成开发环境，了解SpringBoot框架进行高效应用开发
                        项目经历：
                        项目名称：“飞来职Freelance——基于LLM的零工招聘平台
                        项目介绍： 在当今数字化时代，劳动力市场日益灵活化和多样化。本项目旨在搭建一个创新的零工平台，以解决这些痛点，满足供需双方的需求。
                        工作内容：
                        负责全栈开发和系统架构
                        1. 负责前端开发，使用HTML、JavaScript、CSS技术开发前端页面。
                        2. 后台管理系统开发，使用js、vue等技术开发前端页面
                        作品链接：https://gitee.com/SYxiaofeng/freelance-platform`', '2024-10-08 09:29:18');
INSERT INTO wlmtsys_info.teams (id, depart, name, image, job, `desc`, core, info, create_time) VALUES (12, '3', '潘如炯', 'https://wlmtsys.com:9000/wlmtsys/2024/09/29/9ab7da89b5784230a7e297eb1ce76486.jpg', '软件开发', '<h1>潘如炯</h1>
                                <div style="display: flex;">
                                    <div style="width: 75%;">
                                        <p style="font-size: 20px">专业：22级计算机科学与技术2班</p>
                                        <h2>技能特长：</h2>
                                        <ul>
                                            <li>C语言</li>
                                            <li>Java编程</li>
                                            <li>数据库设计</li>
                                            <li>电路逻辑设计</li>
                                            <li>版本控制</li>
                                            <li>PHP项目</li>
                                        </ul>
                                    </div>
                                    <img style="width: 25%;" src="https://wlmtsys.com:9000/wlmtsys/2024/09/29/9ab7da89b5784230a7e297eb1ce76486.jpg">
                                </div>
                                <h2>实践经历：</h2>
                                <ul>
                                    <li>黄皮小程序开发</li>
                                    <li>微信直播拓客助手开发</li>
                                    <li>数字人项目研究</li>
                                </ul>', 85, '              专业：22级计算机科学与技术2班

                        技能特长：
                        c语言，java编程，数据库设计，
                        电路逻辑设计，版本控制，php项目

                        实践经历：
                        黄皮小程序开发，微信直播拓客助手开发，数字人项目研究`', '2024-10-08 09:29:38');
INSERT INTO wlmtsys_info.teams (id, depart, name, image, job, `desc`, core, info, create_time) VALUES (13, '3', '苏健', 'https://wlmtsys.com:9000/wlmtsys/2024/09/29/9eec2c6a4a564b2f816677ea943a4211.jpg', '数字人开发', '<h1>苏健</h1>
                                <div style="display: flex;">
                                    <div style="width: 75%;">
                                        <p style="font-size: 20px">专业：计算机科学与技术</p>
                                        <h2>技能特长：</h2>
                                        <ul>
                                            <li>VIMer</li>
                                            <li>番茄工作达人</li>
                                            <li>负责数字人生成（GPT-SoVITS、Easy-Wav2Lip/MuseTalk）</li>
                                        </ul>
                                    </div>
                                    <img style="width: 25%;" src="https://wlmtsys.com:9000/wlmtsys/2024/09/29/9eec2c6a4a564b2f816677ea943a4211.jpg">
                                </div>
                                <h2>实践经历：</h2>
                                <ul>
                                    <li>使用Hexo框架搭建个人博客：<a href="http://simuleite.github.io" target="_blank">simuleite.github.io</a></li>
                                    <li>参加浙江大学2024年春季《数据结构》MOOC，PTA拼题平台排名163/1510</li>
                                </ul>
                                <h2>获奖情况：</h2>
                                <ul>
                                    <li>网络系统软件应用与维护（中级）</li>
                                    <li>希芙领思 Blurt Out擂台冠军</li>
                                </ul>
                                <h2>项目经历：</h2>
                                <h3>数字人生成</h3>
                                <p>主要贡献：</p>
                                <ul>
                                    <li>2次数字人生成经验分享会</li>
                                    <li>1次论文阅读报告</li>
                                    <li>FFmpeg AB区推流脚本解决数字人前端推流不连续问题</li>
                                    <li>Auto Wav2Lip.sh简化生成数字人工作流程</li>
                                </ul>
                                <h3>智能名片小程序</h3>
                                <p>主要内容：</p>
                                <ul>
                                    <li>合作开发微信小程序智能名片页面</li>
                                    <li>使用SVN同步项目代码</li>
                                    <li>通过Git进行code review合并代码分支</li>
                                </ul>', 85, '专业：B23计算机科学与技术1班
                        技能特长：
                        VIMer
                        番茄工作达人
                        负责数字人生成（GPT-SoVITS、Easy-Wav2Lip/MuseTalk）
                        实践经历：
                        1. 实践描述：使用Hexo框架搭建个人博客
                        实践内容：simuleite.github.io
                        2. 实践描述：参加浙江大学2024年春季《数据结构》MOOC
                        实践内容：PTA拼题平台排名163/1510
                        项目经历：
                        1. 项目描述：数字人生成
                        主要贡献：
                        2次数字人生成经验分享会、1次论文阅读报告
                        FFmpeg AB区推流脚本解决数字人前端推流不连续问题，Auto Wav2Lip.sh简化生成数字人工作流程。
                        2. 项目描述：智能名片小程序
                        主要内容：
                        合作开发微信小程序智能名片页面，使用SVN同步项目项目代码，并通过Git 进行code review合并代码分支。
                        获奖情况：
                        网络系统软件应用与维护（中级）
                        希芙领思 Blurt Out擂台冠军', '2024-10-08 09:29:54');
INSERT INTO wlmtsys_info.teams (id, depart, name, image, job, `desc`, core, info, create_time) VALUES (14, '3', '罗绍铭', 'https://wlmtsys.com:9000/wlmtsys/2024/09/29/5b11a74d616c4497ab5df537cda0dd1d.jpg', '前端开发', '<h1>罗绍铭</h1>
                                <div style="display: flex;">
                                    <div style="width: 75%;">
                                        <p style="font-size: 20px">专业：计算机科学与技术</p>
                                        <h2>技能特长：</h2>
                                        <ul>
                                            <li>Html</li>
                                            <li>Python</li>
                                            <li>C语言</li>
                                            <li>微信小程序开发</li>
                                            <li>PS（Photoshop）</li>
                                            <li>Pr剪辑（Premiere Pro）</li>
                                            <li>WPS Office办公</li>
                                            <li>UI设计</li>
                                        </ul>
                                    </div>
                                    <img style="width: 25%;" src="https://wlmtsys.com:9000/wlmtsys/2024/09/29/5b11a74d616c4497ab5df537cda0dd1d.jpg">
                                </div>
                                <h2>实践经历：</h2>
                                <p>参与"品质女孩"商城项目首页和名片前端开发，参与数字人开发项目，负责Stable Diffusion生图教学ppt制作。</p>
                                <h2>获奖情况：</h2>
                                <ul>
                                    <li>校级Web前端开发竞赛一等奖</li>
                                    <li>校级英语知识竞赛二等奖</li>
                                </ul>', 85, '专业：B23计算机科学与技术1班
                        技能特长：
                        Html、Python、c语言、微信小程序开发、PS、pr剪辑、wps office办公、UI设计
                        实践经历：
                        参与"品质女孩"商城项目首页和名片前端开发，参与数字人开发项目，负责Stable Diffusion生图教学ppt制作
                        获奖情况：校级web前端开发竞赛一等奖、校级英语知识竞赛二等奖`
               ', '2024-10-08 09:30:08');
INSERT INTO wlmtsys_info.teams (id, depart, name, image, job, `desc`, core, info, create_time) VALUES (15, '3', '林堂辉', 'https://wlmtsys.com:9000/wlmtsys/2024/09/29/7321976f90b640b082e5bcf0d60e7f6f.jpg', '数字人开发', '<h1>林堂辉</h1>
                                <div style="display: flex;">
                                    <div style="width: 75%;">
                                        <p style="font-size: 20px">专业：计算机科学与技术</p>
                                        <h2>技能特长：</h2>
                                        <ul>
                                            <li>精通Office办公软件套件</li>
                                            <li>精通专业编程工具如PyCharm和Visual Studio</li>
                                            <li>熟练掌握多种数字人生成技术</li>
                                            <li>拥有扎实的前端开发技能</li>
                                            <li>能够使用Python进行网络爬虫开发</li>
                                            <li>能够构建小程序</li>
                                        </ul>
                                    </div>
                                    <img style="width: 25%;" src="https://wlmtsys.com:9000/wlmtsys/2024/09/29/7321976f90b640b082e5bcf0d60e7f6f.jpg">
                                </div>
                                <h2>实践经历：</h2>
                                <p>参与并贡献于"品质女孩"商城项目，负责设计和制作项目的名片首页，提升用户界面的吸引力和功能性。</p>', 85, '专业：B23计算机科学与技术1班
                        技能特长：
                        精通Office办公软件套件，以及专业编程工具如PyCharm和Visual Studio。
                        熟练掌握多种数字人生成技术，包括wav2lip、MuseTalk、GPT-Sovits等。
                        拥有扎实的前端开发技能，能够使用Python进行网络爬虫开发，以及小程序的构建。
                        实践经历：
                        参与并贡献于"品质女孩"商城项目，负责设计和制作项目的名片首页，提升用户界面的吸引力和功能性。`
               ', '2024-10-08 09:30:23');
INSERT INTO wlmtsys_info.teams (id, depart, name, image, job, `desc`, core, info, create_time) VALUES (16, '2', '刘婉怡', 'https://wlmtsys.com:9000/wlmtsys/2024/09/29/6b7218a1d95445e68399d732c8f3e679.jpg', '管理', '
                    专业：软件工程
                    技能特长：
                    精通HTML、CSS、JavaScript等Web前端技术、项目管理、熟练使用剪映、WPS Office应用。
                    项目经历：RPA营销机器人
                    工作内容：作为负责人组织协调队友完成大创立项、参与计算机设计大赛、中国国际创新大赛等比赛。
                    项目经历：黄皮小程序
                    工作内容：作为负责人组织协调队友完成小程序上线工作等任务，并担任项目中运营成员。
                    项目经历：易而戴——口腔正畸全链路数字化领航者
                    工作内容：作为成员协助负责人完成比赛准备工作。
                    获奖情况：1.第九届“互联网+”大赛校级一等奖 ；2.广东“众创杯”创新创业大赛优胜奖；3.全国大学生计算机设计大赛校三等奖`,
                ', 85, '
                    专业：软件工程
                    技能特长：
                    精通HTML、CSS、JavaScript等Web前端技术、项目管理、熟练使用剪映、WPS Office应用。
                    项目经历：RPA营销机器人
                    工作内容：作为负责人组织协调队友完成大创立项、参与计算机设计大赛、中国国际创新大赛等比赛。
                    项目经历：黄皮小程序
                    工作内容：作为负责人组织协调队友完成小程序上线工作等任务，并担任项目中运营成员。
                    项目经历：易而戴——口腔正畸全链路数字化领航者
                    工作内容：作为成员协助负责人完成比赛准备工作。
                    获奖情况：1.第九届“互联网+”大赛校级一等奖 ；2.广东“众创杯”创新创业大赛优胜奖；3.全国大学生计算机设计大赛校三等奖`,
                ', '2024-09-29 10:33:14');
INSERT INTO wlmtsys_info.teams (id, depart, name, image, job, `desc`, core, info, create_time) VALUES (17, '2', '尹晰慧', 'https://wlmtsys.com:9000/wlmtsys/2024/09/29/276da4b3b48b423f8a5a04fd6d0ac2ad.jpg', '管理', '<h1>尹晰慧</h1>
                                <div style="display: flex;">
                                <div style="width: 75%;">
                                    <p style="font-size: 20px">专业：数据科学与大数据技术</p>
                                    <h2>技能特长：</h2>
                                    <ul>
                                    <li>ps修图</li>
                                    <li>剪辑视频</li>
                                    <li>摄影</li>
                                    <li>路演</li>
                                    </ul>
                                </div>
                                <img style="width: 25%;" src="https://wlmtsys.com:9000/wlmtsys/2024/09/29/276da4b3b48b423f8a5a04fd6d0ac2ad.jpg">
                                </div>
                                <h2>获奖情况：</h2>
                                <ul>
                                    <li>广东省众创杯大学生启航赛团队组优胜奖</li>
                                    <li>计算机设计大赛校三等奖</li>
                                </ul>
                                <h2>项目经历：</h2>
                                <h3>黄埔百年百人志项目成员</h3>
                                <p>工作内容：</p><p>负责项目审核工作，素材收集，网站后台管理，剪辑人员工作进展管理。</p>
                                <h3>易而戴</h3>
                                <p>工作内容：</p><p>项目为白云学院与广州泛宇医疗科技有限公司合作项目，项目学生发展营销模块开发与推广课程制作推广。</p>
                                <h3>RPA机器人计算机设计大赛</h3>
                                <p>工作内容：</p><p>收集营销类素材，制作项目PPT，有效支持营销活动的开展，为企业提供数智化品牌营销解决方案，中清数据旗下项目。</p>', 85, '                    专业：数据科学与大数据技术
                        技能特长：ps修图、剪辑视频、摄影、路演
                        项目经历：易而戴众创杯、RPA机器人计算机设计大赛、黄埔百年百人志项目成员
                        获奖情况：广东省众创杯大学生启航赛团队组优胜奖、计算机设计大赛校三等奖`,
               ', '2024-10-08 09:30:45');
INSERT INTO wlmtsys_info.teams (id, depart, name, image, job, `desc`, core, info, create_time) VALUES (18, '1', '周颖灵', 'https://wlmtsys.com:9000/wlmtsys/2024/09/29/6fff25119b28464c98b32ca13418cb91.jpg', '管理', '<h1>周颖灵</h1>
                                <div style="display: flex;">
                                <div style="width: 75%;">
                                    <p style="font-size: 20px">专业：计算机科学与技术</p>
                                    <h2>技能特长：</h2>
                                    <ul>
                                    <li>前端界面设计</li>
                                    <li>项目管理</li>
                                    <li>演讲发言</li>
                                    <li>熟练使用剪映、WPS Office应用。</li>
                                    </ul>
                                </div>
                                <img style="width: 25%;" src="https://wlmtsys.com:9000/wlmtsys/2024/09/29/6fff25119b28464c98b32ca13418cb91.jpg">
                                </div>
                                <h2>获奖情况：</h2>
                                <ul>
                                    <li>第十七届中国计算机设计大赛省赛三等奖</li>
                                    <li>广东白云学院第十四届“挑战杯”三等奖</li>
                                    <li>榜样白云新生代表</li>
                                    <li>广东白云学院优秀共青团员</li>
                                    <li广东白云学院大数据与技术学院“职云杯”二等奖</li>
                                    <li>广东白云学院军训标兵</li>
                                </ul>
                                <h2>项目经历：</h2>
                                <h3>AI智推——基于人机融合的RPA营销机器人</h3>
                                <p>工作内容：作为队友协调队长完成任务、设计调查问卷、申报各类赛事资料填写、赛事跟进。</p>
                                <h3>易而戴——口腔正畸全链路数字化领航者</h3>
                                <p>工作内容：作为队友协调队长完成任务，进行微课程的出境拍摄。</p>
                                <h3>ConvBEiVIT（垃圾分类物品识别）</h3>
                                <p>工作内容：项目资料收集整合，测试代码。</p>', 87, '               专业：计算机科学与技术
                    技能特长：
                    前端界面设计、项目管理、演讲发言；
                    熟练使用剪映、WPS Office应用。
                    项目经历：AI智推——基于人机融合的RPA营销机器人
                    工作内容：作为队友协调队长完成任务、设计调查问卷、申报各类赛事资料填写、赛事跟进。
                    项目经历：易而戴——口腔正畸全链路数字化领航者
                    工作内容：作为队友协调队长完成任务，进行微课程的出境拍摄。
                    项目经理：ConvBEiVIT（垃圾分类物品识别）
                    项目经理：项目资料收集整合，测试代码。
                    获奖情况：1.第十七届中国计算机设计大赛省赛三等奖 2.广东白云学院军训标兵  3.广东白云学院第十四届“挑战杯”三等奖 4.广东白云学院优秀共青团员 5.广东白云学院大数据与技术学院“职云杯”二等奖 6.榜样白云新生代表
                    ', '2024-10-08 09:31:03');
INSERT INTO wlmtsys_info.teams (id, depart, name, image, job, `desc`, core, info, create_time) VALUES (19, '2', '伍尚雅', 'https://wlmtsys.com:9000/wlmtsys/2024/09/29/2f115b501789486ead2ed9b836e2eb55.jpg', '成员', '<h1>伍尚雅</h1>
                                <div style="display: flex;">
                                    <div style="width: 75%;">
                                        <p style="font-size: 20px">专业：计算机科学与技术</p>
                                        <h2>技能特长：</h2>
                                        <ul>
                                            <li>推文制作</li>
                                            <li>公众号运营</li>
                                            <li>PS海报设计</li>
                                            <li>UI界面设计</li>
                                            <li>文档撰写制作</li>
                                            <li>Html5、CSS、Python</li>
                                            <li>摄影摄像</li>
                                        </ul>
                                    </div>
                                    <img style="width: 25%;" src="https://wlmtsys.com:9000/wlmtsys/2024/09/29/2f115b501789486ead2ed9b836e2eb55.jpg">
                                </div>
                                <h2>获奖情况：</h2>
                                <ul>
                                    <li>小挑优秀奖</li>
                                    <li>职云杯三等奖</li>
                                    <li>新生杯辩论赛殿军</li>
                                </ul>
                                <h2>项目经历：</h2>
                                <h3>小挑</h3>
                                <p>工作内容：计划书填写</p>
                                <h3>“亲子声梦园”创新创业比赛</h3>
                                <p>工作内容：计划书撰写，图片制作</p>
                                <h3>数字人</h3>
                                <p>工作内容：拍摄，抠图，市场调研</p>
                                <h3>飞来职</h3>
                                <p>工作内容：UI界面设计</p>', 84, '          desc: `专业：计算机科学与技术
                        技能特长：
                        推文制作，公众号运营，ps海报设计，UI界面设计，文档撰写制作，Html5、CSS、Python，摄影摄像
                        项目经历：
                        1.项目描述：小挑
                        工作内容：计划书填写
                        2.项目描述：“亲子声梦园”创新创业比赛
                        工作内容：计划书撰写，图片制作
                        3.项目描述：数字人
                        工作内容：拍摄，抠图，市场调研
                        4.项目描述：飞来职
                        工作内容：UI界面设计
                        获奖情况：小挑优秀奖，职云杯三等奖，新生杯辩论赛殿军`,
               ', '2024-10-08 09:31:21');
INSERT INTO wlmtsys_info.teams (id, depart, name, image, job, `desc`, core, info, create_time) VALUES (20, '2', '谭靖诗', 'https://wlmtsys.com:9000/wlmtsys/2024/09/29/7020866bc9764b2ab23da08442e0a810.jpg', '成员', '<h1>谭靖诗</h1>
                                <div style="display: flex;">
                                    <div style="width: 75%;">
                                        <p style="font-size: 20px">专业：计算机科学与技术</p>
                                        <h2>技能特长：</h2>
                                        <ul>
                                            <li>摄影摄像、视频剪辑、ps、pr、lr</li>
                                            <li>熟练掌握Python、熟练掌握html、css等前端开发技术</li>
                                            <li>熟练掌握word、excel、ppt制作</li>
                                            <li>公众号运营、文稿攥写</li>
                                        </ul>
                                    </div>
                                    <img style="width: 25%;" src="https://wlmtsys.com:9000/wlmtsys/2024/09/29/7020866bc9764b2ab23da08442e0a810.jpg">
                                </div>
                                <h2>工作内容：</h2>
                                <p>校辩论队成员</p>
                                <h2>实践经历：</h2>
                                <p>“百千万”农趣园</p>
                                <h2>项目经历：</h2>
                                <h3>数字人分身</h3>
                                <p>工作内容：</p>
                                <p>拍摄、出演、市场调研</p>
                                <h3>“捉友DrawU”——LLM+桌游社交平台</h3>
                                <p>项目介绍：“捉友DrawU”——LLM+桌游社交平台，结合AI智能助手，简化桌游规则理解，为桌游爱好者提供一站式社交平台，提升用户体验，填补行业空白，引领全新社交方式。</p>
                                <p>工作内容：</p>
                                <p>作为软件测试人员，负责小程序的测试</p>
                                <h3>百千万”-“乡知乡识”</h3>
                                <p>工作内容：</p>
                                <p>拍摄剪辑</p>', 84, '专业：计算机科学与技术
                        技能特长：
                        摄影摄像、视频剪辑、ps、pr、lr；
                        熟练掌握Python、熟练掌握html、css等前端开发技术；
                        熟练掌握word、excel、ppt制作；
                        公众号运营、文稿攥写
                        工作内容：校辩论队成员；
                        实践经历：“百千万”农趣园
                        项目经历：
                        1、“百千万”-“乡知乡识”/拍摄剪辑
                        2、“捉友Draw U”/小程序测试
                        3、“数字人”/拍摄、出演、市场调研
                        4、“AI智推”`,
              ', '2024-10-08 09:31:39');
INSERT INTO wlmtsys_info.teams (id, depart, name, image, job, `desc`, core, info, create_time) VALUES (21, '2', '余紫菱', 'https://wlmtsys.com:9000/wlmtsys/2024/09/29/f7869f782bae4f2cbde1a18cee720aec.png', '成员', '<h1>余紫菱</h1>
                                <div style="display: flex;">
                                    <div style="width: 75%;">
                                        <p style="font-size: 20px">专业：计算机科学与技术</p>
                                        <h2>技能特长：</h2>
                                        <ul>
                                            <li>文案编辑</li>
                                            <li>视频剪辑</li>
                                            <li>UI界面设计</li>
                                            <li>基本掌握HTML5、Python等技术</li>
                                            <li>熟练使用剪映、WPS Office应用</li>
                                        </ul>
                                    </div>
                                    <img style="width: 25%;" src="https://wlmtsys.com:9000/wlmtsys/2024/09/29/f7869f782bae4f2cbde1a18cee720aec.png">
                                </div>
                                <h2>获奖情况：</h2>
                                <ul>
                                    <li>第十七届中国大学生计算机设计大赛选拔赛三等奖</li>
                                    <li>广东白云学院优秀共青团员</li>
                                    <li>广东白云学院大数据与技术学院“职云杯”三等奖</li>
                                </ul>
                                <h2>项目经历：</h2>
                                <h3>《心间漫步》日记小程序</h3>
                                <p>工作内容：为项目进行计划书撰写，文案编写等工作</p>
                                <h3>AI智推——基于人机融合的RPA营销机器人</h3>
                                <p>主要内容：和队友共同协作完成项目任务、进行赛事的申报资料填写及制作、赛事跟进、计划书以及各类文稿的统稿</p>', 83, '专业：计算机科学与技术
                        技能特长：文案编辑、视频剪辑、UI界面设计;
                        基本掌握HTML5、Python等技术;
                        熟练使用剪映、WPS office应用
                        项目经历：
                        1.项目描述：《心间漫步》日记小程序
                        工作内容：为项目进行计划书撰写，文案编写等工作
                        2.项目描述：AI智推——基于人机融合的RPA营销机器人
                        主要内容：和队友共同协作完成项目任务、进行赛事的申报资料填写及制作、赛事跟进、计划书以及各类文稿的统稿
                        获奖情况：1、获第十七届中国大学生计算机设计大赛选拔赛三等奖
                        2、广东白云学院优秀共青团员
                        3、广东白云学院大数据与技术学院“职云杯”三等奖`,
              ', '2024-10-08 09:32:15');
INSERT INTO wlmtsys_info.teams (id, depart, name, image, job, `desc`, core, info, create_time) VALUES (22, '2', '林聪怡', 'https://wlmtsys.com:9000/wlmtsys/2024/09/29/d842a071dda4473da8002da40d9e1224.jpg', '成员', '<h1>林聪怡</h1>
                                <div style="display: flex;">
                                    <div style="width: 75%;">
                                        <p style="font-size: 20px">专业：计算机科学与技术</p>
                                        <h2>技能特长：</h2>
                                        <ul>
                                            <li>摄影摄像</li>
                                            <li>视频剪辑</li>
                                            <li>文案撰写</li>
                                            <li>熟练使用剪映、Wink、醒图等视频图片剪辑工具</li>
                                            <li>精通HTML5、CSS、JavaScript、Python、C语言</li>
                                        </ul>
                                    </div>
                                    <img style="width: 25%;" src="https://wlmtsys.com:9000/wlmtsys/2024/09/29/d842a071dda4473da8002da40d9e1224.jpg">
                                </div>
                                <h2>获奖情况：</h2>
                                <ul>
                                    <li>《捉友DrawU》项目获全国大学生计算机设计大赛校级三等奖</li>
                                    <li>《心间漫步》日记小程序获全国大学生计算机设计大赛校级奖项</li>
                                    <li>院级大学生职业生涯规划大赛优秀奖</li>
                                </ul>
                                <h2>项目经历：</h2>
                                <h3>《捉友DrawU》小程序</h3>
                                <p>工作内容：为项目进行小程序演示视频的录制及剪辑、收集资料等工作</p>
                                <h3>《心间漫步》日记小程序</h3>
                                <p>主要内容：为项目进行小程序演示视频的录制及剪辑、文案的编辑等工作</p>', 82, '专业：计算机科学与技术
                        技能特长：
                        摄影摄像、视频剪辑、文案撰写；
                        熟练使用剪映、wink、醒图等视频图片剪辑工具；
                        精通Html5、CSS、JavaScript、Python、C语言。
                        项目经历：
                        1.项目描述：《捉友DrawU》小程序
                        工作内容：为项目进行小程序演示视频的录制及剪辑、收集资料等工作。
                        2.项目描述：《心间漫步》日记小程序
                        主要内容：为项目进行小程序演示视频的录制及剪辑、文案的编辑等工作。
                        获奖情况：参加的《捉友DrawU》项目获全国大学生计算机设计大赛校级三等奖；
                            《心间漫步》日记小程序获全国大学生计算机设计大赛校级奖项。
                            院级大学生职业生涯规划大赛优秀奖。
            ', '2024-10-08 09:32:35');
INSERT INTO wlmtsys_info.teams (id, depart, name, image, job, `desc`, core, info, create_time) VALUES (23, '2', '詹邦庭', 'https://wlmtsys.com:9000/wlmtsys/2024/09/29/bc66832e33e54be8a579f4846cce2236.jpg', '成员', '<h1>詹邦庭</h1>
                                <div style="display: flex;">
                                    <div style="width: 75%;">
                                        <p style="font-size: 20px">专业：软件工程</p>
                                        <h2>技能特长：</h2>
                                        <ul>
                                            <li>项目管理</li>
                                            <li>视频剪辑</li>
                                            <li>新闻稿件撰写</li>
                                            <li>熟练使用C++，Python等编程语言</li>
                                        </ul>
                                    </div>
                                    <img style="width: 25%;" src="https://wlmtsys.com:9000/wlmtsys/2024/09/29/bc66832e33e54be8a579f4846cce2236.jpg">
                                </div>
                                <h2>实践经历：</h2>
                                <p>在深圳教育机构、潮州教育机构、在校生志愿平台担任初二数学老师，进行一对一或一对多的教学。</p>
                                <p>工作内容：解答并教授所有初二数学知识内容以及出题讲解，将学生成绩从50分提升至最高100多分。</p>
                                <h2>项目经历：</h2>
                                <h3>农林产品智慧供应链保鲜溯源平台</h3>
                                <p>工作内容：作为项目负责人组织协调队友完成任务、完成项目大部分工作。</p>
                                <h3>郁南无核黄皮种植地和工厂实地调研</h3>
                                <p>主要内容：通过对郁南无核黄皮种植地和工厂进行实地调研,深入梳理并分析无核黄皮生产流程和供应链各环节质量安全问题。结合消费者、企业、监管部门等不同追溯主体的差异化需求，提出了郁南无核黄皮质量安全可信的农林产品智慧供应链保鲜溯源模型。结合区块链技术、传感网络监测技术、AI回溯技术三大技术解决长期以来保鲜期较短的如黄皮等农林产品在运输中的问题，致力于为每一项农林产品创造了一份独一无二的健康档案。</p>
                                <h2>获奖情况：</h2>
                                <ul>
                                    <li>CET-4证书</li>
                                    <li>CMC二等奖</li>
                                </ul>', 82, '专业：软件工程
                        技能特长：项目管理、视频剪辑、新闻稿件撰写；
                        熟练使用c++，python等。
                        实践经历：当老师
                        实践描述：在深圳教育机构、潮州教育机构、在校生志愿平台当任初二数学老师一对一或一对多。
                        工作内容：解答并教授所有初二数学知识内容以及出题讲解，将学生从50分拉至最高分100多分。
                        项目经历：
                        1.项目名称：农林产品智慧供应链保鲜溯源平台。
                        工作内容：作为项目负责人组织协调队友完成任务、完成项目大部分工作。
                        2.项目描述：通过对郁南无核黄皮种植地和工厂进行实地调研,深入梳理并分析无核黄皮生产流程和供应链各环节质量安全问题。结合消费者、企业、监管部门等不同追溯主体的差异化需求，提出了郁南无核黄皮质量安全可信的农林产品智慧供应链保鲜溯源模型。结合区块链技术、传感网络监测技术、AI回溯技术三大技术解决长期以来保鲜期较短的如黄皮等农林产品在运输中的问题，致力于为每一项农林产品创造了一份独一无二的健康档案。
                        获奖情况：CET-4证书、CMC二等奖。
            ', '2024-10-08 09:32:56');
INSERT INTO wlmtsys_info.teams (id, depart, name, image, job, `desc`, core, info, create_time) VALUES (24, '3', '廖耀华', 'https://wlmtsys.com:9000/wlmtsys/2024/09/27/9f50f75829804cc18f7f805bb5760c57.jpg', '技术负责人', '<h1>廖耀华</h1>
                                <div style="display: flex;">
                                <div style="width: 75%;">
                                    <p style="font-size: 20px">专业：数据科学与大数据技术</p>
                                    <h2>技能特长：</h2>
                                    <ul>
                                    <li>小程序开发</li>
                                    <li>Vue前端开发</li>
                                    <li>Java后端开发</li>
                                    <li>Python后端开发</li>
                                    <li>熟练使用Ps/Mockitt设计前端UI</li>
                                    <li>熟练使用WPS Office应用</li>
                                    </ul>
                                </div>
                                <img style="width: 25%;" src="https://6472-drawu-7gbxn3kn5cbb6119-1316724426.tcb.qcloud.la/web/teams/廖耀华.jpg">
                                </div>
                                <h2>获奖情况：</h2>
                                <ul>
                                    <li>《心间漫步》日记小程序V1.0计算机软件著作权登记证书</li>
                                    <li>《基于人工智能课堂教学智慧评价系统》V1.0计算机软件著作权登记证书</li>
                                    <li>第十四届蓝桥杯全国软件和信息技术专业人才大赛Java组国家级优秀奖</li>
                                    <li>第十四届蓝桥杯全国软件和信息技术专业人才大赛Java组广东省一等奖</li>
                                    <li>第十五届蓝桥杯全国软件和信息技术专业人才大赛Web组广东省三等奖</li>
                                    <li>国家励志奖学金</li>
                                    <li>第六届微信小程序应用开发赛 一等奖</li>
                                    <li>第四届算法设计竞赛 一等奖</li>
                                    <li>第一届数据获取与可视化方案设计竞赛 一等奖</li>
                                    <li>第六届数据分析精神 一等奖</li>
                                    <li>第三届大数据挑战赛 一等奖</li>
                                    <li>第八届网络爬虫竞赛 一等奖</li>
                                    <li>第六届移动互联网应用开发竞赛 一等奖</li>
                                    <li>第六届软件作品竞赛 一等奖</li>
                                    <li>第三届大数据预处理竞赛 一等奖</li>
                                    <li>第十四届“蓝桥杯”校园选拔赛 一等奖</li>
                                    <li>大数据协会创意可视化竞赛 一等奖</li>
                                    <li>第四届数据库设计竞赛 一等奖</li>
                                </ul>
                                <h2>实践经历：</h2>
                                <p>实践描述：</p><p>前往云浮市郁南县15个镇街为150多位新农人提供新媒体营销指导，带动1000多户果农就业增收，帮助打造“互联网 + 文旅融合”乡村文化符号，解决营销难题。</p>
                                <p>工作内容：</p><p>作为学生助理及实践团学生负责人，负责团队管理与工作任务的分配，参与实地调研，撰写调研文稿、新闻稿件等，协助指导老师开展新农人电商直播培训。</p>
                                <h2>项目经历：</h2>
                                <h3>基于人工智能课堂教学智慧评价系统</h3>
                                <p>项目介绍：</p>
                                <p>通过设备获取学生上课情况进行识别以及自动签到，通过数据库连接整理出汇报表进行统计。建立学习平台，方便学生与老师即使进行本节课内容的交流。通过与学习通的连接，方便老师布置作业以及即时统计未完成情况。</p>
                                <p>工作内容：</p>
                                <ul>
                                <li>使用Python PyQt5开发前端页面</li>
                                <li>使用Python PyTest测试软件并上传漏洞</li>
                                </ul>
                                <p>作品链接：<a href="https://gitee.com/huazaiLYH/face-recognition">https://gitee.com/huazaiLYH/face-recognition</a></p>
                                <h3>基于人脸识别的弱势人群护理系统</h3>
                                <p>项目介绍：</p>
                                <p>面向需要特殊关怀的弱势人群的创新技术产品，采用先进的人脸表情识别技术和智能管理系统，该系统通过摄像头收集用户面部表情信息，进行分析和识别，提供针对性的护理服务和支持措施，提高生活质量。</p>
                                <p>工作内容：</p>
                                <ul>
                                <li>负责前端开发与软件测试</li>
                                <li>使用Python PyQt5开发前端页面</li>
                                <li>使用Python PyTest测试软件并上传漏洞</li>
                                </ul>
                                <p>作品链接：<a href="https://gitee.com/huazaiLYH/ai-classroom">https://gitee.com/huazaiLYH/ai-classroom</a></p>
                                <h3>“心间漫步”日记小程序</h3>
                                <p>项目介绍：一个记录心情、图片的日记小程序，可以在广场中上传并分享自己的日记。</p>
                                <p>工作内容：</p>
                                <ul>
                                <li>作为前端开发人员，使用HTML、JavaScript、CSS技术开发前端页面</li>
                                <li>作为后端开发人员，使用Node.js技术开发后端逻辑层</li>
                                <li>作为运维人员，使用微信云开发作为数据库，并主要负责写SQL语句、检测数据库信息</li>
                                <li>统筹小组工作，定时开展例会，检查各人员进度，指名发展方向</li>
                                </ul>
                                <p>作品链接：<a href="https://gitee.com/huazaiLYH/heartwalking">https://gitee.com/huazaiLYH/heartwalking</a></p>
                                <h3>“捉友DrawU”——LLM+桌游社交平台</h3>
                                <p>项目介绍：“捉友DrawU”——LLM+桌游社交平台，结合AI智能助手，简化桌游规则理解，为桌游爱好者提供一站式社交平台，提升用户体验，填补行业空白，引领全新社交方式。</p>
                                <p>工作内容：</p>
                                <ul>
                                <li>作为前端开发人员，使用HTML、JavaScript、CSS技术开发前端页面</li>
                                <li>作为后端开发人员，使用Python Flask技术开发后端逻辑层</li>
                                <li>作为后端开发人员，使用ChatGLM 4.0作为小程序内置AI，负责调试AI</li>
                                <li>作为运维人员，使用MySQL作为数据库，并主要负责写SQL语句、检测数据库信息</li>
                                <li>作为项目负责人，负责撰写创业计划书与活动策划案，并在线下开展项目活动</li>
                                <li>定时开展培训与研讨会，提升小组能力</li>
                                </ul>
                                <p>作品链接：<a href="https://gitee.com/huazaiLYH/drawu">https://gitee.com/huazaiLYH/drawu</a></p>
                                <h3>“飞来职Freelance”——基于LLM的零工招聘平台</h3>
                                <p>项目介绍：在当今数字化时代，劳动力市场日益灵活化和多样化。随着人们工作观念的转变以及企业对弹性用工的需求增加，零工经济迅速崛起。然而，现有的零工市场存在信息不对称、匹配效率低下、权益保障不足等问题。本项目旨在搭建一个创新的零工平台，以解决这些痛点，满足供需双方的需求。</p>
                                <p>工作内容：</p>
                                <ul>
                                <li>作为前端开发人员，使用HTML、JavaScript、CSS技术开发前端页面</li>
                                <li>作为后端开发人员，我使用Java Springboot框架开发后端逻辑层。</li>
                                <li>作为后端开发人员，我使用ChatGLM 4.0作为小程序内置AI。我负责调试AI。</li>
                                <li>作为运维人员，我使用MySQL作为数据库，并主要负责写SQL语句、检测数据库信息。</li>
                                </ul>
                                <p>作品链接：<a href="https://gitee.com/SYxiaofeng/freelance-platform">https://gitee.com/SYxiaofeng/freelance-platform</a></p>', 99, '专业：数据科学与大数据技术
技能特长：小程序开发、Vue前端开发、Java后端开发、Python后端开发；
熟练使用Ps/Mockitt设计前端UI、WPS Office应用。
项目经历：
项目名称：基于人工智能课堂教学智慧评价系统
项目介绍：通过设备获取学生上课情况进行识别以及自动签到，通过数据库连接整理出汇报表进行统计。 建立学习平台，方便学生与老师即使进行本节课内容的交流。 通过与学习通的连接，方便老师布置作业以及即时统计未完成情况。
工作内容：
1.在前端开发中，我使用Python PyQt5开发前端页面。
2.负责软件测试，我使用Python PyTest测试软件并上传漏洞。
项目经历：
项目名称：基于人脸识别的弱势人群护理系统
项目介绍：面向需要特殊关怀的弱势人群的创新技术产品，采用先进的人脸表情识别技术和智能管理系统，该系统通过摄像头收集用户面部表情信息，进行分析和识别，提供针对性的护理服务和支持措施，提高生活质量。\\n\\
                    工作内容：\\n\\
                    负责前端开发与软件测试。\\n\\
                    1.在前端开发中，我使用Python PyQt5开发前端页面。\\n\\
                    2.负责软件测试，我使用Python PyTest测试软件并上传漏洞。\\n\\
                    作品链接：https://gitee.com/huazaiLYH/ai-classroom\\n\'', '2024-10-08 09:35:31');
INSERT INTO wlmtsys_info.teams (id, depart, name, image, job, `desc`, core, info, create_time) VALUES (25, '4', '蒲源', 'https://wlmtsys.com:9000/wlmtsys/2024/09/29/d96150ead00a4d00aa8ff7734cb34cde.jpg', '老师', ' <ul>\\
                        <li>广东白云学院教授兼中清数据创始人/教授级高级工程师</li>\\
                        <li>国PMP国际项目经理/欧盟IPMP C国际高级项目经理</li>\\
                        <li>中山大学优秀硕士毕业生/杰出校友/第二届中山大学MPM理事长</li>\\
                        <li>深耕“媒体融合”领域，主持6项省级重点工程项目负责人，参与3项省级标准制定，发表论文16篇、论著1部、专利4项、软著26项。</li>\\
                        <li>主持参与多项国家级、省部级创新创业大赛并获得荣誉。</li>\\
                        <li>中育人+实战，围绕“数据+营销服务”的理念，帮助企业打造直播带货销量冠军团队及搭建私域流量池，在引流、获客、转化过程实施标准化。</li>\\
                    </ul>\\
                    <div>主要业务方向：</div>\\
                    <div style="color: #c00000; font-weight: bold;">直播销冠团队孵化、从0到1做新媒体运营、社会化媒体计算</div>\',
               ', 100, '广东白云学院教授兼中清数据创始人/教授级高级工程师
国PMP国际项目经理/欧盟IPMP C国际高级项目经理
中山大学优秀硕士毕业生/杰出校友/第二届中山大学MPM理事长
深耕“媒体融合”领域，主持6项省级重点工程项目负责人，参与3项省级标准制定，发表论文16篇、论著1部、专利4项、软著26项。
主持参与多项国家级、省部级创新创业大赛并获得荣誉。
中育人+实战，围绕“数据+营销服务”的理念，帮助企业打造直播带货销量冠军团队及搭建私域流量池，在引流、获客、转化过程实施标准化。
主要业务方向：
直播销冠团队孵化、从0到1做新媒体运营、社会化媒体计算
', '2024-11-13 18:24:33');


create table wlmtsys_info.project
(
    id          bigint auto_increment
        primary key,
    title       varchar(100) null,
    content     longtext     null,
    image       varchar(100) null,
    create_time datetime     null
);

INSERT INTO wlmtsys_info.project (id, title, content, image, create_time) VALUES (1, '数字人分身', '形象训练+声音克隆。通过AI深度学习训练，高度还原的真人数字替身。录制5-10分钟视频和音频作为训练素材，即可高精度还原真人外形、嘴型、表情、动作。
定制专属数字人。客户也可以直接使用平台现有超过60种通用超写实数字人形象能快速开启数字人智能播报，打造属于每个人自己的IP。', 'https://wlmtsys.com:9000/wlmtsys/2024/09/20/1768e71785964b409bc4198a89dfb8b1.jpg', '2024-08-20 17:36:30');
INSERT INTO wlmtsys_info.project (id, title, content, image, create_time) VALUES (2, '捉友DrawU”——LLM+桌游社交平台', '传统桌游行业缺乏专业平台，规则复杂导致新用户上手困难。本项目首创了桌游社交平台结合大语言模型LLM和AI智能助手，简化桌游规则理解，为游爱好者提供一站式社交平台，提升用户体验，填补行业空白，引领全新社交方式。', 'https://wlmtsys.com:9000/wlmtsys/2024/09/20/9edd7ff92d7c4612813e5eb473bf72da.png', '2024-08-21 17:36:29');
INSERT INTO wlmtsys_info.project (id, title, content, image, create_time) VALUES (4, 'RPA营销机器人+直播电商', '为探索培育乡村新质生产力，深入实施“百千万工程”，助力打造国家地理标志农产品，本项目设计了一种基于RPA技术的直播间各业务场景仿真流程自动化软件，通过0CR文字识别技术及智能数据提取与处理，并结合外设模拟操作，实现了场控、助播等更多业务流程自动化，解决了直播间运营流量少，成本高等问题，提高了农产品销售效率。', 'https://wlmtsys.com:9000/wlmtsys/2024/09/22/a07c1a5400b44b33bf391897a2c58aed.jpg', '2024-09-22 14:42:53');

create table wlmtsys_info.news
(
    id      bigint auto_increment
        primary key,
    title   varchar(100) null,
    date    date         null,
    author  varchar(50)  null,
    content longtext     null,
    image   varchar(300) null,
    url     varchar(300) null,
    label   int          null
);

INSERT INTO wlmtsys_info.news (id, title, date, author, content, image, url, label) VALUES (1, '【第二课堂】大数据与计算机学院举办第七届移动互联应用开发竞赛', '2024-08-19', '广东白云学院', '为从学生中发掘移动互联应用开发的创新、创意型人才，锻炼其软件设计及应用能力，培养创新意识、实践能力和团队协作精神，鼓励和引导大学生利用平时所学知识将想法或创意转化为具有一定实际应用价值的作品。大数据与计算机学院于2024年6月7日举办了2024年广东白云学院第七届移动互联应用开发竞赛，截至5月初，所有参赛小组将本小组的竞赛作品提交给老师，经过大数据与计算机学院孙雪岩与李妍老师的初步筛选，最终确定竞赛项目作品进入决赛环节。', 'https://wlmtsys.com:9000/wlmtsys/2024/09/20/5533a5951b504b65887267cc23161c05.png', 'https://jsj.baiyunu.edu.cn/html/bydt/1806.html', 0);
INSERT INTO wlmtsys_info.news (id, title, date, author, content, image, url, label) VALUES (3, '聚力百千万工程，解锁郁南“互联网+文旅融合”流量密码', '2023-08-25', '广东白云学院', '为了深入学习贯彻党的二十大精神，推动“百县千镇万村高质量发展工程”，广东白云学院积极响应“三下乡”社会实践活动暨广东青年大学生“百千万工程”突击行动，持续推进乡村振兴人才培育工作，帮助新农人提高电子商务技能和职业素养，鼓励新农人走进直播间。8月22至23日，云浮郁南县建城镇、大湾镇人民政府委托我校广州市农村科技特派员蒲源教授团队开展2023年郁南县网红达人暨新农人第二期直播培训，先后帮助80余名学员通过短视频和直播拓宽营销渠道，解锁郁南“互联网+文旅融合”流量密码。', 'https://wlmtsys.com:9000/wlmtsys/2024/09/20/eef6728f6a004ea79a30e9a6aba64369.png', 'https://jsj.baiyunu.edu.cn/html/bydt/1530.html', 0);
INSERT INTO wlmtsys_info.news (id, title, date, author, content, image, url, label) VALUES (6, '郁南新闻20230714', '2023-07-14', '郁南县广播电视台', '培训班邀请广东白云学院教授蒲源进行授课，培训内容有短视频案例分析、直播运营、拍摄技巧、带货技能等方面。期间，学员们还到了无核黄皮干园进行实地拍摄，提高实操能力，随后寻味郁南团队作经验分享，课程内容丰富，理论与实际结合紧密，现场学习气氛活跃，学员学习热情高涨。', 'https://wlmtsys.com:9000/wlmtsys/2024/09/20/4c08ae41a0b440dab7f4dece5a9d7787.png', 'https://yunan-m.itouchtv.cn/video/79eb1e6b6b3258323c03eef92f4fbe52?', 0);
INSERT INTO wlmtsys_info.news (id, title, date, author, content, image, url, label) VALUES (21, '大数据与计算机学院学子入围2023年广东“众创杯”创业创新大赛之大学生启航赛团队组复赛', '2023-12-04', '广东白云学院', '近日，我校大数据与计算机学院学子入围2023年广东“众创杯”创业创新大赛之大学生启航赛（以下简称：大学生启航赛）团队组复赛。本次赛事吸引了全球超过300余所院校的3100个项目，包括清华大学、北京大学、中山大学等国内外顶级高校，广东白云学院“易而戴——基于数字孪生技术的全链路数字化口腔正畸平台应用研究”从3100多个大学生创新创业项目中以省排名前3%的成绩晋级，与来自广东、香港、台湾、澳门等地的92支团队共同竞技。', 'https://wlmtsys.com:9000/wlmtsys/2024/09/22/7b07a81697264864b24103af6a68f9b0.png', 'https://www.baiyunu.edu.cn/html/cn/xykx/23608.html', 0);
INSERT INTO wlmtsys_info.news (id, title, date, author, content, image, url, label) VALUES (22, '大湾镇：以“互联网+”模式打开农产品销路', '2023-08-24', '郁南县人民政府门户网站', '为巩固深化“真抓实干、马上就办、办就办好”专题教育实践活动成果，8月23日，大湾镇邀请广东青年大学生“百千万工程”突击队——广东白云学院“三下乡”社会实践活动团队到五星村花海文旅产业示范园宝树湾片区对当地新营职业农民和农村人才进行视频剪辑、直播带货等新农人培训教学，送技下乡，通过直播带货形式拓宽本地区农副产品销路，助力大湾镇农业产业高质量发展，促进乡村振兴。', 'https://wlmtsys.com:9000/wlmtsys/2024/09/22/3b59e7f9c2d343429d9dc5a5c1c25aad.jpg', 'http://www.gdyunan.gov.cn/ynxrmzf/xwzx/xzdt/content/post_1729226.html', 0);
INSERT INTO wlmtsys_info.news (id, title, date, author, content, image, url, label) VALUES (23, '郁南：网红达人和新农人集中培训 助力乡村振兴', '2023-07-15', '郁南发布（公众号）', '为帮助网红达人和新农人提高电子商务技能和职业素养，鼓励新农人走进直播间，全力推动“直播带货”等销售新业态，让更多农民成为数字技术的使用者、受益者、推广者，7月13日，县委宣传部、建城镇人民政府联合举办2023年郁南县网红达人暨新农人直播培训班，全县共70多名网络主播、网红达人和新农人代表参加了培训。', 'https://wlmtsys.com:9000/wlmtsys/2024/09/22/89814dad301d4ac0a99d6ee0b077ac60.jpg', 'https://mp.weixin.qq.com/s?__biz=MzkzMDY2MjM4Ng==&mid=2247534924&idx=3&sn=79d5a84bdacda7cf327ef0f22ab9376f&source=41#wechat_redirect', 0);
INSERT INTO wlmtsys_info.news (id, title, date, author, content, image, url, label) VALUES (24, '抢先看！2023-2024学年第二课堂活动立项名单', '2023-10-08', '广东白云学院团委', '第二课堂是第一课堂的有效延伸是学校人才培养的重要组成部分第二课堂以“实践”为主要培养形式着力对学生素质和能力的开发学校每年面向各二级学院、职能部门和各学生组织征集第二课堂项目接下来就跟团团看看本学年校级立项的第二课堂活动有哪些吧', 'https://wlmtsys.com:9000/wlmtsys/2024/09/22/5c2f4f88bb754932a1a0feb816c92729.gif', 'https://mp.weixin.qq.com/s/9Jg8Dj5T2airWKxDyr6AIw', 1);

create table wlmtsys_info.info
(
    id          bigint auto_increment
        primary key,
    title       varchar(500)                       null,
    content1    longtext                           null,
    content2    longtext                           null,
    image       varchar(500)                       null,
    weimg       varchar(500)                       null,
    phone       varchar(11)                        null,
    email       varchar(50)                        null,
    address     varchar(100)                       null,
    create_time datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP
);

INSERT INTO wlmtsys_info.info (id, title, content1, content2, image, weimg, phone, email, address, create_time) VALUES (3, '未来媒体实验室', '未来媒体实验室致力于探索人工智能与传媒技术相融合的创新研究，旨在推动媒体行业的整体转型。实验室聚焦于人工智能与新媒体的未来，建立世界领先的人工智能及媒体技术研究与合作平台。通过与华为、百度、微软等企业的合作，实验室将共同致力于人工智能与传媒技术的研究，探索AI+移动媒体的未来，促进媒体行业的整体转型。', '实验室的研究内容涵盖了人工智能、大数据、虚拟现实等技术对媒体行业的影响与变革，旨在通过技术研发推动媒体行业的创新发展。实验室还将面向国内媒体及中小型企业提供定制化咨询，成员机构相互合作进行课题和技术研发，共享成果，为政府机构、大型企业提供长期咨询和技术研发服务。', 'https://wlmtsys.com:9000/wlmtsys/2024/09/20/5cdd1eb8fd354e719642f377b60d2996.jpg', 'https://wlmtsys.com:9000/wlmtsys/2024/09/20/90e57bc9b0bc485ebfb09ebf3446f399.jpg', '13719814204', 'wlmtsys@163.com', '广东省广州市白云区江高镇学苑路1号', '2024-09-20 22:55:05');

create table wlmtsys_info.employ
(
    id          bigint auto_increment
        primary key,
    title       varchar(50)   null,
    work        text          null,
    requirement text          null,
    label       int           null,
    create_time datetime      null,
    description varchar(1000) null
);

INSERT INTO wlmtsys_info.employ (id, title, work, requirement, label, create_time, description) VALUES (7, '前端开发', '负责实验室相关项目的用户界面设计与开发。通过运用前端技术，打造美观、易用且交互性强的网页和应用界面，为用户带来优质的视觉体验和便捷的操作感受。', '\'熟练使用HTML/CSS/JavaScript等前端开发技术\',
\'掌握Vue/React/小程序等前端技术与框架之一\',
\'需要有项目经历和比赛奖项\'', 1, '2024-09-22 15:06:02', '\'熟练使用HTML/CSS/JavaScript等前端开发技术\',
\'掌握Vue/React/小程序等前端技术与框架之一\',
\'需要有项目经历和比赛奖项\'');
INSERT INTO wlmtsys_info.employ (id, title, work, requirement, label, create_time, description) VALUES (8, '后端开发', '主要承担实验室项目的服务器端开发工作。进行数据库管理、业务逻辑处理以及系统架构搭建，确保项目的稳定运行和高效数据处理。', '熟练使用Python/Java/C++等后端开发语言\',\'掌握MySQL/MongoDB/Redis等数据库技术\',\'掌握Flask/Django/Spring/SpringBoot/SpringCloud等后端框架之一\',\'需要有项目经历和比赛奖项', 1, '2024-09-22 14:52:29', '熟练使用Python/Java/C++等后端开发语言\',\'掌握MySQL/MongoDB/Redis等数据库技术\',\'掌握Flask/Django/Spring/SpringBoot/SpringCloud等后端框架之一\',\'需要有项目经历和比赛奖项');
INSERT INTO wlmtsys_info.employ (id, title, work, requirement, label, create_time, description) VALUES (9, '剪辑师', '对实验室的视频素材进行剪辑和后期制作。通过创意剪辑、添加特效、调整色彩等手段，将原始素材转化为精彩的视频作品，用于项目展示、宣传等。', '1练掌握至少一种视频剪辑软件，如 Adobe Premiere Pro、Final Cut Pro 等。
2好的节奏感和叙事能力，能够将素材剪辑成精彩的视频作品。
3解视频特效和调色技巧，提升视频质量。
4有创意，能够根据不同主题和需求进行剪辑创作。
', 1, '2024-09-22 15:08:27', '1练掌握至少一种视频剪辑软件，如 Adobe Premiere Pro、Final Cut Pro 等。
2好的节奏感和叙事能力，能够将素材剪辑成精彩的视频作品。3解视频特效和调色技巧，提升视频质量。4有创意，能够根据不同主题和需求进行剪辑创作。
');
INSERT INTO wlmtsys_info.employ (id, title, work, requirement, label, create_time, description) VALUES (10, '摄影师', '负责拍摄实验室的各项活动、实验场景以及成果展示等照片。以专业的摄影技术捕捉精彩瞬间，为实验室提供高质量的视觉素材。', '1悉摄影设备的操作，掌握基本的摄影技巧。2良好的构图和光影把握能力。3根据不同场景和要求进行拍摄，提供高质量的照片素材。4一定的后期处理能力，如调色、裁剪等
熟练使用Ps等软件\',\'需要摄影作品展示', 1, '2024-09-22 14:54:24', '1悉摄影设备的操作，掌握基本的摄影技巧。2良好的构图和光影把握能力。3根据不同场景和要求进行拍摄，提供高质量的照片素材。4一定的后期处理能力，如调色、裁剪等
熟练使用Ps等软件\',\'需要摄影作品展示');
INSERT INTO wlmtsys_info.employ (id, title, work, requirement, label, create_time, description) VALUES (11, '文案编辑', '撰写实验室各个项目的商业计划书",
\'参与每个项目的讨论', '\'熟练使用Word/Excel/PPT等Office软件\',\'获得过校级及以上的创新创业奖项优先\'', 1, '2024-09-22 14:58:17', '\'熟练使用Word/Excel/PPT等Office软件\',\'获得过校级及以上的创新创业奖项优先\'');
INSERT INTO wlmtsys_info.employ (id, title, work, requirement, label, create_time, description) VALUES (12, 'UI设计师', '负责实验室项目的用户界面设计。结合用户需求和审美趋势，设计出简洁美观、操作便捷的界面，提升用户对项目的第一印象和使用感受。', '1用户体验有深刻的理解，能够从用户角度出发进行界面设计，注重交互性和易用性。2有良好的色彩搭配和排版能力，能够创造出美观、舒适的视觉效果。3悉不同平台（如网页、移动应用等）的设计规范和特点，确保设计的一致性和适配性。4有创新思维和创意能力，能够为实验室项目带来独特的设计风格和视觉亮点。', 1, '2024-09-22 14:52:53', '熟练使用Ps等软件\',\'需要设计作品展示');
INSERT INTO wlmtsys_info.employ (id, title, work, requirement, label, create_time, description) VALUES (13, '产品经理', '负责规划、开发和推广产品的专业人员。他们需要理解市场需求，定义产品愿景，并推动产品从概念到市场的整个过程。', '1能够领导跨职能团队，推动项目向前发展。2能够使用数据和分析来指导产品决策。3对用户体验（UX）设计有深刻理解，能够创造以用户为中心的产品。4能够管理复杂的项目，确保按时交付', 1, '2024-09-22 14:51:20', '1能够领导跨职能团队，推动项目向前发展。2能够使用数据和分析来指导产品决策。3对用户体验（UX）设计有深刻理解，能够创造以用户为中心的产品。4能够管理复杂的项目，确保按时交付');
INSERT INTO wlmtsys_info.employ (id, title, work, requirement, label, create_time, description) VALUES (14, '销售', '推广实验室的项目成果和服务，寻找合作机会和客户资源。通过有效的销售策略和良好的客户关系管理，为实验室带来经济效益和发展机遇。', '1备良好的沟通能力和销售技巧。
2较强的市场开拓能力和客户服务意识。
3够制定销售计划和策略，完成销售任务。
4团队合作精神，能够与其他部门协作配合。', 1, '2024-09-22 15:08:07', '1备良好的沟通能力和销售技巧。2较强的市场开拓能力和客户服务意识。3够制定销售计划和策略，完成销售任务。4团队合作精神，能够与其他部门协作配合。');
INSERT INTO wlmtsys_info.employ (id, title, work, requirement, label, create_time, description) VALUES (15, '推文编写', '负责实验室的社交媒体账号运营和推文撰写。通过生动有趣的文字和精美的图片，向外界宣传实验室的成果、活动和理念，提升实验室的知名度和影响力。', '1较强的文字功底，能够撰写吸引人的推文内容。2悉社交媒体平台的运营规则和技巧。3良好的审美能力，能够进行图文排版和编辑。4注热点话题，有敏锐的新闻嗅觉和创新思维。', 1, '2024-09-22 14:55:21', '1较强的文字功底，能够撰写吸引人的推文内容。2悉社交媒体平台的运营规则和技巧。3良好的审美能力，能够进行图文排版和编辑。4注热点话题，有敏锐的新闻嗅觉和创新思维。');
INSERT INTO wlmtsys_info.employ (id, title, work, requirement, label, create_time, description) VALUES (16, '演讲', '代表实验室在各种场合进行项目展示和演讲。以清晰的表达、自信的台风和深入的专业知识，向观众传达实验室的创新成果和价值。', '1备良好的口头表达能力和演讲技巧。
2够自信地在公众场合展示项目成果和观点。
3较强的逻辑思维和应变能力，能够回答观众提问。
4悉 PPT 制作，能够辅助演讲进行展示。', 1, '2024-09-22 15:06:48', '1备良好的口头表达能力和演讲技巧。2够自信地在公众场合展示项目成果和观点。3较强的逻辑思维和应变能力，能够回答观众提问。4悉 PPT 制作，能够辅助演讲进行展示。');
INSERT INTO wlmtsys_info.employ (id, title, work, requirement, label, create_time, description) VALUES (17, '前端开发', '负责实验室相关项目的用户界面设计与开发。通过运用前端技术，打造美观、易用且交互性强的网页和应用界面，为用户带来优质的视觉体验和便捷的操作感受。', '\'熟练使用HTML/CSS/JavaScript等前端开发技术\',
\'掌握Vue/React/小程序等前端技术与框架之一\',
\'需要有项目经历和比赛奖项\'', 2, '2024-09-22 14:52:14', '\'熟练使用HTML/CSS/JavaScript等前端开发技术\',
\'掌握Vue/React/小程序等前端技术与框架之一\',
\'需要有项目经历和比赛奖项\'');
INSERT INTO wlmtsys_info.employ (id, title, work, requirement, label, create_time, description) VALUES (18, '后端开发', '主要承担实验室项目的服务器端开发工作。进行数据库管理、业务逻辑处理以及系统架构搭建，确保项目的稳定运行和高效数据处理。', '熟练使用Python/Java/C++等后端开发语言\',\'掌握MySQL/MongoDB/Redis等数据库技术\',\'掌握Flask/Django/Spring/SpringBoot/SpringCloud等后端框架之一\',\'需要有项目经历和比赛奖项', 2, '2024-09-22 14:52:29', '熟练使用Python/Java/C++等后端开发语言\',\'掌握MySQL/MongoDB/Redis等数据库技术\',\'掌握Flask/Django/Spring/SpringBoot/SpringCloud等后端框架之一\',\'需要有项目经历和比赛奖项');
INSERT INTO wlmtsys_info.employ (id, title, work, requirement, label, create_time, description) VALUES (19, '剪辑师', '对实验室的视频素材进行剪辑和后期制作。通过创意剪辑、添加特效、调整色彩等手段，将原始素材转化为精彩的视频作品，用于项目展示、宣传等。', '1练掌握至少一种视频剪辑软件，如 Adobe Premiere Pro、Final Cut Pro 等。
2好的节奏感和叙事能力，能够将素材剪辑成精彩的视频作品。
3解视频特效和调色技巧，提升视频质量。
4有创意，能够根据不同主题和需求进行剪辑创作。
', 2, '2024-09-22 15:07:48', '1练掌握至少一种视频剪辑软件，如 Adobe Premiere Pro、Final Cut Pro 等。
2好的节奏感和叙事能力，能够将素材剪辑成精彩的视频作品。3解视频特效和调色技巧，提升视频质量。4有创意，能够根据不同主题和需求进行剪辑创作。
');
INSERT INTO wlmtsys_info.employ (id, title, work, requirement, label, create_time, description) VALUES (20, '摄影师', '负责拍摄实验室的各项活动、实验场景以及成果展示等照片。以专业的摄影技术捕捉精彩瞬间，为实验室提供高质量的视觉素材。', '1悉摄影设备的操作，掌握基本的摄影技巧。2良好的构图和光影把握能力。3根据不同场景和要求进行拍摄，提供高质量的照片素材。4一定的后期处理能力，如调色、裁剪等
熟练使用Ps等软件\',\'需要摄影作品展示', 2, '2024-09-22 14:54:24', '1悉摄影设备的操作，掌握基本的摄影技巧。2良好的构图和光影把握能力。3根据不同场景和要求进行拍摄，提供高质量的照片素材。4一定的后期处理能力，如调色、裁剪等
熟练使用Ps等软件\',\'需要摄影作品展示');
INSERT INTO wlmtsys_info.employ (id, title, work, requirement, label, create_time, description) VALUES (21, '文案编辑', '撰写实验室各个项目的商业计划书",
\'参与每个项目的讨论', '\'熟练使用Word/Excel/PPT等Office软件\',\'获得过校级及以上的创新创业奖项优先\'', 2, '2024-09-22 14:54:44', '\'熟练使用Word/Excel/PPT等Office软件\',\'获得过校级及以上的创新创业奖项优先\'');
INSERT INTO wlmtsys_info.employ (id, title, work, requirement, label, create_time, description) VALUES (22, 'UI设计师', '负责实验室项目的用户界面设计。结合用户需求和审美趋势，设计出简洁美观、操作便捷的界面，提升用户对项目的第一印象和使用感受。', '1用户体验有深刻的理解，能够从用户角度出发进行界面设计，注重交互性和易用性。
2有良好的色彩搭配和排版能力，能够创造出美观、舒适的视觉效果。
3悉不同平台（如网页、移动应用等）的设计规范和特点，确保设计的一致性和适配性。
4有创新思维和创意能力，能够为实验室项目带来独特的设计风格和视觉亮点。', 2, '2024-09-22 15:08:32', '熟练使用Ps等软件\',\'需要设计作品展示');
INSERT INTO wlmtsys_info.employ (id, title, work, requirement, label, create_time, description) VALUES (23, '产品经理', '负责规划、开发和推广产品的专业人员。他们需要理解市场需求，定义产品愿景，并推动产品从概念到市场的整个过程。', '1能够领导跨职能团队，推动项目向前发展。
2能够使用数据和分析来指导产品决策。
3对用户体验（UX）设计有深刻理解，能够创造以用户为中心的产品。4能够管理复杂的项目，确保按时交付', 2, '2024-09-22 15:08:55', '1能够领导跨职能团队，推动项目向前发展。2能够使用数据和分析来指导产品决策。3对用户体验（UX）设计有深刻理解，能够创造以用户为中心的产品。4能够管理复杂的项目，确保按时交付');
INSERT INTO wlmtsys_info.employ (id, title, work, requirement, label, create_time, description) VALUES (24, '销售', '推广实验室的项目成果和服务，寻找合作机会和客户资源。通过有效的销售策略和良好的客户关系管理，为实验室带来经济效益和发展机遇。', '1备良好的沟通能力和销售技巧。2较强的市场开拓能力和客户服务意识。3够制定销售计划和策略，完成销售任务。4团队合作精神，能够与其他部门协作配合。', 2, '2024-09-22 14:51:44', '1备良好的沟通能力和销售技巧。2较强的市场开拓能力和客户服务意识。3够制定销售计划和策略，完成销售任务。4团队合作精神，能够与其他部门协作配合。');
INSERT INTO wlmtsys_info.employ (id, title, work, requirement, label, create_time, description) VALUES (25, '推文编写', '负责实验室的社交媒体账号运营和推文撰写。通过生动有趣的文字和精美的图片，向外界宣传实验室的成果、活动和理念，提升实验室的知名度和影响力。', '1较强的文字功底，能够撰写吸引人的推文内容。
2悉社交媒体平台的运营规则和技巧。
3良好的审美能力，能够进行图文排版和编辑。
4注热点话题，有敏锐的新闻嗅觉和创新思维。', 2, '2024-09-22 15:06:56', '1较强的文字功底，能够撰写吸引人的推文内容。2悉社交媒体平台的运营规则和技巧。3良好的审美能力，能够进行图文排版和编辑。4注热点话题，有敏锐的新闻嗅觉和创新思维。');
INSERT INTO wlmtsys_info.employ (id, title, work, requirement, label, create_time, description) VALUES (26, '演讲', '代表实验室在各种场合进行项目展示和演讲。以清晰的表达、自信的台风和深入的专业知识，向观众传达实验室的创新成果和价值。', '1备良好的口头表达能力和演讲技巧。
2够自信地在公众场合展示项目成果和观点。
3较强的逻辑思维和应变能力，能够回答观众提问。
4悉 PPT 制作，能够辅助演讲进行展示。', 2, '2024-09-22 15:08:44', '1备良好的口头表达能力和演讲技巧。2够自信地在公众场合展示项目成果和观点。3较强的逻辑思维和应变能力，能够回答观众提问。4悉 PPT 制作，能够辅助演讲进行展示。');
INSERT INTO wlmtsys_info.employ (id, title, work, requirement, label, create_time, description) VALUES (27, '前端开发', '负责实验室相关项目的用户界面设计与开发。通过运用前端技术，打造美观、易用且交互性强的网页和应用界面，为用户带来优质的视觉体验和便捷的操作感受。', '\'熟练使用HTML/CSS/JavaScript等前端开发技术\',
\'掌握Vue/React/小程序等前端技术与框架之一\',
\'需要有项目经历和比赛奖项\'', 3, '2024-09-22 14:52:14', '\'熟练使用HTML/CSS/JavaScript等前端开发技术\',
\'掌握Vue/React/小程序等前端技术与框架之一\',
\'需要有项目经历和比赛奖项\'');
INSERT INTO wlmtsys_info.employ (id, title, work, requirement, label, create_time, description) VALUES (28, '后端开发', '主要承担实验室项目的服务器端开发工作。进行数据库管理、业务逻辑处理以及系统架构搭建，确保项目的稳定运行和高效数据处理。', '熟练使用Python/Java/C++等后端开发语言\',\'掌握MySQL/MongoDB/Redis等数据库技术\',\'掌握Flask/Django/Spring/SpringBoot/SpringCloud等后端框架之一\',\'需要有项目经历和比赛奖项', 3, '2024-09-22 14:52:29', '熟练使用Python/Java/C++等后端开发语言\',\'掌握MySQL/MongoDB/Redis等数据库技术\',\'掌握Flask/Django/Spring/SpringBoot/SpringCloud等后端框架之一\',\'需要有项目经历和比赛奖项');
INSERT INTO wlmtsys_info.employ (id, title, work, requirement, label, create_time, description) VALUES (29, '剪辑师', '对实验室的视频素材进行剪辑和后期制作。通过创意剪辑、添加特效、调整色彩等手段，将原始素材转化为精彩的视频作品，用于项目展示、宣传等。', '1练掌握至少一种视频剪辑软件，如 Adobe Premiere Pro、Final Cut Pro 等。
2好的节奏感和叙事能力，能够将素材剪辑成精彩的视频作品。
3解视频特效和调色技巧，提升视频质量。
4有创意，能够根据不同主题和需求进行剪辑创作。
', 3, '2024-09-22 15:07:42', '1练掌握至少一种视频剪辑软件，如 Adobe Premiere Pro、Final Cut Pro 等。
2好的节奏感和叙事能力，能够将素材剪辑成精彩的视频作品。3解视频特效和调色技巧，提升视频质量。4有创意，能够根据不同主题和需求进行剪辑创作。
');
INSERT INTO wlmtsys_info.employ (id, title, work, requirement, label, create_time, description) VALUES (30, '摄影师', '负责拍摄实验室的各项活动、实验场景以及成果展示等照片。以专业的摄影技术捕捉精彩瞬间，为实验室提供高质量的视觉素材。', '1悉摄影设备的操作，掌握基本的摄影技巧。
2良好的构图和光影把握能力。
3根据不同场景和要求进行拍摄，提供高质量的照片素材。
4一定的后期处理能力，如调色、裁剪等
熟练使用Ps等软件\',\'需要摄影作品展示', 3, '2024-09-22 15:05:58', '1悉摄影设备的操作，掌握基本的摄影技巧。2良好的构图和光影把握能力。3根据不同场景和要求进行拍摄，提供高质量的照片素材。4一定的后期处理能力，如调色、裁剪等
熟练使用Ps等软件\',\'需要摄影作品展示');
INSERT INTO wlmtsys_info.employ (id, title, work, requirement, label, create_time, description) VALUES (31, '文案编辑', '撰写实验室各个项目的商业计划书",
\'参与每个项目的讨论', '\'熟练使用Word/Excel/PPT等Office软件\',\'获得过校级及以上的创新创业奖项优先\'', 3, '2024-09-22 14:54:44', '\'熟练使用Word/Excel/PPT等Office软件\',\'获得过校级及以上的创新创业奖项优先\'');
INSERT INTO wlmtsys_info.employ (id, title, work, requirement, label, create_time, description) VALUES (32, 'UI设计师', '负责实验室项目的用户界面设计。
结合用户需求和审美趋势，设计出简洁美观、操作便捷的界面，提升用户对项目的第一印象和使用感受。', '1用户体验有深刻的理解，能够从用户角度出发进行界面设计，注重交互性和易用性。
2有良好的色彩搭配和排版能力，能够创造出美观、舒适的视觉效果。
3悉不同平台（如网页、移动应用等）的设计规范和特点，确保设计的一致性和适配性。
4有创新思维和创意能力，能够为实验室项目带来独特的设计风格和视觉亮点。', 3, '2024-09-22 15:09:22', '熟练使用Ps等软件\',\'需要设计作品展示');
INSERT INTO wlmtsys_info.employ (id, title, work, requirement, label, create_time, description) VALUES (33, '产品经理', '负责规划、开发和推广产品的专业人员。他们需要理解市场需求，定义产品愿景，并推动产品从概念到市场的整个过程。', '1能够领导跨职能团队，推动项目向前发展。2能够使用数据和分析来指导产品决策。3对用户体验（UX）设计有深刻理解，能够创造以用户为中心的产品。4能够管理复杂的项目，确保按时交付', 3, '2024-09-22 14:51:20', '1能够领导跨职能团队，推动项目向前发展。2能够使用数据和分析来指导产品决策。3对用户体验（UX）设计有深刻理解，能够创造以用户为中心的产品。4能够管理复杂的项目，确保按时交付');
INSERT INTO wlmtsys_info.employ (id, title, work, requirement, label, create_time, description) VALUES (35, '推文编写', '负责实验室的社交媒体账号运营和推文撰写。通过生动有趣的文字和精美的图片，向外界宣传实验室的成果、活动和理念，提升实验室的知名度和影响力。', '1较强的文字功底，能够撰写吸引人的推文内容。
2悉社交媒体平台的运营规则和技巧。
3良好的审美能力，能够进行图文排版和编辑。
4注热点话题，有敏锐的新闻嗅觉和创新思维。', 3, '2024-09-22 15:07:17', '1较强的文字功底，能够撰写吸引人的推文内容。2悉社交媒体平台的运营规则和技巧。3良好的审美能力，能够进行图文排版和编辑。4注热点话题，有敏锐的新闻嗅觉和创新思维。');
