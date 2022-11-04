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
                        Patty's Bakery   
                        <i class="fa fa-shopping-cart" style="font-size:24px">0</i>
                    </h1>
                </div>
            </nav>
        </header>

        <h1 align='center'>Cookies</h1>

        <div class="images-container">
            <div class="cookies_img" >

                <div align='center'>
                    <label id='cookie_label'><strong>Vanilla Cookies</strong></label>
                    <br>
                    <img src="assets/cookies/cookies_p.jpg" alt="cookies" >
                </div>
                <div>
                    <article>
                        <ul>
                            <li  id='img_list'><strong>Ingredients</strong>
                                <ul>
                                    <li>All-purpose flour</li>
                                    <li>Chocolate chips</li>
                                    <li>Dried cranberries</li>
                                    <li>Butter</li>
                                    <li>Egg</li>
                                </ul>
                            </li>
                            <li  id='img_list'><strong>Nutrients</strong>
                                <ul>
                                    <li>Fat 9.8g</li>
                                    <li>Protein 2.9g</li>
                                </ul>
                            </li>
                        </ul>
                    </article>
                </div>

            </div>
            <div id='img_price'>
                <button id='price_button'>R75.99</button>
                <button id='cart_button'>add to cart</button>
            </div>
            <div >
                <i class="fa fa-exclamation-triangle">contains vanilla full cream</i>
            </div>

        </div><br><br>
        <div class="images-container">
            <div class="cookies_img" >

                <div align='center'>
                    <label id='cookie_label'><strong>Plain Coffee Cookies</strong></label>
                    <br>
                    <img src="assets/cookies/cokkies_pic2.jpg" alt="cookies" >
                </div>
                <div>
                    <article>
                        <ul>
                            <li  id='img_list'><strong>Ingredients</strong>
                                <ul>
                                    <li>All-purpose flour</li>
                                    <li>Chocolate chips</li>
                                    <li>Butter</li>
                                    <li>Egg</li>
                                </ul>
                            </li>
                            <li  id='img_list'><strong>Nutrients</strong>
                                <ul>
                                    <li>Fat 5.8g</li>
                                    <li>Protein 1.2g</li>
                                </ul>
                            </li>
                        </ul>
                    </article>
                </div>

            </div>
            <div id='img_price'>
                <button id='price_button'>R32.49</button>
                <button id='cart_button'>add to cart</button>
            </div>
            <div >
                <i class="fa fa-exclamation-triangle">contains nuts</i>
            </div>

        </div>
        <div class="images-container">
            <div class="cookies_img" >

                <div align='center'>
                    <label id='cookie_label'><strong>Chocolate Cookie</strong></label>
                    <br>
                    <img src="assets/cookies/cookies_pic1.jpg" alt="cookies" >
                </div>
                <div>
                    <article>
                        <ul>
                            <li  id='img_list'><strong>Ingredients</strong>
                                <ul>
                                    <li>All-purpose flour</li>
                                    <li>Chocolate chips</li>
                                    <li>Butter</li>
                                    <li>Egg</li>
                                </ul>
                            </li>
                            <li  id='img_list'><strong>Nutrients</strong>
                                <ul>
                                    <li>Fat 5.8g</li>
                                    <li>Protein 1.2g</li>
                                </ul>
                            </li>
                        </ul>
                    </article>
                </div>

            </div>
            <div id='img_price'>
                <button id='price_button'>R32.49</button>
                <button id='cart_button'>add to cart</button>
            </div>
            <div >
                <i class="fa fa-exclamation-triangle">contains nuts</i>
            </div>
        </div>
    </body>
</html>
