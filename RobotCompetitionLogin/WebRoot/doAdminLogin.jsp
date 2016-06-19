<%@ page language="java" import="java.util.*,com.yupeng.biz.*,com.yupeng.biz.impl.*" pageEncoding="utf-8"%>
<%
   request.setCharacterEncoding("utf-8");
	String adminName=request.getParameter("adminName");
	String adminPassword=request.getParameter("adminPassword");
	AdministratorInfoBiz aib=new AdministratorInfoBizImpl();
	String password="";
	password=aib.getByAdministratorName(adminName).trim();


	if(password==null||password.equals("")){
		session.setAttribute("login","该用户不存在，请重新登录");
		response.sendRedirect("adminLogin.jsp");
	}else if(adminPassword==null||adminPassword.isEmpty()){
		session.setAttribute("login","密码不能为空，请重新登录");
		response.sendRedirect("adminLogin.jsp");
	}else if(adminPassword.equals(password)){
		session.setAttribute("login","RobotCompetitionLoginAdmin");
		response.sendRedirect("admin.jsp");		
	}else {
		session.setAttribute("login","密码不正确，请重新登录");
		response.sendRedirect("adminLogin.jsp");
	}

%>