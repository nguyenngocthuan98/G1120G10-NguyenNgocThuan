<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- The Modal -->
<div class="modal fade" id="myModalUpdate">
    <div class="modal-dialog">
        <div class="modal-content">
            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title">Update user</h4>
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
                <form action="/users" method="POST">
                    <input
                            type="text"
                            class="form-control"
                            id="name"
                            value="code here"
                            name="name"
                    />
                    <input
                            type="text"
                            class="form-control"
                            id="email"
                            value="code here"
                            name="email"
                    />
                    <input
                            type="text"
                            class="form-control"
                            id="country"
                            value="code here"
                            name="country"
                    />
                    <input type="hidden" name="action" value="update">
                    <button type="submit" class="btn btn-success btn-sm">
                        Update
                    </button>
                </form>
            </div>
            <!-- Modal footer -->
            <div class="modal-footer">
                <button
                        type="button"
                        class="btn btn-danger btn-sm"
                        data-dismiss="modal"
                >
                    Close
                </button>
            </div>
        </div>
    </div>
</div>