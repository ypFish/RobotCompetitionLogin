<%@ page language="java" import="java.util.*,com.yupeng.entity.*,com.yupeng.biz.*,com.yupeng.biz.impl.*" pageEncoding="utf-8"%>
<%@ include file="adminLoginSession.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <link rel="shortcut icon" type="image/x-icon" href="image/robot32.ico" media="screen" />
    <base href="<%=basePath%>">
    
    <title>北京工业大学机器人竞赛报名平台</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
<body style="text-align:center">
<img src="image/top.jpg"  />
<div style="background-color:#39C; margin:0px auto; width:733px; height:1000px; ">
<%@ include file="adminMenu.jsp" %>
<br/>
<br/>
	<div>
	<h3>修改竞赛科目信息</h3>
	<br/>
	<br/>
	<br/>
	<% 
		
		request.setCharacterEncoding("utf-8");
		SubjectInfo si=new SubjectInfo();
		si.setSubjectName(request.getParameter("subjectName").trim());
		si.setSubjectId(Integer.parseInt(request.getParameter("subId").trim()));
		
		si.setPeopleNumber( Integer.parseInt(request.getParameter("peopleNumber").trim()));
		si.setSubjectInformation(request.getParameter("subjectInformation").trim());
		si.setRemark("");
		SubjectInfoBiz sib=new SubjectInfoBizImpl();
		int success=sib.updateById(si);
		if(success>0){
			out.print("修改竞赛科目信息成功！");	
		}else{
			out.print("修改竞赛科目信息失败！此科目已有学生报名……");	
		}
	%>
	<br/>
	<br/>

	<a href="adminSelectSubject.jsp">[返回管理竞赛科目]</a>
	
	</div>

</div>
</body>
</html>
