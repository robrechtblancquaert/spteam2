package gui;

import java.io.IOException;
//import java.net.URL;
//import java.time.LocalDate;
//import java.time.Month;
import java.util.Optional;

//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import java.util.ResourceBundle;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
//import javafx.scene.control.SelectionMode;
//import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainRemakeController /*implements Initializable*/{

    @FXML
    private Label departementLabel;

    @FXML
    private Button ImportTrainingButton;

    @FXML
    private Button MailManagerButton;

    @FXML
    private TableView<?> TrainingTabel;

    @FXML
    private Button ImportCancelRequestsButton;

    @FXML
    private Button ConfigButton;

    @FXML
    private Button MailTraineeButton;

    @FXML
    private Button AddCertificateButton;

    @FXML
    private TextField TrainingRequestTextField;

    @FXML
    private Button DeclineCertificateButton;

    @FXML
    private TableView<?> aanvraagTabel;

    @FXML
    private Button importCertficiateButton;

    @FXML
    private Label voorNaamLabel;

    @FXML
    private Label joinedDateLabel;

    @FXML
    private Button BooksButton;

    @FXML
    private Label ageLabel;

    @FXML
    private Button DeleteTrainingButton;

    @FXML
    private TextField extraInformationTraineeTextfield;

    @FXML
    private Button ViewCertificateButton;

    @FXML
    private Label StatusLabel;

    @FXML
    private Label achterNaamLabel;

    @FXML
    private Label functieLabel;

    @FXML
    private Button ShowTrainingLocationButton;

    @FXML
    private Button AccountButton;

    @FXML
    private Label ModeLabel;
    
    @FXML
    private Button AddTrainingButton;
    
    @FXML
    private Button LogoutButton;
    
   
    
    @FXML
    public void ImportTrainingButtonPushed(ActionEvent event) throws IOException {
    	 ModeLabel.setText("Training Requests");
    	 AddTrainingButton.setDisable(false);
    	 DeleteTrainingButton.setDisable(false);
    	 ShowTrainingLocationButton.setDisable(false);
    	 AddCertificateButton.setDisable(true);
    	 ViewCertificateButton.setDisable(true);
    	 DeclineCertificateButton.setDisable(true);
    	 BooksButton.setDisable(false);
    	 MailTraineeButton.setDisable(false);
    	 MailManagerButton.setDisable(false);
    	 StatusLabel.setText("Import Training Button Clicked");    	 
    }
    
    @FXML    
    public void ImportCertificateRequestButtonPushed(ActionEvent event) throws IOException {
    	 ModeLabel.setText("Certificate Requests");
    	 AddTrainingButton.setDisable(true);
    	 DeleteTrainingButton.setDisable(true);
    	 ShowTrainingLocationButton.setDisable(true);
    	 AddCertificateButton.setDisable(false);
    	 ViewCertificateButton.setDisable(false);
    	 DeclineCertificateButton.setDisable(false);
    	 BooksButton.setDisable(true);
    	 MailTraineeButton.setDisable(false);
    	 MailManagerButton.setDisable(false);
    	 StatusLabel.setText("certificate Request Button Clicked");    	
    }
    
    @FXML
    public void ImportCancelRequestButtonPushed(ActionEvent event) throws IOException {
    	 ModeLabel.setText("Cancel Requests");
    	 AddTrainingButton.setDisable(true);
    	 DeleteTrainingButton.setDisable(false);
    	 ShowTrainingLocationButton.setDisable(true);
    	 AddCertificateButton.setDisable(true);
    	 ViewCertificateButton.setDisable(true);
    	 DeclineCertificateButton.setDisable(true);
    	 BooksButton.setDisable(true);
    	 MailTraineeButton.setDisable(false);
    	 MailManagerButton.setDisable(false);
    	 StatusLabel.setText("Cancel Request Button Pushed");    	
    }
    
    @FXML
    public void AddTrainingButtonPushed(ActionEvent event) throws IOException{
    	StatusLabel.setText("Add Training button pushed");
    }
    
    @FXML
    public void DeleteTrainingButtonPushed(ActionEvent event) throws IOException{
    	StatusLabel.setText("Delete training button pushed");
    }
    
    @FXML
    public void ShowTrainingLocationButtonPushed(ActionEvent event) throws IOException{
    	StatusLabel.setText("Show training button pushed");
    }
    
    @FXML
    public void AddCertificateButtonPushed(ActionEvent event) throws IOException{
    	StatusLabel.setText("Add certificate button pushed");
    }
    
    @FXML
    public void ViewCertificateButtonPushed(ActionEvent event) throws IOException{
    	StatusLabel.setText("View Certificate button pushed");
    }
    
    @FXML
    public void DeclineCertificateButtonPushed(ActionEvent event) throws IOException{
    	StatusLabel.setText("Decline Certificate button pushed");
    }
    
    @FXML
    public void BooksButtonPushed(ActionEvent event) throws IOException{
    	StatusLabel.setText("Books button pushed");
    }
    
    @FXML
    public void MailTraineeButtonPushed(ActionEvent event) throws IOException{
    	StatusLabel.setText("Mail Trainee button pushed");
    }
    
    @FXML
    public void MailManagerButtonPushed(ActionEvent event) throws IOException{
    	StatusLabel.setText("Mail Manager button pushed");
    }
    
    @FXML
    public void AccountButtonPushed(ActionEvent event) throws IOException{
    	StatusLabel.setText("Account button pushed");
    }
    
    //http://code.makery.ch/blog/javafx-dialogs-official/
   @FXML
   public void LogoutButtonPushed(ActionEvent event) throws IOException{
	Alert alert = new Alert(AlertType.CONFIRMATION);
	alert.setTitle("Logging out");
	alert.setHeaderText("Confirmation needed");
	alert.setContentText("Are you sure you want tot log out?");	
	
	Optional<ButtonType> result = alert.showAndWait();
	if (result.get() == ButtonType.OK){
	    System.out.println("LOGGING OUT");
	} else {
		System.out.println("user chose to stay logged in");
	}
	
   	StatusLabel.setText("Logging out");
   }
    
    @FXML
    void gotoSettingsButtonPushed(ActionEvent event) throws IOException {
	 try {
	 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("\\ApplicationSettingsGUI.fxml"));
	 Parent root1 = (Parent) fxmlLoader.load();
	 Stage stage = new Stage();	 
	 stage.setTitle("Config");
	 stage.setScene(new Scene(root1));
	 stage.show(); 	 
	 
	 StatusLabel.setText("Config button pushed");	 
 } catch (Exception e)
	 {
	 System.out.println("Application Window cannot be loaded");
	 } 
 		}
    
    
    /*
     * deze code laad de tabel met dummy data
     * Dennis
     * 
    @FXML private TableView<Person> tableView;
	@FXML private TableColumn<Person,String> firstNameColumn;
	@FXML private TableColumn<Person,String> lastNameColumn;
	
    private Person selectedPerson;
    
    public void initData(Person person)
	{
		selectedPerson = person;
		voorNaamLabel.setText(selectedPerson.getFirstName());
		achterNaamLabel.setText(selectedPerson.getLastName());
		functieLabel.setText(selectedPerson.getFunction());
		joinedDateLabel.setText(selectedPerson.getJoinedDate().toString());
		ageLabel.setText(Integer.toString(selectedPerson.getAge()));
		departementLabel.setText(selectedPerson.getDepartement());
	}
    
	@FXML
	public void showTrainingDetails(ActionEvent event) throws IOException
	{
	initData(tableView.getSelectionModel().getSelectedItem());
	}
	
	
	 @Override 
     public void initialize(URL url, ResourceBundle rb) {
    	 //set up the columns in the table
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
       
        
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
	 
	 public ObservableList<Person> getPeople()
	 {
		 ObservableList<Person> people = FXCollections.observableArrayList();
		 people.add(new Person("Duke","Java",LocalDate.of(1996, Month.JANUARY,23), "Java Departement", "Mascot",LocalDate.of(1996, Month.JANUARY, 23)));
		 return people;
	 } 	
    
    */
    
    
    
    


}