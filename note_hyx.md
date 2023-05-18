# References

比较简短，掌握MVC框架。<url>https://www.bilibili.com/video/BV18D4y187Rb/?spm_id_from=333.337.search-card.all.click&vd_source=b68d0ac223650fbd49edda7e1f565b7e</url>

比较详细，从p20开始看几个了解一下就行。[21、员工管理系统：首页实现_哔哩哔哩_bilibili](https://www.bilibili.com/video/BV1PE411i7CV?p=21&vd_source=b68d0ac223650fbd49edda7e1f565b7e)

<img src="C:\Users\Heyix\AppData\Roaming\Typora\typora-user-images\image-20230516115456093.png" alt="image-20230516115456093" style="zoom:50%;" />

# MVC开发模式

项目的三个层次

## 模型层

除了`controller`、`resources`、`config`、`annotation`、utils的**其他文件夹**

模型实现的核心逻辑的代码。

> ### interface
>
> 定义好方法、结构。
>
> 不含有实现（像C++的抽象类，不能实现）（Java的特点，多态）。需要由**子类**继承它实现。

### Dao层

直接实现增删改。

### Service层

各个表的实现类。

## 控制器

`Controller`文件夹

负责转发请求，通过request mapping（网址拼接）对请求进行处理。

- 接受请求：（RequestMapping+）**PostMapping** 。
- 响应请求：方法函数，包含少量的逻辑代码，设**返回值**。

## 视图

`resources`

前端界面。有模板可以下载，但是要修改一些地方（thymeleaf标准，加`:th`，清缓存等等）。



# “英语六级考试报考系统”作业要求

## 用户

- 考生
- 教师
- 管理员

框架只有学生和管理员。

## 功能

- 考生信息注册
- 增删改查
- 试题录入
- 报名
- 缴费
- 线上考试答题
- 自动阅卷和教师阅卷（？这是什么）
- 考试结果查询（成绩，是否出席）





# 前后端调用逻辑

<u>从`resources`前端入手</u>，每个信息处的超链接（href），会在url后附上（或直接跳转）到**响应**的页面

由`controller`决定怎么响应。

`controller`里面会调用`service`里的方法，service里会调用相应的`Dao`方法，`Dao`负责底层逻辑的实现（有SQL语句，增删改查功能）。

`entity`中定义实体。

# 备忘

![image-20230516112222260](C:\Users\Heyix\AppData\Roaming\Typora\typora-user-images\image-20230516112222260.png)

注意到时候把这种信息改掉。



### BestMapper

很强大。封装了很多**增删改**的操作。

dao的interface可以继承它。继承后只需要补充自定义的增删改（一般为**复杂查询**）。





页面放到`templetes`下面

资源放到`static`下面



<u>template改完可能要关缓存才能生效。</u>



页面国际化（可以到时候考虑）

# READCODE

home頁面主要呈現的那些`common/header`中

它原來有老師，但是register的时候没有做区分。原来只有username，password，repassword，phone。再加一个选项student/teacher/admin

![image-20230518104847398](C:\Users\Heyix\AppData\Roaming\Typora\typora-user-images\image-20230518104847398.png)

在这写死了全是学生。

![image-20230518105100776](C:\Users\Heyix\AppData\Roaming\Typora\typora-user-images\image-20230518105100776.png)

把那个2改成`role`，可以注册老师了。

## 添加试题（考务人员）

### 试题注册

##### paper

试卷编号

试卷名称（一套卷子共用一个试题名称）

出题人

发布时间

考试id

##### 选择题试题

试卷编号

试题编号

题干

4个选项的内容

答案

##### 主观题试题

试卷编号

试题编号

题干

答案



题干

选项

正确答案



dao->service->controller

注意那些@

**@RequestMapping**和**@Service**