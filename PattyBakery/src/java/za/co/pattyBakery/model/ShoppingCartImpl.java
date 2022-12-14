package za.co.pattyBakery.model;

/**
 *
 * @author Hlawulani
 */
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import za.co.pattyBakery.Order;
import za.co.pattyBakery.ShoppingCart;
import za.co.pattyBakery.exception.ShoppingCartException;

public class ShoppingCartImpl implements ShoppingCart {

    private List<Order> cartOrders;
    private List<List<Order>> myOrders;
    private Double totalPrice = 0.0;
    private String orderNumber;
    private LocalDate date;
    private Boolean deliveryStatus;

    public ShoppingCartImpl(List<Order> orders, String orderNumber, LocalDate date) {
        cartOrders = orders;
        myOrders = new ArrayList<>();
        setOrders(cartOrders);
        this.orderNumber = orderNumber;
        this.date = date;
        this.deliveryStatus = false;
        totalPrice = getTotalprice();

    }

    public ShoppingCartImpl(List<Order> orders, Double totalPrice, String orderNumber, LocalDate date) {
        cartOrders = orders;
        myOrders = new ArrayList<>();
        setOrders(cartOrders);
        this.totalPrice = totalPrice;
        this.orderNumber = orderNumber;
        this.date = date;
        this.deliveryStatus = false;
        totalPrice = getTotalprice();

    }

    public ShoppingCartImpl(List<Order> orders, String orderNumber, LocalDate date, Boolean deliveryStatus) {
        cartOrders = orders;
        myOrders = new ArrayList<>();
        setOrders(cartOrders);
        this.orderNumber = orderNumber;
        this.date = date;
        this.deliveryStatus = deliveryStatus;
        totalPrice = getTotalprice();

    }

    @Override
    public void setOrders(List<Order> orders) {
        cartOrders = orders;
        myOrders.add(cartOrders);
    }

    @Override
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Override
    public void addOrder(Order order, List<Order> orders) throws ShoppingCartException {
        if (order == null || orders == null) {
            throw new ShoppingCartException("");
        }
        setOrders(orders);
    }

    @Override
    public List<Order> getOrders() {

        return cartOrders;
    }

    @Override
    public Double getTotalprice() {
        totalPrice = 0.0;
        if (getAllOrders() != null) {
            for (Order order : getAllOrders()) {
                totalPrice += order.getTotalPrice();
            }
        }
        return Double.valueOf(String.format("%.2f", totalPrice));
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

    @Override
    public List<Order> getAllOrders() {
        List<Order> allOrders = new ArrayList<>();
        if (myOrders != null) {
            for (List<Order> orders : myOrders) {
                for (Order order : orders) {
                    if (!checkOrderExists(allOrders, order)) {
                        allOrders.add(order);
                    }
                }
            }
        }
        return allOrders;
    }

    private Boolean checkOrderExists(List<Order> myOrders, Order order) {
        for (Order or : myOrders) {
            if (or.getProduct().getProductId().equals(order.getProduct().getProductId())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void removeAllFromCart(String productId) {
        List<Order> ordersToRemove = new ArrayList<>();
        if (!productId.equalsIgnoreCase("removeAll")) {
            for (List<Order> orders : myOrders) {
                for (Order order : orders) {
                    if (order.getProduct().getProductId().equals(productId)) {
                        ordersToRemove.add(order);
                    }
                }
                orders.removeAll(ordersToRemove);
                ordersToRemove.clear();
            }
        } else {
            for (List<Order> orders : myOrders) {
                for (Order order : orders) {
                    ordersToRemove.add(order);
                }
                orders.removeAll(ordersToRemove);
                ordersToRemove.clear();
            }
        }

    }
}
