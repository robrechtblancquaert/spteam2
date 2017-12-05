package gui;

//https://stackoverflow.com/questions/43429492/how-to-pass-an-object-from-one-controller-to-another-with-javafx



import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class LoginController extends HRApplicationMainController{	
	
    @FXML
    private TextField UsernameTextfield;

    @FXML
    private TextField PasswordTextfield;

    @FXML
    private Label UsernameLabel;

    @FXML
    private Button LogInButton;

    @FXML
    private Label PasswordLabel;
    /*
     
   //if text in textfield -> glow
    @FXML
    private void GlowUsername() throws IOException{
    	UsernameLabel.setEffect(GlowOFF);
    }
    
    @FXML
    private void GlowPassword() throws IOException{
    	PasswordLabel.setEffect(GlowON);
    }
    
    
    @FXML
    private void gotoDashBoardButton() throws IOException {
    	MainLoader.LogInButtonClicked();    	
    }
    
    @FXML
    static void LoginButtonCLicked(ActionEvent event) throws IOException{
    	MainLoader.showDashBoard();
    	//HRApplicationMainController.ChangeLogout(); Static gezever
    	   	
    }
    */
    
    
   
    
    

    

}
