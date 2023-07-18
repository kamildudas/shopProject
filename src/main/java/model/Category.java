package model;

import java.util.regex.Pattern;

public class Category {
    private static int lastId = 1;
    private final int categoryId;
    private String name;

    public Category(String name) {
        validateProductName(name);
        this.categoryId = lastId++;
        this.name = name;
    }


    private boolean validateProductName(String name) {
        if (name == null || name.isBlank() || name.length() == 0 || name.length() >= 50) {
            throw new IllegalArgumentException("Name must not be null, blank, empty, or exceed 50 characters.");
        }
        if (!Pattern.matches("^[a-zA-Z ]+$", name)) {
            throw new IllegalArgumentException("Name can only contain alphabetic characters and spaces.");
        }
        return true;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
