package HW.models;

import java.io.IOException;

import HW.Main;
import HW.controllers.EditDialogController;
import HW.controllers.HomeworkEditDialogController;
import HW.controllers.MainViewController;
import HW.controllers.PropertiesDialogController;
import HW.lang.Language;
import HW.models.Subject;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ViewContainer {
	private Stage primaryStage;
	
	private BorderPane rootLayout;
	
	private PropertiesContainer properties = new PropertiesContainer();
	
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
	
	public boolean initEditDialog(Subject subject) throws IOException {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("views/EditDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			Stage dialogStage = new Stage();
			dialogStage.setTitle("Add Subject");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			EditDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setProperties(properties);
			controller.setSubject(subject);
			dialogStage.showAndWait();
			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public void initMainView() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("views/MainView.fxml"));
			AnchorPane hwOverview = (AnchorPane) loader.load();
			rootLayout.setCenter(hwOverview);
			

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean initHomeworkEditDialog(Subject subject) throws IOException {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("views/HomeworkEditDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			Stage dialogStage = new Stage();
			dialogStage.setTitle(subject.getName());
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			HomeworkEditDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setProperties(properties);
			controller.setSubject(subject);
			dialogStage.showAndWait();
			return controller.isSaveClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean initPropertiesDialog() throws IOException {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("views/PropertiesDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			Stage dialogStage = new Stage();
			dialogStage.setTitle("Properties");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			PropertiesDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setProperties(properties);
			setProperties(properties);
			dialogStage.showAndWait();

			return controller.isSaveClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	} 

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	public BorderPane getRootLayout() {
		return rootLayout;
	}

	public void setRootLayout(BorderPane rootLayout) {
		this.rootLayout = rootLayout;
	}
	
	public void setProperties(PropertiesContainer properties) {		
		this.properties = properties;
	}
	
	public PropertiesContainer getProperties() {
		return properties;
	}
	
}

