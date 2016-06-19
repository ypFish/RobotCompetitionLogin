<%@ page language="java" import="java.util.*,com.yupeng.entity.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ include file="adminLoginSession.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

List<SubjectInfo> listSubject=(ArrayList<SubjectInfo>)request.getAttribute("listSubject");
HashMap<Integer,List<TeamInfo>> hmTeam=	(HashMap<Integer,List<TeamInfo>>)request.getAttribute("hmTeam");
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
  
<body style="text-align:center">&nbsp; 
<img src="image/top.jpg"  />
<div style="background-color:#39C; margin:0px auto; width:733px; height:1300px; ">
<%@ include file="adminMenuLongger.jsp" %>
<style>
	tr{ text-align: center; font-family:"微软雅黑"; font-size: 14px; }
</style>
<br/>

	<div>
	<h3>查看已报名组队信息</h3>
	<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style="font-size: 14px; font-family:'微软雅黑'; text-align: right;">(点击队名可以查看详细信息)</span></p>
	<table border="2 " cellspacing="0" cellpadding="2" bordercolor="white" width="540px" align="center" >
	<tr>
		<td>科目名称</td><td>组数</td><td>组队名称</td><td>组队密码</td>
	</tr>
		<%
		for(SubjectInfo si:listSubject){
			%>
			<tr>
				<td rowspan="<%=(hmTeam.get(si.getSubjectId())).size()%>" ><%=si.getSubjectName() %></td>
				<td rowspan="<%=(hmTeam.get(si.getSubjectId())).size()%>" ><%=(hmTeam.get(si.getSubjectId())).size()%></td>
				<%
				for(TeamInfo ti:(hmTeam.get(si.getSubjectId()))){
					%>
						
						<td><a href="doAdminSelectOneTeam?teamId=<%=ti.getTeamId()%>&subjectName=<%=si.getSubjectName() %>" >[<%=ti.getTeamName() %>]</a></td><td><%=ti.getTeamPassword()%></td>
						
						</tr>
				
					<%
				}

		}
		 %>
	</table>
	</div>

</div>
</body>
</html>
