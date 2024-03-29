<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 29/12/2022
  Time: 9:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
    <link rel="stylesheet" href="themify-icons/themify-icons.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .gradient-custom {
            /* fallback for old browsers */
            background: #f6d365;

            /* Chrome 10-25, Safari 5.1-6 */
            background: -webkit-linear-gradient(to right bottom, rgba(246, 211, 101, 1), rgba(253, 160, 133, 1));

            /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
            background: linear-gradient(to right bottom, rgba(246, 211, 101, 1), rgba(253, 160, 133, 1))
        }
    </style>
    <link rel="stylesheet" href="/Css/style.css">
    <link rel="stylesheet" href="/themify-icons/themify-icons.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet">


</head>
<body style="background: url('https://www.supercars.net/blog/wp-content/uploads/2020/09/wallpaperflare.com_wallpaper-1-1.jpg') top center /cover no-repeat">
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
            <c:if test="${client.role==2}">
                <li>
                    <a href="/showMoney"><i class="ti-money"></i></a>
                </li>
            </c:if>

            <li>
                <c:if test="${client.role==1}">
                    <a href="/viewEmailUser?email=${client.email}"><i class="ti-email"></i></a>
                </c:if>
                <c:if test="${client.role==2}">

                    <a href="/adminEmail"><i class="ti-email"></i></a>
                </c:if>
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
                <c:if test="${client.email==null}">
                    <a href="/login" >login <i class="setting-login ti-id-badge"></i></a>
                </c:if>
                <c:if test="${client.email!=null}">
                    <a href="profile?email=${client.email}" >Welcome ${client.name} <i class="setting-login ti-id-badge"></i></a>
                </c:if>
            </li>
        </ul>
    </div>
</div>
<section class="vh-100" style="background-color: #f4f5f7;">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col col-lg-6 mb-4 mb-lg-0">
                <div class="card mb-3" style="border-radius: .5rem;">
                    <div class="row g-0">
                        <div>

                        </div>
                        <div class="col-md-4 gradient-custom text-center text-white"
                             style="border-top-left-radius: .5rem; border-bottom-left-radius: .5rem;">


                            <img src="https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__340.png"
                                 alt="Avatar" class="img-fluid my-5" style="width: 80px;"/>

                            <h5> ${client.name} </h5>

                            =======
                            <c:if test="${client.role==1}">
                                <p>Client</p>
                            </c:if>
                            <c:if test="${client.role==2}">
                                <p>Admin</p>
                            </c:if>


                            <i class="far fa-edit mb-5"></i>

                        </div>
                        <div class="col-md-8">
                            <div class="card-body p-4">
                                <h6>Information</h6>
                                <hr class="mt-0 mb-4">
                                <div class="row pt-1">
                                    <div class="col-6 mb-3">
                                        <h6>Email</h6>
                                        <p class="text-muted">${client.email}</p>
                                    </div>
                                    <div class="col-6 mb-3">
                                        <h6>Phone</h6>
                                        <p class="text-muted">${client.phoneNumber}</p>
                                    </div>
                                </div>
                                <h6>Projects</h6>
                                <hr class="mt-0 mb-4">
                                <div class="row pt-1">
                                    <div class="col-6 mb-3">
                                        <h6>Address</h6>
                                        <p class="text-muted"> ${client.address} </p>
                                    </div>
                                    <div class="col-6 mb-3">
                                        <h6> Position </h6>
                                        <c:if test="${client.role==1}">
                                            <p class="text-muted">User</p>
                                        </c:if>
                                        <c:if test="${client.role==2}">
                                            <p class="text-muted">Admin</p>
                                        </c:if>

                                    </div>
                                </div>
                                <div class="d-flex justify-content-start">
                                    <a href="https://www.facebook.com/"><i class="fab ti-facebook fa-lg me-3"></i></a>
                                    <a href="https://twitter.com/?lang=vi"><i class="fab ti-twitter fa-lg me-3"></i></a>
                                    <a href="https://www.instagram.com/"><i class="fab ti-instagram fa-lg"></i></a>
                                </div>
                                <div>
                                </div>
                                <div>
                                    <button type="button" class="btn btn-danger" style="float: right">
                                        <a href="/login" style="text-decoration: none;color: white">Log out</a>
                                    </button>
                                    <button type="button" class="btn btn-warning" style="float: right">
                                        <a href="editUser?email=${client.email}"
                                           style="text-decoration: none;color: white">Edit profile</a>
                                    </button>
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
