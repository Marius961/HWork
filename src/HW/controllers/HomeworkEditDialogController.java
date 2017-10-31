package HW.controllers;

import HW.lang.Language;
import HW.models.PropertiesContainer;
import HW.models.Subject;
import HW.models.Task;
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

	TableView<ObservableList<String>> tableView = new TableView<>();

	@FXML
	private TextArea homeworkField;

	@FXML
	private TableView<Task> taskTable;

	@FXML
	private TableColumn<Task, String> taskCol;

	@FXML
	private void initialize() {
		taskCol.setCellValueFactory(new PropertyValueFactory<Task, String>("task"));
		homeworkField.setWrapText(true);
	}

	private void setLanguage(Language lang) {

	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
		taskTable.setItems(this.subject.getTaskList());
	}

	@FXML
	private void addButton() {
		subject.add(homeworkField.getText());
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
