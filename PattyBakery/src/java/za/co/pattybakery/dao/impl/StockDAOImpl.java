package za.co.pattybakery.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import za.co.pattybakery.Product;
import za.co.pattybakery.dao.StockDAO;

/**
 *
 * @author Hlawulani
 */
public class StockDAOImpl implements StockDAO{
    private PreparedStatement ps;
    private ResultSet rs;
    private Connection con = null;
    public StockDAOImpl() {
       
    }

    @Override
    public void addStock(Product productId) {
        try{
            if(con != null){
                ps = con.prepareStatement("INSERT INTO stock (stock) VALUE(?)");
                
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
    public void updateStockQuantity(Integer productId, Integer quantity) {
        try{
            if (con != null){
                ps = con.prepareStatement("UPDATE product SET quantity = ? WHERE productId = ?");
                ps.setInt(1, quantity);
                ps.setInt(2, productId);
                ps.executeQuery();
            }
        }
        catch(SQLException sql){
            System.out.println("Error: "+ sql.getMessage());
        }
        finally{
            close(ps,rs);
        }
    }

    @Override
    public List<Product> getAllStocks() {
        List<Product> stock = new ArrayList<>();
        Product stocks = null;
        try{
            if(con != null){
                ps = con.prepareStatement("SELECT * FROM stock");
                rs = ps.executeQuery();
                while(rs.next()){
                    stock.add(stocks);
                }
            }
        }
        catch(SQLException sql){
            System.out.println("Error: " + sql.getMessage());
        }
        finally{
            close(ps,rs);
        }
        return stock;
    }

}
