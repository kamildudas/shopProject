package service;

import java.util.ArrayList;

public class ProductService {
    private List<Product> products;

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
        }
            else {
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

