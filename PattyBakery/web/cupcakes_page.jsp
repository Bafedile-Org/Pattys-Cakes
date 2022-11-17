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
        <title>Cupcakes Page</title>
        <link rel = "stylesheet" href="css/style.css">
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
                            <i class="fa fa-shopping-cart" style="font-size:24px">
                                <%
                                out.println((Integer)request.getAttribute("totalInCart"));
                                %>
                            </i></a>
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
        <div id="label_div" style= "background-color: #C799BA; padding: 5px 5px;">

                <label>
                    <strong><%
                        String name = (String) request.getAttribute("7PROName");
                        out.println(name);
                        %></strong>
                </label><br>
                <div class="parent">
                    <img src="assets/cupcakes/coffeecupcake.jfif">
            <article>
                <p id="img_list"><strong>Ingredients</strong></p>
                     <ul>
                        <%
                            List<String> ingredients = (List<String>) request.getAttribute("7PRO");
                           if(ingredients!=null){
                            for (String ingredient : ingredients) {
                                out.println(String.format("<li>%s</li>", ingredient));
                            }
                           }
                        %>
                    </ul>
                    <p id="img_list"><strong>Nutrients</strong></p>
                    <ul>
                        <%
                            List<String> nutrients = (List<String>) request.getAttribute("7PRONu");
                                        for (String nutrient : nutrients) {
                                            out.println(String.format("<li>%s</li>", nutrient));
                                        }
                        %>
                    </ul>
                     </article>
               
            </div>  
            <div class="price">  
               <form method="POST" action="cupcakes_control">
                <button id="b"><%
                    Double price = (Double) request.getAttribute("7PROPrice");
                    out.println("R" + price);
                    %></button>  
                    <button id="b1" type="submit" name="add" value="7PRO"> Add to cart</button>
               </form>
            </div>
               
        </div>
            <div id="label_div" style= "background-color: #C799BA; padding: 5px 5px;">
                 <label>
                    <strong><%
                        name = (String) request.getAttribute("8PROName");
                        out.println(name);
                        %></strong>
                </label><br>
                <div class="parent">
                <img src="assets/cupcakes/glutten_free_chocolate_cupcakes.jpg" alt="cookies" > 
                 <article>
                     <p id="img_list"><strong>Ingredients</strong></p>
                     <ul>
                        <%
                            ingredients = (List<String>) request.getAttribute("8PRO");
                            if(ingredients!=null){
                            for (String ingredient : ingredients) {
                                out.println(String.format("<li>%s</li>", ingredient));
                            }
                            }
                        %>
                    </ul>
                    <p id="img_list"><strong>Nutrients</strong></p><ul>
                        <%
                            nutrients = (List<String>) request.getAttribute("8PRONu");
                                        for (String nutrient : nutrients) {
                                            out.println(String.format("<li>%s</li>", nutrient));
                                        }
                        %>
                    </ul>
</article>
                
            </div>  
            <div class="price">  
                <form method="POST" action="cupcakes_control">
                <button id="b"><%
                    price = (Double) request.getAttribute("8PROPrice");
                    out.println("R" + price);
                    %></button>  
                    <button id="b1" type="submit" name="add" value="8PRO"> Add to cart</button>
                </form>
            </div>
   </div></div>
  <div id="label_div" style= "background-color: #C799BA; padding: 5px 5px;">

                 <label>
                    <strong><%
                        name = (String) request.getAttribute("9PROName");
                        out.println(name);
                        %></strong>
                </label><br>
                <div class="parent">
                <img src="assets/cupcakes/IMG_3165.webp" alt="cookies"> <br> 
             <article>
                     <p id="img_list"><strong>Ingredients</strong></p>
                     <ul>
                        <%
                            ingredients = (List<String>) request.getAttribute("9PRO");
                            if(ingredients!=null){
                            for (String ingredient : ingredients) {
                                out.println(String.format("<li>%s</li>", ingredient));
                            }
                            }
                        %>
                    </ul>
                     <p id="img_list"><strong>Nutrients</strong></p>
                     <ul>
                        <%
                            nutrients = (List<String>) request.getAttribute("9PRONu");
                                            for (String nutrient : nutrients) {
                                                out.println(String.format("<li>%s</li>", nutrient));
                                            }
                        %>
                    </ul>
             </article>
               
            </div>  
            <div class="price">  
                <form method="POST" action="cupcakes_control">
                <button id="b"><%
                    price = (Double) request.getAttribute("9PROPrice");
                    out.println("R" + price);
                    %></button>  
                    <button id="b1" type="submit" name="add" value="9PR"> Add to cart</button>  
                </form>
            </div>
               
        </div>

    </body>
</html>
