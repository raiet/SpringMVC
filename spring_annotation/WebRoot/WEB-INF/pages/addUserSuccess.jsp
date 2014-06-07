<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>add user</title>

  </head>
  
  <body>
   		<br/><br/><br/><br/><br/>
   		add user success!!<br/><br/>
   		<a href = "user.do">继续添加用户</a>
  </body>
</html>
