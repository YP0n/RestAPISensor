import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author ua.ypon 13.10.2023
 */
public class Sensor extends SensorMeasurement {

    @JsonProperty("name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
