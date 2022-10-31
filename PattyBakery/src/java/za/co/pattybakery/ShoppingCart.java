
package za.co.pattybakery;

import java.time.LocalDate;
import java.util.List;

public interface ShoppingCart {
    public void addOrder(Order order, List<Order> orders);
    public List<Order> getOrders();
    public Double getTotalprice();
    public Integer getOrderNumber();
    public LocalDate getDate();
}
