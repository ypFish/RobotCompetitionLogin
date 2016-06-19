<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	if(session.getAttribute("login")!=null){
		if(((String)session.getAttribute("login")).equals("RobotCompetitionLoginAdmin")){
			
		}else{
			response.sendRedirect("adminLogin.jsp");
		}
	}else{
		response.sendRedirect("adminLogin.jsp");
	}

%>
