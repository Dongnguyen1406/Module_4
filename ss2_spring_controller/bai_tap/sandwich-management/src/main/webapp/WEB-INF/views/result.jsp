<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 7/15/2025
  Time: 3:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>You selected:</h2>
<c:if test="${empty selected}">
    <p>No condiments selected.</p>
</c:if>
<c:if test="${not empty selected}">
    <ul>
        <c:forEach items="${selected}" var="item">
            <li>${item}</li>
        </c:forEach>
    </ul>
</c:if>
<a href="/">Back</a>
</body>
</html>
