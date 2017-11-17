package HW.models;

import java.util.LinkedList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ThemeList {
	private final List<Theme> themes = new LinkedList<>();
	
	public ThemeList() {
		themes.add(new Theme("Classic", "../styles/ClassicTheme.css", 0));
		themes.add(new Theme("Dark", "../styles/DarkTheme.css", 1));
	}
	public Theme get(int ind) {
		return themes.get(ind);
	}
}
