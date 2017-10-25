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
	
	@FXML
	private TextArea homeworkField;	
	@FXML
	Label homeworkLabel;
	@FXML
	Button saveButton;
	@FXML
	Button cancelButton;
	@FXML
	Button cleanButton;
		
	private Stage dialogStage;
	PropertiesContainer properties;
	private Subject subject;
	
	private boolean saveClicked = false;
	
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
	
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	
	@FXML
	public void handleClean() {
		homeworkField.setText("");
	}
	
	public void setSubject(Subject subject) {
		this.subject = subject;
		homeworkField.setText(subject.getHomework());
	}

	public boolean isSaveClicked() {
		return saveClicked;
	}
	
	public void applyProperties(PropertiesContainer properties) {
		if (this.properties != properties) {
			this.properties = properties;			
			setLanguage(this.properties.getLanguage());
		}		
	}
	
	private void setLanguage(Language lang) {
		homeworkLabel.setText(lang.getHomeworkEditDialog().getHomeworkLabel());
		cancelButton.setText(lang.getHomeworkEditDialog().getCancelButton());
		saveButton.setText(lang.getHomeworkEditDialog().getSaveButton());
		cleanButton.setText(lang.getHomeworkEditDialog().getCleanButton());
	}
}
