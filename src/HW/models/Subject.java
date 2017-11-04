package HW.models;

public class Subject {
	
	private String name;
	private String lect;
	private String homework;
	private int weekNum;
	private int id;
	
	public Subject() {
	}
	
	public Subject(int id,int weekNum, String name, String lect) {
		this.name = name;
		this.lect = lect;
		this.id = id;
		this.weekNum = weekNum;
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

	public int getWeekNum() {
		return weekNum;
	}

	public void setWeeknum(int weekNum) {
		this.weekNum = weekNum;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}	
	
	
}
