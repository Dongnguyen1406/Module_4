<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 7/16/2025
  Time: 3:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Danh sách bài hát</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"/>
</head>
<body class="p-5">
<div class="container">
    <h2>Danh Sách Bài Hát</h2>
    <a href="/songs/upload" class="btn btn-success mb-3">Upload bài hát mới</a>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Tên</th>
            <th>Nghệ sĩ</th>
            <th>Thể loại</th>
            <th>Nghe</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${songs}" var="song">
            <tr>
                <td>${song.name}</td>
                <td>${song.artist}</td>
                <td>${song.genre}</td>
                <td>
                    <audio controls>
                        <source src="${song.filePath}" type="audio/mpeg"/>
                        Trình duyệt không hỗ trợ.
                    </audio>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>


