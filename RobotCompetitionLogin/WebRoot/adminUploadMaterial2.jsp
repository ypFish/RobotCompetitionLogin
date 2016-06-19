<%@ page language="java" import="java.util.*,com.yupeng.entity.*,com.yupeng.biz.*,com.yupeng.biz.impl.*,org.apache.commons.fileupload.*,java.io.*" pageEncoding="utf-8"%>
<%@ include file="adminLoginSession.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <link rel="shortcut icon" type="image/x-icon" href="image/robot32.ico" media="screen" />
    <base href="<%=basePath%>">
    
    <title>北京工业大学机器人竞赛报名平台</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
<body style="text-align:center">
<img src="image/top.jpg"  />
<div style="background-color:#39C; margin:0px auto; width:733px; height:1000px; ">
<%@ include file="adminMenu.jsp" %>
<br/>
	<div>
	<h3>竞赛资料上传</h3>
	<br/>
<%
request.setCharacterEncoding("utf-8");
String name ="";
int materialLimit=2;
long size=0;
boolean flag=true;
String projectUploadAddress=new java.io.File(application.getRealPath("index.jsp")).getParent()+"\\upload";
String projectTempAddress=new java.io.File(application.getRealPath("index.jsp")).getParent()+"\\temp";
projectUploadAddress = projectUploadAddress.replaceAll("\\\\","\\\\\\\\");
projectTempAddress=projectTempAddress.replaceAll("\\\\","\\\\\\\\");
request.setCharacterEncoding("utf-8");
DiskFileUpload fu = new DiskFileUpload();

fu.setHeaderEncoding("utf-8");
// 设置允许用户上传文件大小,单位:字节
//fu.setSizeMax(20*1024*1024);
// 设置最多只允许在内存中存储的数据,单位:字节
 fu.setSizeThreshold(1024*1024*5);
// 设置一旦文件大小超过getSizeThreshold()的值时数据存放在硬盘的目录
//(临时存放目录,文件上传完毕后有办法清除它吗？)
fu.setRepositoryPath(projectTempAddress);

//开始读取上传信息
List fileItems = fu.parseRequest(request);
// 依次处理每个上传的文件
Iterator iter = fileItems.iterator();
while (iter.hasNext()) 
{
	FileItem item = (FileItem) iter.next();
	//忽略其他不是文件域的所有表单信息
	if (!item.isFormField()) 
	{
	name = item.getName();//获取上传的文件名
	size = item.getSize();//获取上传的文件大小(字节为单位)
	if((name==null||name.equals("")) && size==0){
	out.print("<p>上传失败：上传文件不能为空</p>");
		flag=false;
		continue;//跳到while检查条件
	}
	if(size>=1024*1024*20){
		out.print("<p>上传失败：文大小件超过系统上传限制20M</p>");
		File tempFolder=new File(projectTempAddress);
		File[] tempFiles=tempFolder.listFiles();
		for(File tempFile:tempFiles){
			tempFile.delete();
		}
		flag=false;
		continue;
	}
	//验证该文件夹下是否存在一个同名文件
	File uploadFolder=new File(projectUploadAddress);
	File[] uploadFolderFiles=uploadFolder.listFiles();
	for(File f:uploadFolderFiles){
	if(name.equals(f.getName())){
		out.print("<p>上传失败：服务器资料库内存在一个同名文件，请查看！</p>");
	
		flag=false;
		break;
	}
	
	}
		if(flag==true){
			
			//以下为文件名处理，将上传的文件保存在项目所在目录下。
			File savedFile = new File(projectUploadAddress, name); 
			item.write(savedFile);
		}
	}else{
		materialLimit=Integer.parseInt(item.getString());
	}
}
if(flag==true){

	MaterialInfoBiz mib=new MaterialInfoBizImpl();
	MaterialInfo mi=new MaterialInfo();
	mi.setMaterialName(name);
	mi.setMaterialLimit(materialLimit);
	mi.setMaterialURL(projectUploadAddress.toString());
	mi.setRemark("");
	if(mib.addAll(mi)>0){
			out.print("<p>资料上传成功！</P>");
	
	

			out.println("<p>文件名称：" + name + "</p>");
			out.println("<p文件大小：" + size + "字节</p>");		
			out.print("<p>文件保存路径："+projectUploadAddress+"</p");
			out.print("<br/>");
			if(materialLimit==1){
				out.print("<p>文件下载权限：仅管理员可见</p>");
			}else if(materialLimit==2){
				out.print("<p>文件下载权限：报名小组及管理员可见</p>");
			}else if(materialLimit==3){
				out.print("<p>文件下载权限：全部可见</p>");
			}

	}else{
		out.print("<p>上传失败：上传文件信息不能保存在系统资料库内</p>");
	}

}
	
%>
<br/>
<br/>
<a href="adminSelectMaterial.jsp">[查看资料信息]</a>&nbsp;&nbsp;&nbsp;<a href="adminAddMaterial.jsp">[继续上传资料]</a>
</div>

</div>
</body>
</html>
