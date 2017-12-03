package gui;

import java.io.IOException;

import javafx.animation.FadeTransition;
import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import javafx.scene.effect.Bloom;
import javafx.scene.effect.Glow;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;
public class MainLoader extends Application{
	
	//https://stackoverflow.com/questions/10751271/accessing-fxml-controller-class
	
	
	private Stage primaryStage;
	private static BorderPane mainLayout; //static? werkt niet zonder
	
	
	@Override
	public void start (Stage primaryStage) throws IOException{
		this.primaryStage= primaryStage;
		this.primaryStage.setTitle("HR App");
		showMainView();
		showLogin();
	}
	
	private void showMainView() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainLoader.class.getResource("HRApplicationGUI.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene (mainLayout);
		primaryStage.setScene(scene);
		FadeTransition ft = new FadeTransition(Duration.millis(2000), mainLayout);
		ft.setFromValue(0.0);
		ft.setToValue(1);
		ft.play();
		mainLayout.getStylesheets().add(getClass().getResource("csstest.css").toExternalForm());
		primaryStage.show();	
		
	}
	

	static void showLogIn() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainLoader.class.getResource("LoginGUI.fxml"));
		BorderPane LoginScreen = loader.load();		
		mainLayout.setCenter(LoginScreen);		
	}
	
	
	static void showDashBoard() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainLoader.class.getResource("DashBoardScreen.fxml"));	
		BorderPane DashBoard = loader.load();
		mainLayout.setCenter(DashBoard);
	}	
	
	
    static void showCertificate () throws IOException {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(MainLoader.class.getResource("CertificateScreen.fxml"));    	
    	BorderPane Certificate = loader.load();
    	mainLayout.setCenter(Certificate);
    }
    
    static void showTraining() throws IOException {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(MainLoader.class.getResource("TrainingScreen.fxml"));    	
    	BorderPane TrainingScreen = loader.load();
    	mainLayout.setCenter(TrainingScreen);
    }
    
    static void showCancelations() throws IOException {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(MainLoader.class.getResource("CancelationsScreen.fxml"));    	
    	BorderPane CancelScreen = loader.load();
    	mainLayout.setCenter(CancelScreen);
    }       
    
    static void showSettings() throws IOException{
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(MainLoader.class.getResource("SettingsScreen.fxml"));   	
    	BorderPane SettingsScreen = loader.load();    	
    	mainLayout.setCenter(SettingsScreen);
    }
    
    
    static void showLogin() throws IOException{
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(MainLoader.class.getResource("LoginGUI.fxml"));
    	//Test
    	/*
    	HRApplicationMainController hrapplicationmaincontroller = loader.getController();
    	hrapplicationmaincontroller.changeLogoutButtonToLogOut("");
    	*/
    	//LogInController logincontroller = loader.getController();    	
    	BorderPane LoginScreen = loader.load();
    	mainLayout.setCenter(LoginScreen);
    }
    
    static void LogInButtonClicked() throws IOException{
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(MainLoader.class.getResource("DashBoardScreen.fxml"));
    	BorderPane DasHBoardScreen = loader.load();
    	mainLayout.setCenter(DasHBoardScreen);
    }
    
    
    
	
	public static void main (String[] args) {
		launch(args);
	}
	
	//source for bloom https://docs.oracle.com/javase/8/javafx/api/javafx/scene/effect/Bloom.html    
    public Bloom DashBoardBloomON = new Bloom(0.0);  
    public Bloom CertificateBloomON = new Bloom(0.0); 
    public Bloom SettingsBloomON = new Bloom(0.0); 
    public Bloom TrainingBloomON = new Bloom(0.0); 
    public Bloom CancelationsBloomON = new Bloom(0.0);
    public Bloom LogoutBloomON = new Bloom(0.0);
    
    public Bloom DashBoardBloomOFF = new Bloom(1.0);
    public Bloom CertificateBloomOFF = new Bloom(1.0);
    public Bloom SettingsBloomOFF = new Bloom(1.0);    
    public Bloom CancelationsBloomOFF = new Bloom(1.0);    
    public Bloom TrainingBloomOFF = new Bloom(1.0);
    public Bloom LogoutBloomOFF = new Bloom(1.0);
    
    
    public Glow UserNameGlowON = new Glow(1.0);
    public Glow UserNameGlowOFF = new Glow(0.0);    
    public Glow PasswordGlowON = new Glow (1.0);
    public Glow PasswordGlowOFF = new Glow (0.0);
    
    public Glow DigitalGlowON = new Glow(1.0);
    public Glow DigitalGlowOFF = new Glow(0.0);
    
    public Glow ClockGlowON = new Glow (1.0);
    public Glow ClockGlowOFF = new Glow (0.0);
    
    
	
	
}





/*
 * Transition Code - source - https://stackoverflow.com/questions/24978278/fade-in-fade-out-a-screen-in-javafx
 * 
FadeTransition ft = new FadeTransition(Duration.millis(1000), mainLayout);
ft.setFromValue(0.5);
ft.setToValue(1);
ft.play();
*/
