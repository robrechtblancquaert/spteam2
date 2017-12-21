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

import books.Book;
import employee.Employee;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker.State;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import maps.Location;
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
	private HBox participantsBox;
	@FXML
	private HBox booksBox;
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
		
		initializeParticipantsBox();
		initializeBooksBox();
	}
	
	private void initializeParticipantsBox() {
		if(training.getParticipants().size() == 0) {
			participantsBox.getChildren().add(new Label("none"));
			return;
		}
		
		VBox name = new VBox();
		name.setAlignment(Pos.CENTER_LEFT);
		name.setPrefWidth(200);
		VBox function = new VBox();
		function.setAlignment(Pos.CENTER_LEFT);
		participantsBox.getChildren().add(name);
		participantsBox.getChildren().add(function);
		
		Label nameLabel = new Label("name");
		nameLabel.setTextFill(Color.CADETBLUE);
		name.getChildren().add(nameLabel);
		Label functionLabel = new Label("function");
		functionLabel.setTextFill(Color.CADETBLUE);
		function.getChildren().add(functionLabel);
		
		for(Employee e :training.getParticipants()) {
			name.getChildren().add(new Label(e.getName()));
			function.getChildren().add(new Label(e.getRole()));
		}
	}
	
	private void initializeBooksBox() {
		if(training.getBooks().size() == 0) {
			booksBox.getChildren().add(new Label("none"));
			return;
		}
		
		VBox name = new VBox();
		name.setAlignment(Pos.CENTER_LEFT);
		name.setPrefWidth(200);
		VBox isbn = new VBox();
		isbn.setAlignment(Pos.CENTER_LEFT);
		booksBox.getChildren().add(name);
		booksBox.getChildren().add(isbn);
		
		Label nameLabel = new Label("title");
		nameLabel.setTextFill(Color.CADETBLUE);
		name.getChildren().add(nameLabel);
		Label functionLabel = new Label("isbn");
		functionLabel.setTextFill(Color.CADETBLUE);
		isbn.getChildren().add(functionLabel);
		
		for(Book e :training.getBooks()) {
			name.getChildren().add(new Label(e.getTitle()));
			isbn.getChildren().add(new Label(e.getIsbn()));
		}
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
		Location location = new Location();
		location.setAddress(training.getLocation());
		String function = "moveToLocation(" + location.getLatitude() + ", " + location.getLongitude() + ");";
		
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
		popup.show(mapButton, PopupVPosition.TOP, PopupHPosition.LEFT, 20, 20);
	}
}
