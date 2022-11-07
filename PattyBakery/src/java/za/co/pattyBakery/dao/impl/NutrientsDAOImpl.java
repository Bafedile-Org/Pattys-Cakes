package za.co.pattybakery.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import za.co.pattyBakery.database.DatabaseConnect;
import za.co.pattybakery.dao.NutrientsDAO;

/**
 *
 * @author Hlawulani
 */
public class NutrientsDAOImpl implements NutrientsDAO {

    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Connection con = null;

    public NutrientsDAOImpl() {
        con = DatabaseConnect.getInstance().getConnection();
    }

    public NutrientsDAOImpl(Connection con) {
        this.con = con;
    }

    @Override
    public void addNutrient(String nutrientId, String nutrient) {
        try {
            if (con != null) {
                preparedStatement = con.prepareStatement("INSERT INTO nutrients VALUE(?,?)");
                preparedStatement.setString(1, nutrientId);
                preparedStatement.setString(2, nutrient);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException sql) {
            System.out.println("Error: " + sql.getMessage());
        } finally {
            close(preparedStatement, resultSet);
        }
    }

    @Override
    public void updateNutrient(String nutrientId, String nutrient) {
        try {
            if (con != null) {
                preparedStatement = con.prepareStatement("UPDATE nutrients SET nutrient = ? WHERE ingr_id = ?");
                preparedStatement.setString(1, nutrient);
                preparedStatement.setString(2, nutrientId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException sql) {
            System.out.println("Error: " + sql.getMessage());
        } finally {
            close(preparedStatement, resultSet);
        }
    }

    @Override
    public void removeNutrient(String nutrientId) {
        try {
            if (con != null) {
                preparedStatement = con.prepareStatement("DELETE FROM nutrients WHERE ingr_id = ?");
                preparedStatement.setString(1, nutrientId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException sql) {
            System.out.println("Error: " + sql.getMessage());
        } finally {
            close(preparedStatement, resultSet);
        }
    }

    @Override
    public String getNutrientById(String nutrientId) {
        String nutrient = null;
        try {
            if (con != null) {
                preparedStatement = con.prepareStatement("SELECT nutrient FROM nutrients WHERE nutr_id =?");
                preparedStatement.setString(1, nutrientId);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    nutrient = resultSet.getString("nutrient");
                }
            }
        } catch (SQLException sql) {
            System.out.println("Error: " + sql.getMessage());
        } finally {
            close(preparedStatement, resultSet);
        }
        return nutrient;
    }

    @Override
    public List<String> getAllNutrients() {
        List<String> nutrients = new ArrayList<>();
        try {
            if (con != null) {
                preparedStatement = con.prepareStatement("SELECT * FROM nutrients");
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    nutrients.add(resultSet.getString("nutrient"));
                }
            }
        } catch (SQLException sql) {
            System.out.println("Error: " + sql.getMessage());
        } finally {
            close(preparedStatement, resultSet);
        }
        return nutrients;
    }

    public void addRecipe() {
        List<String> ingredientIdList = new IngredientsDAOImpl().getAllIngredient();
        List<String> recipeIdList = getAllNutrients();
        Integer[] chocolateCookies = {4, 39, 23, 1, 3, 2, 17, 13, 19};
        Integer[] plainCoffeeCookies = {4, 39, 23, 1, 3, 2, 17, 1, 19};
        Integer[] vanilaCookies = {4, 39, 23, 1, 3, 2, 17, 13, 19};
    }
}
