<%--
    Document   : shoppingCart_page
    Created on : Nov 8, 2022, 10:40:42 AM
    Author     : Bridget Bapela
--%>

<%@page import="java.io.PrintWriter"%>
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
         <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Prata">
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
<body>
    <header>
        <a align="left" href="home" style="color:black;width:5%;float:left">
            <i class="fa fa-arrow-left" aria-hidden="true" style="">
            </i>
        </a>
    </header>


    <div id='all'>
        <%
            ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
            String displayMessage = (String) request.getAttribute("displayMessage");
            out.println(displayMessage);
        %>
    </div>

    <div class='checkout' align='center'>
        Total Amount :R<input type='button' id='totalAmount' value='<%=String.format("%.2f", cart.getTotalprice())%>'><br>
        <label>Delivery : R100</label><br>
        Total Amount Due :R<input type='button' id='totalAmountDue' value='<%=String.format("%.2f", cart.getTotalprice() + 100)%>'>
    </div>
    <div align='right'>
        <form action='checkout_control' method='POST'>
            <button style="width:150px;height:50px;border-radius:12px;background-color:#C799BA" name='checkout'>Checkout</button>
        </form>
    </div>

</body>
</html>
