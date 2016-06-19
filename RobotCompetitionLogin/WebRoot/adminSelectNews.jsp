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
	<div>
	<h3>管理竞赛通知</h3>
	
	<style type="text/css">
		td {width: 120px; text-align: center; font-size: 14px;}

	</style>
	<table>
		<tr>
			<td style="width: 200px;"><h3>发布通知标题</h3></td><td><h3>发布通知时间</h3></td><td><h3>修改</h3></td><td><h3>删除</h3></td>
		</tr>
	<%
		NewsInfoBiz nib=new NewsInfoBizImpl();
		
		List<NewsInfo> listNews=new ArrayList<NewsInfo>();
		listNews=nib.getAll();
		for(NewsInfo ni:listNews){
	%>
		<tr>
			<td style="width: 200px;"><%=ni.getNewsName()%></td><td><%=ni.getDatetime().substring(0,10)%></td>
			<td><a href="doAdminSelectNews.jsp?handle=update&NewsId=<%=ni.getNewsId()%>">[修改]</a></td>
			<td><a href="javascript:;" onclick="deleteNews(<%=ni.getNewsId()%>)">[删除]</a></td>
		</tr>		
	<%
		}
		session.setAttribute("listNews",listNews);
	 %>
	 </table>
	<script type="text/javascript">
	 	function deleteNews(NewsId){
	 		if(confirm("确认是否删除？")){
	 			window.location = ("doAdminDeleteNews.jsp?NewsId="+NewsId);
	 		}
	 	}
	 
	 </script>
	 

	
	
	</div>

</div>
</body>
</html>
