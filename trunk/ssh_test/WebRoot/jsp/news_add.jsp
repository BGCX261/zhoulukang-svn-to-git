<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="FCK" uri="http://java.fckeditor.net" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'news_add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body >
    This is my JSP page. <br>
    <form action="<%=request.getContextPath() %>/news.do?method=addNews" method="post">
    <table>
    <tbody>
    <tr><td>标题</td><td><input type="text" name="title" /></td></tr>
    <tr><td>内容</td><td><FCK:editor instanceName="news" basePath="/fckeditor" toolbarSet="Basic" height="300" width="500"></FCK:editor></td></tr>
    <tr><td><input type="submit" value="提交"></td><td></td></tr>
    <tr><td></td><td></td></tr>
    </tbody>
    </form>
    
  </body>
</html>
