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
	
	public void remove(Subject subject) {
		subjects.remove(subject);
	}
	
	public int getSize() {
		return subjects.getSize();
	}

	public String getName() {
		return name;
	}
	
	public ObservableList<Integer> getIdList() {
		ObservableList<Integer> tempList = FXCollections.observableArrayList();
		for (Subject temp : subjects.get()) {
			tempList.add(temp.getId());
		}
		return tempList;
	}
	
	public boolean contains(int id) {
		for(Subject temp : subjects.get()) {
			if(temp.getId() == id) {
				return true;
			}
		}
		return false;
	}
	
	public int getFreeId() {
		for(int i = 1;i<subjects.getSize()+2; i++) {
			if(contains(i) == false) {
				return i;
			}
		}
		return 20;
	}
	


			
}
