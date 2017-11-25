package gui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class LoginController {
	//changes Scene to Main Gui
	@FXML
	public void changeScreenButtonPushed(ActionEvent event) throws IOException {
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("\\MainGUI.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);		
		//get stage information
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setTitle("Training Requests");
		
		window.setScene(tableViewScene);
		window.show();	
		
	}
	
	

}
