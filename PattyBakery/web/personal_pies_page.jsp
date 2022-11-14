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
                String name = (String) request.getAttribute("blueberryName");
                out.println(name);
                    %>
                </label></strong>
            <br>
                <img src='assets/personal_pies/blueberry pies.jpg'>
                </div>
                <div>
                <article>
                    <ul>
                    <li id="img_list"><strong>Ingredients:</strong>
                    <ul>
                        <%
                            List<String> blueberryIngr = (List<String>) request.getAttribute("blueberry");
                            for (String ingredient : blueberryIngr) {
                                out.println(String.format("<li>%s</li>", ingredient));
                            }
                        %>
                    </ul>
                    </li>
                    <li id="img_list"><strong>Nutrients:</strong>
                    <ul>
                         <%
                            String nutrients = (String) request.getAttribute("blueberryNu");
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
                    Double price = (Double) request.getAttribute("blueberryPrice");
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
                name = (String) request.getAttribute("appleName");
                out.println(name);
                    %>
                </strong>
            </label><br>
                <img src='assets/personal_pies/apple_pie.jpg'>
                </div>
                <div>
                <article>
                    <ul>
                    <li id="img_list"><strong>Ingredients:</strong>
                    <ul>
                        <%
                            List<String> appleIngr = (List<String>) request.getAttribute("apple");
                            for (String ingredient : appleIngr) {
                                out.println(String.format("<li>%s</li>", ingredient));
                            }
                        %>
                    </ul>
                    </li>
                    <li id="img_list"><strong>Nutrients:</strong>
                    <ul>
                        <%
                            nutrients = (String) request.getAttribute("appleNu");
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
                     price = (Double) request.getAttribute("applePrice");
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
                 name = (String) request.getAttribute("strawberryName");
                out.println(name);
                    %>
                </strong>
            </label><br>
                <img src='assets/personal_pies/strawberry pie.jpg'>
        </div>
                <div>
                <article>
                    <ul>
                    <li id="img_list"><strong>Ingredients:</strong>
                    <ul>
                         <%
                            List<String> strawberryIngr = (List<String>) request.getAttribute("strawberry");
                            for (String ingredient : strawberryIngr) {
                                out.println(String.format("<li>%s</li>", ingredient));
                            }
                        %>
                    </ul>
                    </li>
                    <li id="img_list"><strong>Nutrients:</strong>
                    <ul>
                        <%
                            nutrients = (String) request.getAttribute("strawberryNu");
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
                     price = (Double) request.getAttribute("strawberryPrice");
                    out.println("R" + price);
                    %>
                </button>
                <button id=cart_button">add to cart</button>
            </div>
            </div>

    </body>
</html>
