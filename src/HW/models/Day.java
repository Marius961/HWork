package HW.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Day {
	public Day(String name) {
		this.name = name;
	}
	
	private SubjectsList subjects = new SubjectsList();
	private String name;

	public void addSubject(int id, int weekNum, String name, String lect) {
		subjects.add(id, weekNum, name, lect);
	}
	
	public void addSubject(Subject subject) {
		subjects.add(subject);
	}

	public ObservableList<Subject> getSubjects() {
		return subjects.get();
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
	
	public ObservableList<Subject> getList(int weekNum) {
		ObservableList<Subject> tempList = FXCollections.observableArrayList();
		for (Subject temp : subjects.get()) {
			if(temp.getWeekNum() == weekNum || temp.getWeekNum() == 0) {
				tempList.add(temp);
				System.out.println("added" + temp.getName());
			} 
		}
		return tempList;
	}

			
}
