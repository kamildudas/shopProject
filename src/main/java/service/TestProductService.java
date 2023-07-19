package service;

import model.Product;
import org.junit.Assert;
import org.junit.Test;

public class TestProductService {

    @Test
    public void testAddProduct() {

        //Given
        ProductService productService = new ProductService();

        //When
        productService.addProduct(30000.0, "Toyota Prius", Category.HYBRID, 5);;

        //Then
        Assert.assertEquals(1, productService.getAllProducts().size());
        Product addedProduct = productService.getAllProducts().get(0);
        Assert.assertEquals(30000.0, addedProduct.getPrice(), 0.001);
        Assert.assertEquals("Toyota Prius", addedProduct.getName());
        Assert.assertEquals(Category.HYBRID, addedProduct.getCategory());
        Assert.assertEquals(5, addedProduct.getQuantity());
    }
}
