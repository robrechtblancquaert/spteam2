package gui;

import java.io.IOException;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
public class MainLoader extends Application{
	
	private static MainLoader main;
	private Stage primaryStage;
	private static AnchorPane login;
	
	public static MainLoader getMain() {
		return main;
	}
	
	@Override
	public void start (Stage primaryStage) throws IOException{
		main = this;
		this.primaryStage= primaryStage;
		this.primaryStage.setTitle("Login");
		showLogin();
	}
	
	private void showLogin(){
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainLoader.class.getResource("LoginView.fxml"));
		try {
			login = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene (login);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();	
		
	}
	
	public void showDashboard() {
		this.primaryStage.setTitle("Training Management");
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainLoader.class.getResource("MainView.fxml"));
		BorderPane dashboard = null;
		try {
			dashboard = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene (dashboard);
		primaryStage.setScene(scene);
		primaryStage.show();	
		
	}
	
	public static void main (String[] args) {
		launch(args);
	}
}
