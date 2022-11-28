package za.co.pattyBakery.dao;

import java.util.List;

/**
 *
 * @author Hlawulani
 */
public interface NutrientsDAO extends Close {

    public void addNutrient(String nutrientId, String nutrient);

    public String getNutrientIdByName(String nutrient);

    public void updateNutrient(String nutrientId, String nutrient);

    public void removeNutrient(String nutrientId);

    public String getNutrientById(String nutrientId);

    public List<String> getAllNutrients();
}
