<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hungchivang
  Date: 1/4/2023
  Time: 9:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Total Price</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="card">
    <div class="card-body">
        <div class="container mb-5 mt-3">
            <div class="row d-flex align-items-baseline">
                <div class="col-xl-9">
                    <p style="color: #7e8d9f;font-size: 20px;">Invoice >> <strong>Total Price</strong></p>
                </div>
                <div class="col-xl-3 float-end">
                    <a class="btn btn-light text-capitalize border-0" data-mdb-ripple-color="dark"><i
                            class="fas fa-print text-primary"></i> <a href=""></a>Back</a>
                </div>
                <hr>
            </div>

            <div class="row my-2 mx-1 justify-content-center">
                <table class="table table-striped table-borderless">
                    <thead style="background-color:#84B0CA ;" class="text-white">
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Name Client</th>
                        <th scope="col">Name Car</th>
                        <th scope="col">Color</th>
                        <th scope="col">Price</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="total" items="${danhgia}">
                    <tr>
                        <th scope="row">1</th>
                        <td>${total.carName}</td>
                        <td>${total.IDKH}</td>
                        <td>${total.color}</td>
                        <td>${total.price}</td>
                    </tr>
                    </c:forEach>
                    </tbody>

                </table>
            </div>
            <div class="row">
                <div class="col-xl-8">
                    <p class="ms-3">Add additional notes and payment information</p>
                </div>
                <div class="col-xl-3">
                    <ul class="list-unstyled">
                        <li class="text-muted ms-3"><span class="text-black me-4">SubTotal</span></li>
                        <li class="text-muted ms-3 mt-2"><span class="text-black me-4">Tax(0%)</span>$0</li>
                    </ul>
                    <p class="text-black float-start"><span class="text-black me-3"> Total Amount</span><span
                            style="font-size: 25px;">${totals} B VND</p>
                </div>
            </div>
            <hr>

        </div>
    </div>
</div>
</div>
</body>
</html>
