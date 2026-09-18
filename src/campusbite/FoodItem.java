package campusbite;

public class FoodItem {
    private int id;
    private String name;
    private String category;
    private double price;
    private boolean available;

    public FoodItem(int id, String name, String category, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.available = true;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void display() {
        System.out.printf("%-5d %-20s %-15s ₹%.2f %-10s%n",
                id, name, category, price, available ? "Available" : "Not Available");
    }
}
