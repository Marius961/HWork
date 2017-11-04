package HW.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Week {
	
	private ObservableList<Day> week = FXCollections.observableArrayList();
	
	public Week() {		
		week.add(new Day("Mo"));
		week.add(new Day("Tu"));
		week.add(new Day("We"));
		week.add(new Day("Th"));
		week.add(new Day("Fr"));
	}	
	
	public Day selectDay(int ind) {
		return week.get(ind);
	}

}
