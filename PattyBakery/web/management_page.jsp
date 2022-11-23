<%--
    Document   : management_page
    Created on : 07 Nov 2022, 1:30:30 PM
    Author     : Hlawulani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head class="top-head">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Management page</title>
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Prata">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Pacifico">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="js/main.js"></script>
        <style>

        html, body {
           margin:0px;
           padding:0px;
           background-image:url("../assets/patty_pic_chef.jpg");
           background-size:cover;
        }
        .sf {
          min-height: 400px;
        }
      </style>

    </head>
    <body class="home-body1">
        <header class='home-head'>
            <nav>
                <div class="topnav">
                    <h1 align="center" id='home-header1'>
                        Patty's Bakery Management

                        <i class="fa fa-bars dropdown" aria-hidden="true" style="font-size:24px; padding-right: 24px">
                            <div class="dropdown-content" align="left">
                                <a href="admin/login">Logout</a>
                                <a href="admin/stock">Stock</a>
                                <a href="admin/employee">Employee</a>
                                <a href="admin/orders">Orders</a>
                                <a href="admin/ingredients">Ingredients</a>
                            </div>
                        </i>
                    </h1>

                </div>
            </nav>
        </header>
        <div>
            Today's date: <%= (new java.util.Date()).toLocaleString()%>
        </div>
        <div class="w3-container">
            <div class="w3-content w3-display-container" style="max-width:800px">
                <a href="admin/stock"><img class="mySlides" src="assets/management/stock.jpg" style="width:100%" ></a>
                <a href="admin/employee"><img class="mySlides" src="assets/management/employee.jpg" style="width:100%"></a>
                <a href="admin/orders"><img class="mySlides" src="assets/management/orders.jpg" style="width:100%"></a>
                <a href="admin/ingredients"><img class="mySlides" src="assets/management/ingredient.jfif" style="width:100%"></a>

                <div class="w3-center w3-container w3-section w3-large w3-text-white w3-display-bottommiddle" style="width:100%">
                    <div class="w3-left w3-hover-text-khaki" onclick="plusDivs(-1)">&#10094;</div>
                    <div class="w3-right w3-hover-text-khaki" onclick="plusDivs(1)">&#10095;</div>
                    <span class="w3-badge demo w3-border w3-transparent w3-hover-white" onclick="currentDiv(2)"></span>
                    <span class="w3-badge demo w3-border w3-transparent w3-hover-white" onclick="currentDiv(3)"></span>
                    <span class="w3-badge demo w3-border w3-transparent w3-hover-white" onclick="currentDiv(3)"></span>
                </div>
            </div>
            <script>
                var slideIndex = 1;
                showDivs(slideIndex);

                function plusDivs(n) {
                    showDivs(slideIndex += n);
                }

                function currentDiv(n) {
                    showDivs(slideIndex = n);
                }
                function showDivs(n) {
                    var i;
                    var x = document.getElementsByClassName("mySlides");
                    var dots = document.getElementsByClassName("demo");
                    if (n > x.length) {
                        slideIndex = 1
                    }
                    if (n < 1) {
                        slideIndex = x.length
                    }
                    for (i = 0; i < x.length; i++) {
                        x[i].style.display = "none";
                    }
                    for (i = 0; i < dots.length; i++) {
                        dots[i].className = dots[i].className.replace(" w3-white", "");
                    }
                    x[slideIndex - 1].style.display = "block";
                    dots[slideIndex - 1].className += " w3-white";
                }
            </script>
        </div>


    </body>
</html>
