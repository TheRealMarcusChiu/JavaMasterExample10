package third.party.xml.jaxb;

import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

/**
 * Examples to UnMarshall an XML into Object
 */
public class UnMarshallerMain {

    /**
     * The unmarshal operation is used to convert XML to objects.
     * - &quot; to "
     * - &amp;  to &
     * - &lt;  to <
     * - &gt;   to >
     * @throws JAXBException
     */
    @Test
    public void xmlToObject() throws JAXBException {
        StringReader reader = new StringReader(
                "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<address>\n" +
                "    <street>2912 Winding Creek Drive - \"&amp;&lt;&gt;</street>\n" +
                "    <city>Plano</city>\n" +
                "</address>");

        Unmarshaller unmarshaller = JAXBContext.newInstance(Address.class).createUnmarshaller();
        Address address = (Address) unmarshaller.unmarshal(reader);

        System.out.println(address.toString());
    }
}
