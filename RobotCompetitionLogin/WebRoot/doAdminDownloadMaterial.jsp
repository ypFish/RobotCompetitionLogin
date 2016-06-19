<%@ page language="java" import="java.util.*,com.yupeng.entity.*,com.yupeng.biz.*,com.yupeng.biz.impl.*" pageEncoding="utf-8"%>
<%@ page contentType="text/html;charset=utf-8" %>  
<%@ page import="java.io.*" %><%
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html");  
	response.reset();
	//PrintWriter o = response.getWriter();
	OutputStream o = response.getOutputStream();
	byte b[] = new byte[4096];	
	String	materialName="";
	String materialURL="";
	int materialId=0;
	if(request.getParameter("materialId")!=null&&!request.getParameter("materialId").isEmpty()){
	materialId=Integer.parseInt(request.getParameter("materialId"));
	List<MaterialInfo> listMaterial=(ArrayList<MaterialInfo>)session.getAttribute("listMaterial");
	for(MaterialInfo mi:listMaterial){
		if(materialId==mi.getMaterialId()){
			materialName=mi.getMaterialName();
			materialURL=mi.getMaterialURL();
			break;
		}
	}
	File fileLoad=new File("E:\\Apache Software Foundation\\Tomcat 6.0\\webapps\\RobotCompetitionLogin\\upload\\aa.txt");
	if(!fileLoad.exists()){
		response.sendRedirect("adminSelectSubject.jsp");
	}else{
		String downloanName="attachment;filename="+materialName;
		response.setContentType("application/x-msdownload");	
		response.setHeader("content-disposition","attachment; filename=aa.txt");
		long fileLength = fileLoad.length();
		String length1 = String.valueOf(fileLength);
		response.setHeader("Content_Length", length1);
		FileInputStream in = new FileInputStream(fileLoad);
		int n;
		while ((n = in.read(b))!= -1) {			
			 o.write(b, 0, n);			
		}
		in.close();	
		response.sendRedirect("adminSelectMaterial.jsp");	
	}
	}
out.clear();
out = pageContext.pushBody();
%>