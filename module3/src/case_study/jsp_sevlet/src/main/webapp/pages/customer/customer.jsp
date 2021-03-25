<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <c:if test="${empty customerList}">
            <h3>No Data</h3>
        </c:if>
        <!-- table -->
        <c:if test="${not empty customerList}">
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
                    <th>Gender</th>
                    <th>Id card</th>
                    <th>Phone</th>
                    <th>Email</th>
                    <th>Address</th>
                    <th>Optional</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${customerList}" var="cusList">
                    <tr>
                        <td>${cusList.getCustomerId()}</td>
                        <td>${cusList.getCustomerType().getCustomerTypeName()}</td>
                        <td>${cusList.getCustomerName()}</td>
                        <td>${cusList.getCustomerBirthday()}</td>
                        <td><c:out value="${customer.isCustomerGender() ? 'Male' : 'Female'}"></c:out></td>
                        <td>${cusList.getCustomerIdCard()}</td>
                        <td>${cusList.getCustomerPhone()}</td>
                        <td>${cusList.getCustomerEmail()}</td>
                        <td>${cusList.getCustomerAddress()}</td>
                        <td class="row">
                            <a href="#" role="button" class="btn btn-warning btn-sm">
                                <i class="fas fa-edit"></i>
                            </a>
                            <button class="btn btn-danger btn-sm"
                                    type="button"
                                    data-toggle="modal"
                                    data-target="#deleteModal"
                                    onclick="saveIdDelete('${cusList.getCustomerId()}')">
                                <i class="fas fa-trash-alt"></i>
                            </button>
                        </td>
                    </tr>
                </c:forEach>
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
    </c:if>
</div>
<jsp:include page="../footer_content.jsp"/>
<jsp:include page="../customer/modal_add_new.jsp"/>
<%--<jsp:include page="../customer/modal_confirm_delete.jsp"/>--%>
<!-- Modal confirm delete -->
<div class="modal fade" id="deleteModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title">DELETE WARNING</h4>
                <button
                        type="button"
                        class="close"
                        data-dismiss="modal"
                >
                    &times;
                </button>
            </div>

            <!-- Modal body -->
            <div class="modal-body">
                Do you want to delete?
            </div>

            <!-- Modal footer -->
            <div class="modal-footer">
                <button type="submit" class="btn btn-success btn-sm" onclick="submitFormDelete()">
                    <b>Ok, DELETE</b>
                </button>
                <button type="button" class="btn btn-danger btn-sm" data-dismiss="modal">
                    Cancel
                </button>
            </div>
        </div>
    </div>
</div>
<form action="/customer" method="post" id="formDelete">
    <input type="hidden" name="idCustomer" id="idDeleteCustomer">
    <input type="hidden" name="action" value="delete">
</form>
<script>
    function saveIdDelete(idCustomer) {
        document.getElementById("idDeleteCustomer").value = idCustomer;
    }
    function submitFormDelete() {
        document.getElementById("formDelete").submit();
    }
</script>
<jsp:include page="../footer.jsp"/>