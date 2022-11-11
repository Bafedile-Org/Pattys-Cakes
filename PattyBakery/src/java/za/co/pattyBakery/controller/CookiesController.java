package za.co.pattyBakery.controller;

import java.io.IOException;
import java.security.SecureRandom;
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
@WebServlet(name = "CookiesController", urlPatterns = {"/cookies_control"})
public class CookiesController extends BakeryController {

    /**
     * **
     *
     * Adding to cart does not work fix it
     */
    List<Order> orders = new ArrayList<>();
    String[] recipeIds = {"16RES", "18RES", "17RES"};
    String[] productIds = {"4PRO", "5PRO", "6PRO"};
    String[] strings = {"vanila", "chocolate", "plain"};
    String[] productNames = {"vanilaName", "chocolateName", "plainName"};
    String[] productPrices = {"vanilaPrice", "chocolatePrice", "plainPrice"};
    String[] productNutrients = {"vanilaNu", "chocolateNu", "plainNu"};
    Integer totalItemsInCart = 0;
    ShoppingCart cart;
    String productId = null;
    String[] imagesSrc = new String[3];
    Product[] products = new Product[3];

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("add") != null) {
            if (request.getParameter("add").equalsIgnoreCase("vanila")) {
                imagesSrc[0] = "assets/cookies/cookies_p.jpg";
                productId = productIds[0];
                products[0] = new ProductServImpl().getProductById(productId);
                addOrder(productId);

            } else if (request.getParameter("add").equalsIgnoreCase("chocolate")) {
                imagesSrc[1] = "assets/cookies/cokkies_pic2.jpg";
                productId = productIds[1];
                products[1] = new ProductServImpl().getProductById(productId);
                addOrder(productId);
            } else if (request.getParameter("add").equalsIgnoreCase("plain")) {
                imagesSrc[2] = "assets/cookies/cookies_pic1.jpg";
                productId = productIds[2];
                products[2] = new ProductServImpl().getProductById(productId);
                addOrder(productId);
            }
            cart = setTotalPrice(cart);
            totalItemsInCart = cart.getOrders().size();
            request.setAttribute("totalInCart", totalItemsInCart);
            redirectToPage(request, response);
        } else {
            if (request.getParameter("cart") == null) {
                redirectToPage(request, response);
            } else {
                request.setAttribute("cartItems", cart);
                request.setAttribute("images", imagesSrc);
                request.setAttribute("descriptions", null);
                request.setAttribute("products", products);
                RequestDispatcher dispatcher = request.getRequestDispatcher("cart");
                dispatcher.forward(request, response);
            }

        }
    }

    private void redirectToPage(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        setIngredientAttributes(recipeIds, strings, request);
        setProductName(productIds, productNames, productPrices, productNutrients, request);
        request.setAttribute("totalInCart", totalItemsInCart);
        RequestDispatcher dispatcher = request.getRequestDispatcher("cookies");
        dispatcher.forward(request, response);
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

    private ShoppingCart setTotalPrice(ShoppingCart cart) {
        if (cart == null) {
            cart = new ShoppingCartImpl(null, null, null);
        }

        if (cart.getOrderNumber() == null) {
            cart = new ShoppingCartImpl(orders, generateOrderNumber(), LocalDate.now());
        } else {
            cart = new ShoppingCartImpl(orders, cart.getOrderNumber(), LocalDate.now());
        }

        return cart;
    }

    private String generateOrderNumber() {
        List<Character> alphabets = new ArrayList<>();
        String orderNumber = "";
        for (char i = 'A'; i <= 'Z'; i++) {
            alphabets.add(i);
        }

        for (int i = 0; i < 2; i++) {
            orderNumber += new SecureRandom().nextInt(10) + alphabets.get(new SecureRandom().nextInt(25));
        }

        return orderNumber;
    }

}
