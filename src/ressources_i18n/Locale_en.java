package ressources_i18n;

import java.util.ListResourceBundle;

// Classe pour la locale en anglais
public class Locale_en extends ListResourceBundle {
	    
	// Les données de localisation
	private static final Object[][] contents = {
		{"application.nom", "The Ingredient Box"},
	    {"application.recette", "Recipe"},
	    /////////////////////////////////////////////////////////
	    {"application.typeRecette.T01", "Aperitif"},
	    {"application.typeRecette.T02", "Entry"},
	    {"application.typeRecette.T03", "Soup"},
	    {"application.typeRecette.T04", "Salad"},
	    {"application.typeRecette.T05", "Drinks"},
	    {"application.typeRecette.T06", "Dessert"},
	    {"application.typeRecette.T07", "Vegetarian"},
	    {"application.typeRecette.T08", "Lunch"},
	    {"application.typeRecette.T09", "Dinner"},
	    {"application.typeRecette.T10", "Supper"},
	    {"application.typeRecette.T11", "Other"},
	    {"application.categorieIngredient.C01", "Fruits"},
	    {"application.categorieIngredient.C02", "Vegetables"},
	    {"application.categorieIngredient.C03", "Meat"},
	    {"application.categorieIngredient.C04", "Fish"},
	    {"application.categorieIngredient.C05", "Cereal Products"},
	    {"application.categorieIngredient.C06", "Dairy Products"},
	    {"application.categorieIngredient.C07", "Spices"},
	    {"application.categorieIngredient.C08", "Drinks"},
	    {"application.categorieIngredient.C09", "Other"},
	    {"application.unites.U01", "pinch(es)"},
	    {"application.unites.U02", "tsp(s)"},
	    {"application.unites.U03", "tbsp(s)"},
	    {"application.unites.U04", "cup(s)"},
	    {"application.unites.U05", "mg"},
	    {"application.unites.U06", "g"},
	    {"application.unites.U07", "kg"},
	    {"application.unites.U08", "oz"},
	    {"application.unites.U09", "lb"},
	    {"application.unites.U10", "mL"},
	    {"application.unites.U11", "L"},
	    {"application.unites.", ""},
	    /////////////////////////////////////////////////////////
	    {"recherche.duree", "Unspecified"},
	    {"recherche.duree5", "Less than 5 minutes"},
	    {"recherche.duree10", "Less than 10 minutes"},
	    {"recherche.duree20", "Less than 20 minutes"},
	    {"recherche.duree30", "Less than 30 minutes"},
	    {"recherche.duree45", "Less than 45 minutes"},
	    {"recherche.duree60", "Less than 60 minutes"},
	    {"recherche.duree90", "Less than 90 minutes"},
	    {"recherche.duree120", "Less than 120 minutes"},
	    {"recherche.duree121", "More than 120 minutes"},	    
	    /////////////////////////////////////////////////////////
	    {"recherche.titre", "New grocery list"},
	    {"recherche.form.titre", "Search"},
	    {"recherche.form.freeSearch", "Recipes / Instructions / Ingredients:"},
	    {"recherche.form.recherche.type", "Types of recipes:"},
	    {"recherche.form.recherche.categorie", "Ingredient categories:"},
	    {"recherche.form.recherche.duree", "Preparation time:"},
	    {"recherche.resultats.titre", "Recipes found"},
	    {"recherche.boutonChoisir.titre", "Choose"},
	    {"recherche.panier.titre", "Recipes chosen"},
	    {"recherche.panier.submit", "Create grocery list"},
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
	    {"footer.copyright", "2016-2017 The Ingredient Box"},
	    /////////////////////////////////////////////////////////
	    {"formrecette.titre", "New Recipe"},
	    {"formrecette.info.titre","General Information"},
	    {"formrecette.info.nom","Name"},
	    {"formrecette.info.type","Type"},
	    {"formrecette.info.desc","Description"},
	    {"formrecette.info.prepTime","Preparation Time"},
	    {"formrecette.ingredients.titre","Ingredients"},
	    {"formrecette.instructions.titre","Instructions"},
	    {"formrecette.enregistrer.button","Save"},
	    /////////////////////////////////////////////////////////
	    {"viewrecette.info.prepTime","Preparation Time: "},
	    {"viewrecette.ingredients.titre","Ingredients"},
	    {"viewrecette.instructions.titre","Instructions"},
	    {"viewrecette.modifier.button","Modify"},
	    {"viewrecette.supprimer.button","  Delete  "},
	    /////////////////////////////////////////////////////////
	    {"modificationListe.info.titre","Customize your grocery list"},
	    {"modificationListe.ingredients.titre","Ingredients"},
	    {"modificationListe.finaliser.button","Finalize"},
	    /////////////////////////////////////////////////////////
	    {"affichageListe.info.titre","Final Grocery List"},
	    {"affichageListe.imprimer.button","Print"},
	    {"affichageListe.envoyer.button","Send"},
	    {"affichageListe.retour.button","Back"},
	    /////////////////////////////////////////////////////////
	    {"erreur.info.messageerreur", "An error has occurred."},
	    {"erreur.info.messageerreur.400", "Sorry, this page is not available at this time, please come back later."},
	    {"erreur.info.messageerreur.500", "Sorry, the server is not available at this time, please try again later."},
	    {"erreur.info.retour","Return to the home page."}
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