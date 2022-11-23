<%--
    Document   : stock_page
    Created on : 08 Nov 2022, 10:42:18 AM
    Author     : Hlawulani
--%>

<%@page import="java.util.List"%>
<%@page import="za.co.pattyBakery.service.impl.OrderServImpl"%>
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
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Prata">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <style>
            html, body {
                background-color: #f4f4f4;
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
        <script>
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
                <h1 align="center" id="home-header1"> <div style='float:left' class="dropdown-content">
                        <a href="/bakery/login_control">Back</a>
                    </div> Bakery Order management site


                </h1>
            </div>
        </nav>
        <div align='right'>
            Today's date: <%= (new java.util.Date()).toLocaleString()%>
        </div>
        <div class="form-contents" style='margin-top:80px;border-style: dashed;padding:12px 12px;border-color:black'>
            <h2 align='center'>Update Order Delivery Status</h2>
            <form action="/bakery/res/bakery_res/updateOrder" method='POST'>
                <div class="input-field" style="text-align: center">
                    <input  name='order_id' id="inputValue"  type="orderNumber" placeholder="Order Number" class="orderNumber" size="35">
                    <select id = "myList" onchange = "getDropValue()" >
                        <option>Select Order Id</option>
                        <%
                            List<String> ordersId = new OrderServImpl().getOrderAllIds();
                            if (ordersId != null) {
                                for (String orderId : ordersId) {
                                    out.println(String.format("<option value='%s'>%s</option>", orderId.replace("]", "").replace("[", ""), orderId.replace("]", "").replace("[", "")));
                                }
                            }
                        %>
                    </select>
                </div>
                <div class="input-field" style="text-align: center">
                    <input name='date'  type="date" placeholder="Date" class="date" size="150">
                    <select name='status' >
                        <option>Select Delivery Status</option>
                        <option value='delivered'>Delivered</option>
                        <option value='pending delivery'>Pending Delivery</option>

                    </select>
                </div>

                <div class="btn-group" style="text-align: center">
                    <button>Add</button>
                    <button>Remove</button>
                    <button type='submit'>Update</button>
                </div>
            </form>
        </div>
    </body>
</html>
