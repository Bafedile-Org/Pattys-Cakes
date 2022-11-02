package za.co.pattyBakery.service.impl;

import java.util.List;
import za.co.pattybakery.dao.IngredientsDAO;

/**
 *
 * @author Bridget Bapela
 */
public class IngredientsServImpl implements IngredientsDAO {

    private IngredientsDAO ingredientDAOImpl;

//    @Override
    public void addIngrideint(String ingredientId, String ingredient) {
        if (ingredient == null) {

        }
//        ingredientDAOImpl.addIngridient(ingredientId, ingredient);
    }

    @Override
    public void updateIngredient(String ingredientId, String ingredient) {
        if (ingredient == null || ingredientId == null) {
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getIngredientById(String ingredientId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
