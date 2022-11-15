package za.co.pattyBakery.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dimakatso Sebatane
 */
@WebServlet(name = "CakesController", urlPatterns = {"/cakes_control"})

public class CakesController extends BakeryController {

    String[] recipeIds = {"1RES", "2RES", "3RES"};
    String[] productIds = {"1PRO", "2PRO", "3PRO"};
    String[] strings = {"1PRO", "2PRO", "3PRO"};
    String[] productNames = {"1PROName", "2PROName", "3PROName"};
    String[] productPrices = {"1PROPrice", "2PROPrice", "3PROPrice"};
    String[] productNutrients = {"1PRONu", "2PRONu", "3PRONu"};

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        setIngredientAttributes(recipeIds, strings, request);
        setProductName(productIds, productNames, productPrices, productNutrients, request);
        RequestDispatcher dispatcher = request.getRequestDispatcher("cakes");
        dispatcher.forward(request, response);
    }
}
