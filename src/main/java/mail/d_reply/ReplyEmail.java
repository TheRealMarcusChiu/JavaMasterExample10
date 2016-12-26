package mail.d_reply;

import mail.MailPropertiesConfig;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Properties;

public class ReplyEmail {

    private static final String username = MailPropertiesConfig.getProperties().getProperty("username");

    private static final String password = MailPropertiesConfig.getProperties().getProperty("password");

    public static void main(String args[]) {
        Properties properties = new Properties();
        properties.put("mail.store.protocol", "pop3");

        properties.put("mail.pop3s.host", "pop.gmail.com");
        properties.put("mail.pop3s.port", "995");
        properties.put("mail.pop3.starttls.enable", "true");

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getDefaultInstance(properties);
        // session.setDebug(true);

        try {
            // Get a Store object and connect to the current host
            Store store = session.getStore("pop3s");
            store.connect("pop.gmail.com", username, password);//change the user and password accordingly

            Folder folder = store.getFolder("inbox");
            if (!folder.exists()) {
                System.out.println("inbox not found");
                System.exit(0);
            }
            folder.open(Folder.READ_ONLY);

            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    System.in));

            Message[] messages = folder.getMessages();
            if (messages.length != 0) {

                for (int i = 0, n = messages.length; i < n; i++) {
                    Message message = messages[i];

                    // Get all the information from the message
                    String from = InternetAddress.toString(message.getFrom());
                    if (from != null) {
                        System.out.println("From: " + from);
                    }
                    String replyTo = InternetAddress.toString(message.getReplyTo());
                    if (replyTo != null) {
                        System.out.println("Reply-to: " + replyTo);
                    }
                    String to = InternetAddress.toString(message.getRecipients(Message.RecipientType.TO));
                    if (to != null) {
                        System.out.println("To: " + to);
                    }
                    String subject = message.getSubject();
                    if (subject != null) {
                        System.out.println("Subject: " + subject);
                    }
                    Date sent = message.getSentDate();
                    if (sent != null) {
                        System.out.println("Sent: " + sent);
                    }

                    System.out.print("Do you want to reply [y/n] : ");
                    String ans = reader.readLine();
                    if ("Y".equals(ans) || "y".equals(ans)) {

                        // reply back
                        reply(session, message, to, "Thanks");
                        System.out.println("message replied successfully");

                        // close the store and folder objects
                        folder.close(false);
                        store.close();

                    } else if ("n".equals(ans)) {
                        break;
                    }
                }
            } else {
                System.out.println("There is no msg....");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void reply(Session session, Message message, String from, String text) throws MessagingException {
        Message replyMessage = message.reply(false);
        replyMessage.setFrom(new InternetAddress(from));
        replyMessage.setText(text);
        replyMessage.setReplyTo(message.getReplyTo());

        // Send the message by authenticating the SMTP server
        // Create a Transport instance and call the sendMessage
        Transport t = session.getTransport("smtp");
        try {
            //connect to the smtp server using transport instance
            //change the user and password accordingly
            t.connect(username, password);
            t.sendMessage(replyMessage, replyMessage.getAllRecipients());
        } finally {
            t.close();
        }
    }
}
