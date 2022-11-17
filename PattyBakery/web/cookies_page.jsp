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
        <script src="js/main.js"></script>
    </head>
    <body>
        <header>
            <nav>
                <div class="topnav" >
                    <h1>
                        <a href="home"> Patty's Bakery </a>
                        <a href='?cart=cart' name="cart">
                            <i class="fa fa-shopping-cart" style="font-size:24px;">
                                <%
                                    out.println((Integer) request.getAttribute("totalInCart"));
                                %>
                            </i>
                        </a>
                    </h1>

                </div>
            </nav>
        </header>
        <h1 align="center">
            <a align="left" href="home" style="color:black;width:5%;float:left">
                <i class="fa fa-arrow-left" aria-hidden="true" style="">
                </i>
            </a>
            <pre align="center"><h1>Cookies</h1></pre>

        </h1>
        <div class="images-container">
            <div class="cookies_img" >

                <div align='center'>
                    <label id='cookie_label'><strong><%
                        String name = (String) request.getAttribute("4PROName");
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
                                        List<String> ingredients = (List<String>) request.getAttribute("4PRO");
                                        if (ingredients != null) {
                                            for (String ingredient : ingredients) {
                                                out.println(String.format("<li>%s</li>", ingredient));
                                            }
                                        }
                                    %>
                                </ul>
                            </li>
                            <li  id='img_list'><strong>Nutrients</strong>
                                <ul>
                                    <%
                                        List<String> nutrients = (List<String>) request.getAttribute("4PRONu");
                                        for (String nutrient : nutrients) {
                                            out.println(String.format("<li>%s</li>", nutrient));
                                        }
                                    %>
                                </ul>
                            </li>
                        </ul>
                    </article>
                </div>

            </div>
            <div id='img_price'>
                <form method="POST" action="cookies_control">
                    <button id='price_button'><%
                        Double price = (Double) request.getAttribute("4PROPrice");
                        out.println("R" + price);
                        %>
                    </button>

                    <button id='cart_button' type="submit" name="add" value="4PRO">add to cart</button>

                </form>
            </div>

        </div><br><br>
        <div class="images-container">
            <div class="cookies_img" >

                <div align='center'>
                    <label id='cookie_label'><strong><%
                        name = (String) request.getAttribute("6PROName");
                        out.println(name);
                            %></strong></label>
                    <br>
                    <img src="assets/cookies/cokkies_pic2.jpg" alt="cookies" >
                </div>
                <div>
                    <article>
                        <ul>
                            <li  id='img_list'><strong>Ingredients</strong>
                                <ul>
                                    <%
                                        ingredients = (List<String>) request.getAttribute("6PRO");
                                        if (ingredients != null) {
                                            for (String ingredient : ingredients) {
                                                out.println(String.format("<li>%s</li>", ingredient));
                                            }
                                        }
                                    %>
                                </ul>
                            </li>
                            <li  id='img_list'><strong>Nutrients</strong>
                                <ul>
                                    <%
                                        nutrients = (List<String>) request.getAttribute("6PRONu");
                                        for (String nutrient : nutrients) {
                                            out.println(String.format("<li>%s</li>", nutrient));
                                        }
                                    %>
                                </ul>
                            </li>
                        </ul>
                    </article>
                </div>

            </div>
            <div id='img_price'>
                <form method="POST" action="cookies_control">
                    <button id='price_button'><%
                        price = (Double) request.getAttribute("6PROPrice");
                        out.println("R" + price);
                        %></button>

                    <button id='cart_button' type="submit" name="add" value="6PRO">add to cart</button>

                </form>
            </div>
        </div><br>
        <div class="images-container">
            <div class="cookies_img" >

                <div align='center'>
                    <label id='cookie_label'><strong><%
                        name = (String) request.getAttribute("5PROName");
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
                                        ingredients = (List<String>) request.getAttribute("5PRO");
                                        if (ingredients != null) {
                                            for (String ingredient : ingredients) {
                                                out.println(String.format("<li>%s</li>", ingredient));
                                            }
                                        }
                                    %>
                                </ul>
                            </li>
                            <li  id='img_list'><strong>Nutrients</strong>
                                <ul>
                                    <%
                                        nutrients = (List<String>) request.getAttribute("5PRONu");
                                        for (String nutrient : nutrients) {
                                            out.println(String.format("<li>%s</li>", nutrient));
                                        }
                                    %>
                                </ul>
                            </li>
                        </ul>
                    </article>
                </div>

            </div>
            <div id='img_price'>
                <form method="POST" action="cookies_control">
                    <button id='price_button'><%
                        price = (Double) request.getAttribute("5PROPrice");
                        out.println("R" + price);
                        %></button>
                    <button id='cart_button' type="submit" name="add" value="5PRO">add to cart</button>
                </form>
            </div>
        </div>
    </body>
</html>
