package za.co.pattybakery.model;

/**
 *
 * @author Hlawulani
 */

import za.co.pattybakery.CheckOut;
import za.co.pattybakery.Payment;
import za.co.pattybakery.ShoppingCart;
import za.co.pattybakery.exception.CheckOutException;

public class CheckOutImpl implements CheckOut {

    private ShoppingCart shoppingCart;
    private String address;
    private Payment payment;

    public CheckOutImpl(ShoppingCart shoppingCart, String address, Payment payment) {
        this.shoppingCart = shoppingCart;
        this.address = address;
        this.payment = payment;
    }

    @Override
    public void setShoppingCart(ShoppingCart shoppingCart) throws CheckOutException {
        if (shoppingCart == null) {
            throw new CheckOutException(SHOPPING_CART_ERROR_MSG);
        }
        this.shoppingCart = shoppingCart;
    }

    @Override
    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    @Override
    public void setPayment(Payment payment) throws CheckOutException {
        if (payment == null) {
            throw new CheckOutException(PAYMENT_ERROR_MSG);
        }
        if (payment.getAmount() < shoppingCart.getTotalprice()) {
            throw new CheckOutException(PAYMENT_ERROR_MSG);
        }
        this.payment = payment;
    }

    @Override
    public Payment getPayment() {

        return payment;
    }

    @Override
    public void setAddress(String address) throws CheckOutException {
        if (address == null) {
            throw new CheckOutException(ADDRESS_ERROR_MSG);
        }
        this.address = address;
    }

    @Override
    public String getAddress() {

        return address;
    }
}
