/**
 * SCript pour le AJAX de la page de recherche
 */

var req;
var isIE;

// Fonction pour initialiser la requête
function initRequest() {
    if (window.XMLHttpRequest) {
        if (navigator.userAgent.indexOf('MSIE') != -1) {
            isIE = true;
        }
        return new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        isIE = true;
        return new ActiveXObject("Microsoft.XMLHTTP");//IE 6 ou 7
    }
}

// Fonction pour lancer la recherche dynamique (AJAX)
function lancerRecherche() {

	// La destination
	var nbCriteres = 0;
    var url = "RechercheServlet?action=SEARCH";
    
    // Ajout des paramètres de recherche
    var idType = $("#typeRecherche :selected").val();
    if(idType != "-1"){
    	nbCriteres++;
    	url += "&type=" + idType;
    }
    
    var categories = [];
    $("#categoriesRecherche li input:checked").each(function(){
    	categories.push($(this).val())
    });
    for(var i=0; i < categories.length; i++){
    	nbCriteres++;
    	url += "&categories=" + categories[i];
    }
        
    var duree = $("#dureeRecherche :checked").val();
    if(duree != "NONE"){
    	nbCriteres++;
    	url += "&duree=" + duree;
    }
        
    if(nbCriteres != 0){
        // Initialisation de la requête
        req = initRequest();    
        req.open("GET", url, true);    
        req.onreadystatechange = afficherResultats;// Fonction pour utiliser les résultats    
        
        // Envoie
        req.send(null);
    }
}

// Fonction pour afficher les résultats de la recherche
function afficherResultats() {
    
	// On efface les anciens résultats
	listeResultats = $("#listeResultats").empty();

	// On affiche les nouveaux résultats
    if (req.readyState == 4) {
        if (req.status == 200) {           
            parseMessages(req.responseXML);            
        }
    }
}

// Fonction pour parcourir la réponse serveur
function parseMessages(responseXML) {
    
    // Aucun résultat
    if (responseXML == null) {
        return false;
    }
    else {

    	// On récupère la liste des recettes
        var recettes = responseXML.getElementsByTagName("recettes")[0];

        // On ajoute chaque recette dans la liste des résultats sur la page
        var listeResultats = document.getElementById("listeResultats");
        
        var recette; var id; var nom; var duree; var description;
        for (var i=0; i < recettes.childNodes.length; i++){
        	
        	// Récupération de la recette courante
        	recette = recettes.childNodes[i];
        	id = recette.getElementsByTagName("id")[0];
        	nom = recette.getElementsByTagName("nom")[0];
        	duree = recette.getElementsByTagName("duree")[0];
        	description = recette.getElementsByTagName("description")[0];
        	
        	// Ajout de la recette à la liste
        	ajouterRecette(id.childNodes[0].nodeValue,
        				   nom.childNodes[0].nodeValue,
        				   duree.childNodes[0].nodeValue,
        				   description.childNodes[0].nodeValue, listeResultats);
        }
    }
}

// Fonction pour ajouter une recette à la liste des résultats
function ajouterRecette(id, nom, duree, description, listeResultats) {

	// Création du div principal
	var div = document.createElement('div');
	div.setAttribute("class","list-group-item topBorder media");
	
	// Ajout du div secondaire
	var div2a = document.createElement('div');
	div2a.setAttribute("class","media-body");
	
	var h4 = document.createElement('h4');
	h4.setAttribute("class", "list-group-item-heading");	
	var lienRecette = document.createElement('a');
	lienRecette.setAttribute("href", "RecetteServlet?action=voirRecette&idRecette=" + id);
	lienRecette.innerHTML = nom;
	h4.appendChild(lienRecette);
	div2a.appendChild(h4);
	
	var h5 = document.createElement('h5');	
	var spanDuree = document.createElement('span');
	spanDuree.setAttribute("class", "label label-info");
	spanDuree.innerHTML = "Temps de préparation: " + duree;
	h5.appendChild(spanDuree);
	div2a.appendChild(h5);
	
	var pDescription = document.createElement('p');	
	pDescription.setAttribute("class", "list-group-item-text");
	pDescription.innerHTML = description;
	div2a.appendChild(pDescription);
	
	div.appendChild(div2a);
	
	// Ajout du div secondaire 2
	var div2b = document.createElement('div');
	div2b.setAttribute("class","media-right media-top");
	
	var h3 = document.createElement('h3');
	var h3label = document.createElement('label');
	h3label.setAttribute("class", "label label-success mouseIcon");
	h3label.setAttribute("id", id);
	h3label.innerHTML = "Choisir";	
	h3.appendChild(h3label);
	div2b.appendChild(h3);	
	
	div.appendChild(div2b);
	
	// Ajout du code dans la liste
	listeResultats.appendChild(div);
}