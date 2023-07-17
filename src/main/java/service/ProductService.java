package service;
import java.util.ArrayList;

public class ProductService {
    public class ProjectService {
        private List<Product> products;

        public ProjectService() {
            products = new ArrayList<>();
        }
        public void addProduct(double price, String name, Category category, int quantity) {
            Product product = new Product(price, name, category, quantity);
            products.add(product);

