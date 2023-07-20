import model.*;
import service.CategoryService;
import service.OrderService;
import service.ProductService;

import java.util.Scanner;

public class Main {
    private static final OrderService ORDER_SERVICE = new OrderService();
    private static final CategoryService CATEGORY_SERVICE = new CategoryService();
    private static final ProductService PRODUCT_SERVICE = new ProductService();


    public static void main(String[] args) {

        Client client1 = new Client("Jan", "Kowalski", "Warszawa");
        Client client2 = new Client("Piotr", "Nowak", "Kraków");
        Client client3 = new Client("Krzysztof", "Jerzyna", "Szczecin");

        Order order1 = ORDER_SERVICE.addOrder(client1, OrderStatus.PAID);
        Order order2 = ORDER_SERVICE.addOrder(client2, OrderStatus.IN_PREPARATION);
        Order order3 = ORDER_SERVICE.addOrder(client3, OrderStatus.SHIPPED);

        Product product1 = PRODUCT_SERVICE.addProduct(100000, "AUDI", CATEGORY_SERVICE.getCategories().get(3));
        Product product2 = PRODUCT_SERVICE.addProduct(12000, "BMW", CATEGORY_SERVICE.getCategories().get(0));
        order1.add(product1, 1);
        order1.add(product2, 1);
        order2.add(product1, 2);
        order2.add(product2, 3);
    }


}