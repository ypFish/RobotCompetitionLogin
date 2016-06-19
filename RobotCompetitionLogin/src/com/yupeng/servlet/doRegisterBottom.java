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
import com.yupeng.entity.TeamInfo;

public class doRegisterBottom extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public doRegisterBottom() {
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

		int success=1;
		String failResult="";
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		HttpSession session =request.getSession();
		TeamInfoBiz tib=new TeamInfoBizImpl();
		int subjectId=-1;
		if(request.getParameter("subjectId")==null||request.getParameter("subjectId").isEmpty()){
			
			response.sendRedirect("registerSelectSubject.jsp");
		}else{
			
			StudentInfoBiz stuBiz=new StudentInfoBizImpl();
			String addTeam[]={"","","","",""};

			int peopleNumber=Integer.parseInt(request.getParameter("peopleNumber").trim());
			for(int i=1;i<=peopleNumber;i++){
				String studentNameString="studentName"+i;
				String studentIdString="studentId"+i;
				String studentInstituteString="studentInstitute"+i;
				String studentPhoneString="studentPhone"+i;
				String studentEmailString="studentEmail"+i;
				
				String studentId=request.getParameter(studentIdString);
				if(studentId!=null&&!studentId.isEmpty()){

					addTeam[i-1]=studentId;
					if(stuBiz.havaStudentId(studentId)==0){
						String studentName=request.getParameter(studentNameString);
						String studentInstitute=request.getParameter(studentInstituteString);
						String studentPhone=request.getParameter(studentPhoneString);
						String studentEmail=request.getParameter(studentEmailString);
						if(studentPhone==null){
							studentPhone="";
						}
						if(studentEmail==null){
							studentEmail="";
						}
						StudentInfo studentInfo=new StudentInfo();
						studentInfo.setStudentId(studentId);
						studentInfo.setStudentName(studentName);
						studentInfo.setStudentInstitute(studentInstitute);
						studentInfo.setStudentPhone(studentPhone);
						studentInfo.setStudentEmail(studentEmail);
						studentInfo.setRemark("");
						success=stuBiz.add(studentInfo);
						if(success>0){
							continue;
						}else{
							break;
						}
					}else{
						List<Integer> listSubjectId=tib.getSubjcetId(studentId);
						subjectId=Integer.parseInt(request.getParameter("subjectId").trim());
						for(Integer subId:listSubjectId){
							if(subId==subjectId){
								success=-1;
								break;
							}
							
						}
						
					}
					
				}
				
				
			}
			
			if(success>0){

				String teamName=request.getParameter("teamName");
				String teamPassword=request.getParameter("password");
				String teacherName=request.getParameter("teacherName");
				subjectId=Integer.parseInt(request.getParameter("subjectId").trim());
				TeamInfo ti=new TeamInfo(teamName,teamPassword,subjectId,teacherName,addTeam[0],addTeam[1],addTeam[2],addTeam[3],addTeam[4],"");

				
				int success2=tib.add(ti);
				
				if(success2>0){
					session.setAttribute("result","RobotCompetitionLoginTeam");
					session.setAttribute("resultId",tib.getId(teamName, teamPassword));
					response.sendRedirect("Team.jsp");
				}else{
					failResult="组队信息填写有误，提示：相同科目每个学生只能报名一次！";
					session.setAttribute("failResult",failResult);
					response.sendRedirect("registerFail.jsp");
				}
				
			}else{
				failResult="学生信息填写有误，提示：相同科目每个学生只能报名一次！";
				session.setAttribute("failResult",failResult);
				response.sendRedirect("registerFail.jsp");
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
