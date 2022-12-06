package no.ntnu.ui;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import no.ntnu.SensorProvider;
import no.ntnu.client.ClientHandler;
import no.ntnu.logic.enums;
import no.ntnu.server.MqttPublisher;
import org.eclipse.paho.client.mqttv3.MqttException;

public class FrontPageController {

    @FXML
    private TextArea console;
    private PrintStream ps;
    private Button button;

    public void initialize() {
        ps = new PrintStream(new Console(console));

    }

    public void buttonPressed(ActionEvent event) throws MqttException, IOException {
        SensorProvider sensorProvider = new SensorProvider();
        System.out.println("Current readings: ");
        MqttPublisher temperaturePublisher = new MqttPublisher(enums.TEMPERATURE_TOPIC, enums.BROKER, enums.TEMPERATURE_SENSOR_ID, enums.QOS);
        temperaturePublisher.startConnection();
        temperaturePublisher.publishMessageToBroker(sensorProvider.getTemperatureSensor().readValue() + "");

        MqttPublisher humidityPublisher = new MqttPublisher(enums.HUMIDITY_TOPIC, enums.BROKER, enums.HUMIDITY_SENSOR_ID, enums.QOS);
        humidityPublisher.startConnection();
        humidityPublisher.publishMessageToBroker(sensorProvider.getHumiditySensor().readValue() + "");

        ClientHandler clientHandler = new ClientHandler(enums.TEMPERATURE_TOPIC, enums.BROKER, enums.TEMPERATURE_CLIENT_ID, enums.QOS);
        clientHandler.startClient();

        ClientHandler clientHandler2 = new ClientHandler(enums.HUMIDITY_TOPIC, enums.BROKER, enums.HUMIDITY_CLIENT_ID, enums.QOS);
        clientHandler2.startClient();

        System.out.println("Press button again to update readings. ");
        System.out.println("");

        System.setOut(ps);
        System.setErr(ps);
    }

    public class Console extends OutputStream {
        private TextArea console;

        public Console(TextArea console) {
            this.console = console;
        }

        public void appendText(String valueOf) {
            Platform.runLater(() -> console.appendText(valueOf));
        }

        public void write(int b) throws IOException {
            appendText(String.valueOf((char)b));
        }
    }
}