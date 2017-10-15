package HW.models;

public class Subject1 {
	
	private String name;
	private String lect;
	private String homework;
	
	public Subject1() {
	}
	
	public Subject1(String name, String lect) {
		this.name = name;
		this.lect = lect;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLect() {
		return lect;
	}

	public void setLect(String lect) {
		this.lect = lect;
	}

	public String getHomework() {
		return homework;
	}

	public void setHomework(String homework) {
		this.homework = homework;
	}
	
}
