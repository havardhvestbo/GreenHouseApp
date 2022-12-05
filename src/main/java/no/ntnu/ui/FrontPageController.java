package no.ntnu.ui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.util.ResourceBundle;

public class FrontPageController implements Initializable {

    @FXML
    private LineChart< ? , ? > chart;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        XYChart.Series series = new XYChart.Series();

        series.getData().add(new XYChart.Data("1",4));
        series.getData().add(new XYChart.Data("2",2));
        series.getData().add(new XYChart.Data("3",3));

        chart.getData().addAll(series);


    }

}