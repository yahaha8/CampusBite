package campusbite;

import java.util.ArrayList;

public class OrderManager {
    private ArrayList<Order> orders = new ArrayList<>();

    public Order placeOrder(Cart cart) {
        Order order = new Order(cart);
        orders.add(order);
        return order;
    }

    public void displayOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders available.");
            return;
        }

        for (Order order : orders) {
            order.display();
        }
    }

    public boolean updateStatus(int id, OrderStatus status) {
        for (Order order : orders) {
            if (order.getOrderId() == id) {
                order.setStatus(status);
                return true;
            }
        }

        return false;
    }

    public boolean isEmpty() {
        return orders.isEmpty();
    }
}
