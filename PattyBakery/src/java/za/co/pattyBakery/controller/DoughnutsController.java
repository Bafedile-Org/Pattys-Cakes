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
@WebServlet(name = "PersonalPiesController", urlPatterns = {"/doughnuts_control"})
public class DoughnutsController extends BakeryController {

    String[] recipeIds = {"4RES", "5RES", "6RES"};
    String[] productIds = {"16PRO", "17PRO", "18PRO"};
    String[] strings = {"glazedLove", "glazed", "chocolate"};
    String[] productNames = {"glazedLoveName", "glazedName", "chocolateName"};
    String[] productPrices = {"glazedLovePrice", "glazedPrice", "chocolatePrice"};
    String[] productNutrients = {"glazedLoveNu", "glazedNu", "chocolateNu"};

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        setIngredientAttributes(recipeIds, strings, request);
        setProductName(productIds, productNames, productPrices, productNutrients, request);
        RequestDispatcher dispatcher = request.getRequestDispatcher("doughnuts");
        dispatcher.forward(request, response);
    }
}
