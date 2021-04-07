<%-- 
    Document   : Home
    Created on : Jan 5, 2021, 2:23:11 PM
    Author     : ANH NGUYEN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width" initial-scale="1">
        <script src="https://apis.google.com/js/platform.js" async defer></script>
        <meta name="google-signin-client_id" content="243151196244-39r53fd3cafmickd0kdi5ksapb2p64sh.apps.googleusercontent.com">
        <title >Login Account</title>
        <!--Use bootStrap 4 -->     
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
        <script src="https://apis.google.com/js/platform.js" async defer></script>
        <style type="text/css"> 
            .container h2{
                background: #0062cc;
                color: #fff;
                width: 200px;
                font-size: 24px;
                padding: 5px;
                height: 40px;
            }
            .container h2::after{
                content: '';

                position: relative;
                left: 48px;
                top: 34px;
            }
            .row{
                margin-top: 30px;
            }
            img{
                width: 80%;
                border: 1px;
                margin-left: 20px;
                margin-bottom: 15px;
            }
            .product-bottom .fa{
                color: #28a745;
                font-size: 10px;
            }
            .product-bottom h6{
                font-size: 20px;
                font-weight: bold;
            }
            .product-bottom h7{
                font-size: 15px;
                padding-bottom: 10px;
            }
            .overlay{
                display: block;
                opacity: 0;
                position: absolute;
                top: 10%;
                margin-left: 0;
                width: 70px;
            }
            .product-top:hover .overlay{
                opacity: 1;
                margin-left: 5%;
                transition: 0.5s;
            }
            .overlay .fa{
                cursor: pointer;
                background-color: #fff;
                color: #000;
                height: 35px;
                width: 35px;
                font-size: 20px;
                padding: 7px;
                margin: 5%;
                margin-bottom: 5%;
            }
            .overlay .btn-secondary{
                background: transparent !important;
                border:none !important;
                box-shadow: none !important;  
            }
            .pagination{
                display: inline-block;
            }
            .pagination a{
                float: left;
                padding: 8px 16px;
                text-decoration: none;
                border: 1px solid;
            }
            .pagination a:hover{
                background-color: #ddd;
            }
            .pagination a:first-child {
                border-top-left-radius: 5px;
                border-bottom-left-radius: 5px;                
            }
            .pagination a:first-child {
                border-top-left-radius: 5px;
                border-bottom-left-radius: 5px;                
            }
            .preferences{
                background-color: rgb(121 165 143 / 50%);
                position: absolute;
                z-index: 99999999;
                width: 180px;
                left: 0%;
                border-radius: 10px;

            }
            .preferences div{
                border: 2px solid #79a58f;
                border-radius: 10px;
                width: 250px;
                margin: 10px auto;
                height: 300px;
                background-color: #d8e6df;
            }

            .preferences h4{
                text-align: center;
                font-family: Georgia, 'Times New Roman', Times, serif;
                font-size: 120%;
                margin: 15px 0px;
            }

            .together{
                background-color: rgb(121 165 143 / 50%);
                position: absolute;
                z-index: 99999999;
                width: 270px;
                top: 127%;
                border-radius: 10px;
            }
            .together div{
                border: solid #79a58f;
                border-radius: 10px;
                width: 250px;
                margin: 10px auto;
                height: 300px;
                background-color: #d8e6df;
            }

            .together h4{
                text-align: center;
                font-family: Georgia, 'Times New Roman', Times, serif;
                font-size: 90%;
                margin: 15px 0px;
            }

            .together h3{
                text-align: center;
                font-family: Georgia, 'Times New Roman', Times, serif;
                font-size: 150%;
                margin: 15px 0px;
            }
            .imgFavor{
                text-align: center;
                border: 5px;
            }
            p{
                margin: 15px 20px;

            }
        </style>

    </head>
    <body>
        <div class="container">
            <!--header -->
            <div class="header">
                <nav class="navbar navbar-expand-lg navbar-light bg-light">
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav mr-auto">
                            <li class="nav-item active">
                                <a class="nav-link" href="LoadHomePage"><i class="fa fa-home"></i> Home <span class="sr-only">(current)</span></a>
                            </li>

                            <form action="ShoppingManager">
                                <li class="nav-item">
                                    <c:set var="isMember" value="${member}" />
                                    <c:set var="isAdmin" value="${admin}"/>
                                    <c:set var="gAccount" value="${accountGoogle}"/>

                                    <c:if test="${not empty isMember}">
                                        <a class="nav-link" href="#"> <i class="fa fa-user"></i> ${isMember} </a> 
                                    </c:if>       
                                    <c:if test="${not empty isAdmin}">
                                        <a class="nav-link" href="#"> <i class="fa fa-user"></i> ${isAdmin} </a> 
                                    </c:if>  
                                    <c:if test="${ empty isMember && empty isAdmin}">
                                        <a class="nav-link" href="ShoppingManager?btAction=loginAccount"> <i class="fa fa-user"></i> Login </a> 
                                    </c:if>  
                                </li>
                            </form>




                            <c:choose>
                                <c:when test="${not empty isAdmin }">
                                    <li class="nav-item">
                                        <a class="nav-link" href="ShoppingManager?btAction=history"><i style="font-size:24px" class="fa">&#xf1da;</i>History</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="ShoppingManager?btAction=deleteRecordPage"><i class="fa fa-user" aria-hidden="true"></i> Manage Deleted Food</a>
                                    <li class="nav-item">
                                        <a class="nav-link" href="ShoppingManager?btAction=addFoodPage"><i style="font-size:20px" class="fa">&#xf067;</i> Add Food</a>
                                    </c:when>
                                </c:choose>   


                                <c:choose>
                                    <c:when test="${not empty isMember && empty gAccount}">

                                    <li class="nav-item">
                                        <a class="nav-link" href="ShoppingManager?btAction=shoppingCart"><i class="fa fa-shopping-cart"></i> Cart</a>
                                    </li>

                                    <li class="nav-item">
                                        <a class="nav-link" href="ShoppingManager?btAction=userHistory"><i class="fa fa-history"></i>Shopping History</a>
                                    </li>

                                    <li class="nav-item">
                                        <a class="nav-link" href="ShoppingManager?btAction=logOut&&user=${isMember}"><i class="fa fa-sign-out"></i> Log out</a>
                                    </li>
                                </c:when>
                                <c:when test="${not empty isAdmin}">
                                    <li class="nav-item">
                                        <a class="nav-link" href="ShoppingManager?btAction=logOut&&user=${isMember}"><i class="fa fa-sign-out"></i> Log out</a>
                                    </li>
                                </c:when>   

                                <c:when test="${not empty isMember && not empty gAccount}">

                                    <li class="nav-item">
                                        <a class="nav-link" href="ShoppingManager?btAction=shoppingCart"><i class="fa fa-shopping-cart"></i> Cart</a>
                                    </li>

                                    <li class="nav-item">
                                        <a class="nav-link" href="ShoppingManager?btAction=userHistory"><i class="fa fa-history"></i>Shopping History</a>
                                    </li>

                                    <li class="nav-item">
                                        <a class="nav-link"  href="ShoppingManager?btAction=logOut&&user=${isMember}" onclick="myFunction()"><i class="fa fa-sign-out"></i> Log out</a>
                                        <div class="g-signin2"  ></div>
                                        <script>
                                            function myFunction() {
                                                gapi.auth2.getAuthInstance().disconnect();
                                                location.reload();
                                            }
                                        </script>
                                    </li>
                                </c:when>

                            </c:choose>

                        </ul>
                        <form class="form-inline my-2 my-lg-0" action="ShoppingManager">
                            <select name="categoryFood" >
                                <option>DairyFood</option>
                                <option>SeaFood</option>
                                <option>Vegetables</option>
                                <option>Drink</option>
                            </select>
                            &nbsp;                        
                            <div>
                                Price

                                <input type="number" name="fromPrice" placeholder="From" min="0"> 
                                <input type="number" name="toPrice" placeholder="To" min="0"> 
                            </div>
                            <br>
                            &nbsp;
                            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="txtSearch">
                            <input class="btn btn-outline-success my-2 my-sm-0" type="submit" name="btAction" value="search"/>
                        </form>
                    </div>


            </div> 

            <p style="color: green" ><c:out value="${welcomeUser}" /></p>

            <p style="color: green" ><c:out value="${textMess}" /></p>
            <p style="color: green" ><c:out value="${cartMess}" /></p>
            <p style="color: green" ><c:out value="${confirmMess}" /></p>
            <p style="color: red" ><c:out value="${rangeNotValid}" /></p>
            <!--Body-->
            <div class="body">
                <h2>Hana Shop</h2>
                <div class="row">



                    <form action="ShoppingManager">
                        <div class="preferences">
                            <h4>Your favourite</h4>
                            <c:forEach var="f" items="${listFavour}">
                                <img src="${f.imageFood}" style="width: 150px">
                                <p>${f.nameFood}</p>
                                <p>${f.priceFood}</p>
                               
                                </c:forEach>
                        </div>
                    </form>




                    <c:forEach var="F" items="${listFoodHomePage}">

                        <div class="col-md-3">
                            <div class="product-top">

                                <img src="${F.imageFood}" style="width: 300px">



                                <c:choose>
                                    <c:when test="${ empty isMember && not empty isAdmin && F.statusFood eq 'active'}">

                                        <div class="overlay">
                                            <form action="ShoppingManager">
                                                <input type="hidden" name="txtfoodID" value="${F.idFood}"/>
                                                <input type="hidden" name="txtfoodName" value="${F.nameFood}"/>
                                                <button type="submit" class="btn btn-secondary"  name="btAction" value="deleteFood"><i class="fa fa-trash"></i></button>
                                                <button type="submit" class="btn btn-secondary"  name="btAction" value="update" ><i style="font-size:20px" class="fa">&#xf021;</i></button>

                                            </form>

                                        </div>
                                    </div>
                                </c:when>

                                <c:when test="${empty isMember }">
                                </div>
                            </c:when>

                            <c:otherwise>
                                <div class="overlay">
                                    <form action="ShoppingManager">
                                        <input type="hidden" name="txtfoodID" value="${F.idFood}"/>
                                        <input type="hidden" name="txtfoodName" value="${F.nameFood}"/>
                                        <button type="submit" class="btn btn-secondary" title="add Cart" name="btAction" value="addCart"><i class="fa fa-cart-plus"></i></button>
                                    </form>
                                    <button type="submit" class="btn btn-secondary" title="love Product" name="btAction" value="lovely" ><i class="fa fa-heart-o"></i></button>
                                </div>
                            </div>
                        </c:otherwise>
                    </c:choose>

                    <div class="product-bottom text-center">
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <h6>${F.nameFood}</h6>
                        <h7>${F.priceFood} $</h7>
                        <select name="categoryFood" >
                            <option>${F.categoryFood}</option>
                            <option>${F.statusFood}</option>
                        </select>
                    </div>       
                </div>

            </c:forEach>









        </div>
    </div>


    <div class="pagination">
        <c:forEach var="s" begin="1" end="${endPage}">
            <a href="ShoppingManager?btAction=homePage&&index=${s}">${s}</a>
        </c:forEach>
    </div>









    <!-- footer -->
    <div class="footer">
        <!-- Footer -->
        <footer class="page-footer font-small mdb-color lighten-3 pt-4">

            <!-- Footer Links -->
            <div class="container text-center text-md-left">

                <!-- Grid row -->
                <div class="row">

                    <!-- Grid column -->
                    <div class="col-md-4 col-lg-3 mr-auto my-md-4 my-0 mt-4 mb-1">

                        <!-- Content -->
                        <h5 class="font-weight-bold text-uppercase mb-4">More Information</h5>
                        <p><i class="fa fa-github-alt"></i> HN Company.</p>
                        <p>HN is a brand used by Asus since 2006, encompassing a range of computer hardware, personal computers, peripherals, and accessories oriented primarily toward PC gaming.</p>

                    </div>
                    <!-- Grid column -->

                    <hr class="clearfix w-100 d-md-none">

                    <!-- Grid column -->
                    <div class="col-md-2 col-lg-2 mx-auto my-md-4 my-0 mt-4 mb-1">

                        <!-- Links -->
                        <h5 class="font-weight-bold text-uppercase mb-4">About</h5>

                        <ul class="list-unstyled">
                            <li>
                                <p>
                                    <a href="#!">PROJECTS</a>
                                </p>
                            </li>
                            <li>
                                <p>
                                    <a href="#!">ABOUT US</a>
                                </p>
                            </li>
                            <li>
                                <p>
                                    <a href="#!">BLOG</a>
                                </p>
                            </li>
                            <li>
                                <p>
                                    <a href="#!">AWARDS</a>
                                </p>
                            </li>
                        </ul>

                    </div>
                    <!-- Grid column -->

                    <hr class="clearfix w-100 d-md-none">

                    <!-- Grid column -->
                    <div class="col-md-4 col-lg-3 mx-auto my-md-4 my-0 mt-4 mb-1">

                        <!-- Contact details -->
                        <h5 class="font-weight-bold text-uppercase mb-4">Address</h5>

                        <ul class="list-unstyled">
                            <li>
                                <p>
                                    <i class="fa fa-home"></i> Sai gon,Ho chi minh,2020-VN</p>
                            </li>
                            <li>
                                <p>
                                    <i class="fa fa-envelope-o"></i>   info@example.com</p>
                            </li>
                            <li>
                                <p>
                                    <i class="fa fa-phone-square"></i> + 01 234 567 88</p>
                            </li>
                            <li>
                                <p>
                                    <i class="fa fa-phone-square"></i> + 01 234 567 89</p>
                            </li>
                        </ul>

                    </div>
                    <!-- Grid column -->

                    <hr class="clearfix w-100 d-md-none">

                    <!-- Grid column -->
                    <div class="col-md-2 col-lg-2 text-center mx-auto my-4">

                        <!-- Social buttons -->
                        <h5 class="font-weight-bold text-uppercase mb-4">Follow Us</h5>

                        <!-- Facebook -->
                        <a type="button" class="btn-floating btn-fb">
                            <i class="fa fa-facebook-official"></i>
                        </a>
                        <!-- Twitter -->
                        <a type="button" class="btn-floating btn-tw">
                            <i class="fa fa-twitter"></i>
                        </a>
                        <!-- Google +-->
                        <a type="button" class="btn-floating btn-gplus">
                            <i class="fa fa-google"></i>
                        </a>
                        <!-- Dribbble -->
                        <a type="button" class="btn-floating btn-dribbble">
                            <i class="fa fa-dribbble"></i>
                        </a>

                    </div>
                    <!-- Grid column -->

                </div>
                <!-- Grid row -->

            </div>
            <!-- Footer Links -->

            <!-- Copyright -->

        </footer>
        <!-- Footer -->
    </div> 
</div>

</body>
</html>
