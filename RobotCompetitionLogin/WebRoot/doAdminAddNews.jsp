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
<br/>
	<div>
	<%
	request.setCharacterEncoding("utf-8");
	if(request.getParameter("newsName")!=null&&!("".equals(request.getParameter("newsName")))){
		
		String newsName=request.getParameter("newsName");
		String newsContent=request.getParameter("newsContent");
		String remark="";

		NewsInfo ni=new NewsInfo(newsName,newsContent,remark);
		NewsInfoBiz nib=new NewsInfoBizImpl();		
		int num=0;
		num=nib.addAll(ni);
		if(num>0){
			out.print("<h3>通知信息添加成功！<h3>");
		}else{
			out.print("<h3>通知信息添加失败！(您添加的数据已经录入，不能重复添加或者录入信息有误。)<h3>");
		}
	}
	 %>
	 <br/>
	 <p>是否继续添加？</p>
	 <br/>
	 
	 <a href="adminAddNews.jsp" >[继续添加]</a>
	 &nbsp;&nbsp;&nbsp;
	 <a href="adminSelectNews.jsp" >[查看数据]</a>

	
	
	</div>

</div>
</body>
</html>
