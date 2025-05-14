import java.util.Map;

public class Conversor {
    private Map<String, Moneda> monedas;

    public Conversor(Map<String, Moneda> monedas) {
        this.monedas = monedas;
    }

    public double convertir(double cantidad, String codigoOrigen, String codigoDestino) {
        Moneda origen = monedas.get(codigoOrigen);
        Moneda destino = monedas.get(codigoDestino);

        if (origen == null || destino == null) {
            throw new IllegalArgumentException("Moneda no válida");
        }

        // Convertir a USD primero (moneda base) y luego a la moneda destino
        double cantidadEnUsd = cantidad / origen.getTasaCambio();
        return cantidadEnUsd * destino.getTasaCambio();
    }

    public void mostrarMonedasDisponibles() {
        System.out.println("\nMonedas disponibles:");
        monedas.values().forEach(System.out::println);
    }
}