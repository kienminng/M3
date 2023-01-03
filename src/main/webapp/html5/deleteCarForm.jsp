<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/1/2023
  Time: 4:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <style>
        *{
            font-family: Arial,Tahoma,sans-serif;
        }
    </style>

</head>
<body >
<form action="/deleteCar?carID=${car.carID}" method="post" class="container" style="margin-top: 50px;background: url('https://images.wallpapersden.com/image/download/ferrari-supercar-sports-car_Zm5pZ2qUmZqaraWkpJRmbmdlrWZlbWU.jpg') center / cover no-repeat">
    <div class="card-body p-md-5 text-black">
        <h3 class="mb-5 text-uppercase">Are you sure ?</h3>

        <div class="row">
            <div class="col-md-6 mb-4">
                <div class="form-outline">
                    <input type="text" id="form3Example1e" class="form-control form-control-lg" name="carID" value="${car.carID}" readonly />
                    <label class="form-label" for="form3Example1m">Car ID</label>
                </div>
            </div>
            <div class="col-md-6 mb-4">
                <div class="form-outline">
                    <input type="text" id="form3Example1m" class="form-control form-control-lg" name="carName" value="${car.carName}" readonly/>
                    <label class="form-label" for="form3Example1m">Car name</label>
                </div>
            </div>
            <div class="col-md-6 mb-4">
                <div class="form-outline">
                    <input type="number" id="form3Example1n" class="form-control form-control-lg" name="price" value="${car.price}" readonly/>
                    <label class="form-label" for="form3Example1n">Price</label>
                </div>
            </div>
        </div>

        <div class="form-outline mb-4">
            <input type="text" id="form3Example9" class="form-control form-control-lg" name="color" value="${car.color}" readonly/>
            <label class="form-label" for="form3Example9">Color</label>
        </div>

        <div class="form-outline mb-4">
            <input type="text" id="form3Example90" class="form-control form-control-lg" name="img" value="${car.img}"readonly />
            <label class="form-label" for="form3Example90">Img</label>
        </div>

        <div class="form-outline mb-4">
            <input type="text" id="form3Example99" class="form-control form-control-lg" name="branch" value="${car.branch}" readonly/>
            <label class="form-label" for="form3Example99">Branch</label>
        </div>

        <div class="d-flex justify-content-end pt-3">
            <button type="submit" class="btn btn-warning btn-lg ms-2">Yes , I'm</button>
        </div>


        <div class="d-flex justify-content-end pt-3" style="float: right">
            <a href="/carModal" class="btn btn-dark">Back</a>
        </div>
    </div>
</form>
</body>
</html>
