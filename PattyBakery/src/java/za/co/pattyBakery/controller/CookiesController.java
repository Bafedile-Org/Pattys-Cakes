package za.co.pattyBakery.controller;

import java.io.IOException;
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
    protected String servletPath;
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

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        bakery_control = request.getServletPath().replace("/", "");
        cookies = new ProductServImpl().getAllProductsByCategoryId(1);
        getProductInfo();
        request.setAttribute("products", cookies);
        request.setAttribute("totalInCart", 0);
        request.setAttribute("control", bakery_control);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("cookies");
//        dispatcher.forward(request, response);
//        getAllFromSession(request, response, bakeryCart, orderQuantitiesMap, products, imagesSrc, bakery_control);
        manageOrderAddition(request, response, "cookies");
//        manageCart(request, response, bakeryProductIds, bakeryCart, bakeryOrders, orderQuantitiesMap, orderQuantities, imagesSrc, products);
//        manageOrderConfirmation(request, response, bakeryOrders, bakeryRecipeIds, bakeryProductIds, bakeryProductNames, bakeryProductPrices, bakeryProductNutrients, totalItemsInCart, bakeryCart, bakery_control);
//        managePayment(request, response, bakeryRecipeIds, bakeryProductIds, bakeryProductNames, bakeryProductPrices, bakeryProductNutrients, totalItemsInCart, bakeryCart, bakeryOrders);
//        manageCheckout(request, response, bakeryOrders, bakeryRecipeIds, bakeryProductIds, bakeryProductNames, bakeryProductPrices, bakeryProductNutrients, totalItemsInCart, bakeryCart, bakery_control);
//        manageLogin(request, response, bakeryOrders, bakeryRecipeIds, bakeryProductIds, bakeryProductNames, bakeryProductPrices, bakeryProductNutrients, totalItemsInCart, bakeryCart, bakery_control);
//        addQuantities(bakeryOrders, bakeryProductIds, orderQuantitiesMap, orderQuantities);
//        saveToSession(request, response, bakeryCart, imagesSrc, orderQuantitiesMap, products, bakery_control);

    }

    @Override
    public void redirectToCart(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        saveToSession(request, response, bakeryCart, imagesSrc, orderQuantitiesMap, products, bakery_control);
        session.setAttribute("deliveryAmount", 100.0);
        session.setAttribute("totalAmount", Double.valueOf(String.format("%.2f", bakeryCart == null ? 0.0 : bakeryCart.getTotalprice())));
        response.sendRedirect("cart_control");
    }

    @Override
    public void addOrders(HttpServletRequest request, String param)
            throws ServletException, IOException {
        if (request.getParameter(param).equalsIgnoreCase("4PRO")) {
            imagesSrc[0] = "assets/cookies/cookies_p.jpg";
            bakeryProductId = bakeryProductIds[0];
            products[0] = new ProductServImpl().getProductById(bakeryProductId);
            addOrder(bakeryProductId);

        } else if (request.getParameter(param).equalsIgnoreCase("5PRO")) {
            imagesSrc[1] = "assets/cookies/cookies_pic1.jpg";
            bakeryProductId = bakeryProductIds[1];
            products[1] = new ProductServImpl().getProductById(bakeryProductId);
            addOrder(bakeryProductId);
        } else if (request.getParameter(param).equalsIgnoreCase("6PRO")) {
            imagesSrc[2] = "assets/cookies/cokkies_pic2.jpg";
            bakeryProductId = bakeryProductIds[2];
            products[2] = new ProductServImpl().getProductById(bakeryProductId);
            addOrder(bakeryProductId);
        }
        bakeryCart = setTotalPrice(bakeryCart, orders);
        totalItemsInCart = bakeryCart.getOrders().size();
        session.setAttribute("totalInCart", totalItemsInCart);
    }

}
