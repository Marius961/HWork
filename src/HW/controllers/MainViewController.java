package HW.controllers;

import java.io.IOException;
import java.util.Calendar;

import HW.Main;
import HW.models.Subject1;
import HW.models.Week;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainViewController {

	Calendar calendar = Calendar.getInstance();
	@FXML
	private TableView<Subject1> subjTable;

	@FXML
	private TableColumn<Subject1, Integer> colTime;

	@FXML
	private TableColumn<Subject1, String> colSubject;

	@FXML
	private TableColumn<Subject1, String> colLecture;
	@FXML
	private Button topButton;
	@FXML
	private Button bottomButton;
	@FXML
	private Label dayName;
	private int dayCounter = getCurrentDay();
	private Week week1 = new Week();

	Main main = new Main();

	@FXML
	private void initialize() {
		init();
		colSubject.setCellValueFactory(new PropertyValueFactory<Subject1, String>("name"));
		colLecture.setCellValueFactory(new PropertyValueFactory<Subject1, String>("lect"));
		subjTable.setItems(week1.getDay(dayCounter).getSubjects());
		setButtonsNames();
		dayName.setText(getDay(dayCounter));
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
		week1.getDay(0).add("Test subject Mon", "Test lect Mon");
		week1.getDay(1).add("Test subject Tue", "Test lect Tue");
		week1.getDay(2).add("Test subject Wed", "Test lect Wed");
		week1.getDay(3).add("Test subject Thu", "Test lect Thu");
		week1.getDay(4).add("Test subject Fri", "Test lect Fri");
	}

	public void top() {
		if (dayCounter >= 1) {
			dayCounter--;
			subjTable.setItems(week1.getDay(dayCounter).getSubjects());
			setButtonsNames();
			dayName.setText(getDay(dayCounter));
		}
	}

	public void down() {
		if (dayCounter <= 3) {
			dayCounter++;
			subjTable.setItems(week1.getDay(dayCounter).getSubjects());
			setButtonsNames();
			dayName.setText(getDay(dayCounter));
		}
	}

	public void setButtonsNames() {
		if (dayCounter == 0) {
			topButton.setText("***");
		} else {
			int topName = dayCounter - 1;
			topButton.setText(getDay(topName));
		}
		if (dayCounter == 4) {
			bottomButton.setText("***");
		} else {
			int bottomName = dayCounter + 1;
			bottomButton.setText(getDay(bottomName));
		}
	}

	public int getCurrentDay() {
		if ((calendar.get(Calendar.DAY_OF_WEEK) - 2) < 0) {
			return 0;
		} else
			return calendar.get(Calendar.DAY_OF_WEEK) - 2;
	}

	public Week getWeek1() {
		return week1;
	}

	public String getDay(int count) {
		return week1.getDay(count).getName();
	}
}
