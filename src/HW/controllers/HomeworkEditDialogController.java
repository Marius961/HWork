package HW.controllers;

import HW.lang.Language;
import HW.models.PropertiesContainer;
import HW.models.Subject;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class HomeworkEditDialogController {
	
	private Stage dialogStage;
	
	private PropertiesContainer properties;
	
	private Subject subject;
	
	private boolean saveClicked = false;
	
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
	
/*	private void setLanguage(Language lang) {
		homeworkLabel.setText(lang.getHomeworkEditDialog().getHomeworkLabel());
		cancelButton.setText(lang.getHomeworkEditDialog().getCancelButton());
		saveButton.setText(lang.getHomeworkEditDialog().getSaveButton());
		cleanButton.setText(lang.getHomeworkEditDialog().getCleanButton());
	} */
	
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
	
	public void setProperties(PropertiesContainer properties) {
		if (this.properties != properties) {
			this.properties = properties;			
		}	
		applyProperties();
	}
	
	public void applyProperties() {
//		setLanguage(properties.getLanguage());
	}
}
