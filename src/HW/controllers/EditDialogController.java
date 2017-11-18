package HW.controllers;

import javafx.scene.layout.AnchorPane;
import javafx.scene.control.TextField;
import HW.Main;
import HW.models.Properties;
import HW.models.InputValidator;
import HW.models.PropertiesContainer;
import HW.models.Subject;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class EditDialogController implements Properties{
	
	private Stage dialogStage;
	private Subject subject;
	private boolean okClicked = false;
	private PropertiesContainer properties;
	private Main main = new Main();
	
	private ObservableList<Integer> idList1;
	private ObservableList<Integer> idList2;
	
	private int beforeId;
	private int beforeWeek;
	
		
	@FXML
	private TextField subjectField;		
	@FXML
	private TextField lectureField;
	@FXML
	private TextField idField;
	@FXML
	private TextField weekNumField;
	@FXML
	AnchorPane pane;
	private final InputValidator validator = new InputValidator();
	
	@FXML
	private void initialize() {
		this.properties = main.getProperties();
	}
	
	@FXML
	private void handleOk() {
		if (setSubject()) {
			okClicked = true;
			dialogStage.close();
		}
	}
	
	private boolean setSubject() {
		if (validator.isInputValid(
				dialogStage, 
				idList1, 
				idList2, 
				subjectField, 
				lectureField, 
				weekNumField, 
				idField, 
				beforeId, 
				isOnposition())) {			
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
	
	private boolean isOnposition() {
		int id = Integer.parseInt(idField.getText());
		int weekNum = Integer.parseInt(weekNumField.getText());		
		if (beforeId == id && beforeWeek == weekNum) {
			System.out.println("on position");
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

	public void setFields(Subject subject) {
		this.subject = subject;
		beforeId = this.subject.getId();
		beforeWeek = this.subject.getWeekNum();
		subjectField.setText(this.subject.getName());
		lectureField.setText(this.subject.getLect());
		idField.setText(Integer.toString(this.subject.getId()));
		weekNumField.setText(Integer.toString(this.subject.getWeekNum()));
		
	}
	
	@Override
	public void setProperties(PropertiesContainer properties) {
		if (this.properties != properties) {
			this.properties = properties;
			applyProperties();
		}		
	}
	
	public void setIdList(ObservableList<Integer> idList1, ObservableList<Integer> idList2) {
		this.idList1 = idList1;
		this.idList2 = idList2;
	}
	
	@Override
	public void applyProperties() {
		setTheme();
	}
	
	private void setTheme() {
		pane.getStylesheets().clear();
		pane.getStylesheets().add(getClass().getResource(properties.getTheme().getUrl()).toExternalForm());		
	}
	
	public boolean isOkClicked() {
		return okClicked;
	}
	
}
