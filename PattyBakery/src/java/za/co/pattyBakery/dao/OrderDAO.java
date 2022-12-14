package za.co.pattyBakery.dao;

import java.time.LocalDate;
import java.util.List;
import za.co.pattyBakery.Order;
import za.co.pattyBakery.ShoppingCart;

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

    public ShoppingCart getShoppingCartByOrderId(String orderId);

    public void updateOrderDeliveryDate(String orderId, LocalDate date);

    public List<String> getOrderAllIds();

}
