<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                <form method="POST">
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">Customer ID</span>
                        </div>
                        <input type="text" class="form-control" id="id" placeholder="KH-XXXX" name="customerId"/>
                    </div>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">Customer type</span>
                        </div>
                        <label>
                            <select class="form-control" name="customerTypeName">
                                <option value="Diamond">Diamond</option>
                                <option value="Platinum">Platinum</option>
                                <option value="Gold">Gold</option>
                                <option value="Silver">Silver</option>
                                <option value="Member">Member</option>
                            </select>
                        </label>
                    </div>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">Name</span>
                        </div>
                        <input type="text" class="form-control" placeholder="Enter name customer" name="customerName"/>
                    </div>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">Birthday</span>
                        </div>
                        <input type="date" class="form-control" name="customerBirthday"/>
                    </div>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">Gender</span>
                        </div>
                        <select class="form-control" name="customerGender" id="">
                            <option value="Male">Male</option>
                            <option value="Female">Female</option>
                        </select>
                    </div>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">ID Card</span>
                        </div>
                        <input type="text" class="form-control" placeholder="Enter 9 or 12 digits" name="customerIdCard"/>
                    </div>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">Phone</span>
                        </div>
                        <input type="text" class="form-control" placeholder="Format 090 | 091 | (+84)"
                               name="customerPhone"/>
                    </div>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">Email</span>
                        </div>
                        <input type="email" class="form-control" placeholder="Enter email" name="customerEmail"/>
                    </div>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">Address</span>
                        </div>
                        <input type="text" class="form-control" placeholder="Enter address" name="customerAddress"/>
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-success btn-sm" name="action" value="create">
                            Add new
                        </button>
                        <button type="button" class="btn btn-danger btn-sm" data-dismiss="modal">
                            Cancel
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>