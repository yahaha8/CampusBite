package campusbite;

import java.util.ArrayList;

public class Cart {
    private ArrayList<CartItem> items = new ArrayList<>();

    public void addItem(FoodItem food, int quantity) {
        for (CartItem item : items) {
            if (item.getFood().getId() == food.getId()) {
                item.addQuantity(quantity);
                System.out.println("Quantity updated.");
                return;
            }
        }

        items.add(new CartItem(food, quantity));
        System.out.println("Item added to cart.");
    }

    public void removeItem(int id) {
        for (CartItem item : items) {
            if (item.getFood().getId() == id) {
                items.remove(item);
                System.out.println("Item removed.");
                return;
            }
        }

        System.out.println("Item not found in cart.");
    }

    public double getTotal() {
        double total = 0;

        for (CartItem item : items) {
            total += item.getTotal();
        }

        return total;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public ArrayList<CartItem> getItems() {
        return items;
    }

    public void clear() {
        items.clear();
    }

    public void displayCart() {
        if (items.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }

        System.out.println("\n========== CART ==========");

        for (CartItem item : items) {
            System.out.printf("%-20s x %-3d ₹%.2f%n",
                    item.getFood().getName(),
                    item.getQuantity(),
                    item.getTotal());
        }

        System.out.println("---------------------------");
        System.out.printf("Total: ₹%.2f%n", getTotal());
    }
}
