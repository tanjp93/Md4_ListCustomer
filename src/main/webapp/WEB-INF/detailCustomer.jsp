<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023/05/05
  Time: 19:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 style="color: brown; font-size: 18px;width: 100%;text-align: center">================== CUSTOMER PROFILE
    ==================</h1>
<button><a href="/customer"> Back to Menu </a></button>
<table border="1" style="width: 100%;text-align: center">
    <tr>
        <th>STT</th>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
        <th>Action</th>
    </tr>
    <tr>
        <td>${requestScope["customerDetail"].getId()}</td>
        <td>${customerDetail.getName()}</td>
        <td>${customerDetail.getEmail()}</td>
        <td>${customerDetail.getAddress()}</td>
        <td>
            <button>Edit</button>
            &nbsp
            <button>Delete</button>
        </td>
    </tr>
</table>
</body>
</html>
