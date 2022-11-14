<%-- 
    Document   : personal_pies_page
    Created on : 03 Nov 2022, 2:52:10 PM
    Author     : Hlawulani
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Personal pies</title>
        <link rel='stylesheet' href='css/style.css'>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Pacifico">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" integrity="sha512-9usAa10IRO0HhonpyAIVpjrylPvoDwiPUiKdWk5t3PyolY1cOd4DSE0Ga+ri4AuTroPR5aQvXU9xC6qOPnzFeg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <script src="js/main.js"></script>
    </head>
    <body>
        <header>
            <nav>
                <div class="topnav">
                    <h1>
                        <a href="home"> Patty's Bakery   
                            <i class="fa fa-shopping-cart" style="font-size:24px"> 
                                <%
                                out.println((Integer)request.getAttribute("totalInCart"));
                                %>
                            </i></a>
                    </h1>
                </div>
            </nav>
        </header>
        <h1> 
            <a align="left" href="home" style="color:black;width:5%;">
                <i class="fa fa-arrow-left" aria-hidden="true" style="float:left">
                </i>
            </a>
            <pre align="center"><h1>Personal Pies</h1></pre>

        </h1>
        <div id="label_div">
             <label><strong><%
                String name = (String) request.getAttribute("blueberryName");
                out.println(name);
                    %>
                </strong>
            </label><br>
            <div class="parent">
                <img src='assets/personal_pies/blueberry pies.jpg' alt="cookies">
                <article>
                    <p id="img_list"><strong>Ingredients</strong>
                    <ul>
                        <%
                            List<String> blueberryIngr = (List<String>) request.getAttribute("blueberry");
                            if (blueberryIngr != null) {
                            for (String ingredient : blueberryIngr) {
                                out.println(String.format("<li>%s</li>", ingredient));
                            }
                            }
                        %>
                    </ul>
                    <p id="img_list"><strong>Nutrients</strong>
                    <ul>
                         <%
                            String nutrients = (String) request.getAttribute("blueberryNu");
                            out.println(String.format("<li>%s</li>", nutrients));
                        %>
                    </ul>
                </article>
            </div>
            <div class="price">
                <form method="GET" action="pies_control">
                <button id="b"><%
                    Double price = (Double) request.getAttribute("blueberryPrice");
                    out.println("R" + price);
                    %>
                </button>
                <button id="cart_button" onclick="piesControl()" name="add" value="blueberry">add to cart</button>
                </form>
            </div>
        </div>

                <div id="label_div"><br><br>
             <label><strong><%
                name = (String) request.getAttribute("appleName");
                out.println(name);
                    %>
                </strong>
            </label><br>
            <div class="parent">
                <img src='assets/personal_pies/apple_pie.jpg'>
                <article>
                    <p id="img_list"><strong>Ingredients:</strong>
                    <ul>
                        <%
                            List<String> appleIngr = (List<String>) request.getAttribute("apple");
                        if(appleIngr!=null){    
                            for (String ingredient : appleIngr) {
                                out.println(String.format("<li>%s</li>", ingredient));
                            }
                            }    
                        %>
                    </ul>
                    <p id="img_list"><strong>Nutrients:</strong>
                    <ul>
                        <%
                            nutrients = (String) request.getAttribute("appleNu");
                            out.println(String.format("<li>%s</li>", nutrients));
                        %>
                    </ul>
                </article>
            </div>
            <div class="price">
                <form method="GET" action="pies_control">
                <button id="b"><%
                     price = (Double) request.getAttribute("applePrice");
                    out.println("R" + price);
                    %>
                </button>
                <button id="b1" onclick="piesControl" name="add" value="apple">add to cart</button>
                </form>
            </div>
            </div>

        <div id="label_div">
             <label><strong><%
                 name = (String) request.getAttribute("strawberryName");
                out.println(name);
                    %>
                </strong>
            </label><br>
            <div class="parent">
                <img src='assets/personal_pies/strawberry pie.jpg'>
                <article>
                    <p id="img_list"><strong>Ingredients</strong>
                    <ul>
                         <%
                            List<String> strawberryIngr = (List<String>) request.getAttribute("strawberry");
                         if(strawberryIngr!=null){   
                            for (String ingredient : strawberryIngr) {
                                out.println(String.format("<li>%s</li>", ingredient));
                            }
                             }
                        %>
                    </ul>
                    <p id="img_list"><strong>Nutrients:</strong>
                    <ul>
                        <%
                            nutrients = (String) request.getAttribute("strawberryNu");
                            out.println(String.format("<li>%s</li>", nutrients));
                        %>
                    </ul>
                </article>
            </div>
            <div class="price">
                <form method="GET" action="pies_control">
                <button id="b"><%
                     price = (Double) request.getAttribute("strawberryPrice");
                    out.println("R" + price);
                    %>
                </button>
                <button id="b1" onclick="piesControl()" name="add" value="strawberry" >add to cart</button>
                </form>
            </div>
            </div>
    </body>
</html>
