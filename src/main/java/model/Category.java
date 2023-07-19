package model;

import java.util.regex.Pattern;

public class Category {
    private static int lastId = 1;
    private final int categoryId;
    private String name;

    public Category(String name) {
        validateCategoryName(name);
        this.categoryId = lastId++;
        this.name = name;
    }

    private void validateCategoryName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        if (name.isBlank()) {
            throw new IllegalArgumentException("name cannot be blank");
        }
        if (name.length() == 0 || name.length() >= 50) {
            throw new IllegalArgumentException("Invalid name length");
        }
        if (!Pattern.matches("^[a-zA-Z ]+$", name)) {
            throw new IllegalArgumentException("Invalid characters");
        }
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
