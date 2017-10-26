package HW.lang;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MainViewLang {
	
//  BUTTONS
	private String addButton;
	private String editButton;
	private String deleteButton;
	
//	RADIOBUTTONS
	private String firstWeek;
	private String secondWeek;
	
//	COLUMNS	
	private String colLecture;
	private String colSubject;
	
//	LABELS	
	private String dayName;	
	private String firstLabelTime;
	private String secondLabelTime;
	private String thirdLabelTime;
	private String fourthLabelTime;
	private String fifthLabelTime;
	
	private ObservableList<String> days = FXCollections.observableArrayList();
	
	public void dayAdd(String day0, String day1 ,String day2 , String day3, String day4) {
		days.addAll(day0, day1, day2, day3, day4);
	}
	public String getDay(int ind) {
		return days.get(ind);
	}
	public String getAddButton() {
		return addButton;
	}
	public void setAddButton(String addButton) {
		this.addButton = addButton;
	}
	public String getEditButton() {
		return editButton;
	}
	public void setEditButton(String editButton) {
		this.editButton = editButton;
	}
	public String getDeleteButton() {
		return deleteButton;
	}
	public void setDeleteButton(String deleteButton) {
		this.deleteButton = deleteButton;
	}

	public String getFirstWeek() {
		return firstWeek;
	}
	public void setFirstWeek(String firstWeek) {
		this.firstWeek = firstWeek;
	}
	public String getSecondWeek() {
		return secondWeek;
	}
	public void setSecondWeek(String secondWeek) {
		this.secondWeek = secondWeek;
	}
	public String getColLecture() {
		return colLecture;
	}
	public void setColLecture(String colLecture) {
		this.colLecture = colLecture;
	}
	public String getColSubject() {
		return colSubject;
	}
	public void setColSubject(String colSubject) {
		this.colSubject = colSubject;
	}
	public String getDayName() {
		return dayName;
	}
	public void setDayName(String dayName) {
		this.dayName = dayName;
	}
	public String getFirstLabelTime() {
		return firstLabelTime;
	}
	public void setFirstLabelTime(String firstLabelTime) {
		this.firstLabelTime = firstLabelTime;
	}
	public String getSecondLabelTime() {
		return secondLabelTime;
	}
	public void setSecondLabelTime(String secondLabelTime) {
		this.secondLabelTime = secondLabelTime;
	}
	public String getThirdLabelTime() {
		return thirdLabelTime;
	}
	public void setThirdLabelTime(String thirdLabelTime) {
		this.thirdLabelTime = thirdLabelTime;
	}
	public String getFourthLabelTime() {
		return fourthLabelTime;
	}
	public void setFourthLabelTime(String fourthLabelTime) {
		this.fourthLabelTime = fourthLabelTime;
	}
	public String getFifthLabelTime() {
		return fifthLabelTime;
	}
	public void setFifthLabelTime(String fifthLabelTime) {
		this.fifthLabelTime = fifthLabelTime;
	}
	

	
	
}
