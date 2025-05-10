import java.util.ArrayList;

public class Menu {

    private static ArrayList<OrderItem> menu = new ArrayList<>();

    static {
        menu.add(new Snack("Chicken nuggets", 5.99, false, OrderItemWithSize.Size.MEDIUM));
        menu.add(new Snack("Large snack plate", 13.49, false, OrderItemWithSize.Size.LARGE));
        menu.add(new MainCourse("Poached salmon", 14.50, false, MainCourse.Side.RICE, OrderItemWithSize.Size.MEDIUM));
        menu.add(new MainCourse("Ribeye steak", 20, false, MainCourse.Side.FRIES, OrderItemWithSize.Size.LARGE));
        menu.add(new Beverage("Coca-cola", 2.50, 500, Beverage.Type.ZERO));
        menu.add(new Beverage("Stella Artois", 5.20, 568, Beverage.Type.ALCO));
        menu.add(new Dessert("Apple pie", 4.90, false));
    }

    public static OrderItem getItem(int position, int qty) {
        if(position < 1 || position > menu.size()) return null;

        OrderItem clone = menu.get(position - 1).clone();
        clone.setOrderedQty(qty);
        return clone;
    }
}
