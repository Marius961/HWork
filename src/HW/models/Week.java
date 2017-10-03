package HW.models;

import java.util.Iterator;
import java.util.Observable;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Week {
	
	private ObservableList<Day> week = FXCollections.observableArrayList();
	private Day Monday = new Day("Mo");
	private Day Tuesday = new Day("Tu");
	private Day Wednesday = new Day("We");
	private Day Thursday = new Day("Th");
	private Day Friday = new Day("Fr");
	
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
	
	
//   Провірочний метод
	
	public String print() {
		String result = "";
		for (int a = 0; a < 5; a++) {
			for (int i = 0; i<5; i++) {
				result += week.get(i).getName() + ":\n";
				for(int j = 0; j < week.get(i).getSize(); j++) {
					result += week.get(i).getSubject(j).getName() + "\n"; 
				}
			}
			return result;
		}
		return result;
	}
	
	
}
