<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ngoct
  Date: 3/16/2021
  Time: 4:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/users" method="POST">
    <input
            type="text"
            class="form-control"
            id="name"
            value="${requestScope["userList"].getName()}"
            name="name"
    />
    <input
            type="text"
            class="form-control"
            id="email"
            value="${requestScope["userList"].getEmail()}"
            name="email"
    />
    <input
            type="text"
            class="form-control"
            id="country"
            value="${requestScope["userList"].getCountry()}"
            name="country"
    />
    <input type="hidden" name="action" value="update">
    <button type="submit" class="btn btn-success btn-sm">
        Update
    </button>
</form>
</body>
</html>
