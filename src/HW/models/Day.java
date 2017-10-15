package HW.models;

import javafx.collections.ObservableList;

public class Day {
	
	private String name;
	
	private SubjectsList subjects = new SubjectsList();
	
	public Day (String name) {
		this.name = name;
	}

	public void add(String name, String lect) {
		subjects.addSubject(name, lect);
	}
	
	public void add(Subject1 subject) {
		subjects.addSubject(subject);
	}

	public ObservableList<Subject1> getSubjects() {
		return subjects.getSubjects();
	}
	
	public Subject1 getSubject(int ind) {
		return subjects.getSubject(ind);
	}	
	
	public void removeSubject(int ind) {
		subjects.removeSubject(ind);
	}
	
	public int getSize() {
		return subjects.getSize();
	}
	
	public String getName() {
		return name;
	}
			
	
}
