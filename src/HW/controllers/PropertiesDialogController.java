package HW.controllers;


import HW.Main;
import HW.models.Properties;
import HW.models.PropertiesContainer;
import HW.models.ThemeList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class PropertiesDialogController implements Properties{
	
	private Stage dialogStage;
	
	private boolean saveClicked = false;
	
	private PropertiesContainer properties;
	
	private ObservableList<String> themes = FXCollections.observableArrayList("Classic","Dark");
	private ObservableList<String> languages = FXCollections.observableArrayList();
	private ThemeList themeList = new ThemeList();
	@FXML
	private Button saveButton1;
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
	AnchorPane pane;
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
	
	public void applyProperties() {
		applyTheme();
		displayTimePickers.setSelected(properties.isDisplayTimePickers());
		twoWeeksShedule.setSelected(this.properties.isTwoWeeksShedule());
		cBThemes.getSelectionModel().select(this.properties.getTheme().getThemeId());
	}
	
	private void saveProperties() {
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
	
	private void applyTheme() {
		pane.getStylesheets().clear();
		pane.getStylesheets().add(getClass().getResource(properties.getTheme().getUrl()).toExternalForm());		
	}

	

}
