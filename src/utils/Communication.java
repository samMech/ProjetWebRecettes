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
	 * Source: http://www.mkyong.com/java/javamail-api-sending-email-via-gmail-smtp-example/
	 * 
	 * @param destinataire L'adresse courriel du destinataire
	 * @param expediteur L'adresse courriel de l'expéditeur
	 * @param sujet Le sujet du courriel
	 * @param message Le message à envoyer
	 */
	public static void envoyerCourriel(String destinataire, String expediteur, String sujet, String message) throws MessagingException {
				
		// Mise en place du serveur SMTP
		Properties props = new Properties();
		props.put("mail.smtp.host", "gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		
		// Récupération de l'instance de session pour envoyer le message
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			// Classe anonyme pour l'authentificateur
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("boite.a.ingredient@gmail.com", "tempbdeb");
			}
		  });
				
		// Construction du message
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(expediteur));
		msg.setRecipient(Message.RecipientType.TO, new InternetAddress(destinataire));
		msg.setSentDate(new Date());
		msg.setSubject(sujet);
		msg.setText(message);
		
		// Envoi du message
		Transport.send(msg);		
	}	
	
}
