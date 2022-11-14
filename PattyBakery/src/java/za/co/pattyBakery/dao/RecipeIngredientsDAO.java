package za.co.pattyBakery.dao;

import java.util.List;
import za.co.pattyBakery.model.Recipe;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface RecipeIngredientsDAO extends Close {

    public void addRecipeIngredient(Recipe recipe);

    public List<String> getIngredientsByRecipeId(String recipeId);

    public void addIngredientToRecipe(String recipeId, String ingredientId);
}
