
package za.co.pattybakery.model;

/**
 *
 * @author Hlawulani
 */
import java.time.LocalDate;
import java.util.List;
import za.co.pattybakery.Order;
import za.co.pattybakery.ShoppingCart;
import za.co.pattybakery.exception.ShoppingCartException;

public abstract class ShoppingCartImpl implements ShoppingCart{
    private List<Order> orders;
    private Double totalPrice;
    private Integer orderNumber;
    private LocalDate date;

    public ShoppingCartImpl(List<Order> orders, Double totalPrice, Integer orderNumber, LocalDate date) {
        this.orders = orders;
        this.totalPrice = totalPrice;
        this.orderNumber = orderNumber;
        this.date = date;
    }
    
    @Override
    public void addOrder(Order order, List<Order> orders) throws ShoppingCartException{
        if(order == null && orders == null){
            throw new ShoppingCartException("");
        }
        orders.add(order);
    }
    
    @Override
    public List<Order> getOrders() {
        
        return orders;
    }

    @Override
    public Double getTotalprice() {
        
        return totalPrice;
    }

    @Override
    public Integer getOrderNumber() {
       
        return orderNumber;
    }

    @Override
    public LocalDate getDate() {
      
        return date;
    }
}
