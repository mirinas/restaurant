public class Beverage extends OrderItem {
    private int volume;
    private Type type;

    public Beverage(String name, double price) {
        super(name, price, true);
    }

    enum Type {
        ZERO, ALCO, DIET, STANDART
    }
}
