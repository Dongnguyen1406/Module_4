<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 7/14/2025
  Time: 2:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Danh sách khách hàng</title></head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

<body>
<div class="container mt-5">
    <h2 class="mb-4 text-center">Danh sách học sinh</h2>

    <table class="table table-bordered table-hover table-striped align-middle">
        <thead class="table-primary">
        <tr class="text-center">
            <th scope="col">No</th>
            <th scope="col">Name</th>
            <th scope="col">Email</th>
            <th scope="col">Address</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${customers}" var="customer" varStatus="temp">
            <tr>
                <td class="text-center">${temp.count}</td>
                <td> <a href="/customers/info?id=${customer.codeCus}">${customer.nameCus}</a></td>
                <td>${customer.email}</td>
                <td>${customer.address}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
