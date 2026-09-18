package campusbite;

import java.util.ArrayList;

public class Order {
    private static int nextId = 1001;
    private int orderId;
    private ArrayList<CartItem> items;
    private double total;
    private OrderStatus status;

    public Order(Cart cart) {
        orderId = nextId++;
        items = new ArrayList<>();

        for (CartItem item : cart.getItems()) {
            items.add(new CartItem(item.getFood(), item.getQuantity()));
        }

        total = cart.getTotal();
        status = OrderStatus.PLACED;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void display() {
        System.out.println("\n========== ORDER ==========");
        System.out.println("Order ID: " + orderId);
        System.out.println("Status: " + status);

        for (CartItem item : items) {
            System.out.printf("%-20s x %-3d ₹%.2f%n",
                    item.getFood().getName(),
                    item.getQuantity(),
                    item.getTotal());
        }

        System.out.println("---------------------------");
        System.out.printf("Total: ₹%.2f%n", total);
    }
}
