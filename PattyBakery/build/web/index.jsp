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
        <style>
            body {
                font-family: Prata;
                padding: 5%;
                text-align: center;
                font-size: 50;
            }

            #slideshow {
                
                overflow:hidden;
                height: 310px;
                width: 428px;

                margin-top: -100px;
                margin-left: -200px;

                position:absolute;
                top: 50%;
                left: 50%;
            }

            .slide {
                float: left;
                height: 310px;
                width: 428px;

            }
            .slide-number{
                font-size:20px;
                font-family:"Prata";
            }
           
            .slide-wrapper {

                width: calc(428px * 5);
                animation: slide 15s ease infinite;
            }

            .slide:nth-child(1) {
                background-image:url("assets/pexels-marta-dzedyshko-2067424.jpg");
                background-size: cover;
            }

            .slide:nth-child(2) {
                background-image:url("assets/pexels-quang-nguyen-vinh-2144200.jpg");
                background-size: cover;
            }

            .slide:nth-child(3) {
                background-image:url("assets/pexels-alisha-mishra-1346263.jpg");
                background-size: cover;
            }

            .slide:nth-child(4) {
                background-image:url("assets/personal_pies/blueberry pies.jpg");
                background-size: cover;
            }
            .slide:nth-child(5) {
                background-image:url("assets/pexels-son-tung-tran-7454368.jpg");
                background-size: cover;
            }

            @keyframes slide {

                20% {
                    margin-left: 0px;
                }
                40% {
                    margin-left: calc(-428px * 1);
                }
                60% {
                    margin-left: calc(-428px * 2);
                }
                80% {
                    margin-left: calc(-428px * 3);
                }
                100% {
                    margin-left: calc(-428px * 4);
                }
            }
        </style>
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <!--<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Pacifico">-->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Prata">
        <script src="js/main.js"></script>
    </head>
    <body class="home-body" style='background-size:cover'>
        <header class="home-head">
            <nav>
                <div class="topnav" >
                    <h1 align="center" id='home-header1'>
                        Patty's Bakery
                        <i class="fa fa-bars dropdown" aria-hidden="true" style="font-size:24px; padding-right: 24px">
                            <div class="dropdown-content">
                                <a href = 'cakes_control'>Cakes</a>
                                <a href = 'cupcakes_control'>Cupcakes</a>
                                <a href = 'muffins_control'>Muffins</a>
                                <a href = 'doughnuts_control'>Doughnuts</a>
                                <a href = 'pies_control'>Pies</a>
                                <a href = 'cookies_control'>Cookies</a>
                                <a  href="aboutUs">About Us</a>
                                <a  href="stores">Our Stores</a>
                                <a href="signup">Signup/Signin</a>
                                
                            </div>
                        </i>
                    </h1>
                </div>
            </nav>
        </header>

        <div id="slideshow">
            <div class="slide-wrapper">

                <div class="slide" onclick="location.href = 'cookies_control'">
                    <header class="home-head">
                        <nav>
                            <h1 class="slide-number">
                                View our Cookies
                            </h1>
                        </nav></header>
                </div>
                <div class="slide" onclick="location.href = 'cakes_control'">
                    <header class="home-head">
                        <nav>
                            <h1 class="slide-number">
                                View our Cakes
                            </h1>
                        </nav></header> </div>
                <div class="slide" onclick="location.href = 'doughnuts_control'">
                    <header class="home-head">
                        <nav>
                            <h1 class="slide-number">
                                View our Doughnuts
                            </h1>
                        </nav></header>
                </div>
                <div class="slide" onclick="location.href = 'pies_control'">
                    <header class="home-head">
                        <nav>
                            <h1 class="slide-number">
                                View our Pies
                            </h1>
                        </nav></header>
                </div>
                <div class="slide" onclick="location.href = 'cupcakes_control'">
                    <header class="home-head">
                        <nav>
                            <h1 class="slide-number">
                                View our Cupcakes&Muffins
                            </h1>
                        </nav></header>
                </div>
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
