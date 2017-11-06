package HW.controllers;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import HW.Main;
import HW.lang.Language;
import HW.models.Day;
import HW.models.PropertiesContainer;
import HW.models.Subject;
import HW.models.Week;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class EditDialogController {
	
	private Stage dialogStage;

	private Subject subject;
	private Day day;

	private boolean okClicked = false;

	private PropertiesContainer properties;
	private Main main = new Main();
	
	@FXML
	private Button okButton;	
	@FXML
	private Button cancelButton;
	
	@FXML
	private Label subjectLabel;	
	@FXML
	private Label lectureLabel;
		
	@FXML
	private TextField subjectField;		
	@FXML
	private TextField lectureField;
	@FXML
	private TextField idField;
	@FXML
	private TextField weekNumField;

	@FXML
	private void initialize() {
		this.properties = main.getProperties();
//		setLanguage(properties.getLanguage());
	}
	
	
	
	@FXML
	private void handleOk() {
		if (isInputValid()) {
			setFields();
			okClicked = true;
			dialogStage.close();
		}
	}
	
	private void setFields() {

			int id = Integer.parseInt(idField.getText());
			int weekNum = Integer.parseInt(weekNumField.getText());						
			subject.setName(subjectField.getText());
			subject.setLect(lectureField.getText());
			subject.setId(id);
			subject.setWeeknum(weekNum);

	}
	@FXML
	private void handleCancel() {
		dialogStage.close();
	}
	
	private boolean isInputValid() {
		String errorMessage = "";
		int id = Integer.parseInt(idField.getText());
		int weekNum = Integer.parseInt(weekNumField.getText());
		if (subjectField.getText() == null || subjectField.getText().length() == 0) {
			errorMessage += "No valid Subject!\n";
		}
		if (lectureField.getText() == null || lectureField.getText().length() == 0) {
			errorMessage += "No valid Lecturer!\n";
		}
		if (weekNum > 2) {
			errorMessage += "No valid number of week!\n";
		}
		for (int tempid : day.getIdList()) {
			if (tempid == id) {
				errorMessage += "No valid id of subject! ID:" + id + "Alrady added!\n";				
			} 
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

	public void setDay(Day day, int subjId) {

		this.day = day;
		this.subject = this.day.getSubject(subjId);
		subjectField.setText(subject.getName());
		lectureField.setText(subject.getLect());
		idField.setText(Integer.toString(subject.getId()));
		weekNumField.setText(Integer.toString(subject.getWeekNum()));
		
	}
	
	public void setProperties(PropertiesContainer properties) {
		if (this.properties != properties) {
			this.properties = properties;
			applyProperties();
		}		
	}
	
	public void applyProperties() {
//		setLanguage(properties.getLanguage());
	}
	
	public boolean isOkClicked() {
		return okClicked;
	}
	
/*	private void setLanguage(Language lang) {
			System.out.println(lang.getEditDialog().getLectureLabel());
			cancelButton.setText(lang.getEditDialog().getCancelButton());
			lectureLabel.setText(lang.getEditDialog().getLectureLabel());
			okButton.setText(lang.getEditDialog().getOkButton());
			subjectLabel.setText(lang.getEditDialog().getSubjectLabel());
	} */
}
