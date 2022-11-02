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
    public void addIngrideint(String ingredient) {
        if (ingredient == null) {

        }
        ingredientDAOImpl.addIngrideint(ingredient);
    }

    @Override
    public void updateIngredient(Integer ingredientId, String ingredient) {
        if (ingredient == null || ingredientId <= 0) {
            return;
        }
        ingredientDAOImpl.updateIngredient(ingredientId, ingredient);
    }

    @Override
    public void removeIngredient(Integer ingredientId) {
        if (ingredientId <= 0) {
            return;
        }
        ingredientDAOImpl.removeIngredient(ingredientId);
    }

    @Override
    public List<String> getAllIngredient() {
        return ingredientDAOImpl.getAllIngredient();
    }

}
