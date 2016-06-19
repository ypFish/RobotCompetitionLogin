package com.yupeng.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yupeng.biz.TeamInfoBiz;
import com.yupeng.biz.impl.TeamInfoBizImpl;

public class doTeamSelectTeam extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public doTeamSelectTeam() {
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
		HttpSession session=request.getSession();
		if(session.getAttribute("resultId")!=null){
			int teamId=Integer.parseInt(session.getAttribute("resultId").toString().trim());
			TeamInfoBiz tib=new TeamInfoBizImpl();
			List<String> listTeamInfo=tib.getTeamInfo(teamId);
			if(listTeamInfo!=null){
				
					String teamName=listTeamInfo.get(0).toString().trim();
					String teamPassword=listTeamInfo.get(1).toString().trim();
					String teacherName=listTeamInfo.get(2).toString().trim();
					String subjectName=listTeamInfo.get(3).toString().trim();
					session.setAttribute("teamName",teamName);
					session.setAttribute("teamPassword", teamPassword);
					session.setAttribute("teacherName", teacherName);
					session.setAttribute("subjectName", subjectName);
					response.sendRedirect("TeamSelectTeam.jsp");
				
			}else{
				response.sendRedirect("teamLogin.jsp");
			}
		}else{
			response.sendRedirect("teamLogin.jsp");
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
