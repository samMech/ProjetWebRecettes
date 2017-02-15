package ressources_i18n;

import java.util.ListResourceBundle;

//Classe pour la locale par d�faut (fran�ais)
public class Locale extends ListResourceBundle {
	    
	// Les donn�es de localisation
	private static final Object[][] contents = {
	    {"application.nom", "La Bo�te � Ingr�dients"},
	    {"application.recette", "Recette"},
	    /////////////////////////////////////////////////////////
	    {"navbar.accueil", "Accueil"},
	    {"navbar.nouvelleListe", "Nouvelle liste d'�picerie"},
	    {"navbar.nouvelleRecette", "Nouvelle recette"},
	    {"navbar.rechercheRapide", "Recherche rapide"},
	    {"navbar.login", "Connexion"},
	    {"navbar.logout", "D�connexion"},
	    /////////////////////////////////////////////////////////
	    {"accueil.form.titre", "Connexion"},
	    {"accueil.form.login", "Adresse courriel:"},
	    {"accueil.form.password", "Mot de passe:"},
	    {"accueil.form.passwordOublie", "Mot de passe oubli� ?"},
	    {"accueil.form.resterConnecte", "Rester connect�"},
	    {"accueil.form.erreurInfosConnexion", "Veuillez v�rifier que votre adresse courriel et mot de passe sont valides."},
	    {"accueil.form.submit", "Se connecter"},
	    {"accueil.form.compte", "Pas encore de compte ?"},
	    {"accueil.form.creerCompte", "Cr�er un nouveau compte"},
	    {"accueil.panel.bienvenue", "Bienvenue !"},
	    {"accueil.panel.message", "Ce site vous permet de cr�er et modifier une liste d'�picerie en fonction des recettes que vous voulez cuisinez.<br /><br />"
	    	+ "Connectez-vous ou cr�ez un nouveau compte d�s maintenant pour g�rer votre propre livre de recettes en ligne."},
	    /////////////////////////////////////////////////////////
	    {"compte.form.titre", "Cr�er un compte"},
	    {"compte.form.nom", "Nom:"},
	    {"compte.form.email", "Adresse courriel:"},
	    {"compte.form.password", "Mot de passe:"},
	    {"compte.form.password2", "Confirmer votre mot de passe: "},
	    {"compte.form.erreurEmailExistant", "Cette adresse courriel est d�j� utilis�e par un autre usager !"},
	    {"compte.form.erreurPasswordInvalide","Veuillez respecter le format pour le mot de passe."},
	    {"comtpe.form.erreurCreation", "Une erreur est survenue, veuillez r�-essayer plus tard."},
	    {"compte.form.erreurPwdDifferents", "Les mots de passes ne sont pas identiques."},
	    {"compte.form.submit", "Cr�er un compte"},
	    {"compte.retour.titre", "Vous avez d�j� un compte ?"},
	    {"compte.retour.bouton", "Se connecter"},
	    {"compte.panel.titre", "Instructions"},
	    {"compte.panel.instruction1","Tous les champs sont obligatoires."},
	    {"compte.panel.instruction2","L'adresse courriel doit �tre valide. Un code de confirmation vous sera envoyez par courriel pour compl�ter le processus d'inscription."},
	    {"compte.panel.instruction3","Le mot de passe doit contenir exactement 8 caract�res (lettres et/ou chiffres).<br />"
	    							+"Seul les caract�res sp�ciaux suivant sont autoris�s: ! @ # $ % & <br />"
	    							+"Les caract�res accentu�s ne sont pas autoris�s."},
	    ///////////////////////////////////////////////////////
	    {"password.form.titre", "R�initialiser votre mot de passe"},
	    {"password.form.email", "Adresse courriel:"},
	    {"password.form.erreurEmail", "L'adresse courriel fournie ne correspond � aucun usager existant !"},
	    {"password.form.submit", "R�initialiser"},
	    {"password.retour.titre", "Cliquez ici pour retourner � la page d'accueil"},
	    {"password.retour.bouton", "Se Connecter"},
	    {"password.panel.titre", "Instructions"},
	    {"password.panel.instruction1", "Pour r�initialiser votre mot de passe, entrez votre adresse courriel."},
	    {"password.panel.instruction2", "Un courriel vous sera envoy� avec votre nouveau mot de passe."},
	    {"password.panel.erreur", "Une erreur est survenue, veuillez r�-essayer plus tard."},
	    {"password.panel.succes", "Un courriel contenant votre nouveau mot de passe vous a �t� envoy�."},
	    ///////////////////////////////////////////////////////
	    {"bienvenue.message", "Bienvenue"},
	    {"bienvenue.panel.titre", "Vos plus r�centes recettes"},
	    {"bienvenue.panel.lienRecette", "Voir la recette"},
	    {"bienvenue.panel.dureeRecette", "Temps de pr�paration:"},
	    {"bienvenue.panel.vide", "Pas encore de recette ? Ajoutez-en une � votre propre livre de recettes d�s maintenant !"},
	    /////////////////////////////////////////////////////////
	    {"footer.copyright", "2016-2017 La Bo�tes � Ingr�dients"}
	    };
	
	/**
	 * Red�finition de la m�thode pour retourner les donn�es de localisation
	 * @return Les donn�es de localisation
	 */
	@Override
	protected Object[][] getContents() {
	    return contents;
	}
	
}
