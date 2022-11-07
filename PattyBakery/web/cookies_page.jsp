<%-- 
    Document   : cookies_page
    Created on : 03 Nov 2022, 9:16:29 AM
    Author     : Dimakatso Sebatane
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cookies Page</title>
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Pacifico">

    </head>
    <body>
        <header>
            <nav>
                <div class="topnav" >
                     <h1>
                        <a href="home"> Patty's Bakery   
                            <i class="fa fa-shopping-cart" style="font-size:24px">0</i></a>
                    </h1>
                </div>
            </nav>
        </header>

        <h1 align='center'>Cookies</h1>
            <div id="label_div">
                <label><strong>Vanilla Cookies</strong></label>
                <div class="parent">
                    <img src="assets/cookies/cookies_p.jpg">
                    <article>
                        <p id='img_list'><strong>Ingredients</strong>
                            <ul>
                                <li>All-purpose flour</li>
                                <li>Chocolate chips</li>
                                <li>Dried cranberries</li>
                                <li>Butter</li>
                                <li>Egg</li>
                                </ul>
                            
                            <p  id='img_list'><strong>Nutrients</strong>
                                <ul>
                                    <li>Fat 9.8g</li>
                                    <li>Protein 2.9g</li>
                                </ul>
                    </article>
            </div>
            <div id='img_price'>
                <button id='b'>R75.99</button>
                <button id='b1'>add to cart</button>
            </div>
            <div >
                <i class="fa fa-exclamation-triangle">contains vanilla full cream</i>
            </div>
</div>

                    <div id="label_div">
                        <label><strong>Plain Coffee Cookies</strong></label>
                     <div class="parent">
                    <img src="assets/cookies/cokkies_pic2.jpg">
                    <article>
                        <p  id='img_list'><strong>Ingredients:</strong>
                                <ul>
                                    <li>All-purpose flour</li>
                                    <li>Chocolate chips</li>
                                    <li>Butter</li>
                                    <li>Egg</li>
                                </ul>
                            <p  id='img_list'><strong>Nutrients</strong>
                                <ul>
                                    <li>Fat 5.8g</li>
                                    <li>Protein 1.2g</li>
                                </ul>
                            
                    </article>
                </div>
               

            </div>
            <div class='price'>
                <button id='b'>R32.49</button>
                <button id='b1'>add to cart</button>
            </div>
            <div >
                <i class="fa fa-exclamation-triangle">contains nuts</i>
            </div>

        </div>
        <div id="label_div">
            <label><strong>Chocolate Cookie</strong></label>
                <div class="parent" >
                    <img src="assets/cookies/cookies_pic1.jpg">
                        <article>
                            <p  id='img_list'><strong>Ingredients</strong>
                                <ul>
                                    <li>All-purpose flour</li>
                                    <li>Chocolate chips</li>
                                    <li>Butter</li>
                                    <li>Egg</li>
                                </ul>
                            <p  id='img_list'><strong>Nutrients</strong>
                                <ul>
                                    <li>Fat 5.8g</li>
                                    <li>Protein 1.2g</li>
                                </ul>
                    </article>
                </div>
            <div class='img_price'>
                <button id='b'>R32.49</button>
                <button id='b1'>add to cart</button>
            </div>
            <div class='bottom' >
                <i class="fa fa-exclamation-triangle">contains nuts</i>
            </div>
        </div>
    </body>
</html>
