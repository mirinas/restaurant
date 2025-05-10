public class Beverage extends OrderItem {
    private int volume;
    private Type type;

    public Beverage(String name, double price, int volume, Type type) {
        super(name, price, true);
        this.volume = volume;
        this.type = type;
    }

    public enum Type {
        ZERO, ALCO, DIET, STANDART
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "%s%s %sml - %s x %seur".formatted(name,
                type != Type.STANDART ? (" " + type) : "", volume, orderedQty, price);
    }
}
