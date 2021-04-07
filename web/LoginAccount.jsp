<%-- 
    Document   : Registration
    Created on : Nov 2, 2020, 8:30:52 PM
    Author     : ANH NGUYEN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://apis.google.com/js/platform.js" async defer></script>
        <meta name="google-signin-client_id" content="243151196244-39r53fd3cafmickd0kdi5ksapb2p64sh.apps.googleusercontent.com">
        <title>Create Account</title>
        <!--Use bootStrap 4 -->     
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="https://apis.google.com/js/platform.js" async defer></script>

        <style type="text/css">
            .form-container{
                background: #fff;
                padding: 30px;
                border-radius: 10px;
                box-shadow: 0px 0px 10px 0px #000;
            }
            .bg{
                background: url('Background_LoginAccount.jpg') no-repeat;
                width: 100%;
                height: 100vh;
                background-size: 100%;
            }
        </style>
        <c:set var="error" value="${error}"/>
    </head>
    <body>
        <section class="container-fluid bg">
            <section class="row justify-content-center">
                <section class="col-12 col-sm-6 col-md-3">
                    <form class="form-container" action="ShoppingManager" method="post">
                        <div class="form-group">
                            <label for="exampleInputEmail1">Email address</label>
                            <input type="text" class="form-control"  placeholder="Enter user" name="txtUser" value="${nameUser}" >                       
                            <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>

                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Password</label>
                            <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" name="password" value="${passwordUser}">
                        </div>

                        <p style="color: red"><c:out value="${error}" /></p>
                        <input type="submit" class="btn btn-primary btn-block" name="btAction" value="login Account">
                        <br>
                        <div class="g-signin2" data-onsuccess="onSignIn" id="myP"></div>
                        <p id="name"></p>
                    </form>
                    <script type="text/javascript">
                        function onSignIn(googleUser) {
                            var profile = googleUser.getBasicProfile();
                            var imgurl = profile.getImageUrl();
                            var name = profile.getName();
                            var email = profile.getEmail();
                            var givenName = profile.getGivenName();
                            var familyName = profile.getFamilyName();
                            var id = profile.getId();
                            
                            
                            window.location.replace("ShoppingManager?btAction=accountGoogle&&txtUser="+givenName+"&&txtFullName="+name+" "); 
                        }
                    </script>
                   
                </section>
            </section>
        </section>

    </body>
</html>
