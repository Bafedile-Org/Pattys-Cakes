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
@WebServlet(name = "PersonalPiesController", urlPatterns = {"/pies_control"})
public class PersonalPiesController extends BakeryController {

    String[] recipeIds = {"13RES", "14RES", "15RES"};
    String[] productIds = {"10PRO", "11PRO", "12PRO"};
    String[] strings = {"blueberry", "apple", "strawberry"};
    String[] productNames = {"blueberryName", "appleName", "strawberryName"};
    String[] productPrices = {"blueberryPrice", "applePrice", "strawberryPrice"};
    String[] productNutrients = {"blueberryNu", "appleNu", "strawberryNu"};

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        setIngredientAttributes(recipeIds, strings, request);
        setProductName(productIds, productNames, productPrices, productNutrients, request);
        RequestDispatcher dispatcher = request.getRequestDispatcher("pies");
        dispatcher.forward(request, response);
    }
}
