<%--
    Document   : cookies_page
    Created on : 03 Nov 2022, 9:16:29 AM
    Author     : Dimakatso Sebatane
--%>

<%@page import='za.co.pattyBakery.Product'%>
<%@page import='java.util.List'%>
<%@page contentType='text/html' pageEncoding='UTF-8'%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
        <title>Cookies Page</title>
        <link rel='stylesheet' href='css/style.css'>
<<<<<<< HEAD
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
=======
        <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>
        <link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Pacifico'>
        <script src='js/main.js'></script>
    </head>
    <body>
>>>>>>> Deekay-dev

        <%
            List<Product> products = (List<Product>) request.getAttribute("products");
            Product product = null;
            List<String> ingredients;
            List<String> nutrients;
            String control = (String) request.getAttribute("control");
            Integer totalInCart = (Integer) request.getAttribute("totalInCart");
            String ingredientsValues = "";
            String nutrientsValues = "";

            out.println(String.format("<header><nav><div class='topnav' ><h1><a href='home'> Patty's Bakery </a>"
                    + "<a href='%s' name='cart'><i class='fa fa-shopping-cart' "
                    + "style='font-size:24px'"
                    + ">%d"
                    + " </i></a></h1></div></nav></header><h1 align='center'>"
                    + "<a align='left' href='home' "
                    + "style='float:left;color:black;width:110px'>"
                    + "<i class='fa fa-arrow-left' aria-hidden='true'>"
                    + "</i></a><pre align='center'><h1>Cookies</h1>"
                    + "</pre></h1>", control + "?cart=cart", totalInCart));
            for (int i = 0; i < products.size(); i++) {
                product = products.get(i);
                ingredients = product.getRecipe().getIngredients();
                nutrients = product.getNutrientsList();
                if (ingredients != null) {
                    for (String ingredient : ingredients) {
                        ingredientsValues += String.format("<li>%s</li>", ingredient);
                    }
                }
                if (nutrients != null) {
                    for (String nutrient : nutrients) {
                        nutrientsValues += String.format("<li>%s</li>", nutrient);
                    }
                }

<<<<<<< HEAD
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
=======
                out.println(String.format(""
                        + "<div class='images-container'><div class='cookies_img' ><div align='center'>"
                        + "<label id='cookie_label'><strong>%s</strong></label>"
                        + "<br><img src='%s' alt='cookies' >"
                        + "</div><div>"
                        + "<article>"
                        + "<ul>"
                        + "<li id='img_list'>"
                        + "<strong>Ingredients</strong>"
                        + "<ul>%s</ul>"
                        + "</li>"
                        + "<li  id='img_list'>"
                        + "<strong>Nutrients</strong>"
                        + "<ul>%s</ul>"
                        + "</li>"
                        + "</ul>"
                        + "</article>"
                        + "</div></div><div id='img_price'>"
                        + "<form method='POST' action='%s'>"
                        + "<button id='price_button'>R%.2f</button><button id='cart_button'  name='add' value='%s'>add to cart</button></form></div>"
                        + "</div><br><br>", product.getProductName(),
                        product.getImageName(), ingredientsValues, nutrientsValues, control, product.getPrice(), product.getProductId()));
                nutrientsValues = "";
                ingredientsValues = "";
            }
        %>
>>>>>>> Deekay-dev

    </body>
</html>
