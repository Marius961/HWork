package HW.controllers;


import HW.Main;
import HW.lang.Language;
import HW.lang.LanguageList;
import HW.models.PropertiesContainer;
import HW.models.Subject;
import HW.models.ViewContainer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
	
	ViewContainer vContainer= new ViewContainer();
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
		cBLanguages.getSelectionModel().select(container.getLanguage().getName());
	}
	
	public boolean isSaveClicked() {
		return saveClicked;
	}
	
	
	private void saveProperties() {
		setLanguage();
		container.setDisplayTimePickers(displayTimePickers.isSelected());
	}
	
	private void setLanguage() {
		int ind = cBLanguages.getSelectionModel().getSelectedIndex();
		LanguageList langList = new LanguageList();
		Language English = langList.getLanguage(0);
		Language Ukrainian = langList.getLanguage(1);
		if (ind == 0 && container.getLanguage() != English) {
			container.setLanguage(English);
		}
		if (ind == 1 && container.getLanguage() != Ukrainian) {
			container.setLanguage(Ukrainian);
		}
	}
	
	

	

}
