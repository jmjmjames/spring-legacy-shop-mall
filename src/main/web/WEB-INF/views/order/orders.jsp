<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sprng" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <title>구매 이력 조회</title>
</head>
<body>

<h2><spring:message code="purchaseHistory"/></h2>

<form:form action="/orders/search/name">
    <p><label> <spring:message code="search"/>:<br>
        <input name="searchCond" />
    </label>
    </p>
    <button class="btn" type="submit"><spring:message code="submit"/></button>
</form:form>
<br>
<form action="/orders/search/date">
    <p><input type="date" name="startDate" value="2022-06-05"  max="2022-12-31"></p>
    <p><input type="date" name="endDate" value="2022-06-13"  max="2022-12-31"></p>
    <p><input type="submit" value="Submit"></p>
</form>

<table summary="목록" , border="1">
    <caption>
        <span>목록</span>
    </caption>
    <thead>
    <tr>
        <th>index</th>
        <th>상품 이름</th>
        <th>가격</th>
        <th>분류</th>
        <th>회사</th>
        <th>주문 총 가격</th>
        <th>주문 갯수</th>
        <th>주문 시간</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${orderItems == null }">
    <tfoot>
    <tr>
        <td colspan="8">검색 결과가 존재하지 않습니다.</td>
    </tfoot>
    </c:if>
    <c:if test="${orderItems != null }">
        <c:forEach var="orderItem" items="${orderItems}" varStatus="status">
        <tr>
            <td><c:out value="${status.index}"/></td>
            <td><c:out value="${orderItem.itemName}"/></td>
            <td><c:out value="${orderItem.price}"/></td>
            <td><c:out value="${orderItem.dType}"/></td>
            <td><c:out value="${orderItem.company}"/></td>
            <td><c:out value="${orderItem.orderPrice}"/></td>
            <td><c:out value="${orderItem.orderCount}"/></td>
            <td><c:out value="${orderItem.orderDate}"/></td>
            </c:forEach>
        </tr>
    </c:if>
    </tr>
    </tbody>
</table>
<a href="/"> <spring:message code="homepage" /> </a>
</body>
</html>
</body>
</html>