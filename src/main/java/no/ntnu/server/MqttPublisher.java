package no.ntnu.server;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 * Establishes a connection & publishes data to an MQTT broker.
 * Code adapted from: https://www.eclipse.org/paho/index.php?page=clients/java/index.php
 *
 */
public class MqttPublisher {

  private final String topic;
  private final String broker;
  private final String sensorID;
  private final int qos;

  private MqttClient client;

  /**
   * Creates a client that sends data to an MQTT broker.
   *
   * @param topic    The topic to upload to.
   * @param broker   The broker to connect to.
   * @param sensorID The client id.
   * @param qos      The "Quality of Service"
   */
  public MqttPublisher(String topic, String broker, String sensorID, int qos) {
    this.topic = topic;
    this.broker = broker;
    this.sensorID = sensorID;
    this.qos = qos;
  }

  /**
   * Starts the connection between the client and the server, and sends data to the MQTT broker.
   */
  public void startConnection() {
    try {
      this.client = new MqttClient(broker, sensorID, new MemoryPersistence());

      MqttConnectOptions options = new MqttConnectOptions();
      options.setConnectionTimeout(60);
      options.setKeepAliveInterval(60);

      client.connect(options);
    } catch (MqttException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Sends a message to the MQTT broker.
   *
   * @param message message to
   */
  public void publishMessageToBroker(String message) {
    try {
      MqttMessage m = new MqttMessage(message.getBytes());
      m.setQos(this.qos);

      client.publish(topic, m);

    } catch (MqttException e) {
      throw new RuntimeException(e);
    }
  }

}
