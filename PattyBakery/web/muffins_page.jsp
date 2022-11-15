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
        <link rel="stylesheet" href="css/style.css">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Muffins page</title>
        <link rel='stylesheet' href='css/style.css'>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Pacifico">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" integrity="sha512-9usAa10IRO0HhonpyAIVpjrylPvoDwiPUiKdWk5t3PyolY1cOd4DSE0Ga+ri4AuTroPR5aQvXU9xC6qOPnzFeg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
      <style>
        
        </style>
      </head>
      <body class="home-body1">
          <header class="home-head">
            <nav>
                <div class="topnav" align="center">
          
                    <h1>
                        <a href="home" > Patty's Bakery   
                            <i class="fa fa-shopping-cart" style="font-size:24px"> <%
                                    out.println((Integer) request.getAttribute("totalInCart"));
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
            <pre align="center"><h1>Muffins/<a href="cupcakes_control">Cupcakes</a></h1></pre>
        </h1>

        <div id="label_div" style= "background-color: #C799BA; padding: 5px 5px;">
                <label id="cookie_label" >
                    <strong>
                        <%
                            String name = (String) request.getAttribute("13PROName");
                            out.println(name);
                        %>
                    </strong>
                </label><br>
                <div class="parent">
                <img   src="assets/muffins/Blueberry-Muffins.jpg">
             <article>
            <div>
               
                     <p id="img_list"><strong>Ingredients</strong></p><ul>
                        <%
                            List<String> ingredients = (List<String>) request.getAttribute("13PRO");
                             if (ingredients != null) {
                            for (String ingredient : ingredients) {
                                out.println(String.format("<li>%s</li>", ingredient));
                            }
                             }
                        %>
                    </ul>
                    <p id="img_list"><strong>Nutrients</strong></p><ul>
                        <%
                            List<String> nutrients = (List<String>) request.getAttribute("13PRONu");
                                        for (String nutrient : nutrients) {
                                            out.println(String.format("<li>%s</li>", nutrient));
                                        }
                        %>
                    </ul>
                    </article>

            </div>  
            <div class="price">  
                <form method="POST" action="muffinss_control">
                <button id="b" ><%
                    Double price = (Double) request.getAttribute("13PROPrice");
                    out.println("R" + price);
                    %></button>  
                <button id="b1" type="submit" name="add" value="13PRO"> Add to cart</button>  
                </form >
            </div>
                
                </div>
                 <div id="label_div" style= "background-color: #C799BA; padding: 5px 5px;">

                <label>
                    <strong><%
                        name = (String) request.getAttribute("15PROName");
                        out.println(name);
                        %></strong>
                </label><br>
                <div class="parent" >
                <img id="cup_img" src="assets/muffins/15PRO-muffins.jpg" alt="muffins"> <br> 
                 <article>
           
                     <p id="img_list"><strong>Ingredients</strong></p>
                         
                         <ul>
                        <%
                            ingredients = (List<String>) request.getAttribute("14PRO");
                           if (ingredients != null) { 
                            for (String ingredient : ingredients) {
                                out.println(String.format("<li>%s</li>", ingredient));
                            }
                           }
                        %>
                    </ul>
                     <p id="img_list"><strong>Nutrients</strong></p>
                     <ul>
                        <%
                            nutrients = (List<String>) request.getAttribute("14PRONu");
                                        for (String nutrient : nutrients) {
                                            out.println(String.format("<li>%s</li>", nutrient));
                                        }
                        %>
                    </ul>
</article>
                
            </div>  
            <div class="price"> 
                <form method="POST" action="muffins_control">
                <button id="b" ><%
                    price = (Double) request.getAttribute("14PROPrice");
                    out.println("R" + price);
                    %></button>  
                <button id="b1" type="submit" name="add" value="14PRO"> Add to cart</button> 
                </form>
            </div>
         
                 </div>
            <div id="label_div" >

                <label>
                    <strong><%
                        name = (String) request.getAttribute("14PROName");
                        out.println(name);
                        %></strong>
                </label><br>
                <div class="parent">
                <img src="assets/muffins/Cranberry-Muffins.jpg" alt="muffins"> <br> 
            <article>
                   <p id="img_list"><strong>Ingredients</strong></p>
                   <ul>
                        <%
                            ingredients = (List<String>) request.getAttribute("15PRO");
                             if (ingredients != null) { 
                            for (String ingredient : ingredients) {
                                out.println(String.format("<li>%s</li>", ingredient));
                            }
                             }
                        %>
                    </ul>
                    <p id="img_list"><strong>Nutrients</strong></p><ul>
                        <%
                            nutrients = (List<String>) request.getAttribute("15PRONu");
                                        for (String nutrient : nutrients) {
                                            out.println(String.format("<li>%s</li>", nutrient));
                                        }
                        %>
                    </ul>
</article>
            </div>  
            <div class="price">  
                 <form method="POST" action="muffins_control">
                <button id="b" ><%
                    price = (Double) request.getAttribute("15PROPrice");
                    out.println("R" + price);
                    %></button>  
                <button id="b1" type="submit" name="add" value="15PRO"> Add to cart</button>  
                 </form>
            </div>
               
        </div>

    </body>
</html>
