package za.co.pattyBakery.model;

/**
 *
 * @author Hlawulani
 */
import java.time.LocalDate;
import java.util.List;
import za.co.pattyBakery.Order;
import za.co.pattyBakery.ShoppingCart;
import za.co.pattyBakery.exception.ShoppingCartException;

public class ShoppingCartImpl implements ShoppingCart {

    private List<Order> orders;
    private Double totalPrice = 0.0;
    private String orderNumber;
    private LocalDate date;
    private Boolean deliveryStatus;

    public ShoppingCartImpl(List<Order> orders, String orderNumber, LocalDate date) {
        this.orders = orders;
        this.orderNumber = orderNumber;
        this.date = date;
        this.deliveryStatus = false;
        totalPrice = getTotalprice();
    }

    public ShoppingCartImpl(List<Order> orders, Double totalPrice, String orderNumber, LocalDate date) {
        this.orders = orders;
        this.totalPrice = totalPrice;
        this.orderNumber = orderNumber;
        this.date = date;
        this.deliveryStatus = false;
        totalPrice = getTotalprice();
    }

    public ShoppingCartImpl(List<Order> orders, String orderNumber, LocalDate date, Boolean deliveryStatus) {
        this.orders = orders;
        this.orderNumber = orderNumber;
        this.date = date;
        this.deliveryStatus = deliveryStatus;
        totalPrice = getTotalprice();
    }

    @Override
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Override
    public void addOrder(Order order, List<Order> orders) throws ShoppingCartException {
        if (order == null && orders == null) {
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
        totalPrice = 0.0;
        if (orders != null) {
            for (Order order : orders) {
                totalPrice += order.getTotalPrice();
            }
        }
        return totalPrice;
    }

    @Override
    public String getOrderNumber() {

        return orderNumber;
    }

    @Override
    public LocalDate getDate() {

        return date;
    }

    @Override

    public Boolean getDeliveryStatus() {
        return deliveryStatus;
    }
    public void setStatus(Boolean deliveryStatus){
        this.deliveryStatus = deliveryStatus;
    }
}
