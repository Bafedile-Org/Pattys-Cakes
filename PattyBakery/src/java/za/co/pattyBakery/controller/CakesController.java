package za.co.pattyBakery.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dimakatso Sebatane
 */
public class CakesController extends BakeryController {

    String[] recipeIds = {"1RES", "2RES", "3RES"};
    String[] productIds = {"1PRO", "2PRO", "3PRO"};
    String[] strings = {"caramel", "margue", "chocolate"};
    String[] productNames = {"caramelName", "margueName", "chocolateName"};
    String[] productPrices = {"caramelPrice", "marguePrice", "chocolatePrice"};
    String[] productNutrients = {"caramelNu", "margueNu", "chocolateNu"};

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        setIngredientAttributes(recipeIds, strings, request);
        setProductName(productIds, productNames, productPrices, productNutrients, request);
        RequestDispatcher dispatcher = request.getRequestDispatcher("cakes");
        dispatcher.forward(request, response);
    }
}
