package service;

import model.Category;
import model.Product;

import java.util.ArrayList;
import java.util.List;

import static service.CategoryService.categories;


public class ProductService {
    public static List<Product> products = generateProductList();

    public ProductService() {
    }

    public static List<Product> generateProductList() {

        List<Product> productList = new ArrayList<>();
        productList.add(new Product(10000, "Toyota Prius", categories.get(0)));
        productList.add(new Product(25000, "BMW X3", categories.get(1)));
        productList.add(new Product(5000, "Volkswagen Multivan", categories.get(2)));
        productList.add(new Product(100000, "Audi A4", categories.get(3)));

        return productList;
    }


    public Product addProduct(double price, String name, int categoryId) {
        Category foundCategory = null;
        for (Category category : categories) {
            if (category.getCategoryId() == categoryId) {
                foundCategory = category;
                break;
            }
        }
        if (foundCategory == null) {
            throw new RuntimeException("Category doesn't exist");
        }

        Product product = new Product(price, name, foundCategory);
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

    public void getAllProducts() {
        for (Product product : products) {
            System.out.println("ID: " + product.getProductId() + " Name: " + product.getName() + " Price: " + product.getPrice() + " Category: " + product.getCategory());
        }
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

