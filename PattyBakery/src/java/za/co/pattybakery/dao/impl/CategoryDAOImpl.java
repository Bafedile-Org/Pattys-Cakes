package za.co.pattybakery.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import za.co.pattybakery.dao.CategoryDAO;

/**
 *
 * @author Hlawulani
 */
public class CategoryDAOImpl implements CategoryDAO {

    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Connection con = null;
   
    public CategoryDAOImpl(){
    }
    @Override
    public void addCategory(String category) {
        try{
            if(con != null){
                preparedStatement = con.prepareStatement("INSERT INTO category (category) VALUES(?)");
                preparedStatement.setString(1, category);
                preparedStatement.executeUpdate();
            }
        }
        catch(SQLException sql){
            System.out.println("Error occured..!!" + sql.getMessage());
        }
        finally{
            close(preparedStatement, resultSet);
        }
    }

    @Override
    public void updateCategory(Integer categoryId, String category) {
        try{
            if(con != null){
                preparedStatement = con.prepareStatement("UPDATE category SET category =? WHERE categoryId = ?");
                preparedStatement.setString(1, category);
                preparedStatement.setInt(2, categoryId);
                preparedStatement.executeQuery();
            }
        }catch(SQLException sql){
            System.out.println("Error: " + sql.getMessage());       
        }
        finally{
            close(preparedStatement, resultSet);
        }
    }

    @Override
    public void removeCategory(Integer categoryId) {
        try{
            if(con != null){
                preparedStatement = con.prepareStatement("DELETE FROM category WHERE categoryId = ?");
                preparedStatement.setInt(1, categoryId);
                preparedStatement.executeQuery();
            }
        }
        catch(SQLException sql){
            System.out.println("Error: " + sql.getMessage());
        }
    }
    @Override
    public List<String> getAllCategory() {
        List<String> categories = new ArrayList<>();
        
        try{
        if(con != null){
            preparedStatement = con.prepareStatement("SELECT * FROM category");
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
            categories.add(resultSet.getString("category"));
             }
        }
    }
    catch(SQLException sql){
        System.out.println("Error: " + sql.getMessage());
    }
        finally{
        close(preparedStatement, resultSet);
    }
        return categories;
    }
}
