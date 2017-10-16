package HW.models;

import javafx.collections.ObservableList;

public class Day {
	
	private String name;
	
	private SubjectsList subjects = new SubjectsList();
	
	public Day(String name) {
		this.name = name;
	}

	public void addSubject(String name, String lect) {
		subjects.add(name, lect);
	}
	
	public void addSubject(Subject subject) {
		subjects.add(subject);
	}

	public ObservableList<Subject> getSubjects() {
		return subjects.getSubjects();
	}
	
	public Subject getSubject(int ind) {
		return subjects.get(ind);
	}	
	
	public void removeSubject(int ind) {
		subjects.remove(ind);
	}
	
	public int getSize() {
		return subjects.getSize();
	}
	
	public String getName() {
		return name;
	}
			
	
}
