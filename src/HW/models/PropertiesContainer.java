package HW.models;

import HW.controllers.EditDialogController;
import HW.controllers.MainViewController;
import HW.lang.Language;
import HW.lang.LanguageList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.SelectionModel;

public class PropertiesContainer {
	private LanguageList langList = new LanguageList();
	
	private Language lang = langList.getLanguage("English");
	
	private String Theme = "";
	
	private boolean twoWeeksShedule = true;

	private int weeks = 2;
	
	private boolean displayTimePickers = true;
	
	public Language getLanguage() {
		return lang;
	}
	
	public void setLanguage(Language lang) {
		this.lang = lang;
	}
	
	public String getTheme() {
		return Theme;
	}
	
	public void setTheme(String theme) {
		Theme = theme;
	}

	public boolean isDisplayTimePickers() {
		return displayTimePickers;
	}
	
	public void setDisplayTimePickers(boolean displayTimePickers) {
		this.displayTimePickers = displayTimePickers;
	}
	
	public int getWeeks() {
		return weeks;
	}
	
	public void setWeeks(int weeks) {
		this.weeks = weeks;
	}

	public boolean isTwoWeeksShedule() {
		return twoWeeksShedule;
	}
	
	public void setTwoWeeksShedule(boolean twoWeeksShedule) {
		this.twoWeeksShedule = twoWeeksShedule;
	}
	
	
	
}
