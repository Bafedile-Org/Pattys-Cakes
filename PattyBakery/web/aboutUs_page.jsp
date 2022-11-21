<%-- 
    Document   : aboutUs_Page
    Created on : Nov 4, 2022, 9:21:00 AM
    Author     : Bridget Bapela
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
  
<head>
    <title>About us Page</title>
    <link rel="stylesheet" href="css/style.css">
     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
      <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Prata">
</head>
<body>
    <header>
        <div class="topnav" >
                    <h1 align="center" id='home-header1'>
                        Patty's Bakery   
                        <i class="fa fa-bars dropdown" aria-hidden="true" style="font-size:24px; padding-right: 24px">
                            <div class="dropdown-content">
                                <a href="home">Home</a>
                                <a  href="aboutUs">About Us</a>
                                <a  href="stores">Our Stores</a>
                                <a href="signup">Signup/Signin</a>
                            </div>
                        </i>
                    </h1>
                </div>
    </header>
    <section class="background firstsection">
        <div class="box-main">
            <div class="firstHalf" align="center">
                <h1 class="text-big" style="margin-top:30px;text-align:center;" align="center"><strong>About US</strong></h1>
                <p class="center">To us, baking is an art form, and we take pride in creating tastes that inspire and stir something deep within. 
                <p>Created with only a few pure, high-quality ingredients; mixed and shaped by hand</p>
                <p>and baked baked to perfection- every last crumb has soul.</p><br>
                <p><strong>Service Guarantee</strong></p>
                <p>You’ve spoken, and we’ve listened. Our customers are the reason we do what we do,</p> 
                <p>and your opinion helps shape our menu and service. The Bakery and Cafe goes to great</p>
                <p>lengths to ensure that we only use the freshest ingredients, serve beautiful food,</p> 
                <p>and put a smile on every customer’s face.</p><br>
                <p><strong>The Bakery</strong></p>
                <p>The smell of freshly baked bread, staff that are truly excited to serve you, and food to die for!</p>
                <p>We’ve spent lots of time creating an authentic cafe that will comfort the senses, and the appetite.</p><br>
                <p>Our updated menu features the classics, and a few of our own favorites.</p>
                <button id="menu-btn">Download Menu</button><br>
                <p><strong>Take-aways & Delivery</strong></p>
                <p>We’re proud to announce the addition of a take away and home delivery service.</p>
                <p>Now you can get a quick bite to eat, or get your favorites delivered straight to your door.</p>
                <p>We are also available on Mr Delivery to order from the convenience of your home. We’re always finding new</p>
                <p>ways to make it easier for our customers to experience our baked goods and cooking.</p><br>
            </div>
        </div>
    </section>
    <section class="service">
        <h1 class="h-primary center" style="margin-top:30px;text-align:center;">
            Meet Our Team
        </h1>
    <div id="services" align="center">
            <div class="box">
                <img src="assets/our_team/mrs_patt.webp" alt="ceo picture" width="500" height="400"> <br>
              
                <p class="center">
                    <a href="#xyz" style="text-decoration:none;color:black;
        font-weight:bold;font-family: 'Langar', cursive;">
                        Mrs Patricia Sebatane
                    </a>
                </p>
                <p style="font-family: sans-serif">CEO and the Founder</p>
            </div>
            <div class="box">
               <img src="assets/our_team/coFounder.jpg" alt="founder picture" width="500" height="400"> <br>
                  
                <p class="center">
                    <a href="#abc" style="text-decoration:none;color:black;
        font-weight:bold;font-family: 'Langar', cursive;">
                        Mr Avir Fripp
                    </a>
                </p>
                  
                <p style="font-family: sans-serif ">co-founder</p>
                <p style="font-family: sans-serif ">info@pattybakery.co.za</p>
            </div>
            <div class="box">
                <img src="assets/our_team/foodMANAGER.jfif" alt="food manager picture" width="500" height="400"> <br>
                <br>
                <p class="center">
                    <a href="#xyz" style="text-decoration:none;color:black;
           font-weight:bold;font-family: 'Langar', cursive;">
                        Ms Sky Walker
                    </a>
                </p>
                <p style="font-family: sans-serif ">Patty's Bakery Food Manager </p>
  
            </div>
        </div>
      
    </section> 
    <footer class="background">
    </footer>
</body>
  
</html>
