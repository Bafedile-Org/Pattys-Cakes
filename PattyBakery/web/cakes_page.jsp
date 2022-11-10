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
            </nav>
        </header>
        <h1> 
           <a align="left" href="home" style="color:black;width:5%;">
               <i class="fa fa-arrow-left" aria-hidden="true" style="float:left">
                </i>
            </a>
            <pre align="center"><h1>Cakes</h1></pre>

        </h1>
        <div id="label_div">
            <label><strong>Salted Caramel Cake</strong></label><br>
        <div class="parent">
            <img src='assets/cakes/caramel-cake-5.jpg'>
            <article>
            <p id="img_list"><strong>Ingredients:</strong>
            <ul>
                
                <li>Cups white sugar</li>
                <li>Cups butter</li>
                <li>Large eggs</li>
                <li>Cups all-purpose flour</li>
                <li>Teaspoon baking powder</li>
                <li>Teaspoon salt</li>
                <li>Cups whole milk</li>
                <li>Teaspoon vanilla extract</li>
            </ul>
                
            <p id="img_list"><strong> Nutrients:</strong>
                <ul>
                <li>Cups white sugar</li>
                <li>1019 Calories</li>
                <li>43g Fat</li>
                <li>155g Carbs</li>
                <li>9g Protein</li>
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
            <label><strong><%
                String name = (String) request.getAttribute("caramelName");
                out.println(name);
                    %>
                </strong>
            </label><br>
            <div class="parent">
                <img src='assets/cakes/caramel-cake-5.jpg'>
                <article>
                    <p id="img_list"><strong> Ingredients: </strong></p>
                    <ul>
                        <%
                            List<String> caramelIngr = (List<String>) request.getAttribute("caramel");
                            for (String ingredient : caramelIngr) {
                                out.println(String.format("<li>%s</li>", ingredient));
                            }
                        %>
                    </ul>
                    <p id="img_list"><strong> Nutrients:</strong></p>
                    <ul>
                        <%
                            String caramelNutrients = (String) request.getAttribute("caramelNu");
                            out.println(String.format("<li>%s</li>", caramelNutrients));
                        %>
                    </ul>
                </article>
            </div>
            <div class="price">
                <button id="b"><%
                    Double price = (Double) request.getAttribute("caramelPrice");
                    out.println("R" + price);
                    %>
                </button>
                <button id="b1">add to cart</button>
            </div>
            <p> </p>
            <div class="botom">
                <p><i class="fa-solid fa-triangle-exclamation"></i> Contains a lot of dairy </p>
            </div></div>
        <div id="label_div">
            <label><strong><%
                name = (String) request.getAttribute("margueName");
                out.println(name);
                    %>
                </strong>
            </label><br>
            <div class="parent">
                <img src='assets/cakes/Meringue-Cake.jpg'>
                <article>
                    <p id="img_list"><strong> Ingredients: </strong></p>
                    <ul>
                        <%
                            List<String> margueIngr = (List<String>) request.getAttribute("margue");
                            for (String ingredient : margueIngr) {
                                out.println(String.format("<li>%s</li>", ingredient));
                            }
                        %>
                    </ul>
                    <p id="img_list"><strong> Nutrients:</strong></p>
                    <ul>
                        <%
                            String margueNutrients = (String) request.getAttribute("margueNu");
                            out.println(String.format("<li>%s</li>", margueNutrients));
                        %>
                    </ul>
                </article>
            </div>
            <div class="price">
                <button id="b"><%
                    price = (Double) request.getAttribute("marguePrice");
                    out.println("R" + price);
                    %>
                </button>
                <button id="b1">add to cart</button>
            </div>
            <p> </p>
            <div class="botom">
                <p><i class="fa-solid fa-triangle-exclamation"></i> Contains a lot of dairy </p>
            </div>

        </div>
        <div id="label_div">
            <label>
                <strong><%
                name = (String) request.getAttribute("chocolateName");
                out.println(name);
                    %>
                </strong>
            </label><br>
            <div class="parent" >
                <img src='assets/cakes/cakes_pic.jpg'>
                <article>
                    <p id="img_list"><strong> Ingredients: </strong></p>
                    <ul>
                        <%
                            List<String> chocolateIngr = (List<String>) request.getAttribute("chocolate");
                            for (String ingredient : chocolateIngr) {
                                out.println(String.format("<li>%s</li>", ingredient));
                            }
                        %>
                    </ul>
                    <p id="img_list"><strong> Nutrients:</strong></p>
                    <ul>
                        <%
                            String chocolateNutrients = (String) request.getAttribute("chocolateNu");
                            out.println(String.format("<li>%s</li>", chocolateNutrients));
                        %>
                    </ul>
                </article>
            </div>
            <div class="price">
                <button id="b"><%
                    price = (Double) request.getAttribute("chocolatePrice");
                    out.println("R" + price);
                    %>
                </button>
                <button id="b1">add to cart</button>
            </div>
            <div class="botom">
                <p><i class="fa-solid fa-triangle-exclamation"></i> Contains a lot of dairy </p>
            </div>
        </div>
    </body>
</html>
