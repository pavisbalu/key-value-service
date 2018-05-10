package in.ashwanthkumar.restvideos.module2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UnirestTest {
    public static  void main(String[] args) throws UnirestException {
        Unirest.setObjectMapper(new ObjectMapper() {
            private com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper
                    = new com.fasterxml.jackson.databind.ObjectMapper();

            public <T> T readValue(String value, Class<T> valueType) {
                try {
                    return jacksonObjectMapper.readValue(value, valueType);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            public String writeValue(Object value) {
                try {
                    return jacksonObjectMapper.writeValueAsString(value);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Map<String,String> map=new HashMap<String,String>();
        map.put("key","23");
        map.put("value","555");
        //map.get("23");
        HttpResponse<String> setResponse = Unirest.post("http://localhost:8080/application/map/set")
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body(map)
                .asString();
        System.out.println(setResponse.getBody());
        final HttpResponse<String> response=Unirest.get("http://localhost:8080/application" +
                "/map/get?key=23").asString();
        System.out.println(response.getBody());
    }
}
