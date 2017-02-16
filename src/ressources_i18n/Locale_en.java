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
		{"accueil.form.titre", "Connection"},
	    {"accueil.form.login", "Email address:"},
	    {"accueil.form.password", "Password:"},
	    {"accueil.form.passwordOublie", "Forgot your password ?"},
	    {"accueil.form.resterConnecte", "Stay Connected"},
	    {"accueil.form.erreurInfosConnexion", "Please verify that your email address and password are valid."},
	    {"accueil.form.submit", "Sign in"},
	    {"accueil.form.compte", "No account yet ?"},
	    {"accueil.form.creerCompte", "Sign up"},
	    {"accueil.panel.bienvenue", "Welcome !"},
	    {"accueil.panel.message1", "This site allows you to create and edit a grocery list based on the recipes you want to cook.."},
	    {"accueil.panel.message2", "Log in or sign up to a new account now to manage your own online cookbook."},
	    /////////////////////////////////////////////////////////
	    {"compte.form.titre", "Sign up"},
	    {"compte.form.nom", "Name:"},
	    {"compte.form.email", "Email:"},
	    {"compte.form.password", "Password:"},
	    {"compte.form.password2", "Confirm your password: "},
	    {"compte.form.erreurEmailExistant", "This email address is already used by another user !"},
	    {"compte.form.erreurPasswordInvalide","Please respect the format for the password."},
	    {"comtpe.form.erreurCreation", "An error has occured, please try again later."},
	    {"compte.form.erreurPwdDifferents", "Passwords are not the same."},
	    {"compte.form.submit", "Sign up"},
	    {"compte.retour.titre", "Already have an account ?"},
	    {"compte.retour.bouton", "Sign in"},
	    {"compte.panel.titre", "Instructions"},
	    {"compte.panel.instruction1","All fields are mandatory."},
	    {"compte.panel.instruction2","The email address must be valid. A confirmation code will be emailed to you to complete the registration process."},
	    {"compte.panel.instruction3a", "The password must contain exactly 8 characters (letters and/or numbers)."},
	    {"compte.panel.instruction3b", "Only the following special characters are allowed: ! @ # $ % &"},
	    {"compte.panel.instruction3c", "Accented characters are not allowed."},
	    ///////////////////////////////////////////////////////
	    {"password.form.titre", "Reset your password"},
	    {"password.form.email", "Email:"},
	    {"password.form.erreurEmail", "The email address provided does not match any existing users !"},
	    {"password.form.submit", "Reset"},
	    {"password.retour.titre", "Click here to return to the homepage"},
	    {"password.retour.bouton", "Sign in"},
	    {"password.panel.titre", "Instructions"},
	    {"password.panel.instruction1", "To reset your password, enter your email address."},
	    {"password.panel.instruction2", "An email will be sent to you with your new password."},
	    {"password.panel.erreur", "An error has occurred, please try again later."},
	    {"password.panel.succes", "An email containing your new password has been sent to you."},
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