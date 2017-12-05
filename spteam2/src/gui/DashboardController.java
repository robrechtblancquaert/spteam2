package gui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class DashboardController extends MainController{
	
	public void initialize() {
		
	}
	
	@FXML
	public void showOverview() {
		FXMLLoader loader = new FXMLLoader();
    	loader.setLocation((MainLoader.class.getResource("TrainingView.fxml")));
    	AnchorPane trainingView = null;
		try {
			trainingView = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		MainController.me.addToMainPane(trainingView);
	}
}
