<%-- 
    Document   : shoppingCart_page
    Created on : Nov 8, 2022, 10:40:42 AM
    Author     : Bridget Bapela
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <link rel="stylesheet" href="css/styles1.css">
         <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
          <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Pacifico">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping Cart Page</title>
         <div class=”Cart-Container”></div>
     <div class=”Header”>
         <h5 class=”Action” align="right"><button> Remove all</button></h5>
         <h1 align="center">
                        <a href="home"> Patty's Bakery</a>
                    </h1>
     <h3 class=”Heading” align="left">Shopping Cart</h3>
    
     </div>
    </head>
    <body>    
     <header>
            <nav>
                <div>
 <!-- Product #1 -->
  <div class="item">
    <div class="buttons">
      <span class="delete-btn"></span>
      <span class="like-btn"></span>
    </div>
 
    <div class="image">
      <img src="assets/cupcakes/coffeecupcake.jfif" alt="cookies" width="250" height="150" />
    </div>
 
    <div class="description">
      <span>Coffee and Walnut Cupcakes</span>
    </div>
 
    <div class="quantity">
      <button class="plus-btn" type="button" name="button"><strong>-</strong>
      </button>
      <input type="text" name="name" value="1">
      <button class="minus-btn" type="button" name="button"><strong>+</strong>
      </button>
    </div>
 
    <div class="total-price">R38.99</div>
  </div><br>
 
  <!-- Product #2 -->
  <div class="item">
    <div class="buttons">
      <span class="delete-btn"></span>
      <span class="like-btn"></span>
    </div>
 
    <div class="image">
      <img src="assets/doughnuts/dougnuts3.jpg" alt="cookies" width="250" height="150"/>
    </div>
 
    <div class="description">
      <span>Glazed Simpsons Doughnuts</span>
    </div>
 
    <div class="quantity">
        <button class="plus-btn" type="button" name="button"><strong>-</strong>
      </button>
      <input type="text" name="name" value="1">
      <button class="minus-btn" type="button" name="button"><strong>+</strong>
      </button>
    </div>
 
    <div class="total-price">R55.00</div>
  </div><br>
 
  <!-- Product #3 -->
  <div class="item">
    <div class="buttons">
      <span class="delete-btn"></span>
      <span class="like-btn"></span>
    </div>
 
    <div class="image">
      <img src="assets/cakes/caramel-cake-5.jpg" alt="cake" width="250" height="150"/>
    </div>
 
    <div class="description">
      <span>Salted Caramel Cake</span>
    </div>
 
    <div class="quantity">
        <button class="plus-btn" type="button" name="button"><strong>-</strong>
      </button>
      <input type="text" name="name" value="1">
      <button class="minus-btn" type="button" name="button"><strong>-</strong>
      </button>
    </div>
 
    <div class="total-price">R589.99</div>
  </div><br>
  
                </div>
                <div class="checkout" lign="cenetr">
                    <label>Delivery : R100</label><br>
  <label>Total Amount : R785</label>
  <p>Click <button>Here</button> to proceed to checkout.</p>
</div>
            </nav>
        </header>
    </body>
</html>
