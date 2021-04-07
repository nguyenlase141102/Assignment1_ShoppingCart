<%-- 
    Document   : Login
    Created on : Nov 2, 2020, 7:58:03 PM
    Author     : ANH NGUYEN
--%>


<%@page import="nguyenla.tblfood.FoodDTO"%>
<%@page import="nguyenla.cart.CartDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width" initial-scale="1">
        <title >Login Account</title>
        <!--Use bootStrap 4 -->     
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
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
                width: 100%;
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

            .cart-page{
                margin: 5px auto;
            }
            table{
                width: 100%;
                border-collapse: collapse;
            }
            .cart-info{
                display: flex;
                flex-wrap: wrap;
            }
            img{
                width: 150px;
            }
            th{
                text-align: left;
                padding: 5px;
                color: #fff;
                background: #ff523b;
                font-weight: normal;
            }
            td{
                padding: 10px 5px;
            }
            td input{
                width: 60px;
                height: 30px;
                padding: 5px;
            }
            td a{
                color: #ff523b;
                font-size: 12px;    
            }
            td img{
                width: 110px;
                height: 80px;
                margin-right: 10px;
            }
            .total-price{
                display: flex;
                justify-content: flex-end;
            }
            .total-price table{
                border-top: 3px solid #ff523b;
                width: 100%;
                max-width: 400px;
            }
            td:last-child{
                text-align: right;
            }
            th:last-child{
                text-align: right;
            }
            .total-price a{
                display: block;
                text-align: center;
                height: 40px;
            }
            .confirm{
                text-align: right;
            }
            .paypal{
                width: 40%;
                height: 30%;
                text-align: right;
                padding: 10px 5px ;
                margin-top: 5px;
                margin-bottom: 5px;
                margin-left:61%;
            }
        </style>
    </head>

    <body>
        <div class="container"> 
            <!-- header -->
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
                                        <a class="nav-link" href="ShoppingManager?btAction=History"><i style="font-size:24px" class="fa">&#xf1da;</i>History</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="ShoppingManager?btAction=deleteRecordPage"><i class="fa fa-user" aria-hidden="true"></i> Manage Deleted Food</a>
                                    <li class="nav-item">
                                        <a class="nav-link" href="ShoppingManager?btAction=addFoodPage"><i style="font-size:20px" class="fa">&#xf067;</i> Add Food</a>
                                    </c:when>
                                    <c:otherwise>
                                    <li class="nav-item">
                                        <a class="nav-link" href="ShoppingManager?btAction=shoppingCart"><i class="fa fa-shopping-cart"></i> Cart</a>
                                    </li>
                                </c:otherwise>
                            </c:choose>   


                            <c:choose>
                                <c:when test="${not empty isMember}">
                                    <li class="nav-item">
                                        <a class="nav-link" href="ShoppingManager?btAction=logOut&&user=${isMember}"><i class="fa fa-sign-out"></i> Log out</a>
                                    </li>
                                </c:when>

                                <c:when test="${not empty isAdmin}">
                                    <li class="nav-item">
                                        <a class="nav-link" href="ShoppingManager?btAction=logOut&&user=${isMember}"><i class="fa fa-sign-out"></i> Log out</a>
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

                                <input type="number" name="fromPrice" placeholder="From" required="required"> 
                                <input type="number" name="toPrice" placeholder="To" required="required"> 
                            </div>
                            <br>
                            &nbsp;
                            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="txtSearch">
                            <input class="btn btn-outline-success my-2 my-sm-0" type="submit" name="btAction" value="search"/>
                        </form>
                    </div>


            </div>
        </nav>

        <br>

        <p style="color: green"><c:out value="${weluser}" /></p>

        <!-- body -->
        <br>
        <c:set var="cart" value="${sessionScope.CART}" />
        <c:set var="sub" value="${subTotal}" /> 
        <c:set var="outStock" value="${outStock}" /> 
        <p style="color: red"><c:out value="${amountMess}" /></p>
        <p style="color: red"><c:out value="${outStock}" /></p>
        <p style="color: green"><c:out value="${cartSuccess}" /></p>
        <div class="small-container cart-page">
            <table>
                <thead>
                    <tr>
                        <th>Product</th>
                        <th>Quantity</th>
                        <th>Subtotal</th>

                    </tr>
                </thead>
                <c:forEach var="s" items="${cart.getCartItem()}">
                    <tr>
                        <td>
                            <div class="cart-info">
                                <img src="${s.value.imageFood}"/>
                                <div>
                                    <p>${s.value.nameFood}</p>
                                    <small>Price: $ ${s.value.priceFood}</small>
                                    <a href="ShoppingManager?btAction=remove Cart&&hiddenID=${s.value.idFood}" onclick="return confirm('Are you sure you want to delete this item?');">Remove</a>
                                </div>
                            </div>
                        </td>
                        <td>

                            <form action="ShoppingManager">
                                <c:if test="${not empty updateAmount}">
                                    <input type="text" value="${s.value.quantityFood}" name="amount" />                                   
                                    <input type="hidden" value="${s.value.idFood}" name="hiddenID" />
                                    <input type="submit" name="btAction" value="confirm" />
                                </c:if>
                                <c:if test="${ empty updateAmount}">
                                    <input type="text" value="${s.value.quantityFood}" readonly  />

                                </c:if>

                            </form>
                        </td>
                        <td>$ ${s.value.priceFood*s.value.quantityFood}</td>                                 
                    </tr>
                </c:forEach>

            </table>

            <c:if test="${not empty cart}">

                <form action="ShoppingManager">
                    <div class="total-price">
                        <table>
                            <tr>
                                <td>Subtotal</td>
                                <td>$<c:out value="${sub}" /></td>
                            </tr>
                            <tr>
                                <td>Tax</td>
                                <td>$10</td>
                            </tr>
                            <tr>
                                <th>Payment Method:</th>
                                <th>
                                    <select name="cmbPayment">
                                        <option>Cash</option>
                                        <option>Credit Card</option>
                                    </select>
                                </th>

                            </tr>

                            <tr>
                                <td>Total</td>
                                <td>$<c:out value="${sub + 10}" /></td>
                            </tr>

                        </table>
                    </div>
                    <div class="confirm">
                        <input type="submit" name="btAction" value="proceed to check out" />
                        <input type="hidden" name="user" value="${User}" />

                        <input type="submit" name="btAction" value="update Amount">
                    </div>
                </form>



            </c:if>

        </div>


        <c:if test="${not empty cart}">
            
                <form action="${initParam['posturl']}" class="paypal " method="post" >
                    <input type="hidden" name="upload" value="1">
                    <input type="hidden" name="return" value="${initParam['returnurl']}"/>
                    <input type="hidden" name="cmd" value="_cart">
                    <input type="hidden" name="business" value="${initParam['business']}"/>

                    <input type="hidden" name="item_name_1" value="IPHONES"  />
                    <input type="hidden" name="amount_1"  value="${sub+10}" />
                    <input type="hidden" name="user" value="${User}" />
                    <input type="hidden" name="quantity_1" value="1"  />

                    <input class="paypal" type="image" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQO3AuiOYtuPqEWEs2HuJgGdL6vc6fYCbeEhg&usqp=CAU" />
                  

                </form> 
            
        </c:if>


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
                <div class="footer-copyright text-center py-3">© 2020 Copyright:
                    <a href="https://mdbootstrap.com/"> MDBootstrap.com</a>
                </div>
                <!-- Copyright -->

            </footer>
            <!-- Footer -->
        </div> 
    </div>
</body>
</html>
