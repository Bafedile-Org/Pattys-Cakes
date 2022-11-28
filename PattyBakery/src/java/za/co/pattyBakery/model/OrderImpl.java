package za.co.pattyBakery.model;

import za.co.pattyBakery.Order;
import za.co.pattyBakery.Product;
import za.co.pattyBakery.exception.OrderException;

/**
 *
 * @author Dimakatso Sebatane
 */
public class OrderImpl implements Order {

    private Product product;
    private Integer quantity;
    private Double totalPrice = 0.0;
    static private Double productPrice = 0.0;

    public OrderImpl() {
    }

    public OrderImpl(Product product, Double productPrice) throws OrderException {
        this.productPrice = productPrice;
        this.setProduct(product);
        this.setQuantity(1);
        this.setTotalPrice(productPrice);
    }

    public OrderImpl(Product product, Integer quantity) throws OrderException {
        this.setProduct(product);
        this.setQuantity(quantity);
    }

    public OrderImpl(Product product, Integer quantity, Double productPrice) throws OrderException {
        this.setProduct(product);
        this.setQuantity(quantity);
        this.setTotalPrice(productPrice);
        this.productPrice = productPrice;
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
        setTotalPrice(productPrice);
    }

    @Override
    public Integer getQuantity() {
        return quantity;
    }

    @Override
    public void setTotalPrice(Double productPrice) throws OrderException {
        if (totalPrice < 0) {
            throw new OrderException(ORDER_TOTAL_PRICE_ERROR_MSG);
        }
        this.totalPrice = productPrice * quantity;
    }

    @Override
    public Double getTotalPrice() {
        return totalPrice;
    }

}
