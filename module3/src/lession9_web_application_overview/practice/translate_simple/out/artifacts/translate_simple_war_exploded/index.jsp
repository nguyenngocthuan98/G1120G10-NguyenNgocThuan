<%--
  Created by IntelliJ IDEA.
  User: ngoct
  Date: 3/11/2021
  Time: 2:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<head>
    <title>Simple Dictionary</title>
</head>
<body>
<h2>Vietnamese Dictionary</h2>
<form method="post" action="/translate">
    <label>
        <input type="text" name="txtSearch" placeholder="Enter your word: "/>
    </label>
    <input type="submit" id="submit" value="Search"/>
</form>
<p>hello, how, book, computer</p>
</body>
</html>
