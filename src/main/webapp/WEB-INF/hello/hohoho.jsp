<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	인사말 : ${requestScope.hohoho}
	<br>
	<br>
	
	<c:forEach var="item" items="${lists}">
		${item}<br>
	</c:forEach>
	
	<hr>
</body>
</html>