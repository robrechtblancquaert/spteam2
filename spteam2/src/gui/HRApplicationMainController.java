package gui;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
//import java.util.Properties;
import java.util.Timer;
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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;


public class HRApplicationMainController extends MainLoader{
	
	@FXML
	private Button gotoTrainingButton;
	
    @FXML
    private Button DashBoardButton;

    @FXML
    private Button certificateButton;
    
    @FXML
    private Button SettingsButton;

    @FXML
    private Button CancelRequestButton;
    
    @FXML
    private ListView<?> RecentActionsList;
    
    @FXML
    private Label ActionLabel;
    
    @FXML
    private Label TimeLabelLastAction;
    
    @FXML
    private Label SessionTimeLabel;    

    @FXML
    private  Button LogoutButton;
    
    Timer timer = new Timer();
    
    //startbloom applicatie (start in dashboard)
    //staat in comments anders werkt inheritance niet
    public void initialize() throws IOException {    	
    	//DashBoardButton.setEffect(DashBoardBloomON);    	
    	//ActionLabel.setText("Logged in");    	
    	//TimeLabelLastAction.setText(LocalTime.now().format(dtf));
    	//LogoutButton.setEffect(LogoutBloomOFF);
    }
    
    
    
    //source code for timestamps https://stackoverflow.com/questions/44701422/formatting-local-time-in-java
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");

    @FXML
    private void gotoDashBoardButton() throws IOException {
    	MainLoader.showDashBoard();  
    	ActionLabel.setText("Dashboard Clicked");
    	TimeLabelLastAction.setText(LocalTime.now().format(dtf));    	
    	//this code handles bloom effect
    	//on
    	DashBoardButton.setEffect(DashBoardBloomON);
    	//off
    	gotoTrainingButton.setEffect(TrainingBloomOFF);
    	certificateButton.setEffect(CertificateBloomOFF);
    	SettingsButton.setEffect(SettingsBloomOFF);
    	CancelRequestButton.setEffect(CancelationsBloomOFF);
    	
    }

    @FXML
    void gotocertificate(ActionEvent event) throws IOException {
    	MainLoader.showCertificate();
    	ActionLabel.setText("Certificate Clicked");
    	TimeLabelLastAction.setText(LocalTime.now().format(dtf));
    	
    	//this code handles bloom effect
    	//on
    	certificateButton.setEffect(CertificateBloomON);
    	//off
    	DashBoardButton.setEffect(DashBoardBloomOFF);
    	gotoTrainingButton.setEffect(TrainingBloomOFF);
    	SettingsButton.setEffect(SettingsBloomOFF);
    	CancelRequestButton.setEffect(CancelationsBloomOFF);
    	
    }    
    
    @FXML
    void gotoTraining(ActionEvent event) throws IOException {
    	MainLoader.showTraining();
    	ActionLabel.setText("Training Clicked");
    	TimeLabelLastAction.setText(LocalTime.now().format(dtf));
    	
    	//this code handles bloom effect
    	//on
    	gotoTrainingButton.setEffect(TrainingBloomON);
    	//off
    	DashBoardButton.setEffect(DashBoardBloomOFF);
    	certificateButton.setEffect(CertificateBloomOFF);
    	SettingsButton.setEffect(SettingsBloomOFF);
    	CancelRequestButton.setEffect(CancelationsBloomOFF);
    	
    }    

    @FXML
    void gotoSettings(ActionEvent event) throws IOException {
    	MainLoader.showSettings();
    	ActionLabel.setText("Settings Clicked");
    	TimeLabelLastAction.setText(LocalTime.now().format(dtf));
    	
    	//this code handles bloom effect
    	//on
    	SettingsButton.setEffect(SettingsBloomON);
    	//off
    	DashBoardButton.setEffect(DashBoardBloomOFF);
    	gotoTrainingButton.setEffect(TrainingBloomOFF);
    	certificateButton.setEffect(CertificateBloomOFF);
    	CancelRequestButton.setEffect(CancelationsBloomOFF);
    }

    @FXML
    void gotoCancelations(ActionEvent event) throws IOException {
    	MainLoader.showCancelations();
    	ActionLabel.setText("Cancelation Clicked");
    	TimeLabelLastAction.setText(LocalTime.now().format(dtf));
    	
    	//this code handles bloom effect
    	//on
    	CancelRequestButton.setEffect(CancelationsBloomON);
    	//off
    	DashBoardButton.setEffect(DashBoardBloomOFF);
    	gotoTrainingButton.setEffect(TrainingBloomOFF);
    	certificateButton.setEffect(CertificateBloomOFF);
    	SettingsButton.setEffect(SettingsBloomOFF);
    }
        
    @FXML
    void Logout(ActionEvent event) throws IOException {
    	MainLoader.showLogIn();
    	ActionLabel.setText("Logged out");
    	TimeLabelLastAction.setText(LocalTime.now().format(dtf));
    	LogoutButton.setText("Log In");    	
    	//this code handles bloom effect
    	//on
    	LogoutButton.setEffect(LogoutBloomON);
    	//off
    	CancelRequestButton.setEffect(CancelationsBloomOFF);
    	DashBoardButton.setEffect(DashBoardBloomOFF);
    	gotoTrainingButton.setEffect(TrainingBloomOFF);
    	certificateButton.setEffect(CertificateBloomOFF);
    	SettingsButton.setEffect(SettingsBloomOFF);
    }
    
    @FXML
    void changeLogoutButtonToLogOut() throws IOException{
    	LogoutButton.setText("Log Out");    	
    }
    
    @FXML
    public void ChangeLogout() throws IOException{
    	LogoutButton.setEffect(LogoutBloomOFF);
    	LogoutButton.setText("Log Out"); 
    }
    
    
    /*
    public static void sendEmail(){

		
    	String host = "mail.gmail.com";
    	final String SenderEMail = "HRapplicationTestMail1@gmail.com";
    	final String password ="testaccount";    	
    	String RecipientEMail = "HRapplicationTestMail2@gmail.com";
    	
    	
    	//session object
    	Properties props = new Properties();
    	props.put("mail.smtp.host",host);
    	props.put("mail.smtp.auth","true");
    	
    	Session session = Session.getDefaultInstance(props,
    			new javax.mail.Authenticator() {
    		protected PasswordAuthentication getPasswordAuthentication() {
    			return new PasswordAuthentication(SenderEMail,password);
    		}
    	});
    	//message
    	try {
    		MimeMessage message = new MimeMessage(session);
    		message.setFrom(new InternetAddress(SenderEMail));
    		message.addRecipient(Message.RecipientType.TO,new InternetAddress(RecipientEMail));
    		message.setSubject("Ping");
    		message.setText("Hello this is an example of sending email");
    	
    	
    	//send message
    	Transport.send(message);
    	System.out.println("message sent succesfully");
    	
    } catch (MessagingException mex) {mex.printStackTrace();}
    }
    
*/
    	
    }

