package HW.controllers;

import HW.lang.Language;
import HW.models.PropertiesContainer;
import HW.models.Subject;
import HW.models.Week;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class HomeworkEditDialogController {

	private Stage dialogStage;

	private PropertiesContainer properties;

	private Subject subject;

	private boolean saveClicked = false;

	@FXML
	private Button saveButton;
	@FXML
	private Button cancelButton;
	@FXML
	private Button cleanButton;

	@FXML
	private Label homeworkLabel;

	@FXML
	private TextArea homeworkField;
	private Week week1 = new Week();
	@FXML
	private TableView<Subject> taskTable;
	@FXML
	private TableColumn<Subject, String> taskCol;
	TableView<ObservableList<String>> tableView = new TableView<>();

	@FXML
	private void initialize() {
		taskCol.setCellValueFactory(new PropertyValueFactory<Subject, String>("homework"));
		taskTable.setItems(week1.getDay(0).getHomeWork());
	}

	@FXML
	private void handleAdd() {
		week1.getDay(0).addHomeWork(homeworkField.getText());
		homeworkField.setText("");
	}

	@FXML
	private void handleSave() {
		subject.setHomework(homeworkField.getText());
		saveClicked = true;
		dialogStage.close();
	}

	@FXML
	private void handleCancel() {
		dialogStage.close();
	}

	@FXML
	private void handleClean() {
		homeworkField.setText("");
	}

	private void setLanguage(Language lang) {
		homeworkLabel.setText(lang.getHomeworkEditDialog().getHomeworkLabel());
		cancelButton.setText(lang.getHomeworkEditDialog().getCancelButton());
		saveButton.setText(lang.getHomeworkEditDialog().getSaveButton());
		cleanButton.setText(lang.getHomeworkEditDialog().getCleanButton());
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
		homeworkField.setText(subject.getHomework());
	}

	public boolean isSaveClicked() {
		return saveClicked;
	}

	public void setProperties(PropertiesContainer properties) {
		if (this.properties != properties) {
			this.properties = properties;
		}
	}

	public void applyProperties() {
		setLanguage(properties.getLanguage());
	}
}
