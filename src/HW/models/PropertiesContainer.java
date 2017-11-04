package HW.models;

import javax.swing.text.StyleConstants;
import javax.swing.text.html.CSS;

import com.sun.javafx.css.Style;
import com.sun.javafx.css.StyleClassSet;
import com.sun.javafx.css.Stylesheet;

import HW.lang.Language;
import HW.lang.LanguageList;
import javafx.collections.FXCollections;

public class PropertiesContainer {
//	private LanguageList langList = new LanguageList();
	
//	private Language lang = langList.getLanguage("English");
	private boolean twoWeeksShedule = true;

	private int weeks = 2;
	private ThemeList themeList = new ThemeList();
	private Theme theme = themeList.get(0);
	private boolean displayTimePickers = true;
	
/*	public Language getLanguage() {
		return lang;
	} 
	
	public void setLanguage(Language lang) {
		this.lang = lang;
	} 
*/

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

	public ThemeList getThemeList() {
		return themeList;
	}

	public void setThemeList(ThemeList themeList) {
		this.themeList = themeList;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(int ind) {
		this.theme = themeList.get(ind);
	}

	

	
}
