import java.util.Scanner;

public class Menu {
    private static final Scanner scanner = new Scanner(System.in);
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
               /* case 2 -> showCategoriesSubMenu();
                case 3 -> ShowProductsSubMenu();*/
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
}
