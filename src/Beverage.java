public class Beverage extends OrderItem {
    private int volume;
    private Type type;

    enum Type {
        ZERO, ALCO, DIET, STANDART
    }
}
