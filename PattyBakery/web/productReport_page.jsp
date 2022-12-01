<%--
    Document   : report_page
    Created on : Dec 1, 2022, 8:53:48 AM
    Author     : Bridget Bapela
--%>


<%@page import="java.security.SecureRandom"%>
<%@page import="za.co.pattyBakery.service.impl.StockServImpl"%>
<%@page import="za.co.pattyBakery.dao.StockDAO"%>
<%@page import="java.time.LocalDate"%>
<%@page import="za.co.pattyBakery.Product"%>
<%@page import="za.co.pattyBakery.service.impl.NutrientsServImpl"%>
<%@page import="java.util.Collections"%>
<%@page import="za.co.pattyBakery.service.impl.ProductServImpl"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!--<link rel="stylesheet" href="css/style.css">-->
        <link href='https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css' rel='stylesheet'>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Pacifico">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <style>
            table, th, td {
                border: 1px solid white;
                border-collapse: collapse;
            }
            th, td {
                background-color: #96D4D4;
            }
        </style>
        <%List<Product> products = new ProductServImpl().getAllProducts();
            StockDAO stockServ = new StockServImpl();
            Product product = null;
            String productValue = "", quantityValue = "";
            LocalDate expDate = LocalDate.now();
        %>
    <div align='right'>
        Today's date: <%= (new java.util.Date())%>
    </div>
</head>
<body>
    <u> <a href="/bakery/login_control">Back</a><h1 align="center">Product Report Summary</h1></u>
    <table style="width:100%">
        <tr>
            <th>Description</th>
            <th>Quantity</th>
            <th>Expiring Date</th>
        </tr>

        <%
            if (products != null) {
                for (Product prod : products) {
                    out.println(String.format(" <tr><td>%s</td>", prod.getProductName()));
                    out.println(String.format("<td>%s</td>", stockServ.getQuantityByID(prod.getProductId())));
                    out.println(String.format("<td>%s</td>  </tr>", LocalDate.now().plusDays(new SecureRandom().nextInt(1))));
                }
            }

        %>
    </table>
</body>
</html>
