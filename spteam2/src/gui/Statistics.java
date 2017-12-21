package gui;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import database.Dao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import maps.Location;
import training.Training;

public class Statistics {
	public List<Node> getGeneral() {
		List<Node> list = new ArrayList<Node>();
		list.add(mostUsedLocations());
		
		
		return list;
	}
	
	public Node mostUsedLocations() {
		Dao<Training> dao = new Dao<Training>(Training.class);
		List<Object> count = dao.selectObject("SELECT count(Location) FROM training.Training GROUP BY Location ORDER BY count(Location) DESC");
		List<Object> address = dao.selectObject("SELECT T.location FROM training.Training T GROUP BY T.location ORDER BY count(T.location) DESC");
		
		if(count.size() == 0) return new Label("No locations");
		ObservableList<PieChart.Data> pieChartData =  FXCollections.observableArrayList(new PieChart.Data((String) address.get(0), (long) count.get(0)));
		
		for(int i = 1; i < count.size() && i < 7; i++) {
			pieChartData.add(new PieChart.Data((String) address.get(i), (long) count.get(i)));
		}
		
		final PieChart chart = new PieChart(pieChartData);
		chart.setTitle("Most used locations");
		chart.setStyle("-fx-border-color: Black; -fx-background-color: white;");
		
		return chart;
	}
	
	public Node trainingsPerMonth() {
		return null;
	}
	
	public static void main(String[] args) {
		Dao<Training> dao = new Dao<Training>(Training.class);
		System.out.println(dao.selectObject("SELECT T.location FROM training.Training T GROUP BY T.location ORDER BY count(T.location) DESC"));
	}
}
