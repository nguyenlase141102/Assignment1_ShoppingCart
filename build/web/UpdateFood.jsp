<%-- 
    Document   : updateProduct
    Created on : Nov 5, 2020, 2:22:58 PM
    Author     : ANH NGUYEN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <style type="text/css">

            .bg{
                background: url('Background_Update.jpg') no-repeat;
                width: 100%;
                height: 100vh;
                background-size: 100%;
            }
        </style>
    </head>
    <body>
        <c:set var="s" value="${InfoUpdate}" />
        <div class="container-fluid bg">
            <form action="ShoppingManager" style="width: 500px; margin: auto " method="post">            
                <div class="row">
                    <div class="col">
                        <div class="form-group">
                            <label for="firstname"><b>Food ID</b></label>
                            <c:choose>
                                <c:when test="${not empty InfoUpdate}">
                                    <input type="text" name="id" class="form-control" value="${s.idFood}" readonly>
                                   
                                </c:when>
                                <c:otherwise>
                                    <input type="text" name="id" class="form-control" value="${idUpdate}">
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>

                    <div class="col">
                        <div class="form-group">
                            <label for="lastname"><b>Food Name</b></label>
                            <c:choose>
                                <c:when test="${not empty InfoUpdate}">
                                    <input type="text" name="name" class="form-control" value="${s.nameFood}">
                                </c:when>
                                <c:otherwise>
                                    <input type="text" name="name" class="form-control" value="${nameUpdate}">
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>


                </div>

                <div class="row">
                    <div class="col">
                        <div class="form-group">
                            <label for="firstname"><b>Image</b></label>
                            <c:choose>
                                <c:when test="${not empty InfoUpdate}">
                                    <input type="text" name="image" class="form-control" value="${s.imageFood}">
                                </c:when>
                                <c:otherwise>
                                    <input type="text" name="image" class="form-control" value="${imageUpdate}">
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>

                    <div class="col">
                        <div class="form-group">
                            <label for="lastname"><b>Description</b></label>
                            <c:choose>
                                <c:when test="${not empty InfoUpdate}">
                                    <input type="text" name="desc" class="form-control" value="${s.descriptionFood}">
                                </c:when>
                                <c:otherwise>
                                    <input type="text" name="desc" class="form-control" value="${descriptionUpdate}">
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>

                </div>




                <div class="row">
                    <div class="col">
                        <div class="form-group">
                            <label for="firstname"><b>CreateDate</b></label>
                            <c:choose>
                                <c:when test="${not empty InfoUpdate}">
                                    <input type="text" name="createDate" class="form-control" value="${s.createDateFood}">
                                </c:when>
                                <c:otherwise>
                                    <input type="text" name="createDate" class="form-control" value="${dateUpdate}">
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>

                    <div class="col">
                        <div class="form-group">
                            <label for="lastname"><b>Category</b></label>
                            <c:choose>
                                <c:when test="${not empty InfoUpdate}">
                                    <input type="text" name="category" class="form-control" value="${s.categoryFood}">
                                </c:when>
                                <c:otherwise>
                                    <input type="text" name="category" class="form-control" value="${categoryUpdate}">
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>                       
                </div>



                <div class="row">
                    <div class="col">
                        <div class="form-group">
                            <label for="firstname"><b>Status</b></label>
                            <c:choose>
                                <c:when test="${not empty InfoUpdate}">
                                    <input type="text" name="status" class="form-control" value="${s.statusFood}">
                                </c:when>
                                <c:otherwise>
                                    <input type="text" name="status" class="form-control" value="${statusUpdate}">
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>

                    <div class="col">
                        <div class="form-group">
                            <label for="lastname"><b>Quantity</b></label>
                            <c:choose>
                                <c:when test="${not empty InfoUpdate}">
                                    <input type="text" name="quantity" class="form-control" value="${s.quantityFood}">
                                </c:when>
                                <c:otherwise>
                                    <input type="text" name="quantity" class="form-control" value="${quantityUpdate}">
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>


                </div>
                <div class="form-group">
                    <label for="username"><b>Price</b></label>
                    <c:choose>
                        <c:when test="${not empty InfoUpdate}">
                            <input type="text" name="price" class="form-control" value="${s.priceFood}">
                        </c:when>
                        <c:otherwise>
                            <input type="text" name="price" class="form-control" value="${priceUpdate}">
                        </c:otherwise>
                    </c:choose>
                </div>
                <p style="color: red"><b><c:out value="${errorUpdate}" /></b></p>
                <input type="submit" class="btn btn-primary btn-block" value="updateFood" name="btAction">

                </div>  


                <br>


                <br>
            </form>
        </div>
    </body>
</html>
