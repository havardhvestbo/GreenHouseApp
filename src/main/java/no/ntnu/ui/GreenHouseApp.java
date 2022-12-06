package no.ntnu.ui;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Starts the UI
 */
public class GreenHouseApp extends Application {

    @Override
    public void start(Stage primaryStage) {
      try {
        Parent root = FXMLLoader.load(getClass().getResource("FrontPage.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
      } catch(Exception e) {
        e.printStackTrace();
      }
    }
}