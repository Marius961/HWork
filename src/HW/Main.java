package HW;

import java.io.IOException;

import HW.models.Subject1;
import HW.models.ViewsContainer;
import javafx.application.Application;
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

	public boolean showHWEditDialog(Subject1 subject) throws IOException {
		return vContainer.showHWEditDialog(subject);
	}

	public void showHWOverview() {
		vContainer.showHWOverview();
	}

	public boolean showHomeworkView(Subject1 subject) throws IOException {
		return vContainer.showHomeworkView(subject);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
