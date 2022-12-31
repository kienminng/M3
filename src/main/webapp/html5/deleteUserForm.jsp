<%--
  Created by IntelliJ IDEA.
  User: hungchivang
  Date: 12/30/2022
  Time: 3:11 PM
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
<body>
<form method="post" action="ConfirmDeleteUser?email=${User.email}" class="container mt-3 color-rect-border " >
  <fieldset>
    <legend>Are you sure?</legend>
    <table class="table center-pill" style="border: 1px solid black">
      <tr>
        <td>Name : </td>
        <td>${User.name}</td>
      </tr>
      <tr>
        <td>Email: </td>
        <td>${User.email}</td>
      </tr>
      <tr>
        <td>Gender: </td>
        <td>${User.gender}</td>
      </tr>
      <tr>
        <td>Address : </td>
        <td>${User.address}</td>
      </tr>
      <tr>
        <td>PhoneNumber : </td>
        <td>${User.phoneNumber}</td>
      </tr>
      <tr>
        <td></td>
        <td><input type="submit" ></td>
      </tr>
      <tr>
        <td><a href="ListUser">Back</a></td>
        <td></td>
      </tr>

    </table>
  </fieldset>
</form>
</body>
</html>
