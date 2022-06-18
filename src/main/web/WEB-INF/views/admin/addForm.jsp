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
<h2><spring:message code="addItemMessage"/></h2>

<form:form action="/admin/item/add" modelAttribute="itemUpdateDto">
  <p> <label> <spring:message code="itemName" />:<br>
    <form:input path="name" />
    <form:errors path="name" /> </label> </p>
  <p> <label> <spring:message code="stockQuantity" /> (기존 재고의 수량 추가):<br>
    <form:input path="stockQuantity" />
    <form:errors path="stockQuantity" /> </label> </p>
  <button class="btn" type="submit"> <spring:message code="submit" /> </button>
</form:form>
</body>
</html>
<a href="/"> <spring:message code="back"/> </a>
</body>
</html>