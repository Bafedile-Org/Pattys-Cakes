<%--
    Document   : shoppingCart_page
    Created on : Nov 8, 2022, 10:40:42 AM
    Author     : Bridget Bapela
--%>

<%@page import="java.util.Map"%>
<%@page import="za.co.pattyBakery.Order"%>
<%@page import="java.util.List"%>
<%@page import="za.co.pattyBakery.ShoppingCart"%>
<%@page import="za.co.pattyBakery.Product"%>
<%@page contentType='text/html' pageEncoding='UTF-8'%>
<!DOCTYPE html>
<html>
    <head>
        <link rel='stylesheet' href='css/styles1.css'>
        <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>
        <link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Pacifico'>
        <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
        <title>Shopping Cart Page</title>
        <script src="js/cartManage.js"></script>
    <div class=”Cart-Container”></div>
    <div class=”Header”>
        <h5 class=”Action” align='right' onclick='removeAll()'><button> Remove all</button></h5>
        <h1 align='center'>
            <a href='home'> Patty's Bakery</a>
        </h1>
        <h3 class=”Heading” align='left'>Shopping Cart</h3>
    </div>
</head>
<body onload="totalAmount()">
    <header>
        <a align="left" href="<%=(String) request.getAttribute("control")%>" style="color:black;width:5%;float:left">
            <i class="fa fa-arrow-left" aria-hidden="true" style="">
            </i>
        </a>
        <nav>
        </nav>
    </header>
    <div id='all'>
        <%
            String[] images = (String[]) request.getAttribute("images");
            Product[] products = (Product[]) request.getAttribute("products");
            Map<String, Integer> quantitiesMap = (Map<String, Integer>) request.getAttribute("quantitiesMap");
            if (images != null) {
                for (int i = 0; i < images.length; i++) {
                    if (images[i] != null && products[i] != null) {
                        out.println(String.format("<div class='item' id='div'>"
                                + "<div class='buttons'>"
                                + "<span class='delete-btn'>"
                                + "</span><span class='like-btn'></span>"
                                + "</div>"
                                + "<div class='image'>"
                                + "<img src='%s' alt='cookies' width='250' height='150' />"
                                + "</div>"
                                + "<div class='description'><span>%s</span>"
                                + "</div>"
                                + "<div class='quantity'><script src='js/cartCode.js'></script> "
                                + "<form onclick='controllers()' method='POST' id='conForm' name='%s'>"
                                + "<button class='plus-btn' type='submit' name='%s' value='%s' data-value='productId'><strong>-</strong>"
                                + "</button>"
                                + "<input id='amountInput' type=label readonly min=1 max=50 value='%d'>"
                                + "<button class='minus-btn' type='submit' name='%s' value='%s'><strong>+</strong></button>"
                                + "</form>"
                                + "</div>"
                                + "R<input type='button' id='price' class='total-price' value='%.2f' name='%.2f'>"
                                + "<div class=”remove” onclick='remove()'>"
                                + "<u style='cursor: pointer'>Remove</u>"
                                + "</div>"
                                + "</div><br>",
                                images[i], products[i].getProductName(), products[i].getCategory(), "sub", products[i].getProductId(), quantitiesMap.get(products[i].getProductId()), "adds",
                                products[i].getProductId(), products[i].getPrice(), products[i].getPrice()));
                    }
                }
            }
        %>
    </div>

    <div class='checkout' align='center'>
        Total Amount :R<input type='button' id='totalAmount' value='<%=String.format("%.2f", request.getAttribute("totalAmount"))%>'><br>
        <label>Delivery : R<%=(Double) request.getAttribute("deliveryAmount")%></label><br>
        Total Amount Due :R<input type='button' id='totalAmountDue' value='<%=(Double) request.getAttribute("totalAmount") == 0 ? 0.0 : String.format("%.2f", (Double) request.getAttribute("totalAmount") + 100)%>'>
    </div>
    <div align='right'>
        <form action='login_control' method='POST'>
            <button style="width:150px;height:50px;border-radius:12px;background-color:#C799BA" name='login'>Checkout</button>
        </form>
    </div>

</body>
</html>
