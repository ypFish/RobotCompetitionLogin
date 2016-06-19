package com.yupeng.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yupeng.biz.TeamInfoBiz;
import com.yupeng.biz.impl.TeamInfoBizImpl;
import com.yupeng.entity.StudentInfo;
import com.yupeng.entity.TeamInfo;

public class doAdminSelectOneTeam extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public doAdminSelectOneTeam() {
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
		String subjectName=new String(request.getParameter("subjectName").getBytes("iso-8859-1"),"utf-8");
		if(subjectName==null||subjectName.isEmpty()){
			response.sendRedirect("doAdminSelectTeam");
		}else{
			if(request.getParameter("teamId")!=null&&!request.getParameter("teamId").isEmpty()){
				int teamId=Integer.parseInt(request.getParameter("teamId").trim());
				request.setAttribute("subjectName", subjectName);
				TeamInfoBiz tib=new TeamInfoBizImpl();
				TeamInfo ti=tib.getTeamById(teamId);
				if(ti!=null){
					request.setAttribute("teamInfo",ti);
					List<StudentInfo> listStudent=new ArrayList<StudentInfo>();
					
					List<StudentInfo> listS=tib.getStudent(teamId);
					if(listS!=null){
						for(StudentInfo si:listS){
							
							if(si.getStudentId().isEmpty()){
								continue;
							}
							listStudent.add(si);
						}
						
						request.setAttribute("listStudent",listStudent);
						request.getRequestDispatcher("adminSelectOneTeam.jsp").forward(request, response);
					}
				}else{
					response.sendRedirect("doAdminSelectTeam");
				}
			}else{
				response.sendRedirect("doAdminSelectTeam");				
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
