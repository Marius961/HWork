package HW.models;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Converter {
	
	 private final static String baseFile = "week.json";
	 
	public static void toJSON(Week week) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(baseFile), week);
        System.out.println("json created!");
    }
 
    public static Week toJavaObject() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(baseFile), Week.class);
    }
}
