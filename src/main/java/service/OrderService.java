package service;


import model.Category;
import model.Client;
import model.Order;
import model.OrderStatus;
import util.RandomUtil;

import java.util.ArrayList;
import java.util.List;

import static util.RandomUtil.randomizeString;

public class OrderService {
    private final List<Order> orders = new ArrayList<>();
    public static List<Order> generateOrder() {
        List<Order> orderList = new ArrayList<>();
        orderList.add(new Order(RandomUtil.randomizeString(8), new Client("Jan", "Kowalski", "Warszawa"), OrderStatus.PAID));
        orderList.add(new Order(RandomUtil.randomizeString(8), new Client("Piotr", "Nowak", "Kraków"), OrderStatus.SHIPPED));
        orderList.add(new Order(RandomUtil.randomizeString(8), new Client("Zofia", "Malinowska", "Wrocław"), OrderStatus.CANCELED));
        orderList.add(new Order(RandomUtil.randomizeString(8), new Client("Bolesław", "Krzywousty", "Chrząszczyrzewoszyce"), OrderStatus.IN_PREPARATION));
        return orderList;

    }
    public Order addOrder(String name, String surname,String address) {
        Order order = new Order(randomizeString(8), new Client(name, surname, address), OrderStatus.IN_PREPARATION);
        orders.add(order);
        return order;
    }

    public void removeOrder(int orderId) {
        orders.removeIf(order -> order.getOrderId() == orderId);
    }

    public void getAllOrders() {
        //   List<Order> orders = getAllOrders();
        if (orders.isEmpty()) {
            System.out.println("No orders.");
        } else {
            for (Order order : orders) {
                System.out.println("Order number: " + order.getOrderId());
            //    System.out.println("Klient: " + );
              //  System.out.println("Order status: " + getOrderStatus());
            }
        }
    }

    public Order getOrderById(int orderId) {
        return orders.stream()
                .filter(order -> order.getOrderId() == orderId)
                .findFirst()
                .orElse(null);
    }

    public OrderStatus getOrderStatus(int orderId) {
        Order order = getOrderById(orderId);
        if (order != null) {
            return order.getOrderStatus();
        } else {
            System.out.println("Order with ID " + orderId + " not found.");
            return null;
        }
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
