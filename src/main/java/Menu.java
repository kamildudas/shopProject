import model.Category;
import service.CategoryService;
import service.ProductService;

import java.util.List;
import java.util.Scanner;

public class Menu {
    private static final Scanner scanner = new Scanner(System.in);
    private final CategoryService categoryService = new CategoryService();
    private final ProductService productService = new ProductService();

    public void showMainMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Orders");
            System.out.println("2. Categories");
            System.out.println("3. Products");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> showOrdersSubMenu();
                case 2 -> showCategoriesSubMenu();
                case 3 -> showProductsSubMenu();
                case 4 -> exit = true;
                default -> System.out.println("Wrong choice!");
            }

            System.out.println();
        }
    }

    public void showOrdersSubMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("[1] List of orders");
            System.out.println("[2, ID] Specific order");
            System.out.println("[3] Add order");
            System.out.println("[4, ID] Remove order");
            System.out.println("[5] Change status");
            System.out.println("[6] Show status");
            System.out.println("[7] Back");

            String choice = scanner.next();
            String[] words = choice.split(",");

            scanner.nextLine();
/*
            switch (choice) {
                case 1 ->ORDER_SERVICE.getAllOrders();
                case 2 ->ORDER_SERVICE.getOrderById();
                case 3 ->ORDER_SERVICE.addOrder();
                case 4 ->ORDER_SERVICE.removeOrder();
                case 5 ->ORDER_SERVICE.
                case 6 ->ORDER_SERVICE.changeOrderStatus();
                case 7 ->ORDER_SERVICE.getOrderStatus()
                case 8 -> ;
                case 9 -> back = true;
                default -> System.out.println("Wrong choice!");
            }

            System.out.println();
        }
        */
        }
    }

    public void showCategoriesSubMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("[1] List of categories");
            System.out.println("[2] Add category");
            System.out.println("[3] Remove category");
            System.out.println("[4] Get category");

            String choice = scanner.next();
            String[] words = choice.split(",");

            scanner.nextLine();

            switch (Integer.parseInt(words[0])) {
                case 1 -> categoryService.getAllCategories();
                case 2 -> categoryService.addCategory((words[1]));
                case 3 -> categoryService.removeCategory(Integer.parseInt(words[1]));
                case 4 -> categoryService.getCategoryById(Integer.parseInt(words[1]));
                case 5 -> back = true;
                default -> System.out.println("Wrong choice!");
            }
        }
    }
        public void showProductsSubMenu() {
            boolean back = false;
            while (!back) {
                System.out.println("[1] List of products");
                System.out.println("[2, ID] Specific product");
                System.out.println("[3, price, name, category] Add product");
                System.out.println("[4, ID] Remove product");
                System.out.println("[5] Back");

                String choice = scanner.next();
                String[] words = choice.split(",");

                scanner.nextLine();

                switch (Integer.parseInt(words[0])) {
                    case 1 -> productService.getAllProducts();
                   // case 2 -> productService.addProduct(Double.parseDouble(words[1]), words[2], )
                    case 5 -> back = true;

                }
            }
        }
    }