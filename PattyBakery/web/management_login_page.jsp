<%-- 
    Document   : management_login_page
    Created on : 08 Nov 2022, 8:52:15 AM
    Author     : Hlawulani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head class="topnav">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Management login</title>
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
         <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Prata">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Pacifico">
        <script src="js/main.js"></script>
        <style>
        html, body {
          background-color: #E6E6FA;
        }
        .sf {
          min-height: 400px;
        }
      </style>
    </head>
    <body class="home-management">
        <header class="home-head">
        <nav>
            <div class="topnav">
                <h1 align="center" id="home-header1">
                    Welcome to Patty's Bakery Management
                    <i class="fa fa-bars dropdown" aria-hidden="true" style="font-size:24px; padding-right: 24px">
                        <div class="dropdown-content">
                            <a  href="management_page.jsp">Home</a>
                        </div>
                    </i>
                </h1>
            </div>
        </nav>
        </header>
        <div>
            Today's date: <%= (new java.util.Date()).toLocaleString()%>
        </div>
         <section class="container forms">
            <div class="form login">
                <div class="form-content">
                    <header>Login</header>
                    <form action="#">
                        <div class="field input-field">
                            <input type="email" placeholder="Email address" class="inputbox" required>
                        </div>
                        <div class="field input-field">
                            <input type="password" placeholder="Password" class="inputbox" required>
                           <i class='bx bx-hide eye-icon'></i>
                        </div>
                        <div class="form-link">
                            <span>Forgot password?<a href="reset">Forgot passowrd</a></span>
                        </div>
                        <div class="field button-field">
                            <button><span>Login <a href="management_page.jsp"></a></span></button>
                        </div>
                    </form>
                </div>
                <div class="line"></div>
            </div>
            </section>
    </body>
</html>
