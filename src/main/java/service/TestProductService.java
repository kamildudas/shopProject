package service;

import model.Category;
import model.Product;
import org.junit.Assert;
import org.junit.Test;

public class TestProductService {

    @Test
    public void testAddProduct() {

        //Given
        Category category = new Category("Hybrid");
        Product product = new Product(30000.0, "Toyota Prius", category);
        ProductService productService = new ProductService();

        //When
        productService.addProduct(product.getPrice(), product.getName(), 1);

        //Then
        Product resultProduct = null;
        for (Product product1 : productService.products) {
            if (product1.getName().equals("Toyota Prius")) {
                resultProduct = product1;
                break;
            }
        }
        if (resultProduct != null) {
            Assert.assertEquals(resultProduct.getName(), product.getName());
        }


    }
}
