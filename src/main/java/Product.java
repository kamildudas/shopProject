import org.example.Category;

public class Product {
    private static int nextId = 1;
    private int productId;
    private double price;
    private String name;
    private Category category;
    private int quantity;

    public Product(double price, String name, Category category, int quantity) {
        this.productId = nextId++;
        this.setPrice(price);
        this.setName(name);
        this.setCategory(category);
        this.setQuantity(quantity);
    }
    public int getProductId() {
        return productId;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        } else {
            throw new IllegalArgumentException("Price must be greater than 0.");
        }
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        if (name != null && !name.isBlank() && name.length() > 0 && name.length() < 50 && name.matches("[a-zA-Z]+")) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Invalid name. Name must not be null, blank, empty, or exceed 50 characters. Only alphabetical characters are allowed.");
        }
    }
    public Category getCategory() {
        return category;
    }

}
