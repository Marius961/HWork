package HW.controllers;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Calendar;

import com.jfoenix.controls.JFXTimePicker;

import HW.Main;
import HW.lang.Language;
import HW.models.PropertiesContainer;
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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainViewController {

	private Calendar calendar = Calendar.getInstance();

	private static Week week = new Week();

	private int dayCounter = getCurrentDay();

	private PropertiesContainer properties = new PropertiesContainer();

	private boolean isSecondWeek = false;
	
	private int weekNum;

	private ToggleGroup rBWeeks = new ToggleGroup();

	private Main main = new Main();

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
	private void initialize() {
		
		setProperties(properties);
		init();
		setToggleGroup();
		firstWeek.setSelected(true);
		setTableProperty();
		dayName.setText(getDayName(dayCounter));
		setButtonsNames();
		subjectTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> listenedSubject = newValue);
		
	}

	@FXML
	private void handleAdd() throws IOException {
		Subject tempSubject = new Subject();
		boolean okClicked = main.initEditDialog();
		if (okClicked) {
			week.selectDay(dayCounter).addSubject(tempSubject);
		}
	}

	@FXML
	private void handleEdit() throws IOException {
		int selectedId = subjectTable.getSelectionModel().getSelectedIndex();
		main.initEditDialog(week.selectDay(dayCounter) , selectedId);	
		setTableItems();
		
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
			subjectTable.setItems(week.selectDay(dayCounter).getSubjects());
			setButtonsNames();
			dayName.setText(getDayName(dayCounter));
		}
	}

	@FXML
	private void handleDown() {		
		if (dayCounter <= 3) {
			dayCounter++;
			subjectTable.setItems(week.selectDay(dayCounter).getSubjects());
			setButtonsNames();
			dayName.setText(getDayName(dayCounter));
		}
	}

	@FXML
	private void handleFirstWeekRB() {
		
	}

	@FXML
	private void handleSecondWeekRB() {
		
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

	private void setProperties(PropertiesContainer properties) {
		if (this.properties != properties) {
			System.out.println("no");
			this.properties = properties;
		}
		applyProperties();
	}

	private void setDisplayTimePickers() {

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
		colSubject.setCellValueFactory(new PropertyValueFactory<Subject, String>("name"));
		colLecture.setCellValueFactory(new PropertyValueFactory<Subject, String>("lect"));
		setTableItems();
	}
	
	public void setTableItems() {
		subjectTable.setItems(week.selectDay(dayCounter).getList(2));
	}


/*	private void setLanguage(Language lang) {
		editButton.setText(lang.getMainViewLang().getEditButton());
		addButton.setText(lang.getMainViewLang().getAddButton());
		deleteButton.setText(lang.getMainViewLang().getDeleteButton());
		firstWeek.setText(lang.getMainViewLang().getFirstWeek());
		secondWeek.setText(lang.getMainViewLang().getSecondWeek());
		colLecture.setText(lang.getMainViewLang().getColLecture());
		colSubject.setText(lang.getMainViewLang().getColSubject());
	} */

	private void init() {
		week.selectDay(0).addSubject(1, 0, "Організація комп'ютерних мереж", "Солонець Д. М.");
		week.selectDay(0).addSubject(2, 2, "Комп'ютерна схемотехніка", "Ващищак С. П.");
		week.selectDay(0).addSubject(2, 1, "Основи електроніки та електротехніки", "Ващищак С. П.");
	}

	private void setButtonsNames() {
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

	public String getDayName(int count) {
		return week.selectDay(count).getName();
	}

	public void applyProperties() {
		setTheme();
		setDisplayTwoWeeks();
		setDisplayTimePickers();
		setButtonsNames();
//		setLanguage(properties.getLanguage());
	}
	
	private void setTheme() {
		pane.getStylesheets().clear();
		pane.getStylesheets().add(getClass().getResource(properties.getTheme().getUrl()).toExternalForm());		
	}
}
