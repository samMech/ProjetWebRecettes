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
	    {"accueil.form.connexion", "Connexion"},
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
