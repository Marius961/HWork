package HW.lang;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class LanguageList {
	ObservableList<Language> langList = FXCollections.observableArrayList();
	
	public LanguageList() {
		langList.add(new Language());
		langList.add(new Language());
		initUkrainianLang();
		initEnglishLang();
	}

	private void initUkrainianLang() {	
		langList.get(1).getMainViewLang().dayAdd("Пн","Вт","Ср","Чт","Пт");
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
		
		langList.get(1).getHomeworkEditDialog().setCancelButton("Скасувати");
		langList.get(1).getHomeworkEditDialog().setCleanButton("Очистити");
		langList.get(1).getHomeworkEditDialog().setHomeworkLabel("Домашнє завдання:");
		langList.get(1).getHomeworkEditDialog().setSaveButton("Зберегти");
		
		langList.get(1).getPropertiesDialog().setAppearanceLabel("Відображення:");
		langList.get(1).getPropertiesDialog().setCancelButton("Скасувати");
		langList.get(1).getPropertiesDialog().setDefaultButton("За замовчуванням");
		langList.get(1).getPropertiesDialog().setDisplayTimePickers("Показувати час");
		langList.get(1).getPropertiesDialog().setExportButton("Експорт");
		langList.get(1).getPropertiesDialog().setGeneral("Основне:");
		langList.get(1).getPropertiesDialog().setIeLabel("Імпорт або експорт налаштувань:");
		langList.get(1).getPropertiesDialog().setImportButton("Імпорт");
		langList.get(1).getPropertiesDialog().setLanguageLabel("Мова:");
		langList.get(1).getPropertiesDialog().setSaveButton("Зберегти");
		langList.get(1).getPropertiesDialog().setThemeLabel("Тема:");
		langList.get(1).getPropertiesDialog().setLanguage1("Англійська");
		langList.get(1).getPropertiesDialog().setLanguage2("Україньська");
		langList.get(1).getPropertiesDialog().setTwoWeeksShedule("two weeks shedule");
	}
	private void initEnglishLang() {
		langList.get(0).getMainViewLang().dayAdd("Mn","Tu","We","Th","Fr");
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
		
		langList.get(0).getHomeworkEditDialog().setCancelButton("Cancel");
		langList.get(0).getHomeworkEditDialog().setCleanButton("Clean");
		langList.get(0).getHomeworkEditDialog().setHomeworkLabel("Homework:");
		langList.get(0).getHomeworkEditDialog().setSaveButton("Save");
		
		langList.get(0).getPropertiesDialog().setAppearanceLabel("Appearance");
		langList.get(0).getPropertiesDialog().setCancelButton("Cancel");
		langList.get(0).getPropertiesDialog().setDefaultButton("Default");
		langList.get(0).getPropertiesDialog().setDisplayTimePickers("DisplayTime");
		langList.get(0).getPropertiesDialog().setExportButton("Export");
		langList.get(0).getPropertiesDialog().setGeneral("General");
		langList.get(0).getPropertiesDialog().setIeLabel("Import or export settings:");
		langList.get(0).getPropertiesDialog().setImportButton("Import");
		langList.get(0).getPropertiesDialog().setLanguageLabel("Language:");
		langList.get(0).getPropertiesDialog().setSaveButton("Save");
		langList.get(0).getPropertiesDialog().setThemeLabel("Theme:");
		langList.get(0).getPropertiesDialog().setLanguage2("Ukrainian");
		langList.get(0).getPropertiesDialog().setLanguage1("English");
		langList.get(1).getPropertiesDialog().setTwoWeeksShedule("2 тижневий розклад");
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
