package za.co.pattyBakery.service.impl;

import java.util.List;
import za.co.pattyBakery.dao.RecipeDAO;
import za.co.pattyBakery.dao.impl.RecipeDAOImpl;
import za.co.pattyBakery.model.Recipe;

/**
 *
 * @author Dimakatso Sebatane
 */
public class RecipeServImpl implements RecipeDAO {

    RecipeDAO recipeDaoImpl;

    public RecipeServImpl() {
        recipeDaoImpl = new RecipeDAOImpl();
    }

    @Override
    public void addRecipe(Recipe recipe) {
        recipeDaoImpl.addRecipe(recipe);
    }

    @Override
    public Recipe getRecipeById(String recipeId) {
        return recipeDaoImpl.getRecipeById(recipeId);
    }

    @Override
    public List<Recipe> getRecipies() {
        return recipeDaoImpl.getRecipies();
    }

}
