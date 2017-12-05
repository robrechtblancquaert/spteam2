package gui;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class LoginController {
	@FXML
	private ImageView lockIcon;
	@FXML
	private JFXTextField username;
	@FXML
	private JFXPasswordField password;
	@FXML
	private JFXButton login;
	@FXML
	private JFXButton cancel;
	
	public void initialize() {
		
	}

	@FXML
	public void checkLogin() {
		System.out.println(username.getText());
		System.out.println(password.getText());
		//check login
		MainLoader.getMain().showDashboard();
	}
	
	public void close() {
		Platform.exit();
	}
}
