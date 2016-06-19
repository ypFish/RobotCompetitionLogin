<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	if(session.getAttribute("result")!=null){
		if(((String)session.getAttribute("result")).equals("RobotCompetitionLoginTeam")){
			
		}else{
			response.sendRedirect("teamLogin.jsp");
		}
	}else{
		response.sendRedirect("teamLogin.jsp");
	}
%>
