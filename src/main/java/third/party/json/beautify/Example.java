package third.party.json.beautify;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

import java.io.IOException;

/**
 <dependency>
     <groupId>com.fasterxml.jackson.core</groupId>
     <artifactId>jackson-core</artifactId>
     <version>2.6.1</version>
 </dependency>
 <dependency>
     <groupId>com.fasterxml.jackson.core</groupId>
     <artifactId>jackson-databind</artifactId>
     <version>2.6.1</version>
 </dependency>
 */
public class Example {
    public static void main(String args[]) throws IOException {
        String json = "{\n" +
                "    \"$schema\": \"http://json-schema.org/draft-04/schema#\",\n" +
                "    \"title\": \"Product\",\n" +
                "    \"description\": \"A product from the catalog\",\n" +
                "    \"type\": \"object\",\n" +
                "    \"properties\": {\n" +
                "        \"id\": {\n" +
                "            \"description\": \"The unique identifier for a product\",\n" +
                "            \"type\": \"integer\"\n" +
                "        },\n" +
                "        \"name\": {\n" +
                "            \"description\": \"Name of the product\",\n" +
                "            \"type\": \"string\"\n" +
                "        },\n" +
                "        \"price\": {\n" +
                "            \"type\": \"number\",\n" +
                "            \"minimum\": 0,\n" +
                "            \"exclusiveMinimum\": true\n" +
                "        }\n" +
                "    },\n" +
                "    \"required\": [\"id\", \"name\", \"price\"]\n" +
                "}";

        ObjectMapper mapper = new ObjectMapper();
        Object obj = mapper.readValue(json, Object.class);
        String beautify = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);

        System.out.println(beautify);

        JSONObject jsonObject = new JSONObject(json);
        String jsonString = jsonObject.toString();
        System.out.println(jsonString);
    }
}
