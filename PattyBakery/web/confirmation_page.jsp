<%-- 
    Document   : confirmation_page
    Created on : 10 Nov 2022, 8:34:57 AM
    Author     : TRAIN 14
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
                        <a href="shoppingCart_page.jsp">Back</a>
                        </div>
                    </i>
                </h1>
            </div>
        </nav>
        <div class="mainscreen">
      <div class="card">
        <div class="leftside">
            <form action="#">
                
                <h2>Categories list: </h2>
                <p> </p>
                <p> </p>
                <p> </p>
                <p> </p>
            </form>
        </div>
        <div class="rightside">
         <form action="#">
            <div class="input-field" style="text-align: center">
                <h2>Total listing </h2>
                <a><button type="submit" class="button">R89-00</button></a>
         </div>
          </form>
            
        </div>
          </div>
            </div>
        <div class="bb">
        <a href="checkOut_page.jsp"><button type="submit" class="button">Confirm order</button></a>
        </div>
    </body>
</html>
