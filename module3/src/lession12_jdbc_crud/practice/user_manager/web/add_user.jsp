<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- The Modal -->
            <div class="modal fade" id="myModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <!-- Modal Header -->
                        <div class="modal-header">
                            <h4 class="modal-title">Add new user</h4>
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
                                    placeholder="Enter name"
                                    name="name"
                                />
                                <input
                                    type="text"
                                    class="form-control"
                                    id="email"
                                    placeholder="Enter email"
                                    name="email"
                                />
                                <input
                                    type="text"
                                    class="form-control"
                                    id="country"
                                    placeholder="Enter country"
                                    name="country"
                                />
                                <button type="submit" class="btn btn-success">
                                    Submit
                                </button>
                            </form>
                        </div>
                        <!-- Modal footer -->
                        <div class="modal-footer">
                            <button
                                type="button"
                                class="btn btn-danger"
                                data-dismiss="modal"
                            >
                                Close
                            </button>
                        </div>
                    </div>
                </div>
            </div>