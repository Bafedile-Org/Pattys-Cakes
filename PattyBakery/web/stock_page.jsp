<%--
    Document   : stock_page
    Created on : 08 Nov 2022, 10:42:18 AM
    Author     : Bridget Bapela
--%>

<%@page import="za.co.pattyBakery.service.impl.ProductServImpl"%>
<%@page import="za.co.pattyBakery.Product"%>
<%@page import="za.co.pattyBakery.dao.impl.ProductDAOImpl"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head class="top-head">
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/style.css">
        <link href='https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css' rel='stylesheet'>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Pacifico">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <style>
            html, body {
                background-image:url("assets/management/bakeryStock.jpg");
                background-size: cover;
            }
            .sf {
                min-height: 400px;
            }
            .input-field input, .input-field select{
                height:35px;
            }
            .input-field{
                padding:14px 18px;

            }
        </style>
        <script >
            function getDropValue() {
                var element = document.getElementById("myList");
                var text = document.getElementById("inputValue");
                text.value = element.options[element.selectedIndex].text;
            }
        </script>
    </head>
    <body>
        <nav class="home-head">
            <div class="topnav">
                <h1 align="center" id="home-header1"> <div  style='float:left'class="dropdown-content" align="left">
                        <a href="/bakery/admin">Back</a>
                    </div>Bakery Stock management site
                </h1>
            </div>
        </nav>
        <div align='right'>
            Today's date: <%= (new java.util.Date())%>
        </div>
        <div class="form-content" style='margin-top:80px;border-style: dashed;padding:12px 12px;border-color:black'>
            <h2 align='center'>Add, Update Or Remove Product</h2>
            <form action="/bakery/res/bakery_res/addStock" method="POST">
                <div class="input-field" style="text-align: center">
                    <input  id="inputValue" type="productId" name="prodId" placeholder="Product ID" class="productId" size="33" value="">
                    <select id = "myList" onchange = "getDropValue()"  >
                        <option>Select ID type</option>
                        <%
                            List<String> products = new ProductServImpl().getAllProductsIds();
                            for (String product : products) {
                                out.println(String.format("<option value='%s'>%s</option>", product, product));
                            }
                        %>
                    </select>
                </div>
                <div class="input-field" style="text-align: center">
                    <input type="quantity" name="quantity" placeholder="Quantity" class="quantity" size="50">
                </div>

                <div class="btn-group" style="text-align: center">
                    <button type='submit' name="which" value="add">Add</button>
                    <button type='submit' name='which' value='remove'>Remove</button>
                    <button type='submit' name="which" value="update">Update</button>
                </div>
            </form>
        </div>
    </body>
</html>
