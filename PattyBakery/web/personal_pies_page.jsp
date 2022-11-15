<%-- 
    Document   : personal_pies_page
    Created on : 03 Nov 2022, 2:52:10 PM
    Author     : Hlawulani
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Personal pies</title>
        <link rel='stylesheet' href='css/style.css'>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Pacifico">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" integrity="sha512-9usAa10IRO0HhonpyAIVpjrylPvoDwiPUiKdWk5t3PyolY1cOd4DSE0Ga+ri4AuTroPR5aQvXU9xC6qOPnzFeg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    </head>
     <body class="home-body1">
          <header class="home-head">
            <nav>
                <div class="topnav" align="center">
                    <h1>
                        <a href="home"> Patty's Bakery   
                            <i class="fa fa-shopping-cart" style="font-size:24px">0</i></a>
                    </h1>
                </div>
            </nav>
        </header>
        <h1> 
            <a align="left" href="home" style="color:black; width: 5%;">
                <i class="fa fa-arrow-left" aria-hidden="true" style="float:left">
                </i>
            </a>
            <pre align="center"><h1>Personal Pies</h1></pre>

        </h1>
        <div class="images-container">
            <div class="cookies_img">
                <div align="center">
             <label id="cookie_label"><strong><%
                String name = (String) request.getAttribute("10PROName");
                out.println(name);
                    %>
                </label></strong>
            <br>
                <img src='assets/personal_pies/10PRO pies.jpg'>
                </div>
                <div>
                <article>
                    <ul>
                    <li id="img_list"><strong>Ingredients:</strong>
                    <ul>
                        <%
<<<<<<< HEAD
                            List<String> ingredients = (List<String>) request.getAttribute("10PRO");
                            for (String ingredient : ingredients) {
=======
                            List<String> blueberryIngr = (List<String>) request.getAttribute("blueberry");
                            for (String ingredient : blueberryIngr) {
>>>>>>> Deekay-dev
                                out.println(String.format("<li>%s</li>", ingredient));
                            }
                        %>
                    </ul>
                    </li>
                    <li id="img_list"><strong>Nutrients:</strong>
                    <ul>
                         <%
                            List<String> nutrients = (List<String>) request.getAttribute("10PRONu");
                            out.println(String.format("<li>%s</li>", nutrients));
                        %>
                    </ul>
                    </li>
                    </ul>
                </article>
            </div>
            </div>
            <div id="img_price">
                <button id="price-button"><%
<<<<<<< HEAD
                    Double price = (Double) request.getAttribute("10PROPrice");
=======
                    Double price = (Double) request.getAttribute("blueberryPrice");
>>>>>>> Deekay-dev
                    out.println("R" + price);
                    %>
                </button>
                <button id="cart_button_">add to cart</button>
            </div>

        </div><br><br>

        <div class="images-container">
            <div class="cookies_img">
                <div align="center">
             <label id="cookie_label"><strong><%
<<<<<<< HEAD
                name = (String) request.getAttribute("11PROName");
=======
                name = (String) request.getAttribute("appleName");
>>>>>>> Deekay-dev
                out.println(name);
                    %>
                </strong>
            </label><br>
                <img src='assets/personal_pies/11PRO_pie.jpg'>
                </div>
                <div>
                <article>
                    <ul>
                    <li id="img_list"><strong>Ingredients:</strong>
                    <ul>
                        <%
<<<<<<< HEAD
                            ingredients = (List<String>) request.getAttribute("11PRO");
                            for (String ingredient : ingredients) {
=======
                            List<String> appleIngr = (List<String>) request.getAttribute("apple");
                            for (String ingredient : appleIngr) {
>>>>>>> Deekay-dev
                                out.println(String.format("<li>%s</li>", ingredient));
                            }
                        %>
                    </ul>
                    </li>
                    <li id="img_list"><strong>Nutrients:</strong>
                    <ul>
                        <%
                            nutrients = (List<String>)  request.getAttribute("11PRONu");
                            out.println(String.format("<li>%s</li>", nutrients));
                        %>
                    </ul>
                    </li>
                    </ul>
                </article>
            </div>
            </div>
            <div id="img_price">
                <button id="price_button"><%
<<<<<<< HEAD
                     price = (Double) request.getAttribute("11PROPrice");
=======
                     price = (Double) request.getAttribute("applePrice");
>>>>>>> Deekay-dev
                    out.println("R" + price);
                    %>
                </button>
                <button id="cart_button">add to cart</button>
            </div>
</div>
        <div class="images-container">
        <div class="cookies_img">       
        <div align="center">
             <label id="cookie_label"><strong><%
<<<<<<< HEAD
                 name = (String) request.getAttribute("12PROName");
=======
                 name = (String) request.getAttribute("strawberryName");
>>>>>>> Deekay-dev
                out.println(name);
                    %>
                </strong>
            </label><br>
                <img src='assets/personal_pies/12PRO pie.jpg'>
        </div>
                <div>
                <article>
                    <ul>
                    <li id="img_list"><strong>Ingredients:</strong>
                    <ul>
                         <%
<<<<<<< HEAD
                            ingredients = (List<String>) request.getAttribute("12PRO");
                            for (String ingredient : ingredients) {
=======
                            List<String> strawberryIngr = (List<String>) request.getAttribute("strawberry");
                            for (String ingredient : strawberryIngr) {
>>>>>>> Deekay-dev
                                out.println(String.format("<li>%s</li>", ingredient));
                            }
                        %>
                    </ul>
                    </li>
                    <li id="img_list"><strong>Nutrients:</strong>
                    <ul>
                        <%
                            nutrients = (List<String>) request.getAttribute("12PRONu");
                            out.println(String.format("<li>%s</li>", nutrients));
                        %>
                    </ul>
                    </li>
                    </ul>
                </article>
            </div>
        </div>
            <div id="img_price">
                <button id="price-button"><%
<<<<<<< HEAD
                     price = (Double) request.getAttribute("12PROPrice");
=======
                     price = (Double) request.getAttribute("strawberryPrice");
>>>>>>> Deekay-dev
                    out.println("R" + price);
                    %>
                </button>
                <button id=cart_button">add to cart</button>
            </div>
            </div>

    </body>
</html>
