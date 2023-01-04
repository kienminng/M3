<%--
  Created by IntelliJ IDEA.
  User: hungchivang
  Date: 12/30/2022
  Time: 1:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <title>List Client</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="Css/style.css">
    <link rel="stylesheet" href="themify-icons/themify-icons.css" >
</head>
<body>

<div class="container mt-3">
    <h2>The list Client</h2>
    <p>The .table-hover class enables a hover state (grey background on mouse over) on table rows:</p>

    <form action="/searchUser" method="post">
    <div style="margin-left: 760px">
        <input type="text" placeholder="Enter here..." name = "name1">
        <button type="submit" style="color: #3c97bf" >Search</button>
        <a href="/carHome" style="margin-left: 20px;font-size: x-large"><i class="ti-home"></i></a>
    </div>
    </form>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Gender</th>
            <th>Address</th>
            <th>PhoneNumber</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${User}">
            <tr>
                <c:if test="${user.role==1}">
                    <td>${user.name}</td>
                    <td>${user.email}</td>
                    <td>${user.gender}</td>
                    <td>${user.address}</td>
                    <td>${user.phoneNumber}</td>
                    <td>
                        <button type="button" class="btn btn-danger"><a href="deleteUser?email=${user.email}">Delete</a>
                        </button>
                    </td>
                </c:if>

            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>

</body>
</html>
