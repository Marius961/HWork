package HW.models;

import java.util.Calendar;
import java.util.List;

import javax.xml.bind.annotation.XmlElementWrapper;

import javafx.collections.FXCollections;

import javafx.collections.ObservableList;

public class Week {
	private Calendar calendar = Calendar.getInstance();
	private ObservableList<Day> week = FXCollections.observableArrayList();
	
	public Week() {		
		week.add(new Day("Mo"));
		week.add(new Day("Tu"));
		week.add(new Day("We"));
		week.add(new Day("Th"));
		week.add(new Day("Fr"));
	}	
	
	public Week(Day d0,Day d1,Day d2,Day d3,Day d4) {
		week.add(d0);
		week.add(d1);
		week.add(d2);
		week.add(d3);
		week.add(d4);
	}
	
	public int getCurrentDay() {
		if ((calendar.get(Calendar.DAY_OF_WEEK) - 2) < 0 || (calendar.get(Calendar.DAY_OF_WEEK) - 2) > 4) {
			return 0;
		} else
			return (calendar.get(Calendar.DAY_OF_WEEK) - 2);
	}
	public void set(Week week) {
		this.week = week.get();
	}
	
	public Day selectDay(int ind) {
		return week.get(ind);
	}
	
	public ObservableList<Day> get() {
		return week;
	}
	

}
