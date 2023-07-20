package service;

import model.Category;
import model.Product;

import java.util.ArrayList;
import java.util.List;


public class ProductService {
    public List<Product> products = generateProductList();
    private CategoryService categoryService;

    public ProductService() {
    }



    public static List<Product> generateProductList() {

        List<Product> productList = new ArrayList<>();
        productList.add(new Product(10000, "Toyota Prius", CategoryService.categories.get(0)   ));
        productList.add(new Product(25000, "BMW X3", CategoryService.categories.get(1)));
        productList.add(new Product(5000, "Volkswagen Multivan",CategoryService.categories.get(2) ));
        productList.add(new Product(100000, "Audi A4", CategoryService.categories.get(3)));

        return productList;
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

