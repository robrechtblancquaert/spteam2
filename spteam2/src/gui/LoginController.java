package gui;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import database.User;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

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
	@FXML
	private HBox messageBox;
	@FXML
	private volatile Label message;
	
	public void initialize() {
		
	}
	
	@FXML
	public void checkLogin() {
		lockFields(true);
		
		if(checkCharsCredentials(username.getText()) && checkCharsCredentials(password.getText())) {
			message.setTextFill(Color.BLACK);
			message.setText("Checking credentials...");
			Thread login = new Thread(new Runnable() {
				@Override
				public void run() {
					boolean b = User.checkCredentials(username.getText(), password.getText());
					if(b) {
						Platform.runLater(new Runnable() {
							@Override
							public void run() {
								MainLoader.getMain().showDashboard();
							}		
						});
					} else {
						Platform.runLater(new Runnable() {
							@Override
							public void run() {
								displayWrongLogin();
							}		
						});
					}
				}		
			});
			login.start();
		} else {
			displayWrongLogin();
		}		
	}
	
	@FXML
	private synchronized void displayWrongLogin() {
		password.clear();
		message.setText("Invalid username or password.");
		message.setTextFill(Color.RED);
		lockFields(false);
	}
	
	public void close() {
		Platform.exit();
	}
	
	private void lockFields(boolean b) {
		username.setEditable(!b);
		password.setEditable(!b);
	}
	
	public static boolean checkCharsCredentials(String s) {
		if(s.length() < 8 || s.length() > 32) return false;
		String regex = "[A-Za-z0-9!\"\\\\#$%&\'()*+,-./:;<=>?@\\[\\]^_`{|}~]+"; 
		return s.matches(regex);
	}
	
	
}
