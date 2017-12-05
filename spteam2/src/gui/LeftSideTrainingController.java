package gui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class LeftSideTrainingController extends HRApplicationMainController{

    @FXML
    private Button TrainingRequests;

    @FXML
    private Button AnnulationsButton;

    @FXML
    private Button ShowCertificateRequestsButton;

    @FXML
    private Button ShowTrainingInformationButton;   

    @FXML
    private void showTrainingRequests(ActionEvent event) throws IOException {
    	MainLoader.showTraining();
    	
    	TrainingRequests.setEffect(BloomON);
    	AnnulationsButton.setEffect(BloomOFF);
    	ShowCertificateRequestsButton.setEffect(BloomOFF);
    	ShowTrainingInformationButton.setEffect(BloomOFF);
    }

    @FXML
    void showAnnulations(ActionEvent event) throws IOException {
    	MainLoader.showCancelations();
    	
    	TrainingRequests.setEffect(BloomOFF);
    	AnnulationsButton.setEffect(BloomON);
    	ShowCertificateRequestsButton.setEffect(BloomOFF);
    	ShowTrainingInformationButton.setEffect(BloomOFF);

    }

    @FXML
    void ShowCertificateRequests(ActionEvent event) throws IOException {
    	MainLoader.showCertificate();
    	
    	TrainingRequests.setEffect(BloomOFF);
    	AnnulationsButton.setEffect(BloomOFF);
    	ShowCertificateRequestsButton.setEffect(BloomON);
    	ShowTrainingInformationButton.setEffect(BloomOFF);
    }

    @FXML
    void ShowTrainingInformation(ActionEvent event) throws IOException {
    	MainLoader.ShowTrainingOverview();
    	
    	TrainingRequests.setEffect(BloomOFF);
    	AnnulationsButton.setEffect(BloomOFF);
    	ShowCertificateRequestsButton.setEffect(BloomOFF);
    	ShowTrainingInformationButton.setEffect(BloomON);
    }

}
