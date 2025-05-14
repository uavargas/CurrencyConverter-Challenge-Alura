import com.google.gson.annotations.SerializedName;
import java.util.Map;

public class ApiResponse {
    @SerializedName("result")
    private String result;

    @SerializedName("base_code")
    private String baseCode;

    @SerializedName("time_last_update_utc")
    private String lastUpdate;

    @SerializedName("conversion_rates")
    private Map<String, Double> conversionRates;

    // Getters y Setters
    public String getResult() {
        return result;
    }

    public String getBaseCode() {
        return baseCode;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public Map<String, Double> getConversionRates() {
        return conversionRates;
    }
}