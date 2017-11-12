package HW.models;

import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class InputValidator {
	
	public boolean isInputValid(Stage owner,ObservableList<Integer> idList1, ObservableList<Integer> idList2,  TextField subjectField,TextField lectureField,TextField weekNumField, TextField idField, int beforeId) {
		String errorMessage = "";
		int weekNum = Integer.parseInt(weekNumField.getText());
		int id = Integer.parseInt(idField.getText());
		if (subjectField.getText() == null || subjectField.getText().length() == 0) {
			errorMessage += "No valid Subject!\n";
		}
		if (lectureField.getText() == null || lectureField.getText().length() == 0) {
			errorMessage += "No valid Lecturer!\n";
		}
		if (weekNum > 2 || weekNum < 0) {
			errorMessage += "No valid number of week!\n";
		}
		if (beforeId != id  && idList1.contains(id) && !idList1.contains(id)) {
			errorMessage += "e1 Id: " + id + " Contains in this day!\n";
		}
		if (beforeId != id  && idList2.contains(id) && !idList2.contains(id)) {
			errorMessage += "e2 Id: " + id + " Contains in this day!\n";
		}
		if (errorMessage.length() == 0) {
			return true;
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(owner);
			alert.setTitle("Invalid Fields");
			alert.setHeaderText("Please correct invalid fields");
			alert.setContentText(errorMessage);
			alert.showAndWait();
			return false;
		}
	}
}
