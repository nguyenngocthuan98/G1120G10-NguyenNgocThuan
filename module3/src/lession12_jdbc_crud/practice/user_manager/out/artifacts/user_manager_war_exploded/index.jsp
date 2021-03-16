<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Header -->
<jsp:include page="header.jsp"></jsp:include>
<body>
<div class="container" style="background-color: rgb(238, 238, 238); width: 50%">
    <h2 style="text-transform: uppercase">user manager</h2>

    <!-- Button to Open the create user modal -->
    <button
            type="button"
            class="btn btn-primary btn-sm"
            data-toggle="modal"
            data-target="#myModalCreate"
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
                <td style="display: inline">
<%--                    <form action="/users" method="POST">--%>
<%--                        <input type="hidden" name="action" value="update">--%>
<%--                        <input type="hidden" name="id" value="${user_item.id}">--%>
<%--                        <button--%>
<%--                                type="submit"--%>
<%--                                class="btn btn-warning btn-sm"--%>
<%--                                data-toggle="modal"--%>
<%--                                data-target="#myModalUpdate"--%>
<%--                        >--%>
<%--                            Edit--%>
<%--                        </button>--%>
<%--                    </form>--%>

                    <a href="/users?action=update&id=${user_item.id}">Edit</a>

                    <form action="/users" method="post">
                        <input type="hidden" name="action" value="delete">
                        <input type="hidden" name="id" value="${user_item.id}">
                        <button type="submit" class="btn btn-danger btn-sm">
                            Delete
                        </button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <!-- Add user -->
    <jsp:include page="add_user.jsp"></jsp:include>

    <%--Update user--%>
    <jsp:include page="update_user.jsp"></jsp:include>

    <!-- Footer -->
<jsp:include page="footer.jsp"></jsp:include>