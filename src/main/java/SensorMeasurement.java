import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.DecimalFormat;
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
        double rawValue = random.nextDouble() * 40;
        // Створити об'єкт DecimalFormat для форматування числа з обмеженням знаків після коми
        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        //Використовуємо DecimalFormat для форматування числа
        String formattedValue = decimalFormat.format(rawValue);
        //Повертаємо форматоване число у вигляді рядка
        return Double.parseDouble(formattedValue.replace(',', '.'));
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
