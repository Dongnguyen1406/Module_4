<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 7/15/2025
  Time: 3:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<h2>Result</h2>
<%-- Hiển thị kết quả hoặc lỗi --%>
<c:if test="${not empty error}">
    <p style="color:red">${error}</p>
</c:if>
<c:if test="${not empty result}">
    <p>Result: <strong>${result}</strong></p>
</c:if>
<a href="/">Back</a>
</body>
</html>

