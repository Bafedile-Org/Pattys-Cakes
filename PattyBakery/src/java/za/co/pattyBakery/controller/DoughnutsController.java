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
@WebServlet(name = "PersonalPiesController", urlPatterns = {"/doughnuts_control"})
public class DoughnutsController extends BakeryController {

    protected String servletPath;
<<<<<<< HEAD
    protected static List<Order> bakeryOrders = new ArrayList<>();
    protected static String[] bakeryRecipeIds = {"4RES", "5RES", "6RES"};
    protected static String[] bakeryProductIds = {"16PRO", "17PRO", "18PRO"};
    protected static String[] bakeryProductNames = {"16PROName", "17PROName", "18PROName"};
    protected static String[] bakeryProductPrices = {"16PROPrice", "17PROPrice", "18PROPrice"};
    protected static String[] bakeryProductNutrients = {"16PRONu", "17PRONu", "18PRONu"};
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
        bakery_control = request.getServletPath().replace("/", "");
<<<<<<< HEAD
        getAllFromSession(request, response, bakeryCart, orderQuantitiesMap, products, imagesSrc, bakery_control);
        manageOrderAddition(request, response, bakeryOrders, bakeryRecipeIds, bakeryProductIds, bakeryProductNames, bakeryProductPrices, bakeryProductNutrients, totalItemsInCart, bakeryCart, "doughnuts");
        manageCart(request, response, bakeryProductIds, bakeryCart, bakeryOrders, orderQuantitiesMap, orderQuantities, imagesSrc, products);
        manageOrderConfirmation(request, response, bakeryOrders, bakeryRecipeIds, bakeryProductIds, bakeryProductNames, bakeryProductPrices, bakeryProductNutrients, totalItemsInCart, bakeryCart, bakery_control);
        managePayment(request, response, bakeryRecipeIds, bakeryProductIds, bakeryProductNames, bakeryProductPrices, bakeryProductNutrients, totalItemsInCart, bakeryCart, bakeryOrders);
        manageCheckout(request, response, bakeryOrders, bakeryRecipeIds, bakeryProductIds, bakeryProductNames, bakeryProductPrices, bakeryProductNutrients, totalItemsInCart, bakeryCart, bakery_control);
        manageLogin(request, response, bakeryOrders, bakeryRecipeIds, bakeryProductIds, bakeryProductNames, bakeryProductPrices, bakeryProductNutrients, totalItemsInCart, bakeryCart, bakery_control);
        addQuantities(bakeryOrders, bakeryProductIds, orderQuantitiesMap, orderQuantities);
        saveToSession(request, response, bakeryCart, imagesSrc, orderQuantitiesMap, products, bakery_control);
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
//            redirectToPage(request, response, "doughnuts", recipeIds, productIds, productNames, productPrices, productNutrients, totalItemsInCart);
//        } else {
//            if (request.getParameter("cart") == null) {
//                redirectToPage(request, response, "doughnuts", recipeIds, productIds, productNames, productPrices, productNutrients, totalItemsInCart);
//            } else {
//                redirectToCart(request, response, cart, imagesSrc, orderQuantitiesMap, products);
//            }
//        }
//        addQuantities(orders, productIds, orderQuantitiesMap, orderQuantities);
//    }

    @Override
    public void redirectToCart(HttpServletRequest request, HttpServletResponse response, ShoppingCart bakeryCart, String[] imagesSrc, Map<String, Integer> orderQuantitiesMap, Product[] products)
            throws ServletException, IOException {
        saveToSession(request, response, bakeryCart, imagesSrc, orderQuantitiesMap, products, bakery_control);
        session.setAttribute("deliveryAmount", 100.0);
        session.setAttribute("totalAmount", Double.valueOf(String.format("%.2f", bakeryCart == null ? 0.0 : bakeryCart.getTotalprice())));
        String controlName = "cart_control";
        response.sendRedirect(controlName);
=======
        cookies = new ProductServImpl().getAllProductsByCategoryId(3);
        getProductInfo();
        request.setAttribute("products", cookies);
        request.setAttribute("totalInCart", 0);
        request.setAttribute("control", bakery_control);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("cookies");
//        dispatcher.forward(request, response);
//        getAllFromSession(request, response, bakeryCart, orderQuantitiesMap, products, imagesSrc, bakery_control);
        manageOrderAddition(request, response, "doughnuts");
//        manageCart(request, response, bakeryProductIds, bakeryCart, bakeryOrders, orderQuantitiesMap, orderQuantities, imagesSrc, products);
//        manageOrderConfirmation(request, response, bakeryOrders, bakeryRecipeIds, bakeryProductIds, bakeryProductNames, bakeryProductPrices, bakeryProductNutrients, totalItemsInCart, bakeryCart, bakery_control);
//        managePayment(request, response, bakeryRecipeIds, bakeryProductIds, bakeryProductNames, bakeryProductPrices, bakeryProductNutrients, totalItemsInCart, bakeryCart, bakeryOrders);
//        manageCheckout(request, response, bakeryOrders, bakeryRecipeIds, bakeryProductIds, bakeryProductNames, bakeryProductPrices, bakeryProductNutrients, totalItemsInCart, bakeryCart, bakery_control);
//        manageLogin(request, response, bakeryOrders, bakeryRecipeIds, bakeryProductIds, bakeryProductNames, bakeryProductPrices, bakeryProductNutrients, totalItemsInCart, bakeryCart, bakery_control);
//        addQuantities(bakeryOrders, bakeryProductIds, orderQuantitiesMap, orderQuantities);
//        saveToSession(request, response, bakeryCart, imagesSrc, orderQuantitiesMap, products, bakery_control);

>>>>>>> Deekay-dev
    }

    @Override
    public void addOrders(HttpServletRequest request, String param)
            throws ServletException, IOException {
<<<<<<< HEAD
        if (request.getParameter(param).equalsIgnoreCase("16PRO")) {
            imagesSrc[0] = "assets/doughnuts/dougnuts3.jpg";
            bakeryProductId = bakeryProductIds[0];
            products[0] = new ProductServImpl().getProductById(bakeryProductId);
            addOrder(bakeryProductId, orders);

        } else if (request.getParameter(param).equalsIgnoreCase("18PRO")) {
            imagesSrc[1] = "assets/doughnuts/dougnuts2.jpg";
            bakeryProductId = bakeryProductIds[1];
            products[1] = new ProductServImpl().getProductById(bakeryProductId);
            addOrder(bakeryProductId, orders);
        } else if (request.getParameter(param).equalsIgnoreCase("19PRO")) {
            imagesSrc[2] = "assets/doughnuts/dougnuts4.jpg";
            bakeryProductId = bakeryProductIds[2];
            products[2] = new ProductServImpl().getProductById(bakeryProductId);
            addOrder(bakeryProductId, orders);
        }
        bakeryCart = setTotalPrice(bakeryCart, orders);
        totalItemsInCart = bakeryCart.getOrders().size();
        session.setAttribute("totalInCart", totalItemsInCart);
=======
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
