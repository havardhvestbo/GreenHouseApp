package no.ntnu.client;


import static no.ntnu.logic.enums.BROKER;
import static no.ntnu.logic.enums.CLIENT_ID;
import static no.ntnu.logic.enums.QOS;

import no.ntnu.server.MqttSubscriber;

public class ClientRunner {


  MqttSubscriber receiveData;

  public static void main(String[] args) {
    ClientRunner clientRunner = new ClientRunner();
    clientRunner.start();
  }

  /**
   * Receives a message from an MQTT topic.
   */
  public void start() {
    try {
      // receiveFromTopic(ClientRunner.TEMPERATURE_TOPIC);
      receiveFromTopic("#");
      receiveData.startClient();
    } catch (Exception e) {
      System.err.println(e);
    }
  }

  /**
   * Receives data from a specified topic.
   *
   * @param topic topic to subscribe to
   */
  private void receiveFromTopic(String topic) {
    receiveData = new MqttSubscriber(topic, BROKER, CLIENT_ID, QOS);
  }

  /**
   * Gets the topic the client subscribes to.
   *
   * @return The topic the client subscribes to.
   */
  public String getClientTopic() {
    return receiveData.getTopic();
  }
}