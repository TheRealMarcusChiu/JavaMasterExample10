package xml.jaxb;

import org.junit.Test;
import org.testng.Assert;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 * Examples to Marshall an object into XML
 */
public class MarshallerMain {

    /**
     * The marshal operation is used to convert objects to XML.  In addition to producing the XML,
     * a JAXB implementation will handle the escaping of special characters:
     * - " to &quot;
     * - & to &amp;
     * - < to &lt;
     * - > to &gt;
     * @throws JAXBException
     */
    @Test
    public void objectToXML() throws JAXBException {
        Address address = new Address();
        address.setCity("Plano");
        address.setStreet("2912 Winding Creek Drive - \"&<>");

        Marshaller marshaller = JAXBContext.newInstance(Address.class).createMarshaller();

        // convert object to xml
        StringWriter sw = new StringWriter();
        marshaller.marshal(address, sw);

        Assert.assertEquals(
            "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><address><street>2912 Winding Creek Drive - \"&amp;&lt;&gt;</street><city>Plano</city></address>",
            sw.toString(), 
            "doesn't match");
    }

    /**
     * By default JAXB will include the XML header.  If you want to marshal contents into an
     * XML stream that is also being populated from other sources you can tell JAXB to omit
     * the header by setting the Marshaller.JAXB_FRAGMENT property to true on the Marshaller.
     * @throws JAXBException
     */
    @Test
    public void noXMLHeader() throws JAXBException {
        Address address = new Address();
        address.setCity("Plano");
        address.setStreet("2912 Winding Creek Drive - \"&<>");

        Marshaller marshaller = JAXBContext.newInstance(Address.class).createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);

        // convert object to xml
        StringWriter sw = new StringWriter();
        marshaller.marshal(address, sw);

        Assert.assertEquals(
            "<address><street>2912 Winding Creek Drive - \"&amp;&lt;&gt;</street><city>Plano</city></address>",
            sw.toString(), 
            "doesn't match");
    }

    /**
     * By default JAXB will not format the XML document.  This is done to save space,
     * and not introduce any whitespace that may accidentally be interpreted as being significant.
     */
    @Test
    public void formatXML() throws JAXBException {
        Address address = new Address();
        address.setCity("Plano");
        address.setStreet("2912 Winding Creek Drive - \"&<>");

        Marshaller marshaller = JAXBContext.newInstance(Address.class).createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        // convert object to xml
        StringWriter sw = new StringWriter();
        marshaller.marshal(address, sw);

        Assert.assertEquals(
            sw.toString(),
            "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
            "<address>\n" +
            "    <street>2912 Winding Creek Drive - \"&amp;&lt;&gt;</street>\n" +
            "    <city>Plano</city>\n" +
            "</address>\n", 
            "doesn't match");
    }

    /**
     * JAXB defaults the encoding to UTF-8.
     * You can specify an alternate encoding by setting the Marshaller.JAXB_Encoding property on the Marshaller.
     */
    @Test
    public void setEncoding() throws JAXBException {
        Address address = new Address();
        address.setCity("Plano");
        address.setStreet("2912 Ànding Cr៹k ⸎rive");

        Marshaller marshaller = JAXBContext.newInstance(Address.class).createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "US-ASCII");

        // convert object to xml
        StringWriter sw = new StringWriter();
        marshaller.marshal(address, sw);

        Assert.assertEquals(
            sw.toString(),
            "<?xml version=\"1.0\" encoding=\"US-ASCII\" standalone=\"yes\"?>\n" +
            "<address>\n" +
            "    <street>2912 &#192;nding Cr&#6137;k &#11790;rive</street>\n" +
            "    <city>Plano</city>\n" +
            "</address>\n",
            "doesn't match");
    }
}
