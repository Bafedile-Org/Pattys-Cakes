package za.co.pattyBakery.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.co.pattyBakery.Product;
import za.co.pattyBakery.ShoppingCart;

/**
 *
 * @author Dimakatso Sebatane
 */
@WebServlet(name = "CartController", urlPatterns = {"/cart_control"})
public class CartController extends BakeryController {

    protected static String displayMsg = "";
    protected static Integer[] orderQuantities = new Integer[3];
    protected List<String[]> images = new ArrayList<>();
    protected List<Product[]> products = new ArrayList<>();

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String[] cookies_images = (String[]) session.getAttribute("cookies_control_images");
        String[] cakes_images = (String[]) session.getAttribute("cakes_control_images");

        Product[] cookies_products = (Product[]) session.getAttribute("cookies_control_products");
        Product[] cakes_products = (Product[]) session.getAttribute("cakes_control_products");

        displayMsg = display(cookies_images, cookies_products, orderQuantitiesMap);
        displayMsg += display(cakes_images, cakes_products, orderQuantitiesMap);
        session.setAttribute("displayMessage", displayMsg);
        displayMsg = "";
        response.sendRedirect("cart");
    }

    void getImages() {
        String[] cookies_images = (String[]) session.getAttribute("cookies_control_images");
        String[] cakes_images = (String[]) session.getAttribute("cakes_control_images");
        String[] cupcakes_images = (String[]) session.getAttribute("cupcakes_control_images");
        String[] muffins_images = (String[]) session.getAttribute("muffins_control_images");
        String[] doughnuts_images = (String[]) session.getAttribute("doughnuts_control_images");
        String[] pies_images = (String[]) session.getAttribute("pies_control_images");

        images.add(cookies_images);
        images.add(cakes_images);
        images.add(cupcakes_images);
        images.add(muffins_images);
        images.add(doughnuts_images);
        images.add(pies_images);
    }

    void getProducts() {
        Product[] cookies_products = (Product[]) session.getAttribute("cookies_control_products");
        Product[] cakes_products = (Product[]) session.getAttribute("cakes_control_products");

        products.add(cookies_products);
        products.add(cakes_products);
    }

    String display(String[] images, Product[] products, Map<String, Integer> quantitiesMap) {
        String msg = "";
        if (images != null && quantitiesMap != null) {
            for (int i = 0; i < images.length; i++) {
                if (images[i] != null && products[i] != null) {
                    msg = msg.concat(String.format("<div class='item' id='div'>"
                            + "<div class='buttons'>"
                            + "<span class='delete-btn'>"
                            + "</span><span class='like-btn'></span>"
                            + "</div>"
                            + "<div class='image'>"
                            + "<img src='%s' alt='cookies' width='250' height='150' />"
                            + "</div>"
                            + "<div class='description'><span>%s</span>"
                            + "</div>"
                            + "<div class='quantity'><script src='js/cartCode.js'></script> "
                            + "<form onclick='controllers()' method='POST' id='conForm' name='%s'>"
                            + "<button class='plus-btn' type='submit' name='%s' value='%s' data-value='productId'><strong>-</strong>"
                            + "</button>"
                            + "<input id='amountInput' type=label readonly min=1 max=50 value='%d'>"
                            + "<button class='minus-btn' type='submit' name='%s' value='%s'><strong>+</strong></button>"
                            + "</form>"
                            + "</div>"
                            + "R<input type='button' id='price' class='total-price' value='%.2f' name='%.2f'>"
                            + "<div class=”remove” onclick='remove()'>"
                            + "<u style='cursor: pointer'>Remove</u>"
                            + "</div>"
                            + "</div><br>",
                            images[i], products[i].getProductName(), products[i].getCategory(), "sub", products[i].getProductId(), quantitiesMap.get(products[i].getProductId()), "adds",
                            products[i].getProductId(), products[i].getPrice(), products[i].getPrice()));
                }
            }
        }
        return msg;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        session = setSession(request, session);
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        session = setSession(request, session);
        processRequest(request, response);
    }
}
