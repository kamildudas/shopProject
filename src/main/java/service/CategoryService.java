package service;

import model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryService {
    private final List<Category> categories;

    public CategoryService() {
        categories = new ArrayList<>();
    }

    public void addCategory(String name) {
        Category category = new Category(name);
        categories.add(category);
    }

    public void removeCategory(int categoryId) {
        Category categoryToRemove = null;
        for (Category category : categories) {
            if (category.getCategoryId() == categoryId) {
                categoryToRemove = category;
                break;
            }
        }

        if (categoryToRemove != null) {
            categories.remove(categoryToRemove);
        } else {
            throw new IllegalArgumentException("Category with ID " + categoryId + " not found.");
        }
    }

    public List<Category> getAllCategories() {
        return categories;
    }

    public Category getCategoryById(int categoryId) {
        for (Category category : categories) {
            if (category.getCategoryId() == categoryId) {
                return category;
            }
        }
        return null;
    }
}
