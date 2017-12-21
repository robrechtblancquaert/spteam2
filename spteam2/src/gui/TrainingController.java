package gui;

import java.io.IOException;
import java.text.SimpleDateFormat;

import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXPopup;
import com.jfoenix.controls.JFXPopup.PopupHPosition;
import com.jfoenix.controls.JFXPopup.PopupVPosition;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.PopupWindow.AnchorLocation;
import training.Training;

public class TrainingController extends AnchorPane{
	
	private Training training;
	
	@FXML
	private Label name;
	@FXML
	private Label date;
	@FXML
	private TextArea description;
	@FXML
	private TextArea location;
	@FXML
	private Label participantsNumber;
	
	public TrainingController(Training training) {
		this.training = training;
		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TrainingView.fxml"));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);
		try {
			fxmlLoader.load();
		} catch (IOException exception) {}
		applyTrainingInformation();
 	}


	public Training getTraining() {
		return training;
	}
	public void setTraining(Training training) {
		this.training = training;
	}
	
	public Label getName() {
		return name;
	}
	public Label getDate() {
		return date;
	}
	public TextArea getDescription() {
		return description;
	}
	public TextArea getLocation() {
		return location;
	}
	public Label getParticipantsNumber() {
		return participantsNumber;
	}

	@FXML
	public void openTrainingDetails() {
		try {
			MainController.get().closePopup();
		} catch (Exception e) {}
		TrainingDetailsController details = new TrainingDetailsController(this.training);
		MainController.get().openPopup(details);
	}
	
	@FXML
	public void applyTrainingInformation() {
		if(this.training == null) return;
				
		this.name.setText(training.getName());
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
		String date = dateFormat.format(training.getDate().getTime());
		this.date.setText(date);
		this.description.setText((training.getDescription()));
		this.location.setText(training.getDescription());
		Integer participants = training.getParticipants().size();
		this.participantsNumber.setText(participants.toString());
	}
}
