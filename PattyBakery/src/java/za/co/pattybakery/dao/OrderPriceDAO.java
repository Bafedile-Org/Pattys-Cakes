package za.co.pattybakery.dao;

import za.co.pattybakery.ShoppingCart;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface OrderPriceDAO extends Close {

    void addOrderPrice(ShoppingCart shoppingCart);

    void updateOrderPriceTotalAmount(String orderId, Double totalAmount);

    void removeOrderPrice(String orderId);
}
