<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/doRegisterTop" />
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
if(request.getParameter("subjectId")==null){
	response.sendRedirect("registerSelectSubject.jsp");
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
<style>
	span { font-size: 16px; font-family:'微软雅黑'; }
	.check {text-align:left; color: red; font-size: 14px; margin-left: 10px;  visibility: hidden;}
</style>
<body style="text-align:center; ">
<div style="background-color:#39C; margin:0px auto; width:733px; height:1800px; text-align: left ">
<img src="image/top.jpg"  />
<p><span style="font-size:24px; font-family:'微软雅黑'; margin-left: 240px;">大学生机器人竞赛组队注册  </span></p>
<div style="padding-left: 210px;">

<br/>
<form method="post" action="doRegisterBottom" onsubmit="return check()">



<input type="hidden" name="subjectId" value="${subjectId}" />
<input type="hidden" name="peopleNumber" value="${peopleNumber}" />

	<p><span>组队名称：</span>&nbsp;<input id="teamName" name="teamName" type="text" size="28" maxlength="28" onblur="teamNameBlur()" onfocus="teamNameFocus()"><span class="check" id="teamNameSpan">组队名称不能为空</span></p>


	<p> <span>设置密码：</span>&nbsp;<input id="password" name="password" type="password" size="28" maxlength="28" onblur="passwordBlur()" onfocus="passwordFocus()"><span class="check" id="passwordSpan">组队密码大于6位</span></p>
	

	<p ><span>确认密码：</span>&nbsp;<input id="passwordAgain" name="passwordAgain" type="password" size="28" maxlength="28" onblur="passwordAgainBlur()" onfocus="passwordAgainFocus()"><span class="check" id="passwordAgainSpan">两次密码输入不一致</span></p>


	<p><span>指导老师：</span>&nbsp;<input name="teacherName" type="text" size="28"></p>




	<p> <span style="margin-left: -80px;">---------------------------默认学生1为队长----------------------------</span></p>


 <c:forEach var="i" begin="1" end="${peopleNumber}" step="1"> 
 <p></p>
 <p><span >学生${i}：</span></p>



	<p><span >学生姓名：</span>&nbsp;<input id="studentName${i}" name="studentName${i}" type="text" size="28" maxlength="28" onblur="studentNameBlur(${i})" onfocus="studentNameFocus(${i})"><span class="check" id="studentNameSpan${i}">姓名不能为空</span></p>



	<p><span >学生学号：</span>&nbsp;<input id="studentId${i}" name="studentId${i}" type="text" size="28" maxlength="28"  onblur="studentIdBlur(${i})" onfocus="studentIdFocus(${i})"><span class="check" id="studentIdSpan${i}">学号不能为空</span></p>


	<p><span>所在学院：</span><select id="studentInstitute${i}" name="studentInstitute${i}"  style="width:210px;">
<option value="机械工程与应用电子技术学院" >机械工程与应用电子技术学院</option>
<option selected="selected" value="电子信息与控制工程学院">电子信息与控制工程学院</option>
<option value="建筑工程学院">建筑工程学院</option>
 <option value="环境与能源工程学院">环境与能源工程学院</option>
 <option value="应用数理学院">应用数理学院</option>
 <option value="计算机学院">计算机学院</option>
 <option value="材料科学与工程学院">材料科学与工程学院</option>
 <option value="生命科学与生物工程学院">生命科学与生物工程学院</option>
 <option value="软件学院">软件学院</option>
 <option value="建筑与城市规划学院">建筑与城市规划学院</option>
 <option value="经济与管理学院">经济与管理学院</option>
 <option value="人文社会科学学院">人文社会科学学院</option>
 <option value="外国语学院">外国语学院</option>
 <option value="艺术设计学院">艺术设计学院</option>
 <option value="激光工程研究院">激光工程研究院</option>
 <option value="循环经济研究院">循环经济研究院</option>
 <option value="固体微结构与性能研究所">固体微结构与性能研究所</option>
 <option value="高等教育研究所">高等教育研究所</option>
 <option value="实验学院">实验学院</option>
 <option value="继续教育学院">继续教育学院</option>
 <option value="体育教学部">体育教学部</option>
 <option value="北京工业大学耿丹学院">北京工业大学耿丹学院</option>
 <option value="马克思主义学院">马克思主义学院</option>
 <option value="北京-都柏林国际学院">北京-都柏林国际学院</option>
        </select>
    </p>

	

	<p><span>联系电话：</span>&nbsp;<input id="studentPhone${i}" name="studentPhone${i}" type="text" size="28"></p>


	<p><span>联系邮箱：</span>&nbsp;<input id="studentEmail${i}" name="studentEmail${i}" type="text" size="28"></p>


 </c:forEach>
<br/>
<p style="margin-left: 50px;"><input type="submit" value=" 确 认 提 交  ">&nbsp;&nbsp;&nbsp;&nbsp; <input type="button" value=" 取 消 返 回   " onclick="javascript:location.href='main.html'"></p>



</form>
</div>
</div>
</body>
</html>
<script type="text/javascript">
	var k=${peopleNumber};

 	function teamNameBlur(){
 		var teamNameInput=document.getElementById("teamName");
 		var teamNameSpan=document.getElementById("teamNameSpan");
 		if(teamNameInput.value.length>0){
 			teamNameSpan.style.visibility="hidden";
 			return true;
 		}else{
 			teamNameSpan.style.visibility="visible";
 			return false;
 		}
 	}
 	function teamNameFocus(){
 		document.getElementById("teamNameSpan").style.visibility="hidden";
 	}
 	
 	function passwordBlur(){
 		var passwordInput=document.getElementById("password");
 		var passwordSpan=document.getElementById("passwordSpan");
 		if(passwordInput.value.length>=6){
 			passwordSpan.style.visibility="hidden";
 			return true;
 		}else{
 			passwordSpan.style.visibility="visible";
 			return false;
 		}
 	}
 	function passwordFocus(){
 		document.getElementById("passwordSpan").style.visibility="hidden";
 	}
 	
 	function passwordAgainBlur(){
 		var passwordInput=document.getElementById("password");
 		var passwordAgainInput=document.getElementById("passwordAgain");
 		var passwordAgainSpan=document.getElementById("passwordAgainSpan");
 		if(passwordAgainInput.value==passwordInput.value){
 			passwordAgainSpan.style.visibility="hidden";
 			return true;
 		}else{

 			passwordAgainSpan.style.visibility="visible";
 			return false;
 		}
 	}
 	function passwordAgainFocus(){
 		document.getElementById("passwordAgainSpan").style.visibility="hidden";
 	}
 	
 	function studentNameBlur(j){
 		var studentNameInputString ="studentName"+j;
 		var studentNameSpanString="studentNameSpan"+j;
 		var studentIdInputString ="studentId"+j;
 		var studentIdSpanString="studentIdSpan"+j;
 		
 		var studentNameInput=document.getElementById(studentNameInputString);
 		var studentNameSpan=document.getElementById(studentNameSpanString);
 		var studentIdInput=document.getElementById(studentIdInputString);
 		var studentIdSpan=document.getElementById(studentIdSpanString);
 		if(j==1){
 			if(studentNameInput.value.length>0){
 				studentNameSpan.style.visibility="hidden";
 				return true;
 			}else{
 				studentNameSpan.style.visibility="visible";
 				return false;
 			}	
 		}else{
	 		if(studentIdInput.value.length>0){
	 				if(studentNameInput.value.length>0){
	 				studentNameSpan.style.visibility="hidden";
	 				return true;
	 			}else{
	 				studentNameSpan.style.visibility="visible";
	 				return false;
	 			}	
 			}else{
 				studentNameSpan.style.visibility="hidden";
 				return true;
 			}
 		}	
 	}
 	function studentNameFocus(j){
 		 var studentNameSpanString="studentNameSpan"+j;
 		 document.getElementById(studentNameSpanString).style.visibility="hidden";
 		 
 	}
 	
 	
 	 function studentIdBlur(j){
 		var studentNameInputString ="studentName"+j;
 		var studentNameSpanString="studentNameSpan"+j;
 		var studentIdInputString ="studentId"+j;
 		var studentIdSpanString="studentIdSpan"+j;
 		
 		var studentNameInput=document.getElementById(studentNameInputString);
 		var studentNameSpan=document.getElementById(studentNameSpanString);
 		var studentIdInput=document.getElementById(studentIdInputString);
 		var studentIdSpan=document.getElementById(studentIdSpanString);
 		if(j==1){
 			if(studentIdInput.value.length>0){
 				studentIdSpan.style.visibility="hidden";
 				return true;
 			}else{
 				studentIdSpan.style.visibility="visible";
 				return false;
 			}	
 		}else{
	 		if(studentNameInput.value.length>0){
	 			if(studentIdInput.value.length>0){
	 				studentIdSpan.style.visibility="hidden";
	 				return true;
	 			}else{
	 				studentIdSpan.style.visibility="visible";
	 				return false;
	 			}	
 			}else{
 				studentIdSpan.style.visibility="hidden";
 				return true;
 			}
 		}	
 	}
 	function studentIdFocus(j){
 		 var studentIdSpanString="studentIdSpan"+j;
 		 	document.getElementById(studentIdSpanString).style.visibility="hidden";
 		 
 	}
 	
 	
 	function check(){

		var flag=true;
 			
	 	for(var t=1;t<=k;t++){
		
	 		if((studentNameBlur(t)==false)||(studentIdBlur(t)==false)){
	 			flag=false;
	 			break;
	 		}
	 	}
 		if((teamNameBlur()==true)&&(passwordBlur()==true)&&(passwordAgainBlur()==true)&&flag){
 			

 			return true;
 		
 		}else{
 				alert("提交信息不符合标准，请检查……");
 				return false;
 		}
 	}
 	


</script>
