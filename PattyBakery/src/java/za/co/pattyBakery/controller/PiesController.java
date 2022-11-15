package za.co.pattyBakery.controller;

import java.io.IOException;
import java.security.SecureRandom;
import java.time.LocalDate;
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
import za.co.pattyBakery.exception.OrderException;
import za.co.pattyBakery.model.OrderImpl;
import za.co.pattyBakery.model.ShoppingCartImpl;
import za.co.pattyBakery.service.impl.ProductServImpl;

/**
 *
 * @author Dimakatso Sebatane
 */
@WebServlet(name = "PiesController", urlPatterns = {"/pies_control"})
public class PiesController extends BakeryController {

    List<Order> orders;
    String[] recipeIds = {"13RES", "14RES", "15RES"};
    String[] productIds = {"10PRO", "11PRO", "12PRO"};
    String[] strings = {"10PRO", "11PRO", "12PRO"};
    String[] productNames = {"10PROName", "11PROName", "12PROName"};
    String[] productPrices = {"10PROPrice", "11PROPrice", "12PROPrice"};
    String[] productNutrients = {"10PRONu", "11PRONu", "12PRONu"};
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
            redirectToPage(request, response, "pies", recipeIds, productIds, productNames, productPrices, productNutrients, totalItemsInCart);

        } else {
            if (request.getParameter("cart") == null) {
                redirectToPage(request, response, "pies", recipeIds, productIds, productNames, productPrices, productNutrients, totalItemsInCart);
            } else {
                redirectToCart(request, response, cart, imagesSrc, orderQuantitiesMap, products);
            }
        }
        addQuantities(orders, productIds, orderQuantitiesMap, orderQuantities);
    }

    @Override
    public void addOrders(HttpServletRequest request, String param, List<Order> orders) {
        if (request.getParameter(param).equalsIgnoreCase("4PRO")) {
            imagesSrc[0] = "assets/personal_pies/10PRO pies.jpg";
            productId = productIds[0];
            products[0] = new ProductServImpl().getProductById(productId);
            addOrder(productId, orders);

        } else if (request.getParameter(param).equalsIgnoreCase("5PRO")) {
            imagesSrc[1] = "assets/personal_pies/11PRO_pie.jpg";
            productId = productIds[1];
            products[1] = new ProductServImpl().getProductById(productId);
            addOrder(productId, orders);
        } else if (request.getParameter(param).equalsIgnoreCase("6PRO")) {
            imagesSrc[2] = "assets/personal_pies/12PRO pie.jpg";
            productId = productIds[2];
            products[2] = new ProductServImpl().getProductById(productId);
            addOrder(productId, orders);
        }
        cart = setTotalPrice(cart, orders);
        totalItemsInCart = cart.getOrders().size();
        request.setAttribute("totalInCart", totalItemsInCart);
    }

}
