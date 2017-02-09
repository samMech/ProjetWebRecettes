package utils;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * Classe utilitaire pour des méthodes générales
 * 
 * @author Marc-André Malouin
 * @version 1.10 (8 janvier 2017)
 */
public class Utilitaire {
	
	public static final int DEFAULT_TIMEOUT = 30 * 60;
	
	/**
	 * Méthode pour retourner le temps d'expiration de la session par défaut
	 * 
	 * @param servletContext Le contexte d'exécution pour la servlet
	 * @return Le temps d'expiration de la session par défaut (en secondes)
	 * @throws IOException 
	 */
	public static int getDefaultSessionTimeOut(ServletContext servletContext) {
		try {
			// Initialisation des outils nécessaires
			XPath xPath = XPathFactory.newInstance().newXPath();
			XPathExpression xPathExp = xPath.compile("web-app/session-config/session-timeout");// Pour parcourir le xml
			DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();// Pour parcourir les fichiers de ressources
			
			// Lecture du sessionTimeout dans le fichier web.xml
			Document docWebXml = dBuilder.parse(servletContext.getResourceAsStream("/WEB-INF/web.xml"));			
			String timeout = xPathExp.evaluate(docWebXml);
			
			return Integer.parseInt(timeout);
			
		} catch (ParserConfigurationException | XPathExpressionException | SAXException | IOException | NumberFormatException e) {
			return DEFAULT_TIMEOUT;
		}
	}
	
	/**
	 * Méthode pour trouver un cookie particulier
	 * 
	 * @param cookies Le tableau contenant les cookies
	 * @param nomCookie Le nom du cookie recherché
	 * @return Le cookie trouvé ou null si introuvable
	 */
	public static Cookie trouverCookie(Cookie[] cookies, String nomCookie){
		if(cookies != null){
			Cookie c;
			for(int i=0; i < cookies.length; i++){
				c = cookies[i];
				if(c.getName().equals(nomCookie)){
					return c;
				}				
			}
		}		
		return null;
	}
	
	
	/**
	 * Méthode pour générer une code aléatoire
	 * 
	 * @return Le code généré
	 */
	public static String genererCodeAleatoire(){				
		return UUID.randomUUID().toString();
	}

	/**
	 * Méthode pour générer un mot de passe aléatoire d'après une liste de caractères valides
	 * 
	 * @param nbChars Le nombre de caractère du mot de passe
	 * @param charsValides Une chaîne contenant les caractères valides
	 * @return Le mot de passe généré
	 */
	public static String genererMotDePasse(int nbChars, String charsValides){
		
		// Le nombre de caractères valides
		int nbCharsValides = charsValides.length();
		
		// Génération du mot de passe
		int idx;
		String pwd = "";
		for(int i=0; i < nbChars; i++){
			// On sélectionne un index aléatoire pour le caractère à ajouter
			idx = (int)(Math.random() * nbCharsValides);
			
			// On ajoute le caractère choisit au mot de passe
			pwd += charsValides.charAt(idx);			
		}		
		
		return pwd;
	}

	/**
	 * Méthode pour valider si un mot de passe est valide
	 * 
	 * @param pwd Le mot de passe à valider
	 * @param nbChars La longueur pour un mot de passe valide
	 * @param charsValides La chaîne contenant les caractères acceptés
	 * @return
	 */
	public static boolean validerMotDePasse(String pwd, int nbChars, String charsValides){
		
		// 1) Test de la longueur
		if(pwd.length() != nbChars){
			return false;
		}
		
		// 2) Test des caractères dans le mot de passe
		for(int i=0; i < pwd.length(); i++){
			if(! charsValides.contains("" + pwd.charAt(i))){
				return false;
			}
		}		
		
		// Mot de passe valide
		return true;		
	}
	
}
