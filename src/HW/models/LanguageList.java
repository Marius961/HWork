package HW.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class LanguageList {
	private ObservableList<Language> languagelist = FXCollections.observableArrayList();
	
	public void add(Language lang) {
		languagelist.add(lang);
	}
	
	public void delete(int ind) {
		languagelist.remove(ind);
	}
}
