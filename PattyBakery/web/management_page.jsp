<%-- 
    Document   : management_page
    Created on : 07 Nov 2022, 1:30:30 PM
    Author     : TRAIN 14
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
        <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Management page</title>
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Pacifico">
        <script src="js/main.js"></script>
    </head>
    <body>
       <header class='home-head'>
            <nav>
                <div class="topnav">
                    <h1 align="center" id='home-header1'>
                    Patty's Bakery Management
                    </h1>
                </div>
            </nav>
        </header>
        <div>
            <a href="add/removeStock">Add/remove Stock</a><br>
            <a href="add/removeEmployee">Add/remove Employee</a><br>
            <a href="add/removeStockPrice">Add/remove price</a><br>
        </div>
    </body>
</html>
