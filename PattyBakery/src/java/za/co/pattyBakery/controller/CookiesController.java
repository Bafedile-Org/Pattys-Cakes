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
@WebServlet(name = "CookiesController", urlPatterns = {"/cookies_control"})
public class CookiesController extends BakeryController {

    /**
     * **
     *
     * Adding to cart does not work fix it
     */
    List<Order> orders;
    String[] recipeIds = {"16RES", "18RES", "17RES"};
    String[] productIds = {"4PRO", "5PRO", "6PRO"};
    String[] productNames = {"4PROName", "5PROName", "6PROName"};
    String[] productPrices = {"4PROPrice", "5PROPrice", "6PROPrice"};
    String[] productNutrients = {"4PRONu", "5PRONu", "6PRONu"};
    Integer totalItemsInCart;
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
            redirectToPage(request, response, "cookies");

        } else {
            if (request.getParameter("cart") == null) {
                redirectToPage(request, response, "cookies");
            } else {
                redirectToCart(request, response);
            }
        }
        addQuantities();

    }

    public void redirectToCart(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("control", "cookies_control");
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
        if (request.getParameter(param).equalsIgnoreCase("4PRO")) {
            imagesSrc[0] = "assets/cookies/cookies_p.jpg";
            productId = productIds[0];
            products[0] = new ProductServImpl().getProductById(productId);
            addOrder(productId);

        } else if (request.getParameter(param).equalsIgnoreCase("5PRO")) {
            imagesSrc[1] = "assets/cookies/cookies_pic1.jpg";
            productId = productIds[1];
            products[1] = new ProductServImpl().getProductById(productId);
            addOrder(productId);
        } else if (request.getParameter(param).equalsIgnoreCase("6PRO")) {
            imagesSrc[2] = "assets/cookies/cokkies_pic2.jpg";
            productId = productIds[2];
            products[2] = new ProductServImpl().getProductById(productId);
            addOrder(productId);
        }
        cart = setTotalPrice();
        totalItemsInCart = cart.getOrders().size();
        request.setAttribute("totalInCart", totalItemsInCart);
    }

}
