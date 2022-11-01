package za.co.pattybakery.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import za.co.pattybakery.ShoppingCart;
import za.co.pattybakery.dao.OrderPriceDAO;

/**
 *
 * @author Dimakatso Sebatane
 */
public class OrderPriceDAOImpl implements OrderPriceDAO {
    
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private Connection conn = null;
    
    public OrderPriceDAOImpl() {
    }
    
    @Override
    public void addOrderPrice(ShoppingCart shoppingCart) {
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("INSERT INTO order_price VALUES(?,?);");
                preparedStatement.setString(1, shoppingCart.getOrderNumber());
                preparedStatement.setDouble(2, shoppingCart.getTotalprice());
                preparedStatement.executeUpdate();
            }
            
        } catch (SQLException sql) {
            System.out.println(String.format("Error: %s%n", sql.getMessage()));
        } finally {
            close(preparedStatement, resultSet);
        }
    }
    
    @Override
    public void updateOrderPriceTotalAmount(String orderId, Double totalAmount) {
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("UPDATE order_price SET  total_amount =?  WHERE order_id = ?");
                preparedStatement.setDouble(1, totalAmount);
                preparedStatement.setString(2, orderId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException sql) {
            System.out.println(String.format("Error: %s%n", sql.getMessage()));
        } finally {
            close(preparedStatement, resultSet);
        }
    }
    
    @Override
    public void removeOrderPrice(String orderId) {
        try {
            if (conn != null) {
                
                preparedStatement = conn.prepareStatement("DELETE  FROM order_price WHERE order_id = ?");
                preparedStatement.setString(1, orderId);
                preparedStatement.executeUpdate();
                
                new OrderDAOImpl().removeOrder(orderId);
            }
            
        } catch (SQLException sql) {
            System.out.println(String.format("Error: %s%n", sql.getMessage()));
        } finally {
            close(preparedStatement, resultSet);
            
        }
    }
    
}
