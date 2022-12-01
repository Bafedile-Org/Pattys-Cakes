package za.co.pattyBakery.service.impl;

import java.util.List;
import za.co.pattyBakery.dao.IngredientsDAO;
import za.co.pattyBakery.dao.impl.IngredientsDAOImpl;

/**
 *
 * @author Bridget Bapela
 */
public class IngredientsServImpl implements IngredientsDAO {
    
    private IngredientsDAO ingredientDAOImpl;
    
    public IngredientsServImpl() {
        ingredientDAOImpl = new IngredientsDAOImpl();
    }
    
    @Override
    public void updateIngredientQuantity(String ingredientId, Integer quantity) {
        ingredientDAOImpl.updateIngredientQuantity(ingredientId, quantity);
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
    public void addIngridient(String ingredientId, String ingredient, Integer quantity) {
        if (ingredient == null || quantity <= 0) {
            return;
        }
        ingredientDAOImpl.addIngridient(ingredientId, ingredient, quantity);
    }
    
    @Override
    public String getIngredientById(String ingredientId) {
        if (ingredientId == null) {
            return null;
        }
        return ingredientDAOImpl.getIngredientById(ingredientId);
    }
    
    @Override
    public List<String> getAllIngredientsId() {
        
        return ingredientDAOImpl.getAllIngredientsId();
    }
    
    @Override
    public String getIngredientByIdName(String ingredient) {
        return ingredientDAOImpl.getIngredientByIdName(ingredient);
    }
    
    @Override
    public Integer getQuantityByID(String ingredientId) {
        return ingredientDAOImpl.getQuantityByID(ingredientId);
    }
    
}
