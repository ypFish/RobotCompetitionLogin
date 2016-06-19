package com.yupeng.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yupeng.entity.SubjectInfo;

public class doPublicSelectOneSubject extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public doPublicSelectOneSubject() {
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
		HttpSession session =request.getSession();
		if(session.getAttribute("listSubject")==null){
			response.sendRedirect("doPublicSelectSubject");
		}else{
			List<SubjectInfo> listSubject=(ArrayList<SubjectInfo>)session.getAttribute("listSubject");
			int subjectId=Integer.parseInt(request.getParameter("subId").trim());
			SubjectInfo si=new SubjectInfo();
			for(SubjectInfo s:listSubject){
				if(subjectId==s.getSubjectId()){
					si=s;
					break;
				}
			}
			request.setAttribute("si",si);
			request.getRequestDispatcher("publicSelectSubjectInfo.jsp").forward(request, response);
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
