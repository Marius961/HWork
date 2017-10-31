package HW.models;

public class Theme {
	private String name;
	private String url;
	private int themeId;
	public Theme(String name, String url, int id) {
		this.name = name;
		this.url = url;
		this.themeId = id;
	}
	
	public String getName() {
		return name;
	}
	public String getUrl() {
		return url;
	}

	public int getThemeId() {
		return themeId;
	}

	public void setThemeId(int themeId) {
		this.themeId = themeId;
	}

	
	
}
