package HW.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Week {
	
	private ObservableList<Day> week = FXCollections.observableArrayList();
	
	public Week() {		
		week.add(new Day("Monday"));
		week.add(new Day("Tuesday"));
		week.add(new Day("Wednesday"));
		week.add(new Day("Thursday"));
		week.add(new Day("Friday"));
		week.add(new Day("Friday"));
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
