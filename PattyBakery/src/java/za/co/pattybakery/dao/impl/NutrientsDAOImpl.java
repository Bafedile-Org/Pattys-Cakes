package za.co.pattybakery.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import za.co.pattybakery.dao.NutrientsDAO;

/**
 *
 * @author Hlawulani
 */
public class NutrientsDAOImpl implements NutrientsDAO {

    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public NutrientsDAOImpl(PreparedStatement preparedStatement, ResultSet resultSet) {
        this.preparedStatement = preparedStatement;
        this.resultSet = resultSet;
    }

    @Override
    public void addNutrient(String nutrient) {

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

}
