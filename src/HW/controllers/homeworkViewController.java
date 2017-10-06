package HW.controllers;


import HW.models.Subject1;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class homeworkViewController {
	
	@FXML
	private TextArea homeworkField;	
		
	private Stage dialogStage;
	private Subject1 subject;
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
	public void handleClean() {
		homeworkField.setText("");
	}
	
	@FXML
	private void handleCancel() {
		dialogStage.close();
	}
	
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public void setSubject(Subject1 subject) {
		this.subject = subject;
		homeworkField.setText(subject.getHomework());
	}

	public boolean isSaveClicked() {
		return saveClicked;
	}
}
