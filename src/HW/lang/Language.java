package HW.lang;


public class Language {
	private int langId = 0;
	
	private MainViewLang mainViewLang = new MainViewLang();	
	private EditDialog editDialog = new EditDialog();	
	private HomeworkEditDialogLang HomeworkEditDialog = new HomeworkEditDialogLang();
	private PropertiesDialogLang propertiesDialog = new PropertiesDialogLang();
	

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
