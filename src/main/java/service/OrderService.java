package service;


import model.Client;
import model.Order;
import model.OrderStatus;

import java.util.ArrayList;
import java.util.List;

import static util.RandomUtil.randomizeString;

public class OrderService {
    private final List<Order> orders = new ArrayList<>();
    public Order addOrder(String name, String surname,String address) {
        Order order = new Order(randomizeString(8), new Client(name, surname, address), OrderStatus.IN_PREPARATION);
        orders.add(order);
        return order;
    }

    public void removeOrder(int orderId) {
        orders.removeIf(order -> order.getOrderId() == orderId);
    }

    public List<Order> getAllOrders() {
        return orders;
    }

    public Order getOrderById(int orderId) {
        return orders.stream()
                .filter(order -> order.getOrderId() == orderId)
                .findFirst()
                .orElse(null);
    }

    public OrderStatus getOrderStatus(int orderId) {
        Order order = getOrderById(orderId);
        return order != null ? order.getOrderStatus() : null;
    }

    public void changeOrderStatus(int orderId, OrderStatus newStatus) {
        Order order = getOrderById(orderId);
        if (order != null) {
            order.setOrderStatus(newStatus);
        } else {
            throw new IllegalArgumentException("Order with ID " + orderId + " not found.");
        }
    }

}
