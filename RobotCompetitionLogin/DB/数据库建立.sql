/*建立数据库：RobotCompetitionLogin*/
create database RobotCompetitionLogin
on primary
(
name='RobotCompetitionLogin_data',
filename='D:\\RobotCompetitionLogin_data.mdf',
size=10mb,
maxsize=100mb,
filegrowth=15%
)
log on(
name='RobotCompetitionLogin_log',
filename='D:\\RobotCompetitionLogin_log.ldf'
)
go

use RobotCompetitionLogin
go

if exists(select * from sys.tables where name='subjectInfo')
drop table subjectInfo
go

/*科目信息表*/
create table subjectInfo
(
subjectId int identity(1,1) primary key,
--科目编号
subjectName char(30) not null,
--科目名称
peopleNumber int not null,
--允许最大报名人数
subjectInformation text,
--科目简介
remark text
--备注信息
)
go


/*管理员信息表*/
create table administratorInfo
(
administratorName char(30) primary key,
--管理员用户名
administratorPassword char(30) not null,
--管理员密码
remark text
--备注信息
)
go


/*报名队员信息表*/
create table studentInfo
(
studentId char(30) primary key,
--学号
studentName char(30) not null,
--姓名
studentInstitute char(30) not null,
--所在学院
studentPhone char(30) ,
--联系电话
studentEmail char(30),
--邮箱
remark text
--备注信息
)
go


/*报名组队信息表*/
create table teamInfo(
teamId int identity(1,1) primary key ,
--组队编号
teamName char(30) not null,
--组队名称
teamPassword char(30) not null,
--密码
subjectId int foreign key references subjectInfo(subjectId),
--科目编号
teacherName char(30),
--指导老师姓名
student1 char(30) foreign key references studentInfo(studentId),
--队员一学号
student2 char(30) foreign key references studentInfo(studentId),
--队员二学号
student3 char(30) foreign key references studentInfo(studentId),
--队员三学号
student4 char(30) foreign key references studentInfo(studentId),
--队员四学号
student5 char(30) foreign key references studentInfo(studentId),
--队员五学号
remark text
--备注信息
)
go


go
/*新闻信息表*/
create table newsInfo(
newsId int identity(1,1) primary key,
--新闻编号
newsName char(30) not null,
--新闻名称
newsContent text not null,
--新闻内容
newsDate datetime ,
--发布时间
remark text
--备注信息

)
go

if exists(select * from sys.tables where name='materialInfo')
drop table materialInfo

/*资料信息表*/
create table materialInfo(
materialId int identity(1,1) primary key,
--资料编号
materialName text not null,
--资料名称
materialLimit  int not null default(2),
--资料权限
materialURL text,
--资料下载地址
remark text
--备注信息
)
go



/*成绩等级表*/
create table rewardInfo(
rewardId int  primary key,
--成绩等级编号
rewardName char(30) not null,
--成绩名称
remark text
--备注信息
)
go


/*成绩信息表*/
create table resultInfo(
resultId int identity(1,1) primary key,
--成绩编号
teamId int foreign key references teamInfo(teamId),
--组队编号
rewardName nchar(30) ,
--成绩等级
remark text
--备注信息
)
go

select studentId ,studentName,studentInstitute,studentPhone,studentEmail from studentInfo where studentId =(select student1 from teamInfo where teamId=3) or studentId=(select student2 from teamInfo where teamId=3) or studentId=(select student3 from teamInfo where teamId=3) or studentId=(select student4 from teamInfo where teamId=3) or studentId=(select student5 from teamInfo where teamId=3) order by studentId desc

select * from teamInfo
update teamInfo set teamName='轨道',teamPassword='10101010',teacherName='虹的' where teamId=3

select teamPassword from teamInfo where teamName='天宫一号'

insert into teamInfo(teamName,teamPassword,subjectId,teacherName,student1,student2,student3,student4,student5,remark)
values('火箭队','1212121',23,'哈哈','09020202','09020201','','','','remark')
select * from studentInfo
select * from teamInfo
delete from studentInfo where studentId=''
if exists(select * from sys.tables where name='subjectInfo')

select * from subjectInfo

insert into administratorInfo values('bjut','bjut123','')


insert into subjectInfo values('ss飞行机器人制作',1,'关于仿真机器人的规则与介绍','')
select subjectId,subjectName,peopleNumber,subjectInformation,remark from subjectInfo
update subjectInfo set subjectName='足球机器人',peopleNumber=3,subjectInformation='关于足球机器人的信息与介绍'
where subjectId=23

select teamId from teamInfo where teamName='火箭队' and teamPassword='1312121'
select * from teamInfo
delete from subjectInfo where subjectId=5


insert into newsInfo(newsName,newsContent,newsDate,remark) values('缴费新通知','2月13日下午9点再缴费',convert(varchar(10),getdate(),120),'')
select * from newsInfo
delete from newsInfo where newsId=1
update newsInfo set newsName='宇宙大爆炸',newsContent='关于宇宙大爆炸的规则与方式',newsDate=convert(varchar(10),getdate(),120) where newsId=4

select newsId,newsName,newsContent,newsDate,remark from newsInfo
select * from studentInfo

update studentInfo set studentId='11100011' where studentId='08020209'

select materialId,materialName,materialLimit,materialURL from materialInfo

select subjectId from teamInfo where student1='09020202' or student2='09020202' or student3='09020202' or student4='09020202' or student5='09020202'
select COUNT(studentId) as 'havaStudentId' from studentInfo where studentId='09020202' and 
insert into studentInfo(studentId,studentName,studentInstitute,studentPhone,studentEmail,remark) values('09020201','yuefe','电子信息与控制工程学院','148324422453','yy@121.com','')

delete from materialInfo where materialId=1

select peopleNumber from subjectInfo where subjectId=(select subjectId from teamInfo where teamId=4)
select subjectId from teamInfo where teamId=4

insert into materialInfo(materialName,materialLimit,materialURL) values('a哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈',3,'upload//关于竞赛规则.docx')

select teamName,teamPassword,teacherName,subjectName from teamInfo inner join subjectInfo on subjectInfo.subjectId=teamInfo.subjectId where teamId=3 

update studentInfo set studentName='赵大可' ,studentInstitute='计算机学院',studentPhone='323123231',studentEmail='lingdian@sina.com' where studentId='08020201'

update teamInfo set student1='r333r3' where student1='' and teamId=3
update teamInfo set student2='r333r3' where student2='' and teamId=3
update teamInfo set student3='r333r3' where student3='' and teamId=3
update teamInfo set student4='r333r3' where student4='' and teamId=3
update teamInfo set student5='r333r3' where student5=''and teamId=3


select * from studentInfo
select * from teamInfo

delete from studentInfo where studentId='09020201'
select student1 from teamInfo where student1='090202'
select teamId,teamName,teamPassword from teamInfo where subjectId=23

select teamName,teamPassword,subjectName,teacherName,student1,studentName,studentInstitute,StudentPhone,studentEmail,student2,student3,student4,student5 from teamInfo inner join subjectInfo on teamInfo.subjectId=subjectInfo.subjectId inner join studentInfo on student1=studentId where teamId=2
select studentId,studentName,studentInstitute,studentPhone from studentInfo


--以组队查询
select subjectName,teamName,studentId,studentName,studentInstitute,studentPhone from teamInfo
 inner join subjectInfo on subjectInfo.subjectId=teamInfo.subjectId 
 inner join studentInfo on student1=studentInfo.studentId
union 
select subjectName,teamName,studentId,studentName,studentInstitute,studentPhone from teamInfo
 inner join subjectInfo on subjectInfo.subjectId=teamInfo.subjectId 
 inner join studentInfo on student2=studentInfo.studentId
union 
select subjectName,teamName,studentId,studentName,studentInstitute,studentPhone from teamInfo
 inner join subjectInfo on subjectInfo.subjectId=teamInfo.subjectId 
 inner join studentInfo on student3=studentInfo.studentId
 union 
select subjectName,teamName,studentId,studentName,studentInstitute,studentPhone from teamInfo
 inner join subjectInfo on subjectInfo.subjectId=teamInfo.subjectId 
 inner join studentInfo on student4=studentInfo.studentId
 union 
select subjectName,teamName,studentId,studentName,studentInstitute,studentPhone from teamInfo
 inner join subjectInfo on subjectInfo.subjectId=teamInfo.subjectId 
 inner join studentInfo on student5=studentInfo.studentId
 order by subjectName 

 


--以学生查询
select studentId,studentName,studentInstitute,studentPhone,(select COUNT(teamId) from teamInfo where student1=studentInfo.studentId or student2=studentInfo.studentId or student3=studentInfo.studentId or student4=studentInfo.studentId or student5=studentInfo.studentId) as 'count' from studentInfo order by studentInstitute desc
select subjectName,teamName from teamInfo inner join subjectInfo on teamInfo.subjectId=subjectInfo.subjectId where student1='r333r3' or student2='r333r3' or student3='r333r3' or student4='r333r3' or student5='r333r3'

select subjectName,teamName from teamInfo inner join subjectInfo on teamInfo.subjectId=subjectInfo.subjectId where student1="+si.getStudentId()+" or student2="+si.getStudentId()+" or student3="+si.getStudentId()+" or student4="+si.getStudentId()+" or student5=''

select rewardName from resultInfo where resultInfo.teamId=2
update resultInfo set rewardName='三等奖' where resultInfo.teamId=2
select * from studentInfo
select * from teamInfo 
select * from resultInfo
delete resultInfo from resultInfo 

select subjectName,teamInfo.teamId,teamName,student1,student1Name=(select studentName from studentInfo where studentId=student1),
student2, student2Name=(select studentName from studentInfo where studentId=student2),
student3, student3Name=(select studentName from studentInfo where studentId=student3),
student4, student4Name=(select studentName from studentInfo where studentId=student4),
student5, student5Name=(select studentName from studentInfo where studentId=student5),
rewardName from teamInfo
left join subjectInfo on subjectInfo.subjectId=teamInfo.subjectId 
 left join resultInfo on resultInfo.teamId=teamInfo.teamId
 order by subjectName,rewardName
 
select * from subjectInfo
insert into resultInfo values(2,'二等奖','')
select * from materialInfo
