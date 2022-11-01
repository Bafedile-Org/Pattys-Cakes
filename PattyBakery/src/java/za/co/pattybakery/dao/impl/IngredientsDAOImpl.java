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
public class IngredientsDAOImpl implements IngredientsDAO{
    private PreparedStatement ps;
    private ResultSet rs;
    private Connection con = null;

    public IngredientsDAOImpl() {
       
    }

    @Override
    public void addIngrideint(String ingredient) {
        try{
            if(con != null){
                ps = con.prepareStatement("INSERT INTO ingredient (ingredient) VALUE(?)");
                ps.setString(1, ingredient);
                ps.executeQuery();
            }
        }
        catch(SQLException sql){
            System.out.println("Error: " + sql.getMessage());
        }
        finally{
            close(ps,rs);
        }
    }

    @Override
    public void updateIngredient(Integer ingredientId, String ingredient) {
        try{
            if(con != null){
                ps = con.prepareStatement("UPDATE ingredient SET ingredient = ? WHERE ingredientId = ?");
                ps.setString(1, ingredient);
                ps.setInt(2, ingredientId);
                ps.executeQuery();
            }
        }
        catch(SQLException sql){
            System.out.println("Error: " + sql.getMessage());
        }
        finally{
            close(ps,rs);
        }
    }

    @Override
    public void removeIngredient(Integer ingredientId) {
        try{
            if(con != null){
                ps = con.prepareStatement("DELETE FROM ingredient WHERE ingredientId = ?");
                ps.setInt(1, ingredientId);
                ps.executeQuery();
            }
        }catch(SQLException sql){
            System.out.println("Error: " + sql.getMessage());
        }
        finally{
            close(ps,rs);
        }
    }

    @Override
    public List<String> getAllIngredient() {
        List<String> ingridiets = new ArrayList<>();
        try{
            if(con != null){
                ps = con.prepareStatement("SELECT * FROM ingredient");
                rs = ps.executeQuery();
                while(rs.next()){
                    ingridiets.add(rs.getString("ingredient"));
                }
            }
        }
        catch(SQLException sql){
            System.out.println("Error: " + sql.getMessage());
        }
        finally{
            close(ps,rs);
        }
        return ingridiets;
    }

}
