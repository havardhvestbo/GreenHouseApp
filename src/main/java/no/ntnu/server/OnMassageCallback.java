package no.ntnu.server;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class OnMassageCallback implements MqttCallback {

  @Override
  public void connectionLost(Throwable throwable) {
    System.out.println("Disconnect, you can reconnect");
  }

  @Override
  public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
    System.out.println("Received message topic: " + s);
    System.out.println("Received message Qos: " + mqttMessage.getQos());
    System.out.println("Received message content: " + new String(mqttMessage.getPayload()));
  }

  @Override
  public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
    System.out.println("deliveryComplete------------ " + iMqttDeliveryToken.isComplete());
  }
}