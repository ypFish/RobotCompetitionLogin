package com.yupeng.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yupeng.biz.SubjectInfoBiz;
import com.yupeng.biz.TeamInfoBiz;
import com.yupeng.biz.impl.SubjectInfoBizImpl;
import com.yupeng.biz.impl.TeamInfoBizImpl;
import com.yupeng.entity.SubjectInfo;
import com.yupeng.entity.TeamInfo;

public class doAdminSelectTeam extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public doAdminSelectTeam() {
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
		TeamInfoBiz tib=new TeamInfoBizImpl();
		SubjectInfoBiz sib=new SubjectInfoBizImpl();
		List<SubjectInfo> listSubject=sib.getAll();
		if(listSubject!=null){
			HashMap<Integer,List<TeamInfo>> hmTeam=new HashMap<Integer,List<TeamInfo>>();
			for(SubjectInfo si:listSubject){
				List<TeamInfo> listTeam=tib.getTeamBySubjectId(si.getSubjectId());
					//如果listTeam为空，也放到HashMap中！
					hmTeam.put(si.getSubjectId(),listTeam);
				
			}
			request.setAttribute("listSubject",listSubject);
			request.setAttribute("hmTeam", hmTeam);
			request.getRequestDispatcher("adminSelectTeam.jsp").forward(request,response);
			
		}else{
			response.sendRedirect("NotRecord.jsp");
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
