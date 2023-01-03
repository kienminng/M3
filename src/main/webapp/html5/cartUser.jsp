<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/1/2023
  Time: 10:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cart user</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<section class="vh-100" style="background-color: #fdccbc;">
    <div class="container h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col">
                <p><span class="h2">Order Cart </span><span class="h4"></span></p>

                <c:forEach var="car" items="${cars}" >
                    <c:if test="${car.status!=1}">
                        <div class="card mb-4">
                            <div class="card-body p-4">

                                <div class="row align-items-center">
                                    <div class="col-md-2">
                                        <img src="https://mdbcdn.b-cdn.net/img/Photos/Horizontal/E-commerce/Products/1.webp"
                                             class="img-fluid" alt="Generic placeholder image">
                                    </div>
                                    <div class="col-md-2 d-flex justify-content-center">
                                        <div>
                                            <p class="small text-muted mb-4 pb-2">Car name</p>
                                            <p class="lead fw-normal mb-0">${car.carName}</p>
                                        </div>
                                    </div>
                                    <div class="col-md-2 d-flex justify-content-center">
                                        <div>
                                            <p class="small text-muted mb-4 pb-2">Color</p>
                                            <p class="lead fw-normal mb-0"><i class="fas fa-circle me-2" style="color: #fdd8d2;"></i>
                                            ${car.color}</p>
                                        </div>
                                    </div>

                                    <c:if test="${car.satus==2}">
                                        <div class="col-md-2 d-flex justify-content-center">
                                            <div>
                                                <p class="small text-muted mb-4 pb-2">Status</p>
                                                <p class="lead fw-normal mb-0">Order</p>
                                            </div>
                                        </div>
                                    </c:if>
                                    <c:if test="${car.status==3}">
                                        <div class="col-md-2 d-flex justify-content-center">
                                            <div>
                                                <p class="small text-muted mb-4 pb-2">Status</p>
                                                <p class="lead fw-normal mb-0">Bought</p>
                                            </div>
                                        </div>
                                    </c:if>

                                    <div class="col-md-2 d-flex justify-content-center">
                                        <div>
                                            <p class="small text-muted mb-4 pb-2">Price</p>
                                            <p class="lead fw-normal mb-0">${car.price}</p>
                                        </div>
                                    </div>

<%--                                    <div class="col-md-2 d-flex justify-content-center">--%>
<%--                                        <div>--%>
<%--                                            <p class="small text-muted mb-4 pb-2">Total</p>--%>
<%--                                            <p class="lead fw-normal mb-0">$799</p>--%>
<%--                                        </div>--%>
<%--                                    </div>--%>
                                </div>

                            </div>
                        </div>
                    </c:if>

                </c:forEach>



                <div class="card mb-5">
                    <div class="card-body p-4">

                        <div class="float-end">
                            <p class="mb-0 me-5 d-flex align-items-center">
                                <span class="small text-muted me-2">Order total:</span> <span
                                    class="lead fw-normal">$799</span>
                            </p>
                        </div>

                    </div>
                </div>

                <div class="d-flex justify-content-end">
                    <button type="button" class="btn btn-light btn-lg me-2">Continue shopping</button>
                    <button type="button" class="btn btn-primary btn-lg">Add to cart</button>
                </div>

            </div>
        </div>
    </div>
</section>
</body>
</html>
