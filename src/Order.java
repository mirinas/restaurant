import java.util.ArrayList;
import java.util.Random;

public class Order {

    private final String numeris;
    private ArrayList<OrderItem> orderItems = new ArrayList<>();

    private boolean vietoje;
    private String statusas;

    // sukurti uzsakyma
    public Order(OrderItem item, boolean v) {
        orderItems.add(item);
        vietoje = v;
        numeris = "#" + new Random().nextInt(1000, 10000);
        statusas = "Pateiktas";
    }

    // cekio formavimas
    public String formuotiCeki() {
//        return "%s - %sEur\n%s\n".formatted(numeris, suma, aprasymas) +
//                (vietoje ? "Vietoje" : "Išsinešimui");
        return "";
    }

    // pakeisti statusa
    public void setStatusas(String statusas) {
        // patikrinam ar viskas pagaminta
        this.statusas = statusas;
    }

    // papildyti uzsakyma
    public void papildytiUzsakyma(OrderItem item) {
        orderItems.add(item);
    }

    public String getStatusas() {
        return statusas;
    }

    public String getNumeris() {
        return numeris;
    }
}
