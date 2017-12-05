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
		showDashBoard();
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
	/*

	static void showLogIn() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainLoader.class.getResource("LoginGUI.fxml"));
		BorderPane LoginScreen = loader.load();		
		mainLayout.setCenter(LoginScreen);		
	}
	*/
	
	
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
    static void showLeftsideTraining() throws IOException{
    	FXMLLoader loaderleft = new FXMLLoader();
    	loaderleft.setLocation(MainLoader.class.getResource("LeftSideTrainingScreen.fxml"));
    	BorderPane LeftSide = loaderleft.load(); 
    	mainLayout.setLeft(LeftSide);
    }
    
    static void showLeftSideSettings() throws IOException{
    	FXMLLoader loaderleft = new FXMLLoader();
    	loaderleft.setLocation(MainLoader.class.getResource("LeftSideSettingsScreen.fxml"));
    	BorderPane LeftSideSettings = loaderleft.load(); 
    	mainLayout.setLeft(LeftSideSettings);
    }
    
    
    static void showCancelations() throws IOException {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(MainLoader.class.getResource("CancelationsScreen.fxml"));    	
    	BorderPane CancelScreen = loader.load();
    	mainLayout.setCenter(CancelScreen);
    }       
   
    
    static void ShowApplicationSettings() throws IOException{
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(MainLoader.class.getResource("ApplicationSettingsScreen.fxml"));   	
    	BorderPane SettingsScreen = loader.load();    	
    	mainLayout.setCenter(SettingsScreen);
    }
    
    static void ShowUserSettings() throws IOException{
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(MainLoader.class.getResource("UserSettingsScreen.fxml"));   	
    	BorderPane SettingsScreen = loader.load();    	
    	mainLayout.setCenter(SettingsScreen);
    }
    
    static void ShowTrainingOverview()throws IOException{
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(MainLoader.class.getResource("TrainingOverviewScreen.fxml"));   	
    	BorderPane TrainingOverview = loader.load();    	
    	mainLayout.setCenter(TrainingOverview);
    }
    
    static void ShowStatistics1Screen() throws IOException{
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(MainLoader.class.getResource("Statistics1Screen.fxml"));   	
    	BorderPane StatisticsScreen = loader.load();    	
    	mainLayout.setCenter(StatisticsScreen);
    }
    
    static void ShowStatistics2Screen() throws IOException{
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(MainLoader.class.getResource("Statistics2Screen.fxml"));   	
    	BorderPane StatisticsScreen = loader.load();    	
    	mainLayout.setCenter(StatisticsScreen);
    }
    
    static void ShowLeftSideStatisticsScreen() throws IOException{
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(MainLoader.class.getResource("LeftSideStatistics.fxml"));   	
    	BorderPane StatisticsScreen = loader.load();    	
    	mainLayout.setLeft(StatisticsScreen);
    }
    
    /*
    static void showLogin() throws IOException{
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(MainLoader.class.getResource("LoginGUI.fxml"));
    	//Test
    	/*
    	HRApplicationMainController hrapplicationmaincontroller = loader.getController();
    	hrapplicationmaincontroller.changeLogoutButtonToLogOut("");
    	*/
    	//LogInController logincontroller = loader.getController();  
    	/*
    	BorderPane LoginScreen = loader.load();
    	mainLayout.setCenter(LoginScreen);
    	
    }
    
    */
    
    /*
    static void LogInButtonClicked() throws IOException{
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(MainLoader.class.getResource("DashBoardScreen.fxml"));
    	BorderPane DasHBoardScreen = loader.load();
    	mainLayout.setCenter(DasHBoardScreen);
    }
    */
    
    
	
	public static void main (String[] args) {
		launch(args);
	}
	
	//source for bloom https://docs.oracle.com/javase/8/javafx/api/javafx/scene/effect/Bloom.html    
    public Bloom BloomOFF = new Bloom(1.0);
    public Bloom BloomON = new Bloom (0.0);
    
    public Glow GlowON = new Glow (1.0);
    public Glow GlowOFF = new Glow (0.0);

}





/*
 * Transition Code - source - https://stackoverflow.com/questions/24978278/fade-in-fade-out-a-screen-in-javafx
 * 
FadeTransition ft = new FadeTransition(Duration.millis(1000), mainLayout);
ft.setFromValue(0.5);
ft.setToValue(1);
ft.play();
*/
