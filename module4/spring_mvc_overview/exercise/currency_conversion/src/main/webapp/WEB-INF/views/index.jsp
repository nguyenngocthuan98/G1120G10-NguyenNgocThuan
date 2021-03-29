<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<div
        class="container col-6"
        style="
                border: 2px solid;
                border-radius: 5px;
                margin-top: 10px;
                padding: 10px;
            "
>
    <form class="form" method="POST" action="/currency">
        <div class="form-group form-inline">
            <label for="input_value">USD: </label>
            <input
                    type="text"
                    name="input_value"
                    id="input_value"
                    class="form-control"
                    placeholder=""
                    style="margin: 0px 10px"
                    value="${input_value}"
            />
            <input
                    type="submit"
                    class="btn btn-sm btn-success"
                    value="Convert"
            />
        </div>
    </form>
    <hr/>
    <div class="form-group form-inline">
        <label for="output_value">VND: </label>
        <input
                type="text"
                name="output_value"
                id="output_value"
                class="form-control"
                placeholder=""
                style="margin: 0px 10px"
                value="${output_value}"
                disabled
        />
    </div>
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
