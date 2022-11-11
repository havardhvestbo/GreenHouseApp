package no.ntnu.server;

import org.eclipse.paho.client.mqttv3.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

/**
 * This class represent the MQTT Protocol.
 * It is used to connect the microcontrollers and sensor to the cloud.
 */
public class Mqtt {

  //Different MQTT variables.
  private String id;
  private String broker;
  private IMqttClient client;
  private MqttConnectOptions options;

  //Input function
  private BufferedReader input;

  //Topics
  private int qos = 0;
  private String pubTopic = "ntnu/ankeret/beddingen/temprature/21/1";
  private String subTopic = "ntnu/ankeret/beddingen/temprature/21/1";

  /**
   * Constructor of the MQTT Client.
   * @param address address to the broker you want to connect to.
   * @param port port of the broker you want to connect to.
   * @param id the id of the one connecting.
   * @throws MqttException
   * @throws IOException
   */
  public Mqtt(String address, String port, String id) throws MqttException, IOException {

    //Sets up the client connection
    this.id = id;
    this.broker = "tcp://" + address + ":" + port;
    this.client = new MqttClient(this.broker, this.id);
    this.options = new MqttConnectOptions();

    //TODO Fine out what options we want on the Client.
    //Setts up different options for the Client
    this.options.setAutomaticReconnect(true);
    this.options.setCleanSession(true);
    this.options.setCleanSession(true);
    this.options.setConnectionTimeout(5);

    //Sets up input function
    this.input = new BufferedReader(new InputStreamReader(in));

    //Set callback
    this.client.setCallback(new OnMassageCallback());

    //Establish connection
    System.out.println("Connecting to broker: " + this.broker);
    this.client.connect(options);

    //TODO find out what topic i want to sub to.
    //subscribe to a topic
    this.client.subscribe(subTopic);


    //TODO find out how the programe can tel the user that it didnt connect to the broker, instead of the program crashing.
    //Checks if the client is connected to the broker.
    String line = "";
    if(this.client.isConnected() == true) {
      System.out.println("Connected to the broker: " + this.broker);

      //TODO Find out why when "Disconnect" it sends the message to the broker.
      while(!line.equals("Disconnect")) {
        line = this.input.readLine();
        sendMessage(line);
      }

      System.out.println("Disconnecting");
      this.client.disconnect();
      this.input.close();
    }
    else {
      System.out.println("Did not connect to the broker: " + this.broker);
      this.client.disconnect();
      this.input.close();
    }
  }

  /**
   * Sends message to the broker
   * @param line the message you want to send
   */
  private void sendMessage(String line){
    try {
      if(!this.client.isConnected()) {
        return;
      }
      MqttMessage message = new MqttMessage(line.getBytes());
      message.setQos(qos);
      client.publish(this.pubTopic, message);
    }
    catch (MqttPersistenceException e) {
      e.printStackTrace();
    }
    catch (MqttException e) {
      e.printStackTrace();
    }
  }
}