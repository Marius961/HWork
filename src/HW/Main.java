package HW;
	
import java.io.IOException;

import HW.controllers.dialogWindowController;
import HW.controllers.homeworkViewController;
import HW.models.Subject1;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("HW");
		initRootLayout();
		showHWOverview();
	}

	public void initRootLayout() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("views/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	
	public boolean showHWEditDialog(Subject1 subject) throws IOException {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("views/inputDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			Stage dialogStage = new Stage();
			dialogStage.setTitle("Add Subject");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			dialogWindowController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setSubject(subject);
			dialogStage.showAndWait();
			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public void showHWOverview() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("views/MainView.fxml"));
			AnchorPane hwOverview = (AnchorPane) loader.load();
			rootLayout.setCenter(hwOverview);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean showHomeworkView(Subject1 subject) throws IOException {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("views/homeworkView.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			Stage dialogStage = new Stage();
			dialogStage.setTitle(subject.getName());
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			homeworkViewController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setSubject(subject);
			dialogStage.showAndWait();
			return controller.isSaveClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
