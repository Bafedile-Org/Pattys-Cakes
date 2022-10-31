
package za.co.pattybakery.model;

import java.time.LocalDate;
import java.util.List;
import za.co.pattybakery.ShoppingCart;

public class ShoppingCartImpl implements ShoppingCart{
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
    public void <>(Order order, List<Order> orders) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Order> getOrders() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Double getTotalprice() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer getOrderNumber() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public LocalDate getDate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
