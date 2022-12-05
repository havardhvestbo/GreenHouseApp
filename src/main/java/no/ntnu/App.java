package no.ntnu;

import java.io.IOException;
import no.ntnu.client.ClientHandler;
import no.ntnu.client.ClientRunner;
import no.ntnu.logic.enums;
import no.ntnu.sensors.Sensor;
import no.ntnu.server.MqttPublisher;
import no.ntnu.server.MqttSubscriber;
import org.eclipse.paho.client.mqttv3.MqttException;

/**
 * Represents the whole application, including the sensors.
 */
public class App {

  private static final long SLEEP_DURATION_MS = 2000;
  double lastTemperatureReading;
  double lastHumidityReading;

  Sensor temperatureSensor;
  Sensor humiditySensor;

  public App() throws MqttException, IOException {
  }

  /**
   * Run the application, does not return, except if something goes wrong.
   *
   * @throws IllegalStateException If something went wrong during the process
   */
  public void run() throws IllegalStateException, MqttException {
    initializeSensors();
    while (true) {
      readAllSensors();
      sendDataToServer();
      goToSleep();
    }
  }

  /**
   * Initializes all the sensors
   *
   * @throws IllegalStateException If some sensors are not found
   */
  private void initializeSensors() throws IllegalStateException {
    SensorProvider sensorProvider = SensorProvider.getInstance();
    temperatureSensor = sensorProvider.getTemperatureSensor();
    if (temperatureSensor == null) {
      throw new IllegalStateException("Temperature sensor not found");
    }
    humiditySensor = sensorProvider.getHumiditySensor();
    if (humiditySensor == null) {
      throw new IllegalStateException("Humidity sensor not found");
    }
  }

  private void readAllSensors() {
    System.out.println("Reading sensor data...");
    lastTemperatureReading = temperatureSensor.readValue();
    lastHumidityReading = humiditySensor.readValue();
  }

  private void sendDataToServer() throws MqttException {
    MqttPublisher mqttPublisher = new MqttPublisher(enums.TEMPERATURE_TOPIC, enums.BROKER, enums.SENSOR_ID, enums.QOS);
    mqttPublisher.startConnection();
    mqttPublisher.publishMessageToBroker(lastTemperatureReading + "");

   // MqttSubscriber mqttSubscriber = new MqttSubscriber(enums.TEMPERATURE_TOPIC, enums.BROKER, enums.CLIENT_ID, enums.QOS);
   // mqttSubscriber.startClient();

   // ClientRunner clientRunner = new ClientRunner();
//    clientRunner.start();

    ClientHandler clientHandler = new ClientHandler(enums.TEMPERATURE_TOPIC, enums.BROKER, enums.CLIENT_ID, enums.QOS);
    clientHandler.startClient();
    clientHandler.getData();

//    System.out.println("Sending data to server: ");
//    System.out.println("  temp: " + lastTemperatureReading + "C");
//    System.out.println("  humi: " + lastHumidityReading + "%");
//    System.out.println("");
//    System.out.println("Received from topic: " + mqttSubscriber.getTopic());
//    System.out.println("Received from Client: " + mqttSubscriber.getClientId());
//    System.out.println("Received messages: " + mqttSubscriber.getData());
//    System.out.println("-------");
  }

  private void goToSleep() {
    try {
      Thread.sleep(SLEEP_DURATION_MS);
    } catch (InterruptedException e) {
      System.out.println("Ooops, someone woke us up in the middle of a nap");
    }
  }
}
