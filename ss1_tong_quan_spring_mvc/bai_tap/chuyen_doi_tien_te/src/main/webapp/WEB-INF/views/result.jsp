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
  <h2>Kết quả chuyển đổi</h2>
  <p><strong>Tỉ giá:</strong> <c:out value="${rate}"/> VNĐ/USD</p>
  <p><strong>Số USD:</strong> <c:out value="${usd}"/> USD</p>
  <p><strong>Thành tiền:</strong> <c:out value="${vnd}"/> VNĐ</p>
  <a href="/" class="btn btn-secondary">Thử lại</a>
</div>
</body>
</html>

