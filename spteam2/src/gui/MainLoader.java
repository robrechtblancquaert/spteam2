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
		primaryStage.show();	
		
	}

	public static void main (String[] args) {
		launch(args);
	}
}





/*
 * Transition Code - source - https://stackoverflow.com/questions/24978278/fade-in-fade-out-a-screen-in-javafx
 * 
FadeTransition ft = new FadeTransition(Duration.millis(1000), mainLayout);
ft.setFromValue(0.5);
ft.setToValue(1);
ft.play();
*/
