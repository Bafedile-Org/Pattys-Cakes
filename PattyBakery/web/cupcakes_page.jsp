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
        <title>Cupcakes Page</title>
        <link rel = "stylesheet" href="css/styles.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Pacifico">
    </head>
    <body>
        <header>
            <nav>
                <div class="topnav" >
                    <h1 align="center">
                        <a href="home"> Patty's Bakery   
                            <i class="fa fa-shopping-cart" style="font-size:24px"><%
                                out.println((Integer)request.getAttribute("totalInCart"));
                                %></i></a>
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

        <div class="cupcakes_img" style="margin-left:2%;">

            <div class="cupcakes">

                <label style="margin-left: 25%;
                       font-size: 25px;
                       border-style: solid;margin-top:10%">
                    <strong><%
                        String name = (String) request.getAttribute("walnutName");
                        out.println(name);
                        %></strong>
                </label><br>
                <img id="cup_img" src="assets/cupcakes/coffeecupcake.jfif" alt="cookies" width="500" height="400"> <br> 
            </div>
            <div id="cup_ingr">
                <ul style="margin-top:20%;">
                     <p><strong>Ingredients</strong></p><ul>
                        <%
                            List<String> ingredients = (List<String>) request.getAttribute("walnut");
                            if(ingredients!=null){
                            for (String ingredient : ingredients) {
                                out.println(String.format("<li>%s</li>", ingredient));
                            }
                            }
                        %>
                    </ul>
                    <p><strong>Nutrients</strong></p><ul>
                        <%
                            String nutrients = (String) request.getAttribute("walnutNu");
                            out.println(String.format("<li>%s</li>", nutrients));
                        %>
                    </ul>

                </ul>
            </div>  
            <div class="cont">  
                <form method="GET" action="cupcakes_control">
                <button id="price-button"><%
                    Double price = (Double) request.getAttribute("walnutPrice");
                    out.println("R" + price);
                    %></button>  
                <button id="add-to-cart-button" onclick="CupcakesControl()" name="add" value="walnut"> Add to cart</button>  
            
                </form>
            </div>
        </div>
        <div class="cupcakes_img" style="margin-left:2%;">

            <div class="cupcakes">

                 <label style="margin-left: 15%;
                       font-size: 25px;
                       border-style: solid;margin-top:10%">
                    <strong><%
                        name = (String) request.getAttribute("chocolateName");
                        out.println(name);
                        %></strong>
                </label><br>
                <img id="cup_img" src="assets/cupcakes/glutten_free_chocolate_cupcakes.jpg" alt="cookies" width="500" height="400"> <br> 
            </div>
            <div>
                <ul style="margin-top:20%;">
                     <p><strong>Ingredients</strong></p><ul>
                        <%
                            ingredients = (List<String>) request.getAttribute("chocolate");
                            if(ingredients!=null){
                            for (String ingredient : ingredients) {
                                out.println(String.format("<li>%s</li>", ingredient));
                            }
                            }
                        %>
                    </ul>
                    <p><strong>Nutrients</strong></p><ul>
                        <%
                            nutrients = (String) request.getAttribute("chocolateNu");
                            out.println(String.format("<li>%s</li>", nutrients));
                        %>
                    </ul>

                </ul>
            </div>  
            <div class="cont"> 
                 <form method="GET" action="cupcakes_control">
                <button id="price-button"><%
                    price = (Double) request.getAttribute("chocolatePrice");
                    out.println("R" + price);
                    %></button>  
                <button id="add-to-cart-button" onclick="CupcakesControl()" name="add" value="chocolate"> Add to cart</button>  
                 </form>
            </div>
        </div>
       <div class="cupcakes_img" style="margin-left:2%;">

            <div class="cupcakes">

                 <label style="margin-left: 25%;
                       font-size: 25px;
                       border-style: solid;margin-top:10%">
                    <strong><%
                        name = (String) request.getAttribute("vanilaName");
                        out.println(name);
                        %></strong>
                </label><br>
                <img id="cup_img" src="assets/cupcakes/IMG_3165.webp" alt="cookies" width="500" height="400"> <br> 
            </div>
            <div>
               <ul style="margin-top:20%;">
                     <p><strong>Ingredients</strong></p><ul>
                        <%
                            ingredients = (List<String>) request.getAttribute("vanila");
                            if(ingredients!=null){
                            for (String ingredient : ingredients) {
                                out.println(String.format("<li>%s</li>", ingredient));
                            }
                            }
                        %>
                    </ul>
                     <p><strong>Nutrients</strong></p><ul>
                        <%
                            nutrients = (String) request.getAttribute("vanilaNu");
                            out.println(String.format("<li>%s</li>", nutrients));
                        %>
                    </ul>

                </ul>
            </div>  
            <div class="cont"> 
                 <form method="GET" action="cupcakes_control">
                <button id="price-button"><%
                    price = (Double) request.getAttribute("vanilaPrice");
                    out.println("R" + price);
                    %></button>  
                <button id="add-to-cart-button"  onclick="CupcakesControl()" name="add" value="vanila"> Add to cart</button>  
                 </form>
            </div>
        </div>

    </body>
</html>
