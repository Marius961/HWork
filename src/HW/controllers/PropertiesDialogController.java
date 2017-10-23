package HW.controllers;


import HW.models.PropertiesContainer;
import HW.models.Subject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PropertiesDialogController {
	
	@FXML
	CheckBox displayTimePickers;
	@FXML
	TextField tf;
	@FXML
	ChoiceBox<String> cBLanguages;
	@FXML
	ChoiceBox<String> cBWeeks;
	@FXML
	ChoiceBox<String> cBThemes;
	
	private Stage dialogStage;
	private boolean saveClicked = false;
	PropertiesContainer container = new PropertiesContainer();
	ObservableList<String> themes = FXCollections.observableArrayList("Classic", "Dark");
	ObservableList<String> weeks = FXCollections.observableArrayList("1" , "2");
	ObservableList<String> languages = FXCollections.observableArrayList("English", "Ukrainian");
	@FXML
	private void initialize() {
		cBLanguages.setItems(languages);
		cBWeeks.setItems(weeks);
		cBThemes.setItems(themes);
	}
	@FXML
	private void handleSave() {
		saveProperties();
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
	
	public void setProperties(PropertiesContainer container) {
		this.container = container;
	}
	
	public boolean isSaveClicked() {
		return saveClicked;
	}
	
	@FXML
	private void add1() {
		
	}
	
	private void saveProperties() {
		container.setDisplayTimePickers(displayTimePickers.isSelected());
		
	}
}
