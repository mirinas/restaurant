public class MainCourse extends OrderItemWithSize {
    private Side side;

    public MainCourse(String name, double price, boolean vegan, Side side, Size s) {
        super(name, price, vegan, s);
        this.side = side;
    }

    public enum Side {
        FRIES, SALAD, RICE
    }

    @Override
    public String toString() {
        return "%s with %s%s - %s x %seur".formatted(name, side, vegan ? " (V)" : "", orderedQty, price);
    }
}
