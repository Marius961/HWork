package HW.lang;


public class Language {
	private int langId = 0;
	MainViewLang mainViewLang = new MainViewLang();
	EditDialog editDialog = new EditDialog();
	HomeworkEditDialogLang HomeworkEditDialog = new HomeworkEditDialogLang();
	PropertiesDialogLang propertiesDialog = new PropertiesDialogLang();
	

	public MainViewLang getMainViewLang() {
		return mainViewLang;
	}

	public void setMainViewLang(MainViewLang mainViewLang) {
		this.mainViewLang = mainViewLang;
	}


	public EditDialog getEditDialog() {
		return editDialog;
	}

	public void setEditDialog(EditDialog editDialog) {
		this.editDialog = editDialog;
	}

	public HomeworkEditDialogLang getHomeworkEditDialog() {
		return HomeworkEditDialog;
	}

	public void setHomeworkEditDialog(HomeworkEditDialogLang homeworkEditDialog) {
		HomeworkEditDialog = homeworkEditDialog;
	}

	public PropertiesDialogLang getPropertiesDialog() {
		return propertiesDialog;
	}

	public void setPropertiesDialog(PropertiesDialogLang propertiesDialog) {
		this.propertiesDialog = propertiesDialog;
	}

	public int getLangId() {
		return langId;
	}

	public void setLangId(int langId) {
		this.langId = langId;
	}


	
	
}
