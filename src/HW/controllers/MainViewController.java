package HW.controllers;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Calendar;

import com.jfoenix.controls.JFXTimePicker;

import HW.Main;
import HW.models.Subject;
import HW.models.Week;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class MainViewController {

	Calendar calendar = Calendar.getInstance();

	private Week week1 = new Week();
	private Week week2 = new Week();

	private int enterPressCounter = 0;
	private int dayCounter = getCurrentDay();

	private boolean isSecondWeek = false;

	private ToggleGroup rBWeeks = new ToggleGroup();

	private Main main = new Main();

	@FXML
	private TableView<Subject> subjectTable;

	@FXML
	private TableColumn<Subject, Integer> colTime;
	@FXML
	private TableColumn<Subject, String> colSubject;
	@FXML
	private TableColumn<Subject, String> colLecture;

	@FXML
	private RadioButton secondWeek;
	@FXML
	private RadioButton firstWeek;

	@FXML
	AnchorPane pane;

	@FXML
	private Button topButton;
	@FXML
	private Button bottomButton;

	@FXML
	private Label dayName;
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
	private JFXTimePicker tempTimePicker;
	Subject listenedSubject;

	@FXML
	private void initialize() {
		init();
		setToggleGroup();
		firstWeek.setSelected(true);
		setTableProperty();
		dayName.setText(getDay(dayCounter));
		setButtonsNames();
		subjectTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> listenedSubject = newValue);
	}

	@FXML
	private void handleAdd() throws IOException {
		Subject tempSubject = new Subject();
		boolean okClicked = main.initEditDialog(tempSubject);
		if (okClicked) {
			getWeekNum().getDay(dayCounter).addSubject(tempSubject);
		}
	}

	@FXML
	private void handleEdit() throws IOException {
		Subject selectedSubject = subjectTable.getSelectionModel().getSelectedItem();
		if (selectedSubject != null) {
			main.initEditDialog(selectedSubject);
			subjectTable.getSelectionModel().getSelectedItem().setName(selectedSubject.getName());
			subjectTable.getSelectionModel().getSelectedItem().setLect(selectedSubject.getLect());
			subjectTable.refresh();
		}
	}

	@FXML
	private void openHomeWork(MouseEvent mouseEvent) throws IOException {
		if (mouseEvent.getButton().equals(MouseButton.PRIMARY) && mouseEvent.getClickCount() == 2) {
			handleEditHomework(listenedSubject);
		}
	}

	@FXML
	public void handleDelete() {

		int selectedIndex = subjectTable.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			subjectTable.getItems().remove(selectedIndex);
		}
	}

	@FXML
	private void handleTop() {
		if (dayCounter >= 1) {
			dayCounter--;
			subjectTable.setItems(getWeekNum().getDay(dayCounter).getSubjects());
			setButtonsNames();
			dayName.setText(getDay(dayCounter));
		}
	}

	@FXML
	private void handleDown() {
		if (dayCounter <= 3) {
			dayCounter++;
			subjectTable.setItems(getWeekNum().getDay(dayCounter).getSubjects());
			setButtonsNames();
			dayName.setText(getDay(dayCounter));
		}
	}

	@FXML
	private void handleFirstWeekRB() {
		isSecondWeek = false;
		subjectTable.setItems(getWeekNum().getDay(dayCounter).getSubjects());
	}

	@FXML
	private void handleSecondWeekRB() {
		isSecondWeek = true;
		subjectTable.setItems(getWeekNum().getDay(dayCounter).getSubjects());

	}

	@FXML
	private void openTimePicker() {
		tempTimePicker.setIs24HourView(true);
	}

	private void setClickedLabel() {
		if (tempTimePicker == firstTimePicker) {
			tempLabelTime = firstLabelTime;
		} else if (tempTimePicker == secondTimePicker) {
			tempLabelTime = secondLabelTime;
		}
	}

	private void setToggleGroup() {
		firstWeek.setToggleGroup(rBWeeks);
		secondWeek.setToggleGroup(rBWeeks);
	}

	private void setTableProperty() {
		colSubject.setCellValueFactory(new PropertyValueFactory<Subject, String>("name"));
		colLecture.setCellValueFactory(new PropertyValueFactory<Subject, String>("lect"));
		subjectTable.setItems(getWeekNum().getDay(dayCounter).getSubjects());
	}

	private Week getWeekNum() {
		if (isSecondWeek == false) {
			return week1;
		}
		if (isSecondWeek == true) {
			return week2;
		}
		return null;
	}

	private void init() {
		week1.getDay(0).addSubject("Test subject Mon week 1", "Test lect Mon");
		week1.getDay(1).addSubject("Test subject Tue week 1", "Test lect Tue");
		week1.getDay(2).addSubject("Test subject Wed week 1", "Test lect Wed");
		week1.getDay(3).addSubject("Test subject Thu week 1", "Test lect Thu");
		week1.getDay(4).addSubject("Test subject Fri week 1", "Test lect Fri");
		week2.getDay(0).addSubject("Test subject Mon week 2", "Test lect Mon 2");
		week2.getDay(1).addSubject("Test subject Tue week 2", "Test lect Tue 2");
		week2.getDay(2).addSubject("Test subject Wed week 2", "Test lect Wed 2");
		week2.getDay(3).addSubject("Test subject Thu week 2", "Test lect Thu 2");
		week2.getDay(4).addSubject("Test subject Fri week 2", "Test lect Fri 2");
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
		if ((calendar.get(Calendar.DAY_OF_WEEK) - 2) < 0 || (calendar.get(Calendar.DAY_OF_WEEK) - 2) > 4) {
			return 0;
		} else
			return (calendar.get(Calendar.DAY_OF_WEEK) - 2);
	}

	private void handleEditHomework(Subject subject) throws IOException {
		if (subject != null) {
			main.initHomeworkEditDialog(subject);
			subjectTable.getSelectionModel().getSelectedItem().setHomework(subject.getHomework());
		}
	}

	// ---------------------------------PUBLIC METHODS-----------------------//

	public void getTimePicker(MouseEvent mouseEvent) {
		if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
			tempTimePicker = (JFXTimePicker) mouseEvent.getSource();
			setClickedLabel();
		}
		if (mouseEvent.getButton().equals(MouseButton.PRIMARY) && mouseEvent.getClickCount() == 2) {
			LocalTime time = tempTimePicker.getValue();
			tempLabelTime.setText(time + "-");
		}
		if (mouseEvent.getButton().equals(MouseButton.PRIMARY) && mouseEvent.getClickCount() == 2) {
			LocalTime time = tempTimePicker.getValue();
			tempLabelTime.setText(tempLabelTime.getText() + time);
			enterPressCounter = 0;
		}
	}

	public String getDay(int count) {
		return getWeekNum().getDay(count).getName();
	}
}
