package HW.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Language {
	private ObservableList<Language> parts = FXCollections.observableArrayList();
	
	public void add(LanguagePart part) {
		parts.add(part);
	}
	
	public void delete(int ind) {
		parts.remove(ind);
	}
}
