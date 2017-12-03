package gui;

import java.io.IOException;

//import java.net.URL;
//import java.util.ResourceBundle;

//import com.jfoenix.controls.JFXToggleButton;

import eu.hansolo.medusa.Clock;
import eu.hansolo.medusa.Clock.ClockSkinType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
/*
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.effect.Bloom;
*/
public class DashBoardController extends HRApplicationMainController{

    @FXML
    private Clock clock;

    @FXML
    private Button DigitalClockButton;

    @FXML
    private Button ClockButton;
    
    public void initialize() throws IOException{
    	clock.setSkinType(ClockSkinType.CLOCK);
    	ClockButton.setEffect(ClockGlowON);    	
    }
    
    @FXML
    void MakeClockTypeDigital(ActionEvent event) {
    	clock.setSkinType(ClockSkinType.DIGITAL);	
    	DigitalClockButton.setEffect(DigitalGlowON);
    	ClockButton.setEffect(ClockGlowOFF);
    	

    }

    @FXML
    void makeClocknonDigital(ActionEvent event) { 
    	clock.setSkinType(ClockSkinType.CLOCK);
    	DigitalClockButton.setEffect(DigitalGlowOFF);
    	ClockButton.setEffect(ClockGlowON);

    }
    
    
}




/*
 * //https://jar-download.com/javaDoc/com.jfoenix/jfoenix/1.4.0/com/jfoenix/controls/JFXToggleButton.html
 * 
public void initialize(URL arg0, ResourceBundle arg1) {    	
    
    ToggleClock.selectedProperty().addListener(new ChangeListener<Boolean>() {
    	@Override
    	public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) {
    		if(ToggleClock.isSelected()==true) {
    			ToggleClock.setText("Digital");
    		}
    		else {
    			ToggleClock.setText("Clock");
    		}
    	}
    });
    
    }	
    
    */
