package za.co.pattyBakery.controller;

import java.io.IOException;
import java.security.SecureRandom;
import java.sql.Connection;
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
    List<Order> orders;
    String[] recipeIds = {"16RES", "18RES", "17RES"};
    String[] productIds = {"4PRO", "5PRO", "6PRO"};
    String[] productNames = {"4PROName", "5PROName", "6PROName"};
    String[] productPrices = {"4PROPrice", "5PROPrice", "6PROPrice"};
    String[] productNutrients = {"4PRONu", "5PRONu", "6PRONu"};
    Integer totalItemsInCart;
    ShoppingCart cart;
    String productId = null;
    String[] imagesSrc = new String[3];
    Product[] products = new Product[3];
    Integer[] orderQuantities = new Integer[3];

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("index") != null) {
            totalItemsInCart = 0;
            productId = null;
            if (orders != null) {
                orders.clear();
            }
            cart = null;
        }
        for (String productId1 : productIds) {
            if (request.getParameter("adds") != null) {
                if (request.getParameter("adds").equalsIgnoreCase(productId1)) {
                    addOrders(request, response, "adds");
                    addQuantities();
                    cart = setTotalPrice();
                    redirectToCart(request, response);
                }
            }
        }

        if (request.getParameter("add") != null) {
            addOrders(request, response, "add");
            redirectToPage(request, response, "cookies");

        } else {
            if (request.getParameter("cart") == null) {
                redirectToPage(request, response, "cookies");
            } else {
                redirectToCart(request, response);
            }

        }
        addQuantities();

    }

    private void redirectToCart(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("control", "cookies_control");
        request.setAttribute("cartItems", cart);
        request.setAttribute("images", imagesSrc);
        request.setAttribute("quantities", orderQuantities);
        request.setAttribute("products", products);
        request.setAttribute("deliveryAmount", 100.0);
        request.setAttribute("totalAmount", Double.valueOf(String.format("%.2f", cart == null ? 0.0 : cart.getTotalprice())));
        RequestDispatcher dispatcher = request.getRequestDispatcher("cart");
        dispatcher.forward(request, response);
    }

    private void addOrders(HttpServletRequest request, HttpServletResponse response, String param)
            throws ServletException, IOException {
        if (request.getParameter(param).equalsIgnoreCase("4PRO")) {
            imagesSrc[0] = "assets/cookies/cookies_p.jpg";
            productId = productIds[0];
            products[0] = new ProductServImpl().getProductById(productId);
            addOrder(productId);

        } else if (request.getParameter(param).equalsIgnoreCase("5PRO")) {
            imagesSrc[1] = "assets/cookies/cookies_pic1.jpg";
            productId = productIds[1];
            products[1] = new ProductServImpl().getProductById(productId);
            addOrder(productId);
        } else if (request.getParameter(param).equalsIgnoreCase("6PRO")) {
            imagesSrc[2] = "assets/cookies/cokkies_pic2.jpg";
            productId = productIds[2];
            products[2] = new ProductServImpl().getProductById(productId);
            addOrder(productId);
        }
        cart = setTotalPrice();
        totalItemsInCart = cart.getOrders().size();
        request.setAttribute("totalInCart", totalItemsInCart);
    }

    private void redirectToPage(HttpServletRequest request, HttpServletResponse response, String redirectPage)
            throws ServletException, IOException {
        setIngredientAttributes(recipeIds, productIds, request);
        setProductName(productIds, productNames, productPrices, productNutrients, request);
        request.setAttribute("totalInCart", totalItemsInCart);
        RequestDispatcher dispatcher = request.getRequestDispatcher(redirectPage);
        dispatcher.forward(request, response);
    }

    private void addOrder(String productId) {
        try {
            Product product = new ProductServImpl().getProductById(productId);
            Order order = new OrderImpl(product, product.getPrice());

            if (orders == null) {
                orders = new ArrayList<>();
            }
            for (Order or : orders) {
                if (or.getProduct().getProductId().equalsIgnoreCase(product.getProductId())) {
                    or.setQuantity(or.getQuantity() + 1);
                    return;
                }
            }

            orders.add(order);
        } catch (OrderException ex) {

        }
    }

    private void addQuantities() {
        Integer i = 0;
        for (String prodId : productIds) {
            for (Order order : orders) {
                if (order.getProduct().getProductId().equals(prodId)) {
                    orderQuantities[i] = order.getQuantity();
                }
            }
            i++;
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

    private String generateOrderNumber() {
        List<Character> alphabets = new ArrayList<>();
        String orderNumber = "";
        for (char i = 'A'; i <= 'Z'; i++) {
            alphabets.add(i);
        }
        orderNumber += alphabets.get(new SecureRandom().nextInt(25)) + alphabets.get(new SecureRandom().nextInt(25));
        for (int i = 0; i < 5; i++) {
            orderNumber += new SecureRandom().nextInt(10);
        }

        return orderNumber;
    }

}
