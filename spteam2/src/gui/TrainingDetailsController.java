package gui;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPopup;
import com.jfoenix.controls.JFXPopup.PopupHPosition;
import com.jfoenix.controls.JFXPopup.PopupVPosition;
import com.jfoenix.controls.JFXTextArea;

import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker.State;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import training.Training;

public class TrainingDetailsController extends AnchorPane {
	private Training training = null;
	
	@FXML
	private Label windowTitle;
	@FXML
	private TextField name;
	@FXML
	private TextField date;
	@FXML
	private TextField location;
	@FXML
	private JFXTextArea description;
	@FXML
	private VBox participantsBox;
	@FXML
	private VBox booksBox;
	@FXML
	private JFXButton mapButton;
	
	public TrainingDetailsController(Training training) {
		if(training == null) throw new NullPointerException();
		this.training = training;
		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TrainingDetailsView.fxml"));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);
		try {
			fxmlLoader.load();
		} catch (IOException exception) {}
		
		name.setText(training.getName());
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd / MM / yyyy");
		date.setText(dateFormat.format(training.getDate().getTime()));
		location.setText(training.getLocation().toString());
		description.setText(training.getDescription());
		
	
	}
	
	@FXML
	public void close() {
		try {
			MainController.get().closePopup();
		} catch(Exception e) {}
	}
	
	@FXML
	public void openMap() {
		//used code example from: https://developers.google.com/maps/documentation/javascript/adding-a-google-map
		WebView webView = new WebView();
		WebEngine webEngine = webView.getEngine();
		webEngine.load(getClass().getResource("map.html").toExternalForm());
		webEngine.setJavaScriptEnabled(true);
		String function = "moveToLocation(" + training.getLocation().getLatitude() + ", " + training.getLocation().getLongitude() + ");";
		
		webEngine.getLoadWorker().stateProperty().addListener(new javafx.beans.value.ChangeListener<State>() {

			@Override
			public void changed(ObservableValue ov, State oldState, State newState) {
				 if (newState == State.SUCCEEDED) {
                     webEngine.executeScript(function);
                 }
			}
			
		});
		
		AnchorPane content = new AnchorPane();
		content.getChildren().add(webView);
		AnchorPane.setLeftAnchor(webView, (double) 0);
		AnchorPane.setRightAnchor(webView, (double) 0);
		AnchorPane.setTopAnchor(webView, (double) 0);
		AnchorPane.setBottomAnchor(webView, (double) 0);
		JFXPopup popup = new JFXPopup(content);
		webView.setMaxSize(420, 420);
		popup.setMaxSize(420, 420);
		popup.show(mapButton, PopupVPosition.TOP, PopupHPosition.LEFT);
	}
}
