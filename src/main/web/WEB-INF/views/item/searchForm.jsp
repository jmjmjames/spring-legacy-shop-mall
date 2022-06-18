<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<meta charset="UTF-8">
<html>
<head>
    <title>Home</title>
</head>
<% request.setCharacterEncoding("UTF-8"); %>
<body>
<form:form action="" modelAttribute="searchCond">
    <p><label> <spring:message code="search"/>:<br>
        <form:input path="search"/>
    </label>
    </p>
    <button class="btn" type="submit"><spring:message code="submit"/></button>
</form:form>
</body>
</html>