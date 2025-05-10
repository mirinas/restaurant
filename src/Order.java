import java.util.Random;

public class Order {

    private final String numeris;
    private String aprasymas;
    private double suma;

    private boolean vietoje;
    private String statusas;

    // sukurti uzsakyma
    public Order(String a, double s, boolean v) {
        aprasymas = a;
        suma = s;
        vietoje = v;
        numeris = "#" + new Random().nextInt(1000, 10000);
        statusas = "Pateiktas";
    }

    // cekio formavimas
    public String formuotiCeki() {
        return "%s - %sEur\n%s\n".formatted(numeris, suma, aprasymas) +
                (vietoje ? "Vietoje" : "Išsinešimui");
    }

    // pakeisti statusa
    public void setStatusas(String statusas) {
        // patikrinam ar viskas pagaminta
        this.statusas = statusas;
    }

    // papildyti uzsakyma
    public void papildytiUzsakyma(String papildomasAprasymas, double papildomaSuma) {
//        aprasymas = aprasymas + papildomasAprasymas;
        aprasymas += "\n" + papildomasAprasymas;
        suma += papildomaSuma;
    }

    public String getStatusas() {
        return statusas;
    }

    public String getNumeris() {
        return numeris;
    }
}
