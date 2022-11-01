
package za.co.pattybakery;

/**
 *
 * @author Hlawulani
 */
import java.time.LocalDate;
import java.util.List;
import za.co.pattybakery.exception.ShoppingCartException;

public interface ShoppingCart {
    public void addOrder(Order order, List<Order> orders) throws ShoppingCartException;
    public List<Order> getOrders();
    public Double getTotalprice();
    public Integer getOrderNumber();
    public LocalDate getDate();
}
