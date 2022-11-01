
package za.co.pattybakery.dao;

import java.util.List;

/**
 *
 * @author Hlawulani
 */
public interface IngredientsDAO extends Close{
    public void addIngrideint(String ingredient);
    public void updateIngredient(Integer ingredientId, String ingredient);
    public void removeIngredient(Integer ingredientId);
    public List<String> getAllIngredient();
}
