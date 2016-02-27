package pp5.services;

/**
 * Created by Yoga2pro on 27.02.2016.
 */

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class EmailSending{

    private String host;
    private String to;
    private String from;
    private String subject;
    private String text;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public EmailSending(String to, String text, String subject){
        this.text = text;
        this.subject = subject;
        this.to = to;
        sentEmail(to, subject, text);
      }
      public void sentEmail(String to, String subject, String text)
     {
         host = "localhost";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.setProperty("mail.smtp.host", host);

        // Get the default Session object.
        Session session = Session.getDefaultInstance(properties);

        try{
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject(subject);

            // Now set the actual message
            message.setText(text);

            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
            
        }catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}

