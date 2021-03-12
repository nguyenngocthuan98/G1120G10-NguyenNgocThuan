<%--
  Created by IntelliJ IDEA.
  User: ngoct
  Date: 3/12/2021
  Time: 2:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1>Simple Calculator</h1>
<fieldset>
    <legend>Calculator</legend>
    <form action="/calculator" method="post">
        <label for="f_num">First Operand:
            <input type="number" id="f_num" name="f_num">
        </label>
        <label for="operator">Operator:</label>
        <select name="operator" id="operator">
            <option value="+">Addition</option>
            <option value="-">Subtraction</option>
            <option value="*">Multiplication</option>
            <option value="/">Division</option>
        </select>
        <label for="s_num">First Operand:
            <input type="number" id="s_num" name="s_num">
        </label>
        <input type="submit" id = "submit" value = "Calculate">
    </form>
</fieldset>
</body>
</html>
