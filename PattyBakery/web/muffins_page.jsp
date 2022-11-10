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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Muffins page</title>
        <link rel='stylesheet' href='css/style.css'>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Pacifico">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" integrity="sha512-9usAa10IRO0HhonpyAIVpjrylPvoDwiPUiKdWk5t3PyolY1cOd4DSE0Ga+ri4AuTroPR5aQvXU9xC6qOPnzFeg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    </head>
    <body>
        <header>
            <nav>
                <div class="topnav" >
                    <h1>
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

        <div id="label_div">
                <label id="cookie_label">
                    <strong>
                        <%
                            String name = (String) request.getAttribute("blueberryName");
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
                            List<String> ingredients = (List<String>) request.getAttribute("blueberry");
                            for (String ingredient : ingredients) {
                                out.println(String.format("<li>%s</li>", ingredient));
                            }
                        %>
                    </ul>
                    <p id="img_list"><strong>Nutrients</strong></p><ul>
                        <%
                            String nutrients = (String) request.getAttribute("blueberryNu");
                            out.println(String.format("<li>%s</li>", nutrients));
                        %>
                    </ul>
                    </article>

            </div>  
            <div class="price">  
                <button id="b" ><%
                    Double price = (Double) request.getAttribute("blueberryPrice");
                    out.println("R" + price);
                    %></button>  
                <button id="b1"> Add to cart</button>  
            </div>
                  <div class="botom">
                <p><i class="fa-solid fa-triangle-exclamation"></i> Contains a lot of dairy </p>
            </div>
                </div>
                 <div id="label_div">

                <label>
                    <strong><%
                        name = (String) request.getAttribute("carrotName");
                        out.println(name);
                        %></strong>
                </label><br>
                <div class="parent" >
                <img id="cup_img" src="assets/muffins/carrot-muffins.jpg" alt="muffins"> <br> 
                 <article>
           
                     <p id="img_list"><strong>Ingredients</strong></p>
                         
                         <ul>
                        <%
                            ingredients = (List<String>) request.getAttribute("cranberry");
                            for (String ingredient : ingredients) {
                                out.println(String.format("<li>%s</li>", ingredient));
                            }
                        %>
                    </ul>
                     <p id="img_list"><strong>Nutrients</strong></p>
                     <ul>
                        <%
                            nutrients = (String) request.getAttribute("cranberryNu");
                            out.println(String.format("<li>%s</li>", nutrients));
                        %>
                    </ul>
</article>
                
            </div>  
            <div class="price">  
                <button id="b" ><%
                    price = (Double) request.getAttribute("cranberryPrice");
                    out.println("R" + price);
                    %></button>  
                <button id="b1"> Add to cart</button>  
            </div>
         <div class="botom">
                <p><i class="fa-solid fa-triangle-exclamation"></i> Contains a lot of dairy </p>
            </div>
                 </div>
            <div id="label_div">

                <label>
                    <strong><%
                        name = (String) request.getAttribute("cranberryName");
                        out.println(name);
                        %></strong>
                </label><br>
                <div class="parent">
                <img src="assets/muffins/Cranberry-Muffins.jpg" alt="muffins"> <br> 
            <article>
                   <p id="img_list"><strong>Ingredients</strong></p>
                   <ul>
                        <%
                            ingredients = (List<String>) request.getAttribute("carrot");
                            for (String ingredient : ingredients) {
                                out.println(String.format("<li>%s</li>", ingredient));
                            }
                        %>
                    </ul>
                    <p id="img_list"><strong>Nutrients</strong></p><ul>
                        <%
                            nutrients = (String) request.getAttribute("carrotNu");
                            out.println(String.format("<li>%s</li>", nutrients));
                        %>
                    </ul>
</article>
            </div>  
            <div class="price">  
                <button id="b" ><%
                    price = (Double) request.getAttribute("carrotPrice");
                    out.println("R" + price);
                    %></button>  
                <button id="b1"> Add to cart</button>  
            </div>
                 <div class="botom">
                <p><i class="fa-solid fa-triangle-exclamation"></i> Contains a lot of dairy </p>
            </div>
        </div>

    </body>
</html>
