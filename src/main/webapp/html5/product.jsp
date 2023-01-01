<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 28/12/2022
  Time: 3:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Product</title>
  <style>
    .card {
      box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
      max-width: 300px;
      margin-left:20px ;
      font-family: arial;
      position: relative;
      float: left;
      display: inline-block;
    }

    .price {
      color: grey;
      font-size: 22px;
    }

    .card button {
      border: none;
      outline: 0;
      padding: 12px;
      color: white;
      background-color: #000;
      text-align: center;
      cursor: pointer;
      width: 100%;
      font-size: 18px;
    }

    .card button:hover {
      opacity: 0.7;
    }

    /*body{*/
    /*  font-family: 'Roboto', sans-serif;*/
    /*  margin: 0;*/
    /*  padding: 0;*/
    /*  display: flex;*/
    /*  justify-content: center;*/
    /*  align-items: center;*/
    /*  min-height: 100vh;*/
    /*}*/
    /*.container{*/
    /*  position: relative;*/
    /*}*/
    /*.container .noi_dung img{*/
    /*  position: absolute;*/
    /*  top: 0;*/
    /*  left: 0;*/
    /*  width: 100%;*/
    /*  height: 100%;*/
    /*  object-fit: cover;*/
    /*}*/
    /*.container .noi_dung::before{*/
    /*  content: '';*/
    /*  position: absolute;*/
    /*  top: 0;*/
    /*  left: 0;*/
    /*  width: 100%;*/
    /*  height: 100%;*/
    /*  background: #000;*/
    /*  z-index: 1;*/
    /*  animation: reveal 1s reverse forwards;*/
    /*  animation-delay: 3s;*/
    /*  transform-origin: right;*/
    /*}*/
    /*@keyframes reveal{*/
    /*  0%{*/
    /*    transform: scaleX(0);*/
    /*  }*/
    /*  100%{*/
    /*    transform: scaleX(1);*/
    /*  }*/
    /*}*/

  </style>
  <link rel="stylesheet" href="/Css/style.css">
  <link rel="stylesheet" href="/themify-icons/themify-icons.css">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body style="background: url('https://wallpapercave.com/wp/wp5215885.jpg') top center /cover no-repeat">
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
      <c:if test="${client.role ==2}">
        <li><a href="/ListUser"><i class="ti-user"></i></a></li>
        <li><a href=""><i class="ti-plus ti-car"></i></a></li>
      </c:if>
      <li><a href=""><i class="ti-shopping-cart"></i></a></li>
      <li>
        <a href="profile?email=${client.email}" > ${client.name} <i class="setting-login ti-user"></i></a>
      </li>
    </ul>
  </div>
</div>
<div class="container" style="margin-top: 70px">
  <h1 style="text-align: center">List of cars</h1>
  <c:forEach items="${carList}" var="cars">
    <div class="card col-4" style="max-height: 470px;min-height: 470px">
      <div class="noi_dung">
        <img src="${cars.img}" alt="loading" style="width:100%">
        <h1>${cars.carName}</h1>
        <p class="price">${cars.price} B VND</p>
        <h3>${cars.branch} , color: ${cars.color}  </h3>
        <p><button><a href="/addToCart?carID=${cars.carID}" style="text-decoration: none">Add to Cart</a></button></p>
      </div>

    </div>
  </c:forEach>
</div>



</body>
</html>
