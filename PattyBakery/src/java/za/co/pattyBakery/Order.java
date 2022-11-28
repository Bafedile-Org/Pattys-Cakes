package za.co.pattyBakery;

import za.co.pattyBakery.exception.OrderException;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface Order {

    String ORDER_QUANTITY_ERROR_MSG = "Quantity Cannot Be Less Than 0!!";
    String ORDER_PRODUCT_ERROR_MSG = "Product Cannot Be Null !!";
    String ORDER_TOTAL_PRICE_ERROR_MSG = "Total Price Cannot Be Less Than 0!!";

    void setProduct(Product product) throws OrderException;

    Product getProduct();

    void setQuantity(Integer quantity) throws OrderException;

    Integer getQuantity();

    void setTotalPrice(Double price) throws OrderException;

    Double getTotalPrice();
}
