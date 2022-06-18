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
<% request.setCharacterEncoding("UTF-8"); %>
<h2><spring:message code="joinmesg"/></h2>

<form:form action="/user/join" modelAttribute="userDto">
  <p> <label> <spring:message code="userId" />:<br>
    <form:input path="userId" />
    <form:errors path="userId" /> </label> </p>
  <p> <label> <spring:message code="pwd" />:<br>
    <form:password path="pwd" />
    <form:errors path="pwd" /> </label> </p>
  <p> <label> <spring:message code="name" />:<br>
    <form:input path="name" />
    <form:errors path="name" /> </label> </p>
  <p> <label> <spring:message code="birthday" />(yyyyMMdd):<br>
    <form:input path="birthday" />
    <form:errors path="birthday" /> </label> </p>
  <p> <label> <spring:message code="email" />:<br>
    <form:input path="email" />
    <form:errors path="email" /> </label> </p>
  <p> <label> <spring:message code="address" />:<br>
    <form:input path="address" />
    <form:errors path="address" /> </label> </p>
  <p> <label> <spring:message code="phoneNumber" />:<br>
    <form:input path="phoneNumber" />
    <form:errors path="phoneNumber" /> </label> </p>
  <button class="btn" type="submit"> <spring:message code="submit" /> </button>
</form:form>
</body>
</html>
<a href="/"> <spring:message code="back"/> </a>
</body>
</html>