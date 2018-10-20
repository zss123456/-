<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%out.print("对不起您还没有登录,一秒后转到登陆界面！");
           response.setHeader("refresh", "1;url=http://localhost:8080/TTMS/login.jsp");
%>
</body>
</html>