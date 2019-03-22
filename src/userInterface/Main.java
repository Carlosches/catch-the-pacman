package userInterface;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application {


	@Override
	public void start(Stage stage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Pac-Man.FXML"));
		Parent root = loader.load();
		
		PacManController pCon = loader.getController();
		pCon.setWindow(stage);
		
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent arg0) {
				try {
					pCon.onCloseRequest();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			
		});
		
		Scene scene = new Scene(root);
		stage.setTitle("Catch The Pac-Man");
		stage.setScene(scene);
		stage.setFullScreen(true);
		stage.show();
	}

	
	public static void main(String[] args) {
		launch(args);

	}
}
