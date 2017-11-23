package HW.models;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import javafx.collections.ObservableList;

public class Converter {
	
	 private static final String dataBaseFile = "week.json";
	 private static final String propertiesBaseFile = "properties.json";
	 
	public static void toJson(Week week)  {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
	    	List<ObservableList<Subject>> personList = Stream.of(
					week.selectDay(0).get(),
					week.selectDay(1).get(),
					week.selectDay(2).get(),
					week.selectDay(3).get(),
					week.selectDay(4).get())
					.collect(Collectors.toList());   	
	    	objectMapper.writeValue(new File(dataBaseFile), personList);
		} catch (IOException e3) {
			e3.printStackTrace();
		}
    	
   }
	
	public static void toJson(PropertiesContainer properties) throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();		
		objectMapper.writeValue(new File(propertiesBaseFile), properties);
	}

   public static Week dataToJavaObject() {
	   ObjectMapper mapper = new ObjectMapper();      
	   try {
		   List<List<Subject>> list = mapper.readValue(new File(dataBaseFile),
				   new TypeReference<List<List<Subject>>>() {});
		   System.out.println("Data loaded");
		   return new Week(
				   new Day(list.get(0), "Mn"),
				   new Day(list.get(1), "Tu"),
				   new Day(list.get(2), "We"),
				   new Day(list.get(3), "Th"),
				   new Day(list.get(4), "Fr")
				   ); 
	   } catch (IOException e) {
		   return new Week();
	   }
   }
   public static PropertiesContainer propertiesToJavaObject() {
	      ObjectMapper mapper = new ObjectMapper();
	      try {		      
	    	  return mapper.readValue(new File(propertiesBaseFile), PropertiesContainer.class);
	      } catch (IOException e) {
	    	  return new PropertiesContainer();			
	      } 

   }
}
