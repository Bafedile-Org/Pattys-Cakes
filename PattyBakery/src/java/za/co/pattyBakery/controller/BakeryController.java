package za.co.pattyBakery.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.co.pattyBakery.Product;
import za.co.pattyBakery.dao.ProductDAO;
import za.co.pattyBakery.dao.RecipeDAO;
import za.co.pattyBakery.dao.impl.ProductDAOImpl;
import za.co.pattyBakery.model.Recipe;
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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
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

    protected void setIngredientAttributes(String[] recipeIds, String[] strings, HttpServletRequest request) {
        RecipeDAO recipeServImpl = new RecipeServImpl();
        for (int i = 0; i < recipeIds.length; i++) {
            Recipe recipe = recipeServImpl.getRecipeById(recipeIds[i]);
            request.setAttribute(strings[i], recipe.getIngredients());
        }
    }

    protected void setProductName(String[] productIds, String[] productNames, String[] productPrices, String[] productNutrients, HttpServletRequest request) {
        ProductDAO productServImpl = new ProductDAOImpl();
        for (int i = 0; i < productIds.length; i++) {
            Product product = productServImpl.getProductById(productIds[i]);
            request.setAttribute(productNames[i], product.getProductName());
            request.setAttribute(productPrices[i], product.getPrice());
            request.setAttribute(productNutrients[i], product.getNutrientsList());
        }
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
