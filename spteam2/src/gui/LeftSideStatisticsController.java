package gui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class LeftSideStatisticsController {

    @FXML
    private Button gotoStats2Button;

    @FXML
    private Button gotostats1Button;

    @FXML
    void showgotostats1(ActionEvent event) throws IOException {
    	MainLoader.ShowStatistics1Screen();
    }

    @FXML
    void showgotostats2(ActionEvent event) throws IOException {
    	MainLoader.ShowStatistics2Screen();
    }

}
