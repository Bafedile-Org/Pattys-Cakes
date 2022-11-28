<%-- 
    Document   : testPage
    Created on : Nov 21, 2022, 9:08:48 AM
    Author     : Bridget Bapela
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Slideshow</title>
    <style>
    body {
        font-family: Helvetica, sans-serif;
        padding: 5%;
        text-align: center;
        font-size: 50;
    }
     
    /* Styling the area of the slides */
     
    #slideshow {
        overflow: hidden;
        height: 510px;
        width: 728px;
        margin: 0 auto;
    }
     
    /* Style each of the sides
    with a fixed width and height */
     
    .slide {
        float: left;
        height: 510px;
        width: 728px;
    }
     
    /* Add animation to the slides */
     
    .slide-wrapper {
         
        /* Calculate the total width on the
      basis of number of slides */
        width: calc(728px * 6);
         
        /* Specify the animation with the
      duration and speed */
        animation: slide 10s ease infinite;
    }
     
    /* Set the background color
    of each of the slides */
     
    .slide:nth-child(1) {
        background-image:url("assets/cookies/cokkies_pic2.jpg");
        background-size: cover;
    }
     
    .slide:nth-child(2) {
        background-image:url("assets/cakes/rainbow_cake3.jpg");
        background-size: cover;
    }
     
    .slide:nth-child(3) {
        background-image:url("assets/doughnuts/dougnuts2.jpg");
        background-size: cover;
    }
     
    .slide:nth-child(4) {
        background-image:url("assets/personal_pies/blueberry pies.jpg");
        background-size: cover;
    }
    .slide:nth-child(5) {
        background-image:url("assets/cupcakes/coffeecupcake.jfif");
        background-size: cover;
    }
    .slide:nth-child(6) {
        background-image:url("assets/muffins/Cranberry-Muffins.jpg");
        background-size: cover;
    }
     
    /* Define the animation
    for the slideshow */
     
    @keyframes slide {
         
        /* Calculate the margin-left for
      each of the slides */
        0% {
            margin-left: 0px;
        }
        20% {
            margin-left: calc(-728px * 1);
        }
        40% {
            margin-left: calc(-728px * 2);
        }
        60% {
            margin-left: calc(-728px * 3);
        }
        80% {
            margin-left: calc(-728px * 4);
        }
        100% {
            margin-left: calc(-728px * 5);
        }
    }
    </style>
</head>
 
<body>
     
    <!-- Define the slideshow container -->
    <div id="slideshow">
        <div class="slide-wrapper">
             
            <!-- Define each of the slides
         and write the content -->
            <div class="slide">
                <h1 class="slide-number">
                    Cookies
                </h1>
            </div>
            <div class="slide">
                <h1 class="slide-number">
                    Cakes
                </h1>
            </div>
            <div class="slide">
                <h1 class="slide-number">
                    Doughnuts
                </h1>
            </div>
            <div class="slide">
                <h1 class="slide-number">
                    Pies
                </h1>
            </div>
            <div class="slide">
                <h1 class="slide-number">
                    Cupcakes
                </h1>
            </div>
            <div class="slide">
                <h1 class="slide-number">
                    Muffins
                </h1>
            </div>
        </div>
    </div>
</body>
</html>
