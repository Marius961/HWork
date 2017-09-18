package HW.view;

import HW.model.Subject;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HWEditDialogController {

	@FXML
	private TextField subjectField;
	@FXML
	private TextField lecturerField;

	private Stage dialogStage;
	private Subject subject;
	private boolean okClicked = false;

	@FXML
	private void initialize() {
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;

		subjectField.setText(subject.getSubjectName());
		lecturerField.setText(subject.getLectorer());
	}

	public boolean isOkClicked() {
		return okClicked;
	}

	@FXML
	private void handleOk() {
		if (isInputValid()) {
			subject.setSubjectName(subjectField.getText());
			subject.setLectorer(lecturerField.getText());

			okClicked = true;
			dialogStage.close();
		}
	}

	@FXML
	private void handleCancel() {
		dialogStage.close();
	}

	private boolean isInputValid() {
		String errorMessage = "";

		if (subjectField.getText() == null || subjectField.getText().length() == 0) {
			errorMessage += "No valid Subject!\n";
		}
		if (lecturerField.getText() == null || lecturerField.getText().length() == 0) {
			errorMessage += "No valid Lecturer!\n";
		}
		if (errorMessage.length() == 0) {
			return true;
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(dialogStage);
			alert.setTitle("Invalid Fields");
			alert.setHeaderText("Please correct invalid fields");
			alert.setContentText(errorMessage);

			alert.showAndWait();

			return false;
		}

	}

}