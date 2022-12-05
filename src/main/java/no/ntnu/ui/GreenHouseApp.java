package no.ntnu.ui;

import static javafx.application.Application.launch;

import java.io.IOException;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import no.ntnu.ui.controllers.FrontPageController;

public class GreenHouseApp extends Application {

  private FrontPageController frontPageController;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    try {
      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FrontPage.fxml"));
      Parent root = fxmlLoader.load();
      FrontPageController frontPageController = fxmlLoader.getController();
      Scene scene = new Scene(root, 700, 400);
      primaryStage.setTitle("A simple greenhouse");
      primaryStage.setScene(scene);
      primaryStage.show();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}