<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Navbar -->
<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
    <div class="collapse navbar-collapse" id="collapsibleNavId">
        <!-- Nav  -->
        <ul class="navbar-nav mr-auto mt-lg-0 col-md-9 nav nav-tab">
            <li class="nav-item">
                <a class="nav-link" href="../../index.jsp">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="employee">Employee</a>
            </li>
            <li class="nav-item">
                <a class="nav-link active" href="customer">Customer</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="service">Service</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="contract">Contract</a>
            </li>
        </ul>
        <!-- Search form -->
        <form class="form-inline my-lg-0 col-md-3">
            <span class="search_box">
                <button class="btn btn-nomal btn-sm btn_search" type="submit">
                    <i class="fas fa-search"></i>
                </button>
                <input class="search" type="text" placeholder="Search"/>
            </span>
        </form>
    </div>
</nav>