<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Header -->
<jsp:include page="header.jsp"></jsp:include>
<body>
<div class="container" style="background-color: rgb(238, 238, 238)">
    <h2 style="text-transform: uppercase">user manager</h2>
    <!-- Button to Open the Modal -->
    <button
            type="button"
            class="btn btn-primary btn-sm"
            data-toggle="modal"
            data-target="#myModal"
    >
        Add new
    </button>
    <!-- Show value -->
    <table class="table table-striped table-inverse table-responsive">
        <thead class="thead-inverse">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>
            <th>Options</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${userList}" var="user_item">
            <tr>
                <td scope="row">${user_item.id}</td>
                <td>${user_item.name}</td>
                <td>${user_item.email}</td>
                <td>${user_item.country}</td>
                <td>
                    <button
                            type="submit"
                            class="btn btn-warning btn-sm"
                    >
                        Edit
                    </button>
                    <button type="submit" class="btn btn-danger btn-sm">
                        Delete
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <!-- Add user -->
    <jsp:include page="add_user.jsp"></jsp:include>

    <!-- Footer -->
<jsp:include page="footer.jsp"></jsp:include>