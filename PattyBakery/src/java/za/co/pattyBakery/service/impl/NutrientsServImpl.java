package za.co.pattyBakery.service.impl;

import java.util.List;
import za.co.pattyBakery.dao.NutrientsDAO;

/**
 *
 * @author Bridget Bapela
 */
public class NutrientsServImpl implements NutrientsDAO {

    private NutrientsDAO nutrientsDAOImpl;

    public NutrientsServImpl(NutrientsDAO nutrientsDAOImpl) {
        this.nutrientsDAOImpl = nutrientsDAOImpl;
    }

    @Override
    public void addNutrient(String nutrientId, String nutrient) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateNutrient(String nutrientId, String nutrient) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeNutrient(String nutrientId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNutrientById(String nutrientId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> getAllNutrients() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
