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
@WebServlet(name = "CakesController", urlPatterns = {"/cakes_control"})

public class CakesController extends BakeryController {

    List<Order> orders = new ArrayList<>();
    String[] recipeIds = {"1RES", "2RES", "3RES"};
    String[] productIds = {"1PRO", "2PRO", "3PRO"};
    String[] strings = {"caramel", "margue", "chocolate"};
    String[] productNames = {"caramelName", "margueName", "chocolateName"};
    String[] productPrices = {"caramelPrice", "marguePrice", "chocolatePrice"};
    String[] productNutrients = {"caramelNu", "margueNu", "chocolateNu"};
     Integer totalItemsInCart = 0;
     
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("add")!=null){
            if(request.getParameter("add").equalsIgnoreCase("caramel")){
                addOrder("1PRO");
            }
            if(request.getParameter("add").equalsIgnoreCase("margue")){
                addOrder("2PRO");
            }
            if(request.getParameter("add").equalsIgnoreCase("chocolate")){
                addOrder("3PRO");
            }
            totalItemsInCart += 1;
             setIngredientAttributes(recipeIds, strings, request);
             setProductName(productIds, productNames, productPrices, productNutrients, request);
             request.setAttribute("totalInCart", totalItemsInCart);
             RequestDispatcher dispatcher = request.getRequestDispatcher("cakes");
             dispatcher.forward(request, response);
        }else{
        setIngredientAttributes(recipeIds, strings, request);
        setProductName(productIds, productNames, productPrices, productNutrients, request);
        request.setAttribute("totalInCart", totalItemsInCart);
        RequestDispatcher dispatcher = request.getRequestDispatcher("cakes");
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
