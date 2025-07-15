<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Simple Calculator</title>
</head>
<body>
<h2>Simple Calculator</h2>
<form action="calculate" method="post">
    <label>Number 1:</label>
    <input type="text" name="number1" required><br/><br/>

    <label>Number 2:</label>
    <input type="text" name="number2" required><br/><br/>

    <label>Operator:</label>
    <select name="operator">
        <option value="">chọn</option>
        <option value="+">+</option>
        <option value="-">-</option>
        <option value="*">×</option>
        <option value="/">÷</option>
    </select><br/><br/>

    <button type="submit">Calculate</button>
</form>
</body>
</html>
