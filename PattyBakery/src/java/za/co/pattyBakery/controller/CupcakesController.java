package za.co.pattyBakery.controller;

import java.io.IOException;
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
@WebServlet(name = "CupcakesController", urlPatterns = {"/cupcakes_control"})
public class CupcakesController extends BakeryController {

    List<Order> orders;
    String[] recipeIds = {"7RES", "8RES", "9RES"};
    String[] productIds = {"7PRO", "8PRO", "9PRO"};
    //String[] strings = {"walnut", "chocolate", "vanila"};
    String[] productNames = {"7PROName", "8PROName", "9PROName"};
    String[] productPrices = {"7PROPrice", "8PROPrice", "9PROPrice"};
    String[] productNutrients = {"7PRONu", "8PRONu", "9PRONu"};
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
        request.setAttribute("control", "cupcakes_control");
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
        if (request.getParameter(param).equalsIgnoreCase("7PRO")) {
            imagesSrc[0] = "assets/cupcakes/coffeecupcake.jfif";
            productId = productIds[0];
            products[0] = new ProductServImpl().getProductById(productId);
            addOrder(productId);

        } else if (request.getParameter(param).equalsIgnoreCase("8PRO")) {
            imagesSrc[1] = "assets/cupcakes/glutten_free_chocolate_cupcakes.jpg";
            productId = productIds[1];
            products[1] = new ProductServImpl().getProductById(productId);
            addOrder(productId);
        } else if (request.getParameter(param).equalsIgnoreCase("9PRO")) {
            imagesSrc[2] = "aassets/cupcakes/IMG_3165.webp";
            productId = productIds[2];
            products[2] = new ProductServImpl().getProductById(productId);
            addOrder(productId);
        }
        cart = setTotalPrice();
        totalItemsInCart = cart.getOrders().size();
        request.setAttribute("totalInCart", totalItemsInCart);
    }
}
