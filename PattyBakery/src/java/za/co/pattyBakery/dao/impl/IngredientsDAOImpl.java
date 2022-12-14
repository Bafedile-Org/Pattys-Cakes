package za.co.pattyBakery.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import za.co.pattyBakery.dao.IngredientsDAO;
import za.co.pattyBakery.database.DatabaseConnect;

/**
 *
 * @author Hlawulani
 */
public class IngredientsDAOImpl implements IngredientsDAO {

    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Connection con = null;

    public IngredientsDAOImpl() {
        con = DatabaseConnect.getInstance().getConnection();
    }

    public IngredientsDAOImpl(Connection con) {
        this.con = con;
    }

    @Override
    public void addIngridient(String ingredientId, String ingredient, Integer quantity) {
        try {
            if (con != null) {
                preparedStatement = con.prepareStatement("INSERT IGNORE INTO ingredients (ingr_id,ingredient,quantity) VALUE(?,?,?)");
                preparedStatement.setString(1, ingredientId);
                preparedStatement.setString(2, ingredient);
                preparedStatement.setInt(3, quantity);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException sql) {
            System.out.println("Error: " + sql.getMessage());
        } finally {
            close(preparedStatement, resultSet);
        }
    }

    @Override
    public void updateIngredientQuantity(String ingredientId, Integer quantity) {
        try {
            if (con != null) {
                preparedStatement = con.prepareStatement("UPDATE ingredients SET quantity = ? WHERE ingr_id = ?");
                preparedStatement.setInt(1, quantity);
                preparedStatement.setString(2, ingredientId);
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
    public String getIngredientByIdName(String ingredient) {
        String ingredientId = null;
        try {
            if (con != null) {
                preparedStatement = con.prepareStatement("SELECT ingr_id FROM ingredients WHERE ingredient =?");
                preparedStatement.setString(1, ingredient);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    ingredientId = resultSet.getString("ingr_id");
                }
            }
        } catch (SQLException sql) {
            System.out.println("Error: " + sql.getMessage());
        } finally {
            close(preparedStatement, resultSet);
        }
        return ingredientId;
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

    @Override
    public List<String> getAllIngredientsId() {
        List<String> ingridientsId = new ArrayList<>();
        try {
            if (con != null) {
                preparedStatement = con.prepareStatement("SELECT ingr_id FROM ingredients");
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    ingridientsId.add(resultSet.getString("ingr_id"));
                }
            }
        } catch (SQLException sql) {
            System.out.println("Error: " + sql.getMessage());
        } finally {
            close(preparedStatement, resultSet);
        }
        return ingridientsId;
    }

    @Override
    public Integer getQuantityByID(String ingredientId) {
        int quantity = 0;
        try {
            if (con != null) {
                preparedStatement = con.prepareStatement("SELECT quantity FROM ingredients WHERE ingr_id=?");
                preparedStatement.setString(1, ingredientId);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {

                    quantity = resultSet.getInt("quantity");

                }
            }
        } catch (SQLException sql) {
            System.out.println("Error: " + sql.getMessage());
        } finally {
            close(preparedStatement, resultSet);
        }
        return quantity;

    }
}
