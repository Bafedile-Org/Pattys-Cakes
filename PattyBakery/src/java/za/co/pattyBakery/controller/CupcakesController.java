package za.co.pattyBakery.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.co.pattyBakery.Order;
import za.co.pattyBakery.Product;
import za.co.pattyBakery.ShoppingCart;
import static za.co.pattyBakery.controller.BakeryController.imagesSrc;
import static za.co.pattyBakery.controller.BakeryController.orderQuantities;
import static za.co.pattyBakery.controller.BakeryController.orderQuantitiesMap;
import static za.co.pattyBakery.controller.BakeryController.products;
import static za.co.pattyBakery.controller.BakeryController.totalItemsInCart;
import za.co.pattyBakery.service.impl.ProductServImpl;

/**
 *
 * @author Dimakatso Sebatane
 */
@WebServlet(name = "CupcakesController", urlPatterns = {"/cupcakes_control"})
public class CupcakesController extends BakeryController {

    protected String servletPath;
<<<<<<< HEAD
    protected static List<Order> bakeryOrders = new ArrayList<>();
    protected static String[] bakeryRecipeIds = {"7RES", "8RES", "9RES"};
    protected static String[] bakeryProductIds = {"7PRO", "8PRO", "9PRO"};
    protected static String[] bakeryProductNames = {"7PROName", "8PROName", "9PROName"};
    protected static String[] bakeryProductPrices = {"7PROPrice", "8PROPrice", "9PROPrice"};
    protected static String[] bakeryProductNutrients = {"7PRONu", "8PRONu", "9PRONu"};
    protected static ShoppingCart bakeryCart;
    protected static String bakeryProductId;
    protected static String bakery_control;
=======
    private List<Product> cookies;
    protected static List<Order> bakeryOrders = new ArrayList<>();
    protected static String[] bakeryRecipeIds;
    protected String[] bakeryProductIds;
    protected static ShoppingCart bakeryCart;
    protected static String bakeryProductId;
    protected static String bakery_control;

    public void getProductInfo() {
        bakeryProductIds = new String[cookies.size()];
        bakeryRecipeIds = new String[cookies.size()];
        for (int i = 0; i < bakeryProductIds.length; i++) {
            bakeryProductIds[i] = cookies.get(i).getProductId();
            bakeryRecipeIds[i] = cookies.get(i).getRecipeId();
        }
    }
>>>>>>> Deekay-dev

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
<<<<<<< HEAD

        bakery_control = request.getServletPath().replace("/", "");
        getAllFromSession(request, response, bakeryCart, orderQuantitiesMap, products, imagesSrc, bakery_control);
        manageOrderAddition(request, response, bakeryOrders, bakeryRecipeIds, bakeryProductIds, bakeryProductNames, bakeryProductPrices, bakeryProductNutrients, totalItemsInCart, bakeryCart, "cupcakes");
        manageCart(request, response, bakeryProductIds, bakeryCart, bakeryOrders, orderQuantitiesMap, orderQuantities, imagesSrc, products);
        manageOrderConfirmation(request, response, bakeryOrders, bakeryRecipeIds, bakeryProductIds, bakeryProductNames, bakeryProductPrices, bakeryProductNutrients, totalItemsInCart, bakeryCart, bakery_control);
        managePayment(request, response, bakeryRecipeIds, bakeryProductIds, bakeryProductNames, bakeryProductPrices, bakeryProductNutrients, totalItemsInCart, bakeryCart, bakeryOrders);
        manageCheckout(request, response, bakeryOrders, bakeryRecipeIds, bakeryProductIds, bakeryProductNames, bakeryProductPrices, bakeryProductNutrients, totalItemsInCart, bakeryCart, bakery_control);
        manageLogin(request, response, bakeryOrders, bakeryRecipeIds, bakeryProductIds, bakeryProductNames, bakeryProductPrices, bakeryProductNutrients, totalItemsInCart, bakeryCart, bakery_control);
        addQuantities(bakeryOrders, bakeryProductIds, orderQuantitiesMap, orderQuantities);
        saveToSession(request, response, bakeryCart, imagesSrc, orderQuantitiesMap, products, bakery_control);
=======
        bakery_control = request.getServletPath().replace("/", "");
        cookies = new ProductServImpl().getAllProductsByCategoryId(4);
        getProductInfo();
        request.setAttribute("products", cookies);
        request.setAttribute("totalInCart", 0);
        request.setAttribute("control", bakery_control);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("cookies");
//        dispatcher.forward(request, response);
//        getAllFromSession(request, response, bakeryCart, orderQuantitiesMap, products, imagesSrc, bakery_control);
        manageOrderAddition(request, response, "cupcakes");
//        manageCart(request, response, bakeryProductIds, bakeryCart, bakeryOrders, orderQuantitiesMap, orderQuantities, imagesSrc, products);
//        manageOrderConfirmation(request, response, bakeryOrders, bakeryRecipeIds, bakeryProductIds, bakeryProductNames, bakeryProductPrices, bakeryProductNutrients, totalItemsInCart, bakeryCart, bakery_control);
//        managePayment(request, response, bakeryRecipeIds, bakeryProductIds, bakeryProductNames, bakeryProductPrices, bakeryProductNutrients, totalItemsInCart, bakeryCart, bakeryOrders);
//        manageCheckout(request, response, bakeryOrders, bakeryRecipeIds, bakeryProductIds, bakeryProductNames, bakeryProductPrices, bakeryProductNutrients, totalItemsInCart, bakeryCart, bakery_control);
//        manageLogin(request, response, bakeryOrders, bakeryRecipeIds, bakeryProductIds, bakeryProductNames, bakeryProductPrices, bakeryProductNutrients, totalItemsInCart, bakeryCart, bakery_control);
//        addQuantities(bakeryOrders, bakeryProductIds, orderQuantitiesMap, orderQuantities);
//        saveToSession(request, response, bakeryCart, imagesSrc, orderQuantitiesMap, products, bakery_control);

>>>>>>> Deekay-dev
    }
//    @Override
//    public void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        manageCart(request, response, productIds, cart, orders, orderQuantitiesMap, orderQuantities, imagesSrc, products);
//        if (request.getParameter("index") != null) {
//            totalItemsInCart = 0;
//            productId = null;
//            if (orders != null) {
//                orders.clear();
//            }
//            cart = null;
//        }
//        if (request.getParameter("add") != null) {
//            addOrders(request, "add", orders);
//            redirectToPage(request, response, "cupcakes", recipeIds, productIds, productNames, productPrices, productNutrients, totalItemsInCart);
//        } else {
//            if (request.getParameter("cart") == null) {
//                redirectToPage(request, response, "cupcakes", recipeIds, productIds, productNames, productPrices, productNutrients, totalItemsInCart);
//            } else {
//                redirectToCart(request, response, cart, imagesSrc, orderQuantitiesMap, products);
//            }
//        }
//    }

    @Override
<<<<<<< HEAD
    public void redirectToCart(HttpServletRequest request, HttpServletResponse response, ShoppingCart bakeryCart, String[] imagesSrc, Map<String, Integer> orderQuantitiesMap, Product[] products)
            throws ServletException, IOException {
        saveToSession(request, response, bakeryCart, imagesSrc, orderQuantitiesMap, products, bakery_control);
        session.setAttribute("deliveryAmount", 100.0);
        session.setAttribute("totalAmount", Double.valueOf(String.format("%.2f", bakeryCart == null ? 0.0 : bakeryCart.getTotalprice())));
        String controlName = "cart_control";
        response.sendRedirect(controlName);
    }

    @Override
    public void addOrders(HttpServletRequest request, String param, List<Order> orders)
            throws ServletException, IOException {
        if (request.getParameter(param).equalsIgnoreCase("7PRO")) {
            imagesSrc[0] = "assets/cupcakes/coffeecupcake.jfif";
            bakeryProductId = bakeryProductIds[0];
            products[0] = new ProductServImpl().getProductById(bakeryProductId);
            addOrder(bakeryProductId, orders);

        } else if (request.getParameter(param).equalsIgnoreCase("8PRO")) {
            imagesSrc[1] = "assets/cupcakes/glutten_free_chocolate_cupcakes.jpg";
            bakeryProductId = bakeryProductIds[1];
            products[1] = new ProductServImpl().getProductById(bakeryProductId);
            addOrder(bakeryProductId, orders);
        } else if (request.getParameter(param).equalsIgnoreCase("9PRO")) {
            imagesSrc[2] = "aassets/cupcakes/IMG_3165.webp";
            bakeryProductId = bakeryProductIds[2];
            products[2] = new ProductServImpl().getProductById(bakeryProductId);
            addOrder(bakeryProductId, orders);
        }
        bakeryCart = setTotalPrice(bakeryCart, orders);
        totalItemsInCart = bakeryCart.getOrders().size();
        session.setAttribute("totalInCart", totalItemsInCart);
=======
    public void addOrders(HttpServletRequest request, String param)
            throws ServletException, IOException {
        for (String prodId : bakeryProductIds) {
            if (request.getParameter(param).equalsIgnoreCase(prodId)) {
                addOrder(bakeryOrders, prodId);
            }
        }
        bakeryCart = (ShoppingCart) session.getAttribute("cart");
        totalItemsInCart = bakeryCart.getAllOrders().size();
        addQuantities(bakeryOrders, bakeryProductIds, orderQuantitiesMap, orderQuantities);
        request.setAttribute("totalInCart", totalItemsInCart);

>>>>>>> Deekay-dev
    }

}
