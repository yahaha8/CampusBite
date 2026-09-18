package campusbite;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static MenuManager menuManager = new MenuManager();
    static OrderManager orderManager = new OrderManager();

    public static void main(String[] args) {
        menuManager.loadDefaultMenu();

        while (true) {
            System.out.println("\n===== CAMPUSBITE =====");
            System.out.println("1. Student");
            System.out.println("2. Admin");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = readInt();

            if (choice == 1) {
                studentMenu();
            } else if (choice == 2) {
                adminMenu();
            } else if (choice == 3) {
                System.out.println("Thank you for using CampusBite!");
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }

    static void studentMenu() {
        Cart cart = new Cart();

        while (true) {
            System.out.println("\n----- STUDENT MENU -----");
            System.out.println("1. View Menu");
            System.out.println("2. Search Food");
            System.out.println("3. Add to Cart");
            System.out.println("4. Remove from Cart");
            System.out.println("5. View Cart");
            System.out.println("6. Place Order");
            System.out.println("7. Order History");
            System.out.println("8. Back");
            System.out.print("Enter choice: ");
            int choice = readInt();

            switch (choice) {
                case 1 -> menuManager.displayMenu();
                case 2 -> searchFood();
                case 3 -> addToCart(cart);
                case 4 -> removeFromCart(cart);
                case 5 -> cart.displayCart();
                case 6 -> placeOrder(cart);
                case 7 -> orderManager.displayOrders();
                case 8 -> { return; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    static void searchFood() {
        System.out.print("Enter food name: ");
        String name = sc.nextLine();
        menuManager.searchFood(name);
    }

    static void addToCart(Cart cart) {
        menuManager.displayMenu();
        System.out.print("Enter food ID: ");
        int id = readInt();
        FoodItem food = menuManager.findFood(id);

        if (food == null || !food.isAvailable()) {
            System.out.println("Food item not available.");
            return;
        }

        System.out.print("Enter quantity: ");
        int quantity = readInt();

        if (quantity <= 0) {
            System.out.println("Invalid quantity.");
            return;
        }

        cart.addItem(food, quantity);
    }

    static void removeFromCart(Cart cart) {
        cart.displayCart();
        if (cart.isEmpty()) return;

        System.out.print("Enter food ID: ");
        int id = readInt();
        cart.removeItem(id);
    }

    static void placeOrder(Cart cart) {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }

        Order order = orderManager.placeOrder(cart);
        order.display();
        cart.clear();
    }

    static void adminMenu() {
        while (true) {
            System.out.println("\n----- ADMIN MENU -----");
            System.out.println("1. View Menu");
            System.out.println("2. Add Food");
            System.out.println("3. Remove Food");
            System.out.println("4. Change Availability");
            System.out.println("5. View Orders");
            System.out.println("6. Update Order Status");
            System.out.println("7. Back");
            System.out.print("Enter choice: ");
            int choice = readInt();

            switch (choice) {
                case 1 -> menuManager.displayMenu();
                case 2 -> addFood();
                case 3 -> removeFood();
                case 4 -> changeAvailability();
                case 5 -> orderManager.displayOrders();
                case 6 -> updateStatus();
                case 7 -> { return; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    static void addFood() {
        System.out.print("Food name: ");
        String name = sc.nextLine();
        System.out.print("Category: ");
        String category = sc.nextLine();
        System.out.print("Price: ");
        double price = readDouble();

        menuManager.addFood(name, category, price);
        System.out.println("Food added.");
    }

    static void removeFood() {
        menuManager.displayMenu();
        System.out.print("Food ID: ");
        int id = readInt();

        if (menuManager.removeFood(id)) {
            System.out.println("Food removed.");
        } else {
            System.out.println("Food not found.");
        }
    }

    static void changeAvailability() {
        menuManager.displayMenu();
        System.out.print("Food ID: ");
        int id = readInt();

        FoodItem food = menuManager.findFood(id);
        if (food == null) {
            System.out.println("Food not found.");
            return;
        }

        food.setAvailable(!food.isAvailable());
        System.out.println("Availability updated.");
    }

    static void updateStatus() {
        orderManager.displayOrders();
        if (orderManager.isEmpty()) return;

        System.out.print("Order ID: ");
        int id = readInt();

        System.out.println("1. PREPARING");
        System.out.println("2. READY");
        System.out.println("3. COMPLETED");
        System.out.println("4. CANCELLED");
        System.out.print("Choose status: ");
        int choice = readInt();

        OrderStatus status;
        switch (choice) {
            case 1 -> status = OrderStatus.PREPARING;
            case 2 -> status = OrderStatus.READY;
            case 3 -> status = OrderStatus.COMPLETED;
            case 4 -> status = OrderStatus.CANCELLED;
            default -> {
                System.out.println("Invalid status.");
                return;
            }
        }

        if (orderManager.updateStatus(id, status)) {
            System.out.println("Order status updated.");
        } else {
            System.out.println("Order not found.");
        }
    }

    static int readInt() {
        while (true) {
            try {
                int value = Integer.parseInt(sc.nextLine());
                return value;
            } catch (NumberFormatException e) {
                System.out.print("Enter a valid number: ");
            }
        }
    }

    static double readDouble() {
        while (true) {
            try {
                double value = Double.parseDouble(sc.nextLine());
                if (value > 0) return value;
                System.out.print("Enter a positive price: ");
            } catch (NumberFormatException e) {
                System.out.print("Enter a valid price: ");
            }
        }
    }
}
