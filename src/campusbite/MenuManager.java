package campusbite;

import java.util.ArrayList;

public class MenuManager {
    private ArrayList<FoodItem> menu = new ArrayList<>();
    private int nextId = 1;

    public void loadDefaultMenu() {
        addFood("Veg Burger", "Snacks", 60);
        addFood("Masala Dosa", "South Indian", 70);
        addFood("Cold Coffee", "Beverages", 50);
        addFood("Paneer Roll", "Snacks", 80);
        addFood("Fried Rice", "Meals", 90);
        addFood("Chole Bhature", "Meals", 100);
        addFood("French Fries", "Snacks", 50);
        addFood("Lemonade", "Beverages", 40);
    }

    public void addFood(String name, String category, double price) {
        menu.add(new FoodItem(nextId++, name, category, price));
    }

    public void displayMenu() {
        System.out.println("\n================ FOOD MENU ================");
        System.out.printf("%-5s %-20s %-15s %-10s %-10s%n",
                "ID", "Food", "Category", "Price", "Status");
        System.out.println("----------------------------------------------------------");

        for (FoodItem food : menu) {
            food.display();
        }
    }

    public void searchFood(String name) {
        boolean found = false;

        for (FoodItem food : menu) {
            if (food.getName().toLowerCase().contains(name.toLowerCase())) {
                food.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No food item found.");
        }
    }

    public FoodItem findFood(int id) {
        for (FoodItem food : menu) {
            if (food.getId() == id) {
                return food;
            }
        }
        return null;
    }

    public boolean removeFood(int id) {
        FoodItem food = findFood(id);

        if (food != null) {
            menu.remove(food);
            return true;
        }

        return false;
    }
}
