package ressources_i18n;

import java.util.ListResourceBundle;

// Classe pour la locale en anglais
public class Locale_en extends ListResourceBundle {
	    
	// Les données de localisation
	private static final Object[][] contents = {
		{"application.nom", "The Ingredient Box"},
	    {"application.recette", "Recipe"},
	    /////////////////////////////////////////////////////////
	    {"navbar.accueil", "Home"},
	    {"navbar.nouvelleListe", "New grocery list"},
	    {"navbar.nouvelleRecette", "New recipe"},
	    {"navbar.rechercheRapide", "Quick search"},
	    {"navbar.login", "Sign in"},
	    {"navbar.logout", "Sign out"},
	    /////////////////////////////////////////////////////////
		{"accueil.form.connexion", "Connection"},
	    {"accueil.form.login", "Email address:"},
	    {"accueil.form.password", "Password:"},
	    {"accueil.form.passwordOublie", "Forgot your password ?"},
	    {"accueil.form.resterConnecte", "Stay Connected"},
	    {"accueil.form.erreurInfosConnexion", "Please verify that your email address and password are valid."},
	    {"accueil.form.submit", "Log in"},
	    {"accueil.form.compte", "No account yet ?"},
	    {"accueil.form.creerCompte", "Create a new account"},
	    {"accueil.panel.bienvenue", "Welcome !"},
	    {"accueil.panel.message", "This site allows you to create and edit a grocery list based on the recipes you want to cook.<br /><br />"
		    	+ "Log in or sign up to a new account now to manage your own online cookbook."},
	    /////////////////////////////////////////////////////////
	    {"compte.form.erreurPwdDifferents", "Passwords are not the same."},
	    /////////////////////////////////////////////////////////
	    {"bienvenue.message", "Welcome"},
	    {"bienvenue.panel.titre", "Your Latest Recipes"},
	    {"bienvenue.panel.lienRecette", "View recipe"},
	    {"bienvenue.panel.dureeRecette", "Preparation time:"},
	    {"bienvenue.panel.vide", "No recipe yet? Add one to your own cookbook now!"},
	    /////////////////////////////////////////////////////////
	    {"footer.copyright", "2016-2017 The Ingredient Box"}
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