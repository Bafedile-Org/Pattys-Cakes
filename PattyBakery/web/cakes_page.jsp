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
    <body>
        <header>
            <nav>
                <div class="topnav">
                    <h1>
                        <a href="home"> Patty's Bakery   
                            <i class="fa fa-shopping-cart" style="font-size:24px">0</i></a>
                    </h1>
                </div>
                <div class="topnav">
                </div>
            </nav>
        </header>
        <h1 align='center'> Cakes</h1>
        <div id="label_div">
            <label id='cookie_label'><strong><%
                String name = (String) request.getAttribute("carameName");
                out.println(name);
                    %></strong></label><br>
            <div class="parent">
                <img src='assets/cakes/caramel-cake-5.jpg'>
                <article>
                    <p id="img_list"><strong> Ingredients: </strong>
                    <ul>
                        <%
                            List<String> caramelIngr = (List<String>) request.getAttribute("caramel");
                            for (String ingredient : caramelIngr) {
                                out.println(String.format("<li>%s</li>", ingredient));
                            }
                        %>
                    </ul>
                    <p id="img_list"><strong> Nutrients:</strong>
                    <ul>
                        <%
                            String caramelNutrients = (String) request.getAttribute("caramelNu");
                            out.println(String.format("<li>%s</li>", caramelNutrients));
                        %>
                    </ul>
                </article>
            </div>
            <div class="price">
                <button id="b">R256.50</button>
                <button id="b1">add to cart</button>
            </div>
            <p> </p>
            <div class="botom">
                <p><i class="fa-solid fa-triangle-exclamation"></i> Contains a lot of dairy </p>
            </div></div>
        <div id="label_div">
            <label><strong> Meringue Cake</strong></label><br>
            <div class="parent">
                <img src='assets/cakes/Meringue-Cake.jpg'>
                <article>
                    <p id="img_list"><strong> Ingredients: </strong>
                    <ul>
                        <li>Egg whites</li>
                        <li>Teaspoon cream of tartar</li>
                        <li>Cup white sugar</li>
                        <li>Suger</li>
                        <li>Flour</li>
                        <li>Fat</li>
                        <li>Baking powder</li>
                        <li>Flavoring ingredients</li>
                        <li>Emulsifier</li>
                    </ul>
                    <p id="img_list"><strong> Nutrients:</strong>
                    <ul>
                        <li>79 Calories</li>
                        <li>19g Carbs</li>
                        <li>1g  Protein</li>
                        <li>35g Fat</li>
                    </ul>
                </article>
            </div>
            <div class="price">
                <button id="b">R449.50</button>
                <button id="b1">add to cart</button>
            </div>
            <p> </p>
            <div class="botom">
                <p><i class="fa-solid fa-triangle-exclamation"></i> Contains a lot of dairy </p>
            </div>

        </div>
        <div id="label_div">
            <label> <strong>Full Chocolate Cake</strong></label><br>
            <div class="parent" >
                <img src='assets/cakes/Meringue-Cake.jpg'>
                <article>
                    <p id="img_list"><strong> Ingredients: </strong>
                    <ul>
                        <li>cup sugar, divided</li>
                        <li>cup water</li>
                        <li>tablespoons unsalted butter, melted and cooled</li>
                        <li>large egg yolks</li>
                        <li>ounces (about 1/2 cup) cake flour</li>
                        <li>cup unsweetened cocoa</li>
                        <li>Dash of salt</li>
                        <li>large egg whites</li>
                    </ul>
                    <p id="img_list"><strong> Nutrients:</strong>
                    <ul>
                        <li>12% Calorie Breakdown</li>
                        <li>37% fat</li>
                        <li>58% carbs</li>
                        <li>6% proteins </li>
                    </ul>
                </article>
            </div>
            <div class="price">
                <button id="b">R159.50</button>
                <button id="b1">add to cart</button>
            </div>
            <div class="botom">
                <p><i class="fa-solid fa-triangle-exclamation"></i> Contains a lot of dairy </p>
            </div></div>
    </body>
</html>
