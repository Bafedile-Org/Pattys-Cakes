package za.co.pattyBakery.service.impl;

import java.util.List;
import za.co.pattyBakery.Order;
import za.co.pattyBakery.ShoppingCart;
import za.co.pattyBakery.dao.OrderDAO;
import za.co.pattyBakery.dao.impl.OrderDAOImpl;

/**
 *
 * @author Bridget Bapela
 */
public class OrderServImpl implements OrderDAO {

    private OrderDAO orderDAOImpl;

    public OrderServImpl() {
        this.orderDAOImpl = new OrderDAOImpl();
    }

    @Override
    public void addOrder(ShoppingCart order) {
        if (order == null) {

        }
        orderDAOImpl.addOrder(order);
    }

    @Override
    public void updateOrderDeliveryStatus(String orderId, Boolean status) {
        if (orderId == null || status == null) {
            return;
        }
        orderDAOImpl.updateOrderDeliveryStatus(orderId, status);
    }

    @Override
    public void removeOrder(String orderId) {
        if (orderId == null) {
            return;
        }
        orderDAOImpl.removeOrder(orderId);
    }

    @Override
    public List<ShoppingCart> getAllOrders() {
        return orderDAOImpl.getAllOrders();
    }

    @Override
    public List<Order> getOrderById(String orderId) {
        return orderDAOImpl.getOrderById(orderId);
    }

    @Override
    public ShoppingCart getShoppingCartByOrderId(String orderId) {
        return orderDAOImpl.getShoppingCartByOrderId(orderId);
    }

}
