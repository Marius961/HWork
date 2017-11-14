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
	
	public ObservableList<Integer> getIdList(int weekNum) {
		ObservableList<Integer> tempList = FXCollections.observableArrayList();
		for (Subject temp : get()) {
			if (temp.getWeekNum() == weekNum || temp.getWeekNum() == 0) {
				System.out.println(temp.getId());
				tempList.add(temp.getId());
			}
		}
		return tempList;
	}
	
	public boolean contains(int id, int weekNum) {
		for(Subject temp : get()) {
			if(temp.getId() == id && (temp.getWeekNum() == weekNum || temp.getWeekNum() == 0)) {
				return true;
			}
		}
		return false;
	}
	
	public int getFreeId(int weekNum) {
		for(int i = 1;i<getSize()+2; i++) {
			if(contains(i, weekNum) == false) {
				return i;
			}
		}
		return 0;
	}
	


			
}
