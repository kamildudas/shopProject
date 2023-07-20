package model;

public class Product {
    private static int nextId = 1;
    private final int productId;
    private double price;
    private String name;
    private Category category;

    public Product(double price, String name, Category category) {
        this.productId = nextId++;
        this.price = price;
        this.name = name;
        this.category = category;
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
            throw new IllegalArgumentException("Invalid name.");
        }
    }

    public Category getCategory() {
        return category;
    }
}

