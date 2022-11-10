package za.co.pattyBakery.dao;

import java.util.List;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface ProductNutrientDAO extends Close {

    public void addProductNutrient(String productId, String nutrientId, Double grams);

    public List<String> getNutrientsByProductId(String productId);
}
