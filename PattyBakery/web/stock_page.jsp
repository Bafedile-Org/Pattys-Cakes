<%--
    Document   : stock_page
    Created on : 08 Nov 2022, 10:42:18 AM
    Author     : Hlawulani
--%>

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
                background-color:#f4f4f4;
            }
            .sf {
                min-height: 400px;
            }
        </style>
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
                    <input type="productId" name="prodId" placeholder="Product ID" class="productId" size="33">
                    <select id = "myList" onchange = "favTutorial()" >
                        <option>Select ID type</option>
                        <option> #124547434 </option>
                        <option> #5442677 </option>

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
            </form>
        </div>
    </body>
</html>
