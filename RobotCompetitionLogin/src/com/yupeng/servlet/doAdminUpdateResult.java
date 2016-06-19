package com.yupeng.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yupeng.biz.ResultInfoBiz;
import com.yupeng.biz.impl.ResultInfoBizImpl;
import com.yupeng.entity.ResultInfo;
import com.yupeng.entity.TempTeamResult;

public class doAdminUpdateResult extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public doAdminUpdateResult() {
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
		response.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		ResultInfoBiz rib=new ResultInfoBizImpl();
		int success=1;
		if(session.getAttribute("listTempTeamResult")==null){
			response.sendRedirect("doAdminSelectResult");
		}else{
			List<TempTeamResult> listTempTeamResult=(ArrayList<TempTeamResult>)session.getAttribute("listTempTeamResult");
			int toSubject=listTempTeamResult.get(0).getTtSubjectId();
			for(TempTeamResult ttr:listTempTeamResult){
				if(success>0){
					int resultTeamId=ttr.getTtTeamId();
					String name=String.valueOf(resultTeamId);
					String result=request.getParameter(name);
					String resultNamebyTeamId=rib.getResultName(resultTeamId);
					if(result==null||("нч".equals(result.trim()))){
						
						if(resultNamebyTeamId!=null&&!(resultNamebyTeamId.trim()).equals("нч")&&!resultNamebyTeamId.trim().isEmpty()){
							ResultInfo ri=new ResultInfo();
							ri.setTeamId(resultTeamId);
							ri.setResultName("нч");
							success=rib.update(ri);
						}else{
							continue;
						}
					}else{
						if(resultNamebyTeamId==null||resultNamebyTeamId.trim().isEmpty()){
							ResultInfo ri=new ResultInfo();
							ri.setTeamId(resultTeamId);
							ri.setResultName(result);
							success=rib.add(ri);
						}else{
							if(rib.getResultName(resultTeamId).trim().equals(result.trim())){
								continue;
							}else{
								ResultInfo ri=new ResultInfo();
								ri.setTeamId(resultTeamId);
								ri.setResultName(result);
								success=rib.update(ri);
							}
						}
					}
				}else{
					break;
				}
				
			}
			if(success>0){
				request.setAttribute("toSubject", toSubject);
				request.getRequestDispatcher("adminUpdateResultSuccess.jsp").forward(request, response);
			}else{
				response.sendRedirect("NotSuccess.jsp");
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
