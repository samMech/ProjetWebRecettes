package ressources_i18n;

import java.util.ListResourceBundle;

//Classe pour la locale par d�faut (fran�ais)
public class Locale extends ListResourceBundle {
	    
	// Les donn�es de localisation
	private static final Object[][] contents = {
	    {"application.nom", "La Bo�te � Ingr�dients"},
	    {"application.recette", "Recette"},
		/////////////////////////////////////////////////////////
	    {"application.typeRecette.T01", "Ap�ritif"},
	    {"application.typeRecette.T02", "Entr�e"},
	    {"application.typeRecette.T03", "Soupe"},
	    {"application.typeRecette.T04", "Salade"},
	    {"application.typeRecette.T05", "Breuvage"},
	    {"application.typeRecette.T06", "Dessert"},
		{"application.typeRecette.T07", "V�g�tarienne"},
		{"application.typeRecette.T08", "D�jeuner"},
		{"application.typeRecette.T09", "D�ner"},
		{"application.typeRecette.T10", "Souper"},
		{"application.typeRecette.T11", "Autre"},
		{"application.categorieIngredient.C01", "Fruits"},
		{"application.categorieIngredient.C02", "L�gumes"},
		{"application.categorieIngredient.C03", "Viandes"},
		{"application.categorieIngredient.C04", "Poissons"},
		{"application.categorieIngredient.C05", "Produits c�r�aliers"},
		{"application.categorieIngredient.C06", "Produits laitiers"},
		{"application.categorieIngredient.C07", "�pices"},
		{"application.categorieIngredient.C08", "Boissons"},
		{"application.categorieIngredient.C09", "Autres"},
		{"application.unites.U01", "pinc�e(s)"},
	    {"application.unites.U02", "cac."},
	    {"application.unites.U03", "cas."},
	    {"application.unites.U04", "tasse(s)"},
	    {"application.unites.U05", "mg"},
	    {"application.unites.U06", "g"},
	    {"application.unites.U07", "kg"},
	    {"application.unites.U08", "oz"},
	    {"application.unites.U09", "lb"},
	    {"application.unites.U10", "mL"},
	    {"application.unites.U11", "L"},
	    {"application.unites.", ""},
	    /////////////////////////////////////////////////////////
	    {"recherche.duree", "Non sp�cifi�"},
	    {"recherche.duree5", "Moins de 5 minutes"},
	    {"recherche.duree10", "Moins de 10 minutes"},
	    {"recherche.duree20", "Moins de 20 minutes"},
	    {"recherche.duree30", "Moins de 30 minutes"},
	    {"recherche.duree45", "Moins de 45 minutes"},
	    {"recherche.duree60", "Moins de 60 minutes"},
	    {"recherche.duree90", "Moins de 90 minutes"},
	    {"recherche.duree120", "Moins de 120 minutes"},
	    {"recherche.duree121", "Plus de 120 minutes"},
	    /////////////////////////////////////////////////////////
	    {"recherche.titre", "Nouvelle liste d'�picerie"},
	    {"recherche.form.titre", "Recherche"},
	    {"recherche.form.freeSearch", "Recettes / Instructions / Ingr�dients:"},
	    {"recherche.form.recherche.type", "Types de recette:"},
	    {"recherche.form.recherche.categorie", "Cat�gories d'ingr�dient:"},
	    {"recherche.form.recherche.duree", "Temps de pr�paration:"},
	    {"recherche.resultats.titre", "Recettes trouv�es"},
	    {"recherche.boutonChoisir.titre", "Choisir"},
	    {"recherche.panier.titre", "Recettes choisies"},	    
	    {"recherche.panier.submit", "Cr�er la liste d'�picerie"},
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
	    {"accueil.panel.message1", "Ce site vous permet de cr�er et modifier une liste d'�picerie en fonction des recettes que vous voulez cuisinez."},
	    {"accueil.panel.message2", "Connectez-vous ou cr�ez un nouveau compte d�s maintenant pour g�rer votre propre livre de recettes en ligne."},
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
	    {"compte.panel.instruction3a", "Le mot de passe doit contenir exactement 8 caract�res (lettres et/ou chiffres)."},
	    {"compte.panel.instruction3b", "Seul les caract�res sp�ciaux suivant sont autoris�s: ! @ # $ % &"},
	    {"compte.panel.instruction3c", "Les caract�res accentu�s ne sont pas autoris�s."},
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
	    {"footer.copyright", "2016-2017 La Bo�tes � Ingr�dients"},
	    /////////////////////////////////////////////////////////
	    {"formrecette.titre", "Nouvelle Recette"},
	    {"formrecette.info.titre","Informations g�n�rales"},
	    {"formrecette.info.nom","Nom"},
	    {"formrecette.info.type","Type"},
	    {"formrecette.info.desc","Description"},
	    {"formrecette.info.prepTime","Temps de pr�paration"},
	    {"formrecette.ingredients.titre","Ingr�dients"},
	    {"formrecette.instructions.titre","Instructions"},
	    {"formrecette.enregistrer.button","Enregistrer"},
	    /////////////////////////////////////////////////////////
	    {"viewrecette.info.prepTime","Temps de pr�paration: "},
	    {"viewrecette.ingredients.titre","Ingr�dients"},
	    {"viewrecette.instructions.titre","Instructions"},
	    {"viewrecette.modifier.button","Modifier"},
	    {"viewrecette.supprimer.button","Supprimer"},
	    /////////////////////////////////////////////////////////
	    {"modificationListe.info.titre","Modification de la liste d'�picerie"},
	    {"modificationListe.ingredients.titre","Ingr�dients"},
	    {"modificationListe.finaliser.button","Finaliser"},
	    /////////////////////////////////////////////////////////
	    {"affichageListe.info.titre","Liste d'�picerie finale"},
	    {"affichageListe.imprimer.button","Imprimer"},
	    {"affichageListe.envoyer.button","Envoyer "},
	    {"affichageListe.retour.button","Retour"},
	    /////////////////////////////////////////////////////////
	    {"erreur.info.messageerreur", "Oups, une erreur est survenue !"},
	    {"erreur.info.retour","Retour � l'accueil"}
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
