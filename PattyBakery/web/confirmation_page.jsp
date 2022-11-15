<%--
    Document   : confirmation_page
    Created on : 10 Nov 2022, 8:34:57 AM
    Author     : TRAIN 14
--%>

<%@page import="za.co.pattyBakery.Person"%>
<%@page import="za.co.pattyBakery.Order"%>
<%@page import="za.co.pattyBakery.ShoppingCart"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head class="top-head">
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/confirm.css">
        <link href='https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css' rel='stylesheet'>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Pacifico">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <style>
            html, body {
                background-color: #f4f4f4;
            }
            .sf {
                min-height: 400px;
            }
        </style>
    </head>
    <body class='chec'>
        <nav class="home-head">
            <div class="topnav">
                <h1 align="center" id="home-header1"> Confirmation order
                    <i class="fa fa-bars dropdown" aria-hidden="true" style="font-size:24px; padding-right: 24px">
                        <div class="dropdown-content">
                            <a href="cookies_control">Back</a>
                        </div>
                    </i>
                </h1>
            </div>
        </nav>
        <div class="mainscreen">
            <div class="card">
                <div class="leftside">
                    <form action="#">
                        <h2>Product list: </h2>
                        <%
                            ShoppingCart shoppingCart = (ShoppingCart) request.getAttribute("shoppingCart");
                            if (shoppingCart != null) {
                                for (Order order : shoppingCart.getOrders()) {
                                    out.println(String.format("<p>%s  %.2f x %d</p>",
                                            order.getProduct().getProductName(), order.getProduct().getPrice(), order.getQuantity()));
                                }
                            }
                        %>
                    </form>

                </div>

                <div class="rightside">
                    <form action="#">
                        <div class="input-field" style="text-align: center">
                            <h2>Total listing </h2>
                            <a><button type="submit" class="button">R<%=String.format("%.2f", shoppingCart == null ? 0.0 : shoppingCart.getTotalprice())%></button></a>
                        </div>
                    </form>

                </div><br>

            </div><br>
            <div class="card">
                <div class="leftside">
                    <div class="left_info">
                        <h2>User Information</h2>
                        <%
                            Person person = (Person) request.getAttribute("customer");
                            out.println(String.format("<label>Name</label>:%s<br>"
                                    + "<label>Surname</label>:%s<br>"
                                    + "<label>Telephone Number</label>:%s<br>"
                                    + "<label>Email Address</label>:%s<br>"
                                    + "<label>Delivery Address</label>:%s<br>",
                                    person.getName(), person.getSurname(),
                                    person.getTelephoneNumber(), person.getEmail(),
                                    person.getDeliveryAddress()));
                        %>
                    </div>

                </div>

                <div class="rightside">


                </div><br>

            </div>

        </div>

        <div class="bb">
            <form action="<%=request.getAttribute("control")%>" method="POST">
                <button type="submit" class="button" name="confirmOrder">Confirm order</button>
            </form>
        </div>
    </body>
</html>
