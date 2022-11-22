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
         <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Prata">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <style>
        html, body {
          background-color: #E6E6FA;
        }
        .sf {
          min-height: 400px;
        }
      </style>
    </head>
    <body>
        <nav class="home-head">
            <div class="topnav">
                <h1 align="center" id="home-header1"> Bakery Employee management site
                    <i class="fa fa-bars dropdown" aria-hidden="true" style="font-size:24px; padding-right: 24px">
                        <div class="dropdown-content">
                        <a href="management_page.jsp">Back</a>
                        </div>
                    </i>
                </h1>
            </div>
        </nav>
        <div>
            Today's date: <%= (new java.util.Date()).toLocaleString()%>
        </div>
           <div class="form-content">
             <form action="#">
                <div class="input-field" style="text-align: center">
                    <input type="name" placeholder="Name" class="name" size="50">
                </div>
                <div class="input-field" style="text-align: center">
                    <input type="surname" placeholder="Surname" class="surname" size="50">
                </div>
                <div class="input-field" style="text-align: center">
                 <input type="tittle" placeholder="Tittle" class="tittle" size="34">
                <select id = "myList" onchange = "favTutorial()" >
                <option>Choose Tittle</option>
                <option> Mr </option>
                <option> Ms </option>
                <option> Dr </option>
                <option> Mr </option>
                </select>
                </div>
                <div class="input-field" style="text-align: center">
                    <input type="idNumber" placeholder="ID Number" class="idNumber" size="50">
                </div>
                 <div class="input-field" style="text-align: center">
                    <input type="tel" placeholder="Telephone" class="tel" size="50">
                </div>
                 <div class="input-field" style="text-align: center">
                    <input type="email" placeholder="Email" class="email" size="50">
                </div>
                 <div class="input-field" style="text-align: center">
                    <input type="delivaryStatus" placeholder="Delivary Status" class="delivaryStatus" size="50">
                </div>
             </form>
            <div class="btn-group" style="text-align: center">
            <button>Add</button>
            <button>Remove</button>
            <button>Update</button>
          </div>
        </div>
    </body>
</html>
