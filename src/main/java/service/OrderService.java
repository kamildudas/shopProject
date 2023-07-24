package service;


import model.*;
import util.RandomUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static service.CategoryService.categories;
import static util.RandomUtil.randomizeString;

public class OrderService {
    private final List<Order> orders = generateOrder();

    public static List<Order> generateOrder() {
        List<Order> orderList = new ArrayList<>();
        Map<Product, Integer> productsMap = new HashMap<>();
        productsMap.put(ProductService.products.get(1), 2);
        orderList.add(new Order(RandomUtil.randomizeString(8),
                new Client("Jan", "Kowalski", "Warszawa"),
                OrderStatus.PAID,
                productsMap));
        Map<Product, Integer> productsMap2 = new HashMap<>();
        productsMap2.put(ProductService.products.get(0), 1);
        orderList.add(new Order(RandomUtil.randomizeString(8),
                new Client("Jan", "Kowalski", "Warszawa"),
                OrderStatus.PAID,
                productsMap2));
        Map<Product, Integer> productsMap3 = new HashMap<>();
        productsMap3.put(ProductService.products.get(2), 5);
        orderList.add(new Order(RandomUtil.randomizeString(8),
                new Client("Jan", "Kowalski", "Warszawa"),
                OrderStatus.PAID,
                productsMap3));
        Map<Product, Integer> productsMap4 = new HashMap<>();
        productsMap4.put(ProductService.products.get(3), 4);
        orderList.add(new Order(RandomUtil.randomizeString(8),
                new Client("Jan", "Kowalski", "Warszawa"),
                OrderStatus.PAID,
                productsMap4));
        return orderList;

    }

    public Order addOrder(String name, String surname,String address) {
        Order order = new Order(randomizeString(8), new Client(name, surname, address), OrderStatus.IN_PREPARATION,new HashMap<>());
        orders.add(order);
        return order;
    }

    public void removeOrder(int orderId) {
        orders.removeIf(order -> order.getOrderId() == orderId);
    }

    public void getAllOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders.");
        } else {
            for (Order order : orders) {
                System.out.println("Order number: " + order.getOrderId());
                System.out.println("Klient: " + order.getClient() );
                System.out.println("Order status: " + order.getOrderStatus());
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
