package gui;


import java.io.IOException;

//import java.time.LocalTime;
//import java.time.format.DateTimeFormatter;
//import java.util.Properties;
//import java.util.Timer;
/*
 *mail imports
 * 
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
*/

import javafx.fxml.FXML;
import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.ListView;


public class HRApplicationMainController extends MainLoader{
	
	@FXML
	private Button gotoTrainingButton;
		
    @FXML
    private Button SettingsButton;
    
    @FXML
    private Button StatisticsButton;
    
    @FXML
    private void goToTraining() throws IOException {
    	MainLoader.showTraining(); 
    	MainLoader.showLeftsideTraining();
    	gotoTrainingButton.setEffect(BloomON);
    	SettingsButton.setEffect(BloomOFF);
    	StatisticsButton.setEffect(BloomOFF);
    }
    
    @FXML
    private void goToSettings() throws IOException{
    	MainLoader.ShowApplicationSettings();
    	MainLoader.showLeftSideSettings();
    	
    	//settings needs to be replaced with an image!
    	gotoTrainingButton.setEffect(BloomOFF);
    	SettingsButton.setEffect(BloomON);
    	StatisticsButton.setEffect(BloomOFF);
    }
    
    @FXML
    private void goToStatistics() throws IOException{
    	MainLoader.ShowStatistics1Screen();
    	MainLoader.ShowLeftSideStatisticsScreen();
    	
    	gotoTrainingButton.setEffect(BloomOFF);
    	SettingsButton.setEffect(BloomOFF);
    	StatisticsButton.setEffect(BloomON);
    }
    
    
    

}

