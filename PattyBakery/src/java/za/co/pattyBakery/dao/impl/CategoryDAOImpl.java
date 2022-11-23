package za.co.pattyBakery.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import za.co.pattyBakery.database.DatabaseConnect;
import za.co.pattyBakery.dao.CategoryDAO;

/**
 *
 * @author Hlawulani
 */
public class CategoryDAOImpl implements CategoryDAO {

    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Connection con = null;

    public CategoryDAOImpl() {
        con = DatabaseConnect.getInstance().getConnection();
    }

    public CategoryDAOImpl(Connection con) {
        this.con = con;
    }

    @Override
    public void addCategory(Integer categoryId, String category) {
        try {
            if (con != null) {
                preparedStatement = con.prepareStatement("INSERT IGNORE INTO category (cat_id,category) VALUES(?,?)");
                preparedStatement.setInt(1, categoryId);
                preparedStatement.setString(2, category);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException sql) {
            System.out.println("Error occured..!!" + sql.getMessage());
        } finally {
            close(preparedStatement, resultSet);
        }
    }

    @Override
    public void updateCategory(Integer cat_id, String category) {
        try {
            if (con != null) {
                preparedStatement = con.prepareStatement("UPDATE category SET category =? WHERE cat_id = ?");
                preparedStatement.setString(1, category);
                preparedStatement.setInt(2, cat_id);
                preparedStatement.executeQuery();
            }
        } catch (SQLException sql) {
            System.out.println("Error: " + sql.getMessage());
        } finally {
            close(preparedStatement, resultSet);
        }
    }

    @Override
    public void removeCategory(Integer cat_id) {
        try {
            if (con != null) {
                preparedStatement = con.prepareStatement("DELETE FROM category WHERE cat_id = ?");
                preparedStatement.setInt(1, cat_id);
                preparedStatement.executeQuery();
            }
        } catch (SQLException sql) {
            System.out.println("Error: " + sql.getMessage());
        }
    }

    @Override
    public String getCategoryById(Integer categoryId) {
        String category = null;
        try {
            if (con != null) {
                preparedStatement = con.prepareStatement("SELECT category FROM category WHERE cat_id =?");
                preparedStatement.setInt(1, categoryId);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    category = resultSet.getString("category");
                }
            }
        } catch (SQLException sql) {
            System.out.println("Error: " + sql.getMessage());
        } finally {
            close(preparedStatement, resultSet);
        }
        return category;
    }

    @Override
    public Integer getCategoryIdByName(String category) {
        Integer catId = null;
        try {
            if (con != null) {
                preparedStatement = con.prepareStatement("SELECT cat_id FROM category WHERE category =?");
                preparedStatement.setString(1, category);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    catId = resultSet.getInt("cat_id");
                }
            }
        } catch (SQLException sql) {
            System.out.println("Error: " + sql.getMessage());
        } finally {
            close(preparedStatement, resultSet);
        }
        return catId;
    }

    @Override
    public List<String> getAllCategory() {
        List<String> categories = new ArrayList<>();

        try {
            if (con != null) {
                preparedStatement = con.prepareStatement("SELECT * FROM category");
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    categories.add(resultSet.getString("category"));
                }
            }
        } catch (SQLException sql) {
            System.out.println("Error: " + sql.getMessage());
        } finally {
            close(preparedStatement, resultSet);
        }
        return categories;
    }

}
