package za.co.pattybakery.model;

import za.co.pattybakery.Order;
import za.co.pattybakery.Product;
import za.co.pattybakery.exception.OrderException;

/**
 *
 * @author Dimakatso Sebatane
 */
public class OrderImpl implements Order {

    private Product product;
    private Integer quantity;
    private Double totalPrice;

    public OrderImpl() {
    }

    public OrderImpl(Product product, Integer quantity, Double totalPrice) throws OrderException {
        this.setProduct(product);
        this.setQuantity(quantity);
        this.setTotalPrice(totalPrice);
    }

    @Override
    public void setProduct(Product product) throws OrderException {
        if (product == null) {
            throw new OrderException(ORDER_PRODUCT_ERROR_MSG);
        }
        this.product = product;
    }

    @Override
    public Product getProduct() {
        return product;
    }

    @Override
    public void setQuantity(Integer quantity) throws OrderException {
        if (quantity < 0) {
            throw new OrderException(ORDER_QUANTITY_ERROR_MSG);
        }
        this.quantity = quantity;
    }

    @Override
    public Integer getQuantity() {
        return quantity;
    }

    @Override
    public void setTotalPrice(Double totalPrice) throws OrderException {
        if (totalPrice < 0) {
            throw new OrderException(ORDER_TOTAL_PRICE_ERROR_MSG);
        }
        this.totalPrice = totalPrice;
    }

    @Override
    public Double getTotalPrice() {
        return totalPrice;
    }

}
