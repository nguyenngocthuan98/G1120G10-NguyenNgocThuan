<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../header.jsp"/>
<jsp:include page="../banner.jsp"/>
<jsp:include page="../navbars/navbar_customer.jsp"/>
<jsp:include page="../menu_left.jsp"/>

<!-- Customer main -->
<div class="col-md-12 tab-pane active" id="customer">
    <!-- top main content -->
    <div class="body_top">
        <h3>Customer</h3>
        <button
                class="btn btn-success btn-sm add-new"
                type="button"
                data-toggle="modal"
                data-target="#addNewModal"
        >
            <i class="fas fa-plus"></i>
        </button>
    </div>
    <!-- body main content -->
    <div class="body_content container-fluid">
        <!-- table -->
        <div class="table-responsive">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Customer type</th>
                    <th>
                        Name
                        <i class="fas fa-sort-up"></i>
                        <i class="fas fa-sort-down"></i>
                    </th>
                    <th>Birthday</th>
                    <th>Id card</th>
                    <th>Phone</th>
                    <th>Email</th>
                    <th>Address</th>
                    <th>Optional</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>1</td>
                    <td>Diamond</td>
                    <td>Thuan</td>
                    <td>16/09/1998</td>
                    <td>2464621136886</td>
                    <td>+84397420253</td>
                    <td>thuannguyen1998@gmail.com</td>
                    <td>Thua Thien Hue</td>
                    <td class="row">
                        <a href="#" role="button" class="btn btn-warning btn-sm">
                            <i class="fas fa-edit"></i>
                        </a>
                        <button class="btn btn-danger btn-sm"
                                type="button"
                                data-toggle="modal"
                                data-target="#deleteModal">
                            <i class="fas fa-trash-alt"></i>
                        </button>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
        <!-- end table -->
    </div>
    <!-- bottom main content -->
    <div class="body_bottom">
        <ul class="pagination justify-content-center">
            <li class="page-item">
                <a class="page-link" href="#">Previous</a>
            </li>
            <li class="page-item">
                <a class="page-link" href="#">1</a>
            </li>
            <li class="page-item">
                <a class="page-link" href="#">2</a>
            </li>
            <li class="page-item">
                <a class="page-link" href="#">3</a>
            </li>
            <li class="page-item">
                <a class="page-link" href="#">Next</a>
            </li>
        </ul>
    </div>
    <!-- end customer main -->
</div>
<jsp:include page="../footer_content.jsp"/>
<jsp:include page="../customer/modal_add_new.jsp"/>
<jsp:include page="../customer/modal_confirm_delete.jsp"/>
<jsp:include page="../footer.jsp"/>