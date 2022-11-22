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
import static za.co.pattyBakery.controller.BakeryController.cart;
import static za.co.pattyBakery.controller.CakesController.bakeryOrders;
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

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     *
     * Work on the increasing the quantity of the items selected
     */
    public void removeFromCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("remove") != null) {
            List<Order> ordersToRemove = new ArrayList<>();
            for (Order order : bakeryOrders) {
                if (order.getProduct().getProductId().equals(request.getParameter("remove"))) {
                    ordersToRemove.add(order);
                }
            }
            bakeryOrders.removeAll(ordersToRemove);
            cart.setOrders(bakeryOrders);
            session.setAttribute("cart", cart);
            redirectToPage(request, response, "cart_control");
        }

    }

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        cart = getShoppingCartFromSession(bakeryOrders);
        bakeryOrders = cart.getAllOrders();
        bakery_control = request.getServletPath().replace("/", "");
        cookies = new ProductServImpl().getAllProductsByCategoryId(1);
        getProductInfo();
        request.setAttribute("products", cookies);
        request.setAttribute("totalInCart", 0);
        request.setAttribute("control", bakery_control);
        removeFromCart(request, response);
        manageOrderAddition(request, response, "cookies");
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
        if (bakeryCart.getAllOrders() != null) {
            totalItemsInCart = bakeryCart.getAllOrders().size();
        }
        request.setAttribute("totalInCart", totalItemsInCart);

    }

    public void getProductInfo() {
        bakeryProductIds = new String[cookies.size()];
        bakeryRecipeIds = new String[cookies.size()];
        for (int i = 0; i < bakeryProductIds.length; i++) {
            bakeryProductIds[i] = cookies.get(i).getProductId();
            bakeryRecipeIds[i] = cookies.get(i).getRecipeId();
        }
    }

}
