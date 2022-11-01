
package za.co.pattybakery.dao;

import java.util.List;

/**
 *
 * @author Hlawulani
 */
public interface NutrientsDAO extends Close{
    public void addNutrient(String nutrient);
    public void updateNutrient(Integer nutrientId, String nutrient);
    public void removeNutrient(Integer nutrientId);
    public List<String> getAllNutrients();
}
