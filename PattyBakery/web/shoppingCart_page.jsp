<%-- 
    Document   : shoppingCart_page
    Created on : Nov 8, 2022, 10:40:42 AM
    Author     : Bridget Bapela
--%>

<%@page import="za.co.pattyBakery.Product"%>
<%@page contentType='text/html' pageEncoding='UTF-8'%>
<!DOCTYPE html>
<html>
    <head>
        <link rel='stylesheet' href='css/styles1.css'>
        <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>
        <link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Pacifico'>
        <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
        <title>Shopping Cart Page</title>
    <div class=”Cart-Container”></div>
    <div class=”Header”>
        <h5 class=”Action” align='right' onclick='removeAll()'><button> Remove all</button></h5>
        <h1 align='center'>
            <a href='home'> Patty's Bakery</a>
        </h1>
        <h3 class=”Heading” align='left'>Shopping Cart</h3>

    </div>
</head>
<body>    
    <header>
        <nav>
            <div id='all'>
                <!-- Product #1 -->
                <%
                    String[] images = (String[]) request.getAttribute("images");
                    Product[] products = (Product[]) request.getAttribute("products");
                    if (images != null) {
                        for (int i = 0; i < images.length; i++) {
                            out.println(String.format("<div class='item' id='div1'>"
                                    + "<div class='buttons'>"
                                    + "<span class='delete-btn'>"
                                    + "</span><span class='like-btn'></span>"
                                    + "</div>"
                                    + "<div class='image'>"
                                    + "<img src='%s' alt='cookies' width='250' height='150' />"
                                    + "</div>"
                                    + "<div class='description'><span>%s</span>"
                                    + "</div>"
                                    + "<div class='quantity'><script src='js/cartCode.js'></script> "
                                    + "<button class='plus-btn' type='button' name='button' onclick='decrement()'><strong>-</strong>"
                                    + "</button>"
                                    + "<input id='amountInput' type=number min=1 max=50 value='1'>"
                                    + "<button class='minus-btn' type='button' name='button' onclick='increment()'><strong>+</strong></button>"
                                    + "</div>"
                                    + "R<input type='button' id='firstPrice' class='total-price' value='%.2f' name='%.2f'>"
                                    + "<div class=”remove” onclick='remove2()'>"
                                    + "<u style='cursor: pointer'>Remove</u>"
                                    + "</div>"
                                    + "</div><br>",
                                    images[i], products[i].getProductName(), products[i].getPrice(), products[i].getPrice()));
                        }
                    }
                %>

                <script>
                    function increment() {
                        document.getElementById('amountInput').stepUp();
                        multiply2();
                    }
                    function decrement() {
                        multiply2();
                        document.getElementById('amountInput').stepDown();
                    }
                </script>



                <script>
                    function remove2() {
                        document.getElementById('div1').style.display = 'none';

                    }
                </script>
                <script>
                    function multiply2() {

                        a = Number(document.getElementById('amountInput').value);
                        b = Number(document.getElementById('firstPrice').name);
                        c = a * b;
                        document.getElementById('firstPrice').value = c.toFixed(2);
                        totalAmount();
                        totalAmountDue();
                    }
                </script>

                        <script>
                            function increment1() {
                                document.getElementById('amountInput1').stepUp();
                                multiply1();
                            }
                            function decrement1() {
                                multiply1();
                                document.getElementById('amountInput1').stepDown();
                            }
                        </script>
            
                    <script>
                        function remove1() {
                            document.getElementById('div2').style.display = 'none';

                        }
                    </script>
                    <script>
                        function multiply1() {

                            a = Number(document.getElementById('amountInput1').value);
                            b = Number(document.getElementById('secondPrice').name);
                            c = a * b;
                            document.getElementById('secondPrice').value = c.toFixed(2);
                            totalAmount();
                            totalAmountDue();
                        }
                    </script>              
             
                        <script>
                            function increment3() {
                                document.getElementById('amountInput2').stepUp();
                                multiply();
                            }
                            function decrement3() {
                                multiply();
                                document.getElementById('amountInput2').stepDown();
                            }
                        </script>
              
                    <script>
                        function multiply() {

                            a = Number(document.getElementById('amountInput2').value);
                            b = Number(document.getElementById('thirdPrice').name);
                            c = a * b;
                            document.getElementById('thirdPrice').value = c.toFixed(2);
                            totalAmount();
                            totalAmountDue();
                        }
                    </script>
           

            <script>
                function removeAll() {
                    document.getElementById('all').style.display = 'none';

                }
                function remove() {
                    document.getElementById('div3').style.display = 'none';

                }
            </script>
            <script>
                function totalAmount() {
                    a = Number(document.getElementById('thirdPrice').value);
                    b = Number(document.getElementById('secondPrice').value);
                    c = Number(document.getElementById('firstPrice').value);
                    total = a + b + c;
                    document.getElementById('totalAmount').value = total.toFixed(2);
                    total += 100;
                    document.getElementById('totalAmountDue').value = total.toFixed(2);
                }
            </script>
            <div class='checkout' lign='cenetr'>
                Total Amount :R<input type='button' id='totalAmount' value='0'><br>
                <label>Delivery : R100</label><br>
                Total Amount Due :R<input type='button' id='totalAmountDue' value='0'>
                <p>Click <button>Here</button> to proceed to checkout.</p>
            </div>
        </nav>
    </header>
</body>
</html>
