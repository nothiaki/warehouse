package warehouse.ms_category.app.shared;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class JsonManager {

  @Autowired
  private ObjectMapper objectMapper;
  
  public String objectToJson(Object obj) {
    try {
      return objectMapper.writeValueAsString(obj);
    } catch (Exception e) {
      throw new RuntimeException("Error while convert object to JSON", e);
    }
  }

  public <T> T jsonToObject(String str, Class<T> clazz) {
    try {
      return objectMapper.readValue(str, clazz);
    } catch (Exception e) {
      throw new RuntimeException("Error while convert JSON to object", e);
    }
  }

}
