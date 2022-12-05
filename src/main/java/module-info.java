module GreenHouseApp {
  requires javafx.graphics;
  requires javafx.controls;
  requires javafx.fxml;
  requires org.eclipse.paho.client.mqttv3;
  requires java.logging;

  opens no.ntnu.ui to javafx.fxml;
  opens no.ntnu.client to javafx.fxml;
  opens no.ntnu.logic to javafx.fxml;
  opens no.ntnu.sensors to javafx.fxml;
  opens no.ntnu.server to javafx.fxml;

  exports no.ntnu.ui;
  exports no.ntnu.client;
  exports no.ntnu.logic;
  exports no.ntnu.sensors;
  exports no.ntnu.server;
  exports no.ntnu;

  opens no.ntnu to javafx.fxml;
}