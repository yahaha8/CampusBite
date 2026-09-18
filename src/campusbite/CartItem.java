package campusbite;

public class CartItem {
    private FoodItem food;
    private int quantity;

    public CartItem(FoodItem food, int quantity) {
        this.food = food;
        this.quantity = quantity;
    }

    public FoodItem getFood() {
        return food;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }

    public double getTotal() {
        return food.getPrice() * quantity;
    }
}
