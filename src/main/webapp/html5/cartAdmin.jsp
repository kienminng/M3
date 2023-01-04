<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/1/2023
  Time: 3:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>

    </style>
</head>
<body>
<section class="h-100 h-custom" style="background-color: #eee;">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col">
                <div class="card">
                    <div class="card-body p-4">

                        <div class="row">

                            <div class="col-lg-7">
                                <h5 class="mb-3"><a href="/carHome" class="text-body"><i
                                        class="fas fa-long-arrow-alt-left me-2"></i>Back Home</a></h5>
                                <hr>


                                <div class="card mb-3">
                                    <div class="card-body">
                                        <c:forEach var="list" items="${list}">
                                            <c:if test="${list.status==2}">
                                                <div class="d-flex justify-content-between">
                                                    <div class="d-flex flex-row align-items-center">
                                                        <div class="img-fluid rounded-3"style="width: 65px;" >
                                                            <h5><a href="/viewClientProfile?IDKH=${list.IDKH}">${list.IDKH}</a></h5>
                                                        </div>
                                                        <div class="ms-3">
                                                            <h5><a href="#">${list.carName}</a></h5>
                                                        </div>
                                                        <div class="ms-3">
                                                            <h5><a href="#">${list.color}</a></h5>
                                                        </div>
                                                        <div class="ms-3">
                                                            <h5><img src="${list.img}" alt=""></h5>
                                                        </div>
                                                        <div class="ms-3">
                                                            <h5><a href="#">${list.price} B VND</a></h5>
                                                        </div>
                                                        <div class="d-flex flex-row align-items-center">
                                                            <c:if test="${list.status==2}">
                                                                <div style="width: 80px;">
                                                                    <a href="/deleteCarFromCart?carID=${list.carID}"><button type="button" class="btn btn-danger">Delete</button></a>
                                                                </div>
                                                                <div style="width: 80px;">
                                                                    <a href="/comfirmCarFormCart?carID=${list.carID}"><button type="button" class="btn btn-info">confirm</button></a>
                                                                </div>
                                                            </c:if>
                                                            <c:if test="${list.status==3}">
                                                                <div style="width: 80px;">
                                                                    <input type="text" value="${list.content}" readonly>
                                                                </div>
                                                            </c:if>


                                                            <a href="#!" style="color: #cecece;"><i class="fas fa-trash-alt"></i></a>
                                                        </div>
                                                    </div>

                                                </div>
                                            </c:if>


                                        </c:forEach>

                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>
