package ressources_i18n;

import java.util.ListResourceBundle;

//Classe pour la locale par défaut (français)
public class Locale extends ListResourceBundle {
	    
	// Les données de localisation
	private static final Object[][] contents = {
	    {"application.nom", "La Boîte à  Ingrédients"},
	    {"application.recette", "Recette"},
		/////////////////////////////////////////////////////////
	    {"application.typeRecette.T01", "Apéritif"},
	    {"application.typeRecette.T02", "Entrée"},
	    {"application.typeRecette.T03", "Soupe"},
	    {"application.typeRecette.T04", "Salade"},
	    {"application.typeRecette.T05", "Breuvage"},
	    {"application.typeRecette.T06", "Dessert"},
		{"application.typeRecette.T07", "Végétarienne"},
		{"application.typeRecette.T08", "Déjeuner"},
		{"application.typeRecette.T09", "Dîner"},
		{"application.typeRecette.T10", "Souper"},
		{"application.typeRecette.T11", "Autre"},
		{"application.categorieIngredient.C01", "Fruits"},
		{"application.categorieIngredient.C02", "Légumes"},
		{"application.categorieIngredient.C03", "Viandes"},
		{"application.categorieIngredient.C04", "Poissons"},
		{"application.categorieIngredient.C05", "Produits céréaliers"},
		{"application.categorieIngredient.C06", "Produits laitiers"},
		{"application.categorieIngredient.C07", "Épices"},
		{"application.categorieIngredient.C08", "Boissons"},
		{"application.categorieIngredient.C09", "Autres"},
		{"application.unites.U01", "pincée(s)"},
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
	    {"recherche.duree", "Non spécifié"},
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
	    {"recherche.titre", "Nouvelle liste d'épicerie"},
	    {"recherche.form.titre", "Recherche"},
	    {"recherche.form.freeSearch", "Recettes / Instructions / Ingrédients:"},
	    {"recherche.form.recherche.type", "Types de recette:"},
	    {"recherche.form.recherche.categorie", "Catégories d'ingrédient:"},
	    {"recherche.form.recherche.duree", "Temps de préparation:"},
	    {"recherche.resultats.titre", "Recettes trouvées"},
	    {"recherche.boutonChoisir.titre", "Choisir"},
	    {"recherche.panier.titre", "Recettes choisies"},	    
	    {"recherche.panier.submit", "Créer la liste d'épicerie"},
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
	    {"accueil.panel.message1", "Ce site vous permet de créer et modifier une liste d'épicerie en fonction des recettes que vous voulez cuisinez."},
	    {"accueil.panel.message2", "Connectez-vous ou créez un nouveau compte dès maintenant pour gérer votre propre livre de recettes en ligne."},
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
	    {"compte.panel.instruction3a", "Le mot de passe doit contenir exactement 8 caractères (lettres et/ou chiffres)."},
	    {"compte.panel.instruction3b", "Seul les caractères spéciaux suivant sont autorisés: ! @ # $ % &"},
	    {"compte.panel.instruction3c", "Les caractères accentués ne sont pas autorisés."},
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
	    {"footer.copyright", "2016-2017 La Boîtes à Ingrédients"},
	    /////////////////////////////////////////////////////////
	    {"formrecette.titre", "Nouvelle Recette"},
	    {"formrecette.info.titre","Informations générales"},
	    {"formrecette.info.nom","Nom"},
	    {"formrecette.info.type","Type"},
	    {"formrecette.info.desc","Description"},
	    {"formrecette.info.prepTime","Temps de préparation"},
	    {"formrecette.ingredients.titre","Ingrédients"},
	    {"formrecette.instructions.titre","Instructions"},
	    {"formrecette.enregistrer.button","Enregistrer"},
	    /////////////////////////////////////////////////////////
	    {"viewrecette.info.prepTime","Temps de préparation: "},
	    {"viewrecette.ingredients.titre","Ingrédients"},
	    {"viewrecette.instructions.titre","Instructions"},
	    {"viewrecette.modifier.button","Modifier"},
	    {"viewrecette.supprimer.button","Supprimer"},
	    /////////////////////////////////////////////////////////
	    {"modificationListe.info.titre","Modification de la liste d'épicerie"},
	    {"modificationListe.ingredients.titre","Ingrédients"},
	    {"modificationListe.finaliser.button","Finaliser"},
	    /////////////////////////////////////////////////////////
	    {"affichageListe.info.titre","Liste d'épicerie finale"},
	    {"affichageListe.imprimer.button","Imprimer"},
	    {"affichageListe.envoyer.button","Envoyer "},
	    {"affichageListe.retour.button","Retour"},
	    /////////////////////////////////////////////////////////
	    {"erreur.info.messageerreur", "Oups, une erreur est survenue !"},
	    {"erreur.info.retour","Retour à l'accueil"}
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
