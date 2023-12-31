package service;

import model.Category;
import model.Order;

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

    public void getAllCategories() {
        for (Category category : categories) {
            System.out.println( "Category " + category.getName());
        }
    }


    public void getCategoryById(int categoryId) {
        for (Category category : categories) {
            if (category.getCategoryId() == categoryId) {
                System.out.println("Name category with ID " + categoryId + ": " + category.getName());
            return;
            }
        }
        System.out.println("No category found with ID  " + categoryId);
    }

    public List<Category> getCategories() {
        return categories;
    }
}
