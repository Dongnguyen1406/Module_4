<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 7/14/2025
  Time: 3:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>Thông tin khách hàng</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
  <h2 class="mb-4 text-center">Thông tin chi tiết khách hàng</h2>

  <table class="table table-bordered">
    <tr>
      <th>ID</th>
      <td><c:out value="${customer.codeCus}"/></td>
    </tr>
    <tr>
      <th>Tên</th>
      <td><c:out value="${customer.nameCus}"/></td>
    </tr>
    <tr>
      <th>Email</th>
      <td><c:out value="${customer.email}"/></td>
    </tr>
    <tr>
      <th>Địa chỉ</th>
      <td><c:out value="${customer.address}"/></td>
    </tr>
  </table>

  <a href="/customers" class="btn btn-primary">← Quay lại danh sách</a>
</div>
</body>
</html>

