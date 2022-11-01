package za.co.pattybakery.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import za.co.pattybakery.Order;
import za.co.pattybakery.Product;
import za.co.pattybakery.ShoppingCart;
import za.co.pattybakery.dao.OrderDAO;
import za.co.pattybakery.exception.OrderException;
import za.co.pattybakery.model.OrderImpl;
import za.co.pattybakery.model.ShoppingCartImpl;

/**
 *
 * @author Dimakatso Sebatane
 */
public class OrderDAOImpl implements OrderDAO {

    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private Connection conn = null;

    public OrderDAOImpl() {
    }

    @Override
    public void addOrder(ShoppingCart shoppingCart) {
        try {
            if (conn != null) {
                for (Order order : shoppingCart.getOrders()) {
                    preparedStatement = conn.prepareStatement("INSERT INTO order VALUES(?,?,?,?,?);");
                    preparedStatement.setString(1, shoppingCart.getOrderNumber());
                    preparedStatement.setString(2, order.getProduct().getProductId());
                    preparedStatement.setBoolean(3, shoppingCart.getDeliveryStatus());
                    preparedStatement.setInt(4, order.getQuantity());
                    preparedStatement.setDate(5, Date.valueOf(shoppingCart.getDate()));
                    preparedStatement.executeUpdate();
                }
                new OrderPriceDAOImpl().addOrderPrice(shoppingCart);
            }
        } catch (SQLException sql) {
            System.out.println(String.format("Error: %s%n", sql.getMessage()));

        } finally {
            close(preparedStatement, resultSet);
        }
    }

    @Override
    public void updateOrderDeliveryStatus(String orderId, Boolean status) {
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("UPDATE order  SET  delivery_status =?  WHERE order_id = ?");
                preparedStatement.setBoolean(1, status);
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
    public void removeOrder(String orderId) {
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("DELETE  FROM order WHERE order_id = ?");
                preparedStatement.setString(1, orderId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException sql) {
            System.out.println(String.format("Error: %s%n", sql.getMessage()));
        } finally {
            close(preparedStatement, resultSet);

        }
    }

    @Override
    public List<ShoppingCart> getAllOrders() {
        Set<ShoppingCart> orders = new HashSet<>();
        ShoppingCart order;
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("SELECT * FROM order");
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    order = new ShoppingCartImpl(getOrderById(resultSet.getString("order_id")),
                            resultSet.getString("order_id"),
                            resultSet.getDate("date").toLocalDate(),
                            resultSet.getBoolean("delivery_status"));
                    orders.add(order);
                }
            }

        } catch (SQLException sql) {
            System.out.println(String.format("Error: %s%n", sql.getMessage()));
        } finally {
            close(preparedStatement, resultSet);

        }
        return orders.stream().collect(Collectors.toList());
    }

    public List<Order> getOrderById(String orderId) {
        Order order = null;
        List<Order> orders = new ArrayList<>();
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("SELECT * FROM order WHERE orderId=?");
                preparedStatement.setString(1, orderId);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Product product = new ProductDAOImpl().getProductById(resultSet.getString("prod_id"));
                    order = new OrderImpl(product, resultSet.getInt("quantity"), product.getPrice());
                    orders.add(order);
                }
            }

        } catch (SQLException | OrderException sql) {
            System.out.println(String.format("Error: %s%n", sql.getMessage()));
        } finally {
            close(preparedStatement, resultSet);

        }

        return orders;
    }

}
