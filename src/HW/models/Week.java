package HW.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Week {
	
	private ObservableList<Day> week = FXCollections.observableArrayList();
	private Day Monday = new Day("Monday");
	private Day Tuesday = new Day("Tuesday");
	private Day Wednesday = new Day("Wednesday");
	private Day Thursday = new Day("Thursday");
	private Day Friday = new Day("Friday");
	
	public Week() {
		week.add(Monday);
		week.add(Tuesday);
		week.add(Wednesday);
		week.add(Thursday);
		week.add(Friday);
	}
	public String getHomework(int day,int subject) {
		return getDay(day).getSubject(subject).getHomework();
	}
	
	public void setHomework(int day, int subject, String homework) {
		getDay(day).getSubject(subject).setHomework(homework);
	}
	
	public Day getDay(int ind) {
		return week.get(ind);
	}

}
