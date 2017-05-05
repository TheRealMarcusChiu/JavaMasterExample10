package third.party.json;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

public class Main {

    // Test encode then decode
    @Test
    public void main() {
        Example example = new Example();
        example.setId(1);
        example.setName("Test program");
        example.setNotInterestingMember("Don't care about this");
        example.setAnotherMember(100);
        example.setForgetThisField(-1);

        /////////////////
        // JSON encode //
        /////////////////
        String s = encode(example);
        System.out.println(s);


        /////////////////
        // JSON decode //
        /////////////////
        example = decode(s);
        System.out.println(example.toString());
    }

    // This would throw an error if the Example Class is not
    // annotated with '@JsonIgnoreProperties(ignoreUnknown = true)'
    @Test
    public void testWithUnknownParameters() {
        String jsonTest = "{\"UNKNOWN\":1}";
        Example example = decode(jsonTest);
        System.out.println(example.toString());
    }

    @Test
    public void testWithMultipleSameNamedParameters() {
        String jsonTest = "{\"forgetThisField\":-1,\"forgetThisField\":2}";
        Example example = decode(jsonTest);
        System.out.println(example.toString());
    }


    private static String encode(Example example) {
        String s = "";

        try {
            ObjectMapper mapper = new ObjectMapper();
            s = mapper.writeValueAsString(example);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return s;
    }

    private static Example decode(String s) {
        Example example = null;

        try {
            ObjectMapper mapper = new ObjectMapper();
            example = mapper.readValue(s, Example.class);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return example;
    }
}
