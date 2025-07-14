<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form action="/dictionary" method="post">
    <h1>Từ điển Anh - việt</h1>
    <label>Nhập từ: </label>
    <input type="text" name="search" placeholder="Enter word: ">
    <input type="submit" id="submit" value="Search">
</form>
</body>
</html>