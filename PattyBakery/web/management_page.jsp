<%--
    Document   : management_page
    Created on : 07 Nov 2022, 1:30:30 PM
    Author     : Hlawulani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head class="top-head">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Management page</title>
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Prata">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Pacifico">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="js/main.js"></script>
        <style>
             body {
                 background-image:url("../assets/patty_pic_chef.jpg");
               background-size:cover;
            }
            .sf {
                min-height: 400px;
            }
        </style>
    </head>
    <body class="home-body1">
        <header class='home-head'>
            <nav>
                <div class="topnav">
                    <h1 align="center" id='home-header1'>
                        Patty's Bakery Management

                        <i class="fa fa-bars dropdown" aria-hidden="true" style="font-size:24px; padding-right: 24px">
                            <div class="dropdown-content" align="left">
                                <a href="/bakery/admin">Logout</a>
                                <a href="/bakery/admin/stock">Stock</a>
                                <a href="/bakery/admin/employee">Employee</a>
                                <a href="/bakery/admin/orders">Orders</a>
                                <a href="/bakery/admin/ingredients">Ingredients</a>
                            </div>
                        </i>
                    </h1>

                </div>
            </nav>
        </header>
        <div>
            Today's date: <%= (new java.util.Date()).toLocaleString()%>
        </div>           
        </div>
    </body>
</html>
