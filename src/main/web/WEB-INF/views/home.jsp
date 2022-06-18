<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sprng" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <title>Home</title>
</head>
<body>

<h2><spring:message code="welcome"/></h2>

<c:if test="${empty auth}">
    <a href="/login"> <spring:message code="loginmesg"/> </a> <br>
    <a href="/user/join"> <spring:message code="joinmesg"/> </a> <br><br>
</c:if>
<c:if test="${! empty auth}">
    <p>${auth.userId} 님 로그인되셨습니다.</p> <br>
    <c:if test="${not empty admin}">
        <h3>|관리자 기능|</h3>
        <a href="/admin/item/join"> <spring:message code="joinItem"/> </a> <br>
        <a href="/admin/item/add"> <spring:message code="addItem"/> </a> <br><br>
    </c:if>
    <a href="/login"> <spring:message code="userInfoManagement"/></a>
    <a href="/orders/${auth.userId}"> <spring:message code="purchaseHistory"/></a>
    <a href="/logout"> <spring:message code="logout"/></a><br><br>
</c:if>

<a href="/item/type"><spring:message code="searchBydType"/></a>
<br>
<a href="/item/company"><spring:message code="searchByCompany"/></a>
<br>
<a href="/item/name"><spring:message code="searchByName"/></a>

<table summary="목록" , border="1">
    <caption>
        <span>목록</span>
    </caption>
    <thead>
    <tr>
        <th>index</th>
        <th>이름</th>
        <th>가격</th>
        <th>재고</th>
        <th>분류</th>
        <th>상품 안내 페이지</th>
        <th>구매</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="item" items="${items}" varStatus="status">
    <tr>
        <td><c:out value="${status.index}"/></td>
        <td><c:out value="${item.name}"/></td>
        <td><c:out value="${item.price}"/></td>
        <td><c:out value="${item.stockQuantity}"/></td>
        <td><c:out value="${item.dType}"/></td>
        <td><a href="/item/detail/${item.id}"> <spring:message code="detail"/></a></td>
        <td>
            <form action="/order/${item.id}">
                <input name="count" type='number' min='1' max=${item.stockQuantity} step='1'>
                <input type='submit'>
                <form:errors path="count"/>
            </form>
        </td>
        </c:forEach>
    </tr>
    </tbody>
</table>
<br>
</body>
</html>
</body>
</html>