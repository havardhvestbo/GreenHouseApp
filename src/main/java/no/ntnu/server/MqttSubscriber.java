package no.ntnu.server;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.util.ArrayList;
import java.util.List;

/**
 * Establishes a connection & subscribes to a topic from an MQTT broker.
 */
public class MqttSubscriber implements MqttCallback {

  // Topic to receive data from
  private final String topic;
  private List<Double> data;
  private final String broker;
  private final String clientId;
  private final int qos;
  private MqttClient client;

  /**
   * Creates a client that receives data from an MQTT broker.
   *
   * @param topic    The topic to subscribe from.
   * @param broker   The broker to receive data from.
   * @param clientId The id of the client
   * @param qos      The "Quality of Service"
   */
  public MqttSubscriber(String topic, String broker, String clientId, int qos) {
    this.broker = broker;
    this.clientId = clientId;
    this.qos = qos;
    this.topic = topic;
    this.data = new ArrayList<>();
  }

  /**
   * Starts the client and receives data from the MQTT broker.
   */
  public void startClient() {
    try {
      client = new MqttClient(broker, clientId, new MemoryPersistence());

      // connect options
      MqttConnectOptions options = new MqttConnectOptions();
      options.setConnectionTimeout(60);
      options.setKeepAliveInterval(60);

      // setup callback using MqttCallback
      client.setCallback(this);

      client.connect(options);
      client.subscribe(this.topic, this.qos);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Lets user know if connection is lost.
   * @param throwable
   */
  @Override
  public void connectionLost(Throwable throwable) {
    System.out.println("Connection lost. " + throwable);
    System.out.println(" ");
  }

  /**
   * Notifies the user that the message has arrived.
   * @param topic
   * @param mqttMessage
   */
  @Override
  public void messageArrived(String topic, MqttMessage mqttMessage) {
    String message = new String(mqttMessage.getPayload());

    System.out.println("Received from topic: " + topic);
    System.out.println("Message: " + message);
    System.out.println("----------------");


  }

  /**
   * Notifies the user when the delivery is complete.
   * @param iMqttDeliveryToken
   */
  @Override
  public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
    System.out.println("deliveryComplete: " + iMqttDeliveryToken);
  }

}


