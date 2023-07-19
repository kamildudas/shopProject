package service;

import model.Category;
import model.Product;

import java.util.ArrayList;
import java.util.List;


public class ProductService {
    private final List<Product> products = generateProductList();
    private CategoryService categoryService;

    public ProductService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public List<Product> generateProductList() {
        Category petrol = categoryService.getCategories().get(0);
        Category electric = categoryService.getCategories().get(1);
        Category hybrid = categoryService.getCategories().get(2);
        Category diesel = categoryService.getCategories().get(3);
        return List.of(new Product(30000.0, "Toyota Prius", petrol),
                new Product(10000.0, "Mercedes-Benz", hybrid),
                new Product(10000.0, "BMW", electric),
                new Product(5000.0, "Audi A4", diesel));

    }


    public Product addProduct(double price, String name, Category category) {
        Product product = new Product(price, name, category);
        products.add(product);
        return product;
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

