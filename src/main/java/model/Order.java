package model;

import util.RandomUtil;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private static int lastOrderId = 1;

    private final int orderId;
    private final String orderNumber;
    private final Client client;
    private OrderStatus orderStatus;
    private final Map<Product, Integer> products;



    public Order(final String orderNumber, final Client client, final OrderStatus orderStatus, Map<Product, Integer> products) {
        this.orderId = lastOrderId++;
        this.orderNumber = RandomUtil.randomizeString(8);
        this.client = client;
        this.orderStatus = orderStatus;
        this.products = products;
    }


    public void add(final Product product, final int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        if (products.containsKey(product)) {
            Integer integer = products.get(product);
            products.put(product, integer + quantity);
        } else {
            products.put(product, quantity);
        }
    }

    void remove(Product product) {
        products.remove(product);
    }

    double getSum() {
        return products.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }

    public int getOrderId() {
        return orderId;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
    public Client getClient() {
        return client;
    }
}