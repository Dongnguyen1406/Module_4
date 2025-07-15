<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chuyển đổi tiền tệ</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2>Chuyển đổi từ USD sang VNĐ</h2>
    <form action="/convert" method="post" class="mt-4">
        <div class="mb-3">
            <label>Tỉ giá (VNĐ/USD):</label>
            <input type="text" step="0.01" name="rate" class="form-control" required>
        </div>
        <div class="mb-3">
            <label>Số USD cần đổi:</label>
            <input type="text" step="0.01" name="usd" class="form-control" required>
        </div>
        <button type="submit" class="btn btn-primary">Chuyển đổi</button>
    </form>
</div>
</body>
</html>