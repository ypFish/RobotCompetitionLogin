<%@ page language="java" import="java.util.*,java.net.URLEncoder" pageEncoding="UTF-8" %>  
<%@ page contentType="text/html;charset=utf-8" %>  
<%@ page import="java.io.*" %>
<%@page import="java.net.URLDecoder"%>  
  
<html>  
  <head>  
    <title>北京工业大学机器人竞赛报名平台</title>
  </head>  
  
  <body>  
<%	
//request.setCharacterEncoding("GBK");
String downloadFileName3=new String(request.getParameter("materialName").getBytes("ISO-8859-1"),"utf-8");
String downloadFileAddress2=new String(request.getParameter("materialURL").getBytes("ISO-8859-1"),"utf-8")+"\\\\"+downloadFileName3;
String downloadFileAddress=URLEncoder.encode(downloadFileAddress2);

	response.setContentType("text/html");  
	OutputStream o = response.getOutputStream();
	byte b[] = new byte[5000];
	File fileLoad = new File(URLDecoder.decode(downloadFileAddress));
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
		
		response.sendRedirect("FileNotExist.jsp");
	}
	out.clear();
	out = pageContext.pushBody();
%>
  </body>  
</html> 
