<%--
    Document   : shoppingCart_page
    Created on : Nov 8, 2022, 10:40:42 AM
    Author     : Bridget Bapela
--%>

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
        <a align="left" href="javascript:history.back()" style="color:black;width:5%;float:left">
            <i class="fa fa-arrow-left" aria-hidden="true" style="">
            </i>
        </a>
        <nav>
        </nav>
    </header>
    <div id='all'>
        <!-- Product #1 -->
        <%
            String[] images = (String[]) request.getAttribute("images");
            Product[] products = (Product[]) request.getAttribute("products");
            if (images != null) {
                for (int i = 0; i < images.length; i++) {
                    if (images[i] != null && products[i] != null) {
                        out.println(String.format("<div class='item' id='div%d'>"
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
                                + "<button class='plus-btn' type='button' name='button' onclick='decrement%d()'><strong>-</strong>"
                                + "</button>"
                                + "<input id='amountInput%d' type=number min=1 max=50 value='1'>"
                                + "<button class='minus-btn' type='button' name='button' onclick='increment%d()'><strong>+</strong></button>"
                                + "</div>"
                                + "R<input type='button' id='price%d' class='total-price' value='%.2f' name='%.2f'>"
                                + "<div class=”remove” onclick='remove%d()'>"
                                + "<u style='cursor: pointer'>Remove</u>"
                                + "</div>"
                                + "</div><br>", (i + 1),
                                images[i], products[i].getProductName(), (i + 1), (i + 1), (i + 1), (i + 1), products[i].getPrice(), products[i].getPrice(), (i + 1)));
                    }
                }
            }
        %>
    </div>

    <div class='checkout' align='center'>
        Total Amount :R<input type='button' id='totalAmount' value='0'><br>
        <label>Delivery : R100</label><br>
        Total Amount Due :R<input type='button' id='totalAmountDue' value='0'>
    </div>
    <div align='right'>
        <button style="width:150px;height:50px;border-radius:12px;background-color:#C799BA">Checkout</button>
    </div>

</body>
</html>
