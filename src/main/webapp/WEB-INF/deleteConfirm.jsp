<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023/05/05
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 style="color: brown; font-size: 18px;width: 100%;text-align: center">================== DELETE CUSTOMER
    ==================</h1>
<div>
    <button><a href="/customer?action=DELETE-CONFIRM&id=${requestScope["id"]}"> Delete </a></button>
    Or
    <button><a href="/customer"> Keep and back to Menu </a></button>
</div>
</body>
</html>
