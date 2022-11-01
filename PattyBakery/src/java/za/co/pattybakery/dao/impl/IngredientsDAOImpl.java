package za.co.pattybakery.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import za.co.pattybakery.dao.IngredientsDAO;

/**
 *
 * @author Hlawulani
 */
public class IngredientsDAOImpl implements IngredientsDAO {

    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public IngredientsDAOImpl(PreparedStatement preparedStatement, ResultSet resultSet) {
        this.preparedStatement = preparedStatement;
        this.resultSet = resultSet;
    }

    @Override
    public void addIngrideint(String ingredient) {

    }

    @Override
    public void updateIngredient(Integer ingredientId, String ingredient) {

    }

    @Override
    public void removeIngredient(Integer ingredientId) {

    }

    @Override
    public List<String> getAllIngredient() {
        return null;
    }

}
