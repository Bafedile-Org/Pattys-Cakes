package za.co.pattyBakery.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import za.co.pattyBakery.dao.RecipeDAO;
import za.co.pattyBakery.database.DatabaseConnect;
import za.co.pattyBakery.model.Recipe;

/**
 *
 * @author Dimakatso Sebatane
 */
public class RecipeDAOImpl implements RecipeDAO {

    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Connection con = null;

    public RecipeDAOImpl() {
        con = DatabaseConnect.getInstance().getConnection();
    }

    public RecipeDAOImpl(Connection con) {
        this.con = con;
    }

    @Override
    public void addRecipe(Recipe recipe) {
        try {
            if (con != null) {
                preparedStatement = con.prepareStatement("INSERT IGNORE INTO recipe (recp_id,descriptions) VALUES(?,?)");
                preparedStatement.setString(1, recipe.getRecipeId());
                preparedStatement.setString(2, recipe.getDescription());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException sql) {
            System.out.println("Error: " + sql.getMessage());
        } finally {
            close(preparedStatement, resultSet);
        }
    }

    @Override
    public Recipe getRecipeById(String recipeId) {
        Recipe recipe = null;
        if (con != null) {
            try {
                preparedStatement = con.prepareStatement("SELECT * FROM recipe  WHERE recp_id =?");
                preparedStatement.setString(1, recipeId);
                resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    recipe = new Recipe(recipeId, new RecipeIngredientsDAOImpl(con).getIngredientsByRecipeId(recipeId), resultSet.getString("descriptions"));
                }
            } catch (SQLException sql) {
                System.out.println(String.format("ERROR: %s%n", sql.getMessage()));
            }
        }
        return recipe;
    }

    @Override
    public List<Recipe> getRecipies() {
        Recipe recipe = null;
        Set<Recipe> recipies = new HashSet<>();
        try {
            if (con != null) {
                preparedStatement = con.prepareStatement("SELECT * FROM recipe");
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    recipe = getRecipeById(resultSet.getString("recp_id"));
                    recipies.add(recipe);
                }
            }
        } catch (SQLException sql) {
            System.out.println("Error: " + sql.getMessage());
        } finally {
            close(preparedStatement, resultSet);
        }
        return recipies.stream().collect(Collectors.toList());
    }

}
