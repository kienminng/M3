<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Car home</title>
    <link rel="stylesheet" href="Css/style.css">
    <link rel="stylesheet" href="themify-icons/themify-icons.css" >

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
                        <li><a href="priceNormal">normal</a></li>
                        <li><a href="priceMedium">Midrange </a></li>
                        <li><a href="priceHigh">high</a></li>
                    </ul>
                </div>
            </li>
        </ul>
    </div>
    <div id="login-icon">
        <ul>
            <li>
                <a href=""><i class="ti-email"></i></a>
            </li>
            <c:if test="${client.role ==2}">
                <li><a href="/ListUser"><i class="ti-user"></i></a></li>
                <li><a href="createCar"><i class="ti-car"></i></a></li>
                <li><a href="/adminHoaDon"><i class="ti-shopping-cart-full"></i></a></li>

            </c:if>
            <c:if test="${client.role ==1}">
                <li><a href="/cartUser?email=${client.email}"><i class="ti-shopping-cart"></i></a></li>

            </c:if>
            <li>
                <a href="profile?email=${client.email}" >Welcome ${client.name} <i class="setting-login ti-id-badge"></i></a>
            </li>
        </ul>
    </div>

</div>

<div class="mySlider" id="slider" style="display: block">
    <div class="text-content">
        <h2 class="text-heading">Bugatti Chiron</h2>
        <div class="text-description">The chiron is the fastest, most powerful, and exclusive production super sports car in.</div>
    </div>
</div>

<div class="mySlider" id="slider1" style="display: none">
    <div class="text-content">
        <h2 class="text-heading"> The McLaren 650S Spider</h2>
        <div class="text-description">It's tackles corners in a flat and neutral manner, always inspiring confidencetackles corners in a flat and neutral manner, always inspiring confidence</div>
    </div>

</div>
<div class="mySlider" id="slider2" style="display: none">
    <div class="text-content">
        <h2 class="text-heading">Lamborghini Aventador Ultimae </h2>
        <div class="text-description">It is a famous German supercar brand with the world's leading "warriors"</div>
    </div>
</div>

<div>
    <script src="Js/ImgChange.js"></script>
</div>
</body>

</html>