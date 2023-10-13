import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author ua.ypon 13.10.2023
 */
public class Measurement extends SensorMeasurement {

    @JsonProperty("timestamp")
    private  long timestamp;
}
