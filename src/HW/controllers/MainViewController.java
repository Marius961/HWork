package HW.controllers;

import java.awt.Button;
import java.io.IOException;

import HW.Main;
import HW.models.Subject1;
import HW.models.Week;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainViewController {
	
	@FXML
    private TableView<Subject1> subjTable;
	
	@FXML
    private TableColumn<Subject1,Integer> colTime;
	
	@FXML
    private TableColumn<Subject1,String> colSubject;
	
	@FXML
    private TableColumn<Subject1,String> colLecture;
	
	private int dayCounter = 0;
	private Week week1 = new Week();
	Main main = new Main();
	
	@FXML
	private void initialize() {
		init();
        colTime.setCellValueFactory(new PropertyValueFactory<Subject1, Integer>("id"));
        colSubject.setCellValueFactory(new PropertyValueFactory<Subject1, String>("name"));
        colLecture.setCellValueFactory(new PropertyValueFactory<Subject1, String>("lect"));
        subjTable.setItems(week1.getDay(0).getSubjects());
    }
	
	public void init() {
		week1.getDay(0).add("Test subject Day0", "Test lect day0");
		week1.getDay(1).add("Test subject Day1", "Test lect day1");
		week1.getDay(2).add("Test subject Day2", "Test lect day2");
		week1.getDay(3).add("Test subject Day3", "Test lect day3");
		week1.getDay(4).add("Test subject Day4", "Test lect day4");
	}
	
	public Week getWeek1() {
		return week1;
	}
	
	public void clickonMn() {
		dayCounter = 0;
		subjTable.setItems(week1.getDay(0).getSubjects());
	}
	
	public void clickonTu() {
		dayCounter = 1;
		subjTable.setItems(week1.getDay(1).getSubjects());
	}
	
	public void clickonWe() {
		dayCounter = 2;
		subjTable.setItems(week1.getDay(2).getSubjects());
	}
	
	public void clickonTh() {
		dayCounter = 3;
		subjTable.setItems(week1.getDay(3).getSubjects());
	}
	
	public void clickonFr() {
		dayCounter = 4;
		subjTable.setItems(week1.getDay(4).getSubjects());
	}
	
	@FXML
	public void AddButtonClickMethod() throws IOException {
		Subject1 tempSubject = new Subject1();
		boolean okClicked = main.showHWEditDialog(tempSubject);
		if (okClicked) {
			week1.getDay(dayCounter).add(tempSubject);
		}
	}
	
	@FXML
	public void InsButtonClickMethod() throws IOException  {
		Subject1 selectedSubject = subjTable.getSelectionModel().getSelectedItem();
		if (selectedSubject != null) {
			main.showHWEditDialog(selectedSubject);
			week1.getDay(dayCounter).setSubject(subjTable.getSelectionModel().getSelectedIndex(), selectedSubject);
		}

	}

	public void SetButtonClickMethod() {
		
	}
	
	public void DelButtonClickMethod() {
		int selectedIndex = subjTable.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			subjTable.getItems().remove(selectedIndex);
		} else {
			
		}
	}
	
}
