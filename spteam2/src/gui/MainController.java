package gui;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
//import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class MainController implements Initializable {
	
	/*
	 * config table 
	 *
	 */
	
	@FXML private TableView<Person> tableView;
	@FXML private TableColumn<Person,String> firstNameColumn;
	@FXML private TableColumn<Person,String> lastNameColumn;
	@FXML private TableColumn<Person,LocalDate> birthdayColumn;
	private Person selectedPerson;
	
	/*
	 * 
	 * person to more detailed view
	 */
	
	@FXML private Label firstNameLabel;
	@FXML private Label lastNameLabel;
	@FXML private Label functionLabel;
	@FXML private Label joinedDateLabel;
	@FXML private Label ageLabel;
	@FXML private Label departementLabel;
	@FXML private ImageView photo;
	//@FXML private "textfield" extraInformationField;
	
	
	public void initData(Person person)
	{
		selectedPerson = person;
		firstNameLabel.setText(selectedPerson.getFirstName());
		lastNameLabel.setText(selectedPerson.getLastName());
		functionLabel.setText(selectedPerson.getFunction());
		joinedDateLabel.setText(selectedPerson.getJoinedDate().toString());
		ageLabel.setText(Integer.toString(selectedPerson.getAge()));
		departementLabel.setText(selectedPerson.getDepartement());
		photo.setImage(selectedPerson.getImage());

	}
	
	public void showTrainingDetails(ActionEvent event) throws IOException
	{
	initData(tableView.getSelectionModel().getSelectedItem());
	}
	
	
	
	
	//not workign atm
	  @FXML
	    void gotoCertificateRequests(ActionEvent event) throws IOException {
		  FXMLLoader fxmlLoader = new FXMLLoader();
		  fxmlLoader.setLocation(getClass().getResource("CertificateRequestsGUI.fxml"));
		  
		  Scene scene = new Scene (fxmlLoader.load(),800,500);
		  Stage stage = new Stage();
		  stage.setTitle("Certificate Requests");
		  stage.setScene(scene);
		  stage.show();		  
	  }
		 
	  
	    @FXML
	    void gotoCancelRequests(ActionEvent event) throws IOException {  
	    	/*
	    	Parent root2 = FXMLLoader.load(getClass().getResource("\\CancelRequestsGUI.fxml"));
	    	Scene tableViewScene = new Scene(root2);
	    	
	    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	    	
	    	window.setScene(tableViewScene);
	    	window.show();	    	
	    	*/
	    	
	    	FXMLLoader fxmlLoader = new FXMLLoader();
			  fxmlLoader.setLocation(getClass().getResource("\\\\CancelRequestsGUI.fxml"));
			  
			  Scene scene = new Scene (fxmlLoader.load(),800,500);
			  Stage stage = new Stage();
			  stage.setTitle("Cancel Requests");
			  stage.setScene(scene);
			  stage.show();		  
		  }
	
	 @FXML
	    void gotoSettings(ActionEvent event) throws IOException {
		 try {
		 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("\\ApplicationSettingsGUI.fxml"));
		 Parent root1 = (Parent) fxmlLoader.load();
		 Stage stage = new Stage();
		 
		 stage.setTitle("Application Settings");
		 stage.setScene(new Scene(root1));
		 stage.show();
	 } catch (Exception e)
		 {
		 System.out.println("Application Window cannot be loaded");
		 } 
	 		}
	 


    @FXML
    void changeToDarkThemeMain(ActionEvent event) throws IOException {
    	
    	Parent tableViewParent = FXMLLoader.load(getClass().getResource("GUIMain.fxml"));
    	Scene tableViewScene = new Scene(tableViewParent);
    	tableViewScene.getStylesheets().add(getClass().getResource("DarkThemeMain.css").toExternalForm());
    	
    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setScene(tableViewScene);
		window.show();
    }

    @FXML
    void changeToLightThemeMain(ActionEvent event) throws IOException {
    	Parent tableViewParent = FXMLLoader.load(getClass().getResource("GUIMain.fxml"));
    	Scene tableViewScene = new Scene(tableViewParent);
    	tableViewScene.getStylesheets().add(getClass().getResource("LightThemeMain.css").toExternalForm());
    	
    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setScene(tableViewScene);
		window.show();

    }
  
    //loads table
    @Override 
     public void initialize(URL url, ResourceBundle rb) {
    	 //set up the columns in the table
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
        birthdayColumn.setCellValueFactory(new PropertyValueFactory<Person, LocalDate>("birthday"));
        
        //load dummy data
        tableView.setItems(getPeople());
        
        //Update the table to allow for the first and last name fields
        //to be editable
        tableView.setEditable(true);
        firstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        lastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        
        //This will allow the table to select multiple rows at once
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    	
     } 	 
    	     	 
    	 //method will return an observable list of people objects
    	 public ObservableList<Person> getPeople()
    	 {
    		 ObservableList<Person> people = FXCollections.observableArrayList();
    		 people.add(new Person("Duke","Java",LocalDate.of(1996, Month.JANUARY,23), "Java Departement", "Mascot",LocalDate.of(1996, Month.JANUARY, 23), null));
    		 people.add(new Person("VN2","AN2",LocalDate.of(2002, Month.FEBRUARY,12), null, null, null, null));
    		 people.add(new Person("VN3","AN3",LocalDate.of(2003, Month.MARCH,13), null, null, null, null));
    		 people.add(new Person("VN4","AN4",LocalDate.of(2004, Month.APRIL,14), null, null, null, null));
    		 people.add(new Person("VN5","AN5",LocalDate.of(2005, Month.MAY,15), null, null,  null, null));
    		 people.add(new Person("VN6","AN6",LocalDate.of(2006, Month.JUNE,16), null, null,  null, null));
    		 people.add(new Person("VN7","AN7",LocalDate.of(2007, Month.JULY,17), null, null, null, null));
    		 people.add(new Person("VN8","AN8",LocalDate.of(2008, Month.AUGUST,18), null, null,  null, null));
    		 people.add(new Person("VN9","AN9",LocalDate.of(2009, Month.SEPTEMBER,19), null, null, null, null));
    		 people.add(new Person("VN10","AN10",LocalDate.of(2010, Month.OCTOBER,20), null, null, null, null));
    		 people.add(new Person("VN11","AN11",LocalDate.of(2011, Month.NOVEMBER,21), null, null, null, null));
    		 people.add(new Person("VN12","AN12",LocalDate.of(2012, Month.DECEMBER,22), null, null, null, null));
    		 
    		 return people;
    	 } 			
 }
    	
    
    	 

    
 