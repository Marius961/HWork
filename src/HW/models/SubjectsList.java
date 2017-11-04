package HW.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SubjectsList {
	
	private ObservableList<Subject> subjects = FXCollections.observableArrayList();
	
	public ObservableList<Subject> get() {
		return subjects;
	}
	
	public void add(int id, int weekNum,String name, String lect) {
		Subject temp = new Subject(id, weekNum, name , lect);
		subjects.add(temp);
	}

	public void add(Subject subject) {
		subjects.add(subject);
	}
	
	public void remove(int ind) {
		subjects.remove(ind);
	}
	
	public int getSize() {
		return subjects.size();
	}
	
	public Subject get(int ind) {
		return subjects.get(ind);
	}	
}
