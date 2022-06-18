<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<meta charset="UTF-8">
<html>
<head>
    <title>Logout</title>
</head>
<% request.setCharacterEncoding("UTF-8"); %>
<body>
로그아웃되었습니다. <br><br>
<a href="/"> <spring:message code="back" /> </a>
</body>
</html>