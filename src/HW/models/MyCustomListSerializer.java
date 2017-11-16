package HW.models;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class MyCustomListSerializer extends JsonSerializer<Day>{
	
	@Override
    public void serialize(Day value, JsonGenerator jgen, SerializerProvider provider)
      throws IOException, JsonProcessingException {
        jgen.writeStartArray();
        for(Object o : value.get()){
            jgen.writeStartObject();
            jgen.writeObject(o);
            jgen.writeEndObject();
        }
        jgen.writeEndArray();
    }
}
