import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        HashMap<String, Order> uzsakymai = new HashMap<>();

        Order selectedOrder = null;
        while(true) {
            System.out.println("Enter a command:");
            String komanda = s.next();

            switch (komanda) {
                case "selectOrder" -> {
                    String numeris = s.next();
                    if(uzsakymai.containsKey(numeris)) {
                        selectedOrder = uzsakymai.get(numeris);
                    } else {
                        System.err.println("Order " + numeris + " does not exist");
                    }
                }
                case "newOrder" -> {
                    Menu.print();

                    OrderItem item = getMenuItem(s);
                    if(item == null) break;

                    // paklausiam vietoje ar issinesimui
                    System.out.println("Take-away? (y/n)");
                    boolean vietoje = !s.next().equalsIgnoreCase("y");

                    // sukuriam uzsakyma su meniu patiekalu
                    selectedOrder = new Order(item, vietoje);
                    uzsakymai.put(selectedOrder.getNumeris(), selectedOrder);
                    System.out.println("New order " + selectedOrder.getNumeris() + " created");
                }
                case "updateOrder" -> {
                    if(!uzsakymasPasirinktas(selectedOrder)) break;
                    Menu.print();

                    OrderItem item = getMenuItem(s);
                    if(item == null) break;

                    // sukuriam uzsakyma su meniu patiekalu
                    selectedOrder.papildytiUzsakyma(item);
                }
                case "orderStatus" -> {
                    if(!uzsakymasPasirinktas(selectedOrder)) break;

                    String statusas = s.next();
                    selectedOrder.setStatusas(statusas);
                }
                case "printOrder" -> {
                    if(!uzsakymasPasirinktas(selectedOrder)) break;
                    System.out.println(selectedOrder);
                }
                case "quit" -> {
                    System.out.println("Shutting down");
                    return;
                }
                default -> System.err.println("Invalid command. Use:\nnewOrder, updateOrder, orderStatus, printOrder, quit");
            }
        }
    }



    public static OrderItem getMenuItem(Scanner s) {

        try {
            // nuskaitome meniu pozicija ir kieki
            int position = s.nextInt();
            int qty = s.nextInt();

            // pagal pozicija surandame meniu patiekala
            OrderItem item = Menu.getItem(position, qty);
            if (item == null) {
                System.err.println("Item " + position + " does not exist");
            }
            return item;

        } catch (InputMismatchException e) {
            System.err.println("Invalid character. Please use numbers only");
            return null;
        }
    }


    public static boolean uzsakymasPasirinktas(Order order) {
        if(order == null) {
            System.err.println("Select order first using selectOrder");
            return false;
        }
        return true;
    }
}