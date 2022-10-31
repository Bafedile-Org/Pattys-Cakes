package za.co.pattybakery;

import za.co.pattybakery.exception.CheckOutException;

public interface CheckOut {

    String SHOPPING_CART_ERROR_MSG = "Shopping Cart Cannot Be Null!!";
    String PAYMENT_ERROR_MSG = "Payment Can Not Be Null or Less Than The Amount Owning!!";
    String ADDRESS_ERROR_MSG = "Address Can Not Be Null!!";

    public void setShoppingCart(ShoppingCart shoppingCart) throws CheckOutException;

    public ShoppingCart getShoppingCart();

    public void setPayment(Payment payment) throws CheckOutException;

    public Payment getPayment();

    public void setAddress(String address) throws CheckOutException;

    public String getAddress();
}
