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
<h2><spring:message code="joinItemMessage"/></h2>

<form:form action="/admin/item/join" modelAttribute="itemDto">
  <p> <label> <spring:message code="itemName" />:<br>
    <form:input path="name" />
    <form:errors path="name" /> </label> </p>
  <p> <label> <spring:message code="price" />:<br>
    <form:input path="price" />
    <form:errors path="price" /> </label> </p>
  <p> <label> <spring:message code="stockQuantity" />:<br>
    <form:input path="stockQuantity" />
    <form:errors path="stockQuantity" /> </label> </p>
  <p> <label> <spring:message code="dType" />(상의/하의/모자/신발...):<br>
    <form:input path="dType" />
    <form:errors path="dType" /> </label> </p>
  <p> <label> <spring:message code="company" />:<br>
    <form:input path="company" />
    <form:errors path="company" /> </label> </p>
  <p> <label> <spring:message code="detail" />:<br>
    <form:textarea path="detail" />
    <form:errors path="detail" /> </label> </p>
  <button class="btn" type="submit"> <spring:message code="submit" /> </button>
</form:form>
</body>
</html>
<a href="/"> <spring:message code="back"/> </a>
</body>
</html>