<%--
  Created by IntelliJ IDEA.
  User: Phakp
  Date: 6/11/2566
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>6513050067 - Monthon Mukkun</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container mx-auto">
    <h2 class="bg-primary p-2 text-white">Classic Model Offices ::</h2>
    <table class="table-auto w-full">
        <thead>
        <tr>
            <th class="px-4 py-2">OfficeCode</th>
            <th class="px-4 py-2">City</th>
            <th class="px-4 py-2">Phone</th>
            <th class="px-4 py-2">AddressLine1</th>
            <th class="px-4 py-2">Country</th>
            <th class="px-4 py-2">PostalCode</th>
            <th class="px-4 py-2">Territory</th>
            <th class="px-4 py-2">Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${offices}" var="office">
            <tr>
                <td class="border px-4 py-2">${office.officeCode}</td>
                <td class="border px-4 py-2">${office.city}</td>
                <td class="border px-4 py-2">${office.phone}</td>
                <td class="border px-4 py-2">${office.addressLine1}</td>
                <td class="border px-4 py-2">${office.country}</td>
                <td class="border px-4 py-2">${office.postalCode}</td>
                <td class="border px-4 py-2">${office.territory}</td>
                <td class="border px-4 py-2">
                    <a href="editOffice?officeCode=${office.officeCode}" class="text-blue-500">Edit</a>
                    <a href="deleteOffice?officeCode=${office.officeCode}" class="text-red-500 ml-2">Delete</a>
                </td>
            </tr>
        </c:forEach>
        <div class="container mt-3">
            <div class="row">
                <div class="col-md-6 d-flex justify-content-start">
                    <a href="addOffice" class="text-blue-500">Add</a>
                </div>
                <div class="col-md-6 d-flex justify-content-end w-50">
                    <form action="searchOffice" method="post">
                        <input name="searchByCityOrCountry" style="width: 280px;" type="text" placeholder="Search By City or Country" class="form-control m-1">
                        <button type="submit" class="btn btn-primary">Search</button>
                    </form>
                </div>
            </div>
        </div>
        </tbody>
    </table>
    <div>
        <c:choose>
            <c:when test="${statusAdd}">
                <h5 class="text-success">${messageAdd}</h5>
            </c:when>
            <c:otherwise>
                <h5 class="text-danger">${messageAdd}</h5>
            </c:otherwise>
        </c:choose>
        <c:choose>
            <c:when test="${statusUpdate}">
                <h5 class="text-success">${messageUpdate}</h5>
            </c:when>
            <c:otherwise>
                <h5 class="text-danger">${messageUpdate}</h5>
            </c:otherwise>
        </c:choose>
        <c:choose>
            <c:when test="${statusDelete}">
                <h5 class="text-success">${messageDelete}</h5>
            </c:when>
            <c:otherwise>
                <h5 class="text-danger">${messageDelete}</h5>
            </c:otherwise>
        </c:choose>
    </div>
</div>
</body>
</html>