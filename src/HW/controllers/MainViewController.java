package HW.controllers;

import java.io.IOException;
import java.util.Calendar;

import HW.Main;
import HW.models.Subject1;
import HW.models.Week;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
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
	
	@FXML
	RadioButton secWeek;
	
	@FXML
	RadioButton firstWeek;
	
	private int dayCounter = getCurrentDay();
	private boolean weekCount = false;
	private Week week1 = new Week();
	private Week week2 = new Week();

	Main main = new Main();
// RB = RadioButton
	ToggleGroup rBWeeks = new ToggleGroup();
	
	
	@FXML
	private void initialize()  {
		firstWeek.setToggleGroup(rBWeeks);	
		secWeek.setToggleGroup(rBWeeks);
		firstWeek.setSelected(true);
		setTableProperty();
		init();
		setButtonsNames();
		addClickListener();
		dayName.setText(getDay(dayCounter));
	}

	@FXML
	public void addButtonClickMethod() throws IOException {
		Subject1 tempSubject = new Subject1();
		boolean okClicked = main.showHWEditDialog(tempSubject);
		if (okClicked) {
			getWeekNum().getDay(dayCounter).add(tempSubject);
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
	
	public void addClickListener() {
		subjTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			try {
				clickOnSubject(newValue);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}

	public void delButtonClickMethod() {
		int selectedIndex = subjTable.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			subjTable.getItems().remove(selectedIndex);
		}
	}

	public void init() {
		week1.getDay(0).add("Test subject Mon week 1", "Test lect Mon");
		week1.getDay(1).add("Test subject Tue week 1", "Test lect Tue");
		week1.getDay(2).add("Test subject Wed week 1", "Test lect Wed");
		week1.getDay(3).add("Test subject Thu week 1", "Test lect Thu");
		week1.getDay(4).add("Test subject Fri week 1", "Test lect Fri");
		week2.getDay(0).add("Test subject Mon week 2", "Test lect Mon");
		week2.getDay(1).add("Test subject Tue week 2", "Test lect Tue");
		week2.getDay(2).add("Test subject Wed week 2", "Test lect Wed");
		week2.getDay(3).add("Test subject Thu week 2", "Test lect Thu");
		week2.getDay(4).add("Test subject Fri week 2", "Test lect Fri");
	}

	public void top() {
		if (dayCounter >= 1) {
			dayCounter--;
			subjTable.setItems(getWeekNum().getDay(dayCounter).getSubjects());
			setButtonsNames();
			dayName.setText(getDay(dayCounter));
		}
	}

	public void down() {
		if (dayCounter <= 3) {
			dayCounter++;
			subjTable.setItems(getWeekNum().getDay(dayCounter).getSubjects());
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
		return getWeekNum();
	}

	public String getDay(int count) {
		return getWeekNum().getDay(count).getName();
	}
	
	public void clickOnSubject(Subject1 subject) throws IOException {
		if (subject != null) {
			main.showHomeworkView(subject);
			subjTable.getSelectionModel().getSelectedItem().setHomework(subject.getHomework());
		}
	}
	
	public void refresh() {
		subjTable.refresh();
	}
	
	private void setTableProperty() {
		colSubject.setCellValueFactory(new PropertyValueFactory<Subject1, String>("name"));
		colLecture.setCellValueFactory(new PropertyValueFactory<Subject1, String>("lect"));
		subjTable.setItems(getWeekNum().getDay(dayCounter).getSubjects());
	}
	
	private Week getWeekNum() {
		if (weekCount == false) {
			return week1;
		}
		if (weekCount == true) {
			return week2;
		}
		return null;
	}
		
	@FXML
	public void firstRBMethod() {
		weekCount = false;
		subjTable.setItems(getWeekNum().getDay(dayCounter).getSubjects());
	}
	
	@FXML
	public void secRBMethod() {
		weekCount = true;
		subjTable.setItems(getWeekNum().getDay(dayCounter).getSubjects());
		
	}
	
}
