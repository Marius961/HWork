package HW;

import java.io.IOException;

import HW.models.PropertiesContainer;
import HW.models.Subject;
import HW.models.ViewContainer;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	private ViewContainer viewContainer = new ViewContainer();

	@Override
	public void start(Stage primaryStage) {
		viewContainer.setPrimaryStage(primaryStage);
		viewContainer.getPrimaryStage().setTitle("HW");
		initRootLayout();
		initMainView();	
	}

	public void initRootLayout() {
		viewContainer.initRootLayout();
	}

	public boolean initEditDialog(Subject subject) throws IOException {
		return viewContainer.initEditDialog(subject);
	}

	public void initMainView() {
		viewContainer.initMainView();
	}

	public boolean initHomeworkEditDialog(Subject subject) throws IOException {
		return viewContainer.initHomeworkEditDialog(subject);
	}
	
	public boolean initPropertiesDialog() throws IOException {
		return viewContainer.initPropertiesDialog();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public PropertiesContainer getProperties() {
		return viewContainer.getProperties();
	}
	
	public void setProperties(PropertiesContainer properties) {
		viewContainer.setPrimaryStage(properties);
	}
}
