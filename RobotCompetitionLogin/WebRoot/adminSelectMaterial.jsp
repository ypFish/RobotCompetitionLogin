<%@ page language="java" import="java.util.*,com.yupeng.entity.*,com.yupeng.biz.*,com.yupeng.biz.impl.*,java.net.*" pageEncoding="utf-8"%>
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
<div style="background-color:#39C; margin:0px auto; width:733px; height:1000px;" >
<%@ include file="adminMenu.jsp" %>
<br/>
	<div>
	<h3>管理竞赛资料</h3>
	<style type="text/css">
		 td {width: 80px; text-align: center; font-size: 14px;}

	</style>

	<table>
		<tr>
			<td style="width: 240px;"><h3>竞赛资料名称</h3></td><td  style="width: 150px;"><h3>竞赛资料权限</h3></td><td  style="width: 60px"><h3>下载</h3></td><td  style="width: 60px"><h3>删除</h3></td>
		</tr>
	<%
		MaterialInfoBiz mib=new MaterialInfoBizImpl();
		String materialLimitName="";
		
		List<MaterialInfo> listMaterial=mib.getList();
		for(MaterialInfo mi:listMaterial){
		if(mi.getMaterialLimit()==1){
			materialLimitName="管理员可见";
			}else if(mi.getMaterialLimit()==2){
				materialLimitName="管理员/报名组可见";
			}else{
				materialLimitName="全部可见";
		} 
		
%>		
	<tr>
		 <td  style="width: 240px;"><%= mi.getMaterialName()%></td><td  style="width: 150px;"><%=materialLimitName%></td>
			<td  style="width: 60px"><a href="doAdminDownloadMaterial2.jsp?materialURL=<%=mi.getMaterialURL()%>&materialName=<%= mi.getMaterialName() %>" >[下载]</a></td>
			<td  style="width: 60px"><a href="javascript:;" onclick="deleteMaterial(<%=mi.getMaterialId()%>)">[删除]</a></td>
			
	 </tr>	
<% 
		}
		session.setAttribute("listMaterial",listMaterial);
%>
</table>

	<script type="text/javascript">
	 	function deleteMaterial(MaterialId){
	 		if(confirm("确认是否删除？")){
	 			window.location = ("doAdminDeleteMaterial.jsp?materialId="+MaterialId);
	 		}
	 	}
	 
	 </script>
	 
	
	</div>
</div>
</body>
</html>
