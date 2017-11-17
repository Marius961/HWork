package HW.models;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.lang.model.type.ReferenceType;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonMappingException.Reference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Converter {
	
	 private final static String dataBaseFile = "week.json";
	 private final static String propertiesBaseFile = "properties.json";
	 
	public static void toJson(Week week) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
    	objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    	List<ObservableList<Subject>> personList = Stream.of(
				week.selectDay(0).get(),
				week.selectDay(1).get(),
				week.selectDay(2).get(),
				week.selectDay(3).get(),
				week.selectDay(4).get())
				.collect(Collectors.toList());
    	
    	objectMapper.writeValue(new File(dataBaseFile), personList);
    	System.out.println("Data saved to JSON!");
   }
	
	public static void toJson(PropertiesContainer properties) throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.writeValue(new File(propertiesBaseFile), properties);
		System.out.println("Properties saved to JSON!");
	}

   public static Week dataToJavaObject() throws JsonParseException, JsonMappingException, IOException {
      ObjectMapper mapper = new ObjectMapper();
      List<List<Subject>> list = mapper.readValue(new File(dataBaseFile),
              new TypeReference<List<List<Subject>>>() {});
      return new Week(
    		  	new Day(list.get(0), "Mn"),
    		  	new Day(list.get(1), "Tu"),
    		  	new Day(list.get(2), "We"),
    		  	new Day(list.get(3), "Th"),
    		  	new Day(list.get(4), "Fr")
    		  );    
   }
   
   public static PropertiesContainer propertiesToJavaObject() {
	      ObjectMapper mapper = new ObjectMapper();
	      try {
		      
	    	  return mapper.readValue(new File(propertiesBaseFile), PropertiesContainer.class);
	      } catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Properties loaded!");
		}
		return null;  
	   }
}
