<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>User Details ${id}</title>
                <!-- Latest compiled and minified CSS -->
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

                <!-- Latest compiled JavaScript -->
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>


                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
                <!-- <link href="/css/demo.css" rel="stylesheet"> -->

            </head>

            <body>
                <div class="container mt-5">
                    <div class="d-flex justify-content-between">
                        <div class="mr-auto p-2">
                            <h2>User Details</h2>
                        </div>
                        <div class="p-2">
                            <a href="/admin/user/create"><button type="button" class="btn btn-primary">Create new
                                    user</button></a>
                        </div>

                    </div>
                    <hr />

                    <div class="card" style="width: 60%;">
                        <div class="card-header">
                            User Information ${id}
                        </div>
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item">ID: ${user.id}</li>
                            <li class="list-group-item">Email: ${user.email}</li>
                            <li class="list-group-item">Full Name: ${user.fullName} </li>
                            <li class="list-group-item">Address: ${user.address}</li>
                        </ul>
                    </div>
                    <a href="/admin/user" class="btn btn-primary mt-3">Back</button></a>

                </div>
            </body>

            </html>