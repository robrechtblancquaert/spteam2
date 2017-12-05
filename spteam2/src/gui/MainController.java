package gui;

import java.io.IOException;

import org.controlsfx.glyphfont.FontAwesome;
import org.controlsfx.glyphfont.Glyph;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSpinner;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;


public class HRApplicationMainController extends MainLoader{
	@FXML
    private JFXButton logoutButton;
	
	@FXML
	private Pane optionsPane;
	
	@FXML
	private JFXSpinner loadingSpinner;
	
    public void initialize() throws IOException {
    	
    }
    
    public void stopSpinner() {
    	loadingSpinner.setVisible(false);
    }
}

