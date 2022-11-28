<%--
    Document   : nutrient_page
    Created on : Nov 28, 2022, 9:25:26 AM
    Author     : Bridget Bapela
--%>

<%@page import="za.co.pattyBakery.service.impl.NutrientsServImpl"%>
<%@page import="java.util.Collections"%>
<%@page import="za.co.pattyBakery.service.impl.ProductServImpl"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!--<link rel="stylesheet" href="css/style.css">-->
        <link href='https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css' rel='stylesheet'>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Pacifico">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <style>
            body {
                background-image:url("../assets/pexels-mariana-kurnyk-1756062.jpg");
                background-size:cover;
            }
            .sf {
                min-height: 400px;
            }
            .input-field input, .input-field select{
                height:35px;
            }
            .input-field{
                padding:14px 18px;

            }
        </style>
        <script >
            function getDropValue(myList, inputValue) {
                var element = document.getElementById(myList);
                var text = document.getElementById(inputValue);
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
                        Nutrients Management Page
                    </h1></div>
                </div>
            </nav>
        </header>
        <div class="form-content" style='margin-top:-20px;padding:12px 12px;'>
            <u><h3 align='center'>Add or Delete Nutrient</h3></u>
            <form action="/bakery/res/bakery_res/addNutrient" method="POST">
                <div class="input-field" style="text-align: center">
                    <input  id="inputValue" type="nutrientId" name="nutrient" placeholder="Nutrient" class="nutr_Id" size="33" value="" required>
                    <select id = "myList" onchange = "getDropValue('myList', 'inputValue')"  >
                        <option>Select Nutrient</option>
                        <%
                            List<String> nutrient = new NutrientsServImpl().getAllNutrients();
                            Collections.sort(nutrient);
                            for (String nutrients : nutrient) {
                                out.println(String.format("<option value='%s'>%s</option>", nutrient, nutrients));
                            }

                        %>
                    </select>
                </div>
                <div class="btn-group" style="text-align: center">
                    <button type='submit' name="which" value="add">Add</button>
                    <button type='submit' name='which' value='remove'>Remove</button>
                    <!--<button type='submit' name="which" value="update">Update</button>-->
                </div>
            </form>
        </div>
    </body>
</html>
