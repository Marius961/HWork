package HW.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SubjectsList {
	
	private ObservableList<Subject> subjects = FXCollections.observableArrayList();
	
	public ObservableList<Subject> getSubjects() {
		return subjects;
	}

	public void add(String name, String lect) {
		Subject temp = new Subject(name , lect);
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
