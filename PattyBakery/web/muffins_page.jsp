<%-- 
    Document   : Muffins
    Created on : Nov 3, 2022, 3:35:22 PM
    Author     : Bridget Bapela
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/styles.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Muffins Page</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Pacifico">

    </head>
    <body>
        <header>
            <nav>
                <div class="topnav" >
                    <h1 align="center">
                        <a href="home" > Patty's Bakery   
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
            <pre align="center"><h1>Muffins/<a href="cupcakes_control">Cupcakes</a></h1></pre>
        </h1>

        <div class="cupcakes_img" style="margin-left:2%;">

            <div class="cupcakes">

                <label style="margin-left: 25%;
                       font-size: 25px;
                       border-style: solid;">
                    <strong>
                        <%
                            String name = (String) request.getAttribute("blueberryName");
                            out.println(name);
                        %>
                    </strong>
                </label><br>
                <img  id="cup_img" src="assets/muffins/Blueberry-Muffins.jpg" alt="muffins" width="500" height="400"> <br> 
            </div>
            <div>
                <ul style="margin-top:20%;">
                     <p><strong>Ingredients</strong></p><ul>
                        <%
                            List<String> ingredients = (List<String>) request.getAttribute("blueberry");
                            for (String ingredient : ingredients) {
                                out.println(String.format("<li>%s</li>", ingredient));
                            }
                        %>
                    </ul>
                    <p><strong>Nutrients</strong></p><ul>
                        <%
                            String nutrients = (String) request.getAttribute("blueberryNu");
                            out.println(String.format("<li>%s</li>", nutrients));
                        %>
                    </ul>

                </ul>
            </div>  
            <div class="cont">  
                <button id="price-button" ><%
                    Double price = (Double) request.getAttribute("blueberryPrice");
                    out.println("R" + price);
                    %></button>  
                <button id="add-to-cart-button"> Add to cart</button>  
            </div>
        </div>
         <div class="cupcakes_img" style="margin-left:2%;">

            <div class="cupcakes">

                <label style="margin-left: 25%;

                       font-size: 25px;
                       border-style: solid">
                    <strong><%
                        name = (String) request.getAttribute("carrotName");
                        out.println(name);
                        %></strong>
                </label><br>
                <img id="cup_img" src="assets/muffins/carrot-muffins.jpg" alt="muffins" width="500" height="400"> <br> 
            </div>
            <div>
               <ul style="margin-top:25%;">
                     <p><strong>Ingredients</strong></p>
                         
                         <ul>
                        <%
                            ingredients = (List<String>) request.getAttribute("cranberry");
                            for (String ingredient : ingredients) {
                                out.println(String.format("<li>%s</li>", ingredient));
                            }
                        %>
                    </ul>
                     <p><strong>Nutrients</strong></p>
                     <ul>
                        <%
                            nutrients = (String) request.getAttribute("cranberryNu");
                            out.println(String.format("<li>%s</li>", nutrients));
                        %>
                    </ul>

                </ul>
            </div>  
            <div class="cont">  
                <button id="price-button" ><%
                    price = (Double) request.getAttribute("cranberryPrice");
                    out.println("R" + price);
                    %></button>  
                <button id="add-to-cart-button"> Add to cart</button>  
            </div>
        </div>
         <div class="cupcakes_img" style="margin-left:2%;">

            <div class="cupcakes">

                <label style="margin-left: 25%;

                       font-size: 25px;
                       border-style: solid">
                    <strong><%
                        name = (String) request.getAttribute("cranberryName");
                        out.println(name);
                        %></strong>
                </label><br>
                <img id="cup_img" src="assets/muffins/Cranberry-Muffins.jpg" alt="muffins" width="500" height="400"> <br> 
            </div>
            <div>
               <ul style="margin-top:25%;">
                   <p><strong>Ingredients</strong></p></li><ul>
                        <%
                            ingredients = (List<String>) request.getAttribute("carrot");
                            for (String ingredient : ingredients) {
                                out.println(String.format("<li>%s</li>", ingredient));
                            }
                        %>
                    </ul>
                    <p><strong>Nutrients</strong></p><ul>
                        <%
                            nutrients = (String) request.getAttribute("carrotNu");
                            out.println(String.format("<li>%s</li>", nutrients));
                        %>
                    </ul>

                </ul>
            </div>  
            <div class="cont">  
                <button id="price-button" ><%
                    price = (Double) request.getAttribute("carrotPrice");
                    out.println("R" + price);
                    %></button>  
                <button id="add-to-cart-button"> Add to cart</button>  
            </div>
        </div>

    </body>
</html>
