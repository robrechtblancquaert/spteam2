package gui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class LeftSideSettingsController {

    @FXML
    private Button ApplicationSettingsButton;

    @FXML
    private Button UserSettingsButton;

    @FXML
    void showUserSettingsButton(ActionEvent event) throws IOException {
    	MainLoader.ShowUserSettings();
    }

    @FXML
    void showApplicationSettings(ActionEvent event) throws IOException {
    	MainLoader.ShowApplicationSettings();
    }

}
