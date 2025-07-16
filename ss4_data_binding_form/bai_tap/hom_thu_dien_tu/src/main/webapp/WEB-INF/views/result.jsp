<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 7/16/2025
  Time: 3:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Result</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"/>
</head>
<body class="p-4">
<div class="container">
    <h2 class="mb-4">Configuration Result</h2>
    <ul class="list-group">
        <li class="list-group-item">Language: ${config.language}</li>
        <li class="list-group-item">Page Size: ${config.pageSize}</li>
        <li class="list-group-item">Spam Filter: ${config.spamFilter ? "Enabled" : "Disabled"}</li>
        <li class="list-group-item">
            Signature:
            <pre class="mt-2">${config.signature}</pre>
        </li>
    </ul>
    <a href="/email/settings" class="btn btn-link mt-3">Back to Settings</a>
</div>
</body>
</html>

