import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Inicializando conversor de monedas...");

            // 1. Obtener datos de la API
            ApiClient apiClient = new ApiClient();
            Map<String, Moneda> monedas = apiClient.obtenerMonedas();

            // 2. Configurar el conversor
            Conversor conversor = new Conversor(monedas);

            // 3. Mostrar menú interactivo
            Menu menu = new Menu(conversor);
            menu.mostrarMenu();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}