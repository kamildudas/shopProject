package service;

import model.Category;
import model.Product;

import java.util.ArrayList;
import java.util.List;


public class ProductService {
    private List<Product> products;

    Product car1 = new Product( 123, 30000.0, "Toyota Prius", "Hybrid", 5);
    Product car2 = new Product(234, 25000.0, "Honda Accord", "Petrol", 3);
    Product car3 = new Product(345, 40000.0, "Ford Mustang", "Diesel", 2);
    Product car4 = new Product(456, 35000.0, "Chevrolet Camaro", "Diesel", 4);
    Product car5 = new Product(567,28000.0, "Tesla", "Electric", 6);
    Product car6 = new Product(678, 45000.0, "BMW X5", "Hybrid", 1);
    Product car7 = new Product(789,20000.0, "Hyundai I30", "Petrol", 8);
    Product car8 = new Product(890, 38000.0, "Audi A4", "Diesel", 2);
    Product car9 = new Product(901, 32000.0, "Nissan Leaf", "Electric", 4);
    Product car10 = new Product(210, 42000.0, "Mercedes-Benz C-Class", "Petrol", 3);


    public void ProductService() {
        products = new ArrayList<>();
    }

    public void addProduct(double price, String name, Category category, int quantity) {
        Product product = new Product(price, name, category, quantity);
        products.add(product);
    }

    public void removeProduct(int productId) {
        Product productToRemove = null;
        for (Product product : products) {
            if (product.getProductId() == productId) {
                productToRemove = product;
                break;
            }
        }
        if (productToRemove != null) {
            products.remove(productToRemove);
        } else {
            throw new IllegalArgumentException("Product with ID " + productId + " not found.");
        }
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProductById(int productId) {
        for (Product product : products) {
            if (product.getProductId() == productId) {
                return product;
            }
        }
        return null;
    }
}

