package za.co.pattyBakery.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.co.pattyBakery.dao.RecipeDAO;
import za.co.pattyBakery.model.Recipe;
import za.co.pattyBakery.service.impl.RecipeServImpl;

/**
 *
 * @author Dimakatso Sebatane
 */
@WebServlet(name = "CookiesController", urlPatterns = "/cookies_control")
public class CookiesController extends BakeryController {

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String[] recipeIds = {"16RES", "17RES", "18RES"};
        setIngredientAttributes(recipeIds, request);
        RequestDispatcher dispatcher = request.getRequestDispatcher("cookies");
        dispatcher.forward(request, response);
    }

    private void setIngredientAttributes(String[] recipeIds, HttpServletRequest request) {
        RecipeDAO recipeServImpl = new RecipeServImpl();
        String[] strings = {"vanila", "chocolate", "plain"};
        for (int i = 0; i < strings.length; i++) {
            Recipe recipe = recipeServImpl.getRecipeById(recipeIds[i]);
            request.setAttribute(strings[i], recipe.getIngredients());
        }

    }

}
