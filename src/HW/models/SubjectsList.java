package HW.models;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SubjectsList {
	
	private ObservableList<Subject> subjects = FXCollections.observableArrayList();
	
	public ObservableList<Subject> get() {
		return subjects;
	}
	
	public void add(int id, int weekNum,String name, String lect) {
		subjects.add(new Subject(id, weekNum, name , lect));
	}

	public void add(Subject subject) {
		subjects.add(subject);
	}
	
	public void remove(int ind) {
		subjects.remove(ind);
	}
	
	public void remove(Subject subject) {
		subjects.remove(subject);
	}
	
	public int getSize() {
		return subjects.size();
	}
	
	public Subject get(int ind) {
		return subjects.get(ind);
	}	
	
	public void set(List<Subject> list) {
		this.subjects = FXCollections.observableArrayList(list);
	}
}
