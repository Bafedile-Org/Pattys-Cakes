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
@WebServlet(name = "MuffinsController", urlPatterns = {"/muffins_control"})
public class MuffinsController extends BakeryController {

    String[] recipeIds = {"10RES", "11RES", "12RES"};
    String[] productIds = {"13PRO", "14PRO", "15PRO"};
    String[] strings = {"13PRO", "14PRO", "15PRO"};
    String[] productNames = {"13PROName", "14PROName", "15PROName"};
    String[] productPrices = {"13PROPrice", "14PROPrice", "15PROPrice"};
    String[] productNutrients = {"13PRONu", "14PRONu", "15PRONu"};

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        setIngredientAttributes(recipeIds, strings, request);
        setProductName(productIds, productNames, productPrices, productNutrients, request);
        RequestDispatcher dispatcher = request.getRequestDispatcher("muffins");
        dispatcher.forward(request, response);

    }
}
