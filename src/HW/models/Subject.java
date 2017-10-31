package HW.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Subject {
	
	private String name;
	private String lect;
	private String homework;
	private ObservableList<Task> taskList = FXCollections.observableArrayList();
	
	public Subject() {
		
	}
	
	public Subject(String name, String lect) {
		this.name = name;
		this.lect = lect;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLect() {
		return lect;
	}

	public void setLect(String lect) {
		this.lect = lect;
	}

	public String getHomework() {
		return homework;
	}

	public void setHomework(String homework) {
		this.homework = homework;
	}	
	
	public void add(String task) {
		taskList.add(new Task(task));
	}
	public void remove(int ind) {
		taskList.remove(ind);
	}

	public ObservableList<Task> getTaskList() {
		return taskList;
	}

	public void setTaskList(ObservableList<Task> taskList) {
		this.taskList = taskList;
	}


	
	
}
