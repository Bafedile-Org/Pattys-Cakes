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
            /*
                Created on : 24 Nov 2022, 11:43:06 AM
                Author     : Dimakatso Sebatane
            */

            body {
                font-family: Prata;
                padding: 5%;
                text-align: center;
                font-size: 50;
            }

            #slideshow {
                overflow:hidden;
                height: 320px;
                width: 430px;


                margin-top:-100px;
                margin-left: -600px;

            }

            .slide {
                float: left;
                height: 320px;
                width: 430px;

            }
            .slide-number{
                font-size:20px;
                font-family:"Prata";
            }

            .slide-wrapper {

                width: calc(430px * 5);
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
                    margin-left: calc(-430px* 1);
                }
                60% {
                    margin-left: calc(-430px* 2);
                }
                80% {
                    margin-left: calc(-430px% * 3);
                }
                100% {
                    margin-left: calc(-430px * 4);
                }
            }
            .parent{
                position: relative;
            }
            .content{
                position: absolute;
                top: 15%;
                left: 55%;
            }

        </style>
        <link rel="stylesheet" href="css/style.css">
        <!--<link rel="stylesheet" href="css/index_cascading.css">-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Prata">
    </head>
    <body class="home-body " >
        <header class="home-head" id='myHeader' style='position:static'>
            <nav>
                <div class="topnav" >
                    <h1 align="center" id='home-header1' style=" font-size:70px;" >
                        Patty's Bakery
                        <i class="fa fa-bars dropdown" aria-hidden="true" style="font-size:24px; padding-right: 24px">

                            <div class="dropdown-content" style="background-color:lightgray">
                                <a href = 'cakes_control'>Cakes</a>
                                <a href = 'cupcakes_control'>Cupcakes</a>
                                <a href = 'muffins_control'>Muffins</a>
                                <a href = 'doughnuts_control'>Doughnuts</a>
                                <a href = 'pies_control'>Pies</a>
                                <a href = 'cookies_control'>Cookies</a>
                                <a  href="aboutUs">About Us</a>
                                <a  href="cart_control">Checkout</a>
                                <a  href="stores">Our Stores</a>
                                <a href="signup?ses=ses">Signup/Signin</a>

                            </div>
                        </i>
                    </h1>
                </div>
            </nav>
        </header>
        <div class="parent">

            <img src="assets/whiteCover.jpg" style="width:1400px;height:800px;margin-top:-15px" alt="cover">

            <div id="slideshow" class="content" >
                <div class="slide-wrapper">

                    <div id="slideshow" class="content" >
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

                </div>
            </div>
            <div style='background-color:lightblue;height:404px;padding:13px;margin-top:2%' >
                <div class="column" align="left">
                    <img src="assets/whiteCcake.jpg" style="width:49%;height:30%;margin-top: -25px;margin-left: -20px"  alt="Snow">
                </div>
                <div  style="width:49%;height:30%;margin-top: -335px;margin-left: 580px">
                    <h2>Cupcakes</h2><br><br>
                    <p>What makes the perfect cupcake? High quality natural</p>
                    <p>ingredients go into our freshly baked sponges, which we</p>
                    <p>lovingly hand bake and decorate from scratch everyday.</p>
                    <p>It is home baking done patty's way.</p>
                </div>
            </div>


            <div style='background-color:lightyellow;height:404px;padding:13px;margin-top:2%' >
                <div  style='margin-left: 20px;margin-top:90px;width:40%;'>
                    <h2>Cakes</h2><br><br>
                    <p>Sometimes only a cake will do and for these occasions,</p>
                    <p>we've got you covered! Our cakes bring layers of joy</p>
                    <p>( and rich buttercream) to any occasion. From classics </p>
                    <p>to show stopping center pieces, all of our beautiful decorated</p>
                    <p>cakes are made the old fashion way: from scratch and with love.</p>
                </div>
                <div class="column" align="right" style="margin-top:-110px">
                    <img src="assets/whiteCake.jpg" style="width:52%;height:25%;margin-top: -165px;margin-right: -12px"  alt="Snow">
                </div>
            </div>


            <div style='background-color:lightpink;height:404px;padding:13px;margin-top:2%' >
                <div class="column" align="left">
                    <img src="assets/whitePie.jpg" style="width:49%;height:30%;margin-top: -25px;margin-left: -20px"  alt="Snow">
                </div>
                <div  style='width: 51%;margin-top:-335px;margin-left: 580px'>
                    <h2>Pies</h2><br><br>
                    <p>Our pies are filled with so much goodness. Our quiches</p>
                    <p>are made with top quality crispy pastry and packed with</p>
                    <p>scrumptious sinful fresh ingredients that that will make.</p>
                    <p>you swoon.</p>

                </div>
            </div>


            <div style='background-color:lightgreen;height:411px;padding:13px;margin-top:2%' >
                <div  style='margin-left: 20px;margin-top:70px;width:40%;'>
                    <h2>Muffins</h2><br><br>
                    <p>A bad day eating muffins is better than a good day doing anything</p>
                    <p>else. Baked with the freshest ingredients and filled with love to</p>
                    <p>sooth your soul. You can never go wrong with Patty's muffins</p>
                </div>
                <div class="column" align="right" style="margin-top:-110px">
                    <img src="assets/whiteMuffin.jpg" style="width:50%;height:25%;margin-top: -107px;margin-right: -12px"  alt="Snow">
                </div>
            </div>

            <div style='background-color:lightsalmon;height:404px;padding:13px;margin-top:2%' >
                <div class="column" align="left">
                    <img src="assets/whiteDoughnut.jpg" style="width:49%;height:30%;margin-top: -25px;margin-left: -20px"  alt="Snow">
                </div>
                <div  style='width: 51%;margin-top:-335px;margin-left: 580px'>
                    <h2>Doughnuts</h2><br><br>
                    <p> You can’t buy happiness but you can buy donuts. And that’s kind of</p>
                    <p> the same thing.</p>
                    <p></p>
                    <p></p>
                </div>
            </div>

            <div style='background-color:lightblue;height:404px;padding:13px;margin-top:2%' >
                <div  style='margin-left: 20px;margin-top:70px;width:40%;'>
                    <h2>Cookies</h2>
                    <p>The pleasure lies not in the cookies, but in the pattern the crumbs</p>
                    <p>make when the cookies crumble.We offer the best quality homemade</p>
                    <p> cookies freshly baked from our oven to your door step everyday.</p>
                    <p> Try us and get indulged in the chewy gooey goodness</p>
                </div>
                <div class="column" align="right" style="margin-top:-145px">
                    <img src="assets/whiteMuffin.jpg" style="width:49%;height:25%;margin-top: -53px;margin-right: -12px"  alt="Snow">
                </div>
            </div>

            <div class="contact-div content" style='margin-left: -700px;margin-top: 605px'>
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
