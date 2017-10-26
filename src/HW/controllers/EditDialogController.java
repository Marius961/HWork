package HW.controllers;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import HW.Main;
import HW.lang.Language;
import HW.models.PropertiesContainer;
import HW.models.Subject;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class EditDialogController {
	
	@FXML
	Button okButton;
	
	@FXML
	Button cancelButton;
	
	@FXML
	Label subjectLabel;
	
	@FXML
	Label lectureLabel;
	
	
	@FXML
	private TextField subjectField;		
	@FXML
	private TextField lectureField;
	
	private Stage dialogStage;
	
	private Subject subject;
	
	private boolean okClicked = false;
	
	PropertiesContainer properties;
	Main main = new Main();
	
	@FXML
	private void initialize() {
		this.properties = main.getProperties();
		setLanguage(properties.getLanguage());
	}
	
	@FXML
	private void handleOk() {
		if (isInputValid()) {
			subject.setName(subjectField.getText());
			subject.setLect(lectureField.getText());
			okClicked = true;
			dialogStage.close();
		}
	}
	
	@FXML
	private void handleCancel() {
		dialogStage.close();
	}
	
	private boolean isInputValid() {
		String errorMessage = "";

		if (subjectField.getText() == null || subjectField.getText().length() == 0) {
			errorMessage += "No valid Subject!\n";
		}
		if (lectureField.getText() == null || lectureField.getText().length() == 0) {
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
	
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
		subjectField.setText(subject.getName());
		lectureField.setText(subject.getLect());
	}
	public void setProperties(PropertiesContainer properties) {
		if (this.properties != properties) {
			this.properties = properties;
			applyProperties();
		}
		
	}
	
	public void applyProperties() {
		setLanguage(properties.getLanguage());
	}
	
	public boolean isOkClicked() {
		return okClicked;
	}
	
	private void setLanguage(Language lang) {
			System.out.println(lang.getEditDialog().getLectureLabel());
			cancelButton.setText(lang.getEditDialog().getCancelButton());
			lectureLabel.setText(lang.getEditDialog().getLectureLabel());
			okButton.setText(lang.getEditDialog().getOkButton());
			subjectLabel.setText(lang.getEditDialog().getSubjectLabel());
	}
}
