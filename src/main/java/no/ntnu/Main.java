package no.ntnu;

import java.io.IOException;
import org.eclipse.paho.client.mqttv3.MqttException;

/**
    * Main entrypoint for the application
    */
  public class Main {
    /**
     * Start the application
     * @param args Not used
     */
    public static void main(String[] args) throws MqttException, IOException {
      System.out.println("Starting the application...");
      App app = new App();
      try {
        app.run();
      } catch (Exception e) {
        System.out.println("Oops: " + e.getMessage());
      }
      System.out.println("Application finished");
    }
}