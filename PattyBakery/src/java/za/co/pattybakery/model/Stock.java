package za.co.pattybakery.model;

import za.co.pattybakery.Product;
import za.co.pattybakery.exception.OrderException;

/**
 *
 * @author Dimakatso Sebatane
 */
public class Stock extends OrderImpl {

    public Stock(Product product, Integer quantity, Double totalPrice) throws OrderException {
        super(product, quantity, totalPrice);
    }
}
