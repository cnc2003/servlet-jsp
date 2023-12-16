<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 7/11/2566
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <title>6513050067 - Monthon Mukkun</title>
</head>
<div class="container">
    <h1 class="mb-4">OfficeManagement</h1>
    <ul class="nav nav-tabs">
        <li class="nav-item">
            <a class="nav-link" href="office-list">Show All Data</a>
        </li>
    </ul>

    <h3 class="mt-5">Add Office Data</h3>
    <form action="addOffice" method="POST">
        <div class="form-group">
            <label for="officeCode">officeCode:</label>
            <input type="text" class="form-control" name="officeCode" >
        </div>
        <div class="form-group">
            <label for="city">City:</label>
            <input type="text" class="form-control" name="city" >
        </div>
        <div class="form-group">
            <label for="phone">Phone:</label>
            <input type="text" class="form-control" name="phone">
        </div>
        <div class="form-group">
            <label for="addressLine1">AddressLine1:</label>
            <input type="text" class="form-control" name="addressLine1">
        </div>
        <div class="form-group">
            <label for="country">Country:</label>
            <input type="text" class="form-control" name="country">
        </div>
        <div class="form-group">
            <label for="postalCode">PostalCode:</label>
            <input type="text" class="form-control" name="postalCode">
        </div>
        <div class="form-group">
            <label for="territory">Territory:</label>
            <input type="text" class="form-control" name="territory">
        </div>
        <button type="submit" class="btn btn-primary">ADD</button>
    </form>
    <hr>
</div>
</html>
