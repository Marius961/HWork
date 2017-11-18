package HW.models;

public class PropertiesContainer {
	private Theme theme = new Theme();
	private boolean twoWeeksShedule = true;
	private int weeks = 2;
	private boolean displayTimePickers = true;	
	private int currentWeekNum;
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

	public int getCurrentWeekNum() {
		return currentWeekNum;
	}

	public void setCurrentWeekNum(int currentWeekNum) {
		this.currentWeekNum = currentWeekNum;
	}





	

	
}
