package HW.controllers;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import HW.Main;
import HW.lang.Language;
import HW.models.Day;
import HW.models.InputValidator;
import HW.models.PropertiesContainer;
import HW.models.Subject;
import HW.models.Week;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class EditDialogController {
	
	private Stage dialogStage;

	private Subject subject;

	private boolean okClicked = false;

	private PropertiesContainer properties;
	private Main main = new Main();
	private ObservableList<Integer> idList;
	private int beforeId;
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
	InputValidator validator = new InputValidator();
	
	@FXML
	private void initialize() {
		this.properties = main.getProperties();
	}
	
	@FXML
	private void handleOk() {
		if (setFields()) {
			okClicked = true;
			dialogStage.close();
		}
		

	}
	
	private boolean setFields() {
		if (validator.isInputValid(dialogStage, idList, subjectField, lectureField, weekNumField, idField, beforeId)) {
			int id = Integer.parseInt(idField.getText());
			int weekNum = Integer.parseInt(weekNumField.getText());						
			subject.setName(subjectField.getText());
			subject.setLect(lectureField.getText());
			subject.setId(id);
			subject.setWeeknum(weekNum);
			return true;
		} 
		return false;
	}
	@FXML
	private void handleCancel() {
		dialogStage.close();
	}
		
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
		beforeId = subject.getId();
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
	
	public void setIdList(ObservableList<Integer> idList) {
		this.idList = idList;
	}
	
	public void applyProperties() {
	}
	
	public boolean isOkClicked() {
		return okClicked;
	}
	
}
