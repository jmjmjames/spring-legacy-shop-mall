<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>

<meta charset="UTF-8">
<html>
<head>
  <title>상품 상세 정보</title>
</head>
<% request.setCharacterEncoding("UTF-8"); %>
<body>

<P> ${itemInfo.name}의 상세 정보 </P>
<p> <spring:message code="price" />: ${itemInfo.price} </p>
<p> <spring:message code="stockQuantity" />: ${itemInfo.stockQuantity} </p>
<p> <spring:message code="dType" />: ${itemInfo.dType}</p>
<p> <spring:message code="item_detail" />: ${itemInfo.detail} </p>
<a href="/order/${itemInfo.id}"> <spring:message code="order" /> </a>
</body>
</html>