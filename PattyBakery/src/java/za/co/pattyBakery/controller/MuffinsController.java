//package za.co.pattyBakery.controller;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import za.co.pattyBakery.Order;
//import za.co.pattyBakery.Product;
//import za.co.pattyBakery.ShoppingCart;
//import za.co.pattyBakery.service.impl.ProductServImpl;
//
///**
// *
// * @author Dimakatso Sebatane
// */
//@WebServlet(name = "MuffinsController", urlPatterns = {"/muffins_control"})
//public class MuffinsController extends BakeryController {
//
//    List<Order> orders = new ArrayList<>();
//    String[] recipeIds = {"10RES", "11RES", "12RES"};
//    String[] productIds = {"13PRO", "14PRO", "15PRO"};
//    // String[] strings = {"blueberry", "cranberry", "carrot"};
//    String[] productNames = {"13PROName", "14PROName", "15PROName"};
//    String[] productPrices = {"13PROPrice", "14PROPrice", "15PROPrice"};
//    String[] productNutrients = {"13PRONu", "14PRONu", "15PRONu"};
//    Integer totalItemsInCart = 0;
//    ShoppingCart cart;
//    String productId = null;
//    String[] imagesSrc = new String[3];
//    Product[] products = new Product[3];
//    Integer[] orderQuantities = new Integer[3];
//    Map<String, Integer> orderQuantitiesMap = new HashMap<>();
//
//    @Override
//    public void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        manageCart(request, response, productIds, cart, orders, orderQuantitiesMap, orderQuantities, imagesSrc, products);
//        if (request.getParameter("index") != null) {
//            totalItemsInCart = 0;
//            productId = null;
//            if (orders != null) {
//                orders.clear();
//            }
//            cart = null;
//        }
//        if (request.getParameter("add") != null) {
//            addOrders(request, "add", orders);
//            redirectToPage(request, response, "muffins", recipeIds, productIds, productNames, productPrices, productNutrients, totalItemsInCart);
//        } else {
//            if (request.getParameter("cart") == null) {
//                redirectToPage(request, response, "muffins", recipeIds, productIds, productNames, productPrices, productNutrients, totalItemsInCart);
//            } else {
//                redirectToCart(request, response, cart, imagesSrc, orderQuantitiesMap, products);
//            }
//        }
//        addQuantities(orders, productIds, orderQuantitiesMap, orderQuantities);
//    }
//
//    @Override
//    public void addOrders(HttpServletRequest request, String param, List<Order> orders)
//            throws ServletException, IOException {
//        if (request.getParameter(param).equalsIgnoreCase("13PRO")) {
//            imagesSrc[0] = "assets/muffins/Blueberry-Muffins.jpg";
//            productId = productIds[0];
//            products[0] = new ProductServImpl().getProductById(productId);
//            addOrder(productId, orders);
//
//        } else if (request.getParameter(param).equalsIgnoreCase("14PRO")) {
//            imagesSrc[1] = "assets/muffins/carrot-muffins.jpg";
//            productId = productIds[1];
//            products[1] = new ProductServImpl().getProductById(productId);
//            addOrder(productId, orders);
//        } else if (request.getParameter(param).equalsIgnoreCase("15PRO")) {
//            imagesSrc[2] = "assets/muffins/Cranberry-Muffins.jpg";
//            productId = productIds[2];
//            products[2] = new ProductServImpl().getProductById(productId);
//            addOrder(productId, orders);
//        }
//        cart = setTotalPrice(cart, orders);
//        totalItemsInCart = cart.getOrders().size();
//        request.setAttribute("totalInCart", totalItemsInCart);
//    }
//}
