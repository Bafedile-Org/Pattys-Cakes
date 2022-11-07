package za.co.pattyBakery.model;

import java.util.List;
import za.co.pattyBakery.exception.RecipeException;

/**
 *
 * @author Dimakatso Sebatane
 */
public class Recipe {

    final String RECIPE_INGREDIENTS_ERROR_MSG = "Recipe can not have Null ingredients!!!!";
    private String recipeId;
    private String recipe;
    private List<String> ingredients;

    public Recipe() {

    }

    /**
     * @return the recipeId
     */
    public String getRecipeId() {
        return recipeId;
    }

    public Recipe(String recipeId, List<String> ingredients) {
        this.setRecipeId(recipeId);
        this.addIngredients(ingredients);
    }

    public void addIngredients(List<String> ingredients) {
        try {
            if (ingredients == null) {
                throw new RecipeException(RECIPE_INGREDIENTS_ERROR_MSG);
            }
            this.ingredients = ingredients;
        } catch (RecipeException re) {
            System.out.println(String.format("ERROR_MSG: %s%n", re.getMessage()));
        }
    }

    public void setRecipeId(String recipeId) {
        this.recipeId = recipeId;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public String getRecipe() {
        recipe = "";
        for (String ingredient : ingredients) {
            recipe += String.format("%n- %s", ingredient);
        }
        return recipe;
    }

    @Override
    public String toString() {
        return getRecipe();
    }
}
