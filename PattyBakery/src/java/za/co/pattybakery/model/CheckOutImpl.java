
package za.co.pattybakery.model;

import za.co.pattybakery.CheckOut;
import za.co.pattybakery.Payment;
import za.co.pattybakery.ShoppingCart;

public class CheckOutImpl implements CheckOut{
    private ShoppingCart shoppingCart;
    private String address;
    private Payment payment;

    public CheckOutImpl(ShoppingCart shoppingCart, String address, Payment payment) {
        this.shoppingCart = shoppingCart;
        this.address = address;
        this.payment = payment;
    }
    
    @Override
    public void setShoppingCart(ShoppingCart shoppingCart){
        if(shoppingCart == null){
            setShoppingCart(shoppingCart);
        }
        this.shoppingCart = shoppingCart;
    }
    
    @Override
    public ShoppingCart getShoppingCart() {
        
        return shoppingCart;
    }

    @Override
    public void setPayment(Payment payment) {
        if(payment == null){
            setPayment(payment);
        }
        this.payment = payment;
    }

    @Override
    public Payment getPayment() {
       
        return payment;
    }

    @Override
    public void setAddress(String address) {
        if(address == null){
            setAddress(address);
        }
        this.address = address;
    }

    @Override
    public String getAddress() {
       
        return address;
    }
}
