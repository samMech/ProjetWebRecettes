package controle;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import modele.CategoriesIngredient;
import modele.CRITERE_RECHERCHE;
import modele.DaoJPA;
import modele.DaoRecette;
import modele.Ingredient;
import modele.Instruction;
import modele.Mesure;
import modele.DUREE;
import modele.PanierRecettes;
import modele.Recette;
import modele.TypesRecette;
import modele.Unite;
import modele.Usager;

/**
 * Classe contr�leur pour la gestion du dao
 * 
 * @author Marc-Andr� Malouin
 * @version 1.00 (31 janvier 2017)
 */
public class Driver {

	/**
	 * M�thode pour enregistrer les modifications d'un objet dans la base
	 * 
	 * @param objet L'objet � persister
	 * @param type Le type de l'objet � persister
	 */
	public static <T> T enregistrer(T objet, Class<T> type){
		DaoJPA<T> dao = new DaoJPA<>(type);
		return dao.enregistrer(objet);
	}
	
	/**
	 * M�thode pour cr�er un nouvel usager
	 * 
	 * @param nom Le nom de l'usager
	 * @param email L'adresse courriel de l'usager
	 * @param password Le mot de passe de l'usager
	 * @return L'usager cr��
	 */
	public static Usager creerNouvelUsager(String nom, String email, String password){
		return new Usager(nom, email , password);	
	}
	
	/**
	 * M�thode pour trouver un usager par son email
	 * 
	 * @param email L'adresse courriel de l'usager (login)
	 * @return L'usager trouv� ou null si inexistant
	 */
	public static Usager trouverUsager(String email){
		DaoRecette dao = new DaoRecette();
		return dao.getUsager(email);		
	}
	
	/**
	 * M�thode pour trouver un usager par son id
	 * 
	 * @param id L'identifiant de l'usager
	 * @return L'usager trouv� ou null si inexistant
	 */
	public static Usager trouverUsager(long id){
		DaoRecette dao = new DaoRecette();
		return dao.chercherParId(id, "Usager", "idUsager", Usager.class);		
	}
	
	/**
	 * M�thode pour r�cup�rer la liste des recettes � afficher sur la page de bienvenue
	 * 
	 * @param usager L'usag�
	 * @return La liste des recettes � afficher
	 */
	public static List<Recette> chargerRecettesBienvenue(Usager usager){
		DaoRecette dao = new DaoRecette();
		return dao.chercherRecettesRecentes(usager, 5);
	}
	
	/**
	 * M�thode pour obtenir la liste de toutes les recettes de l'usager
	 * 
	 * @param usager L'usag�
	 * @return La liste des recettes de l'usager
	 */
	public static List<Recette> getRecettesUsager(Usager usager){
		DaoRecette dao = new DaoRecette();
		return dao.getAll("Recette", Recette.class);		
	}
	
	/**
	 * M�thode pour retourner la liste de tous les types de recettes
	 * 
	 * @return La liste de tous les types de recette ou une liste vide si aucun r�sultat
	 */
	public static List<TypesRecette> getTypesRecette(){
		DaoRecette dao = new DaoRecette();
		return dao.getAll("TypesRecette", TypesRecette.class);
	}
	
	/**
	 * M�thode pour retourner la liste de tous les unites
	 * 
	 * @return La liste de tous les unites de mesures ou une liste vide si aucun r�sultat
	 */
	public static List<Unite> getUnites(){
		DaoRecette dao = new DaoRecette();
		return dao.getAll("Unite", Unite.class);
	}
	
	/**
	 * M�thode pour trouver un type de recette selon son id
	 * 
	 * @param idType L'id du type dans la table
	 * @return Le type de recette trouv� ou null si n'existe pas
	 */
	public static TypesRecette getTypeRecette(long idType){
		DaoRecette dao = new DaoRecette();
		TypesRecette type = dao.chercherParId(idType, TypesRecette.class);
		return type;
	}
	
	/**
	 * Methode pour trouver une recette par son id
	 *  @param idRecette l'ID de la recette
	 *  @return La recette trouv� ou null si n'existe pas
	 */
	public static Recette getRecette(long idRecette){
		DaoRecette dao = new DaoRecette();
		Recette recette = dao.chercherParId(idRecette, Recette.class);
		return recette;
	}

	/**
	 * Methode pour trouver une Unite de mesure par son id
	 *  @param idUnite l'ID de l'unite
	 *  @return L'unite trouv� ou null si n'existe pas
	 */
	public static Unite getUnite(long idUnite) {
		DaoRecette dao = new DaoRecette();
		Unite unite = dao.chercherParId(idUnite, Unite.class);
		return unite;
	}
	
	/**
	 * Methode pour trouver une recette par son id
	 *  @param idRecette l'ID de la recette
	 *  @return La recette trouv� ou null si n'existe pas
	 */
	public static CategoriesIngredient getCategorie(long idCategorie) {
		DaoRecette dao = new DaoRecette();
		CategoriesIngredient cat = dao.chercherParId(idCategorie, CategoriesIngredient.class);
		return cat;
	}

	/**
	 * M�thode pour retourner la liste de tous les unites
	 * 
	 * @return La liste de tous les unites de mesures ou une liste vide si aucun r�sultat
	 */
	public static List<CategoriesIngredient> getCategories(){
		DaoRecette dao = new DaoRecette();
		return dao.getAll("CategoriesIngredient", CategoriesIngredient.class);
	}
	
	/**
	 * M�thode pour rechercher des recettes d'apr�s des mots cl�s, des types, des cat�gories et/ou une dur�e
	 * 
	 * @param usager L'usager connect�
	 * @param sTexte La cha�ne contenant le texte pour la recherche libre
	 * @param sType La cha�ne contenant le id du type de recette
	 * @param sDuree La cha�ne contenant la dur�e maximale
	 * @param sCategories Le tableau contenant les id des cat�gories d'ingr�dient
	 * @return La liste des recettes trouv�es
	 */
	public static List<Recette> rechercherRecettes(Usager usager, String sTexte, String sType, String sDuree, String[] sCategories){
		
		// D�claration des variables	
		long id;
		int duree;
		List<Object> params = new ArrayList<>();
		List<CRITERE_RECHERCHE> criteres = new ArrayList<>();
		
		// Recherche libre
		if(sTexte != null){
			String[] motsCle = sTexte.trim().split("\\s+");
			for(int i=0; i < motsCle.length; i++){
				params.add(motsCle[i]);
				criteres.add(CRITERE_RECHERCHE.TEXTE);
			}
		}
		
		// Type de recette	
		if(sType != null){
			id = Long.parseLong(sType);
			params.add(id);
			criteres.add(CRITERE_RECHERCHE.TYPE);
		}
		
		// Dur�e maximale
		if(sDuree != null){			
			duree = Integer.parseInt(sDuree);
			params.add(duree);
			if(sDuree.equals(DUREE.CENT_VINGTS_PLUS.getValue())){
				criteres.add(CRITERE_RECHERCHE.DUREE_MIN);
			}
			else{
				criteres.add(CRITERE_RECHERCHE.DUREE_MAX);
			}			
		}
		
		// Cat�gories d'ingr�dients
		if(sCategories != null){
			for(int i=0; i < sCategories.length; i++){
				id = Integer.parseInt(sCategories[i]);
				params.add(id);
				criteres.add(CRITERE_RECHERCHE.CATEGORIE);
			}
		}
		
		// Construction de la requ�te
		String requete = DaoRecette.construireRequetteRecette(usager, criteres);
		
		System.out.println("================================\nREQUETE:\n" + requete + "\n======================================");
		
		DaoRecette dao = new DaoRecette();
		return dao.chercherRecette(requete, usager, params);
	}	

	/**
	 * M�thode pour r�cup�rer une recette par son id
	 * 
	 * @param id L'id de la recette
	 * @return La recette correspondante
	 */
	public static Recette getRecetteParId(long id){
		DaoRecette dao = new DaoRecette();
		return dao.chercherParId(id, Recette.class);
	}
	
	/**
	 * M�thode pour supprimer une recette par son id
	 * 
	 * @param id L'id de la recette � supprimer
	 */
	public static void supprimerRecette(long id){
		DaoRecette dao = new DaoRecette();
		dao.supprimer(Recette.class, id);
	}
	
	/**
	 * M�thode pour cr�er un panier de recettes
	 * 
	 * @return Le panier de recettes cr��
	 */
	public static PanierRecettes creerPanier(){
		return new PanierRecettes();
	}
	
	/**
	 * Methode pour creer la recette
	 * @param request la requete contenant les donnees
	 * @return Un objet recette rempli
	 */
	public static Recette creerRecette(HttpServletRequest request){
		
		//on cr�e un objet recette
		Recette recette = new Recette();
		
		//on verifie si c'est une nouvelle recette ou une modification de recette
		String idAModifier = request.getParameter("idRecetteAModifier");
		if(idAModifier != null && idAModifier != ""){
			Long id = Long.parseLong(idAModifier);
			recette.setIdRecette(id);
		}
		
		//on ajoute le nom, description et dur�e dans l'objet recette
		recette.setNomRecette(request.getParameter("nomRecette"));
		recette.setDescriptionRecette(request.getParameter("descRecette"));
		int heure = Integer.parseInt(request.getParameter("heureRecette"));
		int minute = Integer.parseInt(request.getParameter("minRecette"));
		recette.setDureeRecette(utils.Conversion.convertirTemps(heure, minute));
		
		//on ajoute le type de la recette dans la recette
		long idType = Long.parseLong(request.getParameter("typeRecette"));	
		TypesRecette type = Driver.getTypeRecette(idType);
		recette.setTypesRecette(type);
		
		//parcourir la liste des ingredients et ajouter le nom, quantit� et unit� de mesure dans la recette
		int i = 1;
		while(request.getParameter("nomIngredient" +i) != null){	

			//recuperer l'ingredient, la quantit�, l'unite de mesure et la categorie du formulaire
			String nomIngredient = request.getParameter("nomIngredient"+i);
			double qte = Double.parseDouble(request.getParameter("qte"+i));
			String unite = request.getParameter("unite"+i);
			String categorieIng = request.getParameter("categorie"+i);
			

			Unite unit = Driver.getUnite(Long.parseLong(unite));
			CategoriesIngredient categorie = Driver.getCategorie(Long.parseLong(categorieIng));
			
			Ingredient ing = new Ingredient();
			ing.setNomIngredient(nomIngredient);
			ing.setCategoriesIngredient(categorie);
			
			Mesure mesure = new Mesure();
			mesure.setQuantite(qte);
			mesure.setIngredient(ing);
			mesure.setUnite(unit);
			recette.addMesure(mesure);
			i++;
		}
		
		i=1;
		while(request.getParameter("instruction" + i) != null){
			Instruction instruction = new Instruction();
			instruction.setNumOrdre(i);
			instruction.setDescInstruction(request.getParameter("instruction" + i));
			recette.addInstruction(instruction);
			i++;
		}
		return recette;
	}
	
	public static ArrayList<String> creerListeEpicerie(HttpServletRequest request){
		ArrayList<String> listePourAffichage = new ArrayList<>();
		// R�cup�ration de la liste des ingr�dients modifi�es
		int i = 1;
		while(request.getParameter("nomIngredient"+i) != null){
			//recuperer nom, quantite et unite de l'ingredient
			String nomIngredient = request.getParameter("nomIngredient"+i);
			String qte = request.getParameter("qte"+i);
			String unite = request.getParameter("unite"+i);
			String result = nomIngredient + ": " + qte+unite;
			listePourAffichage.add(result);
			i++;
		}
		return listePourAffichage;
	}
}
