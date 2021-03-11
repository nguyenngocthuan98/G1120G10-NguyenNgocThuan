<%-- Created by IntelliJ IDEA. User: ngoct Date: 3/11/2021 Time: 3:12 PM To
change this template use File | Settings | File Templates. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Document</title>
</head>
<body>
<form action="/display-discount" method="post">
    <label for="description"
    >Product Description:
        <input type="text" name="description" id="description"/>
    </label>
    <label for="price"
    >List Price:
        <input type="number" name="price" id="price"/>
    </label>
    <label for="discount_percent"
    >Discount Percent:
        <input
                type="number"
                name="discount_percent"
                id="discount_percent"
        />
    </label>
    <input type="submit" value="Calculate Discount"/>
</form>
</body>
</html>
