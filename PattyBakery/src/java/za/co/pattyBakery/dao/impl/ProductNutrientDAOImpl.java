package za.co.pattyBakery.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import za.co.pattyBakery.dao.NutrientsDAO;
import za.co.pattyBakery.dao.ProductNutrientDAO;
import za.co.pattyBakery.database.DatabaseConnect;

/**
 *
 * @author Dimakatso Sebatane
 */
public class ProductNutrientDAOImpl implements ProductNutrientDAO {

    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Connection con = null;

    public ProductNutrientDAOImpl() {
        con = DatabaseConnect.getInstance().getConnection();
    }

    public ProductNutrientDAOImpl(Connection con) {
        this.con = con;
    }

    @Override
    public void addProductNutrient(String productId, String nutrientId, Double grams) {
        try {
            if (con != null) {
                preparedStatement = con.prepareStatement("INSERT IGNORE INTO product_nutrient (prod_id,nutr_id,grams) VALUES(?,?,?)");
                preparedStatement.setString(1, productId);
                preparedStatement.setString(2, nutrientId);
                preparedStatement.setDouble(3, grams);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException sql) {
            System.out.println("Error: " + sql.getMessage());
        } finally {
            close(preparedStatement, resultSet);
        }
    }

    @Override
    public List<String> getNutrientsByProductId(String productId) {
        String nutrient = null;
        Set<String> nutrients = new HashSet<>();
        NutrientsDAO nutrientDAO = new NutrientsDAOImpl(con);
        try {
            if (con != null) {
                preparedStatement = con.prepareStatement("SELECT nutr_id FROM product_nutrient WHERE prod_id = ?");
                preparedStatement.setString(1, productId);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    nutrient = nutrientDAO.getNutrientById(resultSet.getString("nutr_id"));
                    nutrients.add(nutrient);
                }
            }
        } catch (SQLException sql) {
            System.out.println("Error: " + sql.getMessage());
        } finally {
            close(preparedStatement, resultSet);
        }
        return nutrients.stream().collect(Collectors.toList());
    }

    @Override
    public void removeNutrient(String nutrientId) {
        try {
            if (con != null) {
                preparedStatement = con.prepareStatement("DELETE FROM product_nutrient WHERE nutr_id = ?");
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
    public void removeProduct(String productId) {
        try {
            if (con != null) {
                preparedStatement = con.prepareStatement("DELETE FROM product_nutrient WHERE prod_id = ?");
                preparedStatement.setString(1, productId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException sql) {
            System.out.println("Error: " + sql.getMessage());
        } finally {
            close(preparedStatement, resultSet);
        }
    }
}
