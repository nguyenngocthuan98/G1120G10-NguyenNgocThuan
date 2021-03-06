<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <title>Page</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
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
        <tbody>
        <tr>
            <td><h5>Languages</h5></td>
            <td style="padding-left: 0px">
                ${configSetting.language}
            </td>
        </tr>
        <tr>
            <td><h5>Page Size:</h5></td>
            <td style="padding-left: 0px; display: flex">
                ${configSetting.pageSize}
            </td>
        </tr>
        <tr>
            <td><h5>Spam filter:</h5></td>
            <td style="padding-left: 0px">
                <c:out value='${configSetting.spamFilter ? " Yes": "No"}'/>
            </td>
        </tr>
        <tr>
            <td><h5>Signature:</h5></td>
            <td style="padding-left: 0px">
                <textarea class="col-12" name="" id="" disabled>
                    ${configSetting.signature}
                </textarea>
            </td>
        </tr>
        <tr>
            <td>
            </td>
            <td style="padding-left: 0px">
                <form action="/changeSettingPage" method="get">
                    <input type="submit" class="btn btn-sm btn-outline-warning col-12" value="Update"/>
                </form>
            </td>
        </tr>
        </tbody>
    </table>
</div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>
