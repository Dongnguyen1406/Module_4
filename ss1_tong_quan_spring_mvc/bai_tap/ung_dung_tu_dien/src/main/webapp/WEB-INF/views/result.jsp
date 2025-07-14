<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 7/14/2025
  Time: 4:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Kết quả tra từ</title>
</head>
<body>
<h2>Kết quả:</h2>

<c:choose>
    <c:when test="${not empty result}">
        <p><strong>Từ:</strong> ${word}</p>
        <p><strong>Nghĩa:</strong> ${result}</p>
    </c:when>
    <c:otherwise>
        <p>Không tìm thấy từ "<strong>${word}</strong>" trong từ điển.</p>
    </c:otherwise>
</c:choose>

<a href="/">← Quay lại</a>
</body>
</html>
