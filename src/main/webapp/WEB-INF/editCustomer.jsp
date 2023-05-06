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
<h1 style="color: brown; font-size: 18px;width: 100%;text-align: center">================== UPDATE CUSTOMER
    ==================</h1>
<button><a href="/customer"> Back to Menu </a></button>
<form action="" method="post">
    <c:if test='${requestScope["validate"]!=null}'>
        <span>${requestScope["validate"]}</span>
    </c:if>
    <table border="1" style="width: 100%;text-align: center">
        <tr>
            <td>Name</td>
            <td><input type="text" style="width: 80%" name="name" value="${requestScope["customerEdit"].getName()}"></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="text" style="width: 80%"  name="email" value="${requestScope["customerEdit"].getEmail()}"></td>
        </tr>
        <tr>
            <td>Address</td>
            <td><input type="text" style="width: 80%"  name="address"  value="${requestScope["customerEdit"].getAddress()}"></td>
        </tr>
        <tr>
            <td colspan="2"><button type="submit"> UPDATE CUSTOMER </button></td>
        </tr>
    </table>
</form>
</body>
</html>
