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
import com.yupeng.entity.StudentInfo;

public class doTeamSelectStudent extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public doTeamSelectStudent() {
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

		doPost(request,response);
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
		TeamInfoBiz tib=new TeamInfoBizImpl();
		HttpSession session =request.getSession();
		if(session.getAttribute("resultId")==null){
			response.sendRedirect("teamLogin.jsp");
		}else{
			int teamId=Integer.parseInt(session.getAttribute("resultId").toString().trim());
			int peopleNumber=tib.getPeopleNumber(teamId);
			List<StudentInfo> listStudent=tib.getStudent(teamId);
			for(int i=0;i<4;i++){
				StudentInfo stu=new StudentInfo();
				listStudent.add(stu);
			}
			
			
			session.setAttribute("peopleNumber",peopleNumber);
			
			
			session.setAttribute("listStudent", listStudent);
			response.sendRedirect("TeamSelectStudent.jsp");
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
