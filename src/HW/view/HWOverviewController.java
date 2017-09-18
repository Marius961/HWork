package HW.view;

import HW.MainApp;
import HW.model.Subject;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class HWOverviewController {
	@FXML
	private TableView<Subject> subjectTable;
	@FXML
	private TableColumn<Subject, String> subjectNameColumn;
	@FXML
	private TableColumn<Subject, String> lectureColumn;

	private MainApp mainApp;

	public HWOverviewController() {
	}

	@FXML
	public void initialize() {
		subjectNameColumn.setCellValueFactory(cellData -> cellData.getValue().subjectNameProperty());
		lectureColumn.setCellValueFactory(cellData -> cellData.getValue().lectorerProperty());

		// Відслідковує, який елемент таблиці вибрано
		// subjectTable.getSelectionModel().selectedItemProperty().addListener((
		// observable, oldValue, newValue) -> showHWDetails(newValue));

	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		subjectTable.setItems(mainApp.getSubjectData());
	}

	@FXML
	private void handleNewSubject() {
		Subject tempSubject = new Subject();
		boolean okClicked = mainApp.showHWEditDialog(tempSubject);
		if (okClicked) {
			mainApp.getSubjectData().add(tempSubject);
		}
	}

	public void handleDeleteSubject() {
		int selectedIndex = subjectTable.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			subjectTable.getItems().remove(selectedIndex);
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Person Selected");
			alert.setContentText("Please select a person in the table.");

			alert.showAndWait();
		}
	}

	public void handleEditSubject() {
		Subject selectedSubject = subjectTable.getSelectionModel().getSelectedItem();
		if (selectedSubject != null) {
			mainApp.showHWEditDialog(selectedSubject);
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Subject Selected");
			alert.setContentText("Please select a subject in the table.");

			alert.showAndWait();
		}
	}

	public void on1stClick() {

	}

	public void on2ndClick() {

	}

}