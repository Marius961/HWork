package HW.models;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.lang.model.type.ReferenceType;

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
	
	 private final static String baseFile = "week.json";
	 
	public static void toJSON(Week week) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();

    	objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    	List<ObservableList<Subject>> personList = Stream.of(
				week.selectDay(0).get(),
				week.selectDay(1).get(),
				week.selectDay(2).get(),
				week.selectDay(3).get(),
				week.selectDay(4).get())
				.collect(Collectors.toList());
    	
    	objectMapper.writeValue(new File(baseFile), personList);
    	System.out.println("Week saved to JSON!");
   }

   public static Week toJavaObject() throws JsonParseException, JsonMappingException, IOException {
      ObjectMapper mapper = new ObjectMapper();
      final List<List<Subject>> list = mapper.readValue(new File(baseFile),
              new TypeReference<List<List<Subject>>>() {});
      Week tempWeek = new Week(
    		  	new Day(list.get(0), "Mn"),
    		  	new Day(list.get(1), "Tu"),
    		  	new Day(list.get(2), "We"),
    		  	new Day(list.get(3), "Th"),
    		  	new Day(list.get(4), "Fr")
    		  );
      return tempWeek;
   }
}
