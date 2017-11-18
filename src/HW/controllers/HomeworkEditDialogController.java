package HW.controllers;

import HW.models.Properties;
import HW.models.PropertiesContainer;
import HW.models.Subject;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HomeworkEditDialogController implements Properties{
	
	private Stage dialogStage;
	
	private PropertiesContainer properties;
	
	private Subject subject;
	
	private boolean saveClicked = false;
	@FXML
	AnchorPane pane;
	@FXML
	private Button saveButton;
	@FXML
	private Button cancelButton;
	@FXML
	private Button cleanButton;
	
	@FXML
	private TextArea homeworkField;	
	@FXML
	private Label homeworkLabel;
			
	@FXML
	private void initialize() {
		homeworkField.setWrapText(true);
	}
	
	@FXML
	private void handleSave() {
		subject.setHomework(homeworkField.getText());
		saveClicked = true;
		dialogStage.close();
	}
	
	@FXML
	private void handleCancel() {
		dialogStage.close();
	}
	
	@FXML
	private void handleClean() {
		homeworkField.setText("");
	}
	
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	
	public void setSubject(Subject subject) {
		this.subject = subject;
		homeworkField.setText(subject.getHomework());
	}

	public boolean isSaveClicked() {
		return saveClicked;
	}
	
	@Override
	public void setProperties(PropertiesContainer properties) {
		if (this.properties != properties) {
			this.properties = properties;			
		}	
		applyProperties();
	}
	
	@Override
	public void applyProperties() {
		setTheme();		
	}
	
	private void setTheme() {
		pane.getStylesheets().clear();
		pane.getStylesheets().add(getClass().getResource(properties.getTheme().getUrl()).toExternalForm());		
	}
}
