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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        double suma = 0;

        for(OrderItem item : orderItems) {
            sb.append(item).append("\n");
            suma += item.getOrderedQty() * item.getPrice();
        }
        sb.append("Total: ").append(suma).append("eur")
                .append("\n----------------");
        return sb.toString();
    }

}
