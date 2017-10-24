package HW.lang;


public class Language {
	private String name;
	MainViewLang mainViewLang = new MainViewLang();
	EditDialog editDialog = new EditDialog();
	
	public Language(String name) {
		this.name = name;
	}

	public MainViewLang getMainViewLang() {
		return mainViewLang;
	}

	public void setMainViewLang(MainViewLang mainViewLang) {
		this.mainViewLang = mainViewLang;
	}

	public String getName() {
		return name;
	}

	public EditDialog getEditDialog() {
		return editDialog;
	}

	public void setEditDialog(EditDialog editDialog) {
		this.editDialog = editDialog;
	}
	
}
