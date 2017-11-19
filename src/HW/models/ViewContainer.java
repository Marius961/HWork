package HW.models;

import java.io.IOException;

import HW.Main;
import HW.controllers.EditDialogController;
import HW.controllers.HomeworkEditDialogController;
import HW.controllers.MainViewController;
import HW.controllers.PropertiesDialogController;
import HW.models.Subject;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

public class ViewContainer {
	private Stage primaryStage; 	
	private BorderPane rootLayout;
	private PropertiesContainer properties = Converter.propertiesToJavaObject();
	public void initRootLayout() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("views/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();
			Scene scene = new Scene(rootLayout);
			
/*	
		    private double xOffset = 0;
		    private double yOffset = 0;
			primaryStage.initStyle(StageStyle.UNDECORATED);
			rootLayout.setOnMouseClicked(new EventHandler<MouseEvent>() {
	            @Override
	            public void handle(MouseEvent event) {
	                xOffset = primaryStage.getX() - event.getScreenX();
	                yOffset = primaryStage.getY() - event.getScreenY();
	            }
	        });
			rootLayout.setOnMouseDragged(new EventHandler<MouseEvent>() {
	            @Override
	            public void handle(MouseEvent event) {
	                primaryStage.setX(event.getScreenX() + xOffset);
	                primaryStage.setY(event.getScreenY() + yOffset);
	            }
	        });
*/      	primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean initEditDialog(Subject subject, ObservableList<Integer> idList1, ObservableList<Integer> idList2) throws IOException {
		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("views/EditDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Add Subject");
			dialogStage.initModality(Modality.APPLICATION_MODAL);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);
			
			EditDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setProperties(properties);
			controller.setFields(subject);
			controller.setIdList(idList1,idList2);
			dialogStage.setResizable(false);
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
			AnchorPane mainView = (AnchorPane) loader.load();
			rootLayout.setCenter(mainView);
			MainViewController controller = loader.getController();
			controller.setProperties(properties);
			primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
		          public void handle(WindowEvent we) {
		              try {
		            	Converter.toJson(controller.getWeek());
		            	Converter.toJson(controller.getProperties());
					} catch (IOException e) {
						e.printStackTrace();
					}
		          }
		      }); 
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
			dialogStage.initModality(Modality.APPLICATION_MODAL);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			HomeworkEditDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setProperties(properties);
			controller.setSubject(subject);
			dialogStage.setResizable(false);
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
			dialogStage.initModality(Modality.APPLICATION_MODAL);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			PropertiesDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setProperties(properties);
			setProperties(properties);
			dialogStage.setResizable(false);
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

