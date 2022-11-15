<%-- 
    Document   : cupcakes_page
    Created on : Nov 3, 2022, 9:16:34 AM
    Author     : Bridget Bapela
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cupcakes page</title>
        <link rel='stylesheet' href='css/style.css'>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Pacifico">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" integrity="sha512-9usAa10IRO0HhonpyAIVpjrylPvoDwiPUiKdWk5t3PyolY1cOd4DSE0Ga+ri4AuTroPR5aQvXU9xC6qOPnzFeg==" crossorigin="anonymous" referrerpolicy="no-referrer" />

    </head>
    <body>
        <header class="home-head">
            <nav>
                <div class="topnav" >
                    <h1 align="center">
                        <a href="home"> Patty's Bakery   
                            <i class="fa fa-shopping-cart" style="font-size:24px">0</i></a>
                    </h1>
                </div>
            </nav>
        </header>
        <h1> 
            <a align="left" href="home" style="color:black;width:5%;">
                <i class="fa fa-arrow-left" aria-hidden="true" style="float:left">
                </i>
            </a>
            <pre align="center"><h1>Cupcakes/<a href="muffins_control">Muffins</a></h1></pre>

        </h1>
        <div class="images-container">
            <div class="cookies_img" >

                <div align='center'>
                    <label id='cookie_label'>
                <strong><%
                    String name = (String) request.getAttribute("walnutName");
                    out.println(name);
                    %></strong>
            </label><br>
                <img src="assets/cupcakes/coffeecupcake.jfif">
                <article>
                <ul>
                    <li id="img_list"><strong>Ingredients</strong>
                    <ul>
                        <%
                            List<String> ingredients = (List<String>) request.getAttribute("walnut");
                            for (String ingredient : ingredients) {
                                out.println(String.format("<li>%s</li>", ingredient));
                            }
                        %>
                    </ul>
                </li>
                    <li id="img_list"><strong>Nutrients</strong>
                    <ul>
                        <%
                            //String nutrients = (String) request.getAttribute("walnutNu");
                            //.println(String.format("<li>%s</li>", nutrients));
                        %>
                    </ul>
                </li>
                </ul>
                </article>
            </div>
            </div>  
            <div id="img_price">  
                <button id="price-button"><%                    Double price = (Double) request.getAttribute("walnutPrice");
                    out.println("R" + price);
                    %></button>  
                <button id="cart_button_"> Add to cart</button>  
            </div>

        </div>
       <div class="images-container">
            <div class="cookies_img" >

                <div align='center'>
                    <label id='cookie_label'>
                <strong><%
                    name = (String) request.getAttribute("chocolateName");
                    out.println(name);
                    %></strong>
            </label><br>
           
                <img src="assets/cupcakes/glutten_free_chocolate_cupcakes.jpg" alt="cookies" > 
            </div>
                <article>
                    <ul>
                    <li id="img_list"><strong>Ingredients</strong>
                    <ul>
                        <%
                            ingredients = (List<String>) request.getAttribute("chocolate");
                            for (String ingredient : ingredients) {
                                out.println(String.format("<li>%s</li>", ingredient));
                            }
                        %>
                    </ul>
                    </li>
                    <li id="img_list"><strong>Nutrients</strong>
                        <ul>
                        <%
                            //nutrients = (String) request.getAttribute("chocolateNu");
                            //out.println(String.format("<li>%s</li>", nutrients));
                        %>
                    </ul>
                </li>
                </ul>
                </article>
            </div>
            </div>  
            <div id='img_price'>
                <button id='price_button'><%                    price = (Double) request.getAttribute("chocolatePrice");
                    out.println("R" + price);
                    %></button>  
                <button id='cart_button'>> Add to cart</button>  
            </div>
        </div>
     <div class="images-container">
            <div class="cookies_img" >

                <div align='center'>
                    <label id='cookie_label'>
            <strong><%
                name = (String) request.getAttribute("vanilaName");
                out.println(name);
                %></strong>
        </label><br>
        
            <img src="assets/cupcakes/IMG_3165.webp" alt="cookies"> <br> 
    </div>
            <article>
                <ul
                <li id="img_list"><strong>Ingredients</strong>
                <ul>
                    <%
                        ingredients = (List<String>) request.getAttribute("vanila");
                        for (String ingredient : ingredients) {
                            out.println(String.format("<li>%s</li>", ingredient));
                        }
                    %>
                </ul>
            </li>
                <li id="img_list"><strong>Nutrients</strong>
                <ul>
                    <%
                        //nutrients = (String) request.getAttribute("vanilaNu");
                        //out.println(String.format("<li>%s</li>", nutrients));
                    %>
                </ul>
            </li>
            </ul>
            </article>
        </div>
        </div>  
        <div id='img_price'>
                <button id='price_button'><%                    price = (Double) request.getAttribute("vanilaPrice");
                out.println("R" + price);
                %></button>  
            <button id="b1"> Add to cart</button>  
        </div>

    </div>

</body>
</html>
