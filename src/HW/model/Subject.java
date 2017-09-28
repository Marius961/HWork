package HW.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Subject {

	private final StringProperty subjectName;
	private final StringProperty lectorer;
	private final StringProperty homeWork;

	public Subject() {
		this(null, null);
	}

	public Subject(String subjectName, String lectorer) {
		this.subjectName = new SimpleStringProperty(subjectName);
		this.lectorer = new SimpleStringProperty(lectorer);
		this.homeWork = new SimpleStringProperty("Тест");
	}

	public String getSubjectName() {
		return subjectName.get();
	}

	public void setSubjectName(String subjectName) {
		this.subjectName.set(subjectName);
	}

	public StringProperty subjectNameProperty() {
		return subjectName;
	}

	public String getLectorer() {
		return lectorer.get();
	}

	public void setLectorer(String lectorer) {
		this.lectorer.set(lectorer);
	}

	public StringProperty lectorerProperty() {
		return lectorer;
	}

	public String getHomeWork() {
		return homeWork.get();
	}

	public void setHomeWork(String homeWork) {
		this.homeWork.set(homeWork);
	}

	public StringProperty homeWorkProperty() {
		return homeWork;
	}

}