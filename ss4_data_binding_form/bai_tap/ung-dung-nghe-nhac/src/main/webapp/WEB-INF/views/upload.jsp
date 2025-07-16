<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 7/16/2025
  Time: 3:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Upload Song</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"/>
</head>
<body class="p-5">
<div class="container">
    <h2>Upload Bài Hát</h2>
    <form:form action="/songs/upload" modelAttribute="song" method="post" enctype="multipart/form-data" class="mt-4">
        <div class="mb-3">
            <form:label path="name" class="form-label">Tên bài hát</form:label>
            <form:input path="name" class="form-control"/>
        </div>
        <div class="mb-3">
            <form:label path="artist" class="form-label">Nghệ sĩ</form:label>
            <form:input path="artist" class="form-control"/>
        </div>
        <div class="mb-3">
            <form:label path="genre" class="form-label">Thể loại</form:label>
            <form:input path="genre" class="form-control"/>
        </div>
        <div class="mb-3">
            <label class="form-label">Chọn file bài hát</label>
            <input type="file" name="file" class="form-control"/>
        </div>
        <c:if test="${not empty error}">
            <div class="alert alert-danger">${error}</div>
        </c:if>
        <button type="submit" class="btn btn-primary">Upload</button>
        <a href="/songs/list" class="btn btn-secondary">Danh sách</a>
    </form:form>
</div>
</body>
</html>

