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
@WebServlet(name = "CupcakesController", urlPatterns = {"/cupcakes_control"})
public class CupcakesController extends BakeryController {

    String[] recipeIds = {"7RES", "8RES", "9RES"};
    String[] productIds = {"7PRO", "8PRO", "9PRO"};
    String[] strings = {"walnut", "chocolate", "vanila"};
    String[] productNames = {"walnutName", "chocolateName", "vanilaName"};
    String[] productPrices = {"walnutPrice", "chocolatePrice", "vanilaPrice"};
    String[] productNutrients = {"walnutNu", "chocolateNu", "vanilaNu"};

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        setIngredientAttributes(recipeIds, strings, request);
        setProductName(productIds, productNames, productPrices, productNutrients, request);
        RequestDispatcher dispatcher = request.getRequestDispatcher("cupcakes");
        dispatcher.forward(request, response);

    }
}
