<%-- 
    Document   : Search
    Created on : Nov 4, 2020, 3:13:05 PM
    Author     : ANH NGUYEN
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <style type="text/css">
        .row{
            margin-top: 30px;
        }
    </style>
    <body>
        <table class="table table-striped table-dark">
            <thead>
                <tr>
                    <th scope="col"> ID </th>
                    <th scope="col"> Name</th>
                    <th scope="col"> Date</th>
                    <th scope="col"> Price</th>
                    <th scope="col"> Category</th>
                </tr>
            </thead>
            <tbody>
            <form action="ShoppingManager">
                <c:set var="delete" value="${sessionScope.recordFoodToDelete}" />
                <c:if test="${not empty delete}">
                    <div class="body">
                        <c:forEach var="s" items="${delete.getCartItem()}">
                            <tr>
                                <td>${s.value.idFood}                                   
                                </td>
                                <td>${s.value.nameFood}</td>
                                <td>${s.value.createDateFood}</td>
                                <td>${s.value.priceFood}</td>
                                <td>${s.value.categoryFood}</td>
                            </tr>
                        </c:forEach>

                        <!--                                                        <input type="submit" class="btn btn-primary btn-block" name="btAction" value="Remove" >-->

                    </div>
                    <button><a href="ShoppingManager?btAction=remove" onclick="return confirm('Are you sure you want to delete this item?');">Delete All Food</a></button>
                </c:if>

            </form>

        </tbody>
    </table>
</body>
</html>
