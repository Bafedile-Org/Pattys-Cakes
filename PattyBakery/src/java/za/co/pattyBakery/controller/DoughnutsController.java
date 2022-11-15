package za.co.pattyBakery.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
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
import za.co.pattyBakery.model.ShoppingCartImpl;
import za.co.pattyBakery.service.impl.ProductServImpl;

/**
 *
 * @author Dimakatso Sebatane
 */
@WebServlet(name = "PersonalPiesController", urlPatterns = {"/doughnuts_control"})
public class DoughnutsController extends BakeryController {

    List<Order> orders;
    String[] recipeIds = {"4RES", "5RES", "6RES"};
    String[] productIds = {"16PRO", "17PRO", "18PRO"};
    String[] strings = {"16PRO", "17PRO", "18PRO"};
    String[] productNames = {"16PROName", "17PROName", "18PROName"};
    String[] productPrices = {"16PROPrice", "17PROPrice", "18PROPrice"};
    String[] productNutrients = {"16PRONu", "17PRONu", "18PRONu"};
    Integer totalItemsInCart;
    ShoppingCart cart;
    String productId = null;
    String[] imagesSrc = new String[3];
    Product[] products = new Product[3];
    Integer[] orderQuantities = new Integer[3];
    Map<String, Integer> orderQuantitiesMap = new HashMap<>();
    

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        manageCart(request, response);
        if(request.getParameter("index") != null){
            totalItemsInCart = 0;
            productId = null;
            if(orders != null){
                orders.clear();
            }
            cart = null;
        }
    
    if(request.getParameter("add") != null){
        addOrders(request, "add");
        redirectToPage(request, response, "dougnuts");
    }else{
        if(request.getParameter("cart") == null){
            redirectToPage(request, response, "doughnuts");
        }
    }
        addQuantities();
}
    private void manageCart(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        for (String productId1 : productIds) {
            if(request.getParameter("adds") != null){
                if(request.getParameter("adds").equalsIgnoreCase(productId1)){
                addOrders(request, "adds");
                addQuantities();
                cart = setTotalPrice();
                redirectToCart(request, response);
            }
        }
    }
        for(String prodId : productIds){
            if(request.getParameter("sub") != null){
                if(request.getParameter("sub").equalsIgnoreCase(prodId)){
                    removeOder(prodId);
                    addQuantities();
                    redirectToCart(request, response);
                }
            }
        }
    
    }

    private void addOrders(HttpServletRequest request, String param) 
        throws ServletException, IOException{
        if(request.getParameter(param).equalsIgnoreCase("4PRO")){
            imagesSrc[0] = "assets/doughnuts/dougnuts3.jpg";
            productId = productIds[0];
            products[0] = new ProductServImpl().getProductById(productId);
            addOrder(productId);
        }
        else if(request.getParameter(param).equalsIgnoreCase("5PRO")){
            imagesSrc[1] = "assets/doughnuts/dougnuts2.jpg";
            productId = productIds[1];
            products[1] = new ProductServImpl().getProductById(productId);
            addOrder(productId);
        }
        else if(request.getParameter(param).equalsIgnoreCase(productId)){
            imagesSrc[2] = "assets/doughnuts/dougnuts4.jpg";
            productId = productIds[2];
            addOrder(productId);
        }
    }

    private void redirectToPage(HttpServletRequest request, HttpServletResponse response, String redirectPage)
        throws ServletException, IOException {
        setIngredientAttributes(recipeIds, strings, request);
        setProductName(productIds, productNames, productPrices, productNutrients, request);
        request.setAttribute("totalInCart", totalItemsInCart);
        RequestDispatcher dispatcher = request.getRequestDispatcher(redirectPage);
        dispatcher.forward(request, response);
    }

    private void addQuantities() {
        Integer i = 0;
        for (Order order : orders) {
            for (String productId : productIds) {
                if (order.getProduct().getProductId().equals(productId)) {
                    orderQuantities[i] = order.getQuantity();
                    orderQuantitiesMap.put(productId, order.getQuantity());
                }
            }

        }
    }

    private ShoppingCart setTotalPrice() {
        if (cart == null) {
            cart = new ShoppingCartImpl(orders, null, LocalDate.now());
        }

        if (cart.getOrderNumber() == null) {
            cart.setOrderNumber(generateOrderNumber());
            cart.setOrders(orders);
        } else {
            cart.setOrders(orders);
        }

        return cart;
    }

    private void redirectToCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("control", "doughnutes_control");
        request.setAttribute("cartItems", cart);
        request.setAttribute("images", imagesSrc);
        request.setAttribute("quantities", orderQuantities);
        request.setAttribute("quantitiesMap", orderQuantitiesMap);
        request.setAttribute("products", products);
        request.setAttribute("deliveryAmount", 100.0);
        request.setAttribute("totalAmount", Double.valueOf(String.format("%.2f", cart == null ? 0.0 : cart.getTotalprice())));
        RequestDispatcher dispatcher = request.getRequestDispatcher("cart");
        dispatcher.forward(request, response);
    }

    private void removeOder(String prodId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void addOrder(String productId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String generateOrderNumber() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
