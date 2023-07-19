package service;

import model.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CategoryService {
    private final List<Category> categories = generateCategory();

    public List<Category> generateCategory() {

        return Stream.of("petrol", "electric", "hybrid", "diesel")
                .map(Category::new)
                .toList();
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

    public List<Category> getCategories() {
        return categories;
    }
}
