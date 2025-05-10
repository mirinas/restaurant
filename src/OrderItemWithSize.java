public class OrderItemWithSize extends OrderItem {
    private Size size;

    public enum Size {
        MEDIUM, LARGE
    }

    public OrderItemWithSize(String name, double price, boolean vegan, Size s) {
        super(name, price, vegan);
        this.size = s;
    }
}
