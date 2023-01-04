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
  <link rel="stylesheet" href="/Css/search.css">
  <link rel="stylesheet" href="/Css/style.css">
  <link rel="stylesheet" href="/themify-icons/themify-icons.css">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body style="background: url('https://photo-cms-kienthuc.epicdn.me/zoom/800/uploaded/chiphusg/2015_02_10/supercar-wallpaper1/wallpaper-sieu-xe-cuc-dep-de-mac-ao-tet-cho-desktop-1-hinh-4.jpg') top center /cover no-repeat">
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
        <c:if test="${client.role==1}">
          <a href="/viewEmailUser?email=${client.email}"><i class="ti-email"></i></a>
        </c:if>
        <c:if test="${client.role==2}">
          <a href="/adminEmail"><i class="ti-email"></i></a>
        </c:if>

      </li>

<%--      <li>--%>
<%--        <input type="search" name="name">--%>
<%--      </li>--%>
<%--      <li>--%>
<%--        <a href="/search"><i class="ti-search"></i></a>--%>
<%--      </li>--%>
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
<div class="container" style="margin-top: 70px">


  <div style="margin-left: 810px"><form action="/searchCar" method="post">
    <div>
      <input type="text" placeholder="Enter here..." name = "name1" style="width: 250px">
      <button type="submit" style="color: #3c97bf" >Search</button>
    </div>
  </form>
  </div>
    <h1 style="text-align: center">List of cars</h1>


  <c:forEach items="${carList}" var="cars">
    <c:if test="${cars.status!=3}">
      <div class="card col-4" >
        <div class="noi_dung">
          <img src="${cars.img}" alt="loading" style="width:100%">
          <h1>${cars.carName}</h1>
          <p class="price">${cars.price} B VND</p>
          <h3>${cars.branch} , color: ${cars.color}</h3>
          <c:if test="${client.role==1}">
            <c:if test="${cars.status==1}">
              <p><button><a href="/addToCart?carID=${cars.carID}&&email=${client.email}" style="text-decoration: none">Add to Cart</a></button></p>
            </c:if>
            <c:if test="${cars.status==2}">
              <p><button><a href="#" style="text-decoration: none">Ordered</a></button></p>
            </c:if>
          </c:if>
          <c:if test="${client.role==2}">
            <div>
              <button type="button" class="btn btn-dark" style="width: 35%;float: left;margin-left: 30px;"><a href="/carEdit?carID=${cars.carID}" style="text-decoration: none;color: white">Edit</a></button>
              <button type="button" class="btn btn-warning" style="width: 35%;float: left;margin-left: 20px;"><a href="/viewDeleteCar?carID=${cars.carID}" style="text-decoration: none;color: white">Delete</a></button>
            </div>

          </c:if>
        </div>
      </div>
    </c:if>

  </c:forEach>
</div>



</body>
</html>
