<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!-- 引入spring的标签库 -->
<%@ taglib uri = "http://www.springframework.org/tags" prefix = "spring"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'start.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body> 
    This is start page. <br>
    <!-- 提交到本页面 -->
    <form action="" method="post">
    	date：<input name = "date"/><br/>
    	name <input name ="name"/><br/>
    	passwd <input name= "passwd"/><br/>
    	<input type="submit" value= "submit">
    </form>
  </body>
</html>
