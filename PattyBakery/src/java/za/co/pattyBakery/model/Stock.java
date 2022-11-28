package za.co.pattyBakery.model;

import za.co.pattyBakery.Product;
import za.co.pattyBakery.exception.OrderException;

/**
 *
 * @author Dimakatso Sebatane
 */
public class Stock extends OrderImpl {

    public Stock(Product product, Integer quantity, Double totalPrice) throws OrderException {
        super(product, quantity, totalPrice);
    }
}
