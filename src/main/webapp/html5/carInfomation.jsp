<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/1/2023
  Time: 3:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Car Infomation</title>
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" rel="stylesheet">
  <link href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js" rel="stylesheet">
  <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
  <style>
    body{background: linear-gradient(to right, #c04848, #480048);min-height: 100vh}.text-gray{color: #aaa}img{height: 170px;width: 140px}
  </style>
</head>
<body>
<div class="container py-5">
  <div class="row text-center text-white mb-5">
    <div class="col-lg-7 mx-auto">
      <h1 class="display-4">Information Car</h1>
    </div>
  </div>
  <div class="row">
    <div class="col-lg-8 mx-auto">
      <ul class="list-group shadow">
        <li class="list-group-item">
          <div class="media align-items-lg-center flex-column flex-lg-row p-3">
            <div class="media-body order-2 order-lg-1">
              <h5 class="mt-0 font-weight-bold mb-2">${car.carName}</h5>
              <p class="font-italic text-muted mb-0 small">${car.color}</p>
              <div class="d-flex align-items-center justify-content-between mt-1">
                <h6 class="font-weight-bold my-2">${car.price} B VND</h6>
                <ul class="list-inline small">
                  <li class="list-inline-item m-0"><i class="fa fa-star text-success"></i></li>
                  <li class="list-inline-item m-0"><i class="fa fa-star text-success"></i></li>
                  <li class="list-inline-item m-0"><i class="fa fa-star text-success"></i></li>
                  <li class="list-inline-item m-0"><i class="fa fa-star text-success"></i></li>
                  <li class="list-inline-item m-0"><i class="fa fa-star text-success"></i></li>
                </ul>
              </div>
            </div><img src="${car.img}" alt="Generic placeholder image" width="200" class="ml-lg-5 order-1 order-lg-2">
          </div>
        </li>
      </ul>
    </div>
  </div>
</div>
</body>
</html>
