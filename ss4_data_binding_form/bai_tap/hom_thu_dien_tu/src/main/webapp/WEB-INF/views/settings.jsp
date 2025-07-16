<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 7/16/2025
  Time: 1:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Settings</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"/>
</head>
<body class="p-4">
<div class="container">
    <h2 class="mb-4">Settings</h2>
    <form:form action="/email/update" method="post" modelAttribute="config" class="border p-4 rounded bg-light">
        <div class="mb-3">
            <label class="form-label">Languages:</label>
            <form:select path="language" cssClass="form-select">
                <form:options items="${languages}" />
            </form:select>
        </div>

        <div class="mb-3">
            <label class="form-label">Page Size:</label>
            <div class="input-group">
                <span class="input-group-text">Show</span>
                <form:select path="pageSize" cssClass="form-select">
                    <form:options items="${pageSizes}" />
                </form:select>
                <span class="input-group-text">emails per page</span>
            </div>
        </div>

        <div class="mb-3 form-check">
            <form:checkbox path="spamFilter" cssClass="form-check-input" id="spamFilter"/>
            <label class="form-check-label" for="spamFilter">Enable spams filter</label>
        </div>

        <div class="mb-3">
            <label class="form-label">Signature:</label>
            <form:textarea path="signature" rows="3" cssClass="form-control"/>
        </div>

        <div class="d-flex gap-2">
            <button type="submit" class="btn btn-primary">Update</button>
            <button type="reset" class="btn btn-outline-secondary">Cancel</button>
        </div>
    </form:form>
</div>
</body>
</html>