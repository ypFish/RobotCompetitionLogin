package com.yupeng.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yupeng.biz.TempTeamResultDaoBiz;
import com.yupeng.biz.impl.TempTeamResultBizImpl;
import com.yupeng.entity.MiniSubjectInfo;
import com.yupeng.entity.TempTeamResult;

public class doAdminSelectResult extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public doAdminSelectResult() {
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
		TempTeamResultDaoBiz ttrb=new TempTeamResultBizImpl();
		List<TempTeamResult> listTempTeamResult=new ArrayList<TempTeamResult>();
		List<TempTeamResult> listTempTeamResult2=ttrb.getAllTempTeamResult();
		if(listTempTeamResult2.size()==0){
			response.sendRedirect("NotRecord.jsp");
		}else{
			List<MiniSubjectInfo> MiniSubject=new ArrayList<MiniSubjectInfo>();
			String subjectName=listTempTeamResult2.get(0).getTtSubjectName();
			MiniSubjectInfo mini=new MiniSubjectInfo();
			mini.setSubjectId(listTempTeamResult2.get(0).getTtSubjectId());
			mini.setSubjectName(listTempTeamResult2.get(0).getTtSubjectName());
			MiniSubject.add(mini);
			String subject=listTempTeamResult2.get(0).getTtSubjectName();
			for(TempTeamResult ttr:listTempTeamResult2){
				if(!ttr.getTtSubjectName().trim().equals(subject)){
					subject=ttr.getTtSubjectName().trim();
					MiniSubjectInfo mini2=new MiniSubjectInfo();
					mini2.setSubjectId(ttr.getTtSubjectId());
					mini2.setSubjectName(ttr.getTtSubjectName());
					MiniSubject.add(mini2);
				}	
			}
			session.setAttribute("MiniSubject", MiniSubject);
			String sName=request.getParameter("sName");

			if(sName==null||sName.isEmpty()){
				for(TempTeamResult ttr:listTempTeamResult2){
					if(ttr.getTtSubjectName().trim().equals(mini.getSubjectName())){
						listTempTeamResult.add(ttr);
					}
				}
			}else{
				for(TempTeamResult ttr:listTempTeamResult2){
					if(ttr.getTtSubjectId()==Integer.parseInt(sName.trim())){
						listTempTeamResult.add(ttr);
					}
				}
			}
			
			session.setAttribute("listTempTeamResult", listTempTeamResult);
			response.sendRedirect("adminSelectResult.jsp");
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
