
package za.co.pattybakery;

public interface CheckOut {
    public void setShoppingCart(ShoppingCart shoppingCart);
    public ShoppingCart getShoppingCart();
    public void setPayment(Payment payment);
    public Payment getPayment();
    public void setAddress(String address);
    public String getAddress();
}
