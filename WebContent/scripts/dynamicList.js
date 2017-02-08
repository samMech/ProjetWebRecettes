/* 
 * Script pour la gestion dynamique des listes
 * 
 * Fournit les fonctionnalités des icônes (+ / - / up / down)
 * tout en gardant l'ordre des éléments (numéros affichés et attributs 'name')
 * 
 * @author Marc-andré Malouin
 * @version 1.00 (7 février 2017)
 */

// Fonction pour ajuster les numéros d'un ingrédient
function ajusterNumerosIngredient(numero, li){
	nom = li.getAttribute('name').replace(/[0-9]+$/g, '');// On enlève l'ancien numéro	
	li.setAttribute('name', nom + numero);// On remplace par le bon numéro
	
	// On fait aussi les sous-élément pour les ingrédients
	$(li).find('div input, div select').each(function(){	
		nom = this.getAttribute('name').replace(/[0-9]+$/g, '');// On enlève l'ancien numéro	
		this.setAttribute('name', nom + numero);// On remplace par le bon numéro	
	});	
}

// Fonction pour ajuster les numéros d'une instruction
function ajusterNumerosInstruction(numero, li){
	// On change le numéro dans le nom.
	$(li).find('div textarea').each(function(){
		nom = this.getAttribute('name').replace(/[0-9]+$/g, '');// On enlève l'ancien numéro	
		this.setAttribute('name', nom + numero);// On remplace par le bon numéro					
	});
	
	// On change le numéro affiché
	$(li).find('div label').each(function(){
		this.innerHTML = "" + numero + "."	
	});
}

// Fonction pour ajuster les numéros d'ordre pour les ingrédients
function ajusterNumerosIngredients(listeIngredients){
	var nom;
	listeIngredients.find('li').each(function(i, li){
		ajusterNumerosIngredient(i+1, li);
	});	
}

// Fonction pour ajuster les numéros d'ordre pour les instructions
function ajusterNumerosInstructions(listeInstructions){
	var nom;
	listeInstructions.find('li').each(function(i, li){			
		ajusterNumerosInstruction(i+1, li);
	});	
}

// Fonction pour échanger 2 éléments consécutifs dans une liste
$.fn.swap = function(elem) {
    var elem = $(elem);
    var before = elem.prev();

    this.after(elem);
    before.after(this);
}

///////////////////////////////////////////////////////////////
// Fonctions pour ajouter un élément après l'élément courant //
///////////////////////////////////////////////////////////////

function ajouterIngredient(elem){
	// Récupération du 'li' courant
	var elementListe = $(elem).parent().parent();
	
	// Création du nouveau 'li'
	var newElementListe = elementListe.clone();
	
	// On vide les champs du nouvel élément
	$(newElementListe).find('input').each(function(){this.value = '';});
	$(newElementListe).find('select').each(function(){this.selectedIndex = 0});
	
	// Ajout du nouvel élément après l'élément courant
	newElementListe.insertAfter(elementListe);
	
	// On ajuste les numéros
	ajusterNumerosIngredients(elementListe.parent());
}

function ajouterInstruction(elem){
	// Récupération du 'li' courant
	var elementListe = $(elem).parent().parent();
	
	// Création du nouveau 'li'
	var newElementListe = elementListe.clone();
	
	// On vide le texte de l'instructions
	$(newElementListe).find('textarea').each(function(){this.value = '';});
		
	// Ajout du nouvel élément après l'élément courant
	newElementListe.insertAfter(elementListe);
	
	// On ajuste les numéros
	ajusterNumerosInstructions(elementListe.parent());
}

/////////////////////////////////////////////////
// Fonctions pour supprimer un élément courant //
/////////////////////////////////////////////////

function supprimerIngredient(elem){	
	// Récupération du 'li' courant et de la liste
	var elementListe = $(elem).parent().parent();
	var liste = elementListe.parent();
	
	//On supprime l'élément s'il n'est pas le seul de la liste
	if($(liste).find('li').length > 1){
		elementListe.remove	();
		ajusterNumerosIngredients(liste);
	}
}

function supprimerInstruction(elem){	
	// Récupération du 'li' courant et de la liste
	var elementListe = $(elem).parent().parent();
	var liste = elementListe.parent();
	
	//On supprime l'élément s'il n'est pas le seul de la liste
	if($(liste).find('li').length > 1){
		elementListe.remove	();
		ajusterNumerosInstructions(liste);
	}
}

////////////////////////////////////////////////////
// Fonctions pour monter un élément dans la liste //
////////////////////////////////////////////////////

function monterInstruction(elem){
	// Récupération du 'li' courant et de sa position dans la liste
	var elementListe = $(elem).parent().parent();
	var index = $(elementListe).index();

	// On monte l'élément s'il n'est pas le premier
	if(index > 0){
		// On récupère l'élément précédent
		var elementPrecedent = elementListe.prev();
				
		// On ajuste les numéros (valeur après l'échange)
		ajusterNumerosInstruction(index, elementListe);
		ajusterNumerosInstruction(index+1, elementPrecedent);
		
		// On fait l'échange
		elementListe.swap(elementPrecedent);		
	}
}

///////////////////////////////////////////////////////
// Fonctions pour descendre un élément dans la liste //
///////////////////////////////////////////////////////

function descendreInstruction(elem){
	// Récupération du 'li' courant et de sa position dans la liste
	var elementListe = $(elem).parent().parent();
	var index = $(elementListe).index();
	
	// On descend l'élément s'il n'est pas le dernier
	if(index+1 < elementListe.parent().find('li').length){	
		// On récupère l'élément suivant	
		var elementSuivant = elementListe.next();
				
		// On ajuste les numéros (valeur après l'échange)
		ajusterNumerosInstruction(index+2, elementListe);
		ajusterNumerosInstruction(index+1, elementSuivant);
		
		// On fait l'échange
		elementSuivant.swap(elementListe);		
	}
}