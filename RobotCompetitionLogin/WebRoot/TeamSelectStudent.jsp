<%@ page language="java" import="java.util.*,com.yupeng.entity.*,com.yupeng.biz.*,com.yupeng.biz.impl.*" pageEncoding="utf-8"%>
<%@ include file="teamLoginSession.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List<StudentInfo>  list=(ArrayList<StudentInfo>)session.getAttribute("listStudent");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<style>
	span { font-size: 16px; font-family:'微软雅黑'; }
	.check {text-align:left; color: red; font-size: 14px; margin-left: 10px;  visibility: hidden;}
</style>
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
<%@ include file="TeamMenu.jsp" %>

<br/>
<br/>
	<div>
	<span style="font-size:20px; font-family:'微软雅黑';">竞赛通知 </span>
	<br/>
	<br/>
	<select id="student" style="margin-left: -260px; width: 100px;" onchange="changeValue()">
	<c:forEach var="i" begin="1" end="${peopleNumber}" step="1"> 
		<option  value="${i}"  > student${i} </option>
	</c:forEach>
	</select>
	<br/>
	<br/>
	<br/>
	<br/>

	
<form action="doTeamUpdateStudent" method="post" onsubmit="return check()">
<p><span>学生姓名：</span>&nbsp;<input id="studentName" name="studentName" type="text" size="28" maxlength="28" onblur="studentNameBlur()" onfocus="studentNameFocus()"><span class="check" id="studentNameSpan">姓名不能为空</span></p>

<p><span>学生学号：</span>&nbsp;<input id="studentId" name="studentId" type="text" size="28" maxlength="28"  onblur="studentIdBlur()" onfocus="studentIdFocus()"><span class="check" id="studentIdSpan">学号不能为空</span></p>
<input type="hidden" name="oldStudentId" value="">

<p><span>所在学院：</span>&nbsp;<select id="studentInstitute" name="studentInstitute"  style="width:210px;">
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
</select><span class="check" id="studentInsituteSpan">选择所在学院</span>
</p>

	

<p><span>联系电话：</span>&nbsp;<input id="studentPhone" name="studentPhone" type="text" size="28"><span class="check" id="studentPhoneSpan">正确填写电话</span>


<p><span>&nbsp;联系邮箱：</span>&nbsp;<input id="studentEmail" name="studentEmail" type="text" size="28"><span class="check" id="studentEmialSpan">正确填写邮箱</span>

<br/>
<br/>

<p><input type="submit" value="确认修改" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" onclick="returnBack()" value=" 返 回 " />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>	
		
</form>
	<br/>
	</div>

</div>
</body>
</html>
<script type="text/javascript">
	changeValue();


	function changeValue(){
		var student=document.getElementById("student");
		var num=student.value;
		var studentNameInput=document.getElementById("studentName");
		var studentIdInput=document.getElementById("studentId");
		var studentInstituteInput=document.getElementById("studentInstitute");
		var studentPhoneInput= document.getElementById("studentPhone");
		var studentEmailInput= document.getElementById("studentEmail");
		var oldStudentId=document.getElementById("oldStudentId");
		if(num=="1"){
			studentNameInput.value="<%= list.get(0).getStudentName()%>";
			studentIdInput.value="<%= list.get(0).getStudentId()%>";
			studentInstituteInput.value="<%= list.get(0).getStudentInstitute()%>";
			studentPhoneInput.value="<%= list.get(0).getStudentPhone()%>";
			studentEmailInput.value="<%= list.get(0).getStudentEmail()%>";
			oldStudentId.value="<%= list.get(0).getStudentId()%>";
		}else if(num=="2"){
			studentNameInput.value="<%= list.get(1).getStudentName()%>";
			studentIdInput.value="<%= list.get(1).getStudentId()%>";
			studentInstituteInput.value="<%= list.get(1).getStudentInstitute()%>";
			studentPhoneInput.value="<%= list.get(1).getStudentPhone()%>";
			studentEmailInput.value="<%= list.get(1).getStudentEmail()%>";
			oldStudentId.value="<%= list.get(1).getStudentId()%>";
		}else if(num=="3"){
			studentNameInput.value="<%= list.get(2).getStudentName()%>";
			studentIdInput.value="<%= list.get(2).getStudentId()%>";
			studentInstituteInput.value="<%= list.get(2).getStudentInstitute()%>";
			studentPhoneInput.value="<%= list.get(2).getStudentPhone()%>";
			studentEmailInput.value="<%= list.get(2).getStudentEmail()%>";
			oldStudentId.value="<%= list.get(2).getStudentId()%>";
		}else if(num=="4"){
			studentNameInput.value="<%= list.get(3).getStudentName()%>";
			studentIdInput.value="<%= list.get(3).getStudentId()%>";
			studentInstituteInput.value="<%= list.get(3).getStudentInstitute()%>";
			studentPhoneInput.value="<%= list.get(3).getStudentPhone()%>";
			studentEmailInput.value="<%= list.get(3).getStudentEmail()%>";
			oldStudentId.value="<%= list.get(3).getStudentId()%>";
		}else{
			studentNameInput.value="<%= list.get(4).getStudentName()%>";
			studentIdInput.value="<%= list.get(4).getStudentId()%>";
			studentInstituteInput.value="<%= list.get(4).getStudentInstitute()%>";
			studentPhoneInput.value="<%= list.get(4).getStudentPhone()%>";
			studentEmailInput.value="<%= list.get(4).getStudentEmail()%>";
			oldStudentId.value="<%= list.get(4).getStudentId()%>";
		}
		
	}
	
	function returnBack(){
		location.href="teamMain.jsp";
	}

	 function studentNameBlur(){
 		var studentNameInput=document.getElementById("studentName");
 		var studentNameSpan=document.getElementById("studentNameSpan");
 		if(studentNameInput.value.length>0){
 			studentNameSpan.style.visibility="hidden";
 			return true;
 		}else{
 			studentNameSpan.style.visibility="visible";
 			return false;
 		}
 	}
 	function studentNameFocus(){
 		document.getElementById("studentNameSpan").style.visibility="hidden";
 	}
 	
 	function studentIdBlur(){
 		var studentIdInput=document.getElementById("studentId");
 		var studentIdSpan=document.getElementById("studentIdSpan");
 		if(studentIdInput.value.length>=6){
 			studentIdSpan.style.visibility="hidden";
 			return true;
 		}else{
 			studentIdSpan.style.visibility="visible";
 			return false;
 		}
 	}
 	function studentIdFocus(){
 		document.getElementById("studentIdSpan").style.visibility="hidden";
 	}
 	
	 	function check(){


 		if((studentNameBlur()==true)&&(studentIdBlur()==true)){
 			
			if(confirm("是否确认修改？")){
 				return true;
 			}
 		
 		}else{
 				alert("提交信息不符合标准，请检查……");
 				return false;
 		}
 	}


</script>
