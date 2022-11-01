package za.co.pattybakery.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import za.co.pattybakery.dao.NutrientsDAO;

/**
 *
 * @author Hlawulani
 */
public class NutrientsDAOImpl implements NutrientsDAO{
    private PreparedStatement ps;
    private ResultSet rs;
    private Connection con = null;
    public NutrientsDAOImpl() {
        
    }

    @Override
    public void addNutrient(String nutrient) {
        try{
            if(con != null){
                ps = con.prepareStatement("INSERT INTO nutrient (nutrient) VALUE(?)");
                ps.setString(1, nutrient);
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
    public void updateNutrient(Integer nutrientId, String nutrient) {
        try{
            if(con != null){
                ps = con.prepareStatement("UPDATE nutrient SET nutrient = ? WHERE nutrientId = ?");
                ps.setString(1, nutrient);
                ps.setInt(1, nutrientId);
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
    public void removeNutrient(Integer nutrientId) {
        try{
            if(con != null){
                ps = con.prepareStatement("DELETE FROM nutrient WHERE nutrientId = ?");
                ps.setInt(1, nutrientId);
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
    public List<String> getAllNutrients() {
        List<String> nutrients = new ArrayList<>();
        try{
            if(con != null){
                ps = con.prepareStatement("SELECT * FROM nutrient");
                rs = ps.executeQuery();
                while(rs.next()){
                    nutrients.add(rs.getString("nutrient"));
                }
            }
        }
        catch(SQLException sql){
            System.out.println("Error: " + sql.getMessage());
        }
        finally{
            close(ps,rs);
        }
        return nutrients;
    }
    
}
