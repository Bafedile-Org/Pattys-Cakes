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
@WebServlet(name = "CupcakesController", urlPatterns = {"/cupcakes_control"})
public class CupcakesController extends BakeryController {

    List<Order> orders = new ArrayList<>();
    String[] recipeIds = {"7RES", "8RES", "9RES"};
    String[] productIds = {"7PRO", "8PRO", "9PRO"};
    String[] strings = {"walnut", "chocolate", "vanila"};
    String[] productNames = {"walnutName", "chocolateName", "vanilaName"};
    String[] productPrices = {"walnutPrice", "chocolatePrice", "vanilaPrice"};
    String[] productNutrients = {"walnutNu", "chocolateNu", "vanilaNu"};
    Integer totalItemsInCart = 0;

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("add") != null) {

            if (request.getParameter("add").equalsIgnoreCase("walnut")) {

                addOrder("7PRO");
            }
            if (request.getParameter("add").equalsIgnoreCase("chocolate")) {

                addOrder("8PRO");
            }
            if (request.getParameter("add").equalsIgnoreCase("vanilla")) {

                addOrder("9PRO");
            }
            totalItemsInCart += 1;
            request.setAttribute("totalInCart", totalItemsInCart);
            setIngredientAttributes(recipeIds, strings, request);
            setProductName(productIds, productNames, productPrices, productNutrients, request);
            RequestDispatcher dispatcher = request.getRequestDispatcher("cupcakes");
            dispatcher.forward(request, response);
        } else {
            setIngredientAttributes(recipeIds, strings, request);
            setProductName(productIds, productNames, productPrices, productNutrients, request);
            request.setAttribute("totalInCart", totalItemsInCart);
            RequestDispatcher dispatcher = request.getRequestDispatcher("cupcakes");
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
