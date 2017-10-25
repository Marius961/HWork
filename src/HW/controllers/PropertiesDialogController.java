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
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
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
	
	@FXML
	Label generalLabel;
	@FXML
	Label languageLabel;
	@FXML
	Label appearanceLabel;
	@FXML
	Label themeLabel;
	@FXML
	Label weeksLabel;
	@FXML
	Button importButton;
	@FXML
	Button exportButton;
	@FXML
	Label ieLabel;
	@FXML
	Button saveButton;
	@FXML
	Button cancelButton;
	@FXML
	Button defaultButton;
	
	ViewContainer vContainer= new ViewContainer();
	private Stage dialogStage;
	private boolean saveClicked = false;
	PropertiesContainer properties = new PropertiesContainer();
	ObservableList<String> themes = FXCollections.observableArrayList("Classic", "Dark");
	ObservableList<String> weeks = FXCollections.observableArrayList("1" , "2");
	ObservableList<String> languages = FXCollections.observableArrayList();
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
	
	
	public boolean isSaveClicked() {
		return saveClicked;
	}
	
	public void applyProperties(PropertiesContainer properties) {		
		if (this.properties != properties) {
			this.properties = properties;
			setLanguage(this.properties.getLanguage());
			cBLanguages.getSelectionModel().select(this.properties.getLanguage().getLangId());
		}
	}
	private void saveProperties() {
		setLanguage();
//		properties.setDisplayTimePickers(displayTimePickers.isSelected());
	}
	
	private void setLanguage() {
		int ind = cBLanguages.getSelectionModel().getSelectedIndex();
		LanguageList langList = new LanguageList();
		Language English = langList.getLanguage(0);
		Language Ukrainian = langList.getLanguage(1);
		if (ind == 0 && properties.getLanguage() != English) {
			English.setLangId(0);
			properties.setLanguage(English);
		}
		if (ind == 1 && properties.getLanguage() != Ukrainian) {
			Ukrainian.setLangId(1);
			properties.setLanguage(Ukrainian);
		}
	}
	
	private void setLanguage(Language lang) {
		languages.add(lang.getPropertiesDialog().getLanguage1());
		languages.add(lang.getPropertiesDialog().getLanguage2());
		generalLabel.setText(lang.getPropertiesDialog().getGeneral());
		languageLabel.setText(lang.getPropertiesDialog().getLanguageLabel());
		appearanceLabel.setText(lang.getPropertiesDialog().getAppearanceLabel());
		themeLabel.setText(lang.getPropertiesDialog().getThemeLabel());
		weeksLabel.setText(lang.getPropertiesDialog().getWeeksLabel());
		importButton.setText(lang.getPropertiesDialog().getImportButton());
		exportButton.setText(lang.getPropertiesDialog().getExportButton());
		ieLabel.setText(lang.getPropertiesDialog().getIeLabel());
		saveButton.setText(lang.getPropertiesDialog().getSaveButton());
		defaultButton.setText(lang.getPropertiesDialog().getDefaultButton());
		cancelButton.setText(lang.getPropertiesDialog().getCancelButton());
		displayTimePickers.setText(lang.getPropertiesDialog().getDisplayTimePickers());
	}
	
	
	

	

}
