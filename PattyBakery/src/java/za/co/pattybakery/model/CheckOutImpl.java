
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
    public void setShoppingCart(ShoppingCart shoppingCart) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ShoppingCart getShoppingCart() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setPayment(Payment payment) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Payment getPayment() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setAddress(String address) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getAddress() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
