package za.co.pattyBakery.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import za.co.pattyBakery.database.DatabaseConnect;
import za.co.pattyBakery.Order;
import za.co.pattyBakery.Product;
import za.co.pattyBakery.ShoppingCart;
import za.co.pattyBakery.dao.OrderDAO;
import za.co.pattyBakery.exception.OrderException;
import za.co.pattyBakery.model.OrderImpl;
import za.co.pattyBakery.model.ShoppingCartImpl;

/**
 *
 * @author Dimakatso Sebatane
 */
public class OrderDAOImpl implements OrderDAO {

    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private Connection con = null;

    public OrderDAOImpl() {
        con = DatabaseConnect.getInstance().getConnection();
    }

    public OrderDAOImpl(Connection con) {
        this.con = con;
    }

    @Override
    public void addOrder(ShoppingCart shoppingCart) {
        try {
            if (con != null) {
                for (Order order : shoppingCart.getOrders()) {
                    preparedStatement = con.prepareStatement("INSERT IGNORE INTO orders VALUES(?,?,?,?,?);");
                    preparedStatement.setString(1, shoppingCart.getOrderNumber());
                    preparedStatement.setString(2, order.getProduct().getProductId());
                    preparedStatement.setInt(3, order.getQuantity());
                    preparedStatement.setBoolean(4, shoppingCart.getDeliveryStatus());
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
            if (con != null) {
                preparedStatement = con.prepareStatement("UPDATE orders  SET  delivered =?  WHERE order_id = ?");
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
            if (con != null) {
                preparedStatement = con.prepareStatement("DELETE  FROM orders WHERE order_id = ?");
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
            if (con != null) {
                preparedStatement = con.prepareStatement("SELECT * FROM orders");
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    order = new ShoppingCartImpl(getOrderById(resultSet.getString("order_id")),
                            resultSet.getString("order_id"),
                            resultSet.getDate("date").toLocalDate(),
                            resultSet.getBoolean("delivered"));
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

    @Override
    public List<Order> getOrderById(String orderId) {
        Order order = null;
        List<Order> orders = new ArrayList<>();
        try {
            if (con != null) {
                preparedStatement = con.prepareStatement("SELECT * FROM orders WHERE order_id=?");
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

    @Override
    public ShoppingCart getShoppingCartByOrderId(String orderId) {
        return new ShoppingCartImpl(getOrderById(orderId), orderId, LocalDate.now());
    }

}
