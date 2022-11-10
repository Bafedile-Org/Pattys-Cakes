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
@WebServlet(name = "CookiesController", urlPatterns = {"/cookies_control"})
public class CookiesController extends BakeryController {

    String[] recipeIds = {"16RES", "17RES", "18RES"};
    String[] productIds = {"4PRO", "5PRO", "6PRO"};
    String[] strings = {"vanila", "chocolate", "plain"};
    String[] productNames = {"vanilaName", "chocolateName", "plainName"};
    String[] productPrices = {"vanilaPrice", "chocolatePrice", "plainPrice"};
    String[] productNutrients = {"vanilaNu", "chocolateNu", "plainNu"};

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        setIngredientAttributes(recipeIds, strings, request);
        setProductName(productIds, productNames, productPrices, productNutrients, request);
        RequestDispatcher dispatcher = request.getRequestDispatcher("cookies");
        dispatcher.forward(request, response);
    }

}
