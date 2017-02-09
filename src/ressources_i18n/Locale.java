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
	    {"accueil.form.connexion", "Connexion"},
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
