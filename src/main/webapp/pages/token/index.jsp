<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.mycompany.common.util.TokenProcessor" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
var checkSubmitFlag = true;
function checkSubmit(){ //避免重复提交表单
	if(true == checkSubmitFlag){
		document.theForm.submit();
		checkSubmitFlag = false;  //避免重复提交
	}else{
		alert("你已经提交了表单，请不要重复提交!");
	}
}
</script>
</head>
<body>
<%
TokenProcessor tokenProcessor = TokenProcessor.getInstance();
String token = tokenProcessor.getToken(request);
%>
<form action="do_index.jsp" method="post" name="theForm">
 <input type="text" name="userName" value="" />
 <input type="hidden"  name="org.mycompany.token" value="<%=token%>" />
 
  <input type="submit" name="smtBtn" value="submit" />
</form>
</body>
</html>