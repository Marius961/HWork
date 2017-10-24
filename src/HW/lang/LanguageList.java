package HW.lang;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class LanguageList {
	ObservableList<Language> langList = FXCollections.observableArrayList();
	
	public LanguageList() {
		langList.add(new Language("English"));
		langList.add(new Language("Ukrainian"));
		initUkrainianLang();
		initEnglishLang();
	}

	private void initUkrainianLang() {		
		langList.get(1).getMainViewLang().setTopButton("Вверх");
		langList.get(1).getMainViewLang().setBottomButton("Вниз");				
		langList.get(1).getMainViewLang().setEditButton("Редагувати");
		langList.get(1).getMainViewLang().setAddButton("Додати");				
		langList.get(1).getMainViewLang().setDeleteButton("Видалити");	
		
		langList.get(1).getMainViewLang().setFirstWeek("1-ий тиждень");
		langList.get(1).getMainViewLang().setSecondWeek("2-ий тиждень");
		
		langList.get(1).getMainViewLang().setColLecture("Викладач");
		langList.get(1).getMainViewLang().setColSubject("Предмет");
		
		langList.get(1).getMainViewLang().setDayName("День");
		langList.get(1).getMainViewLang().setFirstLabelTime("");		
		langList.get(1).getMainViewLang().setSecondLabelTime("");
		langList.get(1).getMainViewLang().setThirdLabelTime("");
		langList.get(1).getMainViewLang().setFourthLabelTime("");
		langList.get(1).getMainViewLang().setFifthLabelTime("");
		
		langList.get(1).getEditDialog().setCancelButton("Скасувати");
		langList.get(1).getEditDialog().setLectureLabel("Викладач");
		langList.get(1).getEditDialog().setOkButton("OK");
		langList.get(1).getEditDialog().setSubjectLabel("Предмет");
		
	}
	private void initEnglishLang() {
		langList.get(0).getMainViewLang().setTopButton("Up");
		langList.get(0).getMainViewLang().setBottomButton("Down");				
		langList.get(0).getMainViewLang().setEditButton("Edit");
		langList.get(0).getMainViewLang().setAddButton("Add");				
		langList.get(0).getMainViewLang().setDeleteButton("Delete");	
		
		langList.get(0).getMainViewLang().setFirstWeek("1st week");
		langList.get(0).getMainViewLang().setSecondWeek("2nd week");
		
		langList.get(0).getMainViewLang().setColLecture("Lecture");
		langList.get(0).getMainViewLang().setColSubject("Subject");
		
		langList.get(0).getMainViewLang().setDayName("Day");
		langList.get(0).getMainViewLang().setFirstLabelTime("");		
		langList.get(0).getMainViewLang().setSecondLabelTime("");
		langList.get(0).getMainViewLang().setThirdLabelTime("");
		langList.get(0).getMainViewLang().setFourthLabelTime("");
		langList.get(0).getMainViewLang().setFifthLabelTime("");
		
		langList.get(0).getEditDialog().setCancelButton("Cancel");
		langList.get(0).getEditDialog().setLectureLabel("Lecture");
		langList.get(0).getEditDialog().setOkButton("OK");
		langList.get(0).getEditDialog().setSubjectLabel("Subject");
	}
	
	
	public Language getLanguage(String name) {
		if (name == "English") {	
			return langList.get(0);
		}
		if (name == "Ukrainian") {	
			return langList.get(1);
		}
		return null;
	}
	
	public Language getLanguage(int ind) {
		return langList.get(ind);
	}
	
}
