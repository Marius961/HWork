package HW.controllers;

import HW.models.Subject;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class HomeworkEditDialogController {
	
	@FXML
	private TextArea homeworkField;	
		
	private Stage dialogStage;
	
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
}
