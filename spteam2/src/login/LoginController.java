package login;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class LoginController implements Initializable {
	
	 public LoginDAO loginModel = new LoginDAO();
	   @FXML
	   private TextField loginName;
	   
	   @FXML
	   private TextField loginPass;
	 
	   @FXML
	   private Label status;
	   
	
	   
	 @Override
	 public void initialize(URL location, ResourceBundle resources) {
	  // TODO Auto-generated method stub
	  if (loginModel.isConnected()) {
	   status.setText("Connected");
	  } else {

	   status.setText("Not Connected");
	  }
	 }
	 public void Login (ActionEvent event){
		 try {
		 if(loginModel.isLogin(loginName.getText(), loginPass.getText())) {
			 status.setText("username and password is correct");
			 status.setTextFill(Color.web("#5ff442"));
		   }
		 else {
			 status.setText("username and password is incorrect");
			 status.setTextFill(Color.web("#ff0c0c"));
		 }
		}
		 catch(SQLException e) {
			 status.setText("username and password is incorrect");
			 status.setTextFill(Color.web("#ff0c0c"));
			 e.printStackTrace();
			 
		 }
		 
	 }
	 
}
