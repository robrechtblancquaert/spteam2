package gui;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXScrollPane;
import com.jfoenix.controls.JFXSpinner;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;


public class MainController {
	public static MainController me;
	
	@FXML
    private JFXButton logoutButton;
	@FXML
	protected JFXSpinner loadingSpinner;
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
	
    public void initialize() throws IOException {
    	me = this;
    }
    
    @FXML
    public void setSpinnerVis(boolean b) {
    	loadingSpinner.setVisible(b);
    }
   
    @FXML
	public AnchorPane getTopLeftMenu() {
		return topLeftMenu;
	}
	
	@FXML
	public AnchorPane getContentPane() {
		return contentPane;
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
		} catch (IOException e) {}
		topLeftMenu.getChildren().add(dashBoardTopMenu);
	}
	
	public void showStatistics() {
		activateTab(statisticsButton);
		this.clear();
	}
	
	@FXML
	private void clear() {
		setSpinnerVis(false);
		leftPane.setVisible(true);
		homePane.setVisible(false);
		if(topLeftMenu.getChildren() != null) topLeftMenu.getChildren().clear();
		if(contentPane.getChildren() != null) contentPane.getChildren().clear();
	}
	
	@FXML
	public void activateTab(JFXButton button) {
		if(this.activetab != null) this.activetab.setStyle("-fx-background-color: transparent");
		activetab = button;
		button.setStyle("-fx-background-color: " + activeButtonColour);
	}
	
	@FXML
	public void addToContentPane(Node e) {
		JFXListView list = new JFXListView();
		list.getItems().add(e);
		contentPane.setLeftAnchor(list, 50.0);
		contentPane.setTopAnchor(list, 50.0);
		contentPane.setRightAnchor(list, 50.0);
		contentPane.setBottomAnchor(list, 50.0);
		contentPane.getChildren().add(list);
	}
	
	public void logout() {
		Platform.exit();
		
	}
}

