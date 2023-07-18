package service;

import model.Category;
import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private List<Product> products;

    public ProductService() {
        products = new ArrayList<>();
    }

    public void addProduct(double price, String name, Category category, int quantity) {
        Product product = new Product(price, name, category, quantity);
        products.add(product);
    }
}

