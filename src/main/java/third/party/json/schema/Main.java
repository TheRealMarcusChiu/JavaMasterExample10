package third.party.json.schema;

import org.everit.json.schema.Schema;
import org.everit.json.schema.SchemaException;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;

/**
 * http://www.baeldung.com/introduction-to-json-schema-in-java
 <dependency>
     <groupId>org.everit.json</groupId>
     <artifactId>org.everit.json.schema</artifactId>
     <version>1.3.0</version>
 </dependency>
 */
public class Main {

    public static void main( String[] args )
    {
        JSONObject jsonSchema = new JSONObject("{\n" +
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
                "            \"exclusiveMinimum\": tre\n" +
                "        }\n" +
                "    },\n" +
                "    \"required\": [\"id\", \"name\", \"price\"]\n" +
                "}");

        JSONObject jsonSubject = new JSONObject("{\n" +
                "    \"id\": 1,\n" +
                "    \"name\": \"Lampshade\",\n" +
                "    \"price\": 0\n" +
                "}");

        try {
            // this validates the jsonSchema based on $schema property
            Schema schema = SchemaLoader.load(jsonSchema);

            // validate json subject against custom json schema
            schema.validate(jsonSubject);
        }
        catch (SchemaException e) {
            // custom json schema failed $schema definition
            System.out.println(e.getMessage());
        }
        catch (ValidationException e) {
            // json subject failed custom json schema
            System.out.println(e.getMessage());
        }
    }
}
