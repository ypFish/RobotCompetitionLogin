package com.yupeng.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yupeng.biz.TeamInfoBiz;
import com.yupeng.biz.impl.TeamInfoBizImpl;
import com.yupeng.entity.TeamInfo;

public class doTeamUpdateTeam extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public doTeamUpdateTeam() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		int teamId=Integer.parseInt(session.getAttribute("resultId").toString().trim());
		String teamName=request.getParameter("teamName").trim();
		String teamPassword=request.getParameter("password").trim();
		String teacherName=request.getParameter("teacherName").trim();
		String updateResult="";
		TeamInfo ti=new TeamInfo();
		ti.setTeamId(teamId);
		ti.setTeamName(teamName);
		ti.setTeamPassword(teamPassword);
		ti.setTeacherName(teacherName);
		TeamInfoBiz tib=new TeamInfoBizImpl();
		int success=tib.updateTeam(ti);
		if(success>0){
			updateResult="修改成功！";
			session.setAttribute("updateResult", updateResult);
			response.sendRedirect("teamUpdateTeam.jsp");
		}else{
			updateResult="修改失败，修改的信息不符合要求！";
			session.setAttribute("updateResult", updateResult);
			response.sendRedirect("teamUpdateTeam.jsp");
		}
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
