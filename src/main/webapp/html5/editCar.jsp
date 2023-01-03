<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/1/2023
  Time: 2:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit car</title>
    <link rel="stylesheet" href="/themify-icons/themify-icons.css">
    <link rel="stylesheet" href="/Css/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div id="header">
    <div id="nav">
        <ul>
            <li><a href="/carHome">Home</a></li>
            <li><a href="carModal?email=${client.email}">Modal</a></li>
            <li>
                <a href="#">Price</a>
                <div class="subnav">
                    <ul>
                        <li><a href="#">normal</a></li>
                        <li><a href="#">Midrange </a></li>
                        <li><a href="#">high</a></li>
                    </ul>
                </div>
            </li>
        </ul>
    </div>
    <div id="login-icon">
        <ul>
            <c:if test="${client.role ==2}">
                <li><a href=""><i class="ti-user"></i></a></li>
                <li><a href="createCar"><i class="ti-plus ti-car"></i></a></li>
            </c:if>
            <li><a href=""><i class="ti-shopping-cart"></i></a></li>
            <li>
                <a href="/profile" >${client.name} <i class="setting-login ti-user"></i></a>
            </li>
        </ul>
    </div>
</div>
<form action="/updateCar" method="post" class="container" style="margin-top: 50px">
    <div class="card-body p-md-5 text-black">
        <h3 class="mb-5 text-uppercase">Edit car form</h3>

        <div class="row">
            <div class="col-md-6 mb-4">
                <div class="form-outline">
                    <input type="text" id="form3Example1e" class="form-control form-control-lg" name="carID" value="${cars.carID}" readonly />
                    <label class="form-label" for="form3Example1m">Car ID</label>
                </div>
            </div>
            <div class="col-md-6 mb-4">
                <div class="form-outline">
                    <input type="text" id="form3Example1m" class="form-control form-control-lg" name="carName" value="${cars.carName}"/>
                    <label class="form-label" for="form3Example1m">Car name</label>
                </div>
            </div>
            <div class="col-md-6 mb-4">
                <div class="form-outline">
                    <input type="number" id="form3Example1n" class="form-control form-control-lg" name="price" value="${cars.price}"/>
                    <label class="form-label" for="form3Example1n">Price</label>
                </div>
            </div>
        </div>

        <div class="form-outline mb-4">
            <input type="text" id="form3Example9" class="form-control form-control-lg" name="color" value="${cars.color}"/>
            <label class="form-label" for="form3Example9">Color</label>
        </div>

        <div class="form-outline mb-4">
            <input type="text" id="form3Example90" class="form-control form-control-lg" name="img" value="${cars.img}"/>
            <label class="form-label" for="form3Example90">Img</label>
        </div>

        <div class="form-outline mb-4">
            <input type="text" id="form3Example99" class="form-control form-control-lg" name="branch" value="${cars.branch}"/>
            <label class="form-label" for="form3Example99">Branch</label>
        </div>

        <div class="d-flex justify-content-end pt-3">
            <button type="reset" class="btn btn-light btn-lg">Reset all</button>
            <button type="submit" class="btn btn-warning btn-lg ms-2">Submit form</button>
        </div>


        <div class="d-flex justify-content-end pt-3" style="float: right">
            <a href="/carModal" class="btn btn-secondary btn-lg ms-2">Back</a>
        </div>


    </div>
</form>
</body>
</html>
