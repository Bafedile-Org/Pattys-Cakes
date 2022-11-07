package za.co.pattybakery.dao;

import java.util.List;

/**
 *
 * @author Hlawulani
 */
public interface IngredientsDAO extends Close {

    public void addIngridient(String ingredientId, String ingredient, Integer quantity);

    public void updateIngredient(String ingredientId, String ingredient);

    public void removeIngredient(String ingredientId);

    public String getIngredientById(String ingredientId);

    public List<String> getAllIngredient();

    public List<String> getAllIngredientsId();
}
