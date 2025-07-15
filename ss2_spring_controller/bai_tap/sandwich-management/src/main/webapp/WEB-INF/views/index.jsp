<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h2>Sandwich Condiments</h2>
<form action="save" method="post">
    <c:forEach items="${condiments}" var="item">
        <label style="display: inline-block; margin-right: 15px;">
            <input type="checkbox" name="condiment" value="${item}"/> ${item}
        </label>
    </c:forEach>
    <br>
    <button type="submit">Save</button>
</form>
</body>
</html>