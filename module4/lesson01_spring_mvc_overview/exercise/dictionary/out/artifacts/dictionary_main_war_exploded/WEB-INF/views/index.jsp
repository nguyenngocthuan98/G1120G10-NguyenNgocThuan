<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container col-6" style="border: 2px solid; border-radius: 5px; margin-top: 10px; padding: 10px; ">
    <a class="btn btn-primary btn-sm" href="/" style="margin-bottom: 10px">HOME</a>
    <form class="form" method="POST" action="/translate">
        <div class="form-group form-inline">
            <label for="inputValue">English: </label>
            <input
                    type="text"
                    name="inputValue"
                    id="inputValue"
                    class="form-control"
                    placeholder=""
                    style="margin: 0px 10px"
                    value="${inputValue}"
            />
            <input
                    type="submit"
                    class="btn btn-sm btn-success"
                    value="Translate"
            />
        </div>
    </form>
    <c:if test="${empty outputValue && not empty inputValue}">
        <div class="alert alert-danger">
            <strong>Oops!</strong>${mess}
        </div>
        <small>Tip:
            <c:forEach items="${listKey}" var="key"><span>${key},</span></c:forEach>
        </small>
    </c:if>
    <c:if test="${not empty outputValue}">
        <hr/>
        <div class="form-group form-inline">
            <label for="outputValue">Result Vietnamese: </label>
            <input
                    type="text"
                    name="outputValue"
                    id="outputValue"
                    class="form-control"
                    placeholder=""
                    style="margin: 0px 10px"
                    value="${outputValue}"
                    disabled
            />
        </div>
    </c:if>
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
