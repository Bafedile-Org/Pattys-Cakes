<%-- 
    Document   : cakes_page
    Created on : 03 Nov 2022, 9:16:31 AM
    Author     : Hlawulani
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cakes page</title>
        <link rel='stylesheet' href='css/style.css'>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Pacifico">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" integrity="sha512-9usAa10IRO0HhonpyAIVpjrylPvoDwiPUiKdWk5t3PyolY1cOd4DSE0Ga+ri4AuTroPR5aQvXU9xC6qOPnzFeg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
      
    </head>
    <body class="home-body1">
        <header class="home-head" align="center">
            <nav>
                <div class="topnav">
                    <h1>
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
            <pre align="center"><h1>Cakes</h1></pre>

        </h1>
         <div class="images-container">
            <div class="cookies_img" >

                <div align='center'>
                    <label id='cookie_label'><strong><%
                String name = (String) request.getAttribute("1PROName");
                out.println(name);
                    %>
                </strong>
            </label><br>
                <img src='assets/cakes/1PRO-cake-5.jpg'>
                </div>
                <div>
                <article>
                    <ul>
                    <li id="img_list"><strong> Ingredients: </strong>
                    <ul>
                        <%
                            List<String> ingredients = (List<String>) request.getAttribute("1PRO");
                            for (String ingredient : ingredients) {
                            List<String> caramelIngr = (List<String>) request.getAttribute("caramel");
                            for (String ingredient : caramelIngr) {
                                out.println(String.format("<li>%s</li>", ingredient));
                            }
                        %>
                    </ul>
                    </li>
                    <li id="img_list"><strong> Nutrients:</strong>
                    <ul>
                        <%
                            String Nutrients = (String) request.getAttribute("1PRONu");
                            out.println(String.format("<li>%s</li>", Nutrients));
                        %>
                    </ul>
                    </li>
                    </ul>
                </article>
                    
            </div>
             </div>
            <div id='img_price'>
                <button id='price_button'><%
                    Double price = (Double) request.getAttribute("1PROPrice");
                    Double price = (Double) request.getAttribute("caramelPrice");
                    out.println("R" + price);
                    %>
                </button>
                <button id="cart_button">add to cart</button>
            </div>
         </div><br><br>
           
        <div class="images-container">
            <div class="cookies_img" >

                <div align='center'>
                    <label id='cookie_label'><strong><%
                name = (String) request.getAttribute("2PROName");
                out.println(name);
                    %>
                </strong>
            </label><br>
           
                <img src='assets/cakes/Meringue-Cake.jpg'>
                </div>
                <div>
                <article>
                    <ul>
                    <li id="img_list"><strong> Ingredients: </strong>
                    <ul>
                        <%
                          ingredients = (List<String>) request.getAttribute("2PRO");
                            for (String ingredient : ingredients) {
                            List<String> margueIngr = (List<String>) request.getAttribute("margue");
                            for (String ingredient : margueIngr) {
                                out.println(String.format("<li>%s</li>", ingredient));
                            }
                        %>
                    </ul>
                    </li>
                    <li id="img_list"><strong> Nutrients:</strong>
                    <ul>
                        <%
                           List<String> nutrients = (List<String>) request.getAttribute("2PRONu");
                            out.println(String.format("<li>%s</li>", nutrients));
                        %>
                    </ul>
                    </li>
                    </ul>
                </article>
            </div>
            </div>
             <div id='img_price'>
                <button id='price_button'><%
                    price = (Double) request.getAttribute("2PROPrice");
                    price = (Double) request.getAttribute("marguePrice");
                    out.println("R" + price);
                    %>
                </button>
                <button id="b1">add to cart</button>
            </div>
          
         
        </div>
          <div class="images-container">
            <div class="cookies_img" >

                <div align='center'>
                    <label id='cookie_label'>
                <strong><%
                name = (String) request.getAttribute("3PROName");
                out.println(name);
                    %>
                </strong>
            </label><br>
                <img src='assets/cakes/cakes_pic.jpg'>
                </div>
                <div>
                <article>
                    <ul>
                    <li id="img_list"><strong> Ingredients: </strong>
                    <ul>
                        <%
                             ingredients = (List<String>) request.getAttribute("3PRO");
                                for (String ingredient : ingredients) {
                            List<String> chocolateIngr = (List<String>) request.getAttribute("chocolate");
                            for (String ingredient : chocolateIngr) {
                                out.println(String.format("<li>%s</li>", ingredient));
                            }
                        %>
                    </ul>
                    </li>
                    <li id="img_list"><strong> Nutrients:</strong>
                    <ul>
                        <%
                           nutrients = (List<String>) request.getAttribute("3PRONu");
                            for (String nutrient : nutrients) {
                            out.println(String.format("<li>%s</li>", nutrient));
                            }
                        %>
                    </ul>
                    </li>
                    </ul>
                </article>
            </div>
           <div id='img_price'>
                <button id='price_button'><%
                    price = (Double) request.getAttribute("3PROPrice");
                    price = (Double) request.getAttribute("chocolatePrice");
                    out.println("R" + price);
                    %>
                </button>
                <button id="b1">add to cart</button>
            </div>
            
        </div>
    </body>
</html>
