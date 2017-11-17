package TrainingOverviewWindow;


import java.util.ArrayList;
import java.util.Scanner;

public class TrainingOverviewWindow {

	ArrayList<String> trainings = new ArrayList<>();
	
	public ArrayList<String> getTrainings() {
		return trainings;
		//lol 
	}

	public void setTrainings(ArrayList<String> trainings) {
		this.trainings = trainings;
	}

	
	public void addTrainings()
	{
		//String trainingName;
		System.out.println("Give the name of a training: ");
		
		Scanner sc = new Scanner(System.in);
		String test=sc.nextLine();
		
		trainings.add(test);
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

}
