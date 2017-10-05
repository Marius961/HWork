package HW.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SubjectsList {
	private ObservableList<Subject1> subjects = FXCollections.observableArrayList();
	
	public ObservableList<Subject1> getSubjects() {
		return subjects;
	}

	public void addSubject(String name, String lect) {
		Subject1 temp = new Subject1(name , lect);
		subjects.add(temp);
	}

	public void addSubject(Subject1 subject) {
		subjects.add(subject);
	}
	
	public void removeSubject(int ind) {
		subjects.remove(ind);
	}
	
	public int getSize() {
		return subjects.size();
	}
	
	public Subject1 getSubject(int ind) {
		return subjects.get(ind);
	}
	
}
