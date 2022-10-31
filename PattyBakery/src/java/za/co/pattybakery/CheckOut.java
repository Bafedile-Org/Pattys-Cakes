
package za.co.pattybakery;

import za.co.pattybakery.exception.CheckOutException;

public interface CheckOut {
    public void setShoppingCart(ShoppingCart shoppingCart)throws CheckOutException ;
    public ShoppingCart getShoppingCart();
    public void setPayment(Payment payment)throws CheckOutException ;
    public Payment getPayment();
    public void setAddress(String address)throws CheckOutException ;
    public String getAddress();
}
