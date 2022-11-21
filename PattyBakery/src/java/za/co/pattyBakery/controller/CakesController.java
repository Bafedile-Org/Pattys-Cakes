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
import static za.co.pattyBakery.controller.BakeryController.orderQuantities;
import static za.co.pattyBakery.controller.BakeryController.orderQuantitiesMap;
import static za.co.pattyBakery.controller.BakeryController.products;
import static za.co.pattyBakery.controller.CookiesController.bakeryOrders;
import static za.co.pattyBakery.controller.CookiesController.bakeryRecipeIds;
import static za.co.pattyBakery.controller.CookiesController.bakery_control;
import za.co.pattyBakery.service.impl.ProductServImpl;

/**
 *
 * @author Dimakatso Sebatane
 */
@WebServlet(name = "CakesController", urlPatterns = {"/cakes_control"})

public class CakesController extends BakeryController {

    protected String servletPath;
    private List<Product> cakes;
    protected static List<Order> bakeryOrders = new ArrayList<>();
    protected static String[] bakeryRecipeIds;
    protected String[] bakeryProductIds;
    protected static ShoppingCart bakeryCart;
    protected static String bakeryProductId;
    protected static String bakery_control;

    public void getProductInfo() {
        bakeryProductIds = new String[cakes.size()];
        bakeryRecipeIds = new String[cakes.size()];
        for (int i = 0; i < bakeryProductIds.length; i++) {
            bakeryProductIds[i] = cakes.get(i).getProductId();
            bakeryRecipeIds[i] = cakes.get(i).getRecipeId();
        }
    }

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        bakery_control = request.getServletPath().replace("/", "");
        cakes = new ProductServImpl().getAllProductsByCategoryId(2);
        getProductInfo();
        request.setAttribute("products", cakes);
        request.setAttribute("totalInCart", 0);
        request.setAttribute("control", bakery_control);
        manageOrderAddition(request, response, "cakes");
//        RequestDispatcher dispatcher = request.getRequestDispatcher("cakes");
//        dispatcher.forward(request, response);
//        getAllFromSession(request, response, bakeryCart, orderQuantitiesMap, products, imagesSrc, bakery_control);
//        manageOrderAddition(request, response, bakeryOrders, bakeryRecipeIds, bakeryProductIds, bakeryProductNames, bakeryProductPrices, bakeryProductNutrients, totalItemsInCart, bakeryCart, "cakes");
//        manageCart(request, response, bakeryProductIds, bakeryCart, bakeryOrders, orderQuantitiesMap, orderQuantities, imagesSrc, products);
//        manageOrderConfirmation(request, response, bakeryOrders, bakeryRecipeIds, bakeryProductIds, bakeryProductNames, bakeryProductPrices, bakeryProductNutrients, totalItemsInCart, bakeryCart, bakery_control);
//        managePayment(request, response, bakeryRecipeIds, bakeryProductIds, bakeryProductNames, bakeryProductPrices, bakeryProductNutrients, totalItemsInCart, bakeryCart, bakeryOrders);
//        manageCheckout(request, response, bakeryOrders, bakeryRecipeIds, bakeryProductIds, bakeryProductNames, bakeryProductPrices, bakeryProductNutrients, totalItemsInCart, bakeryCart, bakery_control);
//        manageLogin(request, response, bakeryOrders, bakeryRecipeIds, bakeryProductIds, bakeryProductNames, bakeryProductPrices, bakeryProductNutrients, totalItemsInCart, bakeryCart, bakery_control);
//        addQuantities(bakeryOrders, bakeryProductIds, orderQuantitiesMap, orderQuantities);

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
    }
}
