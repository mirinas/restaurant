public class OrderItem implements Cloneable {
    private String name;
    private double price;
    private boolean vegan;

    private int orderedQty = 0;

    public OrderItem(String name, double price, boolean vegan) {
        this.name = name;
        this.price = price;
        this.vegan = vegan;
    }

    public int getOrderedQty() {
        return orderedQty;
    }

    public void setOrderedQty(int orderedQty) {
        this.orderedQty = orderedQty;
    }

    @Override
    public OrderItem clone() {
        try {
            OrderItem clone = (OrderItem) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
