<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<html>
<head>
  <title>Home</title>
</head>
<body>
<c:if test="${empty auth}">
<% request.setCharacterEncoding("UTF-8"); %>
<h2><spring:message code="loginmesg"/></h2>

<form:form action="/login" modelAttribute="loginDto">
  <p> <label> <spring:message code="userId" />:<br>
    <form:input path="userId" />
    <form:errors path="userId" /> </label> </p>
  <spring:message code="rememberId" /> <form:checkbox path="rememberId" /> </label> </p>
  <p> <label> <spring:message code="pwd" />:<br>
    <form:password path="pwd" />
    <form:errors path="pwd" /> </label> </p>
  <button class="btn" type="submit"> <spring:message code="submit" /> </button>
</form:form>
</c:if>

<c:if test="${! empty auth}">
  <P> ${auth.userId}님 환영합니다. </P>
  <a href="/user-info/${auth.userId}">${auth.userId}님 정보</a><br>
  <a href="/user-info/modify/${auth.userId}">${auth.userId}님 정보수정</a><br>
  <a href="/logout">로그아웃</a><br><br>
  <a href="/user/delete/${auth.userId}">회원탈퇴</a>
</c:if>
</body>
</html>
<br><br>
<a href="/"> <spring:message code="homepage"/> </a>
<br><br>
</body>
</html>