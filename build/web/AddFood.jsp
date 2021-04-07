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
                background: url('Background_AddFood.jpg') no-repeat;
                width: 100%;
                height: 100vh;
                background-size: 100%;
            }
        </style>
    </head>
    <body>

        <div class="container-fluid bg">
            <form action="ShoppingManager" style="width: 500px; margin: auto " method="post">            
                <div class="row">
                    <div class="col">
                        <div class="form-group">
                            <label for="firstname"><b>Food ID</b></label>
                            <input type="text" name="id" class="form-control" value="${idAdd}" >                          
                        </div>
                    </div>

                    <div class="col">
                        <div class="form-group">
                            <label for="lastname"><b>Food Name</b></label>
                            <input type="text" name="name" class="form-control" value="${nameAdd}" >
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col">
                        <div class="form-group">
                            <label for="firstname"><b>Image</b></label>
                            <input type="text" name="image" class="form-control" value="${imageAdd}" >
                        </div>
                    </div>

                    <div class="col">
                        <div class="form-group">
                            <label for="lastname"><b>Description</b></label>
                            <input type="text" name="desc" class="form-control" value="${descriptionAdd}">
                        </div>
                    </div>

                </div>

                <div class="row">


                    <div class="col">
                        <div class="form-group">
                            <label for="lastname"><b>Category</b></label>
                            <input type="text" name="category" class="form-control"value="${categoryAdd}" >
                        </div>
                    </div>                       
                </div>



                <div class="row">


                    <div class="col">
                        <div class="form-group">
                            <label for="lastname"><b>Quantity</b></label>
                            <input type="text" name="quantity" class="form-control" value="${quantityAdd}" >
                        </div>
                    </div>


                </div>
                <div class="form-group">
                    <label for="username"><b>Price</b></label>
                    <input type="text" name="price" class="form-control" value="${priceAdd}" >
                </div>
                <p style="color: red"><b><c:out value="${errorAdd}" /></b></p>
                <input type="submit" class="btn btn-primary btn-block" value="add" name="btAction">



            </form>
        </div>
    </body>
</html>
