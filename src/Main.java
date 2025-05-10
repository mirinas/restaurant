import java.util.HashMap;
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
                    s.nextLine();
                    String aprasymas = s.nextLine();
                    double suma = s.nextDouble();

                    System.out.println("Take-away? (y/n)");
                    boolean vietoje = !s.next().equalsIgnoreCase("y");

                    selectedOrder = new Order(aprasymas, suma, vietoje);
                    uzsakymai.put(selectedOrder.getNumeris(), selectedOrder);
                    System.out.println("New order " + selectedOrder.getNumeris() + " created");
                }
                case "updateOrder" -> {
                    if(!uzsakymasPasirinktas(selectedOrder)) break;

                    s.nextLine();
                    String aprasymas = s.nextLine();
                    double suma = s.nextDouble();
                    selectedOrder.papildytiUzsakyma(aprasymas, suma);
                }
                case "orderStatus" -> {
                    if(!uzsakymasPasirinktas(selectedOrder)) break;

                    String statusas = s.next();
                    selectedOrder.setStatusas(statusas);
                }
                case "printOrder" -> {
                    if(!uzsakymasPasirinktas(selectedOrder)) break;

                    System.out.println(selectedOrder.formuotiCeki());
                    System.out.println("-------");
                }
                case "quit" -> {
                    System.out.println("Shutting down");
                    return;
                }
                default -> System.err.println("Invalid command. Use:\nnewOrder, updateOrder, orderStatus, printOrder, quit");
            }
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