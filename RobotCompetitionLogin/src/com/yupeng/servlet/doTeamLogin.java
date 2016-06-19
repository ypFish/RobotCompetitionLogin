package com.yupeng.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yupeng.biz.TeamInfoBiz;
import com.yupeng.biz.impl.TeamInfoBizImpl;

public class doTeamLogin extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public doTeamLogin() {
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
		String result="";
		String rightPassword="";
		String teamName=request.getParameter("teamName");
		String teamPassword=request.getParameter("teamPassword").trim();
		if(teamName==null||teamName.isEmpty()){
			
			result="组队名称不存在！请重新登录……";
			session.setAttribute("result",result);
			response.sendRedirect("teamLogin.jsp");
		}else{
			TeamInfoBiz tib=new TeamInfoBizImpl();
			rightPassword=tib.login(teamName).trim();
			if(rightPassword==null||rightPassword.isEmpty()){
				result="组队名称不存在！请重新登录……";
				session.setAttribute("result",result);
				response.sendRedirect("teamLogin.jsp");
			}else{
				if(!rightPassword.equals(teamPassword)){
					result="登录密码不正确！请重新登录……";
					session.setAttribute("result",result);
					response.sendRedirect("teamLogin.jsp");
				}else{
					result="RobotCompetitionLoginTeam";
					session.setAttribute("result",result);
					session.setAttribute("resultId",tib.getId(teamName,teamPassword));
					response.sendRedirect("teamMain.jsp");
				}
				
			}
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
