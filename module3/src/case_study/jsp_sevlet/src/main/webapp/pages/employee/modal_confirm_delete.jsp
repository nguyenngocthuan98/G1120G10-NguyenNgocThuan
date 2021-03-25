<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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