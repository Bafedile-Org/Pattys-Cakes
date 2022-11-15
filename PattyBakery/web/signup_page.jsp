<%--
    Document   : signup_page
    Created on : 04 Nov 2022, 12:57:23 PM
    Author     : Hlawulani
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
    </head>
    <body>
        <nav>
            <div class="top">
                <h1> Welcome to Patty's Bakery</h1>
            </div>
        </nav>
        <section class="containers forms">
            <div class="form login">
                <div class="form-content">
                    <header>Signup</header>
                    <form action="login_control"method="POST">
                        <div class="field input-field">
                            <input type="name" name='name' placeholder="Name" class="inputbox" required>
                        </div>
                        <div class="field input-field">
                            <input type="surname" name='surname' placeholder="Surname" class="inputbox" required>
                        </div>
                        <div class="field input-field">
                            <input type="iDnumber" name='idNum' placeholder="ID Number" maxlength="13" minlength="13" class="inputbox" required>
                        </div>
                        <div class="field input-field">
                            <input type="email" name='email' placeholder="Email" class="inputbox" required>
                        </div>
                        <div class="field input-field">
                            <input type="address" name='address' placeholder="Address" class="inputbox" required>
                        </div>
                        <div class="field input-field">
                            <input type="tel" name='tel' placeholder="Telephone/Cellphone" class="inputbox" required>
                        </div>
                        <div class="field input-field">
                            <input type="password" name= 'password' placeholder="Create password" class="inputbox" required>
                        </div>
                        <div class="field input-field">
                            <input type="password" name='conPassword' placeholder="Confirm password" class="inputbox" required>

                        </div>
                        <div class="field button-field">
                            <button type="submit" name="signup">Signup</button>
                        </div>
                    </form>
                    <div class="form-link">
                        <span>Already have an account? <a href="login" >Login</a></span>
                    </div>
                </div>
                <div class="line"></div>
            </div>
        </section>
</html>