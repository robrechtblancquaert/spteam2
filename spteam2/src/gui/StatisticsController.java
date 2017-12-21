package gui;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class StatisticsController {

	
	public void initialize() {
		showOverview(new Statistics().getGeneral());
	}
	
	public void showOverview(List<Node> nodes) {
		ScrollPane mainPane = new ScrollPane();
		VBox mainBox = new VBox();
		mainBox.setPadding(new Insets(20));
		
		HBox box = new HBox();
		int counter = 0;
		for(Node e : nodes) {
			box.getChildren().add(e);
			HBox.setMargin(e, new Insets(5));
			counter++;
			if(counter == 6) {
				mainBox.getChildren().add(box);
				box = new HBox();
				counter = 0;
			}
			
		}
		mainBox.getChildren().add(box);
		mainPane.setContent(mainBox);
		MainController.get().setToContentPane(mainPane);
	}
}
