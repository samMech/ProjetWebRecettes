package ressources_i18n;

import java.util.ListResourceBundle;

//Classe pour la locale par défaut (français)
public class Locale extends ListResourceBundle {
	    
	// Les données de localisation
	private static final Object[][] contents = {
	    {"application.nom", "La Boîte à  Ingrédients"},
	    {"application.recette", "Recette"},
	    /////////////////////////////////////////////////////////
	    {"navbar.accueil", "Accueil"},
	    {"navbar.nouvelleListe", "Nouvelle liste d'épicerie"},
	    {"navbar.nouvelleRecette", "Nouvelle recette"},
	    {"navbar.rechercheRapide", "Recherche rapide"},
	    {"navbar.login", "Connexion"},
	    {"navbar.logout", "Déconnexion"},
	    /////////////////////////////////////////////////////////
	    {"accueil.form.titre", "Connexion"},
	    {"accueil.form.login", "Adresse courriel:"},
	    {"accueil.form.password", "Mot de passe:"},
	    {"accueil.form.passwordOublie", "Mot de passe oublié ?"},
	    {"accueil.form.resterConnecte", "Rester connecté"},
	    {"accueil.form.erreurInfosConnexion", "Veuillez vérifier que votre adresse courriel et mot de passe sont valides."},
	    {"accueil.form.submit", "Se connecter"},
	    {"accueil.form.compte", "Pas encore de compte ?"},
	    {"accueil.form.creerCompte", "Créer un nouveau compte"},
	    {"accueil.panel.bienvenue", "Bienvenue !"},
	    {"accueil.panel.message", "Ce site vous permet de créer et modifier une liste d'épicerie en fonction des recettes que vous voulez cuisinez.<br /><br />"
	    	+ "Connectez-vous ou créez un nouveau compte dès maintenant pour gérer votre propre livre de recettes en ligne."},
	    /////////////////////////////////////////////////////////
	    {"compte.form.titre", "Créer un compte"},
	    {"compte.form.nom", "Nom:"},
	    {"compte.form.email", "Adresse courriel:"},
	    {"compte.form.password", "Mot de passe:"},
	    {"compte.form.password2", "Confirmer votre mot de passe: "},
	    {"compte.form.erreurEmailExistant", "Cette adresse courriel est déjà utilisée par un autre usager !"},
	    {"compte.form.erreurPasswordInvalide","Veuillez respecter le format pour le mot de passe."},
	    {"comtpe.form.erreurCreation", "Une erreur est survenue, veuillez ré-essayer plus tard."},
	    {"compte.form.erreurPwdDifferents", "Les mots de passes ne sont pas identiques."},
	    {"compte.form.submit", "Créer un compte"},
	    {"compte.retour.titre", "Vous avez déjà un compte ?"},
	    {"compte.retour.bouton", "Se connecter"},
	    {"compte.panel.titre", "Instructions"},
	    {"compte.panel.instruction1","Tous les champs sont obligatoires."},
	    {"compte.panel.instruction2","L'adresse courriel doit être valide. Un code de confirmation vous sera envoyez par courriel pour compléter le processus d'inscription."},
	    {"compte.panel.instruction3","Le mot de passe doit contenir exactement 8 caractères (lettres et/ou chiffres).<br />"
	    							+"Seul les caractères spéciaux suivant sont autorisés: ! @ # $ % & <br />"
	    							+"Les caractères accentués ne sont pas autorisés."},
	    ///////////////////////////////////////////////////////
	    {"password.form.titre", "Réinitialiser votre mot de passe"},
	    {"password.form.email", "Adresse courriel:"},
	    {"password.form.erreurEmail", "L'adresse courriel fournie ne correspond à aucun usager existant !"},
	    {"password.form.submit", "Réinitialiser"},
	    {"password.retour.titre", "Cliquez ici pour retourner à la page d'accueil"},
	    {"password.retour.bouton", "Se Connecter"},
	    {"password.panel.titre", "Instructions"},
	    {"password.panel.instruction1", "Pour réinitialiser votre mot de passe, entrez votre adresse courriel."},
	    {"password.panel.instruction2", "Un courriel vous sera envoyé avec votre nouveau mot de passe."},
	    {"password.panel.erreur", "Une erreur est survenue, veuillez ré-essayer plus tard."},
	    {"password.panel.succes", "Un courriel contenant votre nouveau mot de passe vous a été envoyé."},
	    ///////////////////////////////////////////////////////
	    {"bienvenue.message", "Bienvenue"},
	    {"bienvenue.panel.titre", "Vos plus récentes recettes"},
	    {"bienvenue.panel.lienRecette", "Voir la recette"},
	    {"bienvenue.panel.dureeRecette", "Temps de préparation:"},
	    {"bienvenue.panel.vide", "Pas encore de recette ? Ajoutez-en une à votre propre livre de recettes dès maintenant !"},
	    /////////////////////////////////////////////////////////
	    {"footer.copyright", "2016-2017 La Boîtes à Ingrédients"}
	    };
	
	/**
	 * Redéfinition de la méthode pour retourner les données de localisation
	 * @return Les données de localisation
	 */
	@Override
	protected Object[][] getContents() {
	    return contents;
	}
	
}
