package gui;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSpinner;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;


public class MainController {
	private static MainController mc = null;
	
	@FXML
    private JFXButton logoutButton;
	@FXML 
	private AnchorPane topLeftMenu;
	@FXML
	private JFXButton dashboardButton;
	@FXML
	private JFXButton statisticsButton;
	@FXML
	protected AnchorPane contentPane;
	@FXML
	protected AnchorPane leftPane;
	@FXML
	private HBox homePane;
	
	private JFXButton activetab;
	private String activeButtonColour = "#777777";
	
	public MainController() throws DuplicateControllerException {
		if (mc != null) throw new DuplicateControllerException();
	}
	
    public void initialize() {
    	mc = this;
    }
    
    public static MainController get() {
    	return mc;
    }
	
	@FXML
	public void showDashboard() {
		activateTab(dashboardButton);
		this.clear();
		FXMLLoader loader = new FXMLLoader();
    	loader.setLocation((MainLoader.class.getResource("DashBoardTopMenuViewPart.fxml")));
    	AnchorPane dashBoardTopMenu = null;
		try {
			dashBoardTopMenu = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		topLeftMenu.getChildren().add(dashBoardTopMenu);
	}
	
	public void showStatistics() {
		activateTab(statisticsButton);
		this.clear();
		FXMLLoader loader = new FXMLLoader();
    	loader.setLocation((MainLoader.class.getResource("StatisticsTopMenuViewPart.fxml")));
    	AnchorPane statisticsTopMenu = null;
		try {
			statisticsTopMenu = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		topLeftMenu.getChildren().add(statisticsTopMenu);
	}
	
	@FXML
	private void clear() {
		leftPane.setVisible(true);
		homePane.setVisible(false);
		if(topLeftMenu.getChildren() != null) topLeftMenu.getChildren().clear();
		if(contentPane.getChildren() != null) contentPane.getChildren().clear();
	}
	
	@FXML
	private void activateTab(JFXButton button) {
		if(this.activetab != null) this.activetab.setStyle("-fx-background-color: transparent");
		activetab = button;
		button.setStyle("-fx-background-color: " + activeButtonColour);
	}
	
	@FXML
	public void setToContentPane(Node e) {
		if(contentPane.getChildren() == null) return;
		contentPane.getChildren().clear();
		contentPane.getChildren().add(e);
		AnchorPane.setBottomAnchor(e, 0d);
		AnchorPane.setTopAnchor(e, 0d);
		AnchorPane.setLeftAnchor(e, 0d);
		AnchorPane.setRightAnchor(e, 0d);
	}
	
	@FXML
	private void logout() {
		MainLoader.getMain().showLogin();
	}
	
	public void  clearContentPane() {
		contentPane.getChildren().clear();
	}
	
	public void openPopup(AnchorPane a) {
		a.setId("popup");
		for(Node e : contentPane.getChildren()) {
			if(e.getId() == "popup") contentPane.getChildren().remove(e);
		}
		contentPane.getChildren().add(a);
		AnchorPane.setLeftAnchor(a, 350d);
		AnchorPane.setTopAnchor(a, 80d);
	}
	
	public void closePopup() {
		for(Node e : contentPane.getChildren()) {
			if(e.getId() == "popup") contentPane.getChildren().remove(e);
		}
	}
	
	public synchronized void loading(boolean b) {
		for(Node e : contentPane.getChildren()) {
			if(e.getId() == "loading") {
				contentPane.getChildren().remove(e);
			}
		}
		
		if(b) {
			contentPane.getChildren().clear();
			Label loading = new Label("Loading...");
			loading.setFont(Font.font(30));
			loading.setId("loading");
			contentPane.getChildren().add(loading);
			AnchorPane.setLeftAnchor(loading, 600d);
			AnchorPane.setTopAnchor(loading, 400d);
		}
	}
}

