import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class ApiClient {
    private static final String API_KEY = "423e1497fd92f64e84085dbb";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/USD";
    private final Gson gson = new Gson();

    public Map<String, Moneda> obtenerMonedas() throws Exception {
        String jsonResponse = hacerPeticion();
        ApiResponse response = gson.fromJson(jsonResponse, ApiResponse.class);

        if (!"success".equalsIgnoreCase(response.getResult())) {
            throw new Exception("Error en la respuesta de la API");
        }

        return procesarMonedas(response);
    }

    private Map<String, Moneda> procesarMonedas(ApiResponse response) {
        Map<String, Moneda> monedas = new HashMap<>();
        Map<String, Double> rates = response.getConversionRates();

        // Monedas predefinidas con sus nombres completos
        String[][] monedasFiltradas = {
                {"USD", "Dólar Estadounidense"},
                {"EUR", "Euro"},
                {"GBP", "Libra Esterlina"},
                {"JPY", "Yen Japonés"},
                {"MXN", "Peso Mexicano"},
                {"COP", "Peso Colombiano"},
                {"ARS", "Peso Argentino"},
                {"CLP", "Peso Chileno"},
                {"BRL", "Real Brasileño"},
                {"CNY", "Yuan Chino"},
        };

        for (String[] moneda : monedasFiltradas) {
            String codigo = moneda[0];
            if (rates.containsKey(codigo)) {
                Moneda m = new Moneda(codigo, moneda[1], rates.get(codigo));
                monedas.put(codigo, m);
            }
        }

        return monedas;
    }

    private String hacerPeticion() throws Exception {
        URL url = new URL(BASE_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            return response.toString();
        } else {
            throw new Exception("Error al conectar con la API: " + responseCode);
        }
    }
}