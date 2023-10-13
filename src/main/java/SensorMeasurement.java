import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Random;

/**
 * @author ua.ypon 13.10.2023
 */
public class SensorMeasurement {

    @JsonProperty("value")
    private double value;

    @JsonProperty("raining")
    private boolean raining;

    private Sensor sensor;

    Random random = new Random();

    public double generateRandomTemperature() {
        return random.nextDouble() * 40;
    }

    public boolean generateRandomRainStatus() {
        return random.nextBoolean();
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public boolean isRaining() {
        return raining;
    }

    public void setRaining(boolean raining) {
        this.raining = raining;
    }
}
