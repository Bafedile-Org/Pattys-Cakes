
package za.co.pattybakery.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import za.co.pattybakery.dao.NutrientsDAO;

/**
 *
 * @author Hlawulani
 */
public class NutrientsDAOImpl implements NutrientsDAO{
    private PreparedStatement ps;
    private ResultSet rs;

    public NutrientsDAOImpl(PreparedStatement preparedStatement, ResultSet resultSet) {
        this.ps = preparedStatement;
        this.rs = resultSet;
    }

    @Override
    public void addNutrient(String nutrient) {
        ps.addBatch(nutrient);
    }

    @Override
    public void updateNutrient(Integer nutrientsId, String nutrients) {
        
    }

    @Override
    public void removeNutrient(Integer nutrientsId) {
        
    }

    @Override
    public List<String> getAllNutrients() {
        return getAllNutrients();
    }

    @Override
    public void close(PreparedStatement preparedStatement, ResultSet resultsSet) {
        
    }
}
