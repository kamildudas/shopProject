package model;

import java.util.regex.Pattern;

public class Category {
    private static int lastId = 0;
    private final int categoryId;
    private String name;

    public Category(String name) {
        validateName(name);

        lastId++;
        this.categoryId = lastId;
        this.name = name;
    }

    private void validateName(String name) {
        if (name == null || name.isBlank() || name.length() == 0 || name.length() >= 50) {
            throw new IllegalArgumentException("Name must not be null, blank, empty, or exceed 50 characters.");
        }
        if (!Pattern.matches("^[a-zA-Z ]+$", name)) {
            throw new IllegalArgumentException("Name can only contain alphabetic characters and spaces.");
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
