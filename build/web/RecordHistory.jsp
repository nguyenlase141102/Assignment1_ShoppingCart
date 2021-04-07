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
    <body>
<table class="table table-striped table-dark">
  <thead>
    <tr>
      <th scope="col"> ID Food</th>
      <th scope="col"> Name Food</th>
      <th scope="col"> Action</th>
      <th scope="col"> Date Time</th>
     
    </tr>
  </thead>
  <tbody>
      <c:forEach var="s" items="${delHistory}">
          <tr>
              <td>${s.idHistory}</td>
              <td>${s.nameHistory}</td>
              <td>${s.actionHistory}</td>
              <td>${s.dateHistory}</td>
       
          </tr>
      </c:forEach>
          <a href="LoadHomePage">Continue Shopping</a>
  </tbody>
</table>
    </body>
</html>
