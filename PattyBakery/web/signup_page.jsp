<%-- 
    Document   : signup_page
    Created on : 04 Nov 2022, 12:57:23 PM
    Author     : TRAIN 14
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/style.css">
        <link href='https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css' rel='stylesheet'>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Pacifico">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>
        <nav>
            <div class="topnav" >
                <h1 align="center" id='home-header1'>
                    Welcome To Patty's Bakery   
                    <i class="fa fa-bars dropdown" aria-hidden="true" style="font-size:24px; padding-right: 24px">
                        <div class="dropdown-content">
                            <a href="home">Home</a>
                            <a  href="aboutUs">About Us</a>
                            <a  href="stores">Our Stores</a>
                        </div>
                    </i>
                </h1>
            </div>
        </nav>
        <section class="containers forms">
            <div class="form login">
                <div class="form-content">
                    <header>Signup</header>
                    <form action="#">
                        <div class="field input-field">
                            <input type="name" placeholder="Name" class="name">
                        </div>
                        <div class="field input-field">
                            <input type="surname" placeholder="Surname" class="surname">
                        </div>
                        <div class="field input-field">
                            <input type="iDnumber" placeholder="ID Number" class="iDnumber">
                        </div>
                        <div class="field input-field">
                            <input type="address" placeholder="Address" class="address">
                        </div>
                        <div class="field input-field">
                            <input type="tel" placeholder="Telephone/Cellphone" class="tel">
                        </div>
                        <div class="field input-field">
                            <input type="password" placeholder="Create password" class="password">
                        </div>
                        <div class="field input-field">
                            <input type="password" placeholder="Confirm password" class="password">
                            <i class='bx bx-hide eye-icon'></i>
                        </div>
                        <div class="field button-field">
                            <button>Signup</button>
                        </div>
                    </form>
                    <div class="form-link">
                        <span>Already have an account? <a href="login">Login</a></span>
                    </div>
                </div>
                <div class="line"></div>
            </div>
        </section>
</html>
