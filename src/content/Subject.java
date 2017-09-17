package content;

public class Subject  {
 
    private int id;
    private String name;
    private String lect;
    private String homework = " ";
 
    public Subject(int id, String name, String lect) {
        this.id = id;
        this.name = name;
        this.lect = lect;
    }
    
    
 
    public Subject() {
    }
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
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
