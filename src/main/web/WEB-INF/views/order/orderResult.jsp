<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>

<html>
<head>
  <title></title>
</head>
<body>
<% request.setCharacterEncoding("UTF-8"); %>
<h3><p> <spring:message code="orderResult" /></p></h3>

<p> <spring:message code="userId" />: ${auth.userId} 님의 구매 현황</p>
<p> <spring:message code="itemName" />: ${item.name} </p>
<p> <spring:message code="orderPrice" />: ${order.orderPrice} </p>
<p> <spring:message code="orderCount" />: ${order.orderCount} </p>
<p> <spring:message code="orderDate" />: <tf:formatDate value="${order.orderDate}" pattern="yyyy-MM-dd HH:mm:SS" /> </p>
<br><br>
<a href="/"> <spring:message code="homepage" /> </a>
</body>
</html>
