package HW;
	
import java.io.IOException;

import javax.security.auth.Subject;

import HW.controllers.MainViewController;
import HW.controllers.dialogWindowController;
import HW.models.Subject1;
import HW.models.Week;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Parent;
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
	
	public static void main(String[] args) {
		launch(args);
		
		
		
//      Провірочний код
		
//		Week Week1 = new Week();
//		Week Week2 = new Week();
		
//		Week1.getDay(0).add("Test subject 0", "Lect 0");
//		Week1.getDay(1).add("Test subject 1", "Lect 1");
//		Week1.getDay(2).add("Test subject 2", "Lect 2");
//		Week1.getDay(3).add("Test subject 3", "Lect 3");
//		Week1.getDay(4).add("Test subject 4", "Lect 4");	
//		System.out.println(Week1.print());
	}
}
