<%-- 
    Document   : cookies_page
    Created on : 03 Nov 2022, 9:16:29 AM
    Author     : Dimakatso Sebatane
--%>

<%@page import="java.util.List"%>
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
                            <i class="fa fa-shopping-cart" style="font-size:24px;">0</i></a>
                    </h1>

                </div>
            </nav>
        </header>
        <h1> 
            <a align="left" href="home" style="color:black">
                <i class="fa fa-arrow-left" aria-hidden="true">
                </i>
            </a>
            <pre align="center"><h1>Cookies</h1></pre>

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
        </h1>
        <div class="images-container">
            <div class="cookies_img" >

                <div align='center'>
                    <label id='cookie_label'><strong><%
                        String name = (String) request.getAttribute("vanilaName");
                        out.println(name);
                            %></strong></label>
                    <br>
                    <img src="assets/cookies/cookies_p.jpg" alt="cookies" >
                </div>
                <div>
                    <article>
                        <ul>
                            <li  id='img_list'><strong>Ingredients</strong>
                                <ul>
                                    <%
                                        List<String> vanilaIngr = (List<String>) request.getAttribute("vanila");
                                        for (String ingredient : vanilaIngr) {
                                            out.println(String.format("<li>%s</li>", ingredient));
                                        }
                                    %>
                                </ul>
                            
                            <p  id='img_list'><strong>Nutrients</strong>
                                <ul>
                                    <%
                                        String vanilaNutrients = (String) request.getAttribute("vanilaNu");
                                        out.println(String.format("<li>%s</li>", vanilaNutrients));
                                    %>
                                </ul>
                    </article>
            </div>
            <div id='img_price'>
                <button id='b'>R75.99</button>
                <button id='b1'>add to cart</button>
                <button id='price_button'><%
                    Double price = (Double) request.getAttribute("vanilaPrice");
                    out.println("R" + price);
                    %></button>
                <button id='cart_button'>add to cart</button>
            </div>
            <div >
                <i class="fa fa-exclamation-triangle">contains vanilla full cream</i>
            </div>
</div>

                    <div id="label_div">
                        <label><strong>Plain Coffee Cookies</strong></label>
                     <div class="parent">
                    <img src="assets/cookies/cokkies_pic2.jpg">
        </div><br><br>
        <div class="images-container">
            <div class="cookies_img" >

                <div align='center'>
                    <label id='cookie_label'><strong><%
                        name = (String) request.getAttribute("plainName");
                        out.println(name);
                            %></strong></label>
                    <br>
                    <img src="assets/cookies/cokkies_pic2.jpg" alt="cookies" >
                </div>
                <div>
                    <article>
                        <p  id='img_list'><strong>Ingredients:</strong>
                                <ul>
                                    <%
                                        List<String> plainIngr = (List<String>) request.getAttribute("plain");
                                        for (String ingredient : plainIngr) {
                                            out.println(String.format("<li>%s</li>", ingredient));
                                        }
                                    %>
                                </ul>
                            <p  id='img_list'><strong>Nutrients</strong>
                                <ul>
                                    <%
                                        String plainNutrients = (String) request.getAttribute("plainNu");
                                        out.println(String.format("<li>%s</li>", plainNutrients));
                                    %>
                                </ul>
                            
                    </article>
                </div>
               

            </div>
            <div class='price'>
                <button id='b'>R32.49</button>
                <button id='b1'>add to cart</button>
            <div id='img_price'>
                <button id='price_button'><%
                    price = (Double) request.getAttribute("plainPrice");
                    out.println("R" + price);
                    %></button>
                <button id='cart_button'>add to cart</button>
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
        <div class="images-container">
            <div class="cookies_img" >

                <div align='center'>
                    <label id='cookie_label'><strong><%
                        name = (String) request.getAttribute("chocolateName");
                        out.println(name);
                            %></strong></label>
                    <br>
                    <img src="assets/cookies/cookies_pic1.jpg" alt="cookies" >
                </div>
                <div>
                    <article>
                        <ul>
                            <li  id='img_list'><strong>Ingredients</strong>
                                <ul>
                                    <%
                                        List<String> chocolateIngr = (List<String>) request.getAttribute("chocolate");
                                        for (String ingredient : chocolateIngr) {
                                            out.println(String.format("<li>%s</li>", ingredient));
                                        }
                                    %>
                                </ul>
                            <p  id='img_list'><strong>Nutrients</strong>
                                <ul>
                                    <%
                                        String chocolateNutrients = (String) request.getAttribute("chocolateNu");
                                        out.println(String.format("<li>%s</li>", chocolateNutrients));
                                    %>
                                </ul>
                    </article>
                </div>
            <div class='img_price'>
                <button id='b'>R32.49</button>
                <button id='b1'>add to cart</button>
            </div>
            <div class='bottom' >
            <div id='img_price'>
                <button id='price_button'><%
                    price = (Double) request.getAttribute("chocolatePrice");
                    out.println("R" + price);
                    %></button>
                <button id='cart_button'>add to cart</button>
            </div>
            <div >
                <i class="fa fa-exclamation-triangle">contains nuts</i>
            </div>
        </div>
    </body>
</html>
