package gui;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.jfoenix.controls.JFXComboBox;
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
import javafx.util.StringConverter;
import training.Training;

public class DashboardController {
	private MainController mc = null;

	@FXML
	private JFXDatePicker fromCalendar; 
	@FXML
	private JFXDatePicker toCalendar;
	@FXML
	private JFXComboBox<Label> intervalBox;
	
	public void initialize() {
		mc = MainController.get();
		
		fromCalendar.setValue(LocalDate.now());
		toCalendar.setValue(LocalDate.now().plusMonths(3));
		
		intervalBox.getItems().addAll(new Label("None"), new Label("Day"), new Label("Week"), new Label("Month"), new Label("Year"));
		intervalBox.setConverter(new StringConverter<Label>() {

			@Override
			public String toString(Label object) {
				return object == null? "" : object.getText();
			}

			@Override
			public Label fromString(String string) {
				return new Label(string);
			}
			
		});
		intervalBox.getSelectionModel().selectFirst();
		
		
		applyOptions();
	}
	
	public Map<String, List<Node>> getTrainings(Calendar fromDate, Calendar toDate) {
		Map<String, List<Node>> map = new TreeMap<String, List<Node>>();
		
		Dao<Training> trainingDao = new Dao<Training>(Training.class);
		String intervalValue = intervalBox.getValue().getText();
		
		List<Training> trainings = new ArrayList<Training>();
		trainings = trainingDao.selectObjectBetweenDates("date", fromDate, toDate);
		trainings.sort(new Comparator<Training>() {
			@Override
			public int compare(Training o1, Training o2) {
				return o1.getDate().compareTo(o2.getDate());
			}	
		});
		
		switch(intervalValue) {
		case "None": 
			map.put("All", createTrainingControllerList(trainings));
			break;
		case "Day": 
			Calendar dayCalendar = fromDate;
			toDate.add(Calendar.DATE, 1);
			while(dayCalendar.before(toDate)) {
				SimpleDateFormat format = new SimpleDateFormat("EEEE, dd/MM/yy", Locale.UK);
				Calendar temp = (Calendar) dayCalendar.clone();
				dayCalendar.add(Calendar.DATE, 1);
				List<Node> nodes = createTrainingControllerList(getTrainingsBetweenDates(trainings, temp, dayCalendar));
				if(nodes.size() > 0) {
					map.put(format.format(temp.getTime()), nodes);
				}		
			}
			break;
		case "Week":
			Calendar weekCalendar = fromDate;
			weekCalendar.set(Calendar.DAY_OF_WEEK, 1);
			toDate.add(Calendar.DATE, 1);
			while(weekCalendar.before(toDate)) {
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy", Locale.UK);
				Calendar temp = (Calendar) weekCalendar.clone();
				weekCalendar.add(Calendar.DATE, 8);
				List<Node> nodes = createTrainingControllerList(getTrainingsBetweenDates(trainings, temp, weekCalendar));
				if(nodes.size() > 0) {
					map.put(format.format(temp.getTime()) + " to " + format.format(weekCalendar.getTime()), nodes);
				}		
			}
			break;
		case "Month":
			Calendar monthCalendar = fromDate;
			monthCalendar.set(Calendar.DAY_OF_MONTH, 1);
			toDate.add(Calendar.MONTH, 1);
			while(monthCalendar.before(toDate)) {
				SimpleDateFormat format = new SimpleDateFormat("MMMM YYYY", Locale.UK);
				Calendar temp = (Calendar) monthCalendar.clone();
				monthCalendar.add(Calendar.MONTH, 1);
				List<Node> nodes = createTrainingControllerList(getTrainingsBetweenDates(trainings, temp, monthCalendar));
				if(nodes.size() > 0) {
					map.put(format.format(temp.getTime()), nodes);
				}		
			}
			break;
		case "Year":
			Calendar yearCalendar = fromDate;
			toDate.add(Calendar.YEAR, 1);
			while(yearCalendar.before(toDate)) {
				SimpleDateFormat format = new SimpleDateFormat("YYYY", Locale.UK);
				Calendar temp1 = (Calendar) yearCalendar.clone();
				temp1.set(Calendar.DAY_OF_YEAR, 1);
				Calendar temp2 = (Calendar) yearCalendar.clone();
				temp2.set(Calendar.MONTH, 11);
				temp2.set(Calendar.DAY_OF_MONTH, 31);
				List<Node> nodes = createTrainingControllerList(getTrainingsBetweenDates(trainings, temp1, temp2));
				if(nodes.size() > 0) {
					map.put(format.format(yearCalendar.getTime()), nodes);
				}
				yearCalendar.add(Calendar.YEAR, 1);
			}
			break;
		}
		
		return map;
	}
	
	public List<Node> createTrainingControllerList(List<Training> trainings) {
		List<Node> nodes = new ArrayList<Node>();
		for(Training t : trainings) {
			nodes.add(new TrainingController(t));
		}
		
		return nodes;
	}
	
	public List<Training> getTrainingsBetweenDates(List<Training> trainings, Calendar startDate, Calendar oneDayOverEndDate) {
		List<Training> result = new ArrayList<Training>();
		
		int counter = 0;
		boolean b = true;
		while(b && counter < trainings.size()) {
			if(!(trainings.get(counter).getDate().before(startDate))) {
				if(trainings.get(counter).getDate().after(oneDayOverEndDate) || trainings.get(counter).getDate().get(Calendar.DAY_OF_YEAR) == oneDayOverEndDate.get(Calendar.DAY_OF_YEAR)) {
					b = false;
				} else {
					result.add(trainings.get(counter));
				}
			}
			
			counter++;
		}
		return result;
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
		
		mainPane.setContent(mainBox);
		mc.setToContentPane(mainPane);
	}
	
	@FXML
	public synchronized void applyOptions() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						showOverview(getTrainings(GregorianCalendar.from(fromCalendar.getValue().atStartOfDay(ZoneId.systemDefault())), GregorianCalendar.from(toCalendar.getValue().atStartOfDay(ZoneId.systemDefault()))));
						MainController.get().loading(false);
					}
					
				});
			}	
		}).start();;
		MainController.get().loading(true);
	}
}
