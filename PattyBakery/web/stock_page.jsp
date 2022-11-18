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
            .Click-here {
                cursor: pointer;
                background-image: linear-gradient(190deg, #f83600 0%, #fee140 100%);
                color: #fff;
                width: 180px;
                text-align: center;
                font-size:16px;
                padding: 18px 0;
                margin: 0 auto;
                transition:background-image 3s ease-in-out;
            }
            .Click-here:hover{
                transition:background-image 3s ease-in-out;
                background-image: linear-gradient(90deg, #fee140 0%, #f83600 100%);
            }
            .custom-model-main {
                text-align: center;
                overflow: hidden;
                position: fixed;
                top: 0;
                right: 0;
                bottom: 0;
                left: 0; /* z-index: 1050; */
                -webkit-overflow-scrolling: touch;
                outline: 0;
                opacity: 0;
                -webkit-transition: opacity 0.15s linear, z-index 0.15;
                -o-transition: opacity 0.15s linear, z-index 0.15;
                transition: opacity 0.15s linear, z-index 0.15;
                z-index: -1;
                overflow-x: hidden;
                overflow-y: auto;
            }
            .model-open {
                z-index: 99999;
                opacity: 1;
                overflow: hidden;
            }
            .custom-model-inner {
                -webkit-transform: translate(0, -25%);
                -ms-transform: translate(0, -25%);
                transform: translate(0, -25%);
                -webkit-transition: -webkit-transform 0.3s ease-out;
                -o-transition: -o-transform 0.3s ease-out;
                transition: -webkit-transform 0.3s ease-out;
                -o-transition: transform 0.3s ease-out;
                transition: transform 0.3s ease-out;
                transition: transform 0.3s ease-out, -webkit-transform 0.3s ease-out;
                display: inline-block;
                vertical-align: middle;
                width: 320px;
                margin: 30px auto;
                max-width: 97%;
            }
            .custom-model-wrap {
                display: block;
                width: 100%;
                position: relative;
                background-color: #fff;
                border: 1px solid #999;
                border: 1px solid rgba(0, 0, 0, 0.2);
                border-radius: 6px;
                -webkit-box-shadow: 0 3px 9px rgba(0, 0, 0, 0.5);
                box-shadow: 0 3px 9px rgba(0, 0, 0, 0.5);
                background-clip: padding-box;
                outline: 0;
                text-align: left;
                padding: 20px;
                -webkit-box-sizing: border-box;
                -moz-box-sizing: border-box;
                box-sizing: border-box;
                max-height: calc(100vh - 70px);
                overflow-y: auto;
            }
            .model-open .custom-model-inner {
                -webkit-transform: translate(0, 0);
                -ms-transform: translate(0, 0);
                transform: translate(0, 0);
                position: relative;
                z-index: 999;
            }
            .model-open .bg-overlay {
                background: rgba(0, 0, 0, 0.6);
                z-index: 99;
            }
            .bg-overlay {
                background: rgba(0, 0, 0, 0);
                height: 100vh;
                width: 100%;
                position: fixed;
                left: 0;
                top: 0;
                right: 0;
                bottom: 0;
                z-index: 0;
                -webkit-transition: background 0.15s linear;
                -o-transition: background 0.15s linear;
                transition: background 0.15s linear;
            }
            .close-btn {
                position: absolute;
                right: 0;
                top: -30px;
                cursor: pointer;
                z-index: 99;
                font-size: 30px;
                color: #fff;
            }
            @media screen and (min-width:800px){
                .custom-model-main:before {
                    content: "";
                    display: inline-block;
                    height: auto;
                    vertical-align: middle;
                    margin-right: -0px;
                    height: 100%;
                }
            }
            @media screen and (max-width:799px){
                .custom-model-inner{margin-top: 45px;}
            }

        </style>
        <script >
            function getDropValue() {
                var element = document.getElementById("myList");
                var text = document.getElementById("inputValue");
                text.value = element.options[element.selectedIndex].text;
            }
        </script>
          <!-- jQuery -->
    <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>
    <script>
    $(".Click-here").on('click', function() {
      $(".custom-model-main").addClass('model-open');
    }); 
    $(".close-btn, .bg-overlay").click(function(){
      $(".custom-model-main").removeClass('model-open');
    });
    </script>
    </head>
    <body>
        <nav class="home-head">
            <div class="topnav">
                <h1 align="center" id="home-header1"> Bakery Stock management site
                    <i class="fa fa-bars dropdown" aria-hidden="true" style="font-size:24px; padding-right: 24px">
                        <div class="dropdown-content" align="left">
                            <a href="management_page.jsp">Back</a>
                        </div>
                    </i>
                </h1>
            </div>
        </nav>
        <div>
            Today's date: <%= (new java.util.Date())%>
        </div>
        <div class="form-content">
            <form action="res/bakery_res/addStock" method="POST">
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
                    <button type='submit'>Remove</button>
                    <button type='submit' name="which" value="update">Update</button>
                </div>
                <button class="Click-here">Click Me</button> 
                <div class="custom-model-main">
                    <div class="custom-model-inner">
                        <div class="close-btn">×</div>
                        <div class="custom-model-wrap">
                            <div class="pop-up-content-wrap">
                                <h2>Have a nice day!</h2>
                                <p>This is message box popup that revealed on button click.</p>
                            </div>
                        </div>
                    </div>
                    <div class="bg-overlay"></div>
                </div>
            </form>
        </div>
    </body>
</html>
