
package HW.models;

import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class InputValidator {
	
	public boolean isInputValid(Stage owner,ObservableList<Integer> idList1, ObservableList<Integer> idList2,  TextField subjectField,TextField lectureField,ChoiceBox<Integer> weekNumField, ChoiceBox<Integer> idField, int beforeId, boolean isOnPosition) {
		String errorMessage = "";
		int weekNum = weekNumField.getSelectionModel().getSelectedItem();
		int id = idField.getSelectionModel().getSelectedItem();
		if (subjectField.getText() == null || subjectField.getText().length() == 0) {
			errorMessage += "No valid Subject!\n";
		}
		if (lectureField.getText() == null || lectureField.getText().length() == 0) {
			errorMessage += "No valid Lecturer!\n";
		}
		if (weekNum > 2 || weekNum < 0) {
			errorMessage += "No valid number of week!\n";
		}
		System.out.println(id + " " + isOnPosition);
		if (weekNum == 1 &&idList1.contains(id) && isOnPosition == false) {
			errorMessage += "e1 Id: " + id + " Contains in this day!\n";
		}
		if (weekNum == 2 && idList2.contains(id) && isOnPosition == false) {
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
