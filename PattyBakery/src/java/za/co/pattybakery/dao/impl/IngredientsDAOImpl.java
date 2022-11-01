package za.co.pattybakery.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import za.co.pattybakery.dao.IngredientsDAO;

/**
 *
 * @author Hlawulani
 */
public class IngredientsDAOImpl implements IngredientsDAO {

    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Connection con = null;

    public IngredientsDAOImpl() {

    }

    @Override
    public void addIngridient(String ingredient, Integer quantity) {
        try {
            if (con != null) {
                preparedStatement = con.prepareStatement("INSERT INTO ingredients (ingredient,quantity) VALUE(?,?)");
                preparedStatement.setString(1, ingredient);
                preparedStatement.setInt(2, quantity);
                preparedStatement.executeQuery();
            }
        } catch (SQLException sql) {
            System.out.println("Error: " + sql.getMessage());
        } finally {
            close(preparedStatement, resultSet);
        }
    }

    @Override
    public void updateIngredient(Integer ingredientId, String ingredient) {
        try {
            if (con != null) {
                preparedStatement = con.prepareStatement("UPDATE ingredients SET ingredient = ? WHERE ingr_id = ?");
                preparedStatement.setString(1, ingredient);
                preparedStatement.setInt(2, ingredientId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException sql) {
            System.out.println("Error: " + sql.getMessage());
        } finally {
            close(preparedStatement, resultSet);
        }
    }

    @Override
    public void removeIngredient(String ingredientId) {
        try {
            if (con != null) {
                preparedStatement = con.prepareStatement("DELETE FROM ingredients WHERE ingr_id = ?");
                preparedStatement.setString(1, ingredientId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException sql) {
            System.out.println("Error: " + sql.getMessage());
        } finally {
            close(preparedStatement, resultSet);
        }
    }

    @Override
    public String getIngredientById(String ingredientId) {
        String ingredient = null;
        try {
            if (con != null) {
                preparedStatement = con.prepareStatement("SELECT ingredient FROM ingredients WHERE ingr_id =?");
                preparedStatement.setString(1, ingredientId);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    ingredient = resultSet.getString("ingredient");
                }
            }
        } catch (SQLException sql) {
            System.out.println("Error: " + sql.getMessage());
        } finally {
            close(preparedStatement, resultSet);
        }
        return ingredient;
    }

    @Override
    public List<String> getAllIngredient() {
        List<String> ingridients = new ArrayList<>();
        try {
            if (con != null) {
                preparedStatement = con.prepareStatement("SELECT * FROM ingredients");
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    ingridients.add(resultSet.getString("ingredient"));
                }
            }
        } catch (SQLException sql) {
            System.out.println("Error: " + sql.getMessage());
        } finally {
            close(preparedStatement, resultSet);
        }
        return ingridients;
    }

}
