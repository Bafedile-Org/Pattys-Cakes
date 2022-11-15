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
        <style>
            html, body {
                background-color: #f4f4f4;
            }
            .sf {
                min-height: 400px;
            }
        </style>
    </head>
    <body>
        <nav>
            <header>
                <div class="topnav" >
                    <h1 align="center" id='home-header1'>
                        Welcome To Patty's Bakery
                        <i class="fa fa-bars dropdown" aria-hidden="true" style="font-size:24px; padding-right: 24px">
                            <div class="dropdown-content" align="left">
                                <a href="home">Home</a>
                                <a  href="aboutUs">About Us</a>
                                <a  href="stores">Our Stores</a>
                            </div>
                        </i>
                    </h1>
                </div>
            </header>
        </nav>
        <section class="container forms">
            <div class="form login">
                <div class="form-content">
                    <header>Login</header>
                    <form action="cookies_control" method="POST">
                        <div class="field input-field">
                            <input type="email" name='email'placeholder="Email" class="inputbox" required>
                        </div>
                        <div class="field input-field">
                            <input type="password" name='password' placeholder="Password" class="inputbox" required>
                            <i class='bx bx-hide eye-icon'></i>
                        </div>
                        <div class="form-link">
                            <span>Forgot password?<a href="reset">Forgot password</a></span>
                        </div>
                        <div class="field button-field">
                            <button name='login'>Login</button>
                        </div>
                    </form>
                    <div class="form-link">
                        <span>Don't have an account?<a href="signup">Signup</a></span>
                    </div>
                </div>
                <div class="line"></div>
            </div>
        </section>
    </body>
</html>
