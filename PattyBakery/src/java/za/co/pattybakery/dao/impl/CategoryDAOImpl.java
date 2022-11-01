package za.co.pattybakery.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import za.co.pattybakery.dao.CategoryDAO;

/**
 *
 * @author Hlawulani
 */
public class CategoryDAOImpl implements CategoryDAO {

    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public CategoryDAOImpl(PreparedStatement preparedStatement, ResultSet resultSet) {
        this.preparedStatement = preparedStatement;
        this.resultSet = resultSet;
    }

    @Override
    public void addCategory(String category) {

    }

    @Override
    public void updateCategory(Integer categoryId, String category) {

    }

    @Override
    public void removeCategory(Integer categoryId) {

    }

    @Override
    public List<String> getAllCategory() {
        return getAllCategory();
    }

}
