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
<h2><spring:message code="submitresult"/></h2>
<p> <spring:message code="name" />: ${itemDto.name} </p>
<p> <spring:message code="price" />: ${itemDto.price} </p>
<p> <spring:message code="stockQuantity" />: ${itemDto.stockQuantity}</p>
<p> <spring:message code="dType" />: ${itemDto.dType} </p>
<p> <spring:message code="company" />: ${itemDto.company} </p>
<p> <spring:message code="detail" />: ${itemDto.detail} </p>
<br><br>
<a href="/"> <spring:message code="homepage" /> </a>
</body>
</html>
