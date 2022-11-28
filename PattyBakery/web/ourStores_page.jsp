<%--
    Document   : ourStores_page
    Created on : Nov 4, 2022, 11:46:44 AM
    Author     : Bridget Bapela
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Our Stores Page</title>
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Prata">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>
        <header>
            <div class="topnav" >
                <h1 align="center" id='home-header1'>
                    Patty's Bakery
                    <i class="fa fa-bars dropdown" aria-hidden="true" style="font-size:24px; padding-right: 24px">
                        <div class="dropdown-content" align="left">
                            <a href="home">Home</a>
                            <a  href="aboutUs">About Us</a>
                            <a  href="stores">Our Stores</a>
                            <a href="signup?ses=ses">Signup/Signin</a>
                        </div>
                    </i>
                </h1>
            </div>
        </header>


        <div class="box-main">
            <div class="firstHalf" align="center">
                <h1 class="text-big" style="margin-top:30px;text-align:center;" align="center"><strong>Our Stores</strong></h1>
                <p>Visit Our Nearest Branch and Satisfy Your Sweet Tooth with Our Homemade Desserts</p><br>
            </div>
            <div align="center">
                <p><strong>Pretoria,central</strong></p>
                <p>Sammy Marks Square,shop no 28</p>
                <img src="assets/stores/Store2.jpg" alt="store1 picture" width="500" height="400"> <br><br>
                <p><strong>Limpopo,Polokwane</strong></p>
                <p>Mall of the North,shop no 9</p>
                <img src="assets/stores/store2.webp" alt="store1 picture" width="500" height="400"> <br><br>
                <p><strong>Diamond Pavilion Shopping Mall</strong></p>
                <p>Corner Oliver & Macdougal road,Kimberly Kimberley 8301</p>
                <img src="assets/stores/store3.jpg" alt="store1 picture" width="500" height="400"> <br><br>
            </div>
        </div>

    </body>
</html>
