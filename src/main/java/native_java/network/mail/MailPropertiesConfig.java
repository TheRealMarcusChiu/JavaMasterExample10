package native_java.network.mail;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MailPropertiesConfig {

    public static Properties getProperties() {
        Properties prop = new Properties();

        String targetPath = System.getProperty("user.dir") + "/src/main/resources/" + System.getProperty("user.name") + ".properties";
        try (InputStream input = new FileInputStream(targetPath)) {
            // load a properties file
            prop.load(input);

            // get the property value and print it out
            //System.out.println(prop.getProperty("database"));
            //System.out.println(prop.getProperty("dbuser"));
            //System.out.println(prop.getProperty("dbpassword"));
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("create a propeties file in resource folder named '" + System.getProperty("user.name") + ".properties'");
        }

        return prop;
    }
}
