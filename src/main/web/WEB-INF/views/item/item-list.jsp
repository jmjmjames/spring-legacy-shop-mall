<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sprng" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <title>검색 결과</title>
</head>
<body>

<h2><spring:message code="searchResult"/></h2>


<table summary="목록", border="1">
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
    <c:if test="${items == null }">
        <tfoot>
        <tr>
            <td colspan="7">검색 결과가 존재하지 않습니다..</td>
        </tfoot>
    </c:if>
    <tbody>
    <c:if test="${items != null }">
        <c:forEach var="item" items="${items}" varStatus="status">
        <tr>
            <td><c:out value="${status.index}"/></td>
            <td><c:out value="${item.name}"/></td>
            <td><c:out value="${item.price}"/></td>
            <td><c:out value="${item.stockQuantity}"/></td>
            <td><c:out value="${item.dType}"/></td>
            <td><a href="/item/detail/${item.id}"> <spring:message code="detail"/></a></td>
            <td><button type="button" onclick="location.href='order/${item.id}"></button></td>
        </tr>
        </c:forEach>
    </c:if>
    </tbody>
</table>
<a href="/"> <spring:message code="homepage" /> </a>
</body>
</html>
</body>
</html>