package service;

import model.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CategoryService {
    public static final List<Category> categories = generateCategory();

    public static List<Category> generateCategory() {
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category("petrol"));
        categoryList.add(new Category("electric"));
        categoryList.add(new Category("hybrid"));
        categoryList.add(new Category("diesel"));
        return categoryList;
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
