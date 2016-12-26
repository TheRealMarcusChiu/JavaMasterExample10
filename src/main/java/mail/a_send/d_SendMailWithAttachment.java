package mail.a_send;

import mail.MailPropertiesConfig;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class d_SendMailWithAttachment {

    private static final String workingDirectory = System.getProperty("user.dir");
    private static final String resourceFolder = workingDirectory + "/src/main/resources/";
    private static final String targetFilePath = resourceFolder + "dummy_attachment.txt";

    public static void main(String[] args) {
        d_SendMailWithAttachment sendMailWithAttachment = new d_SendMailWithAttachment();

        List<String> recipients = Arrays.asList("marcuschiu9@gmail.com");
        String subject = "custom subject";
        String text = "The JavaMail API provides a platform-independent and protocol-independent framework to build mail and messaging applications.";
        File file = new File(targetFilePath);

        boolean sent = sendMailWithAttachment.sendEmailTLS(recipients, subject, text, file);

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
    public boolean sendEmailSSL(List<String> recipients, String subject, String text, File file) {
        if(!activated) return true;

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        return sendEmail(props, recipients, subject, text, file);
    }

    /**
     * Send email via tls
     * @param recipients - list of email addresses
     * @param subject - subject
     * @param text - text
     * @return boolean - whether email was sent
     */
    public boolean sendEmailTLS(List<String> recipients, String subject, String text, File file) {
        if(!activated) return true;

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        return sendEmail(props, recipients, subject, text, file);
    }

    /**
     * sends the email
     * @param props - properties of email
     * @param recipients - list of email addresses
     * @param subject - subject
     * @param text - text
     * @return boolean - whether email was sent or not
     */
    private boolean sendEmail(Properties props, List<String> recipients, String subject, String text, File file) {
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

            // Create the message part
            BodyPart bodyPart = new MimeBodyPart();

            // Now set the actual message
            bodyPart.setText(text);

            // Create a multipart message
            Multipart multipart = new MimeMultipart();

            // Set text message part
            multipart.addBodyPart(bodyPart);

            // Prepare file attachment
            bodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(file);
            bodyPart.setDataHandler(new DataHandler(source));
            bodyPart.setFileName(file.getName());

            // Set file message part
            multipart.addBodyPart(bodyPart);

            // Send the complete message parts
            message.setContent(multipart);

            // Send the message
            Transport.send(message);

            return true;
        } catch (MessagingException e) {
            return false;
        }
    }
}
