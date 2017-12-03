package HW.controllers;

import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTimePicker;

import HW.Main;
import HW.models.Converter;
import HW.models.Day;
import HW.models.Properties;
import HW.models.PropertiesContainer;
import HW.models.Subject;
import HW.models.ThemeList;
import HW.models.Week;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class MainViewController implements Properties{

	private Week week = Converter.dataToJavaObject();
	private List<String> timeList = Converter.timeToJava();
	private int dayCounter = week.getCurrentDay();
	private int weekNum;
	private Main main = new Main();
	private PropertiesContainer properties = main.getProperties();
	private Subject listenedSubject;
	private ObservableList<String> weeks = FXCollections.observableArrayList("1 week","2 week");
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
	public  Label firstLabelTime;
	@FXML
	public  Label secondLabelTime;
	@FXML
	public  Label thirdLabelTime;
	@FXML
	public  Label fourthLabelTime;
	@FXML
	public Label fifthLabelTime;
	@FXML
	private Label tempLabelTime;
	 
	@FXML
	ChoiceBox<String> cbweeks;
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
	private JFXButton accpetTimeButtom;
	@FXML
	private JFXButton deleteTimeButtom;
	@FXML
	private VBox acceptGroup;
	@FXML
	private Label currentTime;
	
	@FXML
	private void initialize() throws IOException {	
		setWeekChangeListener();
		setTableProperty();
		subjectTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> listenedSubject = newValue);
		setTime();
		displayTime();
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
			displayTime();
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
		displayTime();
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
		for(int i=0; i<timeList.size();i++) {
			System.out.println(timeList.get(i));
		}
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
	private void labelClicked(MouseEvent mouseEvent) {
		if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
			tempLabelTime = (Label) mouseEvent.getSource();
			getTimePicker().setVisible(true);
			getTimePicker().setIs24HourView(true);
			closeOtherTimePickers();
			getTimePicker().show();
		}
	}

	@FXML
	private void inputLabelTime() {
		acceptGroup.setVisible(true);
		currentTime.setText(getTimePicker().getValue().toString());
	}
	
	
	@FXML
	private void acepttInputting() {
		enterPressCounter++;
		if (enterPressCounter == 1) {
			LocalTime time = getTimePicker().getValue();
			tempLabelTime.setText(time + "-");
			getTimePicker().show();
			timeList.add("test");
		}
		if (enterPressCounter == 2) {
			LocalTime time = getTimePicker().getValue();
			tempLabelTime.setText(tempLabelTime.getText() + time);
			timeList.add("test");
			getTimePicker().setVisible(false);
			enterPressCounter = 0;
			acceptGroup.setVisible(false);
		}
	}
	
	@FXML
	private void deleteInputting() {
		tempLabelTime.setText("Click me");
		getTimePicker().setVisible(false);
		acceptGroup.setVisible(false);
	}
		
	private void setWeekChangeListener() {
		cbweeks.setVisible(properties.isTwoWeeksShedule());
		setCurrentWeekNum();
		if (properties.isTwoWeeksShedule()) {
			cbweeks.setItems(weeks);
			}
			cbweeks.getSelectionModel().selectedIndexProperty().addListener(
					new ChangeListener<Number>() {
						@Override
						public void changed(ObservableValue<? extends Number> observable, Number oldValue,
								Number newValue) {
							if (newValue.intValue() == 0) {
								properties.setCurrentWeekNum(weekNum = 1);
								setTableItems();
							} else {
								properties.setCurrentWeekNum(weekNum = 2);
								setTableItems();
							}
						}
					});
	}
	
	
	private void closeOtherTimePickers() {
		if (getTimePicker() != firstTimePicker) {
			firstTimePicker.setVisible(false);
		}
		if (getTimePicker() != secondTimePicker) {
			secondTimePicker.setVisible(false);
		}
		if (getTimePicker() != thirdTimePicker) {
			thirdTimePicker.setVisible(false);
		}
		if (getTimePicker() != fourthTimePicker) {
			fourthTimePicker.setVisible(false);
		}
		if (getTimePicker() != fifthTimePicker) {
			fifthTimePicker.setVisible(false);
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
	
	private void setTime() {
		for(int i=0; i<timeList.size(); i++) {
			getLabelTimeById(i).setText(timeList.get(i));
		}
	}
	
	private void displayTime() {
		int subjCount = week.selectDay(dayCounter).getIdList(weekNum).size();
		for(int i=0; i<5; i++) {
			getLabelTimeById(i).setVisible(false);
		}
		if(subjCount<6) {
			for(int i=0;i<subjCount;i++) {
				getLabelTimeById(i).setVisible(true);
			}
		}else {
			for(int i=0;i<5;i++) {
				getLabelTimeById(i).setVisible(true);
			}
		}
	}
	
	private Label getLabelTimeById(int number) {
		if(number==0) {
			return firstLabelTime;
		}else if(number==1) {
			return secondLabelTime;	
		}else if(number==2) {
			return thirdLabelTime;	
		}else if(number==3) {
			return fourthLabelTime;	
		}else if(number==4) {
			return fifthLabelTime;	
		} else return null;
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
		setCurrentWeekNum();
	}
	
	private void setDisplayTwoWeeks() {
		cbweeks.setVisible(properties.isTwoWeeksShedule());
	}

	public void setCurrentWeekNum() {
		if (properties.isTwoWeeksShedule() == false) {
			cbweeks.getSelectionModel().select(0);
			weekNum = 1;
		} else {
			weekNum = properties.getCurrentWeekNum();
			if (weekNum == 1) 
				cbweeks.getSelectionModel().select(0);
			if (weekNum == 2) 
				cbweeks.getSelectionModel().select(1);
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
	public List<String> getTimeList() {
		return timeList;
	}
}
