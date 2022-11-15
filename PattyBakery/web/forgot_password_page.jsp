<%-- 
    Document   : forgot_password_page
    Created on : 04 Nov 2022, 1:15:15 PM
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
    <section class="container forms">
        <div class="forgot password form">
            <div class="form-content">
        <h2>Forgot Password?</h2>
            <form action="#">
                <div class="field input-field">
                    <input type="email" placeholder="Email address" class="email">
                </div>
                    <div class="field input-field">
                        <input type="newpassword" placeholder="New Password" class="newpassword" required>
                    </div>
            </form>
        </div>
    <div class="field button-field">
            <button>Reset password</button>
    </div>
        <div class="line"></div>
    </div>
</body>
    </section>
</html>
