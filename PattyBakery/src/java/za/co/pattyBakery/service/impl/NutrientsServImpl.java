package za.co.pattyBakery.service.impl;

import java.util.List;
import za.co.pattyBakery.dao.NutrientsDAO;
import za.co.pattyBakery.dao.ProductNutrientDAO;
import za.co.pattyBakery.dao.impl.NutrientsDAOImpl;
import za.co.pattyBakery.dao.impl.ProductNutrientDAOImpl;

/**
 *
 * @author Bridget Bapela
 */
public class NutrientsServImpl implements NutrientsDAO, ProductNutrientDAO {
    
    private NutrientsDAO nutrientsDAOImpl;
    private ProductNutrientDAO productNutrientImpl;
    
    public NutrientsServImpl() {
        this.nutrientsDAOImpl = new NutrientsDAOImpl();
        this.productNutrientImpl = new ProductNutrientDAOImpl();
    }
    
    @Override
    public void addNutrient(String nutrientId, String nutrient) {
        nutrientsDAOImpl.addNutrient(nutrientId, nutrient);
    }
    
    @Override
    public void updateNutrient(String nutrientId, String nutrient) {
        nutrientsDAOImpl.updateNutrient(nutrientId, nutrient);
    }
    
    @Override
    public void removeNutrient(String nutrientId) {
        nutrientsDAOImpl.removeNutrient(nutrientId);
    }
    
    @Override
    public String getNutrientById(String nutrientId) {
        return nutrientsDAOImpl.getNutrientById(nutrientId);
    }
    
    public List<String> getNutrientsByProductId(String productId) {
        return productNutrientImpl.getNutrientsByProductId(productId);
    }
    
    @Override
    public List<String> getAllNutrients() {
        return nutrientsDAOImpl.getAllNutrients();
    }
    
    @Override
    public void addProductNutrient(String productId, String nutrientId, Double grams) {
        productNutrientImpl.addProductNutrient(productId, nutrientId, grams);
    }
    
}
