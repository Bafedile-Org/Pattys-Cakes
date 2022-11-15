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
        manageCart(request, response, productIds, cart, orders, orderQuantitiesMap, orderQuantities, imagesSrc, products);
        if (request.getParameter("index") != null) {
            totalItemsInCart = 0;
            productId = null;
            if (orders != null) {
                orders.clear();
            }
            cart = null;
        }
        if (request.getParameter("add") != null) {
            addOrders(request, "add", orders);
            redirectToPage(request, response, "doughnuts", recipeIds, productIds, productNames, productPrices, productNutrients, totalItemsInCart);
        } else {
            if (request.getParameter("cart") == null) {
                redirectToPage(request, response, "doughnuts", recipeIds, productIds, productNames, productPrices, productNutrients, totalItemsInCart);
            } else {
                redirectToCart(request, response, cart, imagesSrc, orderQuantitiesMap, products);
            }
        }
        addQuantities(orders, productIds, orderQuantitiesMap, orderQuantities);
    }

    @Override
    public void addOrders(HttpServletRequest request, String param, List<Order> orders)
            throws ServletException, IOException {
        if (request.getParameter(param).equalsIgnoreCase("16PRO")) {
            imagesSrc[0] = "assets/doughnuts/dougnuts3.jpg";
            productId = productIds[0];
            products[0] = new ProductServImpl().getProductById(productId);
            addOrder(productId, orders);

        } else if (request.getParameter(param).equalsIgnoreCase("18PRO")) {
            imagesSrc[1] = "assets/doughnuts/dougnuts2.jpg";
            productId = productIds[1];
            products[1] = new ProductServImpl().getProductById(productId);
            addOrder(productId, orders);
        } else if (request.getParameter(param).equalsIgnoreCase("19PRO")) {
            imagesSrc[2] = "assets/doughnuts/dougnuts4.jpg";
            productId = productIds[2];
            products[2] = new ProductServImpl().getProductById(productId);
            addOrder(productId, orders);
        }
        cart = setTotalPrice(cart, orders);
        totalItemsInCart = cart.getOrders().size();
        request.setAttribute("totalInCart", totalItemsInCart);
    }
}
