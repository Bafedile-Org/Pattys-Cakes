package za.co.pattyBakery.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.co.pattyBakery.Order;
import za.co.pattyBakery.Product;
import za.co.pattyBakery.exception.OrderException;
import za.co.pattyBakery.model.OrderImpl;
import za.co.pattyBakery.service.impl.ProductServImpl;

/**
 *
 * @author Dimakatso Sebatane
 */
@WebServlet(name = "PiesController", urlPatterns = {"/pies_control"})
public class PiesController extends BakeryController {

    List<Order> orders = new ArrayList<>();
    String[] recipeIds = {"13RES", "14RES", "15RES"};
    String[] productIds = {"10PRO", "11PRO", "12PRO"};
    String[] strings = {"blueberry", "apple", "strawberry"};
    String[] productNames = {"blueberryName", "appleName", "strawberryName"};
    String[] productPrices = {"blueberryPrice", "applePrice", "strawberryPrice"};
    String[] productNutrients = {"blueberryNu", "appleNu", "strawberryNu"};
    Integer totalItemsInCart = 0;

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("add") != null) {
            if (request.getParameter("add").equalsIgnoreCase("blueberry")) {
                addOrder("10PRO");
            } else if (request.getParameter("add").equalsIgnoreCase("apple")) {
                addOrder("11PRO");
            } else if (request.getParameter("add").equalsIgnoreCase("strawberryyt")) {
                addOrder("12PRO");
            }
            totalItemsInCart += 1;
            setIngredientAttributes(recipeIds, strings, request);
            setProductName(productIds, productNames, productPrices, productNutrients, request);
            request.setAttribute("totalInCart", totalItemsInCart);
            RequestDispatcher dispatcher = request.getRequestDispatcher("pies");
            dispatcher.forward(request, response);
        } else {
            setIngredientAttributes(recipeIds, strings, request);
            setProductName(productIds, productNames, productPrices, productNutrients, request);
            request.setAttribute("totalInCart", totalItemsInCart);
            RequestDispatcher dispatcher = request.getRequestDispatcher("pies");
            dispatcher.forward(request, response);
        }

    }

    public void addOrder(String productId) {
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
}
