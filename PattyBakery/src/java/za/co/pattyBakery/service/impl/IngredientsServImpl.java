package za.co.pattyBakery.service.impl;

import java.util.List;
import za.co.pattybakery.dao.IngredientsDAO;

/**
 *
 * @author Bridget Bapela
 */
public class IngredientsServImpl implements IngredientsDAO {
    
    private IngredientsDAO ingredientDAOImpl;
    
    @Override
    public void updateIngredient(Integer ingredientId, String ingredient) {
        if (ingredient == null || ingredientId <= 0) {
            return;
        }
        ingredientDAOImpl.updateIngredient(ingredientId, ingredient);
    }
    
    @Override
    public void removeIngredient(String ingredientId) {
        if (ingredientId == null) {
            return;
        }
        ingredientDAOImpl.removeIngredient(ingredientId);
    }
    
    @Override
    public List<String> getAllIngredient() {
        return ingredientDAOImpl.getAllIngredient();
    }
    
    @Override
    public void addIngridient(String ingredient, Integer quantity) {
        if (ingredient == null || quantity <= 0) {
            return;
        }
        ingredientDAOImpl.addIngridient(ingredient, quantity);
    }
    
    @Override
    public String getIngredientById(String ingredientId) {
        if (ingredientId == null) {
            return null;
        }
        return ingredientDAOImpl.getIngredientById(ingredientId);
    }
    
}
