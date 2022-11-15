package za.co.pattyBakery.controller;

import java.io.IOException;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.ArrayList;
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
import za.co.pattyBakery.exception.OrderException;
import za.co.pattyBakery.model.OrderImpl;
import za.co.pattyBakery.model.ShoppingCartImpl;
import za.co.pattyBakery.service.impl.ProductServImpl;

/**
 *
 * @author Dimakatso Sebatane
 */
@WebServlet(name = "PiesController", urlPatterns = {"/pies_control"})
public class PiesController extends BakeryController {

    List<Order> orders;
    String[] recipeIds = {"13RES", "14RES", "15RES"};
    String[] productIds = {"10PRO", "11PRO", "12PRO"};
    String[] strings = {"10PRO", "11PRO", "12PRO"};
    String[] productNames = {"10PROName", "11PROName", "12PROName"};
    String[] productPrices = {"10PROPrice", "11PROPrice", "12PROPrice"};
    String[] productNutrients = {"10PRONu", "11PRONu", "12PRONu"};
    Integer totalItemsInCart;
    ShoppingCart cart;
    String productId = null;
    String[] imagesSrc = new String[3];
    Product[] products = new Product[3];
    Integer[] orderQuantities = new Integer[3];
    Map<String, Integer> orderQuantitiesMap = new HashMap<>();

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
<<<<<<< HEAD
        manageCart(request, response);
=======
        manageCart(request, response, productIds, cart, orders, orderQuantitiesMap, orderQuantities, imagesSrc, products);
>>>>>>> Deekay-dev
        if (request.getParameter("index") != null) {
            totalItemsInCart = 0;
            productId = null;
            if (orders != null) {
                orders.clear();
            }
            cart = null;
        }

        if (request.getParameter("add") != null) {
            addOrders(request, "add", orders);
            redirectToPage(request, response, "pies", recipeIds, productIds, productNames, productPrices, productNutrients, totalItemsInCart);

        } else {
            if (request.getParameter("cart") == null) {
                redirectToPage(request, response, "pies", recipeIds, productIds, productNames, productPrices, productNutrients, totalItemsInCart);
            } else {
                redirectToCart(request, response, cart, imagesSrc, orderQuantitiesMap, products);
            }
        }
        addQuantities(orders, productIds, orderQuantitiesMap, orderQuantities);
    }

<<<<<<< HEAD
    public void manageCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        for (String productId1 : productIds) {
            if (request.getParameter("adds") != null) {
                if (request.getParameter("adds").equalsIgnoreCase(productId1)) {
                    addOrders(request, "adds");
                    addQuantities();
                    cart = setTotalPrice();
                    redirectToCart(request, response);
                }
            }
        }
        for (String prodId : productIds) {
            if (request.getParameter("sub") != null) {
                if (request.getParameter("sub").equalsIgnoreCase(prodId)) {
                    removeOrder(prodId);
                    addQuantities();
                    cart = setTotalPrice();
                    redirectToCart(request, response);
                }
            }
        }
    }

    public void addOrders(HttpServletRequest request, String param) {
=======
    @Override
    public void addOrders(HttpServletRequest request, String param, List<Order> orders) {
>>>>>>> Deekay-dev
        if (request.getParameter(param).equalsIgnoreCase("4PRO")) {
            imagesSrc[0] = "assets/personal_pies/10PRO pies.jpg";
            productId = productIds[0];
            products[0] = new ProductServImpl().getProductById(productId);
            addOrder(productId, orders);

        } else if (request.getParameter(param).equalsIgnoreCase("5PRO")) {
            imagesSrc[1] = "assets/personal_pies/11PRO_pie.jpg";
            productId = productIds[1];
            products[1] = new ProductServImpl().getProductById(productId);
            addOrder(productId, orders);
        } else if (request.getParameter(param).equalsIgnoreCase("6PRO")) {
            imagesSrc[2] = "assets/personal_pies/12PRO pie.jpg";
            productId = productIds[2];
            products[2] = new ProductServImpl().getProductById(productId);
            addOrder(productId, orders);
        }
        cart = setTotalPrice(cart, orders);
        totalItemsInCart = cart.getOrders().size();
        request.setAttribute("totalInCart", totalItemsInCart);
    }

<<<<<<< HEAD
    public void redirectToPage(HttpServletRequest request, HttpServletResponse response, String redirectPage) throws ServletException, IOException {
        setIngredientAttributes(recipeIds, productIds, request);
        setProductName(productIds, productNames, productPrices, productNutrients, request);
        request.setAttribute("totalInCart", totalItemsInCart);
        RequestDispatcher dispatcher = request.getRequestDispatcher(redirectPage);
        dispatcher.forward(request, response);
    }

    public void redirectToCart(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("control", "cookies_control");
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

    public void addQuantities() {
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

    public ShoppingCart setTotalPrice() {
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

    public void removeOrder(String prodId) {
        try {
            Product product = new ProductServImpl().getProductById(productId);
            if (orders == null) {
                orders = new ArrayList<>();
            }
            for (Order or : orders) {
                if (or.getProduct().getProductId().equalsIgnoreCase(product.getProductId())) {
                    if (or.getQuantity() > 0 || or.getQuantity() == 0) {
                        if (or.getQuantity() == 1) {
                            or.setQuantity(1);
                        } else {
                            or.setQuantity(or.getQuantity() - 1);
                        }
                    }
                    return;
                }
            }

        } catch (OrderException ex) {
            System.out.println(String.format("ERROR: %s%n", ex.getMessage()));
        }
    }

    public void addOrder(String productId) {
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
            System.out.println(String.format("ERROR: %s%n", ex.getMessage()));
        }
    }

    public String generateOrderNumber() {
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
=======
>>>>>>> Deekay-dev
}
