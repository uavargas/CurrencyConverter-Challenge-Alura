import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Menu {
    private Conversor conversor;
    private BufferedReader reader;
    private List<String> historial;  // Cambiamos a List<String>
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public Menu(Conversor conversor) {
        this.conversor = conversor;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
        this.historial = new ArrayList<>();
    }

    public void mostrarMenu() throws IOException {
        int opcion;
        do {
            System.out.println("\n=== CONVERSOR DE MONEDAS ===");
            System.out.println("1. Ver monedas disponibles");
            System.out.println("2. Realizar conversión");
            System.out.println("3. Ver historial de conversiones");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = Integer.parseInt(reader.readLine());

            switch (opcion) {
                case 1:
                    conversor.mostrarMonedasDisponibles();
                    break;
                case 2:
                    realizarConversion();
                    break;
                case 3:
                    mostrarHistorial();
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 4);
    }

    private void realizarConversion() throws IOException {
        System.out.println("\n=== REALIZAR CONVERSIÓN ===");

        System.out.print("Ingrese código de moneda origen (ej. USD): ");
        String origen = reader.readLine().toUpperCase();

        System.out.print("Ingrese código de moneda destino (ej. COP): ");
        String destino = reader.readLine().toUpperCase();

        System.out.print("Ingrese cantidad a convertir: ");
        double cantidad = Double.parseDouble(reader.readLine());

        try {
            double resultado = conversor.convertir(cantidad, origen, destino);
            System.out.printf("\n%.2f %s = %.2f %s%n", cantidad, origen, resultado, destino);

            // Guardar la conversión en el historial como String
            guardarConversion(cantidad, origen, destino, resultado);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void guardarConversion(double cantidad, String origen, String destino, double resultado) {
        String fechaHora = LocalDateTime.now().format(formatter);
        String registro = String.format("[%s] %.2f %s → %.2f %s",
                fechaHora, cantidad, origen, resultado, destino);
        historial.add(registro);
        System.out.println("Conversión guardada en el historial.");
    }

    private void mostrarHistorial() {
        System.out.println("\n=== HISTORIAL DE CONVERSIONES ===");
        if (historial.isEmpty()) {
            System.out.println("No hay conversiones en el historial.");
            return;
        }

        for (String conversion : historial) {
            System.out.println(conversion);
        }
    }
}