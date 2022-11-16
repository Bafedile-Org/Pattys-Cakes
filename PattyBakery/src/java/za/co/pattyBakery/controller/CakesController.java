package za.co.pattyBakery.controller;

import java.io.IOException;
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
import za.co.pattyBakery.model.ShoppingCartImpl;
import za.co.pattyBakery.service.impl.OrderServImpl;
import za.co.pattyBakery.service.impl.ProductServImpl;

/**
 *
 * @author Dimakatso Sebatane
 */
@WebServlet(name = "CakesController", urlPatterns = {"/cakes_control"})

public class CakesController extends BakeryController {

    List<Order> orders = new ArrayList<>();
    String[] recipeIds = {"1RES", "2RES", "3RES"};
    String[] productIds = {"1PRO", "2PRO", "3PRO"};
    String[] productNames = {"1PROName", "2PROName", "3PROName"};
    String[] productPrices = {"1PROPrice", "2PROPrice", "3PROPrice"};
    String[] productNutrients = {"1PRONu", "2PRONu", "3PRONu"};
    Integer totalItemsInCart = 0;
    ShoppingCart cart = null;
    String productId = null;
    String[] imagesSrc = new String[3];
    Product[] products = new Product[3];
    Integer[] orderQuantities = new Integer[3];
    Map<String, Integer> orderQuantitiesMap = new HashMap<>();
    OrderServImpl orderServImpl;

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("pay") != null) {
            orderServImpl = new OrderServImpl();
            if (cart != null) {
                orderServImpl.addOrder(cart);
            }
            orders = new ArrayList<>();
            cart = new ShoppingCartImpl(orders, null, LocalDate.now());
            totalItemsInCart = 0;
        }
        if (request.getParameter("confirmOrder") != null) {
            request.setAttribute("control", "cakes_control");
            redirectToPage(request, response, "check-out", recipeIds, productIds, productNames, productPrices, productNutrients, totalItemsInCart);
        }
        manageLogin(request, response, recipeIds, productIds, productNames, productPrices, productNutrients, totalItemsInCart, cart);
        setIndexPage(request, totalItemsInCart, productId, orders, cart);
        if (request.getParameter("checkout") != null) {
            request.setAttribute("control", "cakes_control");
            request.setAttribute("shoppingCart", cart);
            redirectToPage(request, response, "login", recipeIds, productIds, productNames, productPrices, productNutrients, totalItemsInCart);
        }
        manageCart(request, response, productIds, cart, orders, orderQuantitiesMap, orderQuantities, imagesSrc, products);
        if (request.getParameter("add") != null) {
            addOrders(request, "add", orders);
            redirectToPage(request, response, "cakes", recipeIds, productIds, productNames, productPrices, productNutrients, totalItemsInCart);

        } else {
            if (request.getParameter("cart") == null) {
                redirectToPage(request, response, "cakes", recipeIds, productIds, productNames, productPrices, productNutrients, totalItemsInCart);

            } else {
                redirectToCart(request, response, cart, imagesSrc, orderQuantitiesMap, products);
            }
        }
        addQuantities(orders, productIds, orderQuantitiesMap, orderQuantities);

    }

    @Override
    public void redirectToCart(HttpServletRequest request, HttpServletResponse response, ShoppingCart cart, String[] imagesSrc, Map<String, Integer> orderQuantitiesMap, Product[] products)
            throws ServletException, IOException {
        request.setAttribute("control", "cakes_control");
        request.setAttribute("cartItems", cart);
        request.setAttribute("images", imagesSrc);
        request.setAttribute("quantitiesMap", orderQuantitiesMap);
        request.setAttribute("products", products);
        request.setAttribute("shoppingCart", cart);
        request.setAttribute("deliveryAmount", 100.0);
        request.setAttribute("totalAmount", Double.valueOf(String.format("%.2f", cart == null ? 0.0 : cart.getTotalprice())));
        RequestDispatcher dispatcher = request.getRequestDispatcher("cart");
        dispatcher.forward(request, response);
    }

    @Override
    public void addOrders(HttpServletRequest request, String param, List<Order> orders)
            throws ServletException, IOException {
        if (request.getParameter(param).equalsIgnoreCase("1PRO")) {
            imagesSrc[0] = "assets/cakes/caramel-cake-5.jpg";
            productId = productIds[0];
            products[0] = new ProductServImpl().getProductById(productId);
            addOrder(productId, orders);

        } else if (request.getParameter(param).equalsIgnoreCase("2PRO")) {
            imagesSrc[1] = "assets/cakes/Meringue-Cake.jpg";
            productId = productIds[1];
            products[1] = new ProductServImpl().getProductById(productId);
            addOrder(productId, orders);
        } else if (request.getParameter(param).equalsIgnoreCase("3PRO")) {
            imagesSrc[2] = "assets/cakes/cakes_pic.jpg";
            productId = productIds[2];
            products[2] = new ProductServImpl().getProductById(productId);
            addOrder(productId, orders);
        }
        cart = setTotalPrice(cart, orders);
        totalItemsInCart = cart.getOrders().size();
        request.setAttribute("totalInCart", totalItemsInCart);
    }

}
