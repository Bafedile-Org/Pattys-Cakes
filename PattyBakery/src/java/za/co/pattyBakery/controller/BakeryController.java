package za.co.pattyBakery.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.co.pattyBakery.Order;
import za.co.pattyBakery.Product;
import za.co.pattyBakery.ShoppingCart;
import za.co.pattyBakery.exception.OrderException;
import za.co.pattyBakery.exception.ShoppingCartException;
import za.co.pattyBakery.model.OrderImpl;
import za.co.pattyBakery.model.ShoppingCartImpl;
import za.co.pattyBakery.service.impl.OrderServImpl;
import za.co.pattyBakery.service.impl.ProductServImpl;

/**
 *
 * @author Dimakatso Sebatane
 */
@WebServlet(name = "BakeryController", urlPatterns = {"/control"})
public class BakeryController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected static List<Order> orders = new ArrayList<>();
    protected static String[] recipeIds;
    protected static String[] productIds;
    protected static String[] productNames;
    protected static String[] productPrices;
    protected static String[] productNutrients;
    protected static Integer totalItemsInCart = 0;
    protected static ShoppingCart cart;
    protected static String productId = null;
    protected final static String[] imagesSrc = new String[3];
    protected static Product[] products = new Product[3];
    protected static Integer[] orderQuantities = new Integer[3];
    protected static Map<String, Integer> orderQuantitiesMap = new HashMap<>();
    protected static HttpSession session;
    protected static OrderServImpl orderServImpl;
    String control;

    public void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BakeryController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BakeryController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    public HttpSession setSession(HttpServletRequest request, HttpSession session) {
        if (session == null) {
            session = request.getSession(true);
            this.session = session;
        }
        if (this.session.getId().equals(session.getId())) {
            return session;
        }
        return session;
    }

    public void manageCart(HttpServletRequest request, HttpServletResponse response, String[] productIds, ShoppingCart cart, List<Order> orders,
            Map<String, Integer> orderQuantitiesMap, Integer[] orderQuantities, String[] imagesSrc, Product[] products)
            throws ServletException, IOException {
        if (request.getParameter("adds") != null) {
            for (String productId1 : productIds) {
                if (request.getParameter("adds").equalsIgnoreCase(productId1)) {
                    addOrders(request, "adds");
                    addQuantities(orders, productIds, orderQuantitiesMap, orderQuantities);
                    setTotalPrice(orders);
                    response.sendRedirect("cart_control");
                }
            }
        }
        if (request.getParameter("sub") != null) {
            for (String prodId : productIds) {
                if (request.getParameter("sub").equalsIgnoreCase(prodId)) {
                    removeOrder(prodId, orders);
                    addQuantities(orders, productIds, orderQuantitiesMap, orderQuantities);
                    setTotalPrice(orders);
                    response.sendRedirect("cart_control");
                }
            }
        }
    }

    public void redirectToPage(HttpServletRequest request, HttpServletResponse response, String redirectPage)
            throws ServletException, IOException {
        request.setAttribute("totalInCart", totalItemsInCart);
        RequestDispatcher dispatcher = request.getRequestDispatcher(redirectPage);
        dispatcher.forward(request, response);

    }

    public void addOrder(List<Order> orders, String productId) {
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
            cart = getShoppingCartFromSession(orders);
            cart.addOrder(order, orders);
            session.setAttribute("cart", cart);

        } catch (OrderException | ShoppingCartException ex) {
            System.out.println(String.format("ERROR: %s%n", ex.getMessage()));
        }
    }

    public ShoppingCart getShoppingCartFromSession(List<Order> orders) {
        cart = (ShoppingCart) session.getAttribute("cart");
        if (cart == null) {
            cart = new ShoppingCartImpl(orders, null, LocalDate.now());
        }
        if (cart.getOrderNumber() == null) {
            cart.setOrderNumber(generateOrderNumber());
        }
        return cart;
    }

    public void removeOrder(String productId, List<Order> orders) {
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

    public void addQuantities(List<Order> orders, String[] productIds, Map<String, Integer> orderQuantitiesMap, Integer[] orderQuantities) {
        Integer i = 0;
        if (orders != null && productIds != null) {
            for (Order order : orders) {
                for (String prodId : productIds) {
                    if (order.getProduct().getProductId().equals(prodId)) {
                        orderQuantities[i] = order.getQuantity();
                        orderQuantitiesMap.put(prodId, order.getQuantity());
                    }
                }
            }
        }
    }

    public void setTotalPrice(List<Order> orders) {
        cart = (ShoppingCart) session.getAttribute("cart");
        if (cart == null) {
            cart = new ShoppingCartImpl(orders, null, LocalDate.now());
        }

        if (cart.getOrderNumber() == null) {
            cart.setOrderNumber(generateOrderNumber());
            cart.setOrders(orders);
        } else {
            cart.setOrders(orders);
        }
        session.setAttribute("cart", cart);
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

    public void manageLogin(HttpServletRequest request, HttpServletResponse response, List<Order> orders, String[] recipeIds, String[] productIds,
            String[] productNames, String[] productPrices, String[] productNutrients, Integer totalItemsInCart, ShoppingCart cart, String control) throws ServletException, IOException {
        session.setAttribute("control", control);
        if (request.getParameter("login") != null) {
            session.setAttribute("shoppingCart", cart);
            redirectToPage(request, response, "login_control");
        } else if (request.getParameter("signup") != null) {
            session.setAttribute("shoppingCart", cart);
            redirectToPage(request, response, "login_control");
        }
    }

    public void managePayment(HttpServletRequest request, HttpServletResponse response, List<Order> orders)
            throws ServletException, IOException {

        if (request.getParameter("pay") != null) {
            orderServImpl = new OrderServImpl();
            if (cart != null) {
                orderServImpl.addOrder(cart);
            }
            orders = new ArrayList<>();
            cart = new ShoppingCartImpl(orders, null, LocalDate.now());
            totalItemsInCart = 0;
        }
    }

    public void manageOrderConfirmation(HttpServletRequest request, HttpServletResponse response, String control)
            throws ServletException, IOException {
        if (request.getParameter("confirmOrder") != null) {
            session.setAttribute("control", control);
            redirectToPage(request, response, "check-out");
        }
    }

    public void manageCheckout(HttpServletRequest request, HttpServletResponse response, List<Order> orders, String[] recipeIds, String[] productIds,
            String[] productNames, String[] productPrices, String[] productNutrients, Integer totalItemsInCart, ShoppingCart cart, String control)
            throws ServletException, IOException {
        if (request.getParameter("checkout") != null) {
            session.setAttribute("control", control);
            session.setAttribute("shoppingCart", cart);
            redirectToPage(request, response, "login");
        }
    }

    public void manageOrderAddition(HttpServletRequest request, HttpServletResponse response, String page)
            throws ServletException, IOException {
        if (request.getParameter("add") != null) {
            addOrders(request, "add");
            redirectToPage(request, response, page);

        } else {
            if (request.getParameter("cart") == null) {
                redirectToPage(request, response, page);

            } else {
                redirectToPage(request, response, "cart_control");
            }
        }
    }

    public void addOrders(HttpServletRequest request, String param)
            throws ServletException, IOException {

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        session = setSession(request, session);
        //getAllFromSession(request, response, cart, orderQuantitiesMap, products, control);
        processRequest(request, response);
//        addQuantities(orders, productIds, orderQuantitiesMap, orderQuantities);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        session = setSession(request, session);
        //getAllFromSession(request, response, cart, orderQuantitiesMap, products, control);
//        addQuantities(orders, productIds, orderQuantitiesMap, orderQuantities);
        processRequest(request, response);
//        addQuantities(orders, productIds, orderQuantitiesMap, orderQuantities);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
