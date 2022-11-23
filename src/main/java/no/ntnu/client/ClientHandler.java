package no.ntnu.client;

import no.ntnu.server.MqttSubscriber;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 * Responsible for establishing a connection to the MQTT broker.
 */
public class ClientHandler extends MqttSubscriber {
  Double lastValue;

  /**
   * Creates a client with a connection to an MQTT broker.
   *
   * @param topic mqtt topic
   * @param broker mqtt broker
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

    // **Do something with the message**
    this.lastValue = message;
  }

  public Double getLastValue() {
    return lastValue;
  }

}
