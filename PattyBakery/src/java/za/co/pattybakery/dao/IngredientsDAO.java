
package za.co.pattybakery.dao;

import java.util.List;

/**
 *
 * @author Hlawulani
 */
public interface IngredientsDAO extends Close{
    public void addIngrideint(String ingredient);
    public void updateIngredient(Integer ingredientsId, String ingredients);
    public void removeIngredient(Integer ingredientsId);
    public List<String> getAllIngredient();
}
