package za.co.pattyBakery.controller;

import java.io.IOException;
import java.time.LocalDate;
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
import static za.co.pattyBakery.controller.BakeryController.orderQuantities;
import static za.co.pattyBakery.controller.BakeryController.orderQuantitiesMap;
import static za.co.pattyBakery.controller.BakeryController.products;
import static za.co.pattyBakery.controller.CookiesController.bakeryCart;
import static za.co.pattyBakery.controller.CookiesController.bakeryOrders;
import static za.co.pattyBakery.controller.CookiesController.bakeryProductIds;
import static za.co.pattyBakery.controller.CookiesController.bakery_control;
import za.co.pattyBakery.model.ShoppingCartImpl;
import za.co.pattyBakery.service.impl.OrderServImpl;
import za.co.pattyBakery.service.impl.ProductServImpl;

/**
 *
 * @author Dimakatso Sebatane
 */
@WebServlet(name = "CakesController", urlPatterns = {"/cakes_control"})

public class CakesController extends BakeryController {

    protected static List<Order> bakeryOrders = new ArrayList<>();
    protected static String[] bakeryRecipeIds = {"1RES", "2RES", "3RES"};
    protected static String[] bakeryProductIds = {"1PRO", "2PRO", "3PRO"};
    protected static String[] bakeryProductNames = {"1PROName", "2PROName", "3PROName"};
    protected static String[] bakeryProductPrices = {"1PROPrice", "2PROPrice", "3PROPrice"};
    protected static String[] bakeryProductNutrients = {"1PRONu", "2PRONu", "3PRONu"};
    protected static ShoppingCart bakeryCart;
    protected static String bakeryProductId;
    protected static String bakery_control = "cakes_control";

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getAllFromSession(request, response, bakeryCart, orderQuantitiesMap, products, bakery_control);
        manageOrderAddition(request, response, bakeryOrders, bakeryRecipeIds, bakeryProductIds, bakeryProductNames, bakeryProductPrices, bakeryProductNutrients, totalItemsInCart, bakeryCart, "cakes");
        manageCart(request, response, bakeryProductIds, bakeryCart, bakeryOrders, orderQuantitiesMap, orderQuantities, imagesSrc, products);
        manageOrderConfirmation(request, response, bakeryOrders, bakeryRecipeIds, bakeryProductIds, bakeryProductNames, bakeryProductPrices, bakeryProductNutrients, totalItemsInCart, bakeryCart, bakery_control);
        managePayment(request, response, bakeryRecipeIds, bakeryProductIds, bakeryProductNames, bakeryProductPrices, bakeryProductNutrients, totalItemsInCart, bakeryCart, bakeryOrders);
        manageCheckout(request, response, bakeryOrders, bakeryRecipeIds, bakeryProductIds, bakeryProductNames, bakeryProductPrices, bakeryProductNutrients, totalItemsInCart, bakeryCart, bakery_control);
        manageLogin(request, response, bakeryOrders, bakeryRecipeIds, bakeryProductIds, bakeryProductNames, bakeryProductPrices, bakeryProductNutrients, totalItemsInCart, bakeryCart, bakery_control);
        addQuantities(bakeryOrders, bakeryProductIds, orderQuantitiesMap, orderQuantities);
        saveToSession(request, response, bakeryCart, imagesSrc, orderQuantitiesMap, products, bakery_control);

    }

    @Override
    public void redirectToCart(HttpServletRequest request, HttpServletResponse response, ShoppingCart bakeryCart, String[] imagesSrc, Map<String, Integer> orderQuantitiesMap, Product[] products)
            throws ServletException, IOException {
        saveToSession(request, response, bakeryCart, imagesSrc, orderQuantitiesMap, products, bakery_control);
        session.setAttribute("deliveryAmount", 100.0);
        session.setAttribute("totalAmount", Double.valueOf(String.format("%.2f", bakeryCart == null ? 0.0 : bakeryCart.getTotalprice())));
        RequestDispatcher dispatcher = request.getRequestDispatcher("cart_control");
        dispatcher.forward(request, response);
    }

    @Override
    public void addOrders(HttpServletRequest request, String param, List<Order> orders)
            throws ServletException, IOException {

        // use a switch statement 
        if (request.getParameter(param).equalsIgnoreCase("1PRO")) {
            imagesSrc[0] = "assets/cakes/caramel-cake-5.jpg";
            bakeryProductId = bakeryProductIds[0];
            products[0] = new ProductServImpl().getProductById(bakeryProductId);
            addOrder(bakeryProductId, orders);

        } else if (request.getParameter(param).equalsIgnoreCase("2PRO")) {
            imagesSrc[1] = "assets/cakes/Meringue-Cake.jpg";
            bakeryProductId = bakeryProductIds[1];
            products[1] = new ProductServImpl().getProductById(bakeryProductId);
            addOrder(bakeryProductId, orders);
        } else if (request.getParameter(param).equalsIgnoreCase("3PRO")) {
            imagesSrc[2] = "assets/cakes/cakes_pic.jpg";
            bakeryProductId = bakeryProductIds[2];
            products[2] = new ProductServImpl().getProductById(bakeryProductId);
            addOrder(bakeryProductId, orders);
        }
        bakeryCart = setTotalPrice(bakeryCart, orders);
        totalItemsInCart = bakeryCart.getOrders().size();
        session.setAttribute("totalInCart", totalItemsInCart);
    }

}
