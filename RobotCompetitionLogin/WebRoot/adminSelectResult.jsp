<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="adminLoginSession.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<script>
	function check(){

		if(confirm("确认是否提交？")){
			return true;
		}else{
			return false;
		}
	}
</script>
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
 
<style>
	 tr{ text-align: center; font-family:"微软雅黑"; font-size: 14px; }
	 span{ font-family:"微软雅黑"; font-size: 14px;  }
</style>
<body style="text-align:center">

<img src="image/top.jpg"  />
<div style="background-color:#39C; margin:0px auto; width:733px; height:1000px; ">
<%@ include file="adminMenu.jsp" %>

	<div>
	<br/>
	<h3>管理竞赛成绩</h3>
	<br/>
	</div>
<p><span>已报名竞赛科目:&nbsp;&nbsp;</span>
	<c:forEach var="mini" items="${MiniSubject}">
		<span><a href="doAdminSelectResult?sName=${mini.subjectId}" >[${ mini.subjectName }]</a></span>&nbsp;
	</c:forEach>
	</p>
<form action="doAdminUpdateResult" method="post" onsubmit="return check()">
	<table border="2" cellspacing="0" cellpadding="2" bordercolor="white" align="center" width="540px"  >
	<tr>
		<td>报名科目</td> <td>组队名称</td> <td>学生学号</td> <td>学生姓名</td> <td>竞赛成绩</td>
	</tr>
	<c:forEach var="ttrs" items="${listTempTeamResult}">
		<tr>
			<td>${ ttrs.ttSubjectName }</td>
			<td>${ ttrs.ttTeamName }</td>
			<td>
				<table cellspacing="0"  align="center">
					<c:forEach var="ttstudent" items="${ttrs.ttListStudentInfo}" >
						<tr>
							<td>${ttstudent.studentId }</td>
						</tr>
					</c:forEach>
				</table>
			</td>
			<td>
				<table cellspacing="0"   align="center">
					<c:forEach var="ttstudent" items="${ttrs.ttListStudentInfo}" >
						<tr>
							<td>${ttstudent.studentName }</td>
						</tr>
					</c:forEach>
				</table>
			</td>
			
			<td>
				
				  	<select name="${ttrs.ttTeamId}">
				  	<c:choose>
				  		<c:when test="${ttrs.rewardName=='无'}">
				  			<option selected="selected" value="无"  >无</option>
				  			<option  value="参与奖" >参与奖</option>
				  			<option  value="三等奖" >三等奖</option >
				  			<option  value="二等奖" >二等奖</option >
				  			<option  value="一等奖" >一等奖</option >
				  		</c:when>
				  		<c:when test="${ttrs.rewardName=='参与奖'}">
				  			<option  value="无"  >无</option>
				  			<option selected="selected" value="参与奖" >参与奖</option>
				  			<option  value="三等奖" >三等奖</option >
				  			<option  value="二等奖" >二等奖</option >
				  			<option  value="一等奖" >一等奖</option >
				  		</c:when>
				  		<c:when test="${ttrs.rewardName=='三等奖'}">
				  			<option  value="无"  >无</option>
				  			<option  value="参与奖" >参与奖</option>
				  			<option selected="selected" value="三等奖" >三等奖</option >
				  			<option  value="二等奖" >二等奖</option >
				  			<option  value="一等奖" >一等奖</option >
				  		</c:when>
				  		<c:when test="${ttrs.rewardName=='二等奖'}">
				  			<option  value="无"  >无</option>
				  			<option  value="参与奖" >参与奖</option>
				  			<option  value="三等奖" >三等奖</option >
				  			<option selected="selected" value="二等奖" >二等奖</option >
				  			<option value="一等奖" >一等奖</option >
				  		</c:when>
				  		<c:when test="${ttrs.rewardName=='一等奖'}">
				  			<option  value="无"  >无</option>
				  			<option  value="参与奖" >参与奖</option>
				  			<option  value="三等奖" >三等奖</option >
				  			<option  value="二等奖" >二等奖</option >
				  			<option selected="selected" value="一等奖" >一等奖</option >
				  		</c:when>
				  		<c:otherwise>
				  			<option selected="selected" value="无"  >无</option>
				  			<option  value="参与奖" >参与奖</option>
				  			<option  value="三等奖" >三等奖</option >
				  			<option  value="二等奖" >二等奖</option >
				  			<option  value="一等奖" >一等奖</option >
				  		</c:otherwise>
				  	</c:choose>
				  	
				  	
				  	</select>
			</td>
		</tr>
	</c:forEach>
	</table>
	<br/>
	<input type="submit" value="确认提交" />
</form>
	
	

</div>
</body>
</html>
