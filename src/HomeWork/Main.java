package HomeWork;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
 
public class Main extends Application {
 
    @Override
    public void start(Stage primaryStage1) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/views/mainWindow.fxml"));
        primaryStage1.setTitle("HomeWork");
        primaryStage1.setScene(new Scene(root, primaryStage1.getWidth(), primaryStage1.getHeight()));
        primaryStage1.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}
