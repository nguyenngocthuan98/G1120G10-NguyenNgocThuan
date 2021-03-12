<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ngoct
  Date: 3/12/2021
  Time: 10:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Document</title>
        <link rel="stylesheet" href="css/bootstrap.min.css" />
    </head>
    <body>
        <div class="container">
            <h1>Danh sách khách hàng</h1>
            <c:if test="${empty CustomerList}">
                <h4>Hiện không có khách hàng nào</h4>
            </c:if>
            <c:if test="${not empty CustomerList}">
            <table class="table">
                <thead>
                    <tr>
                        <th>Tên</th>
                        <th>Ngày sinh</th>
                        <th>Địa chỉ</th>
                        <th>Ảnh</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${CustomerList}" var="customer">
                    <tr>
                        <td scope="row">${customer.name}</td>
                        <td>${customer.dateOfBirth}</td>
                        <td>${customer.address}</td>
                        <td>
                            <img src="${customer.image}" alt="" width="50" height="auto">
                        </td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
            </c:if>
        </div>
    </body>
</html>

