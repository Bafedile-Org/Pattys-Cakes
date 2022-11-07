<%-- 
    Document   : cupcakes_page
    Created on : Nov 3, 2022, 9:16:34 AM
    Author     : Bridget Bapela
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cupcakes Page</title>
        <link rel = "stylesheet" href="css/style.css">
        <!--<link rel="stylesheet" href="assets/all.css">-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Pacifico">
    </head>
    <body>
        <header>
            <nav>
                <div class="topnav" >
                     <h1>
                        <a href="home"> Patty's Bakery   
                            <i class="fa fa-shopping-cart" style="font-size:24px">0</i></a>
                    </h1>

                </div>

            </nav>
        </header>
        <h1 align="center">Cupcakes </h1>
        <div id="label_div">
            <label><strong>Coffee and Walnut Cupcakes</strong></label><br>
        <div class="parent">
            
                <img src="assets/cupcakes/coffeecupcake.jfif">
            <article>
            <p id="img_list"><strong>Ingredients:</strong>
                <ul>
                        <li>unsalted butter</li>
                        <li>eggs</li>
                        <li>brown sugar</li>
                        <li>self raising flour</li>
                        <li>instant coffee granules</li>
                        <li>walnuts</li>
                        <li>icing sugar</li>
                        <li>sprinkles</li>
                    </ul>
                        <p id="img_list"><strong> Nutrients:</strong>
                        <li>Calories 502</li>
                        <li>Fat 30g</li>
                        <li>Saturated fat 15g</li>
                        <li>Trans fat 1g</li>
                        <li>cholesterol 105mg</li>
                        <li>Carbs 56g</li>
                        <li>Fiber 1g</li>
                        <li>Sugar 43g</li>
                        <li>Sodium 26mg</li>
                        <li>Protein 5g</li>
                    </ul>
            </article>
            </div>  
                <div class="price">
                <button id="b">R45.99</button>  
                <button id="b1"> Add to cart</button>  
            </div>
       <div class="botom">
            <p><i class="fa-solid fa-triangle-exclamation"></i> Contains a lot of dairy </p>
        </div></div>
        <div class="cupcakes_img">

            <div>
                <div class="item_name"> 
                    
                </div>
                <label style="margin-left: 5%;

                       font-size: 25px;
                       border-style: solid"><strong>Gluten Free Chocolate Cupcakes</strong></label><br>
                <img src="assets/cupcakes/glutten_free_chocolate_cupcakes.jpg" alt="cookies" width="500" height="400"> <br> 
            </div>
            <div>
                <ul>
                    <li>Ingredients</li><ul>
                        <li>unsalted butter</li>
                        <li>eggs</li>
                        <li>brown sugar</li>
                        <li>self raising flour</li>
                        <li>instant coffee granules</li>
                        <li>walnuts</li>
                        <li>icing sugar</li>
                        <li>sprinkles</li>
                    </ul>
                    <li>Nutrients</li><ul>
                        <li>Calories 502</li>
                        <li>Fat 30g</li>
                        <li>Saturated fat 15g</li>
                        <li>Trans fat 1g</li>
                        <li>cholesterol 105mg</li>
                        <li>Carbs 56g</li>
                        <li>Fiber 1g</li>
                        <li>Sugar 43g</li>
                        <li>Sodium 26mg</li>
                        <li>Protein 5g</li>
                    </ul>

                </ul>
            </div>  
            <div class="cont">  
                <button id="price-button">R45.99</button>  
                <button id="add-to-cart-button"> Add to cart</button>  
            </div>
        </div>
        <div class="cupcakes_img">

            <div>
                <div class="item_name"> 
                    
                </div>
                 <label style="margin-left: 5%;

                       font-size: 25px;
                       border-style: solid"><strong>Vegan Vanilla Cupcakes</strong></label><br>
                <img src="assets/cupcakes/IMG_3165.webp" alt="cookies" width="500" height="400"> <br> 
            </div>
            <div>
                <ul>
                    <li>Ingredients</li><ul>
                        <li>unsalted butter</li>
                        <li>eggs</li>
                        <li>brown sugar</li>
                        <li>self raising flour</li>
                        <li>instant coffee granules</li>
                        <li>walnuts</li>
                        <li>icing sugar</li>
                        <li>sprinkles</li>
                    </ul>
                    <li>Nutrients</li><ul>
                        <li>Calories 502</li>
                        <li>Fat 30g</li>
                        <li>Saturated fat 15g</li>
                        <li>Trans fat 1g</li>
                        <li>cholesterol 105mg</li>
                        <li>Carbs 56g</li>
                        <li>Fiber 1g</li>
                        <li>Sugar 43g</li>
                        <li>Sodium 26mg</li>
                        <li>Protein 5g</li>
                    </ul>

                </ul>
            </div>  
            <div class="cont">  
                <button id="price-button">R45.99</button>  
                <button id="add-to-cart-button"> Add to cart</button>  
            </div>
        </div>

    </body>
</html>
