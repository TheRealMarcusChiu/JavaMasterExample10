package xml.jaxb;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Data
@XmlRootElement
@XmlType(propOrder = {"street", "city"})
public class Address {

    private String street;
    private String city;
}
