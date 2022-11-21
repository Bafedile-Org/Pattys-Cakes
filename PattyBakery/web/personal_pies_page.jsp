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
        <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>
        <link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Pacifico'>
        <script src='js/main.js'></script>
    </head>
<<<<<<< HEAD
     <body class="home-body1">
          <header class="home-head">
            <nav>
                <div class="topnav" align="center">
                    <h1>
                        <a href="home"> Patty's Bakery   
                            <i class="fa fa-shopping-cart" style="font-size:24px"> <%
                                    out.println((Integer) request.getAttribute("totalInCart"));
                                %></i></a>
                    </h1>
                </div>
            </nav>
        </header>
        <h1> 
            <a align="left" href="home" style="color:black; width: 5%;">
                <i class="fa fa-arrow-left" aria-hidden="true" style="float:left">
                </i>
            </a>
            <pre align="center"><h1>Personal Pies</h1></pre>

        </h1>
        <div class="images-container">
            <div class="cookies_img">
                <div align="center">
             <label id="cookie_label"><strong><%
                String name = (String) request.getAttribute("10PROName");
                out.println(name);
                    %>
                </label></strong>
            <br>
                <img src='assets/personal_pies/10PRO pies.jpg'>
                </div>
                <div>
                <article>
                    <ul>
                    <li id="img_list"><strong>Ingredients:</strong>
                    <ul>
                        <%

                            List<String> ingredients = (List<String>) request.getAttribute("10PRO");
                            if (ingredients != null) {
                            for (String ingredient : ingredients) {

                            List<String> blueberryIngr = (List<String>) request.getAttribute("blueberry");
                            for (String ingredient : blueberryIngr) {

                                out.println(String.format("<li>%s</li>", ingredient));
                            }
                            }
                        %>
                    </ul>
                    </li>
                    <li id="img_list"><strong>Nutrients:</strong>
                    <ul>
                         <%
                            List<String> nutrients = (List<String>) request.getAttribute("10PRONu");
                                        for (String nutrient : nutrients) {
                                            out.println(String.format("<li>%s</li>", nutrient));
                                        }
                        %>
                    </ul>
                    </li>
                    </ul>
                </article>
            </div>
            </div>
            <div id="img_price">
                <form method="POST" action="pie_control">
                <button id="price-button"><%

                    Double price = (Double) request.getAttribute("10PROPrice");

                    Double price = (Double) request.getAttribute("blueberryPrice");

                    out.println("R" + price);
                    %>
                </button>
                <button id="cart_button_" type="submit" name="add" value="10PRO">add to cart</button>
                </form>
            </div>
=======
    <body>

        <%
            List<Product> products = (List<Product>) request.getAttribute("products");
            Product product = null;
            List<String> ingredients;
            List<String> nutrients;
            String control = (String) request.getAttribute("control");
            Integer totalInCart = (Integer) request.getAttribute("totalInCart");
            String ingredientsValues = "";
            String nutrientsValues = "";
>>>>>>> Deekay-dev

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
        <div class="images-container">
            <div class="cookies_img">
                <div align="center">
             <label id="cookie_label"><strong><%
                name = (String) request.getAttribute("11PROName");

                name = (String) request.getAttribute("appleName");

                out.println(name);
                    %>
                </strong>
            </label><br>
                <img src='assets/personal_pies/11PRO_pie.jpg'>
                </div>
                <div>
                <article>
                    <ul>
                    <li id="img_list"><strong>Ingredients:</strong>
                    <ul>
                        <%
                            ingredients = (List<String>) request.getAttribute("11PRO");
                            if (ingredients != null) {
                            for (String ingredient : ingredients) {
                            List<String> appleIngr = (List<String>) request.getAttribute("apple");
                            for (String ingredient : appleIngr) {
                                out.println(String.format("<li>%s</li>", ingredient));
                            }
                            }
                        %>
                    </ul>
                    </li>
                    <li id="img_list"><strong>Nutrients:</strong>
                    <ul>
                        <%
                            nutrients = (List<String>) request.getAttribute("11PRONu");
                                        for (String nutrient : nutrients) {
                                            out.println(String.format("<li>%s</li>", nutrient));
                                        }
                        %>
                    </ul>
                    </li>
                    </ul>
                </article>
            </div>
            </div>
            <div id="img_price">
                <form method="POST" action="pies_control">
                <button id="price_button"><%
                     price = (Double) request.getAttribute("11PROPrice");
                     price = (Double) request.getAttribute("applePrice");
                    out.println("R" + price);
                    %>
                </button>
                <button id="cart_button" type="submit" name="add" value="11PRO">add to cart</button>
                </form>
            </div>
</div>
        <div class="images-container">
        <div class="cookies_img">       
        <div align="center">
             <label id="cookie_label"><strong><%
                 name = (String) request.getAttribute("12PROName");
                 name = (String) request.getAttribute("strawberryName");
                out.println(name);
                    %>
                </strong>
            </label><br>
                <img src='assets/personal_pies/12PRO pie.jpg'>
        </div>
                <div>
                <article>
                    <ul>
                    <li id="img_list"><strong>Ingredients:</strong>
                    <ul>
                         <%
                            ingredients = (List<String>) request.getAttribute("12PRO");
                          if(ingredients!=null){ 
                            for (String ingredient : ingredients) {
                            List<String> strawberryIngr = (List<String>) request.getAttribute("strawberry");
                            for (String ingredient : strawberryIngr) {
                                out.println(String.format("<li>%s</li>", ingredient));
                            }
                          }
                        %>
                    </ul>
                    </li>
                    <li id="img_list"><strong>Nutrients:</strong>
                    <ul>
                        <%
                           nutrients = (List<String>) request.getAttribute("12PRONu");
                                        for (String nutrient : nutrients) {
                                            out.println(String.format("<li>%s</li>", nutrient));
                                        }
                        %>
                    </ul>
                    </li>
                    </ul>
                </article>
            </div>
        </div>
            <div id="img_price">
                <form method="POST" action="pies_control">
                <button id="price-button"><%
                     price = (Double) request.getAttribute("12PROPrice");
                     price = (Double) request.getAttribute("strawberryPrice");
                    out.println("R" + price);
                    %>
                </button>
                <button id=cart_button" type="submit" name="add" value="12PRO">add to cart</button>
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
