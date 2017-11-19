package HW.controllers;

import java.io.IOException;

import java.time.LocalTime;
import java.util.Calendar;
import java.util.List;

import com.jfoenix.controls.JFXTimePicker;

import HW.Main;
import HW.models.Converter;
import HW.models.Day;
import HW.models.Properties;
import HW.models.PropertiesContainer;
import HW.models.Subject;
import HW.models.ThemeList;
import HW.models.Week;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class MainViewController implements Properties{

	private Week week = Converter.dataToJavaObject();
	private int dayCounter = week.getCurrentDay();
	private int weekNum;
	private ToggleGroup rBWeeks = new ToggleGroup();
	private Main main = new Main();
	private PropertiesContainer properties = main.getProperties();
	private Subject listenedSubject;

	@FXML
	private TableView<Subject> subjectTable;

	@FXML
	private TableColumn<Subject, Integer> colTime;
	@FXML
	private TableColumn<Subject, String> colSubject;
	@FXML
	private TableColumn<Subject, String> colLecture;
	@FXML
	private TableColumn<Button, String> colButton;
	
	@FXML
	private RadioButton secondWeek;
	@FXML
	private RadioButton firstWeek;

	@FXML
	private AnchorPane pane;

	@FXML
	private Button topButton;
	@FXML
	private Button bottomButton;
	@FXML
	private Button addButton;
	@FXML
	private Button editButton;
	@FXML
	private Button deleteButton;

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
	private int enterPressCounter = 0;
	
	@FXML
	private void initialize() throws IOException {			
		setTableProperty();
		subjectTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> listenedSubject = newValue);
	}

	@FXML
	private void handleAdd() throws IOException {
		Subject tempSubject = new Subject();
		tempSubject.setId(week.selectDay(dayCounter).getFreeId(weekNum));
		tempSubject.setWeeknum(weekNum);
		boolean okclicked = main.initEditDialog(tempSubject,week.selectDay(dayCounter).getIdList(weekNum),week.selectDay(1).getIdList(2));
		if (okclicked) {
			week.selectDay(dayCounter).add(tempSubject);
			setTableItems();
		}
	}

	@FXML
	private void handleEdit() throws IOException {
		Subject selectedSubject = subjectTable.getSelectionModel().getSelectedItem();	
		if (selectedSubject != null) {
			boolean okclicked = main.initEditDialog(selectedSubject, week.selectDay(dayCounter).getIdList(1), week.selectDay(dayCounter).getIdList(2));
			if (okclicked) {
				subjectTable.getItems().set(subjectTable.getSelectionModel().getSelectedIndex(), selectedSubject);
				setTableItems();
			}
		}
	}

	@FXML
	private void handleEditHomeWorkEvent(MouseEvent mouseEvent) throws IOException {
		if (mouseEvent.getButton().equals(MouseButton.PRIMARY) && mouseEvent.getClickCount() == 2) {
			handleEditHomework(listenedSubject);
		}
	}

	@FXML
	public void handleDelete() {
		week.selectDay(dayCounter).remove(subjectTable.getSelectionModel().getSelectedItem());
		setTableItems();
	}

	@FXML
	private void openProperties() throws IOException {
		Boolean saveClicked = main.initPropertiesDialog();
		if (saveClicked) {
			setProperties(main.getProperties());
		}
	}

	@FXML
	private void handleTop() {
		if (dayCounter >= 1) {
			dayCounter--;
			setTableItems();
			setButtonsNames();
		}
	}

	@FXML
	private void handleDown() {		
		if (dayCounter <= 3) {
			dayCounter++;
			setTableItems();
			setButtonsNames();
		}
	}

	@FXML
	private void handleFirstWeekRB() {
		properties.setCurrentWeekNum(weekNum = 1);
		setTableItems();
	}

	@FXML
	private void handleSecondWeekRB() {
		properties.setCurrentWeekNum(weekNum = 2);
		setTableItems();
	}

	@FXML
	private void labelClicked(MouseEvent mouseEvent) {
		if (mouseEvent.getButton().equals(MouseButton.PRIMARY) && mouseEvent.getClickCount() == 2) {
			tempLabelTime = (Label) mouseEvent.getSource();
			getTimePicker().setVisible(true);
			getTimePicker().setIs24HourView(true);
			closeOtherTimePickers();
		}
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
			enterPressCounter = 0;
		}
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

	public void setProperties(PropertiesContainer properties) {
		if (this.properties != properties) {
			System.out.println("no");
			this.properties = properties;
		}
		applyProperties();
	}

	private void setDisplayTimePickers() {
		firstLabelTime.setVisible(properties.isDisplayTimePickers());		
		secondLabelTime.setVisible(properties.isDisplayTimePickers());
		thirdLabelTime.setVisible(properties.isDisplayTimePickers());
		fourthLabelTime.setVisible(properties.isDisplayTimePickers());
		fifthLabelTime.setVisible(properties.isDisplayTimePickers());
		firstTimePicker.setVisible(properties.isDisplayTimePickers());
		secondTimePicker.setVisible(properties.isDisplayTimePickers());
		thirdTimePicker.setVisible(properties.isDisplayTimePickers());
		fourthTimePicker.setVisible(properties.isDisplayTimePickers());
		fifthTimePicker.setVisible(properties.isDisplayTimePickers());
	} 

	private void setDisplayTwoWeeks() {
		firstWeek.setVisible(properties.isTwoWeeksShedule());
		secondWeek.setVisible(properties.isTwoWeeksShedule());
	}

	private void setToggleGroup() {
		firstWeek.setToggleGroup(rBWeeks);
		secondWeek.setToggleGroup(rBWeeks);
	}

	private void setTableProperty() {
		subjectTable.setFocusTraversable(false);
		colSubject.setCellValueFactory(new PropertyValueFactory<Subject, String>("name"));
		colLecture.setCellValueFactory(new PropertyValueFactory<Subject, String>("lect"));		
		setTableItems();
	}
		
	public void setTableItems() {
		subjectTable.getItems().clear();
		for (Subject temp : week.selectDay(dayCounter).get()) {
			if(temp.getWeekNum() == weekNum || temp.getWeekNum() == 0) {
				subjectTable.getItems().add(temp);				
				System.out.println("added: " + temp.getName() + " with id " +temp.getId() + " and weenk num: " + weekNum);
			} 
		}
	}

	private void setButtonsNames() {
		dayName.setText(getDayName(dayCounter));
		if (dayCounter == 0) {
			topButton.setText("***");
		} else {
			int topName = dayCounter - 1;
			topButton.setText(getDayName(topName));
		}
		if (dayCounter == 4) {
			bottomButton.setText("***");
		} else {
			int bottomName = dayCounter + 1;
			bottomButton.setText(getDayName(bottomName));
		}
	}
	
	private void handleEditHomework(Subject subject) throws IOException {
		if (subject != null) {
			main.initHomeworkEditDialog(subject);
			subjectTable.getSelectionModel().getSelectedItem().setHomework(subject.getHomework());
		}
	}

	public String getDayName(int count) {
		return week.selectDay(count).getName();
	}

	public void applyProperties() {
		setTheme();
		setDisplayTwoWeeks();
//		setDisplayTimePickers();
		setButtonsNames();
		setToggleGroup();
		setCurrentWeekNum();
	}
	
	public void setCurrentWeekNum() {
		this.weekNum = properties.getCurrentWeekNum();
		if (weekNum == 1) {
			firstWeek.setSelected(true);
		} if (weekNum == 2) {
			secondWeek.setSelected(true);
		} else {
			firstWeek.setSelected(true);
		}
	}
	private void setTheme() {
		pane.getStylesheets().clear();
		pane.getStylesheets().add(getClass().getResource(properties.getTheme().getUrl()).toExternalForm());		
	}
	
	public Week getWeek() {
		return week;
	}
	
	public PropertiesContainer getProperties() {
		return this.properties;
	}		
}
