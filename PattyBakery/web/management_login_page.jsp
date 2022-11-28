<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!--<link rel="stylesheet" href="css/styles.css">-->
        <link rel="stylesheet" href="css/style.css">
        <link href='https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css' rel='stylesheet'>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Prata">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Pacifico">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <style>
            html, body {
                background-color: #f4f4f4;
            }
            .sf {
                min-height: 400px;
            }
            .text-big,service h1{
                font-size:25px;

            }
            .form-content form{
                margin-top:12%;
            }
            .form-contents form{
                margin-top:8%;
            }

            .container{
                height: 100vh;
                width: 100%;
                display: flex;
                align-items: center;
                justify-content: center;
                background-color: #EAD2E9;
                column-gap: 30px;
            }
            .containers{
                margin-top: 5%;
                height: 100vh;
                width: 100%;
                display: flex;
                align-items: center;
                justify-content: center;
                background-color: #EAD2E9;
                column-gap: 30px;
            }
            .form{
                position: absolute;
                max-width: 430px;
                width: 100%;
                padding: 30px;
                border-radius: 6px;
                background: #FFF;
            }
            .form.signup{
                opacity: 0;
                pointer-events: none;
            }
            .forms.show-signup .form.signup{
                opacity: 1;
                pointer-events: auto;
            }
            .forms.show-signup .form.login{
                opacity: 0;
                pointer-events: none;
            }
            header{
                font-size: 28px;
                font-weight: 600;
                color: #232836;
                text-align: center;
            }
            form{
                margin-top: 30px;
            }
            .form .field{
                position: relative;
                height: 50px;
                width: 100%;
                margin-top: 20px;
                border-radius: 6px;
            }
            .field input,
            .field button{
                height: 100%;
                width: 100%;
                border: none;
                font-size: 16px;
                font-weight: 400;
                border-radius: 6px;
            }
            .field input{
                outline: none;
                padding: 0 15px;
                border: 1px solid#CACACA;
            }
            .field input:focus{
                border-bottom-width: 2px;
            }
            .eye-icon{
                position: absolute;
                top: 50%;
                right: 10px;
                transform: translateY(-50%);
                font-size: 18px;
                color: #8b8b8b;
                cursor: pointer;
                padding: 5px;
            }
            .field button{
                color: #fff;
                background-color: #0171d3;
                transition: all 0.3s ease;
                cursor: pointer;
            }
            .field button:hover{
                background-color: #016dcb;
            }
            .form-link{
                text-align: center;
                margin-top: 10px;
            }
            .form-link span,
            .form-link a{
                font-size: 14px;
                font-weight: 400;
                color: #232836;
            }
            .form a{
                color: #0171d3;
                text-decoration: none;
            }
            .form-content a:hover{
                text-decoration: underline;
            }
            .line{
                position: relative;
                height: 1px;
                width: 100%;
                margin: 36px 0;
                background-color: #d4d4d4;
            }
            .line::before{
                position: absolute;
                top: 50%;
                left: 50%;
                transform: translate(-50%, -50%);
                background-color: #FFF;
                color: #8b8b8b;
                padding: 0 15px;
            }
            .media-options a{
                display: flex;
                align-items: center;
                justify-content: center;
            }

            a.facebook .facebook-icon{
                height: 28px;
                width: 28px;
                color: #0171d3;
                font-size: 20px;
                border-radius: 50%;
                display: flex;
                align-items: center;
                justify-content: center;
                background-color: #fff;
            }
            @media screen and (max-width: 400px) {
                .form{
                    padding: 20px 10px;
                }

            }

        </style>
    </head>
    <body>
        <nav>
            <header>
                <div class="topnav" >
                    <h1 align="center" id='home-header1'>
                        Welcome To Patty's Bakery
                    </h1>
                </div>
            </header>
        </nav>
        <section class="container forms">
            <div class="form login">
                <div class="form-content">
                    <header>Admin Login</header>
                    <form action="/bakery/login_control" method="POST">
                        <div class="field input-field">
                            <input type="email" name='email' placeholder="Email" class="inputbox" required>
                        </div>
                        <div class="field input-field">
                            <input type="password" name='password' placeholder="Password" class="inputbox" required>
                            <i class='bx bx-hide eye-icon'></i>
                        </div>
                        <div class="form-link">
                            <span>Forgot password?<a href="reset">Forgot password</a></span>
                        </div>
                        <div class="field button-field">
                            <button name='admin_login'>Login</button>
                        </div>
                    </form>

                </div>

            </div>
        </section>
    </body>
</html>
