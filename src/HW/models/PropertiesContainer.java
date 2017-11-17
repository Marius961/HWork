package HW.models;

import java.io.IOException;

import javax.swing.text.StyleConstants;
import javax.swing.text.html.CSS;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.sun.javafx.css.Style;
import com.sun.javafx.css.StyleClassSet;
import com.sun.javafx.css.Stylesheet;

import HW.lang.Language;
import HW.lang.LanguageList;
import javafx.collections.FXCollections;

public class PropertiesContainer {
	private Theme theme = new Theme();
	private boolean twoWeeksShedule = true;
	private int weeks = 2;
	private boolean displayTimePickers = true;	
	
	public PropertiesContainer() {
	}
	
	public PropertiesContainer(PropertiesContainer container) {
		this.theme = container.theme;
		this.twoWeeksShedule = container.twoWeeksShedule;
		this.weeks = container.weeks;
		this.displayTimePickers = container.displayTimePickers;
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

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}



	

	
}
