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
import za.co.pattyBakery.Order;
import za.co.pattyBakery.Product;
import za.co.pattyBakery.ShoppingCart;
import za.co.pattyBakery.dao.ProductDAO;
import za.co.pattyBakery.dao.RecipeDAO;
import za.co.pattyBakery.dao.impl.ProductDAOImpl;
import za.co.pattyBakery.exception.OrderException;
import za.co.pattyBakery.model.OrderImpl;
import za.co.pattyBakery.model.Recipe;
import za.co.pattyBakery.model.ShoppingCartImpl;
import za.co.pattyBakery.service.impl.ProductServImpl;
import za.co.pattyBakery.service.impl.RecipeServImpl;

/**
 *
 * @author Dimakatso Sebatane
 */
@WebServlet(name = "BakeryController", urlPatterns = {"/bakery_control"})
public class BakeryController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    List<Order> orders;
    String[] recipeIds = {"1RES", "2RES", "3RES"};
    String[] productIds = {"1PRO", "2PRO", "3PRO"};
    // String[] strings = {"caramel", "margue", "chocolate"};
    String[] productNames = {"1PROName", "2PROName", "3PROName"};
    String[] productPrices = {"1PROPrice", "2PROPrice", "3PROPrice"};
    String[] productNutrients = {"1PRONu", "2PRONu", "3PRONu"};
    Integer totalItemsInCart = 0;
    ShoppingCart cart;
    String productId = null;
    String[] imagesSrc = new String[3];
    Product[] products = new Product[3];
    Integer[] orderQuantities = new Integer[3];
    Map<String, Integer> orderQuantitiesMap = new HashMap<>();
    
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
    
    public void setIngredientAttributes(String[] recipeIds, String[] strings, HttpServletRequest request) {
        RecipeDAO recipeServImpl = new RecipeServImpl();
        for (int i = 0; i < recipeIds.length; i++) {
            Recipe recipe = recipeServImpl.getRecipeById(recipeIds[i]);
            request.setAttribute(strings[i], recipe.getIngredients());
        }
    }
    
    public void setProductName(String[] productIds, String[] productNames, String[] productPrices, String[] productNutrients, HttpServletRequest request) {
        ProductDAO productServImpl = new ProductDAOImpl();
        for (int i = 0; i < productIds.length; i++) {
            Product product = productServImpl.getProductById(productIds[i]);
            request.setAttribute(productNames[i], product.getProductName());
            request.setAttribute(productPrices[i], product.getPrice());
            request.setAttribute(productNutrients[i], product.getNutrientsList());
        }
    }
    
    public void manageCart(HttpServletRequest request, HttpServletResponse response, String[] productIds, ShoppingCart cart, List<Order> orders,
            Map<String, Integer> orderQuantitiesMap, Integer[] orderQuantities, String[] imagesSrc, Product[] products)
            throws ServletException, IOException {
        if (request.getParameter("adds") != null) {
            for (String productId1 : productIds) {
                if (request.getParameter("adds").equalsIgnoreCase(productId1)) {
                    addOrders(request, "adds", orders);
                    addQuantities(orders, productIds, orderQuantitiesMap, orderQuantities);
                    cart = setTotalPrice(cart, orders);
                    redirectToCart(request, response, cart, imagesSrc, orderQuantitiesMap, products);
                }
            }
        }
        if (request.getParameter("sub") != null) {
            for (String prodId : productIds) {
                if (request.getParameter("sub").equalsIgnoreCase(prodId)) {
                    removeOrder(prodId, orders);
                    addQuantities(orders, productIds, orderQuantitiesMap, orderQuantities);
                    cart = setTotalPrice(cart, orders);
                    redirectToCart(request, response, cart, imagesSrc, orderQuantitiesMap, products);
                }
            }
        }
    }
    
    public void redirectToPage(HttpServletRequest request, HttpServletResponse response, String redirectPage, String[] recipeIds,
            String[] productIds, String[] productNames, String[] productPrices, String[] productNutrients, Integer totalItemsInCart)
            throws ServletException, IOException {
        setIngredientAttributes(recipeIds, productIds, request);
        setProductName(productIds, productNames, productPrices, productNutrients, request);
        request.setAttribute("totalInCart", totalItemsInCart);
        RequestDispatcher dispatcher = request.getRequestDispatcher(redirectPage);
        dispatcher.forward(request, response);
    }
    
    public void addOrder(String productId, List<Order> orders) {
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
        if (orders != null) {
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
    
    public ShoppingCart setTotalPrice(ShoppingCart cart, List<Order> orders) {
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
    
    public void setIndexPage(HttpServletRequest request, Integer totalItemsInCart, String productId, List<Order> orders, ShoppingCart cart) {
        if (request.getParameter("index") != null) {
////            totalItemsInCart = 0;
//            productId = null;
//            if (orders != null) {
//                orders.clear();
//            }
//            cart = null;
        }
    }
    
    public void manageLogin(HttpServletRequest request, HttpServletResponse response, String[] recipeIds, String[] productIds,
            String[] productNames, String[] productPrices, String[] productNutrients, Integer totalItemsInCart, ShoppingCart cart) throws ServletException, IOException {
        request.setAttribute("control", (String) request.getAttribute("control"));
        if (request.getParameter("login") != null) {
            request.setAttribute("shoppingCart", cart);
            redirectToPage(request, response, "login_control", recipeIds, productIds, productNames, productPrices, productNutrients, totalItemsInCart);
        } else if (request.getParameter("signup") != null) {
            request.setAttribute("shoppingCart", cart);
            redirectToPage(request, response, "login_control", recipeIds, productIds, productNames, productPrices, productNutrients, totalItemsInCart);
        }
    }
    
    public void redirectToCart(HttpServletRequest request, HttpServletResponse response, ShoppingCart cart, String[] imagesSrc, Map<String, Integer> orderQuantitiesMap, Product[] products)
            throws ServletException, IOException {
        
    }
    
    public void addOrders(HttpServletRequest request, String param, List<Order> orders)
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
        processRequest(request, response);
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
        processRequest(request, response);
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
