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
                 background-image:url("../assets/pexels-mariana-kurnyk-1756062.jpg");;
               background-size:cover;
            }
            .sf {
                min-height: 400px;
            }
            .input-field{
                padding:14px 18px;

            }
            .input-field input, .input-field select{
                height:35px;
            }
        </style>
        <script>
            function getValue() {
                var element = document.getElementById("myList");
                var text = document.getElementById("inputValue");
                text.value = element.options[element.selectedIndex].text;
            }
        </script>
    </head>
    <body>
        <header class="home-head">
        <nav >
             <div align='right'>
            Today's date: <%= (new java.util.Date())%>
        </div>
            <div class="topnav">
                     <a href="/bakery/login_control">Back</a>
                    <h1 align="center" id="home-header1" style="font-size:44px;"> 
                        Employee Management 
                </h1></div>
            </div>
        </nav>
        </header>
        <div class="form-contents" style='margin-top:-20px;padding:12px 12px;'>
            <u>  <h3 align='center'>Add An Employee</h3></u>
            <form action="/bakery/res/bakery_res/addEmployee" method="POST">               
                <div class="input-field" style="text-align: center">
                    <input name='name' type="name" placeholder="Name" class="name" size="50">
                </div>
                <div class="input-field" style="text-align: center">
                    <input name='surname' type="surname" placeholder="Surname" class="surname" size="50">
                </div>
                <div class="input-field" style="text-align: center">
                    <input name='title' id='inputValue' type="title" placeholder="Position" class="tittle" size="31">
                    <select id = "myList" onchange = "getValue()" >
                        <option>Choose Position</option>
                        <option value="Cashier"> Cashier </option>
                        <option value="Supervisor"> Supervisor </option>
                        <option value="Chef"> Chef </option>
                        <option value="Director"> Director </option>
                        <option value="Admnistrator"> Administrator </option>
                    </select>
                </div>
                <div class="input-field" style="text-align: center">
                    <input name='id' type="Number" placeholder="ID Number" class="idNumber" minlength="13" maxlength='13' style='width:365px' required>
                </div>
                <div class="input-field" style="text-align: center">
                    <input  name='tel' type="tel" placeholder="Telephone" class="tel" size="50">
                </div>
                <div class="input-field" style="text-align: center">
                    <input name='email' type="email" placeholder="Email" class="email" size="50" required>
                </div>
                <div class="input-field" style="text-align: center">
                    <input name='address' type="address" placeholder="Address" class="delivaryStatus" size="50">
                </div>
                <div class="input-field" style="text-align: center">
                    <input name='password' type="password" placeholder="Password" class="delivaryStatus" size="50" required>
                </div>

                <div class="btn-group" style="text-align: center">
                    <button type="submit" name="todo" value='add'>Add</button>
                    <button type="submit" name='todo' value='remove'>Remove</button>
                    <button type="submit" name="todo" value='update'>Update</button>
                </div> </form>
        </div>
    </body>
</html>