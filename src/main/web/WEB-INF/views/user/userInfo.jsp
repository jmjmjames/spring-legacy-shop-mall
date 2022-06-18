<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>

<meta charset="UTF-8">
<html>
<head>
  <title>회원 정보</title>
</head>
<% request.setCharacterEncoding("UTF-8"); %>
<body>
<c:if test="${! empty auth}">
  <P> ${userInfo.userId}님 정보 </P>
  <p> <spring:message code="name" />: ${userInfo.name} </p>
  <p> <spring:message code="birthday" />: <tf:formatDate value="${userInfo.birthday}" pattern="yyyy-MM-dd" /> </p>
  <p> <spring:message code="email" />: ${userInfo.email} </p>
  <p> <spring:message code="address" />: ${userInfo.address}</p>
  <p> <spring:message code="phoneNumber" />: ${userInfo.phoneNumber} </p>
  <a href="/login"> <spring:message code="back" /> </a>
</c:if>
</body>
</html>