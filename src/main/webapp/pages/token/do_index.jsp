<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.mycompany.common.util.TokenProcessor" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
TokenProcessor tokenProcessor = TokenProcessor.getInstance();
if(tokenProcessor.isTokenValid(request)){
	out.println("继续执行，自己的逻辑");
}else{
	tokenProcessor.saveToken(request);
	out.println("你已经提交了表单，同一表单不能提交两次.");
}
%>
</body>
</html>