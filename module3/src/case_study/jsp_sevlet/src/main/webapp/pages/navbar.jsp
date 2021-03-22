<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Navbar  -->
<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
    <div class="collapse navbar-collapse" id="collapsibleNavId">
        <!-- Nav  -->
        <ul
                class="navbar-nav mr-auto mt-lg-0 col-md-9 nav nav-tabs"
                role="tablist"
        >
            <li class="nav-item">
                <a
                        class="nav-link active"
                        href="#home"
                        data-toggle="tab"
                >Home</a
                >
            </li>
            <li class="nav-item">
                <a
                        class="nav-link"
                        href="#employee"
                        data-toggle="tab"
                >Employee</a
                >
            </li>
            <li class="nav-item">
                <a
                        class="nav-link"
                        href="#customer"
                        data-toggle="tab"
                >Customer</a
                >
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Service</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Contract</a>
            </li>
        </ul>
        <!-- Search form -->
        <form class="form-inline my-lg-0 col-md-3">
                        <span class="search_box">
                            <button
                                    class="btn btn-nomal btn-sm btn_search"
                                    type="submit"
                            >
                                <i class="fas fa-search"></i>
                            </button>
                            <input
                                    class="search"
                                    type="text"
                                    placeholder="Search"
                            />
                        </span>
        </form>
    </div>
</nav>