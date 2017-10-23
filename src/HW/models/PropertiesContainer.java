package HW.models;



public class PropertiesContainer {
	
	String language = "English";
	String Theme = "";
	
	int weeks = 2;
	boolean displayTimePickers = true;
	
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
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
	
	
}
