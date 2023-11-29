## 本项目实现的最终作用是基于JSP停车位预定管理系统
## 分为2个角色
### 第1个角色为管理员角色，实现了如下功能：
 - 停车位信息管理
 - 注册用户管理
 - 留言信息管理
 - 管理员登录页面
 - 系统帮助管理
 - 车位信息管理
 - 预定信息管理
### 第2个角色为用户角色，实现了如下功能：
 - 个人信息管理
 - 发表留言
 - 查看我的预定信息
 - 查看系统通知
 - 用户登录
 - 用户首页
 - 预定停车位
## 数据库设计如下：
# 数据库设计文档

**数据库名：** tccg

**文档版本：** 


| 表名                  | 说明       |
| :---: | :---: |
| [t_admin](#t_admin) | 管理员表 |
| [t_chewei](#t_chewei) |  |
| [t_liuyan](#t_liuyan) |  |
| [t_ting](#t_ting) |  |
| [t_user](#t_user) | 用户表 |
| [t_yuding](#t_yuding) |  |
| [t_zhengce](#t_zhengce) |  |

**表名：** <a id="t_admin">t_admin</a>

**说明：** 管理员表

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | UserId |   int   | 10 |   0    |    N     |  Y   |       | 用户ID  |
|  2   | username |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 用户名  |
|  3   | userPw |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 密码  |

**表名：** <a id="t_chewei">t_chewei</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | bianhao |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 编号  |
|  3   | quyu |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  4   | zt |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  5   | del |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 是否删除  |

**表名：** <a id="t_liuyan">t_liuyan</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | neirong |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 内容  |
|  3   | liuyanshi |   varchar   | 2000 |   0    |    Y     |  N   |   NULL    |   |
|  4   | user_id |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 用户ID  |
|  5   | huifu |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  6   | huifushi |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |

**表名：** <a id="t_ting">t_ting</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | chewei_id |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  3   | chexing |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  4   | chepai |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  5   | kaishishijian |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  6   | jieshushijian |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  7   | feiyong |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |

**表名：** <a id="t_user">t_user</a>

**说明：** 用户表

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | ID |   varchar   | 255 |   0    |    N     |  Y   |       | 主键  |
|  2   | loginname |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 登录名称  |
|  3   | loginpw |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 登录密码  |
|  4   | xingming |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 姓名  |
|  5   | zhuzhi |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  6   | dianhua |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 电话  |
|  7   | dengji |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  8   | del |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 是否删除  |

**表名：** <a id="t_yuding">t_yuding</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | ID |   varchar   | 255 |   0    |    N     |  Y   |       | 主键  |
|  2   | xingming |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 姓名  |
|  3   | dianhua |   varchar   | 8000 |   0    |    Y     |  N   |   NULL    |   |
|  4   | daodashi |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  5   | chewei_id |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  6   | user_id |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 用户ID  |
|  7   | zt |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |

**表名：** <a id="t_zhengce">t_zhengce</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | ID |   varchar   | 255 |   0    |    N     |  Y   |       | 主键  |
|  2   | biaoti |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 标题  |
|  3   | neirong |   varchar   | 8000 |   0    |    Y     |  N   |   NULL    | 内容  |
|  4   | fujian |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 附件  |
|  5   | shijian |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 创建时间  |

**运行不出来可以微信 javape 我的公众号：源码码头**
