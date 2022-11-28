<%--
    Document   : stock_page
    Created on : 08 Nov 2022, 10:42:18 AM
    Author     : Bridget Bapela
--%>

<%@page import="za.co.pattyBakery.service.impl.IngredientsServImpl"%>
<%@page import="za.co.pattyBakery.service.impl.NutrientsServImpl"%>
<%@page import="za.co.pattyBakery.model.Recipe"%>
<%@page import="za.co.pattyBakery.service.impl.RecipeServImpl"%>
<%@page import="java.util.Collections"%>
<%@page import="za.co.pattyBakery.service.impl.CategoryServImpl"%>
<%@page import="za.co.pattyBakery.service.impl.ProductServImpl"%>
<%@page import="za.co.pattyBakery.Product"%>
<%@page import="za.co.pattyBakery.dao.impl.ProductDAOImpl"%>
<%@page import="java.util.List"%>
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
                        Recipe management
                    </h1></div>
            </nav>
        </header>
        <div class="form-content" style='margin-top:-20px;padding:12px 12px;'>
            <u><h3 align='center'>Add, Update Or Remove Recipe</h3></u>
            <form action="/bakery/res/bakery_res/addRecipe" method="POST">
                <div class="input-field" style="text-align: center">
                    <input  id="inputValue3" type="text" name="recipe" placeholder="Product Recipe" class="productId" size="30" value="" >
                    <select id = "myList3" onchange = "getDropValue('myList3', 'inputValue3')"  style='width:110px'>
                        <option style='width:50px'>Select Recipe</option>
                        <%                            List<Recipe> recipies = new RecipeServImpl().getRecipies();
                            for (Recipe recipe : recipies) {
                                out.println(String.format("<option value='%s' style='width:50px'>%s</option>", recipe.getDescription(), recipe.getDescription()));
                            }

                        %>
                    </select>
                </div>
                <div class="input-field" style="text-align: center">
                    <p style='color:black;'><b>Hold down Ctrl to select multiple ingredients</b></p>
                    <select id = "myList4" onchange = "getDropValue('myList4', 'inputValue4')" multiple style='width:360px;height:150px' name='ingredients' >
                        <option>Select Nutrients</option>
                        <%                            List<String> ingredients = new IngredientsServImpl().getAllIngredient();
                            for (String ingredient : ingredients) {
                                out.println(String.format("<option value='%s'>%s</option>", ingredient, ingredient));
                            }

                        %>
                    </select>
                </div>



                <div class="btn-group" style="text-align: center">
                    <button type='submit' name="which" value="add">Add</button>
                    <!--<button type='submit' name='which' value='remove'>Remove</button>-->
                    <button type='submit' name="which" value="update">Update</button>
                </div>
            </form>
        </div>
    </body>
</html>
