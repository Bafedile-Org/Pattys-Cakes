<%-- 
    Document   : index
    Created on : Oct 31, 2022, 8:42:56 AM
    Author     : Hlawulani Baloyi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head class="top-head">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Pacifico">
        <script src="js/main.js"></script>
    </head>
    <body class="home-body">
        <header class="home-head">
            <nav>
                <div class="topnav" >
                    <h1 align="center" id='home-header1'>
                        Patty's Bakery   
                        <i class="fa fa-bars dropdown" aria-hidden="true" style="font-size:24px; padding-right: 24px">
                            <div class="dropdown-content">
                                <a  href="aboutUs">About Us</a>
                                <a  href="stores">Our Stores</a>
                                <a href="signup">Signup/Signin</a>
                            </div>
                        </i>
                    </h1>
                </div>
            </nav>
        </header>

        <div class="slidershow middle">
            <div class="slides">
                <input type="radio" name="r" id="r1" checked>
                <input type="radio" name="r" id="r2" >
                <input type="radio" name="r" id="r3" >
                <input type="radio" name="r" id="r4" >
                <input type="radio" name="r" id="r5" >

                <div class="slide s1">
                    <a href="cookies_control"><img src="assets/cookies/cokkies_pic2.jpg" alt="Plain Coffee Cookies"></a>
                </div>
                <div class="slide ">
                    <a href="cakes_control"><img src="assets/cakes/rainbow_cake3.jpg" alt="Rainbow Cake"></a>
                </div>
                <div class="slide ">
                    <a href="pies_control"><img src="assets/personal_pies/blueberry pies.jpg" alt="Blueberry Pies"></a>
                </div>
                <div class="slide ">
                    <a href="doughnuts_control"><img src="assets/doughnuts/dougnuts2.jpg" alt="Glazed Simpsons Doughnuts"></a>
                </div>
                <div class="slide ">
                    <a href="cupcakes_control"><img src="assets/muffins/muffins_and_cupcakes.png" alt="Muffins And  Cupcakes"></a>
                </div>


            </div>
            <div class="navigation">
                <label for="r1" class="bar"></label>
                <label for="r2" class="bar"></label>
                <label for="r3" class="bar"></label>
                <label for="r4" class="bar"></label>
                <label for="r5" class="bar"></label>
            </div>
        </div>

        <div class="contact-div">
            <h4 align="center">Contact</h4>
            <div><i class="fa fa-phone" aria-hidden="true">+27712345536</i></div>
            <div><i class="fa fa-envelope" aria-hidden="true">info@pattybakery.com</i></div>
            <div>
                <i class="fa fa-globe" aria-hidden="true"></i>
                <a href='#'><i class="fa fa-twitter" aria-hidden="true"></i></a>
                <a href='#'> <i class="fa fa-facebook-official" aria-hidden="true"></i></a>
                <a href='#'><i class="fa fa-instagram" aria-hidden="true"></i></a>
                <a href='#'><i class="fa fa-whatsapp" aria-hidden="true"></i></a>
            </div>
        </div>
    </body>
</html>
