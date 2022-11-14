package za.co.pattyBakery.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
import za.co.pattyBakery.service.impl.ProductServImpl;

/**
 *
 * @author Dimakatso Sebatane
 */
@WebServlet(name = "MuffinsController", urlPatterns = {"/muffins_control"})
public class MuffinsController extends BakeryController {

    List<Order> orders = new ArrayList<>();
    String[] recipeIds = {"10RES", "11RES", "12RES"};
    String[] productIds = {"13PRO", "14PRO", "15PRO"};
    // String[] strings = {"blueberry", "cranberry", "carrot"};
    String[] productNames = {"13PROName", "14PROName", "15PROName"};
    String[] productPrices = {"13PROPrice", "14PROPrice", "15PROPrice"};
    String[] productNutrients = {"13PRONu", "14PRONu", "15PRONu"};
    Integer totalItemsInCart = 0;
    ShoppingCart cart;
    String productId = null;
    String[] imagesSrc = new String[3];
    Product[] products = new Product[3];
    Integer[] orderQuantities = new Integer[3];
    Map<String, Integer> orderQuantitiesMap = new HashMap<>();

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        manageCart(request, response);
        if (request.getParameter("index") != null) {
            totalItemsInCart = 0;
            productId = null;
            if (orders != null) {
                orders.clear();
            }
            cart = null;
        }
        if (request.getParameter("add") != null) {
            addOrders(request, "add");
            redirectToPage(request, response, "cupcakes");
        } else {
            if (request.getParameter("cart") == null) {
                redirectToPage(request, response, "cupcakes");
            } else {
                redirectToCart(request, response);
            }
        }
        addQuantities();
    }

    public void redirectToCart(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("control", "muffins_control");
        request.setAttribute("cartItems", cart);
        request.setAttribute("images", imagesSrc);
        request.setAttribute("quantities", orderQuantities);
        request.setAttribute("quantitiesMap", orderQuantitiesMap);
        request.setAttribute("products", products);
        request.setAttribute("deliveryAmount", 100.0);
        request.setAttribute("totalAmount", Double.valueOf(String.format("%.2f", cart == null ? 0.0 : cart.getTotalprice())));
        RequestDispatcher dispatcher = request.getRequestDispatcher("cart");
        dispatcher.forward(request, response);
    }

    public void addOrders(HttpServletRequest request, String param)
            throws ServletException, IOException {
        if (request.getParameter(param).equalsIgnoreCase("13PRO")) {
            imagesSrc[0] = "assets/muffins/Blueberry-Muffins.jpg";
            productId = productIds[0];
            products[0] = new ProductServImpl().getProductById(productId);
            addOrder(productId);

        } else if (request.getParameter(param).equalsIgnoreCase("14PRO")) {
            imagesSrc[1] = "assets/muffins/carrot-muffins.jpg";
            productId = productIds[1];
            products[1] = new ProductServImpl().getProductById(productId);
            addOrder(productId);
        } else if (request.getParameter(param).equalsIgnoreCase("15PRO")) {
            imagesSrc[2] = "assets/muffins/Cranberry-Muffins.jpg";
            productId = productIds[2];
            products[2] = new ProductServImpl().getProductById(productId);
            addOrder(productId);
        }
        cart = setTotalPrice();
        totalItemsInCart = cart.getOrders().size();
        request.setAttribute("totalInCart", totalItemsInCart);
    }
}
