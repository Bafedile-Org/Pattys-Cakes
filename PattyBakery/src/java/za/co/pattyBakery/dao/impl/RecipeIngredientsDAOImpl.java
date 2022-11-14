package za.co.pattyBakery.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import za.co.pattyBakery.dao.RecipeIngredientsDAO;
import za.co.pattyBakery.database.DatabaseConnect;
import za.co.pattyBakery.model.Recipe;

/**
 *
 * @author Dimakatso Sebatane
 */
public class RecipeIngredientsDAOImpl implements RecipeIngredientsDAO {

    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Connection con = null;

    public RecipeIngredientsDAOImpl() {
        con = DatabaseConnect.getInstance().getConnection();
    }

    public RecipeIngredientsDAOImpl(Connection con) {
        this.con = con;
    }

    @Override
    public void addRecipeIngredient(Recipe recipe) {
        try {
            if (con != null) {
                for (int i = 0; i < recipe.getIngredients().size(); i++) {
                    preparedStatement = con.prepareStatement("INSERT IGNORE INTO recipe_ingredients (recp_id,ingr_id) VALUE(?,?)");
                    preparedStatement.setString(1, recipe.getRecipeId());
                    preparedStatement.setString(2, recipe.getIngredients().get(i));
                    preparedStatement.executeUpdate();
                }
            }
        } catch (SQLException sql) {
            System.out.println("Error: " + sql.getMessage());
        } finally {
            close(preparedStatement, resultSet);
        }
    }

    @Override
    public List<String> getIngredientsByRecipeId(String recipeId) {
        List<String> ingredients = new ArrayList<>();
        try {
            if (con != null) {
                preparedStatement = con.prepareStatement("SELECT ingr_id FROM recipe_ingredient WHERE recp_id =?");
                preparedStatement.setString(1, recipeId);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String ingredient = new IngredientsDAOImpl().getIngredientById(resultSet.getString("ingr_id"));
                    ingredients.add(ingredient);
                }
            }
        } catch (SQLException sql) {
            System.out.println("Error: " + sql.getMessage());
        } finally {
            close(preparedStatement, resultSet);
        }
        return ingredients;
    }

    @Override
    public void addIngredientToRecipe(String recipeId, String ingredientId) {
        try {
            if (con != null) {

                preparedStatement = con.prepareStatement("INSERT IGNORE INTO recipe_ingredient (ingr_id) VALUES(?)");
                preparedStatement.setString(1, recipeId);
                preparedStatement.setString(2, ingredientId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException sql) {
            System.out.println("Error: " + sql.getMessage());
        } finally {
            close(preparedStatement, resultSet);
        }
    }

}
