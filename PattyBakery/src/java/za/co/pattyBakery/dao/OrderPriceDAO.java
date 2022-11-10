package za.co.pattyBakery.dao;

import za.co.pattyBakery.ShoppingCart;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface OrderPriceDAO extends Close {

    void addOrderPrice(ShoppingCart shoppingCart);

    void updateOrderPriceTotalAmount(String orderId, Double totalAmount);

    void removeOrderPrice(String orderId);
}
