import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;

public class SendEmail extends Person {
	String senderEmail = "frootichunduri@gmail.com"; 
	String senderPassword = "rqgulrdflnxdmbwb"; 
	String emailSMTPserver = "smtp.gmail.com";
	String emailServerPort = "465";
	String receiverEmail;
	String emailSubject;
	String emailBody;

	public SendEmail() {

	}

	public SendEmail(String receiverEmail, String emailSubject, String emailBody) {
		
		this.receiverEmail = receiverEmail;
		this.emailSubject = emailSubject;
		this.emailBody = emailBody;

		Properties props = new Properties();
		props.put("mail.smtp.user", senderEmail);
		props.put("mail.smtp.host", emailSMTPserver);
		props.put("mail.smtp.port", emailServerPort);
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.socketFactory.port", emailServerPort);
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");
		SecurityManager security = System.getSecurityManager();

		try {
			Authenticator auth = new SMTPAuthenticator();
			Session session = Session.getInstance(props, auth);
			MimeMessage msg = new MimeMessage(session);
			msg.setText(emailBody);
			// System.out.println(emailBody);
			msg.setSubject(emailSubject);
			msg.setFrom(new InternetAddress(senderEmail));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(receiverEmail));
			Transport.send(msg);
			System.out.println("Message sent successfully");
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public class SMTPAuthenticator extends javax.mail.Authenticator {
		public PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(senderEmail, senderPassword);
		}
	}
/*
	public String getReceiverEmail() {
		return receiverEmail;
	}

	public void setReceiverEmail(String receiverEmail) {
		this.receiverEmail = receiverEmail;
	}

	public String getEmailSubject() {
		return emailSubject;
	}

	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}

	public String getEmailBody() {
		return emailBody;
	}

	public void setEmailBody(String emailBody) {
		this.emailBody = emailBody;
	}
*/
}
