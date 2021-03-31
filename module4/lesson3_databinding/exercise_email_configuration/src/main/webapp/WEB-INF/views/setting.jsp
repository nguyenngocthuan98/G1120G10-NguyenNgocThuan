<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Page</title>
    <!-- Required meta tags -->
    <meta charset="utf-8"/>
    <meta
            name="viewport"
            content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />

    <!-- Bootstrap CSS -->
    <link
            rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
            integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
            crossorigin="anonymous"
    />
</head>
<body>
<div class="container col-sm-8 col-md-6 border" style="padding: 10px">
    <table class="table table-hover table-inverse">
        <thead class="thead-inverse">
        <tr>
            <th><h1>Setting</h1></th>
            <th></th>
        </tr>
        </thead>
        <form:form action="/confirmSetting" method="post" modelAttribute="configSetting">
            <tbody>
            <tr>
                <td><h5>Languages</h5></td>
                <td style="padding-left: 0px">
                    <div class="form-group" style="padding-left: 0px">
                        <form:select class="form-control" path="language" items="${listLanguage}"/>
                    </div>
                </td>
            </tr>
            <tr>
                <td><h5>Page Size:</h5></td>
                <td style="padding-left: 0px; display: flex">
                    Show
                    <div class="form-group" style="margin: 0">
                        <div class="form-group" style="padding-left: 0px">
                            <form:select class="form-control" path="pageSize" items="${listPageSize}"
                                         cssStyle="height: 2em; padding: 0px 10px !important;"/>
                        </div>
                    </div>
                    emails per page
                </td>
            </tr>
            <tr>
                <td><h5>Spam filter:</h5></td>
                <td style="padding-left: 0px">
                    <label class="form-check-label">
                        <form:checkbox class="form-check-input" path="spamFilter"/>Enable spams filter
                    </label>
                </td>
            </tr>
            <tr>
                <td><h5>Signature:</h5></td>
                <td style="padding-left: 0px">
                    <form:textarea path="signature" class="col-12"/>
                </td>
            </tr>
            <tr>
                <td>
                </td>
                <td style="padding-left: 0px">
                    <button type="submit" class="btn btn-sm btn-outline-success col-12">
                        Update
                    </button>
                </td>
            </tr>
            </tbody>
        </form:form>
    </table>
</div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script
        src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"
></script>
<script
        src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"
></script>
<script
        src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"
></script>
</body>
</html>

