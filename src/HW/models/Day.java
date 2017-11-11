package HW.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Day extends SubjectsList{
	
	public Day(String name) {
		this.name = name;
	}
	private String name;	

	public String getName() {
		return name;
	}
	
	public ObservableList<Integer> getIdList() {
		ObservableList<Integer> tempList = FXCollections.observableArrayList();
		for (Subject temp : get()) {
			tempList.add(temp.getId());
		}
		return tempList;
	}
	
	public boolean contains(int id) {
		for(Subject temp : get()) {
			if(temp.getId() == id) {
				return true;
			}
		}
		return false;
	}
	
	public int getFreeId() {
		for(int i = 1;i<getSize()+2; i++) {
			if(contains(i) == false) {
				return i;
			}
		}
		return 20;
	}
	


			
}
