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
         <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Prata">
        <script src='js/main.js'></script>
    </head>
    <body style="background: #E6E6FA;font-family:'Prata'">

        <%
            List<Product> products = (List<Product>) request.getAttribute("products");
            Product product = null;
            List<String> ingredients;
            List<String> nutrients;
            String control = (String) request.getAttribute("control");
            Integer totalInCart = (Integer) request.getAttribute("totalInCart");
            String ingredientsValues = "";
            String nutrientsValues = "";

            out.println(String.format("<header class='home-head'><nav><div class='topnav' ><h1 align='center' id='home-header1' style='font-family:'Prata''>Patty's Bakery"
                    + "<a href='%s' name='cart'><i class='fa fa-shopping-cart' "
                    + "style='font-size:24px'"
                    + ">%d"
                    + " </i></a></h1></div></nav></header><h1 align='center'>"
                    + "<a align='left' href='home' "
                    + "style='float:left;color:black;width:110px;font-family:Prata'>"
                    + "<i class='fa fa-arrow-left' aria-hidden='true'>"
                    + "</i></a><pre align='center'><u><h1>Cookies</h1></u>"
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

                out.println(String.format(""
                        + "<div class='images-container' align='center'><div class='cookies_img' ><div align='center'>"
                        + "<label id='cookie_label'><strong>%s</strong></label>"
                        + "<br><img src='%s' alt='cookies' class='center'>"
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

    </body>
</html>
