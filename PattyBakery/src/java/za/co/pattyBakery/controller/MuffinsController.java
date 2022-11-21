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
@WebServlet(name = "MuffinsController", urlPatterns = {"/muffins_control"})
public class MuffinsController extends BakeryController {

    protected String servletPath;
<<<<<<< HEAD
    protected static List<Order> bakeryOrders = new ArrayList<>();
    protected static String[] bakeryRecipeIds = {"10RES", "11RES", "12RES"};
    protected static String[] bakeryProductIds = {"13PRO", "14PRO", "15PRO"};
    protected static String[] bakeryProductNames = {"13PROName", "14PROName", "15PROName"};
    protected static String[] bakeryProductPrices = {"13PROPrice", "14PROPrice", "15PROPrice"};
    protected static String[] bakeryProductNutrients = {"13PRONu", "14PRONu", "15PRONu"};
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
        manageOrderAddition(request, response, bakeryOrders, bakeryRecipeIds, bakeryProductIds, bakeryProductNames, bakeryProductPrices, bakeryProductNutrients, totalItemsInCart, bakeryCart, "muffins");
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
        String controlName = "cart_control";
        response.sendRedirect(controlName);
    }

    @Override
    public void addOrders(HttpServletRequest request, String param, List<Order> bakeryOrders)
            throws ServletException, IOException {
        if (request.getParameter(param).equalsIgnoreCase("13PRO")) {
            imagesSrc[0] = "assets/muffins/Blueberry-Muffins.jpg";
            bakeryProductId = bakeryProductIds[0];
            products[0] = new ProductServImpl().getProductById(bakeryProductId);
            addOrder(bakeryProductId, bakeryOrders);

        } else if (request.getParameter(param).equalsIgnoreCase("14PRO")) {
            imagesSrc[1] = "assets/muffins/carrot-muffins.jpg";
            bakeryProductId = bakeryProductIds[1];
            products[1] = new ProductServImpl().getProductById(bakeryProductId);
            addOrder(bakeryProductId, bakeryOrders);
        } else if (request.getParameter(param).equalsIgnoreCase("15PRO")) {
            imagesSrc[2] = "assets/muffins/Cranberry-Muffins.jpg";
            bakeryProductId = bakeryProductIds[2];
            products[2] = new ProductServImpl().getProductById(bakeryProductId);
            addOrder(bakeryProductId, bakeryOrders);
        }
        bakeryCart = setTotalPrice(bakeryCart, bakeryOrders);
        totalItemsInCart = bakeryCart.getOrders().size();
        session.setAttribute("totalInCart", totalItemsInCart);
=======
        cookies = new ProductServImpl().getAllProductsByCategoryId(5);
        getProductInfo();
        request.setAttribute("products", cookies);
        request.setAttribute("totalInCart", 0);
        request.setAttribute("control", bakery_control);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("cookies");
//        dispatcher.forward(request, response);
//        getAllFromSession(request, response, bakeryCart, orderQuantitiesMap, products, imagesSrc, bakery_control);
        manageOrderAddition(request, response, "muffins");
//        manageCart(request, response, bakeryProductIds, bakeryCart, bakeryOrders, orderQuantitiesMap, orderQuantities, imagesSrc, products);
//        manageOrderConfirmation(request, response, bakeryOrders, bakeryRecipeIds, bakeryProductIds, bakeryProductNames, bakeryProductPrices, bakeryProductNutrients, totalItemsInCart, bakeryCart, bakery_control);
//        managePayment(request, response, bakeryRecipeIds, bakeryProductIds, bakeryProductNames, bakeryProductPrices, bakeryProductNutrients, totalItemsInCart, bakeryCart, bakeryOrders);
//        manageCheckout(request, response, bakeryOrders, bakeryRecipeIds, bakeryProductIds, bakeryProductNames, bakeryProductPrices, bakeryProductNutrients, totalItemsInCart, bakeryCart, bakery_control);
//        manageLogin(request, response, bakeryOrders, bakeryRecipeIds, bakeryProductIds, bakeryProductNames, bakeryProductPrices, bakeryProductNutrients, totalItemsInCart, bakeryCart, bakery_control);
//        addQuantities(bakeryOrders, bakeryProductIds, orderQuantitiesMap, orderQuantities);
//        saveToSession(request, response, bakeryCart, imagesSrc, orderQuantitiesMap, products, bakery_control);

    }

    @Override
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
