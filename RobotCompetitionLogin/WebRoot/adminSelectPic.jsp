<%@ page language="java" import="java.util.*,com.yupeng.entity.*,com.yupeng.biz.*,com.yupeng.biz.impl.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="adminLoginSession.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
if(session.getAttribute("listShow")==null){
	response.sendRedirect("doAdminSelectStudent");
}
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
<img src="image/top.jpg" width="732px;"  />

<div style="background-color:#39C; margin:0px auto; width:733px; height:1000px; ">

<%@ include file="adminMenu.jsp" %>
<style type="text/css">
	span { font-size: 14px; }

</style>
	<div>
	<br/>
	<h3>统计报名信息</h3>
	<p><span>${unit}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>（推荐使用firefox、chrome等浏览器打开）</span></p>
	<br/>
<div  >


			<input type="button" value="学生学号" onclick="javascript:location.href='doAdminSelectStudent?info=pic&show=byStudentId'">
			<input type="button" value="所在学院" onclick="javascript:location.href='doAdminSelectStudent?info=pic&show=byStudentInstitute'">

			<input type="button" value="科目统计" onclick="javascript:location.href='doAdminSelectStudent?info=pic&show=byTeamName'">
			<input type="button" value="组队统计" onclick="javascript:location.href='doAdminSelectStudent?info=pic&show=byTeamCount'">

	<br/>

</div>


<div id="pic">
<script src="jquery-1.8.2.min.js" type="text/javascript"></script>
<link href="css.css" type="text/css" rel="stylesheet" />
<div  class="histogram-container" id="histogram-container"></div>
</div>
<script type="text/javascript">
$(function(){
var dataArr={
	"data":[

	<c:forEach var="h" items="${listHistogram}">
		{"id":1,"name":"${h.name}","per":"${h.per}"},

	</c:forEach>
	{"id":1,"name":"","per":"0"}
		
	]
	
};
new histogram().init(dataArr.data);
});

function histogram(){
	var controls={};
	var bgColor=new Array("#FF6600","#00FFCC","#2277BB","#dc7644","#BBAA22","#AA22AA","#338800","#9966FF","#ffcc33","#ED3810");
	this.init=function(data,y){
		setControls();
		buildHtml(data,y);
	}
	function setControls(){
		controls.histogramContainer=$("#histogram-container");
		controls.histogramBgLineUL=controls.histogramContainer.children("div.histogram-bg-line");
		controls.histogramContentUL=controls.histogramContainer.children("div.histogram-content");
		controls.histogramY=controls.histogramContainer.children("div.histogram-y");
	}
	function buildHtml(data,y){
		var len=data.length,perArr=new Array(),maxNum,maxTotal,yStr='';
		var contentStr='',bgLineStr='',bgLineAll='';
		var widthPer=Math.floor(100/len);
		minWidth=len*21+60;
		controls.histogramContainer.css("min-width",minWidth+"px");
		
		for(var a=0;a<len;a++){
			perArr[a]=parseInt(data[a]['per']);		
		}
		maxNum=String(perArr.max());
		if(maxNum.length>2){
			var x=parseInt(maxNum.substr(maxNum.length-2,1))+1;
			maxTotal=Math.floor(parseInt(maxNum/100))*100+x*10;
		}else{
			maxTotal=Math.floor(parseInt(maxNum/10))*10+10;
		}
		
		//y轴部分
		if(y=="%"){
			yStr+='<li>100%</li><li>80%</li><li>60%</li><li>40%</li><li>20%</li><li>0%</li>';			
		}else{
			var avg=maxTotal/5;
			for(i=5;i>=0;i--){
				yStr+='<li>'+avg*i+'</li>';
			}
		}
		
		//柱状条部分
		for(var i=0;i<len;i++){
			var per=Math.floor(parseInt(data[i]['per'])/maxTotal*100);
			var n=Math.floor(parseInt(per)/10);
			contentStr+='<li style="width:'+widthPer+'%">';
			contentStr+='<span class="histogram-box"><a style="height:'+per+'%'+';background:'+bgColor[n]+';" title="'+data[i]['per']+'"></a></span><span class="histogram-name">'+data[i]['name']+'</span>';
			contentStr+='</li>';
			bgLineStr+='<li style="width:'+widthPer+'%;"><div></div></li>';
		}
		
		//背景方格部分
		for(var j=0;j<5;j++){
			bgLineAll+='<ul>'+bgLineStr+'</ul>';
		}
		bgLineAll='<div class="histogram-bg-line">'+bgLineAll+'</div>';
		contentStr='<div class="histogram-content"><ul>'+contentStr+'</ul></div>';
		yStr='<div class="histogram-y"><ul>'+yStr+'</ul></div>';
		controls.histogramContainer.html(bgLineAll+contentStr+yStr);
		controls.histogramContainer.css("height",controls.histogramContainer.height()+"px");//主要是解决IE6中的问题		
	}
}
Array.prototype.max = function(){//最大值
 return Math.max.apply({},this) 
} 
</script>
</div>
</div>
</body>
</html>
