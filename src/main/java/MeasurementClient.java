import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

/**
 * @author ua.ypon 13.10.2023
 */
public class MeasurementClient {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Реєстрація нового сенсора
        Sensor sensor = new Sensor();
        sensor.setName("testWithJava");
        HttpEntity<Sensor> sensorEntity = new HttpEntity<>(sensor, headers);
        Sensor sensorResponse = restTemplate.postForObject("http://localhost:8080/sensor/registration", sensorEntity, Sensor.class);

        if(sensorResponse != null) {
            System.out.println("Sensor registration: " + sensorResponse.getName());
        }

        // Надсилання 1000 вимірів
        for(int i = 0; i < 10; i++) {
            SensorMeasurement measurementsRequest = new SensorMeasurement();
            measurementsRequest.setValue(measurementsRequest.generateRandomTemperature());
            measurementsRequest.setRaining(measurementsRequest.generateRandomRainStatus());
            measurementsRequest.setSensor(sensor);

            HttpEntity<SensorMeasurement> measurementEntity = new HttpEntity<>(measurementsRequest, headers);
            restTemplate.postForObject("http://localhost:8080/measurements/add", measurementEntity, String.class);
        }

        // Отримання 1000 вимірів
        Measurement[] measurementsResponses = restTemplate.getForObject("http://localhost:8080/measurements", Measurement[].class);
        if(measurementsResponses != null) {
            System.out.println("Get " + measurementsResponses.length + " measurements.");
        }
    }
}
