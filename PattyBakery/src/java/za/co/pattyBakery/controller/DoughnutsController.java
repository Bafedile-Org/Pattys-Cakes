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
@WebServlet(name = "PersonalPiesController", urlPatterns = {"/doughnuts_control"})
public class DoughnutsController extends BakeryController {

    List<Order> orders = new ArrayList<>();
    String[] recipeIds = {"4RES", "5RES", "6RES"};
    String[] productIds = {"16PRO", "17PRO", "18PRO"};
    //String[] strings = {"glazedLove", "glazed", "chocolate"};
    String[] productNames = {"16PROName", "17PROName", "18PROName"};
    String[] productPrices = {"16PROPrice", "17PROPrice", "18PROPrice"};
    String[] productNutrients = {"16PRONu", "17PRONu", "18PRONu"};
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
            redirectToPage(request, response, "doughnuts");
        } else {
            if (request.getParameter("cart") == null) {
                redirectToPage(request, response, "doughnuts");
            } else {
                redirectToCart(request, response);
            }
        }
        addQuantities();
    }

    public void redirectToCart(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("control", "doughnuts_control");
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
        if (request.getParameter(param).equalsIgnoreCase("16PRO")) {
            imagesSrc[0] = "assets/doughnuts/dougnuts3.jpg";
            productId = productIds[0];
            products[0] = new ProductServImpl().getProductById(productId);
            addOrder(productId);

        } else if (request.getParameter(param).equalsIgnoreCase("18PRO")) {
            imagesSrc[1] = "assets/doughnuts/dougnuts2.jpg";
            productId = productIds[1];
            products[1] = new ProductServImpl().getProductById(productId);
            addOrder(productId);
        } else if (request.getParameter(param).equalsIgnoreCase("19PRO")) {
            imagesSrc[2] = "assets/doughnuts/dougnuts4.jpg";
            productId = productIds[2];
            products[2] = new ProductServImpl().getProductById(productId);
            addOrder(productId);
        }
        cart = setTotalPrice();
        totalItemsInCart = cart.getOrders().size();
        request.setAttribute("totalInCart", totalItemsInCart);
    }
}
