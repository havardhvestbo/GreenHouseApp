package no.ntnu.ui;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import no.ntnu.SensorProvider;
import no.ntnu.client.ClientHandler;
import no.ntnu.logic.enums;
import no.ntnu.server.MqttPublisher;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Code adapted from: https://stackoverflow.com/questions/33494052/javafx-redirect-console-output-to-textarea-that-is-created-in-scenebuilder
 */

public class FrontPageController {

    MqttPublisher temperaturePublisher = new MqttPublisher(enums.TEMPERATURE_TOPIC, enums.BROKER, enums.TEMPERATURE_SENSOR_ID, enums.QOS);
    MqttPublisher humidityPublisher = new MqttPublisher(enums.HUMIDITY_TOPIC, enums.BROKER, enums.HUMIDITY_SENSOR_ID, enums.QOS);
    ClientHandler clientHandler = new ClientHandler(enums.TEMPERATURE_TOPIC, enums.BROKER, enums.TEMPERATURE_CLIENT_ID, enums.QOS);
    ClientHandler clientHandler2 = new ClientHandler(enums.HUMIDITY_TOPIC, enums.BROKER, enums.HUMIDITY_CLIENT_ID, enums.QOS);
    SensorProvider sensorProvider = new SensorProvider();

    @FXML
    private TextArea console;
    private PrintStream ps;

    public void initialize() {
        ps = new PrintStream(new Console(console));

        temperaturePublisher.startConnection();
        temperaturePublisher.publishMessageToBroker(sensorProvider.getTemperatureSensor().readValue() + "");

        humidityPublisher.startConnection();
        humidityPublisher.publishMessageToBroker(sensorProvider.getHumiditySensor().readValue() + "");

        clientHandler.startClient();
        clientHandler2.startClient();
    }

    public void buttonPressed() {
        System.setOut(ps);
        System.setErr(ps);
        System.out.println("Current readings: ");
        System.out.println("");

        initialize();

        System.out.println("Press button again to update readings. ");
        System.out.println("");
        System.out.println("----------------------------------------------------------------------");


    }

    public class Console extends OutputStream {
        private TextArea console;

        public Console(TextArea console) {
            this.console = console;
        }

        public void appendText(String valueOf) {
            Platform.runLater(() -> console.appendText(valueOf));
        }

        public void write(int b) {
            appendText(String.valueOf((char)b));
        }
    }
}