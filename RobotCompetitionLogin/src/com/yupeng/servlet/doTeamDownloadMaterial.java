package com.yupeng.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class doTeamDownloadMaterial extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public doTeamDownloadMaterial() {
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
		
		String downloadFileName3=new String(request.getParameter("materialName").getBytes("ISO-8859-1"),"utf-8");
		String downloadFileAddress2=new String(request.getParameter("materialURL").getBytes("ISO-8859-1"),"utf-8")+"\\\\"+downloadFileName3;
		String downloadFileAddress=URLEncoder.encode(downloadFileAddress2,"utf-8");

			response.setContentType("text/html");  
			OutputStream o = response.getOutputStream();
			byte b[] = new byte[5000];
			File fileLoad = new File(URLDecoder.decode(downloadFileAddress,"utf-8"));
			if(fileLoad.exists()){
				
			
			response.setContentType("application/x-msdownload");
			response.setHeader("content-disposition","attachment; filename="+new String(downloadFileName3.getBytes("gb2312"),"ISO-8859-1"));
			long fileLength = fileLoad.length();
			String length1 = String.valueOf(fileLength);
			response.setHeader("Content_Length", length1);
			FileInputStream in = new FileInputStream(fileLoad);
			int n;
			while ((n = in.read(b)) != -1) {
				o.write(b, 0, n);
			}
			
			in.close();
			}else{
				
				response.sendRedirect("TeamFileNot.jsp");
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
