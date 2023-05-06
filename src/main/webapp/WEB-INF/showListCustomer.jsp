<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023/05/05
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body style="font-size: 12px">
<h1 style="color: brown; font-size: 18px;width: 100%;text-align: center">================== LIST CUSTOMERS
    ==================</h1>
<button><a href="/customer?action=CREATE"> Create Customer </a></button>
<c:if test='${requestScope["message"]!=""}'>
    <span>${requestScope["message"]}</span>
</c:if>
<table border="1" style="width: 100%;text-align: center">
    <tr>
        <th>STT</th>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
        <th>Action</th>
    </tr>

    <c:forEach items='${requestScope["listCustomer"]}' var="ctm">
        <tr>
            <td>${ctm.getId()}</td>
            <td><a href="/customer?action=DETAIL&id=${ctm.getId()}">${ctm.getName()}</a></td>
            <td>${ctm.getEmail()}</td>
            <td>${ctm.getAddress()}</td>
            <td>
                <a href="/customer?action=EDIT&id=${ctm.getId()}">
                    <button style="border: 25px;background-color: aquamarine">Edit</button>
                </a>
                &nbsp
                <a href="/customer?action=DELETE-REQUEST&id=${ctm.getId()}">
                    <button style="border: 25px;background-color: red">Delete</button>
                </a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
