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
		langList.get(1).getMainViewLang().dayAdd("��","��","��","��","��");
		langList.get(1).getMainViewLang().setEditButton("����������");
		langList.get(1).getMainViewLang().setAddButton("������");				
		langList.get(1).getMainViewLang().setDeleteButton("��������");	
		
		langList.get(1).getMainViewLang().setFirstWeek("1-�� �������");
		langList.get(1).getMainViewLang().setSecondWeek("2-�� �������");
		
		langList.get(1).getMainViewLang().setColLecture("��������");
		langList.get(1).getMainViewLang().setColSubject("�������");
		
		langList.get(1).getMainViewLang().setDayName("����");
		langList.get(1).getMainViewLang().setFirstLabelTime("");		
		langList.get(1).getMainViewLang().setSecondLabelTime("");
		langList.get(1).getMainViewLang().setThirdLabelTime("");
		langList.get(1).getMainViewLang().setFourthLabelTime("");
		langList.get(1).getMainViewLang().setFifthLabelTime("");
		
		langList.get(1).getEditDialog().setCancelButton("���������");
		langList.get(1).getEditDialog().setLectureLabel("��������");
		langList.get(1).getEditDialog().setOkButton("OK");
		langList.get(1).getEditDialog().setSubjectLabel("�������");
		
		langList.get(1).getHomeworkEditDialog().setCancelButton("���������");
		langList.get(1).getHomeworkEditDialog().setCleanButton("��������");
		langList.get(1).getHomeworkEditDialog().setHomeworkLabel("������ ��������:");
		langList.get(1).getHomeworkEditDialog().setSaveButton("��������");
		
		langList.get(1).getPropertiesDialog().setAppearanceLabel("³����������:");
		langList.get(1).getPropertiesDialog().setCancelButton("���������");
		langList.get(1).getPropertiesDialog().setDefaultButton("�� �������������");
		langList.get(1).getPropertiesDialog().setDisplayTimePickers("���������� ���");
		langList.get(1).getPropertiesDialog().setExportButton("�������");
		langList.get(1).getPropertiesDialog().setGeneral("�������:");
		langList.get(1).getPropertiesDialog().setIeLabel("������ ��� ������� �����������:");
		langList.get(1).getPropertiesDialog().setImportButton("������");
		langList.get(1).getPropertiesDialog().setLanguageLabel("����:");
		langList.get(1).getPropertiesDialog().setSaveButton("��������");
		langList.get(1).getPropertiesDialog().setThemeLabel("����:");
		langList.get(1).getPropertiesDialog().setWeeksLabel("2 ��������/1 �������� �������:");
		langList.get(1).getPropertiesDialog().setLanguage1("���������");
		langList.get(1).getPropertiesDialog().setLanguage2("����������");
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
		langList.get(0).getPropertiesDialog().setWeeksLabel("2 weeks/1 week shedule:");
		langList.get(0).getPropertiesDialog().setLanguage2("Ukrainian");
		langList.get(0).getPropertiesDialog().setLanguage1("English");
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
