package gui;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.jfoenix.controls.JFXDatePicker;

import database.Dao;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import training.Training;

public class DashboardController {
	private MainController mc = null;
	private LocalDate startDate;
	private LocalDate endDate;
	@FXML
	private JFXDatePicker fromCalendar; 
	@FXML
	private JFXDatePicker toCalendar;
	
	public void initialize() {
		mc = MainController.get();
		
		startDate = LocalDate.now();
		endDate = LocalDate.now().plusMonths(3);
		fromCalendar.setValue(startDate);
		toCalendar.setValue(endDate);
		
		Thread show = new Thread(new Runnable() {
			@Override
			public void run() {
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						showOverview(getTrainings());
						MainController.get().loading(false);
					}
					
				});
			}	
		});
		show.start();
		MainController.get().loading(true);
	}
	
	public Map<String, List<Node>> getTrainings() {
		Dao<Training> trainingDao = new Dao<Training>(Training.class);
		List<Training> trainings = new ArrayList<Training>();
		trainings = trainingDao.selectObject("FROM training.Training");
		
		List<Node> nodes = new ArrayList<Node>();
		for(Training t : trainings) {
			nodes.add(new TrainingController(t));
		}
		
		Map<String, List<Node>> map = new HashMap<String, List<Node>>();
		
		map.put("All", nodes);
		return map;
	}
	
	public void showOverview(Map<String, List<Node>> nodeMap) {
		ScrollPane mainPane = new ScrollPane();
		VBox mainBox = new VBox();
		mainBox.setPadding(new Insets(20));
		
		for(Entry<String, List<Node>> e : nodeMap.entrySet()) {
			Label l = new Label(e.getKey());
			mainBox.getChildren().add(l);
			
			Separator s = new Separator();
			s.setOrientation(Orientation.HORIZONTAL);
			mainBox.getChildren().add(s);
			
			HBox box = new HBox();
			int counter = 0;
			for(Node n : e.getValue()) {
				box.getChildren().add(n);
				HBox.setMargin(n, new Insets(5));
				counter++;
				if(counter == 6) {
					mainBox.getChildren().add(box);
					box = new HBox();
					counter = 0;
				}
			}
			mainBox.getChildren().add(box);
		}
		
		//mainPane.set
		mainPane.setContent(mainBox);
		mc.setToContentPane(mainPane);
	}
}
