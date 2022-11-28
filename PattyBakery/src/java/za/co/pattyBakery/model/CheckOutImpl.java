package za.co.pattyBakery.model;

/**
 *
 * @author Hlawulani
 */
import za.co.pattyBakery.CheckOut;
import za.co.pattyBakery.Payment;
import za.co.pattyBakery.ShoppingCart;
import za.co.pattyBakery.exception.CheckOutException;

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
