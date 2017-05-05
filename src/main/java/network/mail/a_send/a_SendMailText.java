package network.mail.a_send;

import network.mail.MailPropertiesConfig;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class a_SendMailText {

    public static void main(String[] args) {
        a_SendMailText sendMailText = new a_SendMailText();

        List<String> recipients = Arrays.asList("marcuschiu9@gmail.com");
        String subject = "custom subject";
        String text = "The JavaMail API provides a platform-independent and protocol-independent framework to build network.mail and messaging applications.";

        boolean sent = sendMailText.sendEmailTLS(recipients, subject, text);

        if(sent) {
            System.out.println("email successfully sent to: " + recipients.get(0));
        } else {
            System.out.println("email failed to a_send to: " + recipients.get(0));
        }
    }

    private static final boolean activated = true;

    private static final String username = MailPropertiesConfig.getProperties().getProperty("username");

    private static final String password = MailPropertiesConfig.getProperties().getProperty("password");

    private static final String from = "davids.closet@kibocommerce.com";

    /**
     * Send email via ssl TODO (not working)
     * @param recipients - list of email addresses
     * @param subject - subject
     * @param text - text
     * @return boolean - whether email was sent
     */
    public boolean sendEmailSSL(List<String> recipients, String subject, String text) {
        if(!activated) return true;

        Properties props = new Properties();
        props.put("network.mail.smtp.host", "smtp.gmail.com");
        props.put("network.mail.smtp.socketFactory.port", "465");
        props.put("network.mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("network.mail.smtp.auth", "true");
        props.put("network.mail.smtp.port", "465");

        return sendEmail(props, recipients, subject, text);
    }

    /**
     * Send email via tls
     * @param recipients - list of email addresses
     * @param subject - subject
     * @param text - text
     * @return boolean - whether email was sent
     */
    public boolean sendEmailTLS(List<String> recipients, String subject, String text) {
        if(!activated) return true;

        Properties props = new Properties();
//        props.put("network.mail.smtp.auth", "true");
//        props.put("network.mail.smtp.starttls.enable", "true");
//        props.put("network.mail.smtp.host", "smtp.gmail.com");
//        props.put("network.mail.smtp.port", "587");

        // for some reason this works instead of the ones above
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        return sendEmail(props, recipients, subject, text);
    }

    /**
     * sends the email
     * @param props - properties of email
     * @param recipients - list of email addresses
     * @param subject - subject
     * @param text - text
     * @return boolean - whether email was sent or not
     */
    private boolean sendEmail(Properties props, List<String> recipients, String subject, String text) {
        // Get the Session object.
        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            // Create a default MimeMessage object.
            Message message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            for (String recipient : recipients) {
                message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
            }

            // Set Subject: header field
            message.setSubject(subject);

            // Set the actual message
            message.setText(text);

            // Send the message
            Transport.send(message);

            return true;
        } catch (MessagingException e) {
            return false;
        }
    }
}
