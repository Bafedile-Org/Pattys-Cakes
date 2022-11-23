package za.co.pattyBakery.dao;

import java.util.List;
import za.co.pattyBakery.model.Recipe;
import za.co.pattyBakery.dao.Close;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface RecipeDAO extends Close {

    public void addRecipe(Recipe recipe);

    public Recipe getRecipeById(String recipeId);

    public List<Recipe> getRecipies();

    public List<String> getAllRecipieIds();

}
