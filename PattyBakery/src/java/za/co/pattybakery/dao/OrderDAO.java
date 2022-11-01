package za.co.pattybakery.dao;

import java.util.List;
import za.co.pattybakery.Order;
import za.co.pattybakery.ShoppingCart;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface OrderDAO extends Close {

    void addOrder(ShoppingCart order);

    void updateOrderDeliveryStatus(String orderId, Boolean status);

    void removeOrder(String orderId);

    List<ShoppingCart> getAllOrders();

    public List<Order> getOrderById(String orderId);

}
