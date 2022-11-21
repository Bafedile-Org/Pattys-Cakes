package za.co.pattyBakery.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.co.pattyBakery.Order;
import za.co.pattyBakery.Product;
import za.co.pattyBakery.ShoppingCart;

/**
 *
 * @author Dimakatso Sebatane
 */
@WebServlet(name = "CartController", urlPatterns = {"/cart_control"})
public class CartController extends BakeryController {

    protected static String displayMsg = "";
    protected static Integer[] orderQuantities = new Integer[3];
    protected List<String[]> images = new ArrayList<>();
    protected Product[] products;
    List<Order> orders;

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        cart = (ShoppingCart) session.getAttribute("cart");
        orders = cart.getAllOrders();
        getProducts();
        displayMsg = display(products, orderQuantitiesMap, controlsMap);
        request.setAttribute("displayMessage", displayMsg);
        displayMsg = "";
        redirectToPage(request, response, "cart");
    }

    void getProducts() {
        products = new Product[orders.size()];
        int i = 0;
        for (Order order : orders) {
            products[i] = order.getProduct();
            i++;
        }
    }

    String display(Product[] products, Map<String, Integer> quantitiesMap, Map<String, String> controlsMap) {
        String msg = "";
        if (quantitiesMap != null) {
            for (int i = 0; i < products.length; i++) {
                if (products[i] != null) {
                    msg = msg.concat(String.format("<div class='item' id='div'>"
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
                            + "<form  method='POST' id='conForm' name='%s' action='%s'>"
                            + "<button class='plus-btn' type='submit' name='%s' value='%s' data-value='productId'><strong>-</strong>"
                            + "</button>"
                            + "<input id='amountInput' type=label readonly min=1 max=50 value='%d'>"
                            + "<button class='minus-btn' type='submit' name='%s' value='%s'><strong>+</strong></button>"
                            + "</form>"
                            + "</div>"
                            + "R<input type='button' id='price' class='total-price' value='%.2f' name='%.2f'>"
                            + "<div class=”remove” onclick='remove()'>"
                            + "<u style='cursor: pointer'>Remove</u>"
                            + "</div>"
                            + "</div><br>",
                            products[i].getImageName(), products[i].getProductName(), products[i].getCategory(), controlsMap.get(products[i].getProductId()), "sub", products[i].getProductId(), quantitiesMap.get(products[i].getProductId()), "adds",
                            products[i].getProductId(), products[i].getPrice(), products[i].getPrice()));
                }
            }
        }
        return msg;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        session = setSession(request, session);
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        session = setSession(request, session);
        processRequest(request, response);
    }
}
