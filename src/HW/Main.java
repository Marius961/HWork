package HW;

import java.io.IOException;

import HW.controllers.dialogWindowController;
import HW.controllers.homeworkViewController;
import HW.models.Subject1;
import HW.models.ViewsContainer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {

	private ViewsContainer vContainer = new ViewsContainer();

	@Override
	public void start(Stage primaryStage) {
		vContainer.setPrimaryStage(primaryStage);
		vContainer.getPrimaryStage().setTitle("HW");
		initRootLayout();
		showHWOverview();
		
		
	}

	public void initRootLayout() {
		vContainer.initRootLayout();
	}

	public void showHWEditDialog(Subject1 subject) throws IOException {
		vContainer.showHWEditDialog(subject);
	}

	public void showHWOverview() {
		vContainer.showHWOverview();
	}

	public void showHomeworkView(Subject1 subject) throws IOException {
		vContainer.showHomeworkView(subject);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
