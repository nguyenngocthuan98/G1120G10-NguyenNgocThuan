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
                                id=""
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
                                id="email"
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