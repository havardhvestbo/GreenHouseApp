package no.ntnu.sensors;
import no.ntnu.client.ClientRunner;
import no.ntnu.logic.enums;
import no.ntnu.server.MqttPublisher;

public class SensorRunner {

  private MqttPublisher mqttPublisher;

  public static void main(String[] args) {
    SensorRunner sensorRunner = new SensorRunner();
    sensorRunner.start();
  }

  /**
   * Sends a message to the MQTT topic.
   */
  public void start() {
    try {
      sendToTopic(enums.TEMPERATURE_TOPIC);
      mqttPublisher.startConnection();
      mqttPublisher.publishMessageToBroker("1");
    } catch (Exception e) {
      System.err.println(e);
    }
  }

  /**
   * Sends data to a topic.
   *
   * @param topic topic to send to
   */
  private void sendToTopic(String topic) {
    mqttPublisher = new MqttPublisher(topic, enums.BROKER, enums.SENSOR_ID, enums.QOS);
  }
}
