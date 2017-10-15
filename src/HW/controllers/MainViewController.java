package HW.controllers;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Calendar;

import com.jfoenix.controls.JFXTimePicker;

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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class MainViewController {
	
	Calendar calendar = Calendar.getInstance();
	
	private Week week1 = new Week();
	private Week week2 = new Week();
	
	private int enterPressCounter = 0;
	private int dayCounter = getCurrentDay();
	
	private boolean weekCount = false;

	private ToggleGroup rBWeeks = new ToggleGroup();
	
	private  Main main = new Main();
	
	@FXML
	private TableView<Subject1> subjTable;
	
	@FXML
	private TableColumn<Subject1, Integer> colTime;
	@FXML
	private TableColumn<Subject1, String> colSubject;
	@FXML
	private TableColumn<Subject1, String> colLecture;
	
	@FXML
	private RadioButton secWeek;
	@FXML
	private RadioButton firstWeek;
	
	@FXML
	private Label dayName;
	@FXML
	private Button topButton;
	@FXML
	private Button bottomButton;
		
	@FXML
	private Label firstLabelTime;
	@FXML
	private Label secondLabelTime;
	@FXML
	private Label thirdLabelTime;
	@FXML
	private Label fourthLabelTime;
	@FXML
	private Label fifthLabelTime;
	@FXML
	private Label tempLabelTime;
	
	@FXML
	private JFXTimePicker firstTimePicker;
	@FXML
	private JFXTimePicker secondTimePicker;
	@FXML
	private JFXTimePicker thirdTimePicker;
	@FXML
	private JFXTimePicker fourthTimePicker;
	@FXML
	private JFXTimePicker fifthTimePicker;
	
	@FXML
	private void initialize() {
		init();
		setToggleGroup();
		firstWeek.setSelected(true);
		setTableProperty();
		addClickListener();
		dayName.setText(getDay(dayCounter));
		setButtonsNames();

	}

	@FXML
	private void addButtonClickMethod() throws IOException {
		Subject1 tempSubject = new Subject1();
		boolean okClicked = main.showHWEditDialog(tempSubject);
		if (okClicked) {
			getWeekNum().getDay(dayCounter).add(tempSubject);
		}
	}

	@FXML
	private void editButtonClickMethod() throws IOException {
		Subject1 selectedSubject = subjTable.getSelectionModel().getSelectedItem();
		if (selectedSubject != null) {
			main.showHWEditDialog(selectedSubject);
			subjTable.getSelectionModel().getSelectedItem().setName(selectedSubject.getName());
			subjTable.getSelectionModel().getSelectedItem().setLect(selectedSubject.getLect());
			subjTable.refresh();
		}
	}
	
	@FXML
	private void addClickListener() {
		subjTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			try {
				clickOnSubject(newValue);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}
	
	@FXML
	public void delButtonClickMethod() {
		int selectedIndex = subjTable.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			subjTable.getItems().remove(selectedIndex);
		}
	}

	@FXML
	private void top() {
		if (dayCounter >= 1) {
			dayCounter--;
			subjTable.setItems(getWeekNum().getDay(dayCounter).getSubjects());
			setButtonsNames();
			dayName.setText(getDay(dayCounter));
		}
	}
	
	@FXML
	private void down() {
		if (dayCounter <= 3) {
			dayCounter++;
			subjTable.setItems(getWeekNum().getDay(dayCounter).getSubjects());
			setButtonsNames();
			dayName.setText(getDay(dayCounter));
		}
	}

	@FXML
	private void refresh() {
		subjTable.refresh();
	}

	@FXML
	private void firstRBMethod() {
		weekCount = false;
		subjTable.setItems(getWeekNum().getDay(dayCounter).getSubjects());
	}

	@FXML
	private void secRBMethod() {
		weekCount = true;
		subjTable.setItems(getWeekNum().getDay(dayCounter).getSubjects());

	}
	
	@FXML
	private void openTimePicker() {
		tempLabelTime.setVisible(false);
		getTimePicker().setVisible(true);
		closeOtherTimePickers();
	}

	@FXML
	private void inputLabelTime(KeyEvent event) {
		enterPressCounter++;
		if (event.getCode() == KeyCode.ENTER && enterPressCounter == 1) {
			LocalTime time = getTimePicker().getValue();
			tempLabelTime.setText(time + "-");
		}
		if (event.getCode() == KeyCode.ENTER && enterPressCounter == 2) {
			LocalTime time = getTimePicker().getValue();
			tempLabelTime.setText(tempLabelTime.getText() + time);
			getTimePicker().setVisible(false);
			tempLabelTime.setVisible(true);
			enterPressCounter = 0;
		}
	}

	@FXML
	private void setFirstLabelTime() {
		tempLabelTime = firstLabelTime;
		openTimePicker();
	}

	@FXML
	private void setSecondLabelTime() {
		tempLabelTime = secondLabelTime;
		openTimePicker();
	}

	@FXML
	private void setThirdLabelTime() {
		tempLabelTime = thirdLabelTime;
		openTimePicker();
	}

	@FXML
	private void setFourthLabelTime() {
		tempLabelTime = fourthLabelTime;
		openTimePicker();
	}

	@FXML
	private void setFifthLabelTime() {
		tempLabelTime = fifthLabelTime;
		openTimePicker();
	}

	

	private void closeOtherTimePickers() {
		if (getTimePicker() != firstTimePicker) {
			firstTimePicker.setVisible(false);
			firstLabelTime.setVisible(true);
		}
		if (getTimePicker() != secondTimePicker) {
			secondTimePicker.setVisible(false);
			secondLabelTime.setVisible(true);
		}
		if (getTimePicker() != thirdTimePicker) {
			thirdTimePicker.setVisible(false);
			thirdLabelTime.setVisible(true);
		}
		if (getTimePicker() != fourthTimePicker) {
			fourthTimePicker.setVisible(false);
			fourthLabelTime.setVisible(true);
		}
		if (getTimePicker() != fifthTimePicker) {
			fifthTimePicker.setVisible(false);
			fifthLabelTime.setVisible(true);
		}
	}
		
	private void setToggleGroup() {
		firstWeek.setToggleGroup(rBWeeks);
		secWeek.setToggleGroup(rBWeeks);
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
	
	private void init() {
		week1.getDay(0).add("Test subject Mon week 1", "Test lect Mon");
		week1.getDay(1).add("Test subject Tue week 1", "Test lect Tue");
		week1.getDay(2).add("Test subject Wed week 1", "Test lect Wed");
		week1.getDay(3).add("Test subject Thu week 1", "Test lect Thu");
		week1.getDay(4).add("Test subject Fri week 1", "Test lect Fri");
		week2.getDay(0).add("Test subject Mon week 2", "Test lect Mon 2");
		week2.getDay(1).add("Test subject Tue week 2", "Test lect Tue 2");
		week2.getDay(2).add("Test subject Wed week 2", "Test lect Wed 2");
		week2.getDay(3).add("Test subject Thu week 2", "Test lect Thu 2");
		week2.getDay(4).add("Test subject Fri week 2", "Test lect Fri 2");
	}
	
	private void setButtonsNames() {
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

	private int getCurrentDay() {
		if ((calendar.get(Calendar.DAY_OF_WEEK) - 2) < 0) {
			return 0;
		} else
			return calendar.get(Calendar.DAY_OF_WEEK) - 2;
	}


	private void clickOnSubject(Subject1 subject) throws IOException {
		if (subject != null) {
			main.showHomeworkView(subject);
			subjTable.getSelectionModel().getSelectedItem().setHomework(subject.getHomework());
		}
	}
	
//---------------------------------PUBLIC METHODS-----------------------//
	
	public JFXTimePicker getTimePicker() {
		if (tempLabelTime == firstLabelTime) {
			return firstTimePicker;
		} else if (tempLabelTime == secondLabelTime) {
			return secondTimePicker;
		} else if (tempLabelTime == thirdLabelTime) {
			return thirdTimePicker;
		} else if (tempLabelTime == fourthLabelTime) {
			return fourthTimePicker;
		} else
			return fifthTimePicker;
	}
	
	public String getDay(int count) {
		return getWeekNum().getDay(count).getName();
	}
	
	public Week getWeek1() {
		return getWeekNum();
	}
	
}
