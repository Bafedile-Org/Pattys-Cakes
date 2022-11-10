package za.co.pattyBakery.service.impl;

import za.co.pattyBakery.ShoppingCart;
import za.co.pattyBakery.dao.OrderPriceDAO;

/**
 *
 * @author Bridget Bapela
 */
public class OrdePriceServImpl implements OrderPriceDAO {

    private OrderPriceDAO orderPriceDAOImpl;

    public OrdePriceServImpl(OrderPriceDAO orderPriceDAOImpl) {
        this.orderPriceDAOImpl = orderPriceDAOImpl;
    }

    @Override
    public void addOrderPrice(ShoppingCart shoppingCart) {
        if (shoppingCart == null) {
            return;
        }
        orderPriceDAOImpl.addOrderPrice(shoppingCart);
    }

    @Override
    public void updateOrderPriceTotalAmount(String orderId, Double totalAmount) {
        if (orderId == null || totalAmount <= 0) {
            return;
        }
        orderPriceDAOImpl.updateOrderPriceTotalAmount(orderId, totalAmount);
    }

    @Override
    public void removeOrderPrice(String orderId) {
        if (orderId == null) {
            return;
        }
        orderPriceDAOImpl.removeOrderPrice(orderId);
    }

}
