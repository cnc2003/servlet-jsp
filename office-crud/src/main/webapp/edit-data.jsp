<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 7/11/2566
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>6513050067 - Monthon Mukkun</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1 class="mb-4">OfficeManagement</h1>
    <ul class="nav nav-tabs">
        <li class="nav-item">
            <a class="nav-link" href="office-list">Show All Data</a>
        </li>
    </ul>

    <h3 class="mt-5">Update Office Data</h3>
    <form action="editData?officeCode=${office.officeCode}" method="POST">
        <div class="form-group">
            <label for="city">City:</label>
            <input type="text" class="form-control" name="city" value="${office.city}" >
        </div>
        <div class="form-group">
            <label for="phone">Phone:</label>
            <input type="text" class="form-control" name="phone" value="${office.phone}" >
        </div>
        <div class="form-group">
            <label for="addressLine1">AddressLine1:</label>
            <input type="text" class="form-control" name="addressLine1" value="${office.addressLine1}">
        </div>
        <div class="form-group">
            <label for="country">Country:</label>
            <input type="text" class="form-control" name="country" value="${office.country}" >
        </div>
        <div class="form-group">
            <label for="postalCode">PostalCode:</label>
            <input type="text" class="form-control" name="postalCode" value="${office.postalCode}" >
        </div>
        <div class="form-group">
            <label for="territory">Territory:</label>
            <input type="text" class="form-control" name="territory" value="${office.territory}">
        </div>
        <input type="submit" class="btn btn-primary" value="UPDATE">
        <input type="reset" class="btn btn-primary" value="RESET">
    </form>
    <hr>
</div>
</body>
</html>
