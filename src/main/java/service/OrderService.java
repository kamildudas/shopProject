package service;

import model.Client;
import model.Order;
import model.OrderStatus;

public class OrderService {
    String generateOrderNumber(){

    }
    public Order createOrder(Client client){
        return new Order(generateOrderNumber(), client, OrderStatus.IN_PREPARATION);
    }

}
