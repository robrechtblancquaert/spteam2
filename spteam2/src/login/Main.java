package login;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage logScreen) {
		try {
			Parent root  = FXMLLoader.load(getClass().getResource("/login/Login.fxml"));
			Scene scn = new Scene(root);
			scn.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			logScreen.setScene(scn);
			logScreen.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
