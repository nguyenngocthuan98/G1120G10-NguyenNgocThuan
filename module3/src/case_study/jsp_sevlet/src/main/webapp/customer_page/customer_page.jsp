<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- customer main -->
<div class="col-md-12 tab-pane fade" id="customer">
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
    <div class="body_content container">
        <!-- table -->
        <div class="table-responsive">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Customer type</th>
                    <th>
                        Name
                        <i class="fas fa-sort"></i>
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
                    <td>
                        <a
                                href="#"
                                role="button"
                                class="btn btn-warning btn-sm"
                        >
                            <i class="fas fa-edit"></i>
                        </a>
                        <button
                                class="btn btn-danger btn-sm"
                                type="button"
                                data-toggle="modal"
                                data-target="#deleteModal"
                        >
                            <i
                                    class="fas fa-trash-alt"
                            ></i>
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

<%--MODAL--%>
<!-- Modal add new content -->
<div class="modal fade" id="addNewModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title">ADD NEW</h4>
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
                <form action="#" method="#">
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                                    <span class="input-group-text"
                                    >Customer type
                                    </span>
                        </div>
                        <select
                                class="form-control"
                                name="customer_type"
                                id="#"
                        >
                            <option>Diamond</option>
                            <option>Platium</option>
                            <option>Gold</option>
                            <option>Silver</option>
                            <option>Member</option>
                        </select>
                    </div>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">Name</span>
                        </div>
                        <input
                                type="text"
                                class="form-control"
                                id="name"
                                placeholder="Enter name customer"
                                name="name"
                        />
                    </div>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                                    <span class="input-group-text"
                                    >Birthday</span
                                    >
                        </div>
                        <input
                                type="date"
                                class="form-control"
                                id="birthday"
                                name="birthday"
                        />
                    </div>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">Gender</span>
                        </div>
                        <select
                                class="form-control"
                                name="gender"
                                id=""
                        >
                            <option>Male</option>
                            <option>Female</option>
                            <option>Unknown</option>
                        </select>
                    </div>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                                    <span class="input-group-text"
                                    >ID Card</span
                                    >
                        </div>
                        <input
                                type="text"
                                class="form-control"
                                id="id_card"
                                placeholder="Enter ID Card"
                                name="id_card"
                        />
                    </div>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">Phone</span>
                        </div>
                        <input
                                type="text"
                                class="form-control"
                                id="phone"
                                placeholder="Enter phone number"
                                name="phone"
                        />
                    </div>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">Email</span>
                        </div>
                        <input
                                type="email"
                                class="form-control"
                                placeholder="Enter email"
                                name="email"
                        />
                    </div>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                                    <span class="input-group-text"
                                    >Address</span
                                    >
                        </div>
                        <input
                                type="text"
                                class="form-control"
                                id="email"
                                placeholder="Enter email"
                                name="email"
                        />
                    </div>
                    <div class="modal-footer">
                        <button
                                type="submit"
                                class="btn btn-success btn-sm"
                        >
                            Add new
                        </button>
                        <button
                                type="button"
                                class="btn btn-danger btn-sm"
                                data-dismiss="modal"
                        >
                            Cancel
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

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
                Do you want to delete <b>abc</b> ?
            </div>

            <!-- Modal footer -->
            <div class="modal-footer">
                <button
                        type="submit"
                        class="btn btn-success btn-sm"
                        data-dismiss="modal"
                >
                    <b>Ok, DELETE</b>
                </button>
                <button
                        type="button"
                        class="btn btn-danger btn-sm"
                        data-dismiss="modal"
                >
                    Cancel
                </button>
            </div>
        </div>
    </div>
</div>