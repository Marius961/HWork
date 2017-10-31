package HW.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ThemeList {
	ObservableList<Theme> themes = FXCollections.observableArrayList();
	
	public ThemeList() {
		themes.add(new Theme("Classic", "styles/ClassicTheme.css", 0));
		themes.add(new Theme("Dark", "styles/DarkTheme.css", 1));
	}
	public Theme get(int ind) {
		return themes.get(ind);
	}
}
