package gui;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPopup;
import com.jfoenix.controls.JFXPopup.PopupHPosition;
import com.jfoenix.controls.JFXPopup.PopupVPosition;

import database.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

public class AdminController {
	
	@FXML
	private TextField username;
	@FXML
	private TextField email;
	@FXML
	private TextField password;
	@FXML
	private CheckBox admin;
	@FXML
	private CheckBox defaultBox;
	@FXML
	private JFXButton createButton;
	
	public void initialize() {
		
	}
	
	public void defaultBoxChanged() {
		if(defaultBox.isSelected()) {
			password.setText("default!");
			password.setEditable(false);
		} else {
			password.setEditable(true);
		}
		
	}
	
	public void createUser() {
		if(defaultBox.isSelected()) password.setText("default!");
		if(!checkCharsCredentials(username.getText())) {
			popupMessage("Invalid username");
			return;
		}
		if(!checkCharsCredentials(password.getText())) {
			popupMessage("Invalid password");
			return;
		}
		if(!checkCharsCredentials(password.getText())) {
			popupMessage("Invalid password");
			return;
		}
		if(!checkEmail(email.getText())) {
			popupMessage("Invalid email");
			return;
		}
		int role = 1;
		if(admin.isSelected()) role = 2;
		
		try {
			User.createUser(username.getText(), password.getText(), email.getText(), role);
			popupMessage("User created");
		} catch(Exception e) {
			popupMessage("User could not be created");
		}
		
	}
	
	public static boolean checkCharsCredentials(String s) {
		if(s.length() < 8 || s.length() > 32) return false;
		String regex = "[A-Za-z0-9!\"\\\\#$%&\'()*+,-./:;<=>?@\\[\\]^_`{|}~]+"; 
		return s.matches(regex);
	}
	
	public static boolean checkEmail(String s) {
		if(s.length() < 8) return false;
		if(!s.contains("@")) return false;
		if(!s.substring(s.indexOf("@")).contains(".")) return false;
		
		return true;
	}
	
	@FXML
	public void popupMessage(String s) {
		Label l = new Label(s);
		l.setTextFill(Color.RED);
		Insets insets = new Insets(10,10,10,10);
		l.setPadding(insets);
		JFXPopup popup = new JFXPopup(l);
		popup.show(createButton, PopupVPosition.BOTTOM, PopupHPosition.LEFT, 10, 10);
	}
}
