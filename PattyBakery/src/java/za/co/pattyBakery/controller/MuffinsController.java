package za.co.pattyBakery.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "MuffinsController", urlPatterns = {"/muffins_control"})
public class MuffinsController extends BakeryController {

    List<Order> orders = new ArrayList<>();
    String[] recipeIds = {"10RES", "11RES", "12RES"};
    String[] productIds = {"13PRO", "14PRO", "15PRO"};
    String[] strings = {"blueberry", "cranberry", "carrot"};
    String[] productNames = {"blueberryName", "cranberryName", "carrotName"};
    String[] productPrices = {"blueberryPrice", "cranberryPrice", "carrotPrice"};
    String[] productNutrients = {"blueberryNu", "cranberryNu", "carrotNu"};
    Integer totalItemsInCart = 0;

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getParameter("add") != null) {
            if (request.getParameter("add").equalsIgnoreCase("blueberry")) {
                addOrder("13PRO");
            }
            if (request.getParameter("add").equalsIgnoreCase("cranberry")) {
                addOrder("14PRO");
            }
            if (request.getParameter("add").equalsIgnoreCase("carrot")) {
                addOrder("15PRO");
            }
            totalItemsInCart += 1;
            setIngredientAttributes(recipeIds, strings, request);
            setProductName(productIds, productNames, productPrices, productNutrients, request);
            request.setAttribute("totalInCart", totalItemsInCart);
            RequestDispatcher dispatcher = request.getRequestDispatcher("muffins");
            dispatcher.forward(request, response);
        } else {

            setIngredientAttributes(recipeIds, strings, request);
            setProductName(productIds, productNames, productPrices, productNutrients, request);
            request.setAttribute("totalInCart", totalItemsInCart);
            RequestDispatcher dispatcher = request.getRequestDispatcher("muffins");
            dispatcher.forward(request, response);

        }

    }

    private void addOrder(String productId) {
        try {
            Product product = new ProductServImpl().getProductById(productId);
            Order order = new OrderImpl(product, product.getPrice());
            if (orders.contains(order)) {
                order.setQuantity(order.getQuantity() + 1);
            } else {
                orders.add(order);
            }
        } catch (OrderException ex) {

        }
    }

    private void setTotalPrice() {
        ShoppingCart cart = new ShoppingCartImpl(orders, "#1212", LocalDate.now());

    }
}
