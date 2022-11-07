package za.co.pattyBakery.model;

/**
 *
 * @author Dimakatso Sebatane
 */
public class Recipe {

    /**
     * @return the recipeId
     */
    public String getRecipeId() {
        return recipeId;
    }

    public Recipe(String recipeId, String recipe) {
        this.setRecipeId(recipeId);
        this.setRecipe(recipe);
    }

    /**
     * @param recipeId the recipeId to set
     */
    public void setRecipeId(String recipeId) {
        this.recipeId = recipeId;
    }

    /**
     * @return the recipe
     */
    public String getRecipe() {
        return recipe;
    }

    /**
     * @param recipe the recipe to set
     */
    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    private String recipeId;
    private String recipe;

    public Recipe() {

    }

}
