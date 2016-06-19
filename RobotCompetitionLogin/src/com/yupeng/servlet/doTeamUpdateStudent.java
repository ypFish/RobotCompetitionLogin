package com.yupeng.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yupeng.biz.StudentInfoBiz;
import com.yupeng.biz.TeamInfoBiz;
import com.yupeng.biz.impl.StudentInfoBizImpl;
import com.yupeng.biz.impl.TeamInfoBizImpl;
import com.yupeng.entity.StudentInfo;

public class doTeamUpdateStudent extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public doTeamUpdateStudent() {
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
		StudentInfoBiz sib=new StudentInfoBizImpl();
		TeamInfoBiz tib=new TeamInfoBizImpl();
		int teamId=0;
		String teamResult="";
		boolean flag=true;
		if(session.getAttribute("resultId")!=null){
			teamId=Integer.parseInt(session.getAttribute("resultId").toString().trim());
		}else{
			response.sendRedirect("teamLogin.jsp");
		}
		
		int subjectId=tib.getTeamSubjectId(teamId);
		
		String oldStudentId=request.getParameter("oldStudentId").trim();

		String	studentId=request.getParameter("studentId").trim();

		String studentName=request.getParameter("studentName");
		String studentInstitute=request.getParameter("studentInstitute");
		String studentPhone=request.getParameter("studentPhone");
		String studentEmail=request.getParameter("studentEmail");
		
		StudentInfo studentInfo =new StudentInfo();
		studentInfo.setStudentId(studentId);
		studentInfo.setStudentName(studentName);
		studentInfo.setStudentInstitute(studentInstitute);
		studentInfo.setStudentPhone(studentPhone);
		studentInfo.setStudentEmail(studentEmail);
		studentInfo.setRemark("");
		//提交的学生学号与院学生学号相同
		if(studentId.equals(oldStudentId)){
			if(sib.update(studentInfo)>0){
				teamResult="修改学生信息成功！";
				request.setAttribute("teamResult", teamResult);
				request.getRequestDispatcher("teamUpdateResult.jsp").forward(request, response);
			}
		}else{
			List<Integer> listNewId=tib.getSubjcetId(studentId);
			List<Integer> listOldStudentId=null;
			//提交的学生学号不在任何队中
			if(listNewId==null||listNewId.size()==0){
				//新建此学生
				if(sib.add(studentInfo)>0){
					//替换原来学生信息
					if(tib.updateStudentId(teamId, studentId, oldStudentId)>0){
						teamResult="修改学生信息成功！";
						request.setAttribute("teamResult", teamResult);
						//如果原来学生信息未报名过其他科目，删除原来学生信息
						listOldStudentId=tib.getSubjcetId(oldStudentId);
						if(listOldStudentId==null||listOldStudentId.size()==0){
							
							sib.delete(oldStudentId);
						}
						
						request.getRequestDispatcher("teamUpdateResult.jsp").forward(request, response);
						
					}else{
						teamResult="修改学生信息失败！修改的学生信息有误……";
						request.setAttribute("teamResult", teamResult);
						request.getRequestDispatcher("teamUpdateResult.jsp").forward(request, response);
					}
					
					
				}else{
					teamResult="修改学生信息失败！修改的学生信息有误……";
					request.setAttribute("teamResult", teamResult);
					request.getRequestDispatcher("teamUpdateResult.jsp").forward(request, response);
				}
				
			}else{
				//如果新提交的学生已经报名过，并且报名过相同科目
				for(Integer subId:listNewId){
					if(subjectId==subId){
						flag=false;
						teamResult="修改学生信息失败！修改的学生已报名此科目，请核查……";
						request.setAttribute("teamResult", teamResult);
						request.getRequestDispatcher("teamUpdateResult.jsp").forward(request, response);
					}else{
						continue;
					}
				}
				//如果新提交学生已经报名，但不是相同科目
				if(flag){
					//更新新提交的学生信息，并替换原学生在次队中的信息
					if(sib.update(studentInfo)>0){
						if(tib.updateStudentId(teamId, studentId, oldStudentId)>0){
							teamResult="修改学生信息成功！";
							request.setAttribute("teamResult", teamResult);
							
							//删除旧的不在任何队中的学生信息
							listOldStudentId=tib.getSubjcetId(oldStudentId);
							if(listOldStudentId==null||listOldStudentId.size()==0){
								
								sib.delete(oldStudentId);
							}
							
							request.getRequestDispatcher("teamUpdateResult.jsp").forward(request, response);
						}else{
							teamResult="修改学生信息失败！修改的学生信息有误。";
							request.setAttribute("teamResult", teamResult);
							request.getRequestDispatcher("teamUpdateResult.jsp").forward(request, response);
						}
						
					}else{
						teamResult="修改学生信息失败！修改的学生信息有误。";
						request.setAttribute("teamResult", teamResult);
						request.getRequestDispatcher("teamUpdateResult.jsp").forward(request, response);
					}
					
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
