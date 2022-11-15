<%-- 
    Document   : doughnuts_page
    Created on : 03 Nov 2022, 3:04:02 PM
    Author     : Dimakatso Sebatane
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cookies Page</title>
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Pacifico">

    </head>
     <body class="home-body1">
          <header class="home-head">
            <nav>
                <div class="topnav" align="center">
                    <h1>
                        <a href="home"> Patty's Bakery   
                            <i class="fa fa-shopping-cart" style="font-size:24px">
                                <%
                                out.println((Integer)request.getAttribute("totalInCart"));
                                %></i></a>
                    </h1>
                </div>
            </nav>
        </header>

         <h1> 
            <a align="left" href="home" style="color:black;width:5%;">
               <i class="fa fa-arrow-left" aria-hidden="true" style="float:left">
                </i>
            </a>
            <pre align="center"><h1>Doughnuts</h1></pre>

        </h1>

        <div class="images-container">
            <div class="cookies_img" >

                <div align='center'>
                    <label id='cookie_label'><strong><%
                        String name = (String) request.getAttribute("glazedLoveName");
                        out.println(name);
                            %></strong>
                    </label>
                    <br>
                    <img src="assets/doughnuts/dougnuts3.jpg" alt="cookies" >
                </div>
                <div>
                    <article>
                        <ul>
                            <li  id='img_list'><strong>Ingredients</strong>
                                <ul>
                                    <%
                                        List<String> ingr = (List<String>) request.getAttribute("glazedLove");
                                       if (ingr != null) { 
                                        for (String ingredient : ingr) {
                                            out.println(String.format("<li>%s</li>", ingredient));
                                        }
                                       }
                                    %>
                                </ul>
                            </li>
                            <li  id='img_list'><strong>Nutrients</strong>
                                <ul>
                                    <%
                                        String nutrients = (String) request.getAttribute("glazedLoveNu");
                                        out.println(String.format("<li>%s</li>", nutrients));
                                    %>
                                </ul>
                            </li>
                        </ul>
                    </article>
                </div>

            </div>
            <div id='img_price'>
                <form method="GET" action="doughnuts_control">
                <button id='price_button'> 
                    <%Double price = (Double) request.getAttribute("glazedLovePrice");
                        out.println("R" + price);
                    %>
                </button>
                <button id='cart_button' onclick="doughnutsControl()" name="add" value="glazedLove">add to cart</button>
                </form>
            </div>
        </div><br><br>
        <div class="images-container">
            <div class="cookies_img" >

                <div align='center'>
                    <label id='cookie_label'><strong><%
                        name = (String) request.getAttribute("glazedName");
                        out.println(name);
                            %></strong></label>
                    <br>
                    <img src="assets/doughnuts/dougnuts2.jpg" alt="cookies" >
                </div>
                <div>
                    <article>
                        <ul>
                            <li  id='img_list'><strong>Ingredients</strong>
                                <ul>
                                    <%
                                        ingr = (List<String>) request.getAttribute("glazed");
                                        if (ingr != null) {  
                                        for (String ingredient : ingr) {
                                            out.println(String.format("<li>%s</li>", ingredient));
                                        }
                                        }
                                    %>
                                </ul>
                            </li>
                            <li  id='img_list'><strong>Nutrients</strong>
                                <ul>
                                    <%
                                        nutrients = (String) request.getAttribute("glazedNu");
                                        out.println(String.format("<li>%s</li>", nutrients));
                                    %>
                                </ul>
                            </li>
                        </ul>
                    </article>
                </div>

            </div>
            <div id='img_price'>
                <form method="GET" action="doughnuts_control">
                <button id='price_button'> 
                    <% price = (Double) request.getAttribute("glazedPrice");
                        out.println("R" + price);
                    %>
                </button>
                <button id='cart_button' onclick="doughnutsControl()" name="add" value="glazed">add to cart</button>
                </form>
            </div>
        </div>
        <div class="images-container">
            <div class="cookies_img" >

                <div align='center'>
                    <label id='cookie_label'><strong><%
                        name = (String) request.getAttribute("chocolateName");
                        out.println(name);
                            %></strong></label>
                    <br>
                    <img src="assets/doughnuts/dougnuts4.jpg" alt="cookies" >
                </div>
                <div>
                    <article>
                        <ul>
                            <li  id='img_list'><strong>Ingredients</strong>
                                <ul>
                                    <%
                                        ingr = (List<String>) request.getAttribute("chocolate");
                                       if (ingr != null) {
                                        for (String ingredient : ingr) {
                                            out.println(String.format("<li>%s</li>", ingredient));
                                        }
                                       }  
                                    %>
                                </ul>
                            </li>
                            <li  id='img_list'><strong>Nutrients</strong>
                                <ul>
                                    <%
                                        nutrients = (String) request.getAttribute("chocolateNu");
                                        out.println(String.format("<li>%s</li>", nutrients));
                                    %>
                                </ul>
                            </li>
                        </ul>
                    </article>
                </div>

            </div>
            <div id='img_price'>
              <form method="GET" action="doughnuts_control">  
                <button id='price_button'> 
                    <% price = (Double) request.getAttribute("chocolatePrice");
                        out.println("R" + price);
                    %>
                </button>
                <button id='cart_button' onclick="doughnutsControl()" name="add" value="chocolate">add to cart</button>
              </form>
            </div>
          </div>
    </body>
</html>

