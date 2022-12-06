package no.ntnu.client;

import no.ntnu.server.MqttSubscriber;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 * This class is responsible for establishing connection to the MQTT broker.
 */
public class ClientHandler extends MqttSubscriber {
  Double recentValue;

  /**
   * Creates a client which connects to an MQTT broker.
   *
   *
   * @param broker mqtt broker
   * @param topic mqtt topic
   * @param clientId the client id
   * @param qos qos value
   */
  public ClientHandler(String topic, String broker, String clientId, int qos) {
    super(topic, broker, clientId, qos);
  }

  @Override
  public void messageArrived(String topic, MqttMessage mqttMessage) {
    double message = Double.parseDouble(new String(mqttMessage.getPayload()));

    System.out.println("Received from topic: " + topic);
    System.out.println("Message: " + message);
    System.out.println("----------------");

    this.recentValue = message;
  }

}
