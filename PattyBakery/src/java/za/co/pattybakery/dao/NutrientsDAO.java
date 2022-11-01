
package za.co.pattybakery.dao;

import java.util.List;

/**
 *
 * @author Hlawulani
 */
public interface NutrientsDAO extends Close{
    public void addNutrient(String nutrient);
    public void updateNutrient(Integer nutrientsId, String nutrients);
    public void removeNutrient(Integer nutrientsId);
    public List<String> getAllNutrients();
}
