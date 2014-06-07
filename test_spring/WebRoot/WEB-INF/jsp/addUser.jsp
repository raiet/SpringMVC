<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
  		<!-- 将表单提交到addUserAction.test -->
   		<form action="addUserAction.test" method = "post"> 
   			no:<input name = "no"/><br/>
   			name:<input name = "name"/><br/>
   			phone:<input name = "phone"/><br/>
   			date：<input name = "date"/><br/>
   			deptment:<select name = "dept">
   				<c:forEach items = "${deptList}" var = "dept">
   					<option value = "${dept}">${dept}</option>
   				</c:forEach>
   			</select>
   			<input type = "submit" value = "添加"/>
   		</form>
  </body>
</html>
