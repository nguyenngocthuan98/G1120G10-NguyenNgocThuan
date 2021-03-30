<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <title>CONDIMENTS</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container col-6 border" style="padding: 2rem">
    <form action="/calculator" method="get">
        <div class="form-group row">
            <input
                    type="text"
                    class="form-control form-control-sm col-6"
                    name="firstNumber"
                    placeholder="First number"
                    value="${firstNumber}"
                    required
            />
            <input
                    type="text"
                    class="form-control form-control-sm col-6"
                    name="secondNumber"
                    placeholder="Second number"
                    value="${secondNumber}"
                    required
            />
        </div>
        <div class="row">
            <input
                    type="submit"
                    name="operator"
                    value="addition"
                    class="btn btn-sm btn-outline-primary col-3"
            />
            <input
                    type="submit"
                    name="operator"
                    value="subtraction"
                    class="btn btn-sm btn-outline-primary col-3"
            />
            <input
                    type="submit"
                    name="operator"
                    value="multiplication"
                    class="btn btn-sm btn-outline-primary col-3"
            />
            <input
                    type="submit"
                    name="operator"
                    value="division"
                    class="btn btn-sm btn-outline-primary col-3"
            />
        </div>
    </form>
    <hr/>
    <c:if test="${not empty exceptionDivisionForZero}">
        <div class="alert alert-danger">
                ${exceptionDivisionForZero}
        </div>
    </c:if>
    <c:if test="${not empty result} && ${empty exceptionDivisionForZero}">
        <div class="result row" style="text-align: center">
            <span class="col-1">Result: </span>
            <input
                    type="text"
                    class="form-control form-control-sm col-3"
                    value="${firstNumber}"
                    disabled
                    style="text-align: center"
            />
            <span class="col-1">${operator}</span>
            <input
                    type="text"
                    class="form-control form-control-sm col-3"
                    value="${secondNumber}"
                    disabled
                    style="text-align: center"
            />
            <span class="col-1">=</span>
            <input
                    type="text"
                    class="form-control form-control-sm col-3"
                    value="${result}"
                    disabled
                    style="text-align: center"
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

