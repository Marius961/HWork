package HW.controllers;

import java.io.IOException;

import HW.Main;
import HW.models.Subject1;
import HW.models.Week;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainViewController {

	@FXML
	private TableView<Subject1> subjTable;

	@FXML
	private TableColumn<Subject1, Integer> colTime;

	@FXML
	private TableColumn<Subject1, String> colSubject;

	@FXML
	private TableColumn<Subject1, String> colLecture;
	
	private int dayCounter = 0;
	private Week week1 = new Week();
	
	Main main = new Main();

	@FXML
	private void initialize() {
		init();
		colSubject.setCellValueFactory(new PropertyValueFactory<Subject1, String>("name"));
		colLecture.setCellValueFactory(new PropertyValueFactory<Subject1, String>("lect"));
		subjTable.setItems(week1.getDay(0).getSubjects());
	}

	@FXML
	public void addButtonClickMethod() throws IOException {
		Subject1 tempSubject = new Subject1();
		boolean okClicked = main.showHWEditDialog(tempSubject);
		if (okClicked) {
			week1.getDay(dayCounter).add(tempSubject);
		}
	}

	@FXML
	public void editButtonClickMethod() throws IOException {
		Subject1 selectedSubject = subjTable.getSelectionModel().getSelectedItem();
		if (selectedSubject != null) {
			main.showHWEditDialog(selectedSubject);
			subjTable.getSelectionModel().getSelectedItem().setName(selectedSubject.getName());
			subjTable.getSelectionModel().getSelectedItem().setLect(selectedSubject.getLect());
			subjTable.refresh();
		}
				
	}

	public void delButtonClickMethod() {
		int selectedIndex = subjTable.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			subjTable.getItems().remove(selectedIndex);
		} 
	}
	
	public void init() {
		week1.getDay(0).add("Test subject Day0", "Test lect day0");
		week1.getDay(1).add("Test subject Day1", "Test lect day1");
		week1.getDay(2).add("Test subject Day2", "Test lect day2");
		week1.getDay(3).add("Test subject Day3", "Test lect day3");
		week1.getDay(4).add("Test subject Day4", "Test lect day4");
	}
	
	public void top() {
		if (dayCounter >= 1) {
			dayCounter--;
			subjTable.setItems(week1.getDay(dayCounter).getSubjects());				
		} 
	}

	public void down() {
		if (dayCounter <= 3) {
			dayCounter++;
			subjTable.setItems(week1.getDay(dayCounter).getSubjects());
		} 	
	}
	
	public Week getWeek1() {
		return week1;
	}
	
	public String getDay() {
		return week1.getDay(dayCounter).getName();
	}
}
