<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 7/14/2025
  Time: 3:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Kết quả chuyển đổi</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2>Kết quả</h2>
    <c:if test="${not empty error}">
        <p style="color:red">${error}</p>
    </c:if>

    <c:if test="${not empty result}">
        <p>${usd} USD × ${rate} VNĐ = <strong>${result} VNĐ</strong></p>
    </c:if>
    <a href="/" class="btn btn-secondary">Thử lại</a>
</div>
</body>
</html>

