package za.co.pattyBakery;

/**
 *
 * @author Hlawulani
 */
import java.time.LocalDate;
import java.util.List;
import za.co.pattyBakery.exception.ShoppingCartException;

public interface ShoppingCart {

    public void addOrder(Order order, List<Order> orders) throws ShoppingCartException;

    public List<Order> getOrders();

    public Double getTotalprice();

    public String getOrderNumber();

    public LocalDate getDate();

    public Boolean getDeliveryStatus();
}
