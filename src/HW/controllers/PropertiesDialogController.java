package HW.controllers;


import HW.lang.Language;
import HW.lang.LanguageList;
import HW.models.PropertiesContainer;
import HW.models.ThemeList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class PropertiesDialogController {
	
	private Stage dialogStage;
	
	private boolean saveClicked = false;
	
	private PropertiesContainer properties = new PropertiesContainer();
	
	private ObservableList<String> themes = FXCollections.observableArrayList("Classic","Dark");
	private ObservableList<String> languages = FXCollections.observableArrayList();
	private ThemeList themeList = new ThemeList();
	@FXML
	private Button saveButton;
	@FXML
	private Button importButton;
	@FXML
	private Button exportButton;
	@FXML
	private Button cancelButton;
	@FXML
	private Button defaultButton;
	
	@FXML
	private Label ieLabel;
	@FXML
	private Label generalLabel;
	@FXML
	private Label languageLabel;
	@FXML
	private Label appearanceLabel;
	@FXML
	private Label themeLabel;
	
	@FXML
	private CheckBox displayTimePickers;	
	@FXML
	private CheckBox twoWeeksShedule;
	
	@FXML
	private ChoiceBox<String> cBLanguages;
	@FXML
	private ChoiceBox<String> cBThemes;
	
	@FXML
	private void initialize() {
		cBLanguages.setItems(languages);
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

/*	private void setLanguage() {
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
		themes.add(lang.getPropertiesDialog().getClassicTheme());
		themes.add(lang.getPropertiesDialog().getDarkTheme());
		generalLabel.setText(lang.getPropertiesDialog().getGeneral());
		languageLabel.setText(lang.getPropertiesDialog().getLanguageLabel());
		appearanceLabel.setText(lang.getPropertiesDialog().getAppearanceLabel());
		themeLabel.setText(lang.getPropertiesDialog().getThemeLabel());
		importButton.setText(lang.getPropertiesDialog().getImportButton());
		exportButton.setText(lang.getPropertiesDialog().getExportButton());
		ieLabel.setText(lang.getPropertiesDialog().getIeLabel());
		saveButton.setText(lang.getPropertiesDialog().getSaveButton());
		defaultButton.setText(lang.getPropertiesDialog().getDefaultButton());
		cancelButton.setText(lang.getPropertiesDialog().getCancelButton());
		displayTimePickers.setText(lang.getPropertiesDialog().getDisplayTimePickers());
	} */
	
	private void applyProperties() {
		displayTimePickers.setSelected(properties.isDisplayTimePickers());
		twoWeeksShedule.setSelected(this.properties.isTwoWeeksShedule());
//		setLanguage(this.properties.getLanguage());
//		cBLanguages.getSelectionModel().select(this.properties.getLanguage().getLangId());	
		cBThemes.getSelectionModel().select(this.properties.getTheme().getThemeId());
	}
	
	private void saveProperties() {
//		setLanguage();
		setDisplayTimePickers();
		setTwoWeeksShedule();	
		setTheme();
	}
	
	public void setDisplayTimePickers() {
		properties.setDisplayTimePickers(displayTimePickers.isSelected());
	}
	
	public void setTheme() {
		int ind = cBThemes.getSelectionModel().getSelectedIndex();
		if (ind == 0 && properties.getTheme() != themeList.get(0)) {
			properties.setTheme(themeList.get(0));
			System.out.println("Вибрана тема 1");
		}
		if (ind == 1 && properties.getTheme() != themeList.get(1)) {
			properties.setTheme(themeList.get(1));
			System.out.println("Вибрана тема 2");
		}
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	
	public boolean isSaveClicked() {
		return saveClicked;
	}
	
	public void setTwoWeeksShedule() {
		properties.setTwoWeeksShedule(twoWeeksShedule.isSelected());
	}
	
	public void setProperties(PropertiesContainer properties) {		
		if (this.properties != properties) {
			this.properties = properties;
			applyProperties();
		}
	}

	

}
