package za.co.pattyBakery.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import za.co.pattyBakery.database.DatabaseConnect;

/**
 *
 * @author Dimakatso Sebatane
 */
public class RecipeIngredientsDAOImpl {

    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Connection con = null;

    public RecipeIngredientsDAOImpl() {
        con = DatabaseConnect.getInstance().getConnection();
    }

    public RecipeIngredientsDAOImpl(Connection con) {
        this.con = con;
    }
}
