package native_java.network.mail.b_checking_and_fetching;

import native_java.network.mail.MailPropertiesConfig;

import javax.mail.*;
import java.util.Properties;

public class CheckingEmail {

    // displays only unread emails
    public static void main(String[] args) {
        String host = "pop.gmail.com";// change accordingly
        String mailStoreType = "pop3";
        String username = MailPropertiesConfig.getProperties().getProperty("username");// change accordingly
        String password = MailPropertiesConfig.getProperties().getProperty("password");// change accordingly

        check(host, mailStoreType, username, password);
    }

    public static void check(String host, String storeType, String user, String password) {
        try {
            //create properties field
            Properties properties = new Properties();
            properties.put("network.mail.pop3.host", host);
            properties.put("network.mail.pop3.port", "995");
            properties.put("network.mail.pop3.starttls.enable", "true");
            Session emailSession = Session.getDefaultInstance(properties);

            //create the POP3 store object and connect with the pop server
            Store store = emailSession.getStore("pop3s");

            store.connect(host, user, password);

            //create the folder object and open it
            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);

            // retrieve the messages from the folder in an array and print it
            Message[] messages = emailFolder.getMessages();
            System.out.println("messages.length---" + messages.length);

            for (int i = 0, n = messages.length; i < n; i++) {
                Message message = messages[i];
                System.out.println("---------------------------------");
                System.out.println("Email Number " + (i + 1));
                System.out.println("Subject: " + message.getSubject());
                System.out.println("From: " + message.getFrom()[0]);
                System.out.println("Text: " + message.getContent().toString());

            }

            //close the store and folder objects
            emailFolder.close(false);
            store.close();

        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
