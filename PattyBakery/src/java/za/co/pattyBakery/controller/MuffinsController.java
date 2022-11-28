package za.co.pattyBakery.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.co.pattyBakery.Order;
import za.co.pattyBakery.Product;
import za.co.pattyBakery.ShoppingCart;
import static za.co.pattyBakery.controller.BakeryController.orderQuantitiesMap;
import za.co.pattyBakery.service.impl.ProductServImpl;

/**
 *
 * @author Dimakatso Sebatane
 */
@WebServlet(name = "MuffinsController", urlPatterns = {"/muffins_control"})
public class MuffinsController extends BakeryController {

    protected String servletPath;
    private List<Product> muffins;
    protected static List<Order> bakeryOrders = new ArrayList<>();
    protected static String[] bakeryRecipeIds;
    protected String[] bakeryProductIds;
    protected static ShoppingCart bakeryCart;
    protected static String bakeryProductId;
    protected static String bakery_control;

    public void getProductInfo() {
        bakeryProductIds = new String[muffins.size()];
        bakeryRecipeIds = new String[muffins.size()];
        for (int i = 0; i < bakeryProductIds.length; i++) {
            bakeryProductIds[i] = muffins.get(i).getProductId();
            bakeryRecipeIds[i] = muffins.get(i).getRecipeId();
        }
    }

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        bakery_control = request.getServletPath().replace("/", "");
        muffins = new ProductServImpl().getAllProductsByCategoryId(5);
        getProductInfo();
        request.setAttribute("products", muffins);
        request.setAttribute("totalInCart", 0);
        request.setAttribute("control", bakery_control);
        removeFromCart(request, response);
        manageOrderAddition(request, response, "muffins");
        manageCart(request, response, bakeryProductIds, bakeryOrders, bakery_control);
        addQuantities(bakeryOrders, bakeryProductIds, orderQuantitiesMap, controlsMap, bakery_control);

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
        addQuantities(bakeryOrders, bakeryProductIds, orderQuantitiesMap, controlsMap, bakery_control);
        request.setAttribute("totalInCart", totalItemsInCart);

    }

}
