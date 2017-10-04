package HW.controllers;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import HW.models.Subject1;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class dialogWindowController {
	
	@FXML
	private TextField subjField;	
	@FXML
	private TextField lectField;
	
	private Stage dialogStage;
	private Subject1 subject;
	private boolean okClicked = false;

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public void setSubject(Subject1 subject) {
		this.subject = subject;
		subjField.setText(subject.getName());
		lectField.setText(subject.getLect());
	}
	
	@FXML
	private void handleOk() {
		if (isInputValid()) {
			subject.setName(subjField.getText());
			subject.setLect(lectField.getText());
			okClicked = true;
			dialogStage.close();
		}
	}
	
	public boolean isOkClicked() {
		return okClicked;
	}
	@FXML
	private void handleCancel() {
		dialogStage.close();
	}

	private boolean isInputValid() {
		String errorMessage = "";

		if (subjField.getText() == null || subjField.getText().length() == 0) {
			errorMessage += "No valid Subject!\n";
		}
		if (lectField.getText() == null || lectField.getText().length() == 0) {
			errorMessage += "No valid Lecturer!\n";
		}
		if (errorMessage.length() == 0) {
			return true;
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(dialogStage);
			alert.setTitle("Invalid Fields");
			alert.setHeaderText("Please correct invalid fields");
			alert.setContentText(errorMessage);

			alert.showAndWait();

			return false;
		}

	}
}
