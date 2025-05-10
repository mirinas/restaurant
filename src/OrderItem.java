public class OrderItem implements Cloneable {
    protected String name;
    protected double price;
    protected boolean vegan;

    protected int orderedQty = 1;

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

    public double getPrice() {
        return price;
    }

    @Override
    public OrderItem clone() {
        try {
            OrderItem clone = (OrderItem) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return "%s%s - %s x %seur".formatted(name, vegan ? " (V)" : "", orderedQty, price);
    }
}
