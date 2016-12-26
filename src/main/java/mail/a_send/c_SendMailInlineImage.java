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

public class c_SendMailInlineImage {

    private static final String workingDirectory = System.getProperty("user.dir");
    private static final String resourceFolder = workingDirectory + "/src/main/resources/";
    private static final String targetFilePath = resourceFolder + "girl.jpg";

    public static void main(String[] args) {
        c_SendMailInlineImage sendMail = new c_SendMailInlineImage();

        List<String> recipients = Arrays.asList("marcuschiu9@gmail.com");
        String subject = "custom subject";
        String html = "<H1>Hello</H1><img src=\"cid:image\">";
        File file = new File(targetFilePath);

        boolean sent = sendMail.sendEmailTLS(recipients, subject, html, file);

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
     * @param html - html
     * @return boolean - whether email was sent
     */
    public boolean sendEmailSSL(List<String> recipients, String subject, String html, File file) {
        if(!activated) return true;

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        return sendEmail(props, recipients, subject, html, file);
    }

    /**
     * Send email via tls
     * @param recipients - list of email addresses
     * @param subject - subject
     * @param html - html
     * @return boolean - whether email was sent
     */
    public boolean sendEmailTLS(List<String> recipients, String subject, String html, File file) {
        if(!activated) return true;

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        return sendEmail(props, recipients, subject, html, file);
    }

    /**
     * sends the email
     * @param props - properties of email
     * @param recipients - list of email addresses
     * @param subject - subject
     * @param html - html
     * @return boolean - whether email was sent or not
     */
    private boolean sendEmail(Properties props, List<String> recipients, String subject, String html, File file) {
        // Get the Session object.
        Session session = Session.getDefaultInstance(props,
                new Authenticator() {
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

            // This mail has 2 part, the BODY and the embedded image
            MimeMultipart multipart = new MimeMultipart("related");

            // first part (the html)
            BodyPart bodyPart = new MimeBodyPart();
            bodyPart.setContent(html, "text/html");

            // add it
            multipart.addBodyPart(bodyPart);

            // second part (the image)
            bodyPart = new MimeBodyPart();
            DataSource fds = new FileDataSource(file);
            bodyPart.setDataHandler(new DataHandler(fds));
            bodyPart.setHeader("Content-ID", "<image>");

            // add image to the multipart
            multipart.addBodyPart(bodyPart);

            // put everything together
            message.setContent(multipart);

            // Send the message
            Transport.send(message);

            return true;
        } catch (MessagingException e) {
            return false;
        }
    }
}
