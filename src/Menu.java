import java.util.ArrayList;

public class Menu {

    private static ArrayList<OrderItem> menu = new ArrayList<>();

    static {
        menu.add(new Snack("Chicken nuggets", 5.99, false, OrderItemWithSize.Size.MEDIUM));
        menu.add(new Snack("Large snack plate", 13.49, false, OrderItemWithSize.Size.LARGE));
        menu.add(new MainCourse());
        menu.add(new MainCourse());
        menu.add(new MainCourse());
        menu.add(new Beverage());
        menu.add(new Beverage());
        menu.add(new Dessert());
    }

    public static OrderItem getItem(int position) {
        if(position < 1 || position > menu.size()) return null;
        return menu.get(position - 1);
    }
}
