package utils;

import java.util.Date;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;

/**
 * Classe utilitaire pour les méthodes de communication
 * 
 * @author Marc-André Malouin
 * @version 1.00 (31 janvier 2017)
 */
public class Communication {

	/**
	 * Méthode pour envoyer un courriel
	 * 
	 * @param destinataire L'adresse courriel du destinataire
	 * @param expediteur L'adresse courriel de l'expéditeur
	 * @param sujet Le sujet du courriel
	 * @param message Le message à envoyer
	 */
	public static void envoyerCourriel(String destinataire, String expediteur, String sujet, String message) throws MessagingException {
				
		// Mise en place du serveur SMTP
		Properties props = new Properties();
		props.put("mail.smtp.host", "localhost");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "Container");
		props.put("mail.smtp.starttls.enable", "true");
		
		//Session session = Session.getDefaultInstance(props, null);
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("login", "password");// TODO
			}
		  });
		
		session.setDebug(true);
		// Construction du message
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(expediteur));
		msg.setRecipient(Message.RecipientType.TO, new InternetAddress(destinataire));
		msg.setSentDate(new Date());
		msg.setSubject(sujet);
		msg.setText(message);
		
		// Envoi du message
		//Transport.send(msg);
	}	
	
}
